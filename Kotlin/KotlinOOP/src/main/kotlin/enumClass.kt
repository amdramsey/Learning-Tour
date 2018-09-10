enum class Days {

    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday

}
fun main(args: Array<String>) {

    val day1: Days = Days.Tuesday;
    val day2: Days = Days.Tuesday;

    println(day1 == day2);

}