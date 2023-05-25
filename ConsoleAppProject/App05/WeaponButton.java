import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents a button in the game interface that lets the player upgrade their weapon. It interacts with the Counter class to adjust the player's score and money.
 * 
 * @author Rayan Yousuf Syed
 * @version 2.0
 */
public class WeaponButton extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Counter counter;
    int weaponUpgrade = 1;
    public WeaponButton(Counter counter) //design of weaponUpgrade button
    {
        this.counter = counter;
        setImage("rocket.png");
        getImage().scale(100,100);
    }
    public void act() //function to check if we have clicked the upgrade weapon button and accordingly adjust the cash and increase firing projectiles
    {
        if (counter.money >= 149 && counter.money <= 169 && weaponUpgrade != 3)
        {
            Greenfoot.playSound("sounds/level-up.mp3");
        }

        if(Greenfoot.mousePressed(this) && counter.money > 149)
        {
            counter.money = counter.money - 150;
            weaponUpgrade++;
        }
        if(weaponUpgrade >= 3) //if already at level 3, then weapon upgrade button will disappear. 
        {
            getWorld().removeObject(this);
        }
       
    }
}
