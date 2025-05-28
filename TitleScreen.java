import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
