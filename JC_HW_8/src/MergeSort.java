import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class mergeSort contains two method mergeSort and merge to for performing divide and conquering.
 */
public class MergeSort  {

    public static void mergeSort(HollywoodMovie[] array){
        if(array.length>1){
            //get mid point of array
            int midpoint = array.length/2;

            //get firstHalf array
            HollywoodMovie[] firstHalf = new HollywoodMovie[midpoint] ;
            System.arraycopy(array,0,firstHalf,0,midpoint);

            //get secondhalf array
            HollywoodMovie[] secondHalf = new HollywoodMovie[array.length-midpoint];
            System.arraycopy(array,midpoint,secondHalf,0,array.length-midpoint);

            //pass two halves to merge method
            mergeSort(firstHalf);
            mergeSort(secondHalf);

            merge(firstHalf,secondHalf,array);


        }
    }

    //merge method sorts the two halve array
    public static void merge(HollywoodMovie[] firstHalf,HollywoodMovie[] secondHalf,HollywoodMovie[] sortedArray){
        int firstArrayIndex =0;
        int secondArrayIndex=0;
        int sortedArrayIndex =0;

        //compare elements in arrays
        while(firstArrayIndex<firstHalf.length && secondArrayIndex<secondHalf.length){
            if(firstHalf[firstArrayIndex].getYear() < secondHalf[secondArrayIndex].getYear() ){
                sortedArray[sortedArrayIndex]=firstHalf[firstArrayIndex];

                firstArrayIndex++;
                sortedArrayIndex++;
            }else{
                sortedArray[sortedArrayIndex]=secondHalf[secondArrayIndex];

                secondArrayIndex++;
                sortedArrayIndex++;

            }
        }

        while (firstArrayIndex<firstHalf.length){
            sortedArray[sortedArrayIndex]=firstHalf[firstArrayIndex];

            firstArrayIndex++;
            sortedArrayIndex++;
        }

        while ( secondArrayIndex<secondHalf.length){
            sortedArray[sortedArrayIndex]=secondHalf[secondArrayIndex];

            secondArrayIndex++;
            sortedArrayIndex++;
        }

    }
}
