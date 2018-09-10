class Person(override var first_name: String, override var last_name: String, override var age: Int) : PersonInterface {

    override fun setFirstName(first_name: String) {

        this.first_name = first_name;

    };

    override fun getFirstName(): String {

        return this.first_name;

    };

    override fun setLastName(last_name: String) {

        this.last_name = last_name;

    };

    override fun getLastName(): String {

        return last_name;

    };

    override fun setAge(age: Short) {

        this.age = age.toInt();

    };

    override fun getAge(): Short {

        return age.toShort();

    };

    override fun returnString(): String {

        return "My first name is: ${first_name}, And my last name is: ${last_name}, And my age is: ${age.toString()}";

    }

}