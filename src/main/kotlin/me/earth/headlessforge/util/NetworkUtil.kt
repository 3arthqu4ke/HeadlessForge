package me.earth.headlessforge.util

import me.earth.headlessforge.Globals.MC
import net.minecraft.client.gui.GuiMainMenu
import net.minecraft.client.gui.GuiMultiplayer
import net.minecraft.client.multiplayer.GuiConnecting
import net.minecraft.client.multiplayer.ServerData
import net.minecraft.client.resources.I18n
import net.minecraft.util.text.TextComponentString

/** Util for connecting and disconnecting from Minecraft servers. */
object NetworkUtil {
    /** Disconnects if we are currently connected to a server and displays the given Message. */
    fun disconnect(message: String) {
        MC.connection?.networkManager?.closeChannel(TextComponentString(message))
    }

    /** Connects to the given IP. */
    fun connect(ip: String) {
        MC.displayGuiScreen(GuiConnecting(GuiMultiplayer(GuiMainMenu()),
                                          MC,
                                          ServerData(I18n.format("selectServer.defaultName"),
                                          ip,
                                          false)))
    }

}