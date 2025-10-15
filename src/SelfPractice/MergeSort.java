package SelfPractice;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        sorter(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }
//    This part divides the array, creates left and right subarray and calls function to conquer/combine them
    public static void sorter(int[] arr){
        int len = arr.length;
        if(len<=1){
            return;
        }
        int mid = len/2;
        int[] left = new int[mid];
        int[] right = new int[len-mid];

        int i = 0, j = 0;
        for(; i<len; i++){
            if(i<mid){
                left[i] = arr[i];
            }
            else{
                right[j] = arr[i];
                j++;
            }
        }
        sorter(left);
        sorter(right);
        merger(arr, left, right);

    }

//    This function combines the sorted subarrays
    public static void merger(int[] arr, int[] left, int[] right){
        int llen = left.length;
        int rlen = right.length;
        int l = 0, r = 0, i = 0;
//        We pick the smallest of elements from both subarrays and put it in array
        while(l < llen && r < rlen){
            if(left[l] < right[r]){
                arr[i] = left[l];
                i++;
                l++;
            }
            else{
                arr[i] = right[r];
                i++;
                r++;
            }
        }

//        After this one of left or right subarrays is exhausted
//        We simply put all remaining elements as the subarray was already sorted.
        while(l < llen){
            arr[i] = left[l];
            i++;
            l++;
        }
        while(r < rlen){
            arr[i] = right[r];
            i++;
            r++;
        }
    }

}
