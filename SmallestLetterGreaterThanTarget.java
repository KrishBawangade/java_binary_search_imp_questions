public class SmallestLetterGreaterThanTarget {

    static char nextGreatestLetter(char[] arr, char target){
         // Using binary search to find the smallest letter greater than target
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int middle = low + ((high-low)/2);
            char middleElement = arr[middle];

            if(target>=middleElement){
                low = middle +1;
            }else{
                high = middle-1;
            }
        }
        /*
        At the end of the loop low will be greater than high
        and next Greatest letter =  arr[low % arr.length] -> this will wrap around
        */ 
        return arr[low % arr.length];
    }

    public static void main(String[] args){
        char[] arr = {'c', 'g', 'h'};
        char target = 'f';

        char nextGreatestLetter = nextGreatestLetter(arr, target);

        System.out.printf("Next Greatest letter after %c in the array is %c", target, nextGreatestLetter);
    }
}
