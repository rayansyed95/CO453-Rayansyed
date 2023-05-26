import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the primary game world where all the game objects exist.
 * This class initializes the game objects and sets up the world. 
 * @authors James Patrick Arellano & Rayan Syed 
 * @2.0
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
        addObject(wall1, 123, 276);
        Wall wall2 = new Wall();
        addObject(wall2, 175, 276);
        Wall wall3 = new Wall();
        addObject(wall3, 228, 276);
        Wall wall4 = new Wall();
        addObject(wall4, 185, 584);
        Wall wall5 = new Wall();
        addObject(wall5, 402, 450);
        Wall wall6 = new Wall();
        addObject(wall6, 455, 450);
        Wall wall7 = new Wall();
        addObject(wall7, 508, 450);
        Wall wall8 = new Wall();
        addObject(wall8, 561, 450);
        Wall wall9 = new Wall();
        addObject(wall9, 614, 450);
        Wall wall10 = new Wall();
        addObject(wall10, 783, 278);
        Wall wall11 = new Wall();
        addObject(wall11, 836, 278);
        Wall wall12 = new Wall();
        addObject(wall12, 889, 277);
        Wall wall13 = new Wall();
        addObject(wall13, 849, 580);
        Wall wall14 = new Wall();
        addObject(wall14, 524, 136);
        Wall wall15 = new Wall();
        addObject(wall15, 519, 619);
        
        
        
        Tree tree1 = new Tree();
        addObject(tree1, 113, 223);
        Tree tree2 = new Tree();
        addObject(tree2, 161, 220);
        Tree tree3 = new Tree();
        addObject(tree3, 210, 223);
        Tree tree4 = new Tree();
        addObject(tree4, 519, 81);
        Tree tree5 = new Tree();
        addObject(tree5, 777, 225);
        Tree tree6 = new Tree();
        addObject(tree6, 830, 221);
        Tree tree7 = new Tree();
        addObject(tree7, 880, 222);
        Tree tree8 = new Tree();
        addObject(tree8, 395, 394);
        Tree tree9 = new Tree();
        addObject(tree9, 420, 392);
        Tree tree10 = new Tree();
        addObject(tree10, 580, 395);
        Tree tree11 = new Tree();
        addObject(tree11, 608, 395);
        Tree tree12 = new Tree();
        addObject(tree12, 162, 539);
        Tree tree13 = new Tree();
        addObject(tree13, 195, 540);
        
        Tree tree14 = new Tree();
        addObject(tree14, 513, 571);
        
        
        Tree tree15 = new Tree();
        addObject(tree15, 820, 534);
        Tree tree16 = new Tree();
        addObject(tree16, 855, 536);
        
        
        

        

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
