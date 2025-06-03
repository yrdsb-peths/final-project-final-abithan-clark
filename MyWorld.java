//all images/colors from this website https://2048.ninja/

import greenfoot.*;

public class MyWorld extends World {
    //use an int 2d arr to keep track of the grid
    public Block[][] grid = new Block[4][4];
    
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    
    public boolean win = false;
    public MyWorld() {
        super(500, 500, 1);
        GreenfootImage bg = new GreenfootImage("images/background.png");
        bg.scale(500, 501);
        setBackground(bg);
        //creates two random positioned 2 blocks
        randPos();
    }
    
    //code is in act so it keeps checking for keypresses
    public void act()
    {   
        if (Greenfoot.isKeyDown("up")) 
        {
            //makes sure blocks dont just instantly fill up the world
            if (!upPressed) {
                upPressed = true;
                createNewBlocks();
            }
        } else 
        {
            upPressed = false;
        }
    
        if (Greenfoot.isKeyDown("down")) 
        {
            if (!downPressed) {
                downPressed = true;
                createNewBlocks();
            }
        } else 
        {
            downPressed = false;
        }
    
        if (Greenfoot.isKeyDown("left")) 
        {
            if (!leftPressed) {
                leftPressed = true;
                createNewBlocks();
            }
        } else 
        {
            leftPressed = false;
        }

        if (Greenfoot.isKeyDown("right")) {
            if (!rightPressed) {
                // deal with rightmost blocks in the grid
                for (int x = 0; x < 4; x++)
                {
                    for (int y = 0; y < 4; y++)
                    {
                        if (grid[x][y] != null)
                        {
                            Block b = grid[x][y];
                            b.moveRight();
                        }
                    }
                }
                rightPressed = true;
                createNewBlocks();
                
            }
        } else {
            rightPressed = false;
        }
        
        if (win == true)
        {
            Label winnerLabel = new Label("You Win", 100);
            addObject(winnerLabel, 250, 250);
        }
    }
    
    public void randPos()
    {
        Block two1 = new Block(2);
        Block two2 = new Block(2);
        
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
        
        //1 means the block is occupied and 0 means its not
        grid[randX1][randY1] = two1;
        grid[randX2][randY2] = two2;
    } 
    
    public void createNewBlocks()
    {   
        //checking if the board is full
        int emptySpots = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (grid[i][j] == null)
                {
                    emptySpots++;
                }
            }
        }
        
        if (emptySpots == 0)
        {
            EndScreen endscreen = new EndScreen();
            Greenfoot.setWorld(endscreen); 
            return;
        }
        
        // Find a random empty spot
        int randSpot = Greenfoot.getRandomNumber(emptySpots);
        int count = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (grid[i][j] == null)
                {
                    if (count == randSpot)
                    {
                        //randomizes to create a new 2 or 4(5% chance)
                        int twoOrFour = Greenfoot.getRandomNumber(6);
                        Block block = (twoOrFour == 1) ? new Block(4) : new Block(2);
    
                        int x = 70 + (i * 120);
                        int y = 70 + (j * 120);
                        addObject(block, x, y);
                        grid[i][j] = block; // mark as full
                        return;
                    }
                    count++;
                }
            }
        }
    }
}
