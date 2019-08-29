package dev.hbrown

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.jupiter.api.Test

internal class BuyCoffeeExtractingPaymentsTest : CreditCardFixture {

    private val cut = BuyCoffeeExtractingPayments()

    @Test
    internal fun `can test method by introducing mocks`() {
        val cc = validCreditCard()
        val mockPayments: Payments = mock()

        val boughtCupOfCoffee = cut.buyCoffee(cc, mockPayments)

        verify(mockPayments, times(1)).charge(cc, boughtCupOfCoffee.price)

    }
}