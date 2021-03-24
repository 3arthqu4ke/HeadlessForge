package me.earth.headlessforge.inject

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
import java.util.function.Supplier

/**
 * Manages Hooks made by Mixin or the Transformer.
 */
object Hooks {
    /** Marks that Hooks are currently active. */
    private const val HOOK = true

    /** If hooks are active the CallbackInfo will be cancelled. */
    @JvmField
    val DEFAULT_HOOK = {
        ci: CallbackInfo -> if (HOOK) { ci.cancel() }
    }

    /** If Hooks are active the Runnable will not be executed. */
    @JvmField
    val RUN_HOOK = {
        run: Runnable -> if (!HOOK) { run.run() }
    }

    /** Sets the given CIR to the value if hooks are active. */
    @JvmStatic
    fun <T> returnableHook(cir: CallbackInfoReturnable<T>, value: T) {
        if (HOOK) { cir.returnValue = value }
    }

    /** If Hooks are active the first Supplier will be called, otherwise the second. */
    @JvmStatic
    fun <T> lambdaHook(ifHooked: Supplier<T>, otherwise: Supplier<T>): T {
        return if (HOOK) ifHooked.get() else otherwise.get()
    }

    /** Returns the first value if hooks are active otherwise the second one. */
    @JvmStatic
    @Suppress("unused")
    fun <T> valueHook(ifHooked: T, otherwise: T): T {
        return if (HOOK) ifHooked else otherwise
    }

    /** Returns true if the hooks are currently active. */
    @JvmStatic
    fun active(): Boolean {
        return HOOK
    }
}