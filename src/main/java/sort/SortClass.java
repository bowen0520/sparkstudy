package sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @program: intelligenthome_collection
 * @package: com.jxlg.project.sort
 * @filename: SortClass.java
 * @create: 2020/07/09 10:07
 * @author: 29314
 * @description: .十大排序实现
 **/

public class SortClass {
    /*
    交换
     */
    public static void exchange(int[] arr,int index_a,int index_b){
        arr[index_a] = arr[index_a] ^ arr[index_b];

        arr[index_b] = arr[index_a] ^ arr[index_b];

        arr[index_a] = arr[index_a] ^ arr[index_b];
    }

    /*
    冒泡排序
     */
    public static int[] bubbleSort(int[] arr){
        boolean flag = true;

        for(int i = 1;i<arr.length;i++){
            for(int j = arr.length-1;j>=i;j--){
                if(arr[j]<arr[j-1]){
                    exchange(arr,j,j-1);
                    flag = false;
                }
            }

            if(flag){
                break;
            }
            flag = true;
        }
        return arr;
    }

    /*
    选择排序
     */
    public static int[] selectSort(int[] arr){
        for(int i = 0;i<arr.length;i++){
            int tmp = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    tmp = j;
                }
            }
            if(tmp != i) {
                exchange(arr, tmp, i);
            }
        }

        return arr;
    }

    /*
    插入排序
     */

    public static int[] insertSort(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            int tmp = arr[i+1];
            int j = i;
            for(;j>=0;j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {

                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    /*
    希尔排序
     */
    public static int[] shellSort(int[] arr){
        for(int gap = arr.length/2;gap>0;gap = gap/2){
            for(int i = 0;i+gap<arr.length;i = i+gap){
                int tmp = arr[i+gap];
                int j = i;
                for(;j>=0;j = j-gap){
                    if(arr[j]>tmp){
                        arr[j+gap] = arr[j];
                    }else{

                        break;
                    }
                }
                arr[j+gap] = tmp;
            }
        }
        return arr;
    }

    /*
    归并排序
     */
    public static int[] copyArr(int[] arr,int from, int to){
        int length = to - from ;

        int[] copy = new int[length];

        for(int i = from,j = 0;i<to;i++,j++){
            copy[j] = arr[i];
        }
        return copy;
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }

        int mid = arr.length>>1;
        //int[] arr_left = mergeSort(copyArr(arr,0,mid));
        //int[] arr_right = mergeSort(copyArr(arr,mid,arr.length));
        int[] arr_left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] arr_right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        int arr_index = 0;
        int left = 0;
        int right = 0;

        while(left<arr_left.length&&right<arr_right.length){
            if (arr_left[left] <= arr_right[right]) {
                arr[arr_index++] = arr_left[left++];
            }else{
                arr[arr_index++] = arr_right[right++];
            }
        }

        while(left<arr_left.length){
            arr[arr_index++] = arr_left[left++];
        }
        while(right<arr_right.length){
            arr[arr_index++] = arr_right[right++];
        }

        return arr;
    }

    /*
    快速排序
     */
    public static int getMid(int[] arr,int start,int end){
        int mid = (start + end) / 2;
        if (arr[start] > arr[mid] && arr[end] < arr[mid]) {
            exchange(arr,mid,start);
        }
        if (arr[start] < arr[mid] && arr[end] > arr[mid]) {
            exchange(arr,mid,start);
        }

        if (arr[start] < arr[end] && arr[end] < arr[mid]) {
            exchange(arr,end,start);
        }
        if (arr[start] > arr[end] && arr[end] > arr[mid]) {
            exchange(arr,end,start);
        }

        return arr[start];
    }

    public static int[] quickSort(int[] arr){
        return quicksort(arr,0,arr.length);
    }

    public static int[] quicksort(int[] arr,int start,int end){
        if(end-start<=1){
            return arr;
        }

        int tmp = getMid(arr, start, end-1);
        //int tmp = arr[start];
        int index = start;
        int left = start + 1;
        int right = end-1;

        while(left<right){
            for(;right>index;right--){
                if(arr[right]<=tmp){
                    arr[index] = arr[right];
                    index = right--;
                    break;
                }
            }
            for(;left<index;left++){
                if(arr[left]>tmp){
                    arr[index] = arr[left];
                    index = left++;
                    break;
                }
            }
        }

        arr[index] = tmp;
        quicksort(arr,start,index);
        quicksort(arr,index+1,end);
        return arr;
    }

    /*
    堆排序
     */

    public static void getMax(int[] arr,int index,int end){
        int maxindex = index;

        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if(left < end && arr[left] > arr[maxindex]){
            maxindex = left;
        }

        if(right < end && arr[right] > arr[maxindex]){
            maxindex = right;
        }

        if(maxindex != index){
            exchange(arr,index,maxindex);
            getMax(arr,maxindex,end);
        }
    }

    public static void getBigTree(int[] arr){
        for(int i = arr.length/2-1;i>=0;i--){
            getMax(arr,i,arr.length);
        }
    }

    public static int[] heapSort(int[] arr){
        getBigTree(arr);
        for(int i = arr.length-1;i>0;i--){
            exchange(arr,0,i);
            getMax(arr,0,i);
        }
        return arr;
    }

    /*

     */


    public static void main(String[] args) {
        int[] arr = {1,3,6,5,2,9,7,4,8,10};
        //int[] arr = {3,2};
        //bubbleSort(arr);
        //selectSort(arr);
        //insertSort(arr);
        //shellSort(arr);

        //mergeSort(arr);
        //quickSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
