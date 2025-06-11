import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * the title screen where you create a new game to play
 * 
 * @author Clark Chen 
 * @version June 7, 2025
 */
public class TitleScreen extends World
{
    Label startLabel = new Label("New game", 42);
    Label infoLabel = new Label("Instructions", 42);
    
    public TitleScreen()
    {      
        super(540, 318, 1); 
        setBackground("images/titlescreen.jpg");
        Greenfoot.setSpeed(60);
        
        addObject(startLabel, 405, 250);
        addObject(infoLabel, 405, 180);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(startLabel))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld); 
        }
        if(Greenfoot.mouseClicked(infoLabel))
        {
            InstructionScreen infoScreen = new InstructionScreen();
            Greenfoot.setWorld(infoScreen);
        }
        
        if(Greenfoot.mouseClicked(infoLabel))
        {
            TextBg infoBg = new TextBg(480, 250);
            
            /*
             * If a block value of 256 is created, hard mode will start, and now 2 blocks will be
             * created when the arrow keys are pressed. If a block value of 512 is created, 3 new
             * blocks will now spawn with each movement. 
            */
           
            Label info = new Label("the the the the \n the the the thet ehth ", 50);
            X infoX = new X();
            
            addObject(infoBg, 268, 160);
            addObject(info, 268, 250);
            addObject(infoX, 70, 245);
        }
    }
}
