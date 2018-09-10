using System;
namespace MultiplicationTable {
    class MainClass {
        public static void Main(string[] args) {
            for (int i = 0; i <= 12; i++) {
                Console.WriteLine("Multiplication table number: " + i);
                for (int x = 0; x <= 12; x++) {
                    Console.WriteLine("   " + i + " * " + x + " = " + (i * x));
                }
                Console.WriteLine("=========================================");
            }
        }
    }
}