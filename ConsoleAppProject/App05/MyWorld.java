import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class sets the main world for the game
 * 
 * @authors Rayan Yousuf Syed & James Patrick Arellano 
 * @1.0
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    //initializing important variables
    int count = 0;
    int spawnSpeed = 50; //small value will increase spawn speed
    int randomSpawn;
    //all of these will be player's main attributes
    public Player mainPlayer = new Player();
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    WeaponButton weaponButton = new WeaponButton(counter);
    
    public MyWorld()
    {    
        // Create a new world with 1000x800 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        mainPlayer = new Player(weaponButton); 
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        addObject(counter, 130, 100); 
        addObject(healthbar, mainPlayer.getX(), mainPlayer.getY() - 50);
        addObject(weaponButton, 900, 100);
        BackgroundMusic backgroundMusic = new BackgroundMusic();
        addObject(backgroundMusic, getWidth() / 2, getHeight() / 2);
        prepare();
        //above lines add different objects on the world screen
    }
    private void prepare() {
        // Create instances of the fixed object classes and add them to the world
        Wall wall1 = new Wall();
        addObject(wall1, 100, 300);
        Wall wall2 = new Wall();
        addObject(wall2, 200, 300);
        
        Tree tree1 = new Tree();
        addObject(tree1, 600, 350);
        Tree tree2 = new Tree();
        addObject(tree2, 600, 450);

        Rock rock1 = new Rock();
        addObject(rock1, 700, 700);
        Rock rock2 = new Rock();
        addObject(rock2, 800, 700);
    }
    public Player getPlayer() //function to call the player
    {
        return mainPlayer;
    }
    public void act() //these lines of code will be our actual acts on screen
    {
        count++;
        //below lines will check change the spawnSpeed based on timing
        if((count/60) >= 120 && (count/60) < 240)
        {
            spawnSpeed = 30;
        }
        if((count/60) >= 240 && (count/60) < 360)
        {
            spawnSpeed = 15;
        }
        SpawnZombies(); 
    }
    public void SpawnZombies() //this is the function that generates zombies
    {
        if (count % spawnSpeed == 0)
       {
           randomSpawn = Greenfoot.getRandomNumber(8);
           switch(randomSpawn){ //zombies will come from 8 different positions on the screen but randomly
               case 0 : addObject(new Zombie(mainPlayer,counter), 0, 0); break;
               case 1 : addObject(new Zombie(mainPlayer,counter), getWidth()/2, 0); break;
               case 2 : addObject(new Zombie(mainPlayer,counter), getWidth(), 0); break;
               case 3 : addObject(new Zombie(mainPlayer,counter), 0, getHeight()/2); break;
               case 4 : addObject(new Zombie(mainPlayer,counter), getWidth(), getHeight()/2); break;
               case 5 : addObject(new Zombie(mainPlayer,counter), 0, getHeight()); break;
               case 6 : addObject(new Zombie(mainPlayer,counter), getWidth()/2, getHeight()); break;
               case 7 : addObject(new Zombie(mainPlayer,counter), getWidth(), getHeight()); break;
            
           }
       }
    }
}
