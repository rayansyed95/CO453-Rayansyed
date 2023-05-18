import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * All the counters displayed here in this class
 * 
 * @authors Rayan Yousuf Syed & James Ptrick Arellano 
 * @1.0
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //following will initialize all important parameters for the counter
    int score;
    int money;
    int time;
    int level = 1;
    public Counter() //counter display function on the world
    {
        setImage(new GreenfootImage("Your Score: " + score + "\n Your Cash: " + money + "\n Time: " + time/60 + "\n Level: " + level, 40, Color.WHITE, new Color (0,0,0,0)));
    }
    public void act()
    {
        time++;
        setImage(new GreenfootImage("Your Score: " + score + "\n Your Cash: " + money + "\n Time: " + time/60 + "\n Level: " + level, 40, Color.WHITE, new Color (0,0,0,0)));
        if((time/60) >= 120 && (time/60) < 240) //following code will check the time and change the level of the game
        {
            level = 2;
        }
        if((time/60) >= 240 && (time/60) < 360)
        {
            level = 3;
        }
        if((time/60) == 360) //after 6 minutes, game will end and the message will appear on the screen
        {
            getWorld().showText("Congratulations, You Win!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop(); // this will stop the game
        }
    }
}
