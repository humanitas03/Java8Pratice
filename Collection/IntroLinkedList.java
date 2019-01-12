import java.util.LinkedList;

class IntroLinkedList
{
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<Integer>();

		//데이터 저장
		list.add(new Integer(11));
		list.add(new Integer(22));
		list.add(new Integer(33));

		//데이터 참조
		System.out.println("1차 참조");
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));

		//데이터 삭제
		list.remove(0);
		System.out.println("2차 참조");
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}
}