import java.util.ArrayList;

class IntroArrayList
{
	public static void main(String[] args)
	{
		ArrayList <Integer> list = new ArrayList<Integer>();

		//데이터 저장
		list.add(new Integer(11));
		list.add(new Integer(22));
		list.add(new Integer(33));

		//데이터 참조
		System.out.println("1차 잠조 ");
		for(int i = 0; i<list.size(); i++)
			System.out.println(list.get(i)); // 0이 첫 번째

		//데이터 삭제
		list.remove(0); // 0이 전달되었으므로 첫번째 데이터 삭제
		System.out.println("2차 잠조");
		for(int i = 0; i<list.size(); i++)
			System.out.println(list.get(i));
	}
}