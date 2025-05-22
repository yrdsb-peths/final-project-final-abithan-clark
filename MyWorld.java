//all images/colors from this website https://2048.ninja/

import greenfoot.*;

public class MyWorld extends World {
    Block two1;
    Block two2;
    
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    public MyWorld() {
        super(500, 500, 1);
        GreenfootImage bg = new GreenfootImage("images/background.png");
        bg.scale(500, 501);
        setBackground(bg);
                
        two1 = new Block(2);
        two2 = new Block(2);
        
        //creates two 2 blocks at a random position
        randPos();
    }
    
    //code is in act so it keeps checking for keypresses
    public void act() {
        if (Greenfoot.isKeyDown("up")) 
        {
            if (!upPressed) {
                Block.goUp = true;
                createNewBlocks();
                upPressed = true;
            }
        } else 
        {
            Block.goUp = false;
            upPressed = false;
        }
    
        if (Greenfoot.isKeyDown("down")) 
        {
            if (!downPressed) {
                Block.goDown = true;
                createNewBlocks();
                downPressed = true;
            }
        } else 
        {
            Block.goDown = false;
            downPressed = false;
        }
    
        if (Greenfoot.isKeyDown("left")) 
        {
            if (!leftPressed) {
                Block.goLeft = true;
                createNewBlocks();
                leftPressed = true;
            }
        } else 
        {
            Block.goLeft = false;
            leftPressed = false;
        }

        if (Greenfoot.isKeyDown("right")) {
            if (!rightPressed) {
                Block.goRight = true;
                createNewBlocks();
                rightPressed = true;
            }
        } else {
            Block.goRight = false;
            rightPressed = false;
        }
    }
    
    public void randPos()
    {
        //random position for one random spawning two block
        int randX1 = Greenfoot.getRandomNumber(4);
        int randY1 = Greenfoot.getRandomNumber(4);
        int x1 = 70 + (randX1 * 120);  //+120 it the position of the next empty square
        int y1 = 70 + (randY1 * 120);
        
        //random position for the other random spawning two block
        int randX2 = Greenfoot.getRandomNumber(4);
        int randY2 = Greenfoot.getRandomNumber(4);
        int x2 = 70 + (randX2 * 120);
        int y2 = 70 + (randY2 * 120);
        
        //prevents the two blocks from spawing on eachother
        while (randX1 == randX2 && randY1 == randY2)
        {
            randX2 = Greenfoot.getRandomNumber(4);
            randY2 = Greenfoot.getRandomNumber(4);
            x2 = 70 + (randX2 * 120);
            y2 = 70 + (randY2 * 120);
        }
        
        addObject(two1, x1, y1);
        addObject(two2, x2, y2);
    } 
    
    //for creating new blocks when any of the arrow keys are pressed
    public void createNewBlocks()
    {
        int randX = Greenfoot.getRandomNumber(4);
        int randY = Greenfoot.getRandomNumber(4);
        int x = 70 + (randX * 120);
        int y = 70 + (randY * 120);
            
        //randomizes whether to create a new 2 or 4(5% chance)
        int twoOrFour = Greenfoot.getRandomNumber(6);
        if (twoOrFour == 1)
        {
            Block four = new Block(4);
            addObject(four, x, y);
        }
        else
        {
            Block two = new Block(2);
            addObject(two, x, y);
        }
    }
}
