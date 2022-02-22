package sort;

import java.util.Arrays;

/**
 * @program: spark_test
 * @package: sort
 * @filename: SortTwoClass.java
 * @create: 2020/07/09 13:34
 * @author: 29314
 * @description: .独立编写排序算法
 **/

public class SortTwoClass {
    public static void exchange(int[] arr,int index_a,int index_b){
        arr[index_a] = arr[index_a] ^ arr[index_b];
        arr[index_b] = arr[index_a] ^ arr[index_b];
        arr[index_a] = arr[index_a] ^ arr[index_b];
    }

    //冒泡排序

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
    //选择排序

    public static int[] selectSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            int tmp = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[tmp]){
                    tmp = j;
                }
            }
            if(tmp!=i) {
                exchange(arr, i, tmp);
            }
        }
        return arr;
    }
    //插入排序

    public static int[] insertSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            int tmp = arr[i];
            int j = i-1;
            for(;j>=0;j--){
                if(arr[j]>tmp){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = tmp;
        }
        return arr;
    }
    //希尔排序

    public static int[] shellSort(int[] arr){
        for(int gap = arr.length/2;gap > 0;gap = gap / 2){
            for(int i = 0;i+gap < arr.length; i = i+gap){
                int tmp = arr[i+gap];
                int j = i + gap;
                for(;j >= gap;j = j - gap){
                    if(arr[j-gap]>tmp){
                        arr[j] = arr[j-gap];
                    }else{
                        break;
                    }
                }
                arr[j] = tmp;
            }
        }

        return arr;
    }
    //归并排序

    public static int[] mergeSort(int[] arr){
        if(arr.length<=1){
            return arr;
        }

        int mid = arr.length >> 1;

        int[] left_arr = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right_arr = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        int idx = 0;
        int left = 0;
        int right = 0;

        while(left<left_arr.length && right < right_arr.length){
            if(left_arr[left]<=right_arr[right]){
                arr[idx++] = left_arr[left++];
            }else{
                arr[idx++] = right_arr[right++];
            }
        }
        while(left<left_arr.length){
            arr[idx++] = left_arr[left++];
        }
        while(right < right_arr.length){
            arr[idx++] = right_arr[right++];
        }
        return arr;
    }
    //快速排序

    public static int getMidNum(int[] arr,int start,int end){
        int mid = (start + end)/2;

        if(arr[start] < arr[mid] && arr[mid] < arr[end]){
            exchange(arr,start,mid);
        }
        if(arr[start] > arr[mid] && arr[mid] > arr[end]){
            exchange(arr,start,mid);
        }

        if(arr[start] < arr[end] && arr[end] < arr[mid]){
            exchange(arr,start,end);
        }
        if(arr[start] > arr[end] && arr[end] > arr[mid]){
            exchange(arr,start,end);
        }

        return arr[start];
    }

    public static int[] quickSort(int[] arr){
        return quickSort(arr,0,arr.length);
    }

    public static int[] quickSort(int[] arr,int start,int end){
        if(end-start<=1){
            return arr;
        }

        int tmp = getMidNum(arr, start, end-1);
        int indx = start;
        int left = start + 1;
        int right = end - 1;

        while(left < right){
            for(;right>indx;right--){
                if(arr[right]<=tmp){
                    arr[indx] = arr[right];
                    indx = right--;
                    break;
                }
            }
            for(;left<indx;left++){
                if(arr[left]>tmp){
                    arr[indx] = arr[left];
                    indx = left++;
                    break;
                }
            }
        }
        arr[indx] = tmp;
        quickSort(arr,start,indx);
        quickSort(arr,indx+1,end);

        return arr;
    }
    //堆排序

    public static void getMaxNode(int[] arr,int index,int end){
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int max_idx = index;
        if(left < end && arr[left] > arr[max_idx]){
            max_idx = left;
        }
        if(right < end && arr[right] > arr[max_idx]){
            max_idx = right;
        }

        if(max_idx != index){
            exchange(arr,index,max_idx);
            getMaxNode(arr,max_idx,end);
        }
    }

    public static void getBigTree(int[] arr){
        for(int i = arr.length/2-1;i>=0;i--){
            getMaxNode(arr,i,arr.length);
        }
    }

    public static int[] heapSort(int[] arr){
        getBigTree(arr);

        for(int i = arr.length-1;i>0;i--){
            exchange(arr,i,0);
            getMaxNode(arr,0,i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,5,2,9,7,4,8,10};
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
