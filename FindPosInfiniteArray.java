public class FindPosInfiniteArray{

    // function to search target in an infinite array
    // for searching a infinite length array we will be searching in chunks as we dont know the upper bound
    static int searchTarget(int[] arr, int target){
        int low = 0;
        int high = 1;

        // run the loop until we get the upper bound
        while(target>arr[high]){
            int newLow = high+1;

            // double the size of the box, size of the box = high-low+1 (as both are inclusive)
            high = high + (high-low+1)*2;
            low = newLow;
        }
        // now perform the binary search and return the result
        return binarySearch(arr, low, high, target);
    }

    static int binarySearch(int[] arr, int low, int high, int target){
        while(low<=high){
            int middle = low + ((high-low)/2);
            int middleElement = arr[middle];

            if(target == middleElement){
                return middle;
            }
            
            if(target>middleElement){
                low = middle +1;
            }else{
                high = middle-1;
            }
        }
        return -1;
    }   

    public static void main(String[] args){
        // assume this as a infinite length array
        int[] arr = {2,5,8,12,34,36,39,44,50,58,59,67,79};
        int target = 34;

        int pos = searchTarget(arr, target);

        if(pos != -1){
            System.out.printf("Element (%d) found at index %d", target, pos);
        }else{
            System.out.printf("Element (%d) not found in the Array", target);
        }
    }
}