import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shows instructions on how to play the game
 * 
 * @author Abithan Paksaranathan and Clark Chen
 * @version June 10, 2025
 */
public class InstructionScreen extends World
{
    Label infoLabelOne = new Label("* The game starts two blocks, each with a value of 2 or 4", 23);
    Label infoLabelTwo = new Label("* The arrow keys slide all blocks up, down, left or right", 23);
    Label infoLabelThree = new Label("* When two same valued blocks slide together, a new block \n  is created with their sum", 23);
    Label infoLabelFour = new Label("* After each move, a 2 or 4-block will randomly spawn", 23);
    Label infoLabelFive = new Label("* To win, you will have to create a block with the value 2048", 23);
    Label infoLabelSix = new Label("* However, if there are no open spaces for a new block to \n  spawn, you lose", 23); 
    
    public InstructionScreen()
    {    
        super(600, 300, 1); 
        
        GreenfootImage info = new GreenfootImage("images/instructionScreen.jpg");
        info.scale(500, 501);
        setBackground(info);

        addObject(infoLabelOne, 300, 50);
        addObject(infoLabelTwo, 300, 90);
        addObject(infoLabelThree, 300, 130);
        addObject(infoLabelFour, 300, 170);
        addObject(infoLabelFive, 300, 205);
        addObject(infoLabelSix, 300, 250);
    }
}
