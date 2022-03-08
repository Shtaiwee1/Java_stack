import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TestOrders {
public static void main(String[] args) {



Item item1 = new Item();
item1.name = "mocha";
item1.price = 3.5;

Item item2 = new Item();
item2.name = "latte";
item2.price = 4;

Item item3 = new Item();
item3.name = "drip coffee";
item3.price = 4.5;

Item item4 = new Item();
item4.name = "capuccino";
item4.price = 3;



Order order1 = new Order();
order1.name = "Cindhuri";
order1.ready = true;


Order order2 = new Order();
order2.name = "Jimmy";
order2.items.add(item1);
order2.total+= item1.price;
order2.ready = true;

Order order3 = new Order();
order3.name = "Noah";
order3.items.add(item4);
order3.total += item3.price;


Order order4 = new Order();
order4.name = "Sam";
order4.items.add(item2);
for (int i= 0 ; i<2 ; i++){
order4.total += item2.price;
}



// System.out.println("Order 1 " + order1);
// System.out.println("Order 1 " + order1.total);
// System.out.println("Order 2 is " + order2.items);
// System.out.println("Order 2 is " + order2.total);
// System.out.println("Order 3 is " + order3.total);
// System.out.println("Order 4 is " + order4.total);
// System.out.println(" Order 1 is ready " + order1.ready);
// System.out.println(" Order 2 is ready " + order2.ready);


}
}

// Menu items
// Order variables -- order1, order2 etc.
// Application Simulations
// Use this example code to test various orders' updates
// System.out.printf("Name: %s\n", order1.name);
// System.out.printf("Total: %s\n", order1.total);
// System.out.printf("Ready: %s\n", order1.ready);





// /*
// You will need add 1 line to this file to create an instance
// of the CafeUtil class.
// Hint: it will need to correspond with the variable name used below..
// */
// /* ============ App Test Cases ============= */
// System.out.println("\n----- Streak Goal Test -----");
// System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(15));
// // System.out.println("----- Order Total Test-----");
// // double[] lineItems = {3.5, 1.5, 4.0, 4.5};
// // System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
// // System.out.println("----- Display Menu Test-----");
// // List<String> loadMenu = Arrays.asList(
// // "drip coffee",
// // "cappucino",
// // "latte",
// // "mocha"
// // );
// // ArrayList<String> menu = new ArrayList<String>();
// // menu.addAll(loadMenu);
// // appTest.displayMenu(menu);
// System.out.println("\n----- Add Customer Test-----");
// ArrayList<String> customers = new ArrayList<String>();
// // --- Test 4 times ---

// for (int i = 0; i < 4; i++) {
// appTest.addCustomer(customers);
//     System.out.println("\n");
// }




