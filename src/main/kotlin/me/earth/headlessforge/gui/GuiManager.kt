package me.earth.headlessforge.gui

import me.earth.headlessforge.Globals.COMMAND
import me.earth.headlessforge.HeadlessForge.Companion.LOGGER
import me.earth.headlessforge.api.gui.IGuiManager
import me.earth.headlessforge.command.process.YesNoProcess
import me.earth.headlessforge.inject.ducks.IGuiMessage
import me.earth.headlessforge.inject.ducks.IGuiScreen
import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.gui.GuiTextField

open class GuiManager: IGuiManager {
    override fun dumpButtons(gui: IGuiScreen) {
        val builder = StringBuilder("\n\nGuiScreen: ").append(gui.javaClass.simpleName)
        if (gui is IGuiMessage && gui.getMessage() != null) { builder.append("\n").append(gui.getMessage()) }
        builder.append("\nButtons:")
        gui.getButtons()?.forEach { button ->
            builder.append("\nID: ").append(button.id)
                   .append(", Name: ").append(button.displayString)
                   .append(", Enabled: ").append(button.enabled)
                   .append(", x:").append(button.x)
                   .append(", y:").append(button.y)
                   .append(", w: ").append(button.width)
                   .append(", h:").append(button.height)
                   .append(", Type: ").append(button.javaClass.simpleName)
        }

        builder.append("\n")
        var id = 0
        var clazz: Class<*>? = gui::class.java
        while (clazz != null) {
            for (field in clazz.declaredFields) {
                if (GuiTextField::class.java.isAssignableFrom(field.type)) {
                    try {
                        field.isAccessible = true
                        val textField: GuiTextField = field.get(gui) as GuiTextField
                        builder.append("\nTextField: " + (id++) + ", Text: \"" + textField.text + "\"")
                    } catch (e: Exception) {
                        builder.append("TextField: " + (id++) + ", " + e.message)
                    }
                }
            }
            clazz = clazz.superclass
        }


        LOGGER.info(builder.append("\n").toString())
    }

    override fun clickButton(gui: IGuiScreen, id: Int, mouseButton: Int): String {
        for (button in gui.getButtons()!!) {
            if (button.id == id) {
                return if (!button.enabled) {
                    "Button $id is currently not enabled!"
                } else if (!button.visible) {
                    "Button $id is currently not visible!"
                } else {
                    try {
                        gui.invokeMouseClick(button.x, button.y, mouseButton)
                    } catch (t: Throwable) {
                        t.printStackTrace()
                        return "An error occurred when pressing button $id: " + t.message
                    }
                    "Button $id clicked."
                }
            }
        }
        return "No button found for $id."
    }

    override fun setTextField(gui: GuiScreen, fieldID: Int, text: String) {
        var id = 0
        var clazz: Class<*>? = gui::class.java
        while (clazz != null) {
            for (field in clazz.declaredFields) {
                if (GuiTextField::class.java.isAssignableFrom(field.type)) {
                    if (id++ == fieldID) {
                        try {
                            field.isAccessible = true
                            val textField: GuiTextField = field.get(gui) as GuiTextField
                            LOGGER.info("Y/N? Change TextField: $id, text: \"" + textField.text + "\" to \"$text\"?")
                            COMMAND.addCallback(object: YesNoProcess() {
                                override fun onYes() {
                                    textField.text = text
                                    LOGGER.info("Set text to \"$text\".")
                                }
                            })
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                        return
                    }
                }
            }
            clazz = clazz.superclass
        }
        LOGGER.info("Couldn't find TextField with id $id.")
    }

}