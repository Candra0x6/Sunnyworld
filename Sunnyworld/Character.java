import greenfoot.*;

public class Character extends ScrollActor
{
    private int speed = 3;
    private Inventory inventory;
    private int globalX = 0;
    private int globalY = 0;
    private static final int EDGE_OFFSET = 50; 
    public Character() {
        inventory = new Inventory(this);
    }
    
    @Override
    protected void addedToWorld(World world) {
        // Add inventory when character is added to world
        world.addObject(inventory, 0, 0);
    }
    
    public void act()
    {
        moveAround();
        checkItemCollection();
    }
    
    private void checkItemCollection() {
        // Check for items to collect
        Tomato tomato = (Tomato)getOneIntersectingObject(Tomato.class);
        if(tomato != null) {
            inventory.addItem("Tomato", tomato.getTomatoQuantity());
            getWorld().removeObject(tomato);
            // Bisa tambahkan efek suara di sini
            // Greenfoot.playSound("collect.wav");
        }
    }
    
    public void moveAround()
    {
        ScrollWorld world = (ScrollWorld)getWorld();
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        
        int oldX = getX();
        int oldY = getY();
        int newX = oldX;
        int newY = oldY;
        
        // Menggerakkan karakter
        if(Greenfoot.isKeyDown("W")) {
            newY -= speed;
        }
        if(Greenfoot.isKeyDown("S")) {
            newY += speed;
        }
        if(Greenfoot.isKeyDown("D")) {
            newX += speed;
        }
        if(Greenfoot.isKeyDown("A")) {
            newX -= speed;
        }
        
        // Cek batas dunia dan update posisi
        if (newX >= EDGE_OFFSET && newX < worldWidth - EDGE_OFFSET) {
            setLocation(newX, getY());
            // Update posisi kamera untuk mengikuti player
            world.setCameraLocation(newX, world.getCameraY());
        }
        
        if (newY >= EDGE_OFFSET && newY < worldHeight - EDGE_OFFSET) {
            setLocation(getX(), newY);
            // Update posisi kamera untuk mengikuti player
            world.setCameraLocation(world.getCameraX(), newY);
        }
    }

    
    public Inventory getInventory() {
        return inventory;
    }
}