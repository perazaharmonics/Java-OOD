package com.example.pizza;

import java.util.ArrayList;

class PizzaPlace {
    ArrayList<Pizza> pi_arrayList = new ArrayList<>();

    public int getSize() {
        return pi_arrayList.size();
    }

    public Pizza getPizza(int pos) {
        if (pos >= 0 && pos < pi_arrayList.size()) {
            return pi_arrayList.get(pos);
        }
        return null;
    }

    public boolean deleteItem(String title) {
        int pos = searchPizza(title);
        if (pos >= 0) {
            pi_arrayList.remove(pos);
            return true;
        }
        return false;
    }

    public int searchPizza(String title) {
        int index = -1; // Initialize with an invalid index
        for (int pos = 0; pos < pi_arrayList.size(); ++pos) {
            Pizza pi = getPizza(pos);
            if (title.compareToIgnoreCase(pi.Title) == 0) {
                index = pos;
                break; // Stop searching once the pizza is found
            }
        }
        return index;
    }
    
    // Add Pizza to the menu
    public void addPizza(Pizza pizza) {
        pi_arrayList.add(pizza);
    }
}
