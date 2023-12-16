package Lab2.bonus.main;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Fridge implements IFridge{

    ArrayList<FridgeItem> fridge = new ArrayList<>();
    int maxSize = 20;

    @Override
    public int nItemsInFridge() {
        return fridge.size();
    }

    @Override
    public int totalSize() {
        return this.maxSize;
    }

    @Override
    public boolean placeIn(FridgeItem item) {
        if (this.nItemsInFridge() < this.totalSize()) {
            this.fridge.add(item);
            return true;
        } else return false;
    }

    @Override
    public void takeOut(FridgeItem item){
        if (this.fridge.contains(item)) {
            this.fridge.remove(item);
        } else throw new NoSuchElementException();
    }

    @Override
    public void emptyFridge() {
        this.fridge.clear();
    }

    @Override
    public List<FridgeItem> removeExpiredFood() {
        List<FridgeItem> expired = new ArrayList<>();
        ArrayList<FridgeItem> temp = new ArrayList<>();
        for (FridgeItem fridgeItem : this.fridge) {
            if (fridgeItem.hasExpired()) {
                expired.add(fridgeItem);
            } else temp.add(fridgeItem);
        this.fridge = temp;
        }
        return expired;
    }
}
