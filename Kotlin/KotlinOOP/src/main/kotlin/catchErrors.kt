fun main(args: Array<String>) {

    val num1: Int = 10;
    val num2: Int = 0;
    val num3: Int = 12;
    val sum = num1 + num2+ num3;

    println("sum = $sum");

    val sub = num1 - num2 - num3;

    println("sub = $sub");

    try {

        val div = num1 / num2 / num3;

        println("div = $div");

    } catch (ex: Exception) {

        println(ex.toString());

    }

    val mul = num1 * num2 * num3;

    println("mul = $mul");

}