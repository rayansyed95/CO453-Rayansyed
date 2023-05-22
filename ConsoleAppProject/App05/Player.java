 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is associated with the main player
 * 
 * @authors James Patrick Arellano
 * @1.0
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 4; //speed of projectile
    int time = 0;
    WeaponButton weaponButton;
    public Player()
    {
      
    }
    public Player(WeaponButton weaponButton) //this is for the upgrade of weapon
    {
        this.weaponButton = weaponButton;
    }
    public void act()
    {
    time++;
    turnAround();
    moveAround();
    fireProjectile();
    /*youLose(); */
    hitByZombie();
    }
    public void turnAround() //this is the function which will turn the zombies towards player
    {
    if(Greenfoot.getMouseInfo() != null)
    turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    public void moveAround() //this function will move the player
    {
    if(Greenfoot.isKeyDown("up"))
        setLocation(getX(),getY() - speed);
    if(Greenfoot.isKeyDown("left"))
        setLocation(getX() - speed, getY());
    if(Greenfoot.isKeyDown("down"))
        setLocation(getX(),getY() + speed);
    if(Greenfoot.isKeyDown("right"))
        setLocation(getX() + speed, getY());
    }
    public void fireProjectile() //function which will fire projectiles based on weaponUpgrade value, each value represents the number of firing projectiles
    {
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 1) {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            projectile.move(25);
            Greenfoot.playSound("sounds/fire.mp3");
            }
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 2) {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation()-5);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation()+5);
            projectile2.move(20);
            Greenfoot.playSound("sounds/fire.mp3");
            }
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 3) {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation()-10);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation()+10);
            projectile2.move(20);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            Greenfoot.playSound("sounds/fire.mp3");
            }
    }
    public boolean hitByZombie() //this function will check are we hit by zombies?
    {
        Actor zombie = getOneObjectAtOffset(0,0,Zombie.class);
        if(zombie!=null)
        {
            Greenfoot.playSound("sounds/zombie.mp3");
            return true;
        }
        else
        return false;
    }
    
}
