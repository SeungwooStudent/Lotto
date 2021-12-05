import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<Integer>();
//		
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		int size = stack.size();
//		for(int i = 0; i < size; i++) {
//			System.out.println(stack.pop());
//		}
//		
////		stack.isEmpty(); stack아 너 비어있음?? 물어보는거 isEmpty
//		while(!stack.isEmpty()) {
//			int num = stack.size();
//			System.out.println(num);
//		}
		
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.add(100);
//		q.add(200);
//		q.add(300);
//		
//		while(!q.isEmpty()) {
//			int num = q.poll();
//			System.out.println(num);
//		}
		
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
//		
		int arr[] = {2,3,6,7,8,9};
		for(int num : arr) {
			System.out.println(set.contains(num));
		}
		
//		Random random = new Random();
//		int num = random.nextInt(45);
//		System.out.println(num);
		
}

}