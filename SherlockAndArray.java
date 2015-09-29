package SearchPractice;

import java.util.Scanner;

/**
 *
 * @author Rajiur
 */
public class SherlockAndArray {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();
        for(int x=0; x<numTestCases; x++){
            int s = in.nextInt();
            int[] ar = new int[s];
            for(int i=0; i<s; i++){
                ar[i]=in.nextInt(); 
            }
            printArray(ar);
            int[] sumArray = new int[ar.length];
            for(int i=0; i<sumArray.length; i++){
                if(i==0){
                    sumArray[i] = ar[i];
                }
                else{
                    sumArray[i] = sumArray[i-1]+ar[i];
                }
            }
            printArray(sumArray);
            int flag = 0;
            int len = sumArray.length-1;
            for(int i=1; i<len-1; i++){
                if( sumArray[i+1] ==(sumArray[len]-sumArray[i]) ){
                    flag = 1;
                }
            }
            if(flag==1){System.out.println("YES");}
            else{System.out.println("NO");}
        }
    }
    public static void printArray(int[] ar){
        for(int i=0; i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }System.out.println("");
    }
}
