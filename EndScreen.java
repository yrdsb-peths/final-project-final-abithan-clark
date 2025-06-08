import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The endscreen after loosing(filling up your world withblocks)
 * 
 * @author Clark Chen 
 * @version June 7, 2025
 */
public class EndScreen extends World
{
    Label endLabel = new Label("You lose", 100);
    Label restart = new Label("try again", 50);
    Label scoreLabel = new Label("score: " + Block.score, 60);
    public EndScreen()
    {    
        super(600, 400, 1); 
        
        setBackground("images/endscreen.jpg");
        Greenfoot.setSpeed(60);
        
        addObject(scoreLabel, 300, 225);
        Block.score = 0;//reset score
        
        addObject(endLabel, 300, 100);
        addObject(restart, 300, 325);
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
