import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ZeroOneTwo {

    public static void main(String[] args) {

        int []nums = {1,0,2};
        //arrange(nums);
        arrange2(nums);
        for (int num : nums)
            System.out.print(num);
    }

    private static void arrange2(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length -1;

        while (mid<=high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] ==1) {
                mid ++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static void arrange(int[] nums) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == 0)
                count0++;
            else if (num == 1)
                count1++;
            else
                count2++;
        }

        int i = 0;
        while (count0>0){
            nums[i] = 0;
            count0--;
            i++;
        }
        while (count1>0){
            nums[i] = 1;
            count1--;
            i++;
        }
        while (count2>0){
            nums[i] = 2;
            count2--;
            i++;
        }
    }
}
