package example


val myFish = listOf(Fish("Flipper"), Fish("Moby Dick"), Fish("Dory"))


fun main() {
    val listString: StringBuffer = StringBuffer("Fishes are: ")
    // https://kotlinlang.org/docs/collection-transformations.html#string-representation
    // myFish.filter { it.name.contains("i")}.joinTo(listString) {it -> it.name}
    myFish.filter { it.name.contains("i")}.joinTo(listString) {it.name}
    println(listString)
    println(
        myFish.filter { it.name.contains("i") }.joinToString(", ") { it.name }
    )
}
