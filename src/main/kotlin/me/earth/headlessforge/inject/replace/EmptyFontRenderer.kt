package me.earth.headlessforge.inject.replace

import net.minecraft.client.gui.FontRenderer
import net.minecraft.client.renderer.texture.TextureManager
import net.minecraft.client.resources.IResourceManager
import net.minecraft.client.settings.GameSettings
import net.minecraft.util.ResourceLocation

/**
 * A FontRenderer that does nothing,
 * replaces Minecrafts FontRenderer.
 */
open class EmptyFontRenderer(
    gameSettingsIn: GameSettings,
    location: ResourceLocation,
    textureManagerIn: TextureManager,
    unicode: Boolean
) : FontRenderer(gameSettingsIn, location, textureManagerIn, unicode) {
    override fun onResourceManagerReload(resourceManager: IResourceManager?) { }

    override fun renderDefaultChar(ch: Int, italic: Boolean): Float { return 0F }

    override fun renderUnicodeChar(ch: Char, italic: Boolean): Float { return 0F }

    override fun drawStringWithShadow(text: String?, x: Float, y: Float, color: Int): Int { return 0 }

    override fun drawString(text: String?, x: Int, y: Int, color: Int): Int { return 0 }

    override fun drawString(text: String?, x: Float, y: Float, color: Int, dropShadow: Boolean): Int { return 0 }

    override fun doDraw(f: Float) { }

    override fun getStringWidth(text: String?): Int { return 0 }

    override fun getCharWidth(character: Char): Int { return 0 }

    override fun trimStringToWidth(text: String, width: Int): String { return text }

    override fun trimStringToWidth(text: String, width: Int, reverse: Boolean): String { return text }

    override fun drawSplitString(str: String?, x: Int, y: Int, wrapWidth: Int, textColor: Int) { }

    override fun getWordWrappedHeight(str: String?, maxLength: Int): Int { return 0 }

    override fun setColor(r: Float, g: Float, b: Float, a: Float) { }

    override fun enableAlpha() { }

    override fun bindTexture(location: ResourceLocation?) { }

    override fun getColorCode(character: Char): Int { return -1 }
}