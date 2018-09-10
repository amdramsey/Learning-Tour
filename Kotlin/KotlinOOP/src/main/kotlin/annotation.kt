@Deprecated("you cn use Cat class", ReplaceWith("Cat") )

class Dog constructor(first_name: String, last_name: String) {

    init {

        println("My first name ${first_name} and my last name ${last_name}");

    }

}

class Cat constructor(first_name: String, last_name: String) {

    init {

        println("My first name ${first_name} and my last name ${last_name}");

    }

}

fun main(args: Array<String>) {

    val dog: Cat = Cat("Ahmed", "Ramsey");
    dog

}