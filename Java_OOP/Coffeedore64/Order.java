import java.util.ArrayList;


public class Order {
        private String name;
        private double total;
        private boolean ready;
        private ArrayList<Item> items = new ArrayList<Item>() ;

    

//setters and getters
    public double getTotal() {
        for(int i=0 ; i < items.size() ; i++){
            total += items.get(i).getPrice();
        }
        return this.total;
    }

    public void setTotal(double total) {
        this.total += total;
    }  

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getReady() {
        return this.ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(Item item) {
        this.items.add(item);
    }

}



