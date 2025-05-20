import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(500, 500, 1);
        
        backgroundSqr();
        
        Two two1 = new Two();
        Two two2 = new Two();
        
        randPos();
        
        addObject(two1, 0, 0);
        addObject(two2, 0, 0);
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
        int randX = Greenfoot.getRandomNumber(4);
        int randY = Greenfoot.getRandomNumber(4);
        
        
    }

    public void create8()
    {
        Eight eight = new Eight();
        addObject();
    }
    
    
}
