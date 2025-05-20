import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Four here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Four extends Actor
{
    public Four()
    {
        setImage("images/fourBlock.png");
    }
    
    //When moving four block gets summoned
    public void act()
    {
        //if(greenfoot.isKeydown("left")
        
        //Merging 4 blocks
        if(isTouching(Four.class))
        {
            removeTouching(Four.class);
            MyWorld world = (MyWorld) getWorld();
        }
            
    }
}
