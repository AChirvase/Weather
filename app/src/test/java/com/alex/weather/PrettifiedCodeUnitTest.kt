package com.alex.weather

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PrettifiedCodeUnitTest {

    @Test
    fun test() {
        //GIVEN
        val rental1 = Rental(Car("Mustang", PriceCode.MUSCLE), 5)
        val rental2 = Rental(Car("Lambo", PriceCode.SUPERCAR), 20)
        val customer = Customer("Liviu")
        val expectedBillingStatement = UglyAsHeckUnitTest.getBillingStatement()

        //WHEN
        customer.addAllRentals(listOf(rental1, rental2))
        val actualBillingStatement = customer.billingStatement()

        //THEN
        assertEquals(expectedBillingStatement, actualBillingStatement)
    }
}

enum class PriceCode {
    ECONOMY,
    SUPERCAR,
    MUSCLE,
}

data class Car(
    val title: String,
    var priceCode: PriceCode
)

data class Rental(
    val car: Car,
    val daysRented: Int
) {
    fun calculateRentalAmount(): Double {
        var amount = 0.0

        when (car.priceCode) {
            PriceCode.ECONOMY -> {
                amount += 80
                if (daysRented > 2) {
                    amount += (daysRented - 2) * 30.0
                }
            }

            PriceCode.SUPERCAR -> {
                amount += daysRented * 200.0
            }

            PriceCode.MUSCLE -> {
                amount += 200
                if (daysRented > 3) {
                    amount += (daysRented - 3) * 50.0
                }
            }
        }
        return amount
    }
}

data class Bill(
    val customerName: String,
    val totalAmount: Double,
    val rentalAmountList: List<Pair<String, Double>>,
    val frequentRenterPoints: Int
) {
    override fun toString(): String {
        var result = "Rental Record for $customerName\n"
        rentalAmountList.forEach { (carTitle, amount) ->
            result += "\t$carTitle\t$amount\n"
        }
        result += "Final rental payment owed $totalAmount\n"
        result += "You received an additional $frequentRenterPoints frequent customer points"

        return result
    }
}

data class Customer(
    val name: String,
    private val rentals: ArrayList<Rental> = ArrayList()
) {

    fun addAllRentals(rentalList: List<Rental>) {
        rentals.addAll(rentalList)
    }

    fun billingStatement() = createBillingData().toString()

    private fun createBillingData(): Bill {
        val rentalAmountList = rentals.map { rental ->
            Pair(rental.car.title, rental.calculateRentalAmount())
        }

        return Bill(
            customerName = name,
            totalAmount = rentalAmountList.sumOf { it.second },
            rentalAmountList = rentalAmountList,
            frequentRenterPoints = calculateFrequentRenterPoints()
        )
    }

    private fun calculateFrequentRenterPoints() =
        rentals.sumOf { rental ->
            // add bonus for a two day new release rental
            if (rental.car.priceCode == PriceCode.SUPERCAR && rental.daysRented > 1) {
                2
            } else {
                1 as Int
            }
        }

}


