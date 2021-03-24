package me.earth.headlessforge.util

import org.objectweb.asm.ClassWriter

/** A [ClassWriter] that calls calls super(COMPUTE_FRAMES or COMPUTE_MAXS); */
open class ComputeFrameMaxsWriter: ClassWriter(COMPUTE_FRAMES or COMPUTE_MAXS)