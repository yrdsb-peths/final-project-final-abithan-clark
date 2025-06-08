import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The button to close labels
 * 
 * @author Abithan Paskaranathan
 * @version June 8, 2025
 */
public class X extends Actor
{
    public X()
    {
        GreenfootImage x = new GreenfootImage("images/X.png");
        x.scale(30, 30);
        setImage(x);
    }
    
    public void act()
    {
        //removes the entire message (Grey background and label)
        //when an X instance is pressed
        
        MyWorld world = (MyWorld) getWorld();
        
        if (Greenfoot.mouseClicked(this) && isTouching(Label.class))
        {
            removeTouching(Label.class);
            removeTouching(TextBg.class);
            world.removeObject(this);
        }
    }
}
