    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends ScrollActor

{
   private String name; // Nama item
    private int quantity; // Jumlah item

    public Item(String name, int size, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Getter untuk nama
    public String getName() {
        return name;
    }

    // Getter untuk jumlah
    public int getQuantity() {
        return quantity;
    }

    // Setter untuk jumlah
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    // Menambahkan jumlah item
    public void addQuantity(int amount) {
        quantity += amount;
    }

    // Mengurangi jumlah item
    public void subtractQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        }
    }

}
