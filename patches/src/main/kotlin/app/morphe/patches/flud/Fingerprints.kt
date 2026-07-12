package app.morphe.patches.flud

import app.morphe.patcher.Fingerprint

object FludAdViewHelperFingerprintA : Fingerprint(
    definingClass = "Ln13;",
    name = "a",
    returnType = "V"
)

object FludAdViewHelperFingerprintB : Fingerprint(
    definingClass = "Ln13;",
    name = "b",
    parameters = listOf("Lzr0;"),
    returnType = "Ljava/lang/Object;"
)

object FludPermissionCheckerFingerprint : Fingerprint(
    definingClass = "Loj2;",
    name = "A",
    parameters = listOf("Lcom/delphicoder/flud/FludBaseActivity;", "Landroid/content/SharedPreferences;"),
    returnType = "Z"
)

object FludLicenseClientFingerprint : Fingerprint(
    definingClass = "Lcom/pairip/licensecheck/LicenseClient;",
    name = "checkLicense",
    parameters = listOf("Landroid/content/Context;"),
    returnType = "V"
)
