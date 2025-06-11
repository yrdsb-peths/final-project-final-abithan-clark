import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the individual blocks
 * 
 * @author Abithan Paskaranathan and Clark Chen 
 * @version June 7, 2025
 */

public class Block extends Actor
{    
    private int value;
 
    public static int score = 0;
    /**
     * Constructor - gets run when an object is created.
     * 
     * @param value the individual value of the blocks
     */
    
    public Block(int value)
    {
        this.value = value;
        
        //all block images are labeled "_number.png"
        setImage(new GreenfootImage("images/_" + value + ".png"));
        getImage().scale(110, 110);
    }
    
    public void act()
    {   MyWorld world = (MyWorld) getWorld();
        
        //constantly checks these conditions
        if (getValue() == 2048)
        {
            world.win = true;
        }
        
        if(getValue() == 256) 
        {
            world.hardMode = true;
        }
        
        if(getValue() == 512)
        {
            world.insaneMode = true; 
        }
    }
    
    
    /**
     * Getter method
     * 
     * @return the value of the block
     */
    public int getValue()
    {
        return value;
    }
    
    
    /**
     * Merges two blocks of the same value and creates a new one with the sum of both
     * 
     * @param block the block that is merged by another
     */
    public void merge(Block block)
    {
        MyWorld world = (MyWorld) getWorld();
        
        int topValue = this.value;
        int bottomValue = block.value;
        
        //return if the two blocks are a different value 
        if(topValue != bottomValue)
        {
            return;
        }
        
        //position of the other block 
        int xBlock = block.getX();
        int yBlock = block.getY();
            
        //grid position of this block
        int xGrid = (this.getX() - 70) / 120;
        int yGrid = (this.getY() - 70) / 120;
        
        //remove both blocks from the world and this block from the grid
        world.grid[xGrid][yGrid] = null;
        world.removeObject(this);
        world.removeObject(block);
        
        //create the new merged block at block's (parameter) old position 
        int mergeValue = (topValue!= 2048) ? topValue + bottomValue : topValue;
        Block newBlock = new Block(mergeValue);
        world.addObject(newBlock, xBlock, yBlock);
        world.grid[(xBlock - 70) / 120][(yBlock - 70) / 120] = newBlock;
        
        //increases score by the value of the merged block
        score += mergeValue;
        
        //add the animated boom object 
        Boom boom = new Boom();
        world.addObject(boom, xBlock, yBlock);
    }
    
    
    /**
     * All four below - moves the block in the specified direction
     */
    public void moveUp()
    { 
        MyWorld world = (MyWorld) getWorld();
        
        //the position of the block in the 2d grid
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        //returns if this block is at the top row or higher
        if (yGrid <= 0)
        {
            return;
        }
        
        //the block above this one
        Block upBlock = world.grid[xGrid][yGrid - 1];
        if (upBlock != null)
        {
            // Check if a block exists above
            if (upBlock.getValue() == this.getValue())
            {
                //update the grid position
                world.grid[xGrid][yGrid] = null;
                setLocation(getX(), getY() - 120);
                world.grid[xGrid][yGrid - 1] = this;
                
                //merge the block above since up would be pressed
                merge(upBlock);    
            }
        } else
        {
            //update the grid position
            world.grid[xGrid][yGrid] = null;
            setLocation(getX(), getY() - 120);
            world.grid[xGrid][yGrid - 1] = this;
        }
    }
    
    public void moveDown()
    {     
        MyWorld world = (MyWorld) getWorld();
        
        //the position of the block in the 2d grid
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        //return if this block is at the bottom row or lower
        if (yGrid >= 3)
        {
            return;
        }
        
        //the block below this one
        Block downBlock = world.grid[xGrid][yGrid + 1];
        if (downBlock != null)
        {
            // Check if block exists below
            if (downBlock.getValue() == this.getValue())
            {
                //update the grid position
                world.grid[xGrid][yGrid] = null;
                setLocation(getX(), getY() + 120);
                world.grid[xGrid][yGrid + 1] = this;
                
                //merge the block below since down would be pressed
                merge(downBlock);    
            }
        } else
        {
            //update the grid position
            world.grid[xGrid][yGrid] = null;
            setLocation(getX(), getY() + 120);
            world.grid[xGrid][yGrid + 1] = this;
        }
    }
    
    public void moveLeft()
    {      
        MyWorld world = (MyWorld) getWorld();
        
        //the position of the block in the 2d grid
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        //return if the block is at the leftmost column or further left
        if (xGrid <= 0)
        {
            return;
        }
        
        //the block on the left of this one
        Block leftBlock = world.grid[xGrid - 1][yGrid];
        if (leftBlock != null)
        {
            // Check if block exists to the left
            if (leftBlock.getValue() == this.getValue())
            {
                //update the grid position
                world.grid[xGrid][yGrid] = null;
                setLocation(getX() - 120, getY());
                world.grid[xGrid - 1][yGrid] = this;
                
                //merge the block on the left since left would be pressed
                merge(leftBlock);
            }
        } else
        {
            //update the grid position
            world.grid[xGrid][yGrid] = null; 
            setLocation(getX() - 120, getY());
            world.grid[xGrid - 1][yGrid] = this;
        }
    }
    
    public void moveRight()
    {  
        MyWorld world = (MyWorld) getWorld();
        
        //the position of the block in the 2d grid
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        //return if the block is at the rightmost column or further right
        if (xGrid >= 3)
        {
            return;
        }
        
        //the block on the right of this one
        Block rightBlock = world.grid[xGrid + 1][yGrid];
        if (rightBlock != null)
        {
            // Check if block exists to the right
            if (rightBlock.getValue() == this.getValue())
            {
                //update the grid position
                world.grid[xGrid][yGrid] = null;
                setLocation(getX() + 120, getY());
                world.grid[xGrid + 1][yGrid] = this;

                //merge the block on the right since right would be pressed
                merge(rightBlock);
            }
        } else
        {
            //update the grid position
            world.grid[xGrid][yGrid] = null; 
            setLocation(getX() + 120, getY());
            world.grid[xGrid + 1][yGrid] = this;
        }
    }
}
