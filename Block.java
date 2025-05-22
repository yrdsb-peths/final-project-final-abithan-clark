import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Block extends Actor
{
    public int value;
    public static boolean goUp = false;
    public static boolean goDown = false;
    
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
        //lets the block move down when this variable is set to true
        if (goUp == true)
        { 
            moveUp();
        }
        
        if (goDown == true)
        {
            moveDown();
        }
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
        
        getWorld().removeObject(this); //remove current instance 
    }
    
    public void moveUp()
    {
        //makes sure the block 
        if (getY() > 70)
        {
            setLocation(getX(), getY() - 120);
        }
        else
        {
            return;
        }
    }
    
    public void moveDown()
    {
        if (getY() >= 430)
        {
            return;
        }
    
        //gets the block object at the specified position
        //returns null if no block object found
        Actor bottom = getOneObjectAtOffset(this.getX(), this.getY() -120, Block.class);
        
        if (bottom != null)
        {
            Block bottBlock = (Block) bottom;
            if (bottBlock.value == this.value)
            {
                merge(bottBlock);
            }
            else
            {
                return;
            }
        }
        
        setLocation(getX(), getY() + 120);
    }
}
