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
        
        if (goUp == true)
        {
            moveUp();
        }
        else if (goDown == true)
        {
            moveDown();
        }
        else if (goLeft == true)
        {
            moveLeft();
        }
        else if (goRight == true)
        {
            moveRight();
        }
    
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
        int xThis = this.getX();
        int yThis = this.getY();
        
        //remove both blocks form the world and grid
        world.grid[(xThis - 70 / 120)][(yThis - 70) / 120] = 0;
        getWorld().removeObject(block); 
        getWorld().removeObject(this);
        
        //create the new merged block
        int mergeValue = (topValue!= 2048) ? topValue + bottomValue : topValue;
        Block newBlock = new Block(mergeValue);
        getWorld().addObject(newBlock, xBlock, yBlock);
        world.grid[(xBlock - 70 / 120)][(yBlock - 70) / 120] = 0;
        
        score += mergeValue;
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
        int xGrid = (getX() - 70) / 120;
        int yGrid = (getY() - 70) / 120;
        
        if (getX() < 430)
        {
            world.grid[xGrid][yGrid] = 0;
            
            setLocation(getX() + 120, getY());
            
            xGrid = (getX() - 70) / 120;
            yGrid = (getY() - 70) / 120;
            world.grid[xGrid][yGrid] = 1;
        }
    }
}
