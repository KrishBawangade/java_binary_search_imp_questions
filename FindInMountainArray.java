public class FindInMountainArray{

    static int findInMountainArray(int target, int[] mountainArr) {
        int peakIndex = peakIndexInMountainArray(mountainArr);
        int ascIndex = binarySearch(mountainArr, 0, peakIndex, target, true);
        if(ascIndex == -1){
            int descIndex = binarySearch(mountainArr, peakIndex, mountainArr.length-1, target, false);
            return descIndex;
        }else{
            return ascIndex;
        }
    }

    static int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high){
            // assume peakIndex as middle Index
            int peakIndex = low + ((high-low)/2);
            int peakElement = arr[peakIndex];
            
            /*
                1. peakElement is less than previous element,
                    then we need to search in left half space

                2. Similarly if it is less than next element,
                    then we need to search in right half space
                
                3. Else it is the greatest that means it is peakElement, return peakIndex
             */  
            if(peakIndex-1>-1 && peakElement<arr[peakIndex-1]){
                high = peakIndex -1;
            }else if(peakIndex+1<arr.length && peakElement<arr[peakIndex+1]){
                low = peakIndex+1;
            }else{
                return peakIndex;
            }
        }

        return -1;
    }

    static int binarySearch(int[] arr, int low, int high, int target, boolean isAscending){
        while(low<=high){
            int middle = low + ((high-low)/2);
            int middleElement = arr[middle];

            if(target == middleElement){
                return middle;
            }
            
            if(isAscending){
                if(target>middleElement){
                    low = middle +1;
                }else{
                    high = middle-1;
                }
            }else{
                if(target>middleElement){
                    high = middle-1;
                }else{
                    low = middle +1;
                }
            }
            
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {24,69,77,100,99,79,78,77,67,36,26,19}; 
        int target = 67;
        int minPos = findInMountainArray(target, arr);

        if(minPos !=-1){
            System.out.printf("Target (%d) found at position %d", target, minPos);
        }else{
            System.out.printf("Target (%d) not found", target);
        }

    }
}