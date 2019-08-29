package dev.hbrown

interface CreditCardFixture {

    fun validCreditCard() = CreditCard(nameOnCard = "Camilla White", cardNumber = "4298350003834472", expiryDate = "05/2025", securityCode = "484")
}