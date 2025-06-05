import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Block extends Actor
{    
    private int value;

    public static int score = 0; 
        
    public Block(int value)
    {
        this.value = value;
        
        setImage(new GreenfootImage("images/_" + value + ".png"));
        getImage().scale(110, 110);
    }
    
    public void act()
    {   MyWorld world = (MyWorld) getWorld();
        
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
        world.removeObject(this);
        world.removeObject(block);
        
        //create the new merged block
        int mergeValue = (topValue!= 2048) ? topValue + bottomValue : topValue;
        Block newBlock = new Block(mergeValue);
        world.addObject(newBlock, xBlock, yBlock);
        world.grid[(xBlock - 70) / 120][(yBlock - 70) / 120] = newBlock;
        
        score += mergeValue;
        
        world.blockCanSpawn = true;
    }
    
    public void moveUp()
    { 
        MyWorld world = (MyWorld) getWorld();
        
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if (yGrid <= 0)
        {
            return;
        }
        
        Block upBlock = world.grid[xGrid][yGrid - 1];
        if (upBlock != null)
        {
            // Check if block exists to the left, if so, merge correctly
            if (upBlock.getValue() == this.getValue())
            {
                world.grid[xGrid][yGrid] = null;
                setLocation(getX(), getY() - 120);
                world.grid[xGrid][yGrid - 1] = this;
                
                merge(upBlock);    
                
                world.blockCanSpawn = true;
            }
        } else
        {
            world.grid[xGrid][yGrid] = null; // the old position of the block
            setLocation(getX(), getY() - 120);
            world.grid[xGrid][yGrid - 1] = this;
            
            world.blockCanSpawn = true;
        }
    }
    
    public void moveDown()
    {     
        MyWorld world = (MyWorld) getWorld();
        
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if (yGrid >= 3)
        {
            return;
        }
        
        Block downBlock = world.grid[xGrid][yGrid + 1];
        if (downBlock != null)
        {
            // Check if block exists to the left, if so, merge correctly
            if (downBlock.getValue() == this.getValue())
            {
                world.grid[xGrid][yGrid] = null;
                setLocation(getX(), getY() + 120);
                world.grid[xGrid][yGrid + 1] = this;
                
                merge(downBlock);    
                
                world.blockCanSpawn = true;
            }
        } else
        {
            world.grid[xGrid][yGrid] = null; // the old position of the block
            setLocation(getX(), getY() + 120);
            world.grid[xGrid][yGrid + 1] = this;
            
            world.blockCanSpawn = true;
        }
    }
    
    public void moveLeft()
    {      
        MyWorld world = (MyWorld) getWorld();
        
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if (xGrid <= 0)
        {
            return;
        }
        
        Block leftBlock = world.grid[xGrid - 1][yGrid];
        if (leftBlock != null)
        {
            // Check if block exists to the left, if so, merge correctly
            if (leftBlock.getValue() == this.getValue())
            {
                world.grid[xGrid][yGrid] = null;
                setLocation(getX() - 120, getY());
                world.grid[xGrid - 1][yGrid] = this;
                
                merge(leftBlock);    
                
                world.blockCanSpawn = true;
            }
        } else
        {
            world.grid[xGrid][yGrid] = null; // the old position of the block
            setLocation(getX() - 120, getY());
            world.grid[xGrid - 1][yGrid] = this;
            
            world.blockCanSpawn = true;
        }
    }
    
    public void moveRight()
    {  
        MyWorld world = (MyWorld) getWorld();
        // Get the middle spot of the current block
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if (xGrid >= 3)
        {
            return;
        }
        
        Block rightBlock = world.grid[xGrid + 1][yGrid];
        if (rightBlock != null)
        {
            // Check if block exists to the right, if so, merge correctly
            if (rightBlock.getValue() == this.getValue())
            {
                world.grid[xGrid][yGrid] = null;
                setLocation(getX() + 120, getY());
                world.grid[xGrid + 1][yGrid] = this;

                merge(rightBlock);    
            }
        } else
        {
            world.grid[xGrid][yGrid] = null; // the old position of the block
            setLocation(getX() + 120, getY());
            world.grid[xGrid + 1][yGrid] = this;
            
            world.blockCanSpawn = true;
        }
    }
}
