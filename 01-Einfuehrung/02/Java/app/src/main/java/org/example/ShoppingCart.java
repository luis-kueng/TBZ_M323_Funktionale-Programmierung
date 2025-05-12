package org.example;

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private List<String> items;
    private boolean isBookAdded;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.isBookAdded = false;
    }

    public void addItem(String item) {
        this.items.add(item);
        if (item != null && item.toLowerCase().contains("book")) {
            this.isBookAdded = true;
        }
    }

    public String removeItem(int itemIndex) {
        String removedItem = this.items.remove(itemIndex);

        if (removedItem != null) {
            boolean bookFound = false;
            for (String cartItem : this.items) {
                if (cartItem != null && cartItem.toLowerCase().contains("book")) {
                    bookFound = true;
                    break;
                }
            }
            this.isBookAdded = bookFound;
        }

        return removedItem;
    }

    public List<String> getItems() {
        return items;
    }

    public boolean isBookAdded() {
        return isBookAdded;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
               "items=" + items +
               ", isBookAdded=" + isBookAdded +
               '}';
    }
}
