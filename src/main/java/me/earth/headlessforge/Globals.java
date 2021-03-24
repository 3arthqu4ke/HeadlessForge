package me.earth.headlessforge;

import me.earth.headlessforge.api.command.ICommandManager;
import me.earth.headlessforge.api.console.IConsole;
import me.earth.headlessforge.api.gui.IGuiManager;
import me.earth.headlessforge.api.gui.IKeyBind;
import me.earth.headlessforge.command.CommandManager;
import me.earth.headlessforge.gui.GuiManager;
import me.earth.headlessforge.gui.KeyBindProvider;
import me.earth.headlessforge.launch.ConsoleSimple;
import net.minecraft.client.Minecraft;

import java.util.Objects;

/**
 * Global Values for HeadlessForge. Will throw an Exception
 * if this Class is loaded in a Context where
 * {@link Minecraft#getMinecraft()} returns <tt>null</tt>.
 */
public interface Globals
{
    /** The Minecraft Instance. */
    Minecraft MC = Objects.requireNonNull(Minecraft.getMinecraft());
    /** An Instance of the CommandManager. */
    ICommandManager COMMAND = new CommandManager();
    /** An Instance of the Console. */
    IConsole CONSOLE = new ConsoleSimple();
    /** An Instance of the GuiManager. */
    IGuiManager GUI = new GuiManager();
    /** Instance of the KeyBindProvider. */
    IKeyBind KEYBINDS = new KeyBindProvider();

}
