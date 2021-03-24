package me.earth.headlessforge.api.console

import net.minecraft.client.Minecraft

/** An interface representing a console. */
interface IConsole {
    /** Attaches the console to the given Minecraft Object. */
    fun attach(mc: Minecraft)

}