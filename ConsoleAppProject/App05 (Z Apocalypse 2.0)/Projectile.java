import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the projectiles fired by the Player. It is responsible for its own movement and interactions with other game objects.
 * 
 * @authors Rayan Syed 
 * @2.0
 */
public class Projectile extends Actor
{
    public Projectile() //designing projectile
    {
        setImage(new GreenfootImage(10, 2));
        getImage().setColor(Color.YELLOW);
        getImage().fillRect(0,0,10,2);
    }
    
    public void act() //removing projectile if they hit the edge of screen.
    {
        move(20);
        if(isAtEdge() || getOneIntersectingObject(Obstacle.class) != null)
        {
            getWorld().removeObject(this);
        }
    }
}
