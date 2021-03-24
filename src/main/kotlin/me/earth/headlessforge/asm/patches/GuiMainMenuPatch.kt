package me.earth.headlessforge.asm.patches

import me.earth.headlessforge.api.patch.AbstractPatch
import net.minecraft.client.gui.GuiMainMenu
import org.lwjgl.opengl.GLContext
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.MethodInsnNode

/**
 * Patches the Ctr of the [GuiMainMenu].
 * Adds a return Instruction at the end right
 * before [GLContext] is called.
 */
open class GuiMainMenuPatch : AbstractPatch("blp", "net.minecraft.client.gui.GuiMainMenu") {
    override fun patch(classNode: ClassNode) {
        for (methodNode in classNode.methods.filter { f -> f.name.equals("<init>") }) {
            for (insn in methodNode.instructions) {
                if (insn is MethodInsnNode
                    && insn.opcode == Opcodes.INVOKESTATIC
                    && insn.name.equals("getCapabilities")) {
                    methodNode.instructions.insertBefore(insn, InsnNode(Opcodes.RETURN))
                    break
                }
            }
        }
    }

}