package dev.hbrown


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BuyCoffeeWithSideEffectsTest : CreditCardFixture {
    private val cut = BuyCoffeeWithSideEffects()

    @Test
    internal fun `no way to test method without invoking side effect`() {
        val e = assertThrows<NotImplementedError>("in this dummy implementation has not been implemented") {
            cut.buyCoffee(validCreditCard())
        }

        assertThat(e.message).isEqualTo("An operation is not implemented: contact bank and charge 10 to card")
    }

}
