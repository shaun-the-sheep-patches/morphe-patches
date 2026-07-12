package app.morphe.patches.flud

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.extensions.InstructionExtensions.removeInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patches.shared.Constants.COMPATIBILITY_FLUD

@Suppress("unused")
val fludPremiumPatch = bytecodePatch(
    name = "Flud Ad-Free & Bypasses",
    description = "Unlock ad-free experience (disable banners/interstitials), bypass storage permission setup block, and disable Google Play Integrity licensing check.",
    default = true
) {
    compatibleWith(COMPATIBILITY_FLUD)

    execute {
        // Hook method a() in Ln13; (no-op)
        FludAdViewHelperFingerprintA.method.apply {
            removeInstructions(0, implementation!!.instructions.size)
            addInstructions(
                0,
                """
                    return-void
                """
            )
        }

        // Hook method b() in Ln13; (returns Unit immediately)
        FludAdViewHelperFingerprintB.method.apply {
            removeInstructions(0, implementation!!.instructions.size)
            addInstructions(
                0,
                """
                    sget-object v0, Lnl5;->a:Lnl5;
                    return-object v0
                """
            )
        }

        // Hook method A() in Loj2; (always returns false)
        FludPermissionCheckerFingerprint.method.apply {
            removeInstructions(0, implementation!!.instructions.size)
            addInstructions(
                0,
                """
                    const/4 v0, 0x0
                    return v0
                """
            )
        }

        // Hook method checkLicense() in Lcom/pairip/licensecheck/LicenseClient; (no-op)
        FludLicenseClientFingerprint.method.apply {
            removeInstructions(0, implementation!!.instructions.size)
            addInstructions(
                0,
                """
                    return-void
                """
            )
        }
    }
}
