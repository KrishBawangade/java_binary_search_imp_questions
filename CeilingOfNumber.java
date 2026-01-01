public class CeilingOfNumber{

    // Ceiling - Smallest no. in array which is greater than or equal to target
    // return the index of that no. number
    static int findCeiling(int[] arr, int target){
        // Using binary search to find the ceiling of the target
        int low = 0;
        int high = arr.length-1;

        // if the target is greater than the greatest element in the array
        // in this case we will not have any ceiling
        if(target>arr[high]){
            return -1;
        }

        while(low<=high){
            int middle = low + ((high-low)/2);
            int middleElement = arr[middle];

            // If we found the target that will be our ceiling
            if(target == middleElement){
                return middleElement;
            }

            if(target>middleElement){
                low = middle +1;
            }else{
                high = middle-1;
            }
        }
        /*
        At the end of the loop low will be greater than high
        and ceiling =  arr[low]
        Therefore return low
        */ 
        return low;
    }


    public static void main(String[] args){
        int[] arr = {2, 5, 12, 23, 45, 66, 67, 78, 89};
        int target = 101;

        int ceilingPos = findCeiling(arr, target);

        if(ceilingPos !=-1){
            System.out.printf("Ceiling of %d is %d", target, arr[ceilingPos]);
        }else{
            System.out.printf("There is no ceiling for %d", target);
        }

    }
}