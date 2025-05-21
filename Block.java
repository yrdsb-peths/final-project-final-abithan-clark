import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    public int val;
    
    public Block(int val)
    {
        this.val = val;
        
        if (val == 2)
        {
            setImage("images/two.png");
        }
        if (val == 4)
        {
            setImage("images/four.png");
        }
        if (val == 8)
        {
            setImage("images/eight.png");
        }
        if (val == 16)
        {
            setImage("images/sixteen.png");
        }
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public int getVal()
    {
        return this.val;
    }
    
    public void merge2()
    {
        
    }
}
