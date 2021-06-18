import java.util.Arrays;

public class Sorter {

    public int[] quickSort(int[] arr){

        /*
        * 实现思路：
        * 1. 去数组第一个数为基准数
        * 2. 分别从左右两边取数和基准数做比较，大于基准数的放在右边，否则放在左边
        * */

        int temp = arr[0];
        int j = arr.length-1;
        for(int i=1;i<arr.length-1;i++){
            if(arr[j]<temp ){
                // 比第一个数小，放在左边
                arr[i]=arr[j];
            }else if (arr[i]>temp){
                // 比第一个数大，放在右边
                arr[j]=arr[i];
            }
            j--;
            if(i==j){
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {3,1,5,2,4};
        //Sorter sorter = new Sorter();
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArray(arr)));
    }
}

class Solution {
    public int[] sortArray(int[] nums) {

        quickSort(nums,0,nums.length-1);
        return nums;

    }
    public void quickSort (int[] nums, int low, int high) {

        if (low < high) {
            int index = partition(nums,low,high);
            quickSort(nums,low,index-1);
            quickSort(nums,index+1,high);
        }

    }
    public int partition (int[] nums, int low, int high) {

        int pivot = nums[low];
        while (low < high) {
            //移动high指针
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            //填坑
            if (low < high) nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            //填坑
            if (low < high) nums[high] = nums[low];
        }
        //基准数放到合适的位置
        nums[low] = pivot;
        return low;
    }
}
