public class SearchInRotatedArray{

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

            /*
                If not pivot,

                1) If first element > middleElement that means pivot lies in left half
                2) Else pivot lies in right half
            */
            if(arr[0]>middleElement){
                high = middle -1;
            }else{
                low = middle+1;
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
        int[] arr = {7,0,1,2,4,5,6}; 
        int target = 0;
        int pos = search(arr, target);

        if(pos !=-1){
            System.out.printf("Target (%d) found at position %d", target, pos);
        }else{
            System.out.printf("Target (%d) not found", target);
        }
    }
}