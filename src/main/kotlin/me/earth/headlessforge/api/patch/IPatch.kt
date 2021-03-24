package me.earth.headlessforge.api.patch

import org.objectweb.asm.tree.ClassNode

/** Represents a ClassPatch. */
interface IPatch {
    /**
     * Applies this patch to the given classNode.
     * The patch should only be applied if the given hooks arg was true.
     */
    fun apply(classNode: ClassNode, hooks: Boolean)

    /** @return true if this Patch is supposed to patch a class with the given name and transformed name. */
    fun matches(name: String, transformed: String): Boolean

    /** @return true if this Patch has been applied and should not patch any other classes. */
    fun isDone(): Boolean

}