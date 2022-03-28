import java.util.Scanner

fun dfs(f: Array<Array<Int>>, row: Int, column: Int, width: Int, height: Int) {
    if (row < 0 || row > height || column < 0 || column > width || f[row][column] != 0 )
        return
    f[row][column] = -1
    dfs(f, row - 1 , column, width, height)
    dfs(f, row, column + 1, width, height)
    dfs(f, row, column - 1, width, height)
}
fun print_field( f: Array<Array<Int>>) {
    for (row in f) {
        for (cell in row)
            print("$cell ")
        println()
    }
}
fun main() {
    val sc = Scanner(System.`in`)
    val width = sc.nextInt()
    val height = sc.nextInt()
    val field = Array(height) { Array(width) {sc.nextInt()} }
    for (col in 0 until width)
        dfs(field, height -1, col, width, height)

    //print_field(field)
    var zeros = 0
    for (row in field) {
        zeros += row.count{it == 0}
    }
    println(zeros)

}
