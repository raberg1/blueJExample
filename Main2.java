/**
 * Assignment 6 Merge Arrays
 *
 * @RobertBerg 
 * @11/15/17 
 */

import java.util.Scanner;

public class Main2
{
    public static void main(String[] args)
    {
        Scanner kin = new Scanner(System.in);
        
        String[] nameArray1 = new String[10000];
        String[] nameArray2 = new String[10000];
        String[] merged = new String[20000];
        
        System.out.println("Enter the values for the first array, up to 10000 values, enter 'End' to quit");
        assignArray(nameArray1, kin);
        
        System.out.println("\nEnter the values for the second array, up to 10000 values, enter 'End' to quit");
        assignArray(nameArray2, kin);
        
        System.out.println("\nFirst Array");
        printArray(nameArray1);
        
        System.out.println("\nSecond Array");
        printArray(nameArray2);
        
        System.out.println();
        
        if(isInOrder(nameArray1) && isInOrder(nameArray2))
        {
            merged = mergeArrays(nameArray1, nameArray2);
            
            System.out.println("Merged Array");
            printArray(merged);
        }
        else
        {
            System.out.println("Error: Arrays not in correct order");
        }
    }
    
    /**
     * Assign String values to an array
     * 
     * @param pArray The array that values will be assigned to
     * @param pkin The scanner that will read from the console
     */
    public static void assignArray(String[] pArray, Scanner pkin){
        int i = 0;
        String result = pkin.nextLine();
        result = result.toLowerCase();
        
        while(!result.equals("end"))
        {
            pArray[i] = result.substring(0,1).toUpperCase() + result.substring(1);
            i++;
            result = pkin.nextLine();
            result = result.toLowerCase();
        }
    }
    
    /**
     * Merge two arrays together in alphabetical order
     * 
     * @param pArray1 The first array to merge
     * @param pArray2 The second array to merge
     * 
     * @return The merged array
     */
    public static String[] mergeArrays(String[] pArray1, String[] pArray2)
    {
        String[] result = new String[20000];
        int i = 0, j = 0, k = 0;
        
        while(pArray1[i] != null || pArray2[j] != null)
        {
            if(pArray1[i] == null)
            {
                result[k] = pArray2[j];
                j++;
            }
            else if (pArray2[j] == null)
            {
                result[k] = pArray1[i];
                i++;
            }
            else
            {
                if(pArray1[i].compareTo(pArray2[j]) < 0)
                {
                    result[k] = pArray1[i];
                    i++;
                }
                else
                {
                    result[k] = pArray2[j];
                    j++;
                }
            }
            k++;
        }
        
        
        return result;
    }
    
    /**
     * Checks to see if an array is in alphabetic order
     * 
     * @param pArray The array to check
     * 
     * @return true if they are in order, false if they are not
     */
    public static boolean isInOrder(String[] pArray)
    {
        boolean inOrder = true;
        int i = 0;
        String previous = "";
        
        while(pArray[i] != null)
        {
            if(previous.compareTo(pArray[i]) > 0)
                inOrder = false;
            previous = pArray[i];
            i++;
        }
        
        return inOrder;
    }
    
    /**
     * Prints each element of the array of Strings
     * 
     * @param pArray The array that will be printed to the console
     */
    public static void printArray(String[] pArray){
        int i = 0;
        while(pArray[i] != null)
        {
            System.out.print(pArray[i] + " ");
            i++;
        }
        System.out.println();
    }
}
