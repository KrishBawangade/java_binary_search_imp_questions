public class FirstLastPosOfElementInArray{


    static int searchTarget(int[] nums, int target, boolean findFirstOccurrence){

        int low = 0;
        int high = nums.length-1;
        int index = -1;

        while(low<=high){
            int middle = low + ((high-low)/2);
            int middleElement = nums[middle];

            if(target == middleElement){
                index = middle;
                if(findFirstOccurrence){
                    high = middle-1;
                }else{
                    low = middle+1;
                }
                continue;
            }
            
            if(target>middleElement){
                low = middle +1;
            }else{
                high = middle-1;
            }
        }

        return index;
    }

    static int[] searchRange(int[] nums, int target){
        

        if(nums.length == 0){
            return new int[] {-1,-1};
        }
        // find the first occurrence of the target
        int startIndex = searchTarget(nums, target, true);

        // find the last occurrence of the target
        int endIndex = searchTarget(nums, target, false);

        return new int[] {startIndex, endIndex};
    }

    public static void main(String[] args){
        int[] nums = {6,6,6,6,6,6};
        int target = 6;

        int[] resultRange = searchRange(nums, target);

        if(resultRange[0] != -1 && resultRange[1] != -1){
            System.out.printf("Range of %d is From %d to %d", target, resultRange[0], resultRange[1]);
        }else{
            System.out.printf("Element (%d) not found in the Array", target);
        }
    }
}