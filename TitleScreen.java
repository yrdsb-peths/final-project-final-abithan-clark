import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the title screen where you create a new game to play
 * 
 * @author Clark Chen 
 * @version June 7, 2025
 */
public class TitleScreen extends World
{
    Label startLabel = new Label("New game", 42);
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {      
        super(540, 318, 1); 
        setBackground("images/titlescreen.jpg");
        Greenfoot.setSpeed(60);
        
        addObject(startLabel, 405, 250);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(startLabel))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld); 
        }
    }
}
