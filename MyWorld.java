//all images/colors from this website https://2048.ninja/

import greenfoot.*;

/**
 * the game world where you play the game
 * 
 * @author Abithan Paskaranathan and Clark Chen 
 * @version June 7, 2025
 */

public class MyWorld extends World {
    //use an int 2d arr to keep track of the grid
    public Block[][] grid = new Block[4][4];
    
    public boolean win = false;
    public boolean hardMode = false;
    public boolean insaneMode = false;
    
    //makes sure you can't hold down keys
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    //adds a message showing the controls
    Label controls = new Label("  Use\n  \u2191\n  \u2190 \u2193 \u2192\n  to move", 50);
    TextBg controlBg = new TextBg(190, 210);
    X controlX = new X();
    
    public MyWorld() {
        super(500, 500, 1);
        
        GreenfootImage bg = new GreenfootImage("images/background.png");
        bg.scale(500, 501);
        setBackground(bg);
        
        //lets block movement look more smooth
        Greenfoot.setSpeed(57);
        
        //creates two random positioned 2 blocks
        randPos();
        
        addObject(controlBg, 252, 247);//the grey background
        addObject(controls, 242, 250); //the label
        addObject(controlX, 332, 157); //the x object that removes the two above if pressed
    }
    
    //code is in act so it keeps checking for keypresses
    public void act()
    {  
        //mouseCord();
        
        if (Greenfoot.isKeyDown("up")) 
        {
            if (!upPressed)
            {   
                upPressed = true;
                
                //check thrice incase blocks move due to another key press
                //ex. without 3 checks: if up is pressed then down, only
                //the layer closest to the bottom row will move down
                
                for (int i = 0; i < 3; i++)
                {
                    upCheck();
                }
                
                createNewBlocks();
                
                //create 2 total new blocks at hard mode and 3 at insane mode
                
                if(hardMode == true)
                {
                    createNewBlocks();
                    
                    Label hard = new Label("Two blocks now \n spawn with\n each movement", 40);
                    TextBg hardBg = new TextBg(270, 160);
                    X hardX = new X();
                    
                    addObject(hardBg, 238, 250);
                    addObject(hard, 242, 250);
                    addObject(hardX, 358, 185);
                }

                if(insaneMode == true)
                {
                    createNewBlocks();
                    
                    Label insane = new Label("Three blocks now \n spawn with\n each movement", 40);
                    TextBg insaneBg = new TextBg(270, 160);
                    X insaneX = new X();
                    
                    addObject(insaneBg, 238, 250);
                    addObject(insane, 242, 250);
                    addObject(insaneX, 358, 185);
                }
            }
        } else 
        {
            upPressed = false;
        }
    
        if (Greenfoot.isKeyDown("down")) 
        {
            if (!downPressed)
            {
                downPressed = true;
                
                for (int i = 0; i < 3; i++)
                {
                    downCheck();
                }
                
                createNewBlocks();

                if(hardMode == true)
                {
                    createNewBlocks();
                    
                    Label hard = new Label("Two blocks now \n spawn with\n each movement", 40);
                    TextBg hardBg = new TextBg(270, 160);
                    X hardX = new X();
                    
                    addObject(hardBg, 238, 250);
                    addObject(hard, 242, 250);
                    addObject(hardX, 358, 185);
                }

                if(insaneMode == true)
                {
                    createNewBlocks();
                    
                    Label insane = new Label("Three blocks now \n spawn with\n each movement", 40);
                    TextBg insaneBg = new TextBg(270, 160);
                    X insaneX = new X();
                    
                    addObject(insaneBg, 238, 250);
                    addObject(insane, 242, 250);
                    addObject(insaneX, 358, 185);
                }
            }
        } else 
        {
            downPressed = false;
        }
    
        if (Greenfoot.isKeyDown("left")) 
        {
            if (!leftPressed)
            {   
                leftPressed = true;
                
                for (int i = 0; i < 3; i++)
                {
                    leftCheck();
                }
                
                createNewBlocks();

                if(hardMode == true)
                {
                    createNewBlocks();
                    
                    Label hard = new Label("Two blocks now \n spawn with\n each movement", 40);
                    TextBg hardBg = new TextBg(270, 160);
                    X hardX = new X();
                    
                    addObject(hardBg, 238, 250);
                    addObject(hard, 242, 250);
                    addObject(hardX, 358, 185);
                }

                if(insaneMode == true)
                {
                    createNewBlocks();
                    
                    Label insane = new Label("Three blocks now \n spawn with\n each movement", 40);
                    TextBg insaneBg = new TextBg(270, 160);
                    X insaneX = new X();
                    
                    addObject(insaneBg, 238, 250);
                    addObject(insane, 242, 250);
                    addObject(insaneX, 358, 185);
                }
            }
        } else 
        {
            leftPressed = false;
        }

        if (Greenfoot.isKeyDown("right"))
        {
            if (!rightPressed)
            {
                rightPressed = true;
                
                for (int i = 0; i < 3; i++)
                {
                    rightCheck();
                }
                
                createNewBlocks();
                
                if(hardMode == true)
                {
                    createNewBlocks();
                    
                    Label hard = new Label("Two blocks now \n spawn with\n each movement", 40);
                    TextBg hardBg = new TextBg(270, 160);
                    X hardX = new X();
                    
                    addObject(hardBg, 238, 250);
                    addObject(hard, 242, 250);
                    addObject(hardX, 358, 185);
                }

                if(insaneMode == true)
                {
                    createNewBlocks();
                    
                    Label insane = new Label("Three blocks now \n spawn with\n each movement", 40);
                    TextBg insaneBg = new TextBg(270, 160);
                    X insaneX = new X();
                    
                    addObject(insaneBg, 238, 250);
                    addObject(insane, 242, 250);
                    addObject(insaneX, 358, 185);
                }
            }
        } else
        {
            rightPressed = false;
        }
        //HARD DIFFICULTY ()
        //Change controls when reaching a set block number
        //If they don't figure out controls in 5 secs then it auto moves a random control
        //Add multiple blocks spawned (2 or 3) per move which can be an 8 value. 
        if(win == true)
        {
            Label winnerLabel = new Label("You Win", 100);
            addObject(winnerLabel, 250, 250);
        }
    }
    
