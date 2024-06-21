import java.util.HashSet;
import java.util.Set;

public class LongestConsicutive {

    public static void main(String[] args) {

        int [] arr = {0,3,7,2,5,8,4,6,0,1};

        System.out.println(longestConSequence(arr));
    }

    private static int longestConSequence(int[] arr) {

        int max = 0;
        Set<Integer> dataSet = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            dataSet.add(arr[i]);
        }

        int count = 0;
        for(int num : dataSet) {
            if(!dataSet.contains(num-1)) {
                // staring of seq
                count++;
                int nextNum = num +1;
                while (dataSet.contains(nextNum)) {
                    count++;
                    nextNum++;
                }
                max = Math.max(max, count);
            }
            count = 0;
        }
        return max;
    }
}
