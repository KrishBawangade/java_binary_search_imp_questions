public class SearchInRotatedArray2{
    // searching in rotated array of non distinct values
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        if(pivot == -1){
            return binarySearch(nums, 0, nums.length-1, target);
        }

        if(target == nums[pivot]){
            return pivot;
        }

        if(target>=nums[0]){
            return binarySearch(nums, 0, pivot-1, target);
        }else{
            return binarySearch(nums, pivot+1, nums.length-1, target);
        }
    }

    static int findPivot(int[] arr){
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int middle = low + ((high-low)/2);
            int middleElement = arr[middle];
            
            // pivot conditions
            if(middle+1< arr.length && middleElement>arr[middle+1]){
                return middle;
            }
            if(middle-1>-1 && middleElement<arr[middle-1]){
                return middle-1;
            }

            // Check If start is a pivot
            if( low+1< arr.length && arr[low]>arr[low+1]){
                return low;
            }

            // Check if end is a pivot
            if( high-1>-1 && arr[high]<arr[high-1]){
                return high-1;
            }

            /*
                Check if the first, end and middle element are equal,
                If it is equal skip it 
            */

            if(arr.length!=1 && arr[low]==middleElement && arr[high] == middleElement){
                low ++;
                high--;
            }else if(middleElement>arr[low] || (middleElement==arr[low] && middleElement>arr[high])){
                /*
                    If middleElement is greater than arr[low],
                    then we can say that the pivot lies in right half space

                    Or If middleElement is equal to arr[low] and greater than arr[high],
                    then also we can say that the pivot lies in right half space
                    because it is rotated array as middle element is greater than end
                */
                low = middle+1;
            }else{
                // Else search in left half space for the pivot
                high = middle-1;
            }
            
        }

        return -1;
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
        int[] arr = {1,1,3}; 
        int target = 2;
        int pos = search(arr, target);

        if(pos !=-1){
            System.out.printf("Target (%d) found at position %d", target, pos);
        }else{
            System.out.printf("Target (%d) not found", target);
        }
    }
}