public class FloorOfNumber{

    // Floor - Greatest no. in array which is smaller than or equal to target
    // return the index of that no. number
    static int findFloor(int[] arr, int target){
        // Using binary search to find the floor of the target
        int low = 0;
        int high = arr.length-1;

        // if the target is less than the smallest element in the array
        // in this case we will not have any floor
        if(target<arr[low]){
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
        At the end of the loop 'high' will be less than 'low'
        and floor =  arr[high]
        Therefore return high
        */ 
        return high;
    }


    public static void main(String[] args){
        int[] arr = {2, 5, 12, 23, 45, 66, 67, 78, 89};
        int target = 1;

        int floorPos = findFloor(arr, target);

        if(floorPos !=-1){
            System.out.printf("Floor of %d is %d", target, arr[floorPos]);
        }else{
            System.out.printf("There is no Floor for %d", target);
        }

    }
}