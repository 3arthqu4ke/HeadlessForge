package me.earth.headlessforge.asm

import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.patch.IPatch
import me.earth.headlessforge.api.patch.IPatchManager
import me.earth.headlessforge.inject.Hooks
import me.earth.headlessforge.util.NoSuperClassWriter
import org.objectweb.asm.ClassReader
import org.objectweb.asm.tree.ClassNode

/**
 * Some things, like injecting Return Instructions into Constructors aren't
 * possible with Mixin. For that purpose an ASM PatchSystem exists as well.
 */
open class PatchManager: IPatchManager {
    private val patches = ArrayList<IPatch>()

    override fun patch(name: String, transformed: String, bytes: ByteArray): ByteArray {
        val foundPatches = patches.filter { p -> p.matches(name, transformed) }
        if (foundPatches.isNotEmpty()) {
            LOGGER.info("Transforming " + name + " : " + transformed + ", " + foundPatches.size + " patch(es) found.")
            val node = ClassNode()
            val reader = ClassReader(bytes)
            reader.accept(node, 0)
            foundPatches.forEach { p -> p.apply(node, Hooks.active()) }
            patches.removeIf { p -> p.isDone() }
            val writer = NoSuperClassWriter()
            node.accept(writer)
            LOGGER.info("Class patched, returning transformed bytes... ($name)")
            return writer.toByteArray()
        }

        return bytes
    }

    override fun add(patch: IPatch) {
        patches.add(patch)
    }

}