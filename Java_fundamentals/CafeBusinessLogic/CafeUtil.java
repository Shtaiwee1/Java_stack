import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CafeUtil {


public int getStreakGoal(int numWeeks){
int sum=0;
for(int i = 0 ; i <= numWeeks ; i++) {
sum+=i;
}
return sum;
    }

// public double getOrderTotal(double[] prices){
//     double total=0;
//     for(int i =0 ; i < prices.length ; i++){
//         total+=prices[i];

//     }
//     return total;
//     }

// public void displayMenu(ArrayList<String> menuItems){
//     for(int i =0 ; i < menuItems.size() ; i++){
//         String name = menuItems.get(i);
//         System.out.println(i + " " + name);

//     }

//     }

public void addCustomer(ArrayList<String> customersList){
    System.out.println("Please enter your name:");
    String userName = System.console().readLine();
    System.out.println("Hello" + userName);
    System.out.println("There are" + customersList.size() + "people in front of you");
    customersList.add(userName);
    for(int j = 0 ; j < customersList.size() ; j++){
    String name = customersList.get(j);
    System.out.println(name);
    }

    }
}
