;

public class Item {
    private String name;
    private double price;
    private int index;
    

///


//setters and getters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index += index;
    }

    public void increaseCounter(){
        index+=1;
    }

    

    

    //methods

    
    // public displayMenu(){

    // }
    // public newOrder(){

    // }
    // public addMenuItemByInput(){

    // }
    






}