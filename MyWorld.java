//all images/colors from this website https://2048.ninja/

import greenfoot.*;

public class MyWorld extends World {
    Two two1;
    Two two2;
    public MyWorld() {
        super(500, 500, 1);
        
        backgroundSqr();
        
        two1 = new Two();
        two2 = new Two();
        
        //creates two 2 blocks at a random position
        randPos();
    }
    
    public void backgroundSqr()
    {
        //setting the first square y position
        int posY = 70;
        
        for (int x = 0; x < 4; x++)
        {
            //resetting the square y position
            int posX = 70;
            for (int i = 0; i < 4; i++)
            {
                //create 4 new empty objects per row
                Empty empty = new Empty();
                addObject(empty, posX, posY);
                posX += 120;
            }
            //lowers the next row
            posY += 120;
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

    public void create8()
    {
        Eight eight = new Eight();
    }
    
    
}
