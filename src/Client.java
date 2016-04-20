
import java.util.*;

/**
 * @author Jyothi Reddy Kallam <jyothi.kallam@gmail.com>
 */
public class Client {

	private static Scanner input;

	public static void main(String args[]) {
		
		input = new Scanner(System.in);
        ArrayList<ZipCodeRange> zipCodeList = new ArrayList<ZipCodeRange>();
        System.out.println("Enter the number of zipcode ranges you wish to add");
        int listNum = input.nextInt();
        int incrementor = 0;
        while (incrementor < listNum) {
        	System.out.println("Enter start of the range followed by space and end of the range \n");
        	ZipCodeRange zipRange = new ZipCodeRange(input.nextInt(), input.nextInt());
        	zipCodeList.add(zipRange);
            incrementor++;
        }
		
//		ZipCodeRange zip1 = new ZipCodeRange(1001, 1004);
//		ZipCodeRange zip2 = new ZipCodeRange(1003, 3006);
//		ZipCodeRange zip3 = new ZipCodeRange(3005, 6005);
//		ZipCodeRange zip4 = new ZipCodeRange(6004, 7005);
//		ArrayList<ZipCodeRange> al = new ArrayList<ZipCodeRange>();
//		al.add(zip1);
//		al.add(zip4);
//		al.add(zip3);
//		al.add(zip2);
		
//		MergeSort mg = new MergeSort();
//		ArrayList<ZipCodeRange> al1 = mg.sortByMerge(zipCodeList);
		ZipCodeOptimizer zip = new ZipCodeOptimizer();
		ArrayList<ZipCodeRange> resList = zip.optimizeRange(zipCodeList);
		
		Iterator<ZipCodeRange> it = resList.iterator();
		while(it.hasNext()) {
			ZipCodeRange res = it.next();
			System.out.printf("(%d,%d) \n", res.start, res.end);
		}
		}
	}