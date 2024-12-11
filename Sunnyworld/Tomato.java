import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tomato extends Item {
    private int quantity;
    public Tomato(int quantity) {
        super("Tomato", 1, quantity); //
        this.quantity = quantity;
    }

      private boolean isCollected = false;
      
    public int getTomatoQuantity(){
        return quantity;
    }
  /**
   public void act()
    {
        if(!isCollected) {
            // Cek apakah player menyentuh tomat
            Character player = (Character)getOneIntersectingObject(Character.class);
            if(player != null) {
                // Tomat terkoleksi
                isCollected = true;
                // Anda bisa menambahkan efek suara atau animasi di sini
                getWorld().removeObject(this);
            }
        }
    }
    */
    public void useItem() {
        System.out.println("Tomato digunakan!");
    }
}
