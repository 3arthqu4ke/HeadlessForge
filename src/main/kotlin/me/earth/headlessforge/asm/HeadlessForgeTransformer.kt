package me.earth.headlessforge.asm

import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.asm.patches.GuiMainMenuPatch
import me.earth.headlessforge.asm.patches.RenderGlobalPatch
import me.earth.headlessforge.asm.patches.RenderManagerPatch
import me.earth.headlessforge.inject.Hooks
import net.minecraft.launchwrapper.IClassTransformer
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin
import org.spongepowered.asm.mixin.MixinEnvironment

/**
 * HeadlessForges ClassTransformer to assist with stuff
 * that Mixin can't do. See [PatchManager].
 */
@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE)
@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.Name("HeadlessForge")
class HeadlessForgeTransformer: IClassTransformer {
    private val patchManager = PatchManager()
    private var reentrancy = 0
    init {
        if (Hooks.active()) {
            patchManager.add(GuiMainMenuPatch())
            patchManager.add(RenderGlobalPatch())
            patchManager.add(RenderManagerPatch())
        }

        MixinEnvironment.getEnvironment(MixinEnvironment.Phase.DEFAULT).addTransformerExclusion(this.javaClass.name)
        MixinEnvironment.getEnvironment(MixinEnvironment.Phase.PREINIT).addTransformerExclusion(this.javaClass.name)
        MixinEnvironment.getEnvironment(MixinEnvironment.Phase.INIT)   .addTransformerExclusion(this.javaClass.name)
        MixinEnvironment.getEnvironment(MixinEnvironment.Phase.DEFAULT).addTransformerExclusion(this.javaClass.name)
    }

    override fun transform(name: String?, transformedName: String?, bytes: ByteArray?): ByteArray? {
        if (name == null || transformedName == null || bytes == null || !Hooks.active()) {
            return bytes
        }

        reentrancy++
        if (reentrancy > 1) {
            LOGGER.warn("Transformer is reentrant on class: $name : $transformedName.")
        }

        val patched = patchManager.patch(name, transformedName, bytes)

        reentrancy--
        return patched
    }

}