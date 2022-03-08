import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
        private String name;
        private boolean ready;
        private ArrayList<Item> items = new ArrayList<Item>() ;
//CONSTRUCTOR
        public Order(){
        this.name = "Guest";
        ArrayList<Item> items = new ArrayList<Item>() ;
    }
        public Order(String name){
        this.name = name;
        
    }


// getters
public String getName(String name) {
    this.name=name;
    return name;
}

public Boolean getReadiness(Boolean ready) {
    this.ready = ready;
    return ready;
}


// *********YOU DON'T NEED THIS**********************
// public ArrayList getItems(ArrayList itemList) {
//     this.itemList = itemList;
//     return items;
// }
// *****************************************

//Setters
public void setName(String name){
    this.name = name;
}

public void setReadiness(Boolean ready){
    this.ready = ready;
}

// ****************************
// public void setItemList(ArrayList itemList){
//     this.itemList = itemList;
// }
// ***********************************


//METHODS

public void addItem(Item item){
    this.items.add(item);
}

public String getStatusMessage(){
    if(this.ready==true){
        return "Your order is ready.";
    }else{
        return "Thank you for waiting. Your order will be ready soon";
    }
}

public void display(){
    System.out.println("Customer Name : " + this.name);
    double total = 0;
    for(int i =0 ; i < items.size() ; i++){
        System.out.println(items.get(i).getName() + "-" + items.get(i).getPrice());
        total += items.get(i).getPrice();
    }
    System.out.println("Total:" + total);
}


public Double getOrderTotal(){
    double total=0;
    for(int i=0 ; i < items.size() ; i++ ){
        total += this.items.get(i).getPrice();
    }
    return total;
    }
}



