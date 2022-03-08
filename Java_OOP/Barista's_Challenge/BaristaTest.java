import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class BaristaTest {
public static void main(String[] args) {


Item item1 = new Item("mocha",3.5);
Item item2 = new Item("latte",4);
Item item3 = new Item("drip coffee",4.5);
Item item4 = new Item("Capuccino",4.5);


// Item item4 = new Item();
// item4.name = "capuccino";
// item4.price = 3;

Order order1 = new Order("Cindhuri");
Order order2 = new Order("Jimmy");
Order order3 = new Order("Noah");
Order order4 = new Order("Mohammad");
Order order5 = new Order("Sam");



// Order order1 = new Order();
order1.addItem(item1);
order1.addItem(item3);
order1.setReadiness(false);
order1.display();
// Order order2 = new Order();
order2.addItem(item4);
order2.addItem(item2);
order2.setReadiness(true);
order2.display();

order3.addItem(item3);
order3.addItem(item2);
order3.display();
order3.setReadiness(false);

order4.addItem(item1);
order4.addItem(item3);
order4.display();

order5.addItem(item3);
order5.addItem(item4);
order5.display();

// System.out.println(order1.getStatusMessage());
System.out.println(order2.getStatusMessage());
// System.out.println(order3.getStatusMessage());

}
}
