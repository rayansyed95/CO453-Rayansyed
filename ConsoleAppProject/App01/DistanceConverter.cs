using System;

namespace ConsoleAppProject.App01
{
    /// <summary>
    /// Please describe the main features of this App
    /// </summary>
    /// <author>
    /// Rayan version 0.1
    /// </author>
    public class DistanceConverter
    {
        const int MILES_TO_FEET = 5280;
        string input;
        int miles;
        int feet;

        public DistanceConverter()
        {

        }
        public void Run()
        {
            ConvertMilesToFeet();
            ConvertFeetToMiles();
        }

        public void ConvertMilesToFeet()
        {
            //step 1 - input miles

            Console.WriteLine("Please enter the number of miles: ");
            input = Console.ReadLine();
            miles = Convert.ToInt32(input);
            Console.WriteLine("Miles entered is: " + miles);

            // step 2 - conversion process 
            
            feet = miles* MILES_TO_FEET;

            // step 3 - output converted number of feet

            Console.WriteLine(miles + " miles is " + feet + " feet.");
        }

        public void ConvertFeetToMiles()
        {

            //step 1 - input feet

            Console.WriteLine("Please enter the number of feet: ");
            input = Console.ReadLine();
            feet = Convert.ToInt32(input);
            Console.WriteLine("Feet entered is: " + feet);

            // step 2 - conversion process 
            miles = feet / MILES_TO_FEET;

            // step 3 - output converted number of miles
            Console.WriteLine(feet + " feet is " + miles + " miles.");
        }
    }
}