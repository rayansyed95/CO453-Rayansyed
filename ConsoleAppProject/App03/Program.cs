using System;
class Program
{
    public Program()
    {
        throw new System.NotImplementedException();
    }
    static void Main(string[] args)
    {
        const int NUM_STUDENTS = 10;
        string[] studentNames = new string[NUM_STUDENTS];
        int[] studentMarks = new int[NUM_STUDENTS];
        Console.WriteLine("================================");
        Console.WriteLine("Students Marks Analysis Program");
        Console.WriteLine("    Developed by Rayan Syed");
        Console.WriteLine("================================");
        // Take input of student names and marks
        for (int i = 0; i < NUM_STUDENTS; i++)
        {
            Console.Write($"Enter name of student {i + 1}: ");
            studentNames[i] = Console.ReadLine();
            bool validMark = false;
            while (!validMark)
            {
                Console.Write($"Enter marks of student {i + 1}: ");
                string input = Console.ReadLine();
                if (!int.TryParse(input, out studentMarks[i]))
                {
                    Console.WriteLine("Invalid input: Please enter a number");
                    continue;
                }
                if (studentMarks[i] < 0 || studentMarks[i] > 100)
                {
                    Console.WriteLine("Invalid input: Please enter a number between 0 and 100");
                    continue;
                }
                validMark = true;
            }
        }
        // Convert marks to grades and save them
        string[] studentGrades = new string[NUM_STUDENTS];
        int[] gradeCounts = new int[5]; // 5 grades: A, B, C, D, Fail
        for (int i = 0; i < NUM_STUDENTS; i++)
        {
            if (studentMarks[i] >= 70)
            {
                studentGrades[i] = "A Grade, First Class";
                gradeCounts[0]++;
            }
            else if (studentMarks[i] >= 60)
            {
                studentGrades[i] = "B Grade, Upper Second Class";
                gradeCounts[1]++;
            }
            else if (studentMarks[i] >= 50)
            {
                studentGrades[i] = "C Grade, Lower Second Class";
                gradeCounts[2]++;
            }
            else if (studentMarks[i] >= 40)
            {
                studentGrades[i] = "D Grade, Third Class";
                gradeCounts[3]++;
            }
            else
            {
                studentGrades[i] = "Fail";
                gradeCounts[4]++;
            }
        }
        // Calculate statistics
        int totalMarks = 0;
        int minMarks = int.MaxValue;
        int maxMarks = int.MinValue;
        for (int i = 0; i < NUM_STUDENTS; i++)
        {
            totalMarks += studentMarks[i];
            if (studentMarks[i] < minMarks)
            {
                minMarks = studentMarks[i];
            }
            if (studentMarks[i] > maxMarks)
            {
                maxMarks = studentMarks[i];
            }
        }
        double avgMarks = (double)totalMarks / NUM_STUDENTS;
        // Print the student names, marks, and grades
        Console.WriteLine("\n===================================");
        Console.WriteLine("\nName\t\tMarks\t\tGrade\n");
        Console.WriteLine("\n===================================");
        for (int i = 0; i < NUM_STUDENTS; i++)
        {
            Console.WriteLine($"{studentNames[i]}\t\t{studentMarks[i]}\t\t{studentGrades[i]}");
        }
        // Print the statistics
        Console.WriteLine("\n========================");
        Console.WriteLine("\nClass Marks Statistics");
        Console.WriteLine("\n========================");
        Console.WriteLine($"\nAverage Marks: {avgMarks:F2}");
        Console.WriteLine($"\nMinimum Marks: {minMarks}");
        Console.WriteLine($"\nMaximum Marks: {maxMarks}");
        // Print the grade-wise count and percentage of students
        Console.WriteLine("\n=====================================");
        Console.WriteLine("\nGrade-wise distribution of students:");
        Console.WriteLine("\n=====================================");
        for (int i = 0; i < 5; i++)
        {
            double percentage = (double)gradeCounts[i] / NUM_STUDENTS * 100; //calculates % of each grade
            Console.WriteLine($"Grade {(char)('A' + i)}: {gradeCounts[i]} students ({percentage:F2}%)"); //this is used to print grade names
        }
        // Wait for user to press a key before exiting
        Console.ReadKey();
    }
    public void Method()
    {
        throw new System.NotImplementedException();
    }
}
