import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Block extends Actor
{    
    private int value;
    
    public static int score = 0; 
    public static boolean goUp = false;
    public static boolean goDown = false;
    public static boolean goLeft = false; 
    public static boolean goRight = false;
        
    public Block(int value)
    {
        this.value = value;
        
        setImage(new GreenfootImage("images/_" + value + ".png"));
        getImage().scale(110, 110);
    }
    
    public void act()
    {   MyWorld world = (MyWorld) getWorld();
    
        //merge another block that interects this one
        Block otherBlock = (Block)getOneIntersectingObject(Block.class);
        if (otherBlock != null && this.getValue() == otherBlock.getValue())
        {
            merge(otherBlock);
        }
        
        if (getValue() == 2048)
        {
            world.win = true;
        }
    }
    
    public int getValue()
    {
        return value;
    }

    public void merge(Block block)
    {
        MyWorld world = (MyWorld) getWorld();
        
        int topValue = this.value;
        int bottomValue = block.value;
        
        if(topValue != bottomValue)
        {
            return;
        }
        
        int xBlock = block.getX();
        int yBlock = block.getY();
        
        int xGrid = (this.getX() - 70) / 120;
        int yGrid = (this.getY() - 70) / 120;
        
        //remove both blocks form the world and grid
        world.grid[xGrid][yGrid] = null;
        world.removeObject(block); 
        
        
        //create the new merged block
        int mergeValue = (topValue!= 2048) ? topValue + bottomValue : topValue;
        Block newBlock = new Block(mergeValue);
        world.addObject(newBlock, xBlock, yBlock);
        world.grid[(xBlock - 70) / 120][(yBlock - 70) / 120] = null;
        
        score += mergeValue;
        world.removeObject(this);
    }
    
    public void moveUp()
    { 
        MyWorld world = (MyWorld) getWorld();
        
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        if (getY() > 70)
        {
            //clear the current location on the grid
            world.grid[xGrid][yGrid] = null;
            
            setLocation(getX(), getY() - 120);
            
            //update the new grid positons after moving
            xGrid = (getX() - 70) / 120;
            yGrid = (getY() - 70) / 120;
            world.grid[xGrid][yGrid] = this;
        }
    }
    
    public void moveDown()
    {     
        MyWorld world = (MyWorld) getWorld();
        
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if (getY() < 430)
        {   
            world.grid[xGrid][yGrid] = null;
            
            setLocation(getX(), getY() + 120);
            
            xGrid = (getX() - 70) / 120;
            yGrid = (getY() - 70) / 120;
            world.grid[xGrid][yGrid] = this;
        }
    }
    
    public void moveLeft()
    {      
        MyWorld world = (MyWorld) getWorld();
        
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if (getX() > 70)
        {
            world.grid[xGrid][yGrid] = null;
            
            setLocation(getX() - 120, getY());
            
            xGrid = (getX() - 70) / 120;
            yGrid = (getY() - 70) / 120;
            world.grid[xGrid][yGrid] = this;
        }
    }
    
    public void moveRight()
    {  
        MyWorld world = (MyWorld) getWorld();
        // Get the middle spot of the current block
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
    
        if(getX() >= 430)
        {
            return;
        } else if (world.grid[xGrid + 1][yGrid] != null)
        {
            // Check if block exists to the right, if so, merge correctly
            if (world.grid[xGrid + 1][yGrid].getValue() == this.getValue())
            {
                world.grid[xGrid][yGrid] = null;
                setLocation(getX() + 120, getY());
                world.grid[xGrid + 1][yGrid] = this;
            }
            else
            {
                return;
            }
        } else
        {
            world.grid[xGrid][yGrid] = null; // the old position of the block
            setLocation(getX() + 120, getY());
            world.grid[xGrid + 1][yGrid] = this;
        }
    }
}
