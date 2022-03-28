import java.util.Scanner

fun printField(f: Array<BooleanArray>) {
    for (i in f.indices) {
        for (j in f.indices) {
            var cell = if (f[i][j]) "1" else "0"
            if (j < f.size - 1) {
                cell += " "
            }
            print(cell)
        }
        println()
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val n_tiles = sc.nextInt()
    val tiles = Array(n) { BooleanArray(n) }
    for (j in 0 until n_tiles) {
        val id = sc.nextInt() - 1
        val row = id / n
        val column = id % n
        tiles[row][column] = !tiles[row][column]
        for (i in 0 until n) {
            tiles[i][column] = !tiles[i][column]
            tiles[row][i] = !tiles[row][i]
        }
    }
    var color1 = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (tiles[i][j]) {
                color1++
            }
        }
    }
    // printField(tiles)
    println(color1)
}
