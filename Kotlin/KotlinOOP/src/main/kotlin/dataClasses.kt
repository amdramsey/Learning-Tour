data class Employee(var ID: Int, var first_name:  String, var last_name: String, var age: Int);

fun main(args: Array<String>) {

    val employee1: Employee = Employee(1, "Ahmed", "Ramsey", 15);
    val employee2: Employee = Employee(2, "Nada", "Ramsey", 10);

    println(employee1);
    println(employee2);

    val check: Int = if(employee1 == employee2) {0} else {1};

    println(check);

    if(if(employee1 == employee2) {0} else {1} == 1) {

        println(if(employee1 == employee2) {0} else {1});

    } else {

        println(if(employee1 == employee2) {0} else {1});

    }

}