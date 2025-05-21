import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Block extends Actor
{
    public int value;
    
    public Block(int value)
    {
        this.value = value;
        
        if (value == 2)
        {
            setImage("images/two.png");
        }
        if (value == 4)
        {
            setImage("images/four.png");
        }
        if (value == 8)
        {
            setImage("images/eight.png");
        }
        if (value == 16)
        {
            setImage("images/sixteen.png");
        }
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void merge(Block block)
    {
        int topValue = this.value;
        int bottomValue = block.value;
        if(topValue != bottomValue) {
            return;
        }
        
        int x = block.getX();
        int y = block.getY();
        getWorld().removeObject(block); // remove bottom block
        Block newBlock = new Block(topValue + bottomValue);
        getWorld().addObject(newBlock, x, y);
        
        getWorld().removeObject(this);
    }
}
