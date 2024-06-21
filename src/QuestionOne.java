import java.util.*;

public class QuestionOne {

    public static void main(String[] args) {

        int [] arr = {-1,-1,6,1,9,3,2,-1,4,-1};

        rearrange(arr, arr.length);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void rearrange(int[] arr, int n) {

        List<Integer> tempSet = new ArrayList<>(Collections.nCopies(n, -1));

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == -1) {
                continue;
            }
            tempSet.set(arr[i], arr[i]);
        }

        for(int i=0;i<n;i++)
            arr[i] = tempSet.get(i);

    }
}
