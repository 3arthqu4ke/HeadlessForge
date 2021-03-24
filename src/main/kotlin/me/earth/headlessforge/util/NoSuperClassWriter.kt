package me.earth.headlessforge.util

/** Credits to forgehax. */
open class NoSuperClassWriter: ComputeFrameMaxsWriter() {
    override fun getCommonSuperClass(type1: String?, type2: String?): String {
        if (type1.equals("blr")) { // GuiMainMenu edge case
            return "blk"
        }
        return "java/lang/Object" // return super.getCommonSuperClass(type1, type2)
    }

}