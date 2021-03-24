package me.earth.headlessforge.inject.replace

import net.minecraft.block.state.IBlockState
import net.minecraft.client.Minecraft
import net.minecraft.client.multiplayer.WorldClient
import net.minecraft.client.renderer.BufferBuilder
import net.minecraft.client.renderer.RenderGlobal
import net.minecraft.client.renderer.Tessellator
import net.minecraft.client.renderer.culling.ICamera
import net.minecraft.client.resources.IResourceManager
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.SoundCategory
import net.minecraft.util.SoundEvent
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.RayTraceResult
import net.minecraft.world.World

/**
 * A RenderGlobal that does nothing,
 * replaces Minecrafts RenderGlobal.
 */
open class EmptyRenderGlobal(mcIn: Minecraft) : RenderGlobal(mcIn) {
    override fun onResourceManagerReload(resourceManager: IResourceManager?) { }

    override fun makeEntityOutlineShader() { }

    override fun renderEntityOutlineFramebuffer() { }

    override fun isRenderEntityOutlines(): Boolean { return false }

    override fun setWorldAndLoadRenderers(worldClientIn: WorldClient?) { }

    override fun loadRenderers() { }

    override fun stopChunkUpdates() { }

    override fun createBindEntityOutlineFbs(width: Int, height: Int) { }

    override fun renderEntities(renderViewEntity: Entity, camera: ICamera, partialTicks: Float) { }

    override fun getDebugInfoRenders(): String { return "EmptyRenderGlobal-DebugInfo" }

    override fun getRenderedChunks(): Int { return 0 }

    override fun setupTerrain(
        viewEntity: Entity,
        partialTicks: Double,
        camera: ICamera,
        frameCount: Int,
        playerSpectator: Boolean
    ) { }

    override fun renderBlockLayer(
        blockLayerIn: BlockRenderLayer,
        partialTicks: Double,
        pass: Int,
        entityIn: Entity
    ): Int {
        return 0
    }

    override fun updateClouds() { }

    override fun renderSky(partialTicks: Float, pass: Int) { }

    override fun renderClouds(partialTicks: Float, pass: Int, x: Double, y: Double, z: Double) { }

    override fun hasCloudFog(x: Double, y: Double, z: Double, partialTicks: Float): Boolean { return false }

    override fun updateChunks(finishTimeNano: Long) { }

    override fun renderWorldBorder(entityIn: Entity, partialTicks: Float) { }

    override fun drawBlockDamageTexture(
        tessellatorIn: Tessellator,
        bufferBuilderIn: BufferBuilder,
        entityIn: Entity,
        partialTicks: Float
    ) { }

    override fun drawSelectionBox(
        player: EntityPlayer,
        movingObjectPositionIn: RayTraceResult,
        execute: Int,
        partialTicks: Float
    ) { }

    override fun notifyBlockUpdate(worldIn: World?, pos: BlockPos, oldState: IBlockState?, newState: IBlockState?,
    flags: Int) { }

    override fun notifyLightSet(pos: BlockPos) { }

    override fun markBlockRangeForRenderUpdate(x1: Int, y1: Int, z1: Int, x2: Int, y2: Int, z2: Int) { }

    override fun playRecord(soundIn: SoundEvent?, pos: BlockPos) { }

    override fun playSoundToAllNearExcept(
        player: EntityPlayer?,
        soundIn: SoundEvent?,
        category: SoundCategory?,
        x: Double,
        y: Double,
        z: Double,
        volume: Float,
        pitch: Float
    ) { }

    override fun spawnParticle(
        particleID: Int,
        ignoreRange: Boolean,
        xCoord: Double,
        yCoord: Double,
        zCoord: Double,
        xSpeed: Double,
        ySpeed: Double,
        zSpeed: Double,
        vararg parameters: Int
    ) { }

    override fun spawnParticle(
        id: Int,
        ignoreRange: Boolean,
        minimiseParticleLevel: Boolean,
        x: Double,
        y: Double,
        z: Double,
        xSpeed: Double,
        ySpeed: Double,
        zSpeed: Double,
        vararg parameters: Int
    ) { }

    override fun onEntityAdded(entityIn: Entity?) {}

    override fun onEntityRemoved(entityIn: Entity?) {}

    override fun deleteAllDisplayLists() {}

    override fun broadcastSound(soundID: Int, pos: BlockPos, data: Int) { }

    override fun playEvent(player: EntityPlayer?, type: Int, blockPosIn: BlockPos, data: Int) { }

    override fun sendBlockBreakProgress(breakerId: Int, pos: BlockPos, progress: Int) { }

    override fun hasNoChunkUpdates(): Boolean { return true }
}