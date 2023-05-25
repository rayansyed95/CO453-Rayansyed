import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The health bar at the top of the player is controlled in this class
 * 
 * @authors James Patrick Arellano 
 * @2.0
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 50;
    public HealthBar() //this funtion designs the health bar
    {
         setImage(new GreenfootImage(52,12));
         getImage().drawRect(0,0,51,11);
         getImage().setColor(Color.RED);
         getImage().fillRect(1,1,health,10);
    }
    public void act()
    {
        setImage(new GreenfootImage(52,12));
         getImage().drawRect(0,0,51,11);
         getImage().setColor(Color.RED);
         getImage().fillRect(1,1,health,10);
         World world = getWorld();
         MyWorld myWorld = (MyWorld)world;
         setLocation(myWorld.getPlayer().getX()-5, myWorld.getPlayer().getY()-50); 
         loseHealth();
    }
    public void loseHealth() //this function will decrease the health when we are hit by the zombies
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if(myWorld.getPlayer().hitByZombie())
        {
            health--; //everytime we are hit by the zombies, our get status is reduced
        }
        if(health<=0){ //if health gets to zero then we lose
            getWorld().showText("You Lose! \n You survived for " + (myWorld.getPlayer().time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.playSound("sounds/you-lose.mp3");
            Greenfoot.stop();
        }
    }
}
