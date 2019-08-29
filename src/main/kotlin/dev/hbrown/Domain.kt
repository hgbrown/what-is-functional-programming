package dev.hbrown

import java.math.BigDecimal

data class Coffee(val price: BigDecimal = BigDecimal.TEN)

data class CreditCard(val nameOnCard: String, val cardNumber: String, val expiryDate: String, val securityCode: String) {

    fun charge(amount: BigDecimal) {
        TODO("contact bank and charge $amount to card")
    }
}