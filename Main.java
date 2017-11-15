
/**
 * Assignment 6 - Merge Arrays
 * This program is from Edhesive and being used  
 * with gitHub
 *
 * @Robert Berg 
 * @11/8/17
 */

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner kin = new Scanner(System.in);
        
        // Declare the String arrays to hold the names
        String[] names1 = new String[10000];
        String[] names2 = new String[10000];
        String[] result = new String[20000];
        
        System.out.println("Enter the values for the first array, up to 10000 values, enter 'End' to quit");
        String word = kin.nextLine().toLowerCase();
        int i = 0;
        
        // Input the names into the first array in the correct format
        while(!word.equals("end"))
        {
            word = word.substring(0,1).toUpperCase() + word.substring(1);
            names1[i] = word;
            
            i++;
            word = kin.nextLine().toLowerCase();
        }
        System.out.println();
        
        System.out.println("Enter the values for the second array, up to 10000 values, enter 'End' to quit");
        word = kin.nextLine().toLowerCase();
        int j = 0;
        
        // Input the names into the second array in the correct format
        while(!word.equals("end"))
        {
            word = word.substring(0,1).toUpperCase() + word.substring(1);
            names2[j] = word;
            
            j++;
            word = kin.nextLine().toLowerCase();
        }
        System.out.println();
        
        // A boolean to keep track of whether the arrays are in order
        boolean isInOrder = true;
        
        String previous = "";
        System.out.println("First Array");
        // Print out the names of the first array and check to see if they are in alphabetical order
        for(int k = 0; k < i; k++)
        {
            if(names1[k]!=null)
            {
                if (previous.compareTo(names1[k]) > 0)
                    isInOrder = false;
                System.out.print(names1[k] + " " );
                previous = names1[k];
            }
        }
        
        previous = "";
        System.out.println("\n\nSecond Array");
        // Print out the names of the first array and check to see if they are in alphabetical order
        for(int k = 0; k < j; k++)
        {
            if(names2[k]!=null)
            {
                if (previous.compareTo(names2[k]) > 0)
                    isInOrder = false;
                System.out.print(names2[k] + " ");
                previous = names1[k];
            }
        }
        
        if(isInOrder)
        {
            i = 0;
            j = 0;
            for(int k = 0; k < result.length; k++)
            {
                if(names1[i] != null && names2[j] != null){
                    if(names1[i].compareTo(names2[j])<0)
                    {
                        result[k] = names1[i];
                        i++;
                    }
                    else
                    {
                        result[k] = names2[j];
                        j++;
                    }
                }
                else if(names1[i] == null && names2[j] != null)
                {
                    result[k] = names2[j];
                    j++;
                }
                else if(names2[j] == null && names1[i] != null)
                {
                    result[k] =names1[i];
                    i++;
                }
            }
            
            System.out.println("\n\nMerged Array");
            for(int k = 0; k < result.length; k++)
            {
                if(result[k] != null)
                {
                    System.out.print(result[k] + " ");
                }
            }
        }
        else
        {
            System.out.println("\n\nError: Arrays not in correct order");
        }
   
    }
}
