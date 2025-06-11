import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The button to close labels
 * 
 * @author Abithan Paskaranathan
 * @version June 8, 2025
 */
public class X extends Actor
{
    /**
     * Constructor - runs when an object is created
     */
    public X()
    {
        GreenfootImage x = new GreenfootImage("images/X.png");
        x.scale(30, 30);
        setImage(x);
    }
    
    public void act()
    {
        //Removes the entire message (Grey background and label) when 
        //an X instance is clicked
        
        MyWorld world = (MyWorld) getWorld();
        
        //Since the order of objects added is Bg, label and X, it removes
        //the Label class it touches and then the same for Bg, then itself.
        if (Greenfoot.mouseClicked(this) && isTouching(Label.class))
        {
            removeTouching(Label.class);
            removeTouching(TextBg.class);
            world.removeObject(this);
        }
    }
}
