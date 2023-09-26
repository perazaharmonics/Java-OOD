package pizzaSingleton;

import java.util.ArrayList;

public class PizzaPlaceSingleton {
    // Singleton instance
    private static PizzaPlaceSingleton instance = null;
    
    private ArrayList<Pizza> pi_arrayList = new ArrayList<>();

    // Private constructor to ensure no other instances can be created
    private PizzaPlaceSingleton() {}

    // Public method to provide access to the singleton instance
    public static PizzaPlaceSingleton getInstance() {
        if(instance == null) {
            instance = new PizzaPlaceSingleton();
        }
        return instance;
    }

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
        int index = -1;
        for (int pos = 0; pos < pi_arrayList.size(); ++pos) {
            Pizza pi = getPizza(pos);
            if (title.compareToIgnoreCase(pi.Title) == 0) {
                index = pos;
                break;
            }
        }
        return index;
    }
    
    public void addPizza(Pizza pizza) {
        pi_arrayList.add(pizza);
    }
}