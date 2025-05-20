import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Two here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Two extends Actor
{    
    public Two()
    {
        setImage("images/twoBlock.png");
    }
    
    public void act()
    {
        // setLocation(getX(), getY()+-1);  for up and down
        
        if(isTouching(Two.class))
        {
            removeTouching(Two.class);
            MyWorld world = (MyWorld) getWorld();
        }
    }
}
