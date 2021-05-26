import java.util.*

fun main() {
    val pairNumberOne = PairNumber(2, 4)
    val pairNumberTwo = PairNumber(-8, 11)

    val pairNumber = pairNumberOne - pairNumberTwo


    print("Please enter your birthdate in dd.mm.yyyy format: ")
    val userInput: String? = readLine()

    if (!userInput.isNullOrEmpty()) {  //todo check whether two dots

        val userDate = userInput.split(".").toTypedArray()

        val day = userDate[0]
        val month = userDate[1]
        val year = userDate[2]

        if (checkDates(day, month, year)) {
            //TODO getTodaysDate
            //TODO applyMinus
        }


    } else {
        printErrorMessage()
    }


}

fun getTodayDate() {
    val date = Calendar.getInstance()
    val year = date.get(Calendar.YEAR)
    val month = date.get(Calendar.MONTH + 1)      //indexed from 0..11 so add +1
    val day = date.get(Calendar.DAY_OF_MONTH)


}

fun checkDates(vararg userDate: String): Boolean {

    return if (userDate[0] !in 1..30 || userDate[1] !in 1..12 || userDate[2] !in 1000..9999) {
        printErrorMessage()
        false
    } else {
        true
    }

}

data class PairNumber(val numberOne: Int, val numberTwo: Int) {
    operator fun minus(pairNumber: PairNumber): PairNumber {
        val returnPairObject = PairNumber(
            numberOne - pairNumber.numberOne,
            numberTwo - pairNumber.numberTwo
        )

        println("Result = (${returnPairObject.numberOne}, ${returnPairObject.numberTwo})")

        return returnPairObject
    }


}

//data class PairNumber(val numberOne: Int, val numberTwo: Int) {
//    operator fun minus(pairNumber: PairNumber): PairNumber {
//        val returnPairObject = PairNumber(
//            numberOne - pairNumber.numberOne,
//            numberTwo - pairNumber.numberTwo
//        )
//
//        println("Result = (${returnPairObject.numberOne}, ${returnPairObject.numberTwo})")
//
//        return returnPairObject
//    }
//
//
//}

fun printErrorMessage() {
    println("Please enter a valid date")
}