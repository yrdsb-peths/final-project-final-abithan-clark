import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shows instructions on how to play the game
 * 
 * @author Abithan Paksaranathan and Clark Chen
 * @version June 10, 2025
 */
public class InstructionScreen extends World
{
    //all the instructions show as bullet points
    Label infoLabelOne = new Label("* The game starts two blocks, each with a value of 2 or 4", 25);
    Label infoLabelTwo = new Label("* The arrow keys slide all blocks up, down, left or right", 25);
    Label infoLabelThree = new Label("* When two same valued blocks slide together, a new block \n  is created with their sum", 25);
    Label infoLabelFour = new Label("* After each move, a 2 or 4-block will randomly spawn", 25);
    Label infoLabelFive = new Label("* To win, you will have to create a block with the value 2048", 25);
    Label infoLabelSix = new Label("* If there are no open spaces for a new block to spawn, you lose", 25); 
    Label infoLabelSeven = new Label("* When a 256 block is made, 2 blocks spawn with each move \n and 3 will spawn when a 512 block is created", 25); 
    
    Label goBack = new Label("Go Back", 35);
    
    public InstructionScreen()
    {    
        super(600, 400, 1); 
        
        //scale the image
        GreenfootImage info = new GreenfootImage("images/instructionScreen.jpg");
        info.scale(600, 301);
        setBackground(info);

        addObject(infoLabelOne, 300, 50);
        addObject(infoLabelTwo, 300, 90);
        addObject(infoLabelThree, 300, 140);
        addObject(infoLabelFour, 300, 190);
        addObject(infoLabelFive, 300, 225);
        addObject(infoLabelSix, 300, 270);
        addObject(infoLabelSeven, 300, 320);
        
        addObject(goBack, 300, 380);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(goBack))
        {
            TitleScreen titleScreen = new TitleScreen();
            Greenfoot.setWorld(titleScreen);            
        }
    }
}
