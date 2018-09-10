interface PersonInterface {

    var first_name: String;
    var last_name: String;
    var age: Int;

    fun setFirstName(first_name: String);

    fun getFirstName(): String;

    fun setLastName(last_name: String);

    fun getLastName(): String;

    fun setAge(age: Short);

    fun getAge(): Short;

    fun returnString(): String;

}