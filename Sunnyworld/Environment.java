import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * The battlefield in which the player fights
 * 
 * @author Michael
 * @version 10/15/2014
 */
public class Environment extends ScrollWorld
{
    /**
     * Constructor for objects of class Battlefield.
     * 
     */
    public Environment()
    {    
        super(1280,720, 1, 5000, 5000);
        Greenfoot.setSpeed(50);
       
      
        addCameraFollower(new Character(), 0, 0);
        Tomato tomato = new Tomato(3);
        addObject(new BorderForest(), 1250, 1250);

        addObject(tomato, 500,500);

    }
}
