package sort.heapsort;
/**
 * 这是一个最大堆，并实现了堆排序
 * @author Czuaphe Cui
 *
 */
public class Heap {
	
	private int SIZE;      // 数组大小
	private int HEAP_SIZE; // 实际堆的大小
	private int[] arr;     // 表示堆的数组，堆从1开始，0号元素没有使用
	
	public Heap(int[] arr) {
		this.arr = arr;
		this.SIZE = arr.length;
		this.HEAP_SIZE = SIZE - 1;
	}
	// 维护最大堆的性质
	public void MaxHeapify(int i) {
		
		int l = LEFT(i);
	    int r = RIGHT(i);
	    int largest = i;

	    if(l <= HEAP_SIZE && arr[l] > arr[i]) {
	        largest = l;
	    }
	    if(r <= HEAP_SIZE && arr[r] > arr[largest]) {
	        largest = r;
	    }
	    if(largest != i) {
	        swap(i, largest);
	        
	        // TODO output delete
	        //outputArrayAsTree();
	        
	        MaxHeapify(largest);
	    }
	}
	// 构建一个最大堆
	public void buildMaxHeap() {
		for(int i = HEAP_SIZE / 2; i > 0; i --) {
			MaxHeapify(i);
			//outputArrayAsTree();
		}
	}
	// 堆排序
	public void HeapSort() {
		buildMaxHeap();
		for( ; HEAP_SIZE > 1; HEAP_SIZE --){
			MaxHeapify(1);
			swap(1, HEAP_SIZE);
			
		}
		HEAP_SIZE = SIZE - 1;
	}
	
	public int[] getArray() {
		return arr;
	}
	// 以树的形式输出数组
	public void outputArrayAsTree() {
		int num = 4;  // 通过数组长度，计算出树的层数
		int[] space = new int[num + 1];  // 辅助数组，计算外空格和内空格个数
		for(int i = 1; i < num + 1; i ++) {
			space[i] = (int) (space[i - 1] +  Math.pow(2, i - 1));
		}
		// i 表示的树的层数和本层应该输出的数的个数，j表示外空格的下标，k表示内空格的下标
		for(int i = 0, j = num - 1, k = num, n = 1; i < num; i ++, j --, k -- ) {
			// 本层应该输出的数的个数
			int nums = (int) Math.pow(2, i);
			// 输出外空格
			for(int x = 0; x < space[j]; x ++) {
				System.out.print(" ");
			}
			// 输出数字和内空格
			for(int x = 0; x < nums; x ++) {
				if(x != 0) {
					for(int y = 0; y < space[k]; y ++) {
						System.out.print(" ");
					}
				}
				// 输出数据
				if(n <= HEAP_SIZE) {
					System.out.print(arr[n]);
					n ++;
				} else {
					break;
				}
				
			}
			System.out.println();
		}
	}
	
	@SuppressWarnings("unused")
	private int PARENT(int i) {
		return i / 2;
	}
	
	private int LEFT(int i) {
		return i * 2;
	}
	
	private int RIGHT(int i) {
		return i * 2 + 1;
	}
	
	private void swap(int i, int j) {
		int tem = arr[i];
		arr[i] = arr[j];
		arr[j] = tem;
	}
}
