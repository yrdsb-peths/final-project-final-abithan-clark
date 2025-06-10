import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Explosion effect that apears when blocks merge
 * 
 * @author Abithan Paskaranthan
 * @version June 10, 2025
 */

public class Boom extends Actor
{
    GreenfootImage[] boom = new GreenfootImage[4];
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Boom()
    {
        for (int i = 0; i < boom.length; i++)
        {
            boom[i] = new GreenfootImage("images/mergeBoom/boom" + i + ".png");
        }
        
        animationTimer.mark();
        
        setImage(boom[0]);
    }
    
    /**
     * Animate the boom
     */
    
    int imageIndex = 0;
    public void animateBoom()
    {
        if (animationTimer.millisElapsed() < 50)
        {
            return;
        }
        
        animationTimer.mark();
        
        setImage(boom[imageIndex]);
        
        imageIndex += 1;
        
        if (imageIndex == 4)
        {
            getWorld().removeObject(this);
        }
    }
    
    public void act()
    {
        //Animate the boom
        animateBoom();
    }
}
