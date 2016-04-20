
import java.util.ArrayList;

/**
 * @author Jyothi Reddy Kallam <jyothi.kallam@gmail.com>
 */
public class MergeSort {
	ArrayList<ZipCodeRange> array;
	ArrayList<ZipCodeRange> tempMergArr;
    int length;
     
    /**
     * This method sorts the given ArrayList using merge sort
     */
    public ArrayList<ZipCodeRange> sortByMerge(ArrayList<ZipCodeRange> input) {
        array = new ArrayList<ZipCodeRange>(input);
        length = input.size();
        tempMergArr = new ArrayList<ZipCodeRange>(length);
        doMergeSort(0, length - 1);
        return array;
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Sorts the left side of the ArrayList
            doMergeSort(lowerIndex, middle);
            // Sorts the right side of the ArrayList
            doMergeSort(middle + 1, higherIndex);
            // Merge both sides of the ArrayList
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr.add(i,array.get(i)); 
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr.get(i).start <= tempMergArr.get(j).start) {
            
                array.set(k, tempMergArr.get(i) );
                i++;
            } else {
            	
                array.set(k, tempMergArr.get(j));
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array.set(k,tempMergArr.get(i) );
            k++;
            i++;
        }
 
    }
}
