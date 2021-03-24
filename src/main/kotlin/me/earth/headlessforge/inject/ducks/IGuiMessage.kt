package me.earth.headlessforge.inject.ducks

import net.minecraft.client.gui.GuiDisconnected

/**
 * Duck interface for Guis that display a message.
 * Currently only [GuiDisconnected].
 */
interface IGuiMessage {
    /** @return the message displayed by the gui. */
    fun getMessage(): String?

}