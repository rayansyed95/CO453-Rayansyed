using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;


namespace BMI
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("==============");
            Console.WriteLine("BMI Calculator");
            Console.WriteLine("by Rayan Syed");
            Console.WriteLine("==============");
            Console.WriteLine("\nThis app will calculate your BMI");

            Console.WriteLine("\nSelect the unit system you would like to use:");
            Console.WriteLine("\n1. Metric (kg, m)");
            Console.WriteLine("\n2. Imperial (lb, in)");

            /// checks for the user input for matric or imperial units of measurements
            int choice;
            if (!int.TryParse(Console.ReadLine(), out choice))
            {
                Console.WriteLine("Invalid input. Please enter a number.");
                Thread.Sleep(3000); /// This pauses the program for 3 seconds incase of an error then re-loads it
                Main(null);
                return;
            }

            double weight = 0, height = 0;
            switch (choice) /// based on choices made by the user, it will run the code either for matric or imperial system
            {
                case 1:
                    Console.Write("\nEnter your weight in kilograms: ");
                    if (!double.TryParse(Console.ReadLine(), out weight) || weight < 0) ///Checks if the weight entered is correct
                    {
                        Console.WriteLine("This is incorrect weight.");
                        Thread.Sleep(3000);
                        Main(null);
                        return;
                    }
                    Console.Write("Enter your height in meters: ");
                    if (!double.TryParse(Console.ReadLine(), out height) || height < 0) ///Checks if the height entered is correct
                    {
                        Console.WriteLine("This is incorrect height.");
                        Thread.Sleep(3000);
                        Main(null);
                        return;
                    }
                    double bmi = weight / Math.Pow(height, 2); ///Formulating BMI in Matric Unit
                    Console.WriteLine("\nYour BMI is: " + bmi.ToString("F2"));
                    Console.WriteLine("Weight Status: " + GetWeightStatus(bmi));
                    break;
                case 2:
                    Console.Write("\nEnter your weight in pounds: ");
                    if (!double.TryParse(Console.ReadLine(), out weight) || weight < 0)
                    {
                        Console.WriteLine("This is incorrect weight.");
                        Thread.Sleep(3000);
                        Main(null);
                        return;
                    }
                    Console.Write("Enter your height in inches: ");
                    if (!double.TryParse(Console.ReadLine(), out height) || height < 0)
                    {
                        Console.WriteLine("This is incorrect height.");
                        Thread.Sleep(3000);
                        Main(null);
                        return;
                    }
                    bmi = (weight * 703) / Math.Pow(height, 2); ///calculating BMI in Imperial units
                    Console.WriteLine("\nYour BMI is: " + bmi.ToString("F2"));
                    Console.WriteLine("Weight Status: " + GetWeightStatus(bmi));
                    break;
                default: ///this will run if the user does not enter the choice properly
                    Console.WriteLine("Invalid choice. Please try again.");
                    Thread.Sleep(3000);
                    Main(null);
                    return;
            }
        }

        static string GetWeightStatus(double bmi)
        {
            if (bmi < 18.5)
            {
                return "Underweight";
            }
            else if (bmi < 25)
            {
                return "Normal";
            }
            else if (bmi < 30)
            {
                return "Overweight";
            }
            else if (bmi < 35)
            {
                return "Obese Class I";
            }
            else if (bmi < 40)
            {
                return "Obese Class II";
            }
            else
            {
                return "Obese Class III";
            }
        }
    }
}