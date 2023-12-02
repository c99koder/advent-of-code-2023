import java.io.File

fun firstDigit(s: String): Int {
    s.forEach {
        if(it.isDigit()) {
            return it.toInt() - '0'.toInt()
        }
    }
    
    return 0
}

fun main() {
    var total1 = 0
    var total2 = 0

    File("input.txt").forEachLine { 
        total1 += firstDigit(it) * 10
        total1 += firstDigit(it.reversed())

        //Replace words with digits, but keep the words in case they overlap (ex. eightwo needs to match both 8 and 2)
        var i = it.replace("zero", "zero0zero")
        i = i.replace("one", "one1one")
        i = i.replace("two", "two2two")
        i = i.replace("three", "three3three")
        i = i.replace("four", "four4four")
        i = i.replace("five", "five5five")
        i = i.replace("six", "six6six")
        i = i.replace("seven", "seven7seven")
        i = i.replace("eight", "eight8eight")
        i = i.replace("nine", "nine9nine")

        total2 += firstDigit(i) * 10
        total2 += firstDigit(i.reversed())
    }

    println("Calibration value sum (part 1): $total1")
    println("Calibration value sum (part 2): $total2")
}