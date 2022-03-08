import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Exceptions {
public static void main(String[] args) {
ArrayList<Object> myList = new ArrayList<Object>();
myList.add("13");
myList.add(11);
myList.add("hello world");
myList.add(48);
myList.add("Goodbye World");
// myList.add(true);


for(int i = 0; i < myList.size(); i++) {
try{
Integer castedValue = (Integer) myList.get(i);
}catch (Exception e){
System.out.println("Hey, you have one or multiple errors in your code " + " The indeces of the errors are: " + i + " The value of the error is " + myList.get(i));
// back-up plan here.
}

}
}
}
// Create a generic array list with strings and integers
    // Looping through the array list, it tries to assign each
    // item to an integer object
    // If the item is not an integer, it will catch the exception
    // and print that it is an exception along with what the exception was