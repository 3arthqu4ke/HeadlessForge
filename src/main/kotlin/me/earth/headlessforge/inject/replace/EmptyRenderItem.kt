package me.earth.headlessforge.inject.replace

import net.minecraft.block.Block
import net.minecraft.client.gui.FontRenderer
import net.minecraft.client.renderer.BufferBuilder
import net.minecraft.client.renderer.RenderItem
import net.minecraft.client.renderer.block.model.BakedQuad
import net.minecraft.client.renderer.block.model.IBakedModel
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType
import net.minecraft.client.renderer.block.model.ModelManager
import net.minecraft.client.renderer.color.ItemColors
import net.minecraft.client.renderer.texture.TextureManager
import net.minecraft.client.resources.IResourceManager
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.world.World

/**
 * A RenderItem that does nothing,
 * replaces Minecrafts RenderItem.
 */
open class EmptyRenderItem(textureManager: TextureManager, modelManager: ModelManager, itemColors: ItemColors)
    : RenderItem(textureManager, modelManager, itemColors) {

    override fun registerItem(itm: Item?, subType: Int, identifier: String?) { }

    override fun registerBlock(blk: Block?, subType: Int, identifier: String?) { }

    override fun renderItem(stack: ItemStack, model: IBakedModel) { }

    override fun renderQuads(renderer: BufferBuilder?, quads: List<BakedQuad>, color: Int, stack: ItemStack) { }

    override fun shouldRenderItemIn3D(stack: ItemStack?): Boolean { return false }

    override fun renderItem(stack: ItemStack, cameraTransformType: TransformType?) { }

    override fun getItemModelWithOverrides(stack: ItemStack?, worldIn: World?, entitylivingbaseIn: EntityLivingBase?)
    : IBakedModel? { return null }

    override fun renderItem(
        stack: ItemStack,
        entitylivingbaseIn: EntityLivingBase?,
        transform: TransformType?,
        leftHanded: Boolean
    ) { }

    override fun renderItemModel(
        stack: ItemStack,
        bakedmodel: IBakedModel,
        transform: TransformType?,
        leftHanded: Boolean
    ) { }

    override fun renderItemIntoGUI(stack: ItemStack, x: Int, y: Int) { }

    override fun renderItemModelIntoGUI(stack: ItemStack, x: Int, y: Int, bakedmodel: IBakedModel) { }

    override fun renderItemAndEffectIntoGUI(stack: ItemStack, xPosition: Int, yPosition: Int) { }

    override fun renderItemAndEffectIntoGUI(
        p_184391_1_: EntityLivingBase?,
        p_184391_2_: ItemStack,
        p_184391_3_: Int,
        p_184391_4_: Int
    ) { }

    override fun renderItemOverlays(fr: FontRenderer, stack: ItemStack, xPosition: Int, yPosition: Int) { }

    override fun renderItemOverlayIntoGUI(fr: FontRenderer, stack: ItemStack, xPosition: Int, yPosition: Int, text:
    String?) { }

    override fun onResourceManagerReload(resourceManager: IResourceManager?) { }
}