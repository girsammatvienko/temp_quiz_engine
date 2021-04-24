import java.util.Arrays;
import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        int occurencesInFirst = 0, occurencesInSecond = 0;

        for(Integer n:list1) {
            if(n == elem) occurencesInFirst++;
        }

        for(Integer n:list2) {
            if(n == elem) occurencesInSecond++;
        }

        return occurencesInFirst == occurencesInSecond;
    }
}