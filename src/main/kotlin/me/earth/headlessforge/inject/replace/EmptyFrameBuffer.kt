package me.earth.headlessforge.inject.replace

import net.minecraft.client.shader.Framebuffer

/**
 * A FrameBuffer that does nothing,
 * replaces Minecrafts FrameBuffer.
 */
open class EmptyFrameBuffer(width: Int, height: Int, useDepthIn: Boolean) : Framebuffer(width, height, useDepthIn) {
    override fun createBindFramebuffer(width: Int, height: Int) { }

    override fun deleteFramebuffer() { }

    override fun createFramebuffer(width: Int, height: Int) { }

    override fun setFramebufferFilter(framebufferFilterIn: Int) { }

    override fun checkFramebufferComplete() { }

    override fun bindFramebufferTexture() { }

    override fun unbindFramebufferTexture() { }

    override fun bindFramebuffer(p_147610_1_: Boolean) { }

    override fun unbindFramebuffer() { }

    override fun setFramebufferColor(red: Float, green: Float, blue: Float, alpha: Float) { }

    override fun framebufferRender(width: Int, height: Int) { }

    override fun framebufferRenderExt(width: Int, height: Int, p_178038_3_: Boolean) { }

    override fun framebufferClear() { }

    /*----Forge-----*/
    private var stencilEnabled = false

    override fun enableStencil(): Boolean { return false }

    override fun isStencilEnabled(): Boolean { return this.stencilEnabled }
}