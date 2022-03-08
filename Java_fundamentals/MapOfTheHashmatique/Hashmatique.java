import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
public static void main(String[] args) {
HashMap<String, String> trackList = new HashMap<String, String>();

trackList.put("Industry_baby", "Lil Nas");
trackList.put("Dark_Horse", "Katty Perry");
trackList.put("Mirrors", "Justin Timberlake");
trackList.put("Faded", "Walker");

// String name = trackList.get("Mirrors");
// System.out.println("the name of the artist is :" + name);

Set<String> keys = trackList.keySet();
for(String key : keys) {
System.out.println(key);
System.out.println(trackList.get(key));
}
}
}