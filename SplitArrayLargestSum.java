public class SplitArrayLargestSum{

    static int splitArray(int[] nums, int k) {
        int[] lowHighArr = findLowHigh(nums);
        int low = lowHighArr[0];
        int high = lowHighArr[1];
        
        return findMinimizedLargestSum(nums, k, low, high);
    }

    static int[] findLowHigh(int[] arr){
        int sum = arr[0];
        int largest = arr[0];

        for(int i=1; i<arr.length;i++){
            int element = arr[i];
            sum+=element;
            if(element>largest){
                largest=element;
            }
        }

        return new int[] {largest, sum};
    }

    static int findMinimizedLargestSum(int[] arr, int k, int low, int high){
        while(low!=high){
            int middle = low + ((high-low)/2);

            int splits = findSplits(arr, middle);
            /*
                1) If splits is less than or equal to largest sum,
                    Then it means that we should reduce our sum 
                    making high = middle

                2) Else If the splits are more than the expected splits,
                    Then it means that the largest sum lies above our lower limit
                    making low = middle+1

                And doing the same thing until our upper and lower limit becomes same
            */
            if(splits<=k){
                high = middle;
            }else{
                low = middle+1;
            }
        }
        return low;
    }

    static int findSplits(int[] arr, int max){
        int splits = 1; // taking initial split as 1 for the last element
        int sum=0;

        for(int i=0;i<=arr.length-1;i++){
            int newSum = sum+ arr[i]; 
            
            // if our newSum doesn't exceed the max limit we will increase the sum
            if(newSum<=max){
                sum = newSum;
            }else{
                // else If it exceeds the max limit we will increment the splits
                splits++;
                sum=arr[i];
            }
        }

        return splits;
    }

    public static void main(String[] args){
        int[] arr = {7,2,5,10,8}; 
        int k=2;
        int largestSum = splitArray(arr, k);
        
        System.out.printf("Largest Sum of SplitArray is %d", largestSum);
    }
}