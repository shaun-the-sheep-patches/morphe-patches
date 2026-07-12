package app.morphe.patches.pinnit

import app.morphe.patcher.Fingerprint

object PinnitEntitlementCheckerFingerprintF : Fingerprint(
    definingClass = "Lkx3;",
    name = "f",
    parameters = listOf("Lcom/revenuecat/purchases/CustomerInfo;"),
    returnType = "Lpw;"
)

object PinnitEntitlementCheckerFingerprintD : Fingerprint(
    definingClass = "Lkx3;",
    name = "d",
    parameters = listOf("Landroid/app/Activity;", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lxh0;"),
    returnType = "Ljava/lang/Object;"
)
