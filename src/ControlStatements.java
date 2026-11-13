import java.util.ArrayList;
import java.util.List;

public class ControlStatements {

    public ControlStatements(){

    }
    static int sum(int[] a)
    {
        // result is the accumulator of the function
        int result = 0;
        for (int i : a){
            result = result + i;
        }
        return result;
    }

    static int[] cumSum(int[] a){
        int[] resultArr = new int[a.length];
        // result acts as an accumulator which is inserted into the array
        int result = 0;
        for (int i = 0; i < a.length; i++){
            result = result + a[i];
            resultArr[i] = result;
        }
        return resultArr;
    }
    static int[] positives(int[] a){
        List<Integer> intList = new ArrayList<>();

        for (int i: a){
            if (i > 0) {
                intList.add(i);
            }
        }
        // code to convert list into a primitive int[]
        return intList.stream().mapToInt(Integer::intValue).toArray();
    }
}
