class Doctor(name: String = "", age: Int = 25, private var specialization: String = "Under training"): Person(name, age) {

    fun getSpecialization(): String {

        return specialization.toLowerCase();

    }

    fun changeSpecialization(specialization: String) {


        this.specialization = specialization;

    }

}

fun main(args: Array<String>) {

    val doctor: Doctor = Doctor("Ahmed", 23);
    val stars: String = "*******************";

    println(doctor.getName());
    println(doctor.getAge());
    println(doctor.getSpecialization());
    println(stars);
    doctor.changeName("Ahmed Ramsey");
    doctor.changeAge(32);
    doctor.changeSpecialization("Cardiology");
    println(doctor.getName());
    println(doctor.getAge());
    println(doctor.getSpecialization());

}