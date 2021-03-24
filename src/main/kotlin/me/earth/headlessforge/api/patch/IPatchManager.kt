package me.earth.headlessforge.api.patch

/** Manages [IPatch]es. */
interface IPatchManager {
    /** Attempts to find [IPatch]es for the given class and applies them. */
    fun patch(name: String, transformed: String, bytes: ByteArray): ByteArray

    /** Adds a patch. */
    fun add(patch: IPatch)

}