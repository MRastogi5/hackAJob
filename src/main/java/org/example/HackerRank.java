package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class HackerRank {

    public static void main(String[] args) {
        //plusMinus(Arrays.asList(1,2,3,4,3,2,1));
        //diagonalDifference(Arrays.asList(Arrays.asList(11,2,4),Arrays.asList(4,5,6),Arrays.asList(10,8,-12)));

        //countingSort(Arrays.asList(1,1,3,2,1));
        flippingMatrix(Arrays.asList(
                Arrays.asList(112,42,83,119,11,22),
                Arrays.asList(56,125,56,49,33,44),
                Arrays.asList(15,78,101,43,55,66),
                Arrays.asList(62,98,114,108,77,88),
                Arrays.asList(10,20,30,40,50,60),
                Arrays.asList(70,80,90,100,110,120)));
    }


    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */
    public static int towerBreakers(int n, int m) {
        // Write your code here

        return 0;
    }

    public static int flippingMatrix(List<List<Integer>> matrixList) {


        int n = matrixList.size() / 2;
        int total = 0;

        Integer[][] matrix = new Integer[matrixList.size()][matrixList.size()];
        for (int i =0; i<matrixList.size();i++) {
            matrix[i] = matrixList.get(i).toArray(matrix[i]);

        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                Integer leftTop = matrix[row][col];
                Integer rightTop = matrix[row][2 * n - col - 1];
                Integer leftBottom = matrix[2 * n - row - 1][col];
                Integer rightBottom = matrix[2 * n - row - 1][2 * n - col - 1];
                total += Math.max(Math.max(leftTop, rightTop), Math.max(leftBottom, rightBottom));
            }
        }

        /*
        Integer[][] matrixArr = new Integer[matrix.size()][matrix.size()];
        for (int i =0; i<matrix.size();i++) {
            matrixArr[i] = matrix.get(i).toArray(matrixArr[i]);

        }
        int j= matrix.size()/2;
        for(int i =0; i<matrix.size()/2;i++){
            int temp = matrixArr[i][j];
            matrixArr[i][j] = matrixArr[matrix.size()-1-i][j];
            matrixArr[matrix.size()-1-i][j] = temp;
        }
        for(int i =0; i<matrixArr[0].length/2;i++){
            int temp = matrixArr[0][i];
            matrixArr[0][i] = matrixArr[0][matrix.size()-1-i];
            matrixArr[0][matrix.size()-1-i] = temp;
        }
        int sum = 0;
        for(int i=0;i<matrixArr.length/2;i++){
            for(int k=0 ; k< matrixArr.length/2;k++){
                sum += matrixArr[i][k];
            }
        }
        System.out.println(sum);
        return sum;*/
        return 0;
    }
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> freqArr = new ArrayList(100);
        for(int i = 0; i < 100; i++) {
            freqArr.add(0);
        }
        for(int a : arr){
            freqArr.set(a,freqArr.get(a)+1);
        }
        return freqArr;
    }
    public static int diagonalDifference(List<List<Integer>> arr) {

        int first = 0;
        int other = 0;
        for(int i = 0; i<arr.size();i++){
            for(int j = 0; j<arr.size();j++){
                if(i==j){
                    first += arr.get(i).get(j);
                    other += arr.get(i).get((arr.size()-1)-j);
                }
            }
        }
        return (first > other) ? first - other : other - first;
    }
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        for (int i=0;i<arr.size();i=i+2) {
            if(i == (arr.size()-1) || arr.get(i)!= arr.get(i+1)){
                System.out.println(arr.get(i));
                break;
            }
        }
    }
}
