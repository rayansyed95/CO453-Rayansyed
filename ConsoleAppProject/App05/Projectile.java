import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the projectile class
 * 
 * @authors Rayan Yousuf Syed & James Ptrick Arellano 
 * @1.0
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile() //designing projectile
    {
        setImage(new GreenfootImage(10, 2));
        getImage().setColor(Color.YELLOW);
        getImage().fillRect(0,0,10,2);
    }
    public void act() //removing projectile if they hit the edge of screen.
    {
        move(20);
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
