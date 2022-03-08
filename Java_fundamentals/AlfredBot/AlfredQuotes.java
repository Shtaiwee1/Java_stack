import java.util.Date;
public class AlfredQuotes {
public String basicGreeting() {
// You do not need to code here, this is an example method
return "Hello, lovely to see you. How are you?";
}
public String guestGreeting(String name) {
// YOUR CODE HERE
return String.format("Hello, %s. Lovely to see you.", name);
}
public String dateAnnouncement() {
// YOUR CODE HERE
Date date= new Date();  
return String.format("It is currently %s", date);
}
public String respondBeforeAlexis(String conversation) {
// YOUR CODE HERE
String alexis = "Alexis";
String alfred = "Alfred";
int a = conversation.indexOf("Alexis");
int b = conversation.indexOf("Alfred");
if (a >= 0) {
    return "Right away, sir. She certainly isn't sophisticated enough for that.";
}else if (b >= 0){
    return "At your service. As you wish, naturally.";
}else{
    return "Right. And with that I shall retire.";
}

}
// NINJA BONUS
// See the specs to overload the guessGreeting method
// SENSEI BONUS
// Write your own AlfredQuote method using any of the String methods you have learned!
}