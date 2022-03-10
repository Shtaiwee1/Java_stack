import java.util.ArrayList;


public class coffeekiosk{
    private  ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>() ;

    //constructor

    public coffeekiosk(){
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
        
    }

    //setters and getters

    public ArrayList<Item> getMenu() {
        return this.menu;
    }

    public void setMenu(ArrayList<Item> menu) {
        this.menu = menu;
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    
//method


public Item addMenuItemByInput(){
    System.out.println("Please enter the name of the new item:");
    Item newitem = new Item();
    String newItemName = System.console().readLine();
    System.out.println("Please enter the price of the new item:");
    String newStringItemPrice = System.console().readLine();
    Integer newItemPrice = Integer.parseInt(newStringItemPrice);
    newitem.setName(newItemName);
    newitem.setPrice(newItemPrice);
    newitem.setIndex(menu.size());
    menu.add(newitem);
    return newitem;

}


public Item addMenuItem(String name , double price ){
    Item thisitem = new Item();
    thisitem.setName(name);
    thisitem.setPrice(price);
    menu.add(thisitem);
    thisitem.setIndex(menu.size()-1);
    return thisitem;
    
}



//display items of a given menu
public void displayMenu(){
    //[item1,item2,item3, ....]
    for(int i=0 ; i < menu.size() ; i++){
        System.out.println(menu.get(i).getIndex() + " " + menu.get(i).getName() + " -- " + "$" + menu.get(i).getPrice());
    }

}

public Item getItemByIndex(int index){
    for(int i=0 ; i < menu.size() ; i++){
        if(menu.get(i).getIndex()== index){
            return menu.get(i);
        }
    }
    return null;
}

public void addCustomer(){
    //ArrayList<String> Queue = new ArrayList<String>();
        System.out.println("Please enter customer name for new order:");
        String userName = System.console().readLine();
        Order newOrder = new Order();
        newOrder.setName(userName);
        String keepGoing = "";
        displayMenu();
        System.out.println("Please enter a menu item index or q to quit:");
        keepGoing = System.console().readLine();


        while(true){
            if(keepGoing.equals("q")){
                System.out.println(newOrder.getName());
                for(int i=0 ; i < newOrder.getItems().size() ; i++){
                    System.out.println(newOrder.getItems().get(i).getName() + " -$ " + newOrder.getItems().get(i).getPrice());
                }
                System.out.println(newOrder.getTotal());
                break;
            }else{
                int itemIndex = Integer.parseInt(keepGoing);
                Item thisItem = getItemByIndex(itemIndex);
                newOrder.setItems(thisItem);
                System.out.println(thisItem.getName());

                System.out.println("Please enter a menu item index or q to quit:");
                keepGoing = System.console().readLine();


            }
        }
    
}


// public void addMenuItemByInput(){
//     System.out.println("Please enter the name of the new item:");
//     String newItemName = System.console().readLine();
//     System.out.println("Please enter the price of the new item:");
//     String newStringItemPrice = System.console().readLine();
//     Double newItemPrice = Double.parseDouble(newStringItemPrice);
//     addMenuItem(newItemName , newItemPrice );

// }

}