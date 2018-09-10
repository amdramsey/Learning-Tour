object myScore{

    var scoreNums: Array<Int> = arrayOf(20, 40, 33, 66, 90);

    fun scoreResults() = scoreNums.last();

}

fun main(args: Array<String>) {

    val scoreNumResult = myScore.scoreResults();

    println(scoreNumResult);

}