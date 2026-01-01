public class PeakIndexMountainArray {

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
  

    public static void main(String[] args){
        int[] arr = {24,69,100,99,79,78,67,36,26,19}; 

        int peakIndex = peakIndexInMountainArray(arr);

        System.out.println("PeakIndex in the given mountain array is "+peakIndex);
    }
}
