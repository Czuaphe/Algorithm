package sort;

import java.util.Random;

import sort.heapsort.Heap;

public class Main {
	public static void main(String[] args) {

		int num = 16;
		Random  random = new Random();
		
		// 随机一个数组
		int array[] = new int[num];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
		}
		
		Heap heap = new Heap(array);
		heap.outputArrayAsTree();

		long start = System.currentTimeMillis();
		heap.HeapSort();
		long end = System.currentTimeMillis();

		heap.outputArrayAsTree();
		System.out.println(end - start);
		
		
	}
}
