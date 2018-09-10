fun functionsWithUnlimitedParameters(vararg strings: String) {

    for(str in strings) {

        println(str);

    }

}

fun main(args: Array<String>) {

    val stars: String = "*******************";

    functionsWithUnlimitedParameters("Ahmed");
    println(stars);
    functionsWithUnlimitedParameters("Ahmed", "Fady", "John", "Ramsey", "Muhammed", "Shaheen");

}