package SearchPractice;

import static java.lang.System.in;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rajiur
 */
public class MissingNumbers {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int len1 = in.nextInt();
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>(); //some elements missing here
        for(int i=0; i<len1; i++){
            int key = in.nextInt(); 
            if(!map1.containsKey(key)){
                map1.put(key, 1);
            }
            else{
                int currentCountForKey = map1.get(key);
                map1.put(key, currentCountForKey+1);
            }
        }
        int len2 = in.nextInt();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>(); //the bigger map/array
        for(int i=0; i<len2; i++){
            int key = in.nextInt(); 
            if(!map2.containsKey(key)){
                map2.put(key, 1);
            }
            else{
                int currentCountForKey = map2.get(key);
                map2.put(key, currentCountForKey+1);
            }
        }
        int[] missingNumbers = finMissingNumbers(map1, map2);
        insertionSort(missingNumbers);
        printArray(missingNumbers);

    }
    private static int[] finMissingNumbers(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) { //map2 is the bigger map
        List<Integer> missingNumbers = new ArrayList<Integer>();
        for(int key:map2.keySet()){
            if( map1.get(key) != null){
                int count1 = map1.get(key);
                int count2 = map2.get(key);
                if(count2-count1 >= 1){
                    missingNumbers.add(key);
                }
            }
            else{
                missingNumbers.add(key);
            }
        }
        int[] missingArray = convertIntegers(missingNumbers);
        return missingArray;
    }
    public static int[] convertIntegers(List<Integer> integers){
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }
    public static void printArray(int[] ar){
        for(int i=0; i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }System.out.println("");
    }
    private static void printMap(HashMap<Integer, Integer> map) {
        for(int key:map.keySet()){
            System.out.print(key+ "-" + map.get(key) + " ");
        }System.out.println("");
    }
    private static void insertionSort(int[] A){
        int count = 0;
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
                count++;
            }
            A[j + 1] = value;
        }
    }

}
