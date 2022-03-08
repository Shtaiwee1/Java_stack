import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Puzzling {

// public ArrayList getTenRolls() {
//     Random randNum = new Random();  
//     ArrayList<Integer> myArray = new ArrayList<Integer>();
//     for(int i =0 ; i < 10 ; i++){
//     int randomNum = randNum.nextInt(19)+1;
//     myArray.add(randomNum);
//     }
//     System.out.println(myArray);
//     return myArray;
//     }




// public String getRandomLetter(){
// char[] alphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
// Random rand = new Random();
// int random = rand.nextInt(25) + 0;
//     char x = alphabets[random];
//     String convert = Character.toString(x);
//     // System.out.println(x);
// return convert;
// }

// *************************NOT A VALID SOLUTION**************************************************************
// public String generatePassword(){
//     char[] alphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
// Random rand = new Random();
// System.out.println(x);
// for(int i = 0 ; i < 8 ; i++){
// int random = rand.nextInt(25) + 0;
//     char x = alphabets[random];
//     // String convert = Character.toString(x);
//     String s = new StringBuilder().append(x).toString();
//     // System.out.println(x);
// }
// return s;
// }
// *********************************************************************




// public String generatePassword(){
//     String alphabets = "abcdefghijklmnopqrstuvwxyz";
//     Random rand = new Random();
// String[] alphabets2 = new String[26];

// for(int i = 0 ; i < 26 ; i++){
//     alphabets2[i] = String.valueOf(alphabets.charAt(i));
// }
// return alphabets2[rand.nextInt(26)];
// }

// public String getPassword(){
//     String random ="";
//     for(int i = 0 ; i < 8 ; i++){
//         random =random + generatePassword();
//     }
//     return random;
// }





// ********POSIIBLE SOLUTION BUT NOT READY YET*************************
// public String getNewPasswordSet(int length){
//     char[] alphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//     Random rand = new Random();
//     String<ArrayList> PassSet = new String<ArrayList>();
//     for(int i = 0 ; i < length ; i++){
//         for(int j = 0 ; j < 8 ; j++){   
//     }   
//     }
// }
// *****************************************



// public String getNewPasswordSet(){
//     String alphabets = "abcdefghijklmnopqrstuvwxyz";
//     Random rand = new Random();
// String[] alphabets2 = new String[26];

// for(int i = 0 ; i < 26 ; i++){
//     alphabets2[i] = String.valueOf(alphabets.charAt(i));
// }
// return alphabets2[rand.nextInt(26)];
// }

// public ArrayList generatePasswordSet(int length){
//     ArrayList<String> PassSet = new ArrayList<String>();
//     for(int j = 0 ; j < length ; j++){
//         String random ="";
//     for(int i = 0 ; i < 8 ; i++){
//         random = random + getNewPasswordSet();
//     }
//         PassSet.add(random);
    
//     }
//     return PassSet;
// }





}

// Random rand = new Random();
// int random_integer = rand.nextInt(upperbound-lowerbound) + lowerbound;