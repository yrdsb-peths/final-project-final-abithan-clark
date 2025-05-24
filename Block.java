import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Block extends Actor
{
    public int value;
    
    boolean overlap = false;
    
    public static boolean goUp = false;
    public static boolean goDown = false;
    public static boolean goLeft = false; 
    public static boolean goRight = false;
    
    public Block(int value)
    {
        this.value = value;
        
        if (value == 2)
        {
            GreenfootImage img = new GreenfootImage("images/_2.png");
            img.scale(110, 110);
            setImage(img);
        }
        if (value == 4)
        {
            GreenfootImage img = new GreenfootImage("images/_4.png");
            img.scale(110, 110);
            setImage(img);
        }
        if (value == 8)
        {
            GreenfootImage img = new GreenfootImage("images/_8.png");
            img.scale(110, 110);
            setImage(img);
        }
        if (value == 16)
        {
            GreenfootImage img = new GreenfootImage("images/_16.png");
            img.scale(110, 110);
            setImage(img);
        }
        if (value == 32)
        {
            GreenfootImage img = new GreenfootImage("images/_32.png");
            img.scale(110, 110);
            setImage(img);
        }
        if (value == 64)
        {
            GreenfootImage img = new GreenfootImage("images/_64.png");
            img.scale(110, 110);
            setImage(img);
        }
        if (value == 128)
        {
            GreenfootImage img = new GreenfootImage("images/_128.png");
            img.scale(110, 110);
            setImage(img);
        }
        if (value == 256)
        {
            GreenfootImage img = new GreenfootImage("images/_256.png");
            img.scale(110, 110);
            setImage(img);
        }
        if (value == 512)
        {
            GreenfootImage img = new GreenfootImage("images/_512.png");
            img.scale(110, 110);
            setImage(img);
        }
        if (value == 1024)
        {
            GreenfootImage img = new GreenfootImage("images/_1024.png");
            img.scale(110, 110);
            setImage(img);
        }
        if (value == 2048)
        {
            GreenfootImage img = new GreenfootImage("images/_2048.png");
            img.scale(110, 110);
            setImage(img);
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
        
        int x = block.getX();
        int y = block.getY();
        
        // remove merging blocks
        getWorld().removeObject(block); 
        
        //create the new merged block
        Block newBlock = new Block(topValue + bottomValue);
        getWorld().addObject(newBlock, x, y);
        
        getWorld().removeObject(this);
    }
    
    public void moveUp()
    {        
        if (getY() > 70)
        {
            setLocation(getX(), getY() - 120);
        }
    }
    
    public void moveDown()
    {        
        if (getY() < 430)
        {
            setLocation(getX(), getY() + 120);
        }
    }
    
    public void moveLeft()
    {        
        if (getX() > 70)
        {
            setLocation(getX() - 120, getY());
        }
    }
    
    public void moveRight()
    {        
        if (getX() < 430)
        {
            setLocation(getX() + 120, getY());
        }
    }
}
