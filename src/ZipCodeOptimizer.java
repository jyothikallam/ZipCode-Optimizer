
import java.util.ArrayList;

/**
 * @author Jyothi Reddy Kallam <jyothi.kallam@gmail.com>
 */
public class ZipCodeOptimizer {
	
	/**
	 * This method performs the optimization of given zipcode ranges
	 * @param data sorted array list of zipcode ranges
	 * @return ArrayList containing minimum number of zipcode ranges that represents the input
	 */
	public ArrayList<ZipCodeRange> optimizeRange(ArrayList<ZipCodeRange> data) {
	
	MergeSort mg = new MergeSort();
	ArrayList<ZipCodeRange> sortedData = mg.sortByMerge(data);  // sorts the zipcode list by using merge sort

    ZipCodeRange tempRange = sortedData.get(0);
    ArrayList<ZipCodeRange> result = new ArrayList<ZipCodeRange>();
    result.add(tempRange);
    for (int i = 1; i < sortedData.size(); i++) {
    	if (sortedData.get(i).start <= tempRange.end) {
            if(tempRange.end > sortedData.get(i).end)
            {
            	// tempRange = new ZipCodeRange(tempRange.start, tempRange.end);
            }
            else {
            	result.remove(tempRange);
            	tempRange = new ZipCodeRange(tempRange.start, sortedData.get(i).end);
            	result.add(tempRange);
            }
            }
    	else {
    		result.add(sortedData.get(i));
    		tempRange = new ZipCodeRange(sortedData.get(i).start, sortedData.get(i).end);
    		}
    	}
    return result;
    }
}
