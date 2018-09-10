class MyThread(var processName: String) : Thread() {

    override fun run() {

        var count = 0
        while(count <= 10) {

            println("${this.processName}, Counter: $count")

            try {

                sleep(1000)

            } catch(ex: Exception) {

                println(ex.message)

            }

            count ++

        }

    }

}

fun main(args: Array<String>) {

    val test1 = MyThread("T1")
    test1.run()

    val test2 = MyThread("T2")
    test2.run()

    val test3 = MyThread("T3")
    test3.run()

    println("Thread is running")

}