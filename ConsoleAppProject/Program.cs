using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UnitConverter; // Add this line to import the "UnitConverter" namespace
using BMI; // Add this line to import the "BMICalculator" namespace

namespace BodyShape
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int choice = 0;

            while (choice != 3)
            {
                Console.WriteLine("==============");
                Console.WriteLine("BMI Calculator");
                Console.WriteLine("by Rayan Syed");
                Console.WriteLine("==============");
                Console.WriteLine("\nPlease select an option:");
                Console.WriteLine("1. Unit Converter");
                Console.WriteLine("2. BMI Calculator");
                Console.WriteLine("3. Exit Program");

                ///Runs only incase of wrong input by user in the menu
                if (!int.TryParse(Console.ReadLine(), out choice))
                {
                    Console.WriteLine("Invalid input. Please enter a number.");
                    continue;
                }
                ///checks the user input and runs the program accordingly
                switch (choice)
                {
                    case 1:
                        Console.WriteLine("Starting Unit Converter...");
                        Console.WriteLine();
                        UnitConverter.Program.Main(null);
                        break;

                    case 2:
                        Console.WriteLine("Starting BMI Calculator...");
                        Console.WriteLine();
                        BMI.Program.Main(null);
                        break;

                    case 3:
                        Console.WriteLine("Exiting program...");
                        break;

                    default:
                        Console.WriteLine("Invalid choice. Please try again.");
                        break;
                }

                Console.WriteLine();
            }
        }
    }
}