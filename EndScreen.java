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
    
    /**
     * Constructor - runs when all spots are filled by blocks
     */
    public EndScreen()
    {    
        super(600, 400, 1); 
        
        setBackground("images/endscreen.jpg");
        
        //Makes sure the button doesn't delay
        Greenfoot.setSpeed(60);
        
        addObject(endLabel, 300, 100);   // shows that  you lost
        addObject(restart, 300, 325);    //shows the option to restart
        addObject(scoreLabel, 300, 225); //shows score
        
        //reset score
        Block.score = 0;
    }
    
    public void act()
    {
        //sets the current world back to MyWorld
        if(Greenfoot.mouseClicked(restart))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld); 
        }
    }
}
