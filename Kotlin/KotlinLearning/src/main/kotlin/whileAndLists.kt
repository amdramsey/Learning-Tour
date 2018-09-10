class personsUsingWhile constructor(private var names: List<String>) {

    fun getPersonsArraySize(): Int {

        return this.names.size

    }

    fun getPersonNameIn(point: Int): String {

        return this.names[point];

    }

    fun deletePersonNameIn(point: Int) {

        this.names.drop(point);

    }

    fun getPersonsNamesArray(): List<String> {

        return this.names;

    }

}

fun main(args: Array<String>) {

    val stars: String = "*******************";
    val persons2: personsUsingWhile = personsUsingWhile(listOf("Ahmed", "Ramsey", "Shaheen"));

    println(persons2.getPersonNameIn(0));
    println(stars);
    println(persons2.getPersonsArraySize().toString());

}