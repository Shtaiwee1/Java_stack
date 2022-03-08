import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();;
// Constructors initiation
    public Order() {
        this.name = "Guest";
        ArrayList<Item> items = new ArrayList<Item>();
    }

    public Order(String name) {
        this.name = name;
    }
// name getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public String getName(String name) {
        this.name = name;
        return name;
    }

// Status ready getters and setters
    public Boolean getIsReady(Boolean ready) {
        this.ready = ready;
        return ready;
    }

    public void isReady(Boolean ready) {
        this.ready = ready;
    }

// Class Methods
    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if (this.ready == true){
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public void display(){
        System.out.println("Customer Name: " + this.name);
        double total = 0;
        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).getName() + " - " + items.get(i).getPrice());
            total += items.get(i).getPrice();
        }
        System.out.println("Total:" + total);
    }

    public Double getOrderTotal(){
        double total = 0;
        for(int i = 0; i < items.size(); i++){
            total += items.get(i).getPrice();
        } //this.items.get(i).getPrice(); equivalent to items.get(i).getPrice();
        return total;
    }
}