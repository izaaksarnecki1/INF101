package Lab2.bonus.test;

import Lab2.bonus.main.Fridge;
import Lab2.bonus.main.FridgeItem;
import static org.junit.jupiter.api.Assertions.*;

import Lab2.bonus.main.IFridge;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class FridgeTest {


    private IFridge fridge = new Fridge();

    /**
     * Get a single FridgeItem
     * @return fridgeItem
     */
    public FridgeItem getItem() {
        LocalDate expirationDate = LocalDate.of(2021, 12, 24);
        FridgeItem item = new FridgeItem("Christmas Cake", expirationDate);
        return item;
    }

    /**
     * Fills the fridge. Place as many items in the fridge as the maxCapacity
     */
    public void fillFridge() {
        FridgeItem item = getItem();
        int maxCapacity = fridge.totalSize();
        for (int i = 0; i < maxCapacity; i++) {
            fridge.placeIn(item);
        }
    }

    /**
     * Test if single item can be placed in empty fridge.
     */
    @Test
    public void placeInEmptyFridgeTest() {
        FridgeItem item = getItem();
        assertTrue(fridge.placeIn(item));
    }

    /**
     * Tests that you can't place a fridgeitem in a full fridge
     */
    @Test
    public void placeInFullFridgeTest() {
        fillFridge();
        FridgeItem item = getItem();
        assertFalse(fridge.placeIn(item));
    }

    /**
     * Test the method <code>nItemsInFridge</code>.
     * Place one and one item in the fridge and check that
     * the number of items in the fridge is correct.
     */
    @Test
    public void nItemsInFridgeTest() {
        FridgeItem item = getItem();
        int maxCapacity = fridge.totalSize();
        for (int i = 0; i < maxCapacity; i++) {
            fridge.placeIn(item);
            assertEquals((i+1), fridge.nItemsInFridge());
        }
        assertEquals(maxCapacity, fridge.nItemsInFridge());
    }

    /**
     * Tests if you can take out a fridgeitem from fridge
     */
    @Test
    public void takeOutTest() {
        FridgeItem item = getItem();
        fridge.placeIn(item);
        fridge.takeOut(item);
    }

    /**
     * Tests if you cannot take out an item from an empty fridge
     */
    @Test
    public void takeOutFromEmptyFridgeTest() {
        FridgeItem item = getItem();
        assertThrows(NoSuchElementException.class, () -> fridge.takeOut(item));
    }

    /**
     * Test <code>emptyFridge</code>. Check that there are no
     * items in the fridge after calling <code>emptyFridge</code>.
     */
    @Test
    public void emptyFridgeTest() {
        fillFridge();
        assertEquals(fridge.totalSize(), fridge.nItemsInFridge());
        fridge.emptyFridge();
        assertEquals(fridge.nItemsInFridge(), 0);
    }

    /**
     * Checks if <code>removeExpiredFoods</code> returns only expired food.
     * Add 4 good items and 4 expired items. Call <code>removeExpiredFoods</code>
     * and check that only the expired items where removed.
     */
    @Test
    public void removeExpiredItemsTest() {
        // Add expired items
        LocalDate expiredDate = LocalDate.of(2008, 4, 19);
        List<FridgeItem> expiredItems = new ArrayList<>();
        List<String> itemNames1 = Arrays.asList("Chicken", "Tofu", "Pizza", "Milk");
        for (int i = 0; i < itemNames1.size(); i++) {
            FridgeItem expiredItem = new FridgeItem(itemNames1.get(i), expiredDate);
            expiredItems.add(expiredItem);
            fridge.placeIn(expiredItem);
        }

        // Add good items
        LocalDate goodDate = LocalDate.of(2026, 1, 1);
        List<FridgeItem> goodItems = new ArrayList<>();
        List<String> itemNames2 = Arrays.asList("Pasta", "Onion", "Taco", "Soda");
        for (int i = 0; i < itemNames2.size(); i++) {
            FridgeItem goodItem = new FridgeItem(itemNames2.get(i), goodDate);
            goodItems.add(goodItem);
            fridge.placeIn(goodItem);
        }

        // Check the number of items in fridge after removing expired items
        int currentNItemsInFridge = fridge.nItemsInFridge();
        List<FridgeItem> expiredItemsFromFridge = fridge.removeExpiredFood();
        assertEquals(currentNItemsInFridge-expiredItemsFromFridge.size(), fridge.nItemsInFridge());

        // Check that only expired items where removed
        for (FridgeItem item : expiredItems) {
            assertTrue(expiredItemsFromFridge.contains(item));
        }
        for (FridgeItem item : goodItems) {
            assertFalse(expiredItemsFromFridge.contains(item));
        }
    }

}
