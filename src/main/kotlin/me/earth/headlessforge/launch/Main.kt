package me.earth.headlessforge.launch

import net.minecraft.launchwrapper.Launch
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Paths

class Main {
    companion object {
        private val classPath = arrayOf( // TODO: read .json instead?
            "/libraries/net/minecraftforge/forge/1.12.2-14.23.5.2854/forge-1.12.2-14.23.5.2854.jar",
            "/libraries/org/ow2/asm/asm-debug-all/5.2/asm-debug-all-5.2.jar",
            "/libraries/net/minecraft/launchwrapper/1.12/launchwrapper-1.12.jar",
            "/libraries/org/jline/jline/3.5.1/jline-3.5.1.jar",
            "/libraries/com/typesafe/akka/akka-actor_2.11/2.3.3/akka-actor_2.11-2.3.3.jar",
            "/libraries/com/typesafe/config/1.2.1/config-1.2.1.jar",
            "/libraries/org/scala-lang/scala-actors-migration_2.11/1.1.0/scala-actors-migration_2.11-1.1.0.jar",
            "/libraries/org/scala-lang/scala-compiler/2.11.1/scala-compiler-2.11.1.jar",
            "/libraries/org/scala-lang/plugins/scala-continuations-library_2.11/1.0.2_mc/scala-continuations-library_2.11-1.0.2_mc.jar",
            "/libraries/org/scala-lang/plugins/scala-continuations-plugin_2.11.1/1.0.2_mc/scala-continuations-plugin_2.11.1-1.0.2_mc.jar",
            "/libraries/org/scala-lang/scala-library/2.11.1/scala-library-2.11.1.jar",
            "/libraries/org/scala-lang/scala-parser-combinators_2.11/1.0.1/scala-parser-combinators_2.11-1.0.1.jar",
            "/libraries/org/scala-lang/scala-reflect/2.11.1/scala-reflect-2.11.1.jar",
            "/libraries/org/scala-lang/scala-swing_2.11/1.0.1/scala-swing_2.11-1.0.1.jar",
            "/libraries/org/scala-lang/scala-xml_2.11/1.0.2/scala-xml_2.11-1.0.2.jar",
            "/libraries/lzma/lzma/0.0.1/lzma-0.0.1.jar",
            "/libraries/java3d/vecmath/1.5.2/vecmath-1.5.2.jar",
            "/libraries/net/sf/trove4j/trove4j/3.0.3/trove4j-3.0.3.jar",
            "/libraries/org/apache/maven/maven-artifact/3.5.3/maven-artifact-3.5.3.jar",
            "/libraries/net/sf/jopt-simple/jopt-simple/5.0.3/jopt-simple-5.0.3.jar",
            "/libraries/com/mojang/patchy/1.1/patchy-1.1.jar",
            "/libraries/oshi-project/oshi-core/1.1/oshi-core-1.1.jar",
            "/libraries/net/java/dev/jna/jna/4.4.0/jna-4.4.0.jar",
            "/libraries/net/java/dev/jna/platform/3.4.0/platform-3.4.0.jar",
            "/libraries/com/ibm/icu/icu4j-core-mojang/51.2/icu4j-core-mojang-51.2.jar",
            "/libraries/net/sf/jopt-simple/jopt-simple/5.0.3/jopt-simple-5.0.3.jar",
            "/libraries/com/paulscode/codecjorbis/20101023/codecjorbis-20101023.jar",
            "/libraries/com/paulscode/codecwav/20101023/codecwav-20101023.jar",
            "/libraries/com/paulscode/libraryjavasound/20101123/libraryjavasound-20101123.jar",
            "/libraries/com/paulscode/librarylwjglopenal/20100824/librarylwjglopenal-20100824.jar",
            "/libraries/com/paulscode/soundsystem/20120107/soundsystem-20120107.jar",
            "/libraries/io/netty/netty-all/4.1.9.Final/netty-all-4.1.9.Final.jar",
            "/libraries/com/google/guava/guava/21.0/guava-21.0.jar",
            "/libraries/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar",
            "/libraries/commons-io/commons-io/2.5/commons-io-2.5.jar",
            "/libraries/commons-codec/commons-codec/1.10/commons-codec-1.10.jar",
            "/libraries/net/java/jinput/jinput/2.0.5/jinput-2.0.5.jar",
            "/libraries/net/java/jutils/jutils/1.0.0/jutils-1.0.0.jar",
            "/libraries/com/google/code/gson/gson/2.8.0/gson-2.8.0.jar",
            "/libraries/com/mojang/authlib/1.5.25/authlib-1.5.25.jar",
            "/libraries/com/mojang/realms/1.10.22/realms-1.10.22.jar",
            "/libraries/org/apache/commons/commons-compress/1.8.1/commons-compress-1.8.1.jar",
            "/libraries/org/apache/httpcomponents/httpclient/4.3.3/httpclient-4.3.3.jar",
            "/libraries/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar",
            "/libraries/org/apache/httpcomponents/httpcore/4.3.2/httpcore-4.3.2.jar",
            "/libraries/it/unimi/dsi/fastutil/7.1.0/fastutil-7.1.0.jar",
            "/libraries/org/apache/logging/log4j/log4j-api/2.8.1/log4j-api-2.8.1.jar",
            "/libraries/org/apache/logging/log4j/log4j-core/2.8.1/log4j-core-2.8.1.jar",
            "/libraries/org/lwjgl/lwjgl/lwjgl/2.9.4-nightly-20150209/lwjgl-2.9.4-nightly-20150209.jar",
            "/libraries/org/lwjgl/lwjgl/lwjgl_util/2.9.4-nightly-20150209/lwjgl_util-2.9.4-nightly-20150209.jar",
            "/libraries/com/mojang/text2speech/1.10.3/text2speech-1.10.3.jar",
            "/versions/1.12.2-forge-14.23.5.2854/1.12.2-forge-14.23.5.2854.jar"
        )

        @JvmStatic
        fun main(args: Array<String>) {
            if (args.isEmpty()) {
                println("Empty Arguments, please specify the path to the .minecraft folder!")
                return
            }

            println("Starting HeadlessForge with Arguments: " + args.contentToString())
            // TODO: Using Reflection to access this really bad and its patched after jdk8...
            val addURL = URLClassLoader::class.java.getDeclaredMethod("addURL", URL::class.java)
            addURL.isAccessible = true

            for (path in classPath) {
                addURL.invoke(Main::class.java.classLoader, Paths.get(args[0] + path).toUri().toURL())
            }

            if (args.size > 1) {
                // TODO: Either find out how minecraft creates the random folder containing lwjgl binaries
                //  or find literally every occurrence of lwjgl and cancel it.
                println("LWJGL detected, setting library path...")
                System.setProperty("org.lwjgl.librarypath", args[1])
            }

            val mcArgs = ArrayList<String>()
            mcArgs.add("--userProperties")
            mcArgs.add("{}")
            // mcArgs.add("--username")
            // mcArgs.add(<username>)
            mcArgs.add("--version")
            mcArgs.add("1.12.2-forge-14.23.5.2854")
            mcArgs.add("--gameDir")
            mcArgs.add(args[0])
            mcArgs.add("--assetsDir")
            mcArgs.add(args[0] + "/assets")
            mcArgs.add("--accessToken") //
            mcArgs.add("{REDACTED}")
            mcArgs.add("--assetIndex")
            mcArgs.add("1.12")
            // mcArgs.add("--uuid")
            // mcArgs.add(<uuid>)
            // mcArgs.add("--userType")
            // mcArgs.add("mojang")
            mcArgs.add("--tweakClass")
            mcArgs.add("net.minecraftforge.fml.common.launcher.FMLTweaker")
            mcArgs.add("--versionType")
            mcArgs.add("Forge")

            println("Starting Launchwrapper...")
            Launch.main(mcArgs.toTypedArray())
        }
    }
}