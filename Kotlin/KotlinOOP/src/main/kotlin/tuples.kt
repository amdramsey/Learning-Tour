fun myFunction(name: String): Pair<String, Int> {

    return Pair("Ramsey", 33);

}

fun main(args: Array<String>) {

    val myWord = myFunction("Ahmed");
    println(myWord.first);

}