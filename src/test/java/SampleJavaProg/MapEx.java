package SampleJavaProg;
import java.util.HashMap;
import java.util.Iterator;

class MapEx {
    public static void main(String[] args) {

        // create a hashmap
        HashMap<String, Integer> languages = new HashMap<>();

        // add elements to hashmap
        languages.put("Java", 8);
        languages.put("JavaScript", 1);
        languages.put("Python", 3);
        languages.put("Pytho", 3);

//        for ( String a  : languages.keySet() ) {
//            System.out.println("HashMap: " + languages.get(a));
//        }
//        System.out.println("HashMap: " + languages.entrySet());
//
//
//            System.out.println("HashMap: "+ languages.keySet());

        for (String str : languages.keySet()) {
            System.out.println("HashMap: " + languages.get(str));

        }

   }
}
