# What is functional programming?

Functional programming is based on a simple premise with far-reaching implications:

## Attempt 1: Side-Effects

**we construct our programs only from pure-functions - that is programs without side-effects**

Consider the first implementation that contains side-effects: `BuyCoffeeWithSideEffects`:

In this code, the charging of the credit card is a side-effect. 
As a result of this side-effect it is difficult to test this code.
We don't want to really contact the credit card provider to test our functionality - 
in fact we don't even really want the credit card to know how to contact the card issuer.

However, as can be seen in the test, it is difficult to test the buying of coffee here without knowledge of the mechanics of
actually how a credit card is charged. In fact, in our implementation we simply have an error indicating that it is not yet implemented 
but this detail is evident in our test.

## Attempt 2: Externalised dependency

We can make the code more modular and testable by introducing another object: `Payments` to handle the charging of the code.
In doing so, we gain some ability to test our code using a mock.
Of course to do this, we are forced to introduce `Payments` as an interface and a mocking framework.

Aside from testing, the code is also difficult to re-use. 
If the same customer wants to buy 12 cups of coffee we are forced to charge the card 12 times!
Of course, we could write an alternative `buyCoffees` method with logic for batching up the payments into a single charge but this results in duplicate logic.

## Attempt 3: A functional solution

The functional solution is to eliminate the side-effect completely. That is, return the charge in addition to the coffee.
In `BuyCoffeeFunctional` we have separated the concern of _creating_ a charge from the _processing_ of that charge.

This implementation enables us to perform a single charge against a credit card when multiple cups of coffee is bought. 
It also enables us to reuse the functionality from `buyCoffee` in `buyCoffees`.

Of course, we probably still need a `Payments` class for processing the payments but the purchasing of coffee does not need to know about this class.

