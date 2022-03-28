import java.util.Scanner
fun print_tiles( t: Array<Array<Int>>) {
    for (row in t) {
        for (cell in row)
            print("$cell ")
        println()
    }
}
fun sum_of_tiles( t: Array<Array<Int>>): Int {
    var sum = 0
    for (row in t) {
        for (cell in row)
            sum += cell
    }
    return sum
}
fun inv(v: Int):Int = if (v == 0) 1 else 0

// for field building (testing)
fun click(id: Int, n: Int, t: Array<Array<Int>>) {
    // counting cells from 1
    val row = (id-1) / n
    val column = (id-1) % n
    t[row][column] = inv(t[row][column])
    for (i in 0 until n) {
        t[i][column] = inv(t[i][column])
        t[row][i] = inv(t[row][i])
    }
}
fun solve (n: Int, t: Array<Array<Int>>) {
    val tile_numbers = mutableListOf<Int>()
    for (id in 1 .. n*n) {
        var cross_sum = 0
        val row = (id-1) / n
        val column = (id-1) % n
        cross_sum += t[row][column]
        for (i in 0 until n) {
            cross_sum += t[i][column]
            cross_sum += t[row][i]
        }
        cross_sum %= 2
        if (cross_sum == 1) {
            tile_numbers.add(id)
        }
    }
    println(tile_numbers.sorted().joinToString(" ") { it.toString() })
}
fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt() // square side length
    val tiles = Array(n) { Array(n) {sc.nextInt()} }
/*
    for (row in tiles) {
        for (i in row.indices) {
            row[i] = sc.nextInt()
        }
    }

 */
    solve(n, tiles)
}
