import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the Player in the game. It is responsible for player movement, shooting and interactions with other game objects.
 * 
 * @authors Rayan Syed 
 * @2.0
 */
public class Player extends Actor
{
    int speed = 4; //speed of projectile
    int time = 0;
    WeaponButton weaponButton;
    boolean isFiring = false;

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
        checkMouseButton();
        if(isFiring){
            fireProjectile();
        }
        hitByZombie();
    }

    public void turnAround() //this is the function which will turn the zombies towards player
    {
        if(Greenfoot.getMouseInfo() != null)
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }

    public void moveAround() //this function will move the player
    {
        if(Greenfoot.isKeyDown("w") && getOneObjectAtOffset(0, -speed, Obstacle.class) == null)
            setLocation(getX(), getY() - speed);
        if(Greenfoot.isKeyDown("a") && getOneObjectAtOffset(-speed, 0, Obstacle.class) == null)
            setLocation(getX() - speed, getY());
        if(Greenfoot.isKeyDown("s") && getOneObjectAtOffset(0, speed, Obstacle.class) == null)
            setLocation(getX(), getY() + speed);
        if(Greenfoot.isKeyDown("d") && getOneObjectAtOffset(speed, 0, Obstacle.class) == null)
            setLocation(getX() + speed, getY());
    }

    public void checkMouseButton() //checks if the mouse button is being pressed
    {
        if(Greenfoot.mousePressed(null)) {
            isFiring = true;
        }
        if(Greenfoot.mouseClicked(null)) {
            isFiring = false;
        }
    }
    
    public void fireProjectile() //function which will fire projectiles based on weaponUpgrade value, each value represents the number of firing projectiles
    {
        if(isFiring && weaponButton.weaponUpgrade == 1) {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            projectile.move(25);
            Greenfoot.playSound("sounds/fire.mp3");
        }
        if(isFiring && weaponButton.weaponUpgrade == 2) {
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
        if(isFiring && weaponButton.weaponUpgrade == 3) {
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

