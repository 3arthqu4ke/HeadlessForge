package me.earth.headlessforge

import me.earth.headlessforge.asm.HeadlessForgeTransformer
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.spongepowered.asm.launch.MixinBootstrap
import org.spongepowered.asm.mixin.MixinEnvironment
import org.spongepowered.asm.mixin.Mixins

@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE)
@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.Name("HeadlessForge")
class HeadlessForge : IFMLLoadingPlugin {
    companion object {
        @JvmField
        var LOGGER: Logger = LogManager.getLogger("HeadlessForge")
    }

    init {
        MixinBootstrap.init()
        Mixins.addConfiguration("mixins.headlessforge.json")
        MixinEnvironment.getDefaultEnvironment().obfuscationContext = "searge"
    }

    override fun getASMTransformerClass(): Array<String> {
        return arrayOf(HeadlessForgeTransformer::class.java.name)
    }

    override fun getModContainerClass(): String? {
        return null
    }

    override fun getSetupClass(): String? {
        return null
    }

    override fun injectData(data: MutableMap<String, Any>?) {
        /* data!!["runtimeDeobfuscationEnabled"] as Boolean */
    }

    override fun getAccessTransformerClass(): String? {
        return null
    }
}