import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is for the Background Music of the game
 * 
 * @authors Rayan Yousuf Syed & James Ptrick Arellano 
 * @1.0
 */
public class BackgroundMusic extends Actor
{
    private GreenfootSound sound;
    
    public BackgroundMusic()
    {
        sound = new GreenfootSound("sounds/back-sound.mp3"); // Replace "your_music_file.mp3" with the actual file name and extension
    }
    
    public void addedToWorld(World world)
    {
        sound.play();
    }
    
    public void act()
    {
        if (!sound.isPlaying())
        {
            sound.play();
        }
    }
}