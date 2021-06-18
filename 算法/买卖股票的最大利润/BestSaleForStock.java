public class BestSaleForStock {

    public static int getMaxProfit(int[] arr){

        int MaxProfit=0, Buy=arr[0];

        for (int i=1;i<arr.length;i++){
            if(Buy>arr[i]){
                Buy = arr[i];
            }else {
                MaxProfit = Math.max(MaxProfit,arr[i]-Buy);
            }
        }

        return MaxProfit;
    }

    public static void main(String[] args) {
        //int[] arr = {9,3,2,6,1,8};
        int[] arr = {2,8,4,6,1,5,3,12};
        System.out.println(BestSaleForStock.getMaxProfit(arr));
    }
}
