#HeadlessForge
While headless Minecraft Clients aren't anything new, they come with a drawback.
The Minecraft API is missing and you need to add all functionality yourself. 
That means getting mods like Baritone which are tightly coupled with mojangs 
code to run is a pain. HeadlessForge takes the other way around to create a 
Minecraft Console Client: It removes all functionality which prevents you from 
running Minecraft on the console (lwjgl) from Minecraft and adds a command 
interface.

HeadlessForge is written in kotlin, the [Mixins](https://github.com/SpongePowered/Mixin) in java. It's currently 
targetting version 1.12.2 of Minecraft.

## Commands
Start a command with `.` to send a chat message while ingame. Use `./` or just 
`/` to use Minecraft commands. Anything else will try to execute one 
of the following commands:

-`quit` to quit Minecraft.

-`help` to get help with HeadlessForge commands.

-`gui` to output the currently opened gui. This will give you ids to use with:

-`click <id>` allows you to click a GuiButton.

-`text <id> <text>` allows you set the text of a Textfield.

-`connect <ip>` connect to a server.

-`disconnect` disconnect if you are connected to a server.

-`ram` outputs info about the current memory usage.

-`session` output info about the current Minecraft Session.

-`tictactoe` well...

## Usage
Java 8 and MinecraftForge-1.12.2-14.23.5.2854 are required. Drag the 
HeadlessForge jar into the mods folder in the .minecraft folder. Then enter
`java -jar <headlessforge.jar name> <Path to .minecraft folder>` on the console.
On windows the path should look like this: `C:\Users\<user>\AppData\Roaming\.minecraft`. 

Of course HeadlessForge doesn't support entering account credentials outside 
the official Minecraft Launcher, so you won't be able to [play](https://github.com/The-Fireplace-Minecraft-Mods/In-Game-Account-Switcher).
When launching HeadlessForge from the commandline you can also specify the 
folder containing the lwjgl64 binaries. I wouldn't recommend running this with 
any paid applications that don't like to get cracked, because a different
method will be at the top of the stacktrace. HeadlessForge 
is a work in progress and there's probably lwjgl context that I missed, 
so expect crashes. It's also stable enough for my purposes so don't
expect too much support.

## License
This project is licensed under the [MIT license](LICENSE).