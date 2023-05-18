import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is for the weapons upgrade
 * 
 * @authors Rayan Yousuf Syed & James Ptrick Arellano 
 * @1.0
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
        getImage().scale(50,50);
    }
    public void act() //function to check if we have clicked the upgrade weapon button and accordingly adjust the cash and increase firing projectiles
    {
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
