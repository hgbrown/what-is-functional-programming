package dev.hbrown

class BuyCoffeeWithSideEffects {

    fun buyCoffee(cc: CreditCard): Coffee {
        val cup = Coffee()

        cc.charge(cup.price)

        return cup
    }

}
