class personsUsingFor constructor(private var names: Array<String>) {

    fun getPersonsArraySize(): Int {

        return this.names.size

    }

    fun getPersonNameIn(point: Int): String {

        return this.names[point];

    }

    fun deletePersonNameIn(point: Int) {

        this.names.drop(point);

    }

    fun getPersonsNamesArray(): Array<String> {

        return this.names;

    }

}

fun main(args: Array<String>) {

    val stars: String = "*******************";
    val persons: personsUsingFor = personsUsingFor(arrayOf("Ahmed", "Ramsey", "Shaheen"));

    println(persons.getPersonsNamesArray()[0]);
    println(stars);
    println(persons.getPersonsArraySize().toString());

}