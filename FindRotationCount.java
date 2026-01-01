public class FindRotationCount{

    public static int findRotationCount(int[] nums) {
        int pivot = findPivot(nums);

        // RotationCount = pivot index +1
        return pivot+1;
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

    public static void main(String[] args){
        int[] arr = {7,0,1,2,4,5,6}; 
        int count = findRotationCount(arr);
        
        System.out.printf("Rotation count of array is %d", count);
        
    }
}