open class Person constructor(private var name: String = "", private var age: Int = 1) {


    fun getName(): String {

        return this.name.toLowerCase();

    }

    fun getAge(): Int {

        return this.age;

    }

    fun changeName(name: String) {


        this.name = name;
    }

    fun changeAge(age: Int) {

        this.age = age;

    }

}

fun main(args: Array<String>) {

    var person: Person = Person("Ahmed", 15);
    println("Hello ${person.getName()}");
    println("You are ${person.getAge()}, Years old");

    println("************************************************");

    person.changeName("Ramsey");
    person.changeAge(62);
    println("Hello ${person.getName()}");
    println("You are ${person.getAge()}, Years old");

}