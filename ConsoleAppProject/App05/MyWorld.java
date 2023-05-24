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
        Wall wall12 = new Wall();
        addObject(wall12, 100, 400);
        Wall wall13 = new Wall();
        addObject(wall13, 100, 500);
        Wall wall14 = new Wall();
        addObject(wall14, 100, 600);
        Wall wall2 = new Wall();
        addObject(wall2, 200, 300);
        Wall wall3 = new Wall();
        addObject(wall3, 300, 300);
        Wall wall32 = new Wall();
        addObject(wall32, 300, 400);
        Wall wall33 = new Wall();
        addObject(wall33, 300, 500);
        Wall wall34 = new Wall();
        addObject(wall34, 300, 600);
        Wall wall4 = new Wall();
        addObject(wall4, 400, 300);
        Wall wall5 = new Wall();
        addObject(wall5, 500, 300);
        //add if needed, because its hiding the player
        //Wall wall52 = new Wall();
        //addObject(wall52, 500, 400);
        Wall wall53 = new Wall();
        addObject(wall53, 500, 500);
        Wall wall54 = new Wall();
        addObject(wall54, 500, 600);
        Wall wall6 = new Wall();
        addObject(wall6, 600, 300);
        Wall wall7 = new Wall();
        addObject(wall7, 700, 300);
        Wall wall72 = new Wall();
        addObject(wall72, 700, 400);
        Wall wall73 = new Wall();
        addObject(wall73, 700, 500);
        Wall wall74 = new Wall();
        addObject(wall74, 700, 600);
        Wall wall8 = new Wall();
        addObject(wall8, 800, 300);
        Wall wall9 = new Wall();
        addObject(wall9, 900, 300);
        Wall wall92 = new Wall();
        addObject(wall92, 900, 400);
        Wall wall93 = new Wall();
        addObject(wall93, 900, 500);
        Wall wall94 = new Wall();
        addObject(wall94, 900, 600);
        
        Tree tree1 = new Tree();
        addObject(tree1, 400, 400);
        Tree tree2 = new Tree();
        addObject(tree2, 400, 500);
        Tree tree3 = new Tree();
        addObject(tree3, 400, 600);
        Tree tree4 = new Tree();
        addObject(tree4, 600, 400);
        Tree tree5 = new Tree();
        addObject(tree5, 600, 500);
        Tree tree6 = new Tree();
        addObject(tree6, 600, 600);

        Rock rock1 = new Rock();
        addObject(rock1, 100, 700);
        Rock rock2 = new Rock();
        addObject(rock2, 200, 700);
        Rock rock3 = new Rock();
        addObject(rock3, 300, 700);
        Rock rock4 = new Rock();
        addObject(rock4, 400, 700);
        Rock rock5 = new Rock();
        addObject(rock5, 500, 700);
        Rock rock6 = new Rock();
        addObject(rock6, 600, 700);
        Rock rock7 = new Rock();
        addObject(rock7, 700, 700);
        Rock rock8 = new Rock();
        addObject(rock8, 800, 700);
        Rock rock9 = new Rock();
        addObject(rock9, 900, 700);
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
