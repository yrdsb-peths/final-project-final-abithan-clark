import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The background of labels in MyWorld
 * 
 * @author Abithan Paskaranathan
 * @version June 8, 2025
 */
public class TextBg extends Actor
{
    public TextBg(int w, int h)
    {
        GreenfootImage bg = new GreenfootImage("images/TextBg.png");
        bg.scale(w, h);
        setImage(bg);
    }
}
