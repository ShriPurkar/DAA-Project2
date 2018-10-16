package median;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MedianofMedian {

	public static void main(String[] args) {
		MedianofMedian med = new MedianofMedian();
		  List<Integer> arr = Arrays.asList(12,23,45,67128,129,300,301,302,303,304,305,306,307,308,309,310,100,99,98,97,96,95,94,93,92,91,90,89,45,46,47,48,99,199,198,197,196,224,345,344,347,348,349,123,124,125,126,127,128,129,300,301,302);	  
		System.out.println("Input Size:" +arr.size());
		  int k_th_element =25;
		  long startTime = System.nanoTime();
		  System.out.println(med.get_k_th_value(arr, k_th_element-1 ));
		  long endTime = System.nanoTime();
		  long timeDifference = endTime - startTime;
		  System.out.println("Number of inputs:"+ arr.size() + "  Time:" + timeDifference);
		  
		  System.out.println("To cross verify:");
		  Collections.sort(arr);
		  System.out.println(arr);
		  System.out.println(arr.get(k_th_element-1));}
		  
		  public int get_k_th_value(List<Integer> arr_1, int k_ele) {
			  if (arr_1.size() < 10) {
			   Collections.sort(arr_1);
			   return arr_1.get(k_ele);
			  }
			  ArrayList<Integer> medians = new ArrayList<Integer>();
			  for (int i = 0; i < arr_1.size() - arr_1.size() % 5; i = i + 5)
			   medians.add(get_median_of_median(arr_1.subList(i, i + 5)));
			  int var = get_median_of_median(medians);

			  ArrayList<Integer> l_divert = make_part(arr_1, var, true);
			  ArrayList<Integer> r_divert = make_part(arr_1, var, false);

			  return (l_divert.size() + 1 == k_ele) ? var : (l_divert.size() > k_ele) ? get_k_th_value(
					  l_divert, k_ele) : get_k_th_value(r_divert, k_ele - l_divert.size());
			 }

			 public int get_median_of_median(List<Integer> arr_2) {
			  Collections.sort(arr_2);
			  return arr_2.get(arr_2.size() / 2);
			 }

			 public ArrayList<Integer> make_part(List<Integer> arr_3, int var3,
			   boolean less_than_value) {
			  ArrayList<Integer> result = new ArrayList<Integer>();
			  for (int value : arr_3)
			   if (less_than_value && value < var3)
			    result.add(value);
			   else if (!less_than_value && value >= var3)
			    result.add(value);
			  return result;
		}

}
