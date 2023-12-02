import java.io.File

val PART1_MAX = mapOf("red" to 12, "green" to 13, "blue" to 14)

fun validate_game(sets: List<String>): Boolean {
    sets.forEach {
        it.split(", ").forEach {
            val count = it.split(" ")[0].toInt()
            val color = it.split(" ")[1]

            if (count > PART1_MAX[color] ?: -1)
                return false
        }
    }

    return true
}

fun power(sets: List<String>): Int {
    val max = mutableMapOf<String, Int>()

    sets.forEach {
        it.split(", ").forEach {
            val count = it.split(" ")[0].toInt()
            val color = it.split(" ")[1]

            if(max[color] ?: 0 < count)
                max[color] = count
        }
    }

    return max.values.reduce { total, next -> total * next }
}

fun main() {
    var total1 = 0
    var total2 = 0

    File("input.txt").forEachLine {
        val game_id = it.split(": ")[0].split(" ")[1]
        val game = it.split(": ")[1].split("; ")

        if(validate_game(game))
            total1 += game_id.toInt()

        total2 += power(game)
    }

    println("Game IDs sum (part 1): $total1")
    println("Game IDs sum (part 2): $total2")
}