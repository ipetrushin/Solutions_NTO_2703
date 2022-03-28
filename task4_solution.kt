import java.util.Scanner

data class Reaction(val from:HashSet<String>, val to: HashSet<String>)

fun main() {
    val sc = Scanner(System.`in`)
    val compounds = HashSet<String>()
    compounds.addAll(sc.nextLine().split(" "))
    val reactions = ArrayList<Reaction>()
    while (sc.hasNextLine()) {
        val array = sc.nextLine().split("=")
        val r = Reaction(HashSet(array[0].split(" ")), HashSet(array[1].split(" ")))
        reactions.add(r)
    }
    var newCompoundAdded: Boolean

    do {
        newCompoundAdded = false
        val iterator = reactions.iterator()
        for (r in iterator) {
            if (compounds.containsAll(r.from)) {
                compounds.addAll(r.to)
                iterator.remove()
                newCompoundAdded = true
                //println(compounds)
            }
        }
    } while (newCompoundAdded)
    println(compounds.sorted().joinToString(" ") { it })

}
