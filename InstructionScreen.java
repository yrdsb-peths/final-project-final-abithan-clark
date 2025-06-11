import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionScreen extends World
{
    Label infoLabelOne = new Label("* The game 2048 has a 4x4 square grid (16 spaces)", 25);
    Label infoLabelTwo = new Label("* You start off with two blocks with the value two in randomized positions", 22);
    Label infoLabelThree = new Label("* Use the arrow keys to slide the blocks up,down,left or right", 25);
    Label infoLabelFour = new Label("* When sliding blocks, all blocks slide as far as they can go", 25);
    Label infoLabelFive = new Label("* When two blocks with the same number slide into each other-", 25);
    Label infoLabelSix = new Label("* They merge, forming into one block with the sum of the previous two", 23);
    Label infoLabelSeven = new Label("* After each move, a block with a value two or four spawns in a random open space", 20);
    Label infoLabelEight = new Label("* To win, you will have to create a block with the value 2048", 25);
    Label infoLabelNine = new Label("* However, if there are no open spaces for a new block to spawn, you lose", 22); 
    
    
    
    
    public InstructionScreen()
    {    
        super(600, 400, 1); 
        
        
        GreenfootImage info = new GreenfootImage("images/instructionScreen.jpg");
        info.scale(500, 501);
        setBackground(info);
        
        addObject(infoLabelOne, 300, 50);
        addObject(infoLabelTwo, 300, 80);
        addObject(infoLabelThree, 300, 110);
        addObject(infoLabelFour, 300, 140);
        addObject(infoLabelFive, 300, 170);
        addObject(infoLabelSix, 300, 200);
        addObject(infoLabelSeven, 300, 230);
        addObject(infoLabelEight, 300, 260);
        addObject(infoLabelNine, 300, 290);
        
        
    }
}
