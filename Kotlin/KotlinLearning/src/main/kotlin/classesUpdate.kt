class PersonsUpdate constructor(vararg names: String) {

    private val names: Array<String>;

    init {

        var array: Array<String> = arrayOf();

        for(x in names) {

            array += arrayOf(x);

        }

        this.names = array;

    }

    fun getPersonsArraySize(): Int {

        return this.names.size

    }

    fun getPersonNameIn(point: Int): String {

        return this.names[point];

    }

    fun deletePersonNameIn(point: Int) {

        this.names.drop(point);

    }

    fun getPersonsNameArray(): Array<String> {

        return this.names;

    }

}

fun main(args: Array<String>) {

    val stars: String = "*******************";
    val persons: PersonsUpdate = PersonsUpdate("Ahmed", "Ramsey", "Shaheen");

    println("${persons.getPersonsNameArray()[0]}, ${persons.getPersonsNameArray()[1]}, ${persons.getPersonsNameArray()[2]}");
    println(stars);
    println(persons.getPersonNameIn(0));
    println(stars);
    persons.deletePersonNameIn(0);
    println("${persons.getPersonsNameArray()[0]}, ${persons.getPersonsNameArray()[1]}, ${persons.getPersonsNameArray()[2]}");

}