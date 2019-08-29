package dev.hbrown


import java.math.BigDecimal

data class Charge(val cc: CreditCard, val amount: BigDecimal) {

    fun combine(other: Charge): Charge {
        return if (cc == other.cc) {
            Charge(cc = cc, amount = amount.add(other.amount))
        } else {
            throw RuntimeException("Cannot combine charges to different cards")
        }
    }
}

class BuyCoffeeFunctional {

    fun buyCoffee(cc: CreditCard): Pair<Coffee, Charge> {
        val cup = Coffee()

        val charge = Charge(cc = cc, amount = cup.price)

        return cup to charge
    }

    fun buyCoffees(cc: CreditCard, n: Int): Pair<List<Coffee>, Charge> {
        val coffeePurchases = List(n) { buyCoffee(cc) }

        val (coffees, charges) = coffeePurchases.unzip()

        val singleCharge = charges.coalesce().first()

        return coffees to singleCharge
    }

}

fun List<Charge>.coalesce(): List<Charge> = this.groupBy { it.cc }.values.map { it.reduce { a, b -> a.combine(b) } }