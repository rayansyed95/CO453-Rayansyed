using System;

namespace ConsoleAppProject.App04
{
    ///<summary>
    /// The main program class for the Social Network.
    /// This class is responsible for creating instances of the classes
    /// MessagePost, PhotoPost, and NewsFeed, and allowing the user to
    /// interact with them through a simple console menu system.
    ///</summary>
    public class Program
    {
        // A news feed to hold all the posts
        private static NewsFeed newsFeed = new NewsFeed();


        public static void Main(string[] args)
        {
            Console.WriteLine("Hello and welcome to the Social Network!");
            Console.WriteLine("----------------------------------------");

            bool quit = false;
            while (!quit)
            {
                Console.WriteLine("\nPlease select an option:");
                Console.WriteLine("1. Add a message post");
                Console.WriteLine("2. Add a photo post");
                Console.WriteLine("3. Display all posts");
                Console.WriteLine("4. Display Posts of a Particular Author");
                Console.WriteLine("5. Delete a Particular Post");
                Console.WriteLine("6. Quit");
                Console.Write("Your choice: ");

                string choice = Console.ReadLine();
                Console.WriteLine();

                switch (choice)
                {
                    case "1":
                        AddMessagePost();
                        break;
                    case "2":
                        AddPhotoPost();
                        break;
                    case "3":
                        DisplayAllPosts();
                        break;
                    case "4":
                        DisplayPostsOfAuthor();
                        break;
                    case "5":
                        quit = true;
                        Console.WriteLine("Goodbye!");
                        break;
                    default:
                        Console.WriteLine("Invalid choice. Please try again.");
                        break;
                }
            }
        }

        ///<summary>
        /// Add a message post to the news feed.
        ///</summary>
        private static void AddMessagePost()
        {
            Console.Write("Enter username: ");
            string username = Console.ReadLine();
            Console.Write("Enter message text: ");
            string message = Console.ReadLine();

            MessagePost post = new MessagePost(username, message);
            newsFeed.AddMessagePost(post);

            Console.WriteLine("Message post added to news feed.");
            Console.WriteLine("The post is created. What would you like to do?");
            Console.WriteLine("C - Add Comment to this post");
            Console.WriteLine("L - Like This Post");
            Console.WriteLine("U - Unlike This Post");
            Console.WriteLine("D - Delete This Post");
            Console.Write("Enter your choice: ");

            // Read the user's choice
            string choice = Console.ReadLine();

            // Take action based on the user's choice
            switch (choice.ToUpper())
            {
                case "C":
                    Console.Write("Enter your comment: ");
                    string commentText = Console.ReadLine();
                    post.AddComment(commentText);
                    Console.WriteLine("Comment added.");
                    break;

                case "L":
                    post.Like();
                    Console.WriteLine("Post liked.");
                    break;

                case "U":
                    post.Unlike();
                    Console.WriteLine("Post Unliked.");
                    break;

                case "D":
                    //this code needs to working. pending so far
                    Console.WriteLine("Post deleted.");
                    break;

                default:
                    Console.WriteLine("Invalid choice.");
                    break;
            }
        }


        ///<summary>
        /// Add a photo post to the news feed.
        ///</summary>
        private static void AddPhotoPost()
        {
            Console.Write("Enter username: ");
            string username = Console.ReadLine();
            Console.Write("Enter photo filename: ");
            string filename = Console.ReadLine();
            Console.Write("Enter photo caption: ");
            string caption = Console.ReadLine();

            PhotoPost post = new PhotoPost(username, filename, caption);
            newsFeed.AddPhotoPost(post);

            Console.WriteLine("Photo post added to news feed.");
            Console.WriteLine("The post is created. What would you like to do?");
            Console.WriteLine("C - Add Comment to this post");
            Console.WriteLine("L - Like This Post");
            Console.WriteLine("U - Unlike This Post");
            Console.WriteLine("D - Delete This Post");
            Console.Write("Enter your choice: ");

            // Read the user's choice
            string choice = Console.ReadLine();

            // Take action based on the user's choice
            switch (choice.ToUpper())
            {
                case "C":
                    Console.Write("Enter your comment: ");
                    string commentText = Console.ReadLine();
                    post.AddComment(commentText);
                    Console.WriteLine("Comment added.");
                    break;

                case "L":
                    post.Like();
                    Console.WriteLine("Post liked.");
                    break;

                case "U":
                    post.Unlike();
                    Console.WriteLine("Post Unliked.");
                    break;

                case "D":
                    //this code needs to working. pending so far
                    Console.WriteLine("Post deleted.");
                    break;

                default:
                    Console.WriteLine("Invalid choice.");
                    break;
            }
        }


        ///<summary>
        /// Display all posts in the news feed.
        ///</summary>
        private static void DisplayAllPosts()
        {
            newsFeed.Display();
        }
        private static void DisplayPostsOfAuthor()
        {
            Console.Write("Enter username to search: ");
            string username = Console.ReadLine();
            newsFeed.DisplayPostsOfAuthor(username);

            Console.WriteLine($"    Displaying Posts by: {username}");
        }
    }
}
