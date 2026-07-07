package Sorting;

import java.util.Arrays;

public class Sortings {
    public static void main(String[] args) {
        int[] arr={2,-32,0,78,1};
        SelectionSort(arr);
        BubbleSort(arr);
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));


    }
    public static void SelectionSort(int [] arr){
        for(int i=0;i<arr.length;i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void BubbleSort(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }


    }
    public static void InsertionSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
        }
        

    }




}

