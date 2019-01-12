import java.util.Arrays;

class MyFirstStream2{
	public static void main(String[] args)
	{
		int[] ar = {1,2,3,4,5};

		int sum = Arrays.stream(ar)				// Stream 생성
						.filter(n->n%2 == 1) 	//filter 통과
						.sum();					//filter 통과 후 그 결과 반환

		System.out.println(sum);
	}
}