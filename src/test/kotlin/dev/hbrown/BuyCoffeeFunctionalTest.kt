package dev.hbrown

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.math.BigDecimal

internal class BuyCoffeeFunctionalTest : CreditCardFixture {

    private val cut = BuyCoffeeFunctional()

    @Test
    internal fun `able test directly without mocks`() {
        val cc = validCreditCard()

        val (boughtCupOfCoffee, charge) = cut.buyCoffee(cc)

        assertAll("credit card should be charged the same amount as cup of coffee bought",
            { assertThat(boughtCupOfCoffee.price).isEqualTo(BigDecimal.TEN) },
            { assertThat(charge.amount).isEqualTo(BigDecimal.TEN) },
            { assertThat(charge.cc).isEqualTo(cc) }
        )

    }

    @Test
    internal fun `should be able to purchase multiple cups of coffee`() {
        val cc = validCreditCard()
        val n = 12

        val (coffees, charge) = cut.buyCoffees(cc = cc, n = n)

        assertAll("should be able to charge multiple cups of coffee with the same card using a single charge amount",
            { assertThat(coffees.size).isEqualTo(n) },
            { assertThat(charge.amount).isEqualTo(BigDecimal("120")) },
            { assertThat(charge.cc).isEqualTo(cc) }
        )
    }


}
