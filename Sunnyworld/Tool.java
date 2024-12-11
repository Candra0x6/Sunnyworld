import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tool here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tool extends ScrollActor
{
    private String name;
    private int quantity;
    /**
     * Act - do whatever the Tool wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Tool(String name, int quantity) 
    {
        this.name = name;
        this.quantity = quantity;
    }
    
     public void useTool() {
        System.out.println("Tomato digunakan!");
    }
}
