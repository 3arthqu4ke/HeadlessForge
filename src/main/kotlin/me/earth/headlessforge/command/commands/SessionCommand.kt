package me.earth.headlessforge.command.commands

import me.earth.headlessforge.Globals.MC
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.command.AbstractCommand
import net.minecraft.util.Session

class SessionCommand: AbstractCommand(arrayOf(arrayOf("session"))) {
    override fun execute(args: Array<String>, raw: String) {
        val session: Session? = MC.session
        if (session == null) {
            LOGGER.info("No Session detected.")
        } else {
            LOGGER.info("Session: " + session.username + " : " + session.profile.id)
        }
    }

    override fun getDescription(): String {
        return "Outputs info about your current Minecraft Session."
    }

}