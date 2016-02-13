package sorting;

import org.junit.Test;

public class SortTest {

	int[] inputArray = { 15, 2, 5, 100, 7, 9, 13, 15, 10, 25, 1 };

	private Sort sort;

	@Test
	public void testBubbleSort() {
		sort = new BubbleSort();
		sort.sort(inputArray);

	}
	
	@Test
	public void testSelectionSort() {
		sort = new SelectionSort();
		sort.sort(inputArray);

	}
	
	@Test
	public void testInsertionSort() {
		sort = new InsertionSort();
		sort.sort(inputArray);

	}
	
	@Test
	public void testMergeSort() {
		sort = new MergeSort();
		sort.sort(inputArray);

	}



}
