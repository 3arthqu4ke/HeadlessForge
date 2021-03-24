package me.earth.headlessforge.asm.patches

import me.earth.headlessforge.api.patch.AbstractPatch
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.client.renderer.RenderGlobal
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode

/**
 * Patches the Ctr of [RenderGlobal].
 * Insert a Return Instruction after all fields
 * have been initialized and before the
 * [GlStateManager] is called.
 */
open class RenderGlobalPatch : AbstractPatch("buy", "net.minecraft.client.renderer.RenderGlobal") {
    override fun patch(classNode: ClassNode) {
        for (methodNode in classNode.methods.filter { f -> f.name.equals("<init>") }) {
            for (insn in methodNode.instructions) {
                if (insn is IntInsnNode && insn.operand == 3553) {
                    methodNode.instructions.insertBefore(insn, InsnNode(Opcodes.RETURN))
                    break
                }
            }
        }
    }
}