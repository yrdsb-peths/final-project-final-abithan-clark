import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    Label endLabel = new Label("You lose", 100);
    Label restart = new Label("try again", 50);
    public EndScreen()
    {    
        super(600, 400, 1); 
        
        setBackground("images/endscreen.jpg");
        
        //add score to endscreen
        addObject(endLabel, 300, 150);
        addObject(restart, 300, 250);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(restart))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld); 
        }
    }
}
