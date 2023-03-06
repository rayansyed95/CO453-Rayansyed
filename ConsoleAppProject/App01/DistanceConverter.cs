using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitConverter
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("===============");
            Console.WriteLine("Unit Convertor");
            Console.WriteLine("===============");
            Console.WriteLine("Developed by: Rayan Syed");
            Console.WriteLine();

            Console.WriteLine("Select input unit:");
            Console.WriteLine("1. Miles");
            Console.WriteLine("2. Meters");
            Console.WriteLine("3. Feet");

            ///main variables
            string inputUnit;
            double inputFactor;
            string outputUnit;
            double outputFactor;

            ///Will check for the input unit and assign the input factor
            switch (Console.ReadLine())
            {
                case "1":
                    inputUnit = "miles";
                    inputFactor = 1.0;
                    break;
                case "2":
                    inputUnit = "meters";
                    inputFactor = 1.0 / 1609.34;
                    break;
                case "3":
                    inputUnit = "feet";
                    inputFactor = 1.0 / 5280;
                    break;
                default:
                    Console.WriteLine("Invalid input unit selected.");
                    return;
            }

            Console.WriteLine("Select output unit:");
            Console.WriteLine("1. Miles");
            Console.WriteLine("2. Meters");
            Console.WriteLine("3. Feet");

            ///will check for the output unit and decide the factor
            switch (Console.ReadLine())
            {
                case "1":
                    outputUnit = "miles";
                    outputFactor = 1.0;
                    break;
                case "2":
                    outputUnit = "meters";
                    outputFactor = 1609.34;
                    break;
                case "3":
                    outputUnit = "feet";
                    outputFactor = 5280;
                    break;
                default:
                    Console.WriteLine("Invalid output unit selected.");
                    return;
            }

            Console.WriteLine($"Enter number of {inputUnit}:");
            if (!double.TryParse(Console.ReadLine(), out double inputValue)) ///generates error at wrong inputs
            {
                Console.WriteLine("Invalid input value entered.");
                return;
            }

            double outputValue = inputValue * inputFactor * outputFactor; ///this calculates the output as required to be shown to user
            Console.WriteLine($"{inputValue} {inputUnit} = {outputValue} {outputUnit}");
        }

    }


}