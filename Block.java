import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Block extends Actor
{    
    public static int value;
    public static int score = 0; 

    public static boolean goUp = false;
    public static boolean goDown = false;
    public static boolean goLeft = false; 
    public static boolean goRight = false;
        
    public Block(int value)
    {
        this.value = value;
        
        GreenfootImage img = new GreenfootImage("images/_" + value + ".png");
        img.scale(110, 110);
        setImage(img);
    }
    
    public void act()
    {   MyWorld world = (MyWorld) getWorld();
        
        if (goUp == true)
        {
            moveUp();
        }
        
        if (goDown == true)
        {
            moveDown();
        }
        
        if (goLeft == true)
        {
            moveLeft();
        }
        
        if (goRight == true)
        {
            moveRight();
        }
    
        //merge another block that interects this one
        Actor other = getOneIntersectingObject(Block.class);
        Block otherBlock = (Block) other;
        if (other != null)
        {
            merge(otherBlock);
        }
    }
    
    public void merge(Block block)
    {
        int topValue = this.value;
        int bottomValue = block.value;
        
        if(topValue != bottomValue)
        {
            return;
        }
        
        score += (topValue + bottomValue);
        
        int x = block.getX();
        int y = block.getY();
        
        //remove merging blocks
        getWorld().removeObject(block); 
        
        //create the new merged block
        int mergeValue = (topValue!= 2048) ? topValue + bottomValue : topValue;
        Block newBlock = new Block(mergeValue);
        getWorld().addObject(newBlock, x, y);
        
        getWorld().removeObject(this);
    }
    
    public void moveUp()
    {   
        MyWorld world = (MyWorld) getWorld();
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if (getY() > 70)
        {
            //clear the current location on the grid
            world.grid[xGrid][yGrid] = 0;
            
            setLocation(getX(), getY() - 120);
            
            //update the new grid positons after moving
            xGrid = (getX() - 70) / 120;
            yGrid = (getY() - 70) / 120;
            world.grid[xGrid][yGrid] = 1;
        }
    }
    
    public void moveDown()
    {   
        MyWorld world = (MyWorld) getWorld();
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if (getY() < 430)
        {   
            world.grid[xGrid][yGrid] = 0;
            
            setLocation(getX(), getY() + 120);
            
            xGrid = (getX() - 70) / 120;
            yGrid = (getY() - 70) / 120;
            world.grid[xGrid][yGrid] = 1;
        }
    }
    
    public void moveLeft()
    {        
        MyWorld world = (MyWorld) getWorld();
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if (getX() > 70)
        {
            world.grid[xGrid][yGrid] = 0;
            
            setLocation(getX() - 120, getY());
            
            xGrid = (getX() - 70) / 120;
            yGrid = (getY() - 70) / 120;
            world.grid[xGrid][yGrid] = 1;
        }
    }
    
    public void moveRight()
    {      
        MyWorld world = (MyWorld) getWorld();
        // Get the middle spot of the current block
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if(getX() >= 430) {
            return;
        } else if (..){
            // Check if block exists to the right, if so, merge correctly
            
        } else {
       
            world.grid[xGrid][yGrid] = null; // the old position of the block
            
            setLocation(getX() + 120, getY());
            
            xGrid = (getX() - 70) / 120;
            yGrid = (getY() - 70) / 120;
            world.grid[xGrid][yGrid] = this;
        } 
    }
    
    
}
