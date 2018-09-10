fun test(test1: Int, test2: Int, function:(Int, Int) -> Int): Int {

    return function(test1, test2);

}

fun resultFunction(test1: Int, test2: Int) = test1 + test2;

fun main(args: Array<String>) {

    println(test(12, 12, ::resultFunction));

}