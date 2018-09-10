fun main(args: Array<String>) {

    val stars: String = "************************************************";
    val person: Person = Person(first_name = "Ahmed", last_name = "Ramsey", age = 15);

    println("Hello, ${person.first_name} ${person.last_name}");
    println("You are ${person.age}, Years old");

}