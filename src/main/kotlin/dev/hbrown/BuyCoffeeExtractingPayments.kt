package dev.hbrown


import java.math.BigDecimal

interface Payments {

    fun charge(cc: CreditCard, amount: BigDecimal)
}

class BuyCoffeeExtractingPayments {

    fun buyCoffee(cc: CreditCard, paymentProcessor: Payments): Coffee {
        val cup = Coffee()

        paymentProcessor.charge(cc, cup.price)

        return cup
    }

}
