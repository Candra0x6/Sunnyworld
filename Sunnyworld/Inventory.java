import greenfoot.*;
import java.util.HashMap;

public class Inventory extends Actor
{
    private HashMap<String, Integer> items = new HashMap<>();
    private boolean isVisible = false;
    private Character owner;
    private static final int SLOT_SIZE = 40;
    private static final int SLOTS = 8;
    
    public Inventory(Character owner) {
        this.owner = owner;
        createInventoryImage();
    }
    
    private void createInventoryImage() {
        GreenfootImage img = new GreenfootImage(SLOT_SIZE * SLOTS, SLOT_SIZE);
        img.setColor(new Color(139, 69, 19, 200));  // Semi-transparent brown
        img.fill();
        img.setColor(Color.BLACK);
        // Draw slot separators
        for(int i = 0; i < SLOTS; i++) {
            img.drawRect(i * SLOT_SIZE, 0, SLOT_SIZE, SLOT_SIZE);
        }
        setImage(img);
    }
    
    public void act() {
        // Toggle inventory visibility with 'I' key
        if(Greenfoot.isKeyDown("I") && !isKeyPressed) {
            isVisible = !isVisible;
            isKeyPressed = true;
        }
        if(!Greenfoot.isKeyDown("I")) {
            isKeyPressed = false;
        }
        
        // Update inventory position to follow player
        if(isVisible) {
            setLocation(owner.getX() - (SLOT_SIZE * SLOTS)/2, owner.getY() - 100);
            updateInventoryDisplay();
        }
    }
    
    private boolean isKeyPressed = false;
    
    public void addItem(String itemName, int quantity) {
        items.put(itemName, items.getOrDefault(itemName, 0) + quantity);
        updateInventoryDisplay();
    }
    
    public boolean hasItem(String itemName) {
        return items.getOrDefault(itemName, 0) > 0;
    }
    
    public void removeItem(String itemName) {
        if(hasItem(itemName)) {
            items.put(itemName, items.get(itemName) - 1);
            if(items.get(itemName) <= 0) {
                items.remove(itemName);
            }
            updateInventoryDisplay();
        }
    }
    
    public boolean isVisible() {
        return isVisible;
    }
    
    private void updateInventoryDisplay() {
        GreenfootImage baseImg = new GreenfootImage(SLOT_SIZE * SLOTS, SLOT_SIZE);
        baseImg.setColor(new Color(139, 69, 19, 200));
        baseImg.fill();
        baseImg.setColor(Color.BLACK);
        
        // Draw items and quantities
        int slot = 0;
        for(String item : items.keySet()) {
            if(slot >= SLOTS) break;
            
            // Draw slot border
            baseImg.drawRect(slot * SLOT_SIZE, 0, SLOT_SIZE, SLOT_SIZE);
            
            // Draw item count
            baseImg.setColor(Color.WHITE);
            baseImg.drawString(items.get(item).toString(), 
                             slot * SLOT_SIZE + 5, 
                             SLOT_SIZE - 5);
            
            slot++;
        }
        
        // Draw empty slots
        for(int i = slot; i < SLOTS; i++) {
            baseImg.setColor(Color.BLACK);
            baseImg.drawRect(i * SLOT_SIZE, 0, SLOT_SIZE, SLOT_SIZE);
        }
        
        setImage(baseImg);
    }
}