import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the zombies in the game. Zombies move around the game world, target the player, and interact with other game objects like Projectiles and Obstacles.
 * 
 * @author Rayan Yousuf Syed
 * @version 2.0
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Zombie extends Actor
{
    int health = 10; 
    Player player;
    Counter counter;
    private int moveCount = 0;
    private int randomDirection = 0;
    
    public Zombie(Player mainPlayer, Counter counter)
    {
        this.counter = counter;
        player = mainPlayer;
        setImage("skull.png");
        getImage().scale(35,35);
    }
    
    public void act()
    {
        moveAround();
        hitByProjectile();
    }
    
    public void moveAround()
    {
        move(1);
        Actor obstacle = getOneIntersectingObject(Obstacle.class);
        if(obstacle != null)
        {
            if(moveCount <= 0)
            {
                randomDirection = Greenfoot.getRandomNumber(360);
                moveCount = 50;
            }
            setRotation(randomDirection);
            moveCount--;
        }
        else
        {
            turnTowards(player.getX(), player.getY());
        }
    }
    
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        if(health == 0)
        {
            counter.score++; 
            counter.money+=2;
            getWorld().removeObject(this);
        }
    }
}


