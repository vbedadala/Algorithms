//package sorting;
//
//import java.util.Arrays;
//
//public class MergeSort implements Sort {
//
//    @Override
//    public int[] sort(int[] input) {
//	input = mergeSort(input);
//	for (int i = 0; i < input.length; i++) {
//	    System.out.println(input[i] + "    ");
//	}
//	return input;
//    }
//
//    private int[] mergeSort(int[] input) {
//	if (input.length <= 1) {
//	    return input;
//	}
//	int[] mid1 = mergeSort(Arrays.copyOfRange(input, 0,
//		(int) Math.floor(input.length / 2)));
//	int[] mid2 = mergeSort(Arrays.copyOfRange(input,
//		(int) Math.floor(input.length / 2), (input.length)));
//	int[] merged = merge(mid1, mid2);
//	return merged;
//
//    }
//
//    private int[] merge(int[] input1, int[] input2) {
//	int[] merged = new int[input1.length + input2.length];
//	int i = 0;
//	int j = 0;
//	int r = 0;
//	while (i < input1.length && j < input2.length) {
//	    if (input1[i] <= input2[j]) {
//		merged[r] = input1[i];
//		r++;
//		i++;
//	    } else if (input1[i] > input2[j]) {
//		merged[r] = input2[j];
//		r++;
//		j++;
//	    }
//
//	}
//	while (j < input2.length) {
//	    merged[r] = input2[j];
//	    r++;
//	    j++;
//	}
//
//	while (i < input1.length) {
//	    merged[r] = input1[i];
//	    r++;
//	    i++;
//	}
//	return merged;
//    }
//
//}