    public void mouseCord()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        
        int x = 0;
        int y = 0;
        
        if (m != null)
        {
            x = m.getX();
            y = m.getY();
        }
        
        Label l = new Label(x + ", " + y, 22);
        addObject(l, 60, 6);
        
        Greenfoot.delay(16);
        removeObject(l);
    }
    
    //check the opposite side in the grid 
    public void upCheck()
    {
        //check every grid spot for a block and check if it can move down
        for (int y = 3; y >= 0; y--)
        {
            for (int x = 0; x < 4; x++)
            {
                if (grid[x][y] != null)
                {
                    Block b = grid[x][y];
                    b.moveUp();
                    Greenfoot.delay(1);
                }
            }
        }
    }
    
    public void downCheck()
    {
        //check every grid spot for a block and if it can move down
        for (int y = 0; y < 4; y++)
        {
            for (int x = 0; x < 4; x++)
            {
                if (grid[x][y] != null)
                {
                    Block b = grid[x][y];
                    b.moveDown();
                    Greenfoot.delay(1);
                }
            }
        }
    }
    
    public void leftCheck()
    {
        //check every grid spot for a block and check if it can move left
        for (int x = 3; x >= 0; x--)
        {
            for (int y = 0; y < 4; y++)
            {
                if (grid[x][y] != null)
                {
                    Block b = grid[x][y];
                    b.moveLeft();
                    Greenfoot.delay(1);
                }
            }
        }
    }
    
    public void rightCheck()
    {
        //check every grid spot for a block and check if it can move right
        for (int x = 0; x < 4; x++)
        {
            for (int y = 0; y < 4; y++)
            {
                if (grid[x][y] != null)
                {
                    Block b = grid[x][y];
                    b.moveRight();
                    Greenfoot.delay(1);
                }
            }
        }
    }
    
    public void randPos()
    {
        Block two1 = new Block(2);
        Block two2 = new Block(2);
        
        //+120 is the position of the next empty square
        
        //random position for one random spawning two block
        int randX1 = Greenfoot.getRandomNumber(4);
        int randY1 = Greenfoot.getRandomNumber(4);
        int x1 = 70 + (randX1 * 120);
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
                    //without count it would spawn a new block at the first empty spot found
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
