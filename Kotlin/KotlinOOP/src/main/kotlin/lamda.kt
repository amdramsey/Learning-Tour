fun addNames(a: String, b: String, adFun: (String, String) -> String): String {

    return adFun(a, b);

}

fun result(a: String, b: String) = a + " " + b;

fun main(args: Array<String>) {

    println(addNames("Ahmed", "Ramsey", ::result));

    println(addNames("Ahmed", "Ramsey", {a: String, b: String -> a + " " + b}));

}