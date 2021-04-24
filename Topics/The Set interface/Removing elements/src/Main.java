import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String part : str.split("\\s")) {
            numbers.add(Integer.parseInt(part));
        }
        Set<Integer> set = new LinkedHashSet<>(numbers);
        return set;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        Set<Integer> anotherSet = new LinkedHashSet<>();
        for(Integer n:set) {
            if(n <= 10) anotherSet.add(n);
        }
        set.removeAll(set);
        for(Integer n:anotherSet) {
             set.add(n);
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
       int i = ((78*7)+42)%71;
       int i2 = ((41*7)+42)%71;
       int i3 = ((33*7)+42)%71;
        System.out.println(i + " " + i2 + " " + i3);
    }
}