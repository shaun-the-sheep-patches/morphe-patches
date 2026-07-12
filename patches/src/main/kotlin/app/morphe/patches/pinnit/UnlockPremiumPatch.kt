package app.morphe.patches.pinnit

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.extensions.InstructionExtensions.removeInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.shared.Constants.COMPATIBILITY_PINNIT

@Suppress("unused")
val unlockPremiumPatch = bytecodePatch(
    name = "Unlock Premium",
    description = "Unlocks all premium features of Pinnit by bypassing the RevenueCat entitlement and purchase checks.",
    default = true
) {
    compatibleWith(COMPATIBILITY_PINNIT)

    execute {
        // Hook method f() in Lkx3; to hamesha return Lnw;->g
        PinnitEntitlementCheckerFingerprintF.method.apply {
            val count = implementation?.instructions?.size ?: 0
            removeInstructions(0, count)
            addInstructions(
                0,
                """
                    sget-object v0, Lnw;->g:Lnw;
                    return-object v0
                """
            )
        }

        // Hook method d() in Lkx3; to hamesha return Lnw;->g
        PinnitEntitlementCheckerFingerprintD.method.apply {
            val count = implementation?.instructions?.size ?: 0
            removeInstructions(0, count)
            addInstructions(
                0,
                """
                    sget-object v0, Lnw;->g:Lnw;
                    return-object v0
                """
            )
        }
    }
}
