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
    Label infoLabel = new Label("Instructions", 42);
    
    /**
     * Constructor - runs when the world starts
     */
    public TitleScreen()
    {      
        super(540, 318, 1); 
        
        setBackground("images/titlescreen.jpg");
        Greenfoot.setSpeed(60);
        
        addObject(startLabel, 405, 250);
        addObject(infoLabel, 405, 180);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(startLabel))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld); 
        }
        
        if(Greenfoot.mouseClicked(infoLabel))
        {
            InstructionScreen infoScreen = new InstructionScreen();
            Greenfoot.setWorld(infoScreen);
        }
    }
}
