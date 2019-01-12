import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

class Apple{
	private int weight;

	public Apple(int weight)
	{
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
	}
}

class StreamTest{
	public static void main(String[] args)
	{
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple(100));
		apples.add(new Apple(88));
		apples.add(new Apple(37));

		List<Integer> applesWeight = apples.stream()
										.map(Apple::getWeight)
									//	.map((apple)->apple.getWeight())
										.collect(Collectors.toList());
		System.out.println(applesWeight);
	}
}
