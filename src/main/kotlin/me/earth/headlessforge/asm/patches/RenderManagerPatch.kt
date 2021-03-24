package me.earth.headlessforge.asm.patches

import me.earth.headlessforge.api.patch.AbstractPatch
import net.minecraft.client.renderer.entity.RenderManager
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldInsnNode
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.VarInsnNode

/**
 * Patches the Ctr of the [RenderManager].
 * Inserts a Return Instruction right after
 * all fields have been initialized. That way
 * nothing is added to the EntityRenderMap.
 */
open class RenderManagerPatch : AbstractPatch("bzf", "net.minecraft.client.renderer.entity.RenderManager") {
    override fun patch(classNode: ClassNode) {
        for (methodNode in classNode.methods.filter { f -> f.name.equals("<init>") }) {
            for (insn in methodNode.instructions) {
                if (insn is VarInsnNode
                    && insn.opcode == Opcodes.ALOAD
                    && insn.`var` == 0
                    && insn.next is FieldInsnNode
                    && insn.next.opcode == Opcodes.GETFIELD
                    && (insn.next as FieldInsnNode).desc.equals("Ljava/util/Map;")) {
                    methodNode.instructions.insertBefore(insn, InsnNode(Opcodes.RETURN))
                }
            }
        }
    }
}