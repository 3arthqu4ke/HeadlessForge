package me.earth.headlessforge.api.patch

import org.objectweb.asm.tree.ClassNode

@Suppress("MemberVisibilityCanBePrivate")
abstract class AbstractPatch(val name: String, val transformed: String): IPatch {
    var patched = false;

    override fun apply(classNode: ClassNode, hooks: Boolean) {
        if (hooks) {
            patch(classNode)
        }
        patched = true;
    }

    protected abstract fun patch(classNode: ClassNode)

    override fun matches(name: String, transformed: String): Boolean {
        return this.transformed == transformed
    }

    override fun isDone(): Boolean {
        return patched
    }

}