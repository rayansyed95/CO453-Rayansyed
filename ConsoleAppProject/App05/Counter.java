import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is responsible for maintaining and displaying the player's score and money.
 * 
 * @authors James Patrick Arellano 
 * @2.0
 */
public class Counter extends Actor
{
    int score;
    int money;
    int time;
    int level = 1;
    public Counter() //counter display function on the world
    {
        setImage(new GreenfootImage("Your Score: " + score + "\n Your Cash: " + money + "\n Time: " + time/80 + "\n Level: " + level, 40, Color.WHITE, new Color (0,0,0,0)));
    }
    public void act()
    {
        time++;
        setImage(new GreenfootImage("Your Score: " + score + "\n Your Cash: " + money + "\n Time: " + time/80 + "\n Level: " + level, 40, Color.WHITE, new Color (0,0,0,0)));
        if((time/80) >= 80 && (time/80) < 160) // following code will check the time and change the level of the game
        {
            level = 2;
        }
        if((time/80) >= 160 && (time/80) < 240)
        {
            level = 3;
        }
        if((time/80) >= 240) // after 240 seconds (4 minutes), the game will end and the message will appear on the screen
        {
            getWorld().showText("Congratulations, You Win!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.playSound("sounds/you-win.wav");
            Greenfoot.stop(); // this will stop the game
        }
    }
}
