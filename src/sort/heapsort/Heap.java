package sort.heapsort;
/**
 * ����һ�����ѣ���ʵ���˶�����
 * @author Czuaphe Cui
 *
 */
public class Heap {
	
	private int SIZE;      // �����С
	private int HEAP_SIZE; // ʵ�ʶѵĴ�С
	private int[] arr;     // ��ʾ�ѵ����飬�Ѵ�1��ʼ��0��Ԫ��û��ʹ��
	
	public Heap(int[] arr) {
		this.arr = arr;
		this.SIZE = arr.length;
		this.HEAP_SIZE = SIZE - 1;
	}
	// ά�����ѵ�����
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
	// ����һ������
	public void buildMaxHeap() {
		for(int i = HEAP_SIZE / 2; i > 0; i --) {
			MaxHeapify(i);
			//outputArrayAsTree();
		}
	}
	// ������
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
	// ��������ʽ�������
	public void outputArrayAsTree() {
		int num = 4;  // ͨ�����鳤�ȣ���������Ĳ���
		int[] space = new int[num + 1];  // �������飬������ո���ڿո����
		for(int i = 1; i < num + 1; i ++) {
			space[i] = (int) (space[i - 1] +  Math.pow(2, i - 1));
		}
		// i ��ʾ�����Ĳ����ͱ���Ӧ����������ĸ�����j��ʾ��ո���±꣬k��ʾ�ڿո���±�
		for(int i = 0, j = num - 1, k = num, n = 1; i < num; i ++, j --, k -- ) {
			// ����Ӧ����������ĸ���
			int nums = (int) Math.pow(2, i);
			// �����ո�
			for(int x = 0; x < space[j]; x ++) {
				System.out.print(" ");
			}
			// ������ֺ��ڿո�
			for(int x = 0; x < nums; x ++) {
				if(x != 0) {
					for(int y = 0; y < space[k]; y ++) {
						System.out.print(" ");
					}
				}
				// �������
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
