# Java 1.8 Fundamentals
=====================

## 1. abstreaction

* 추상화는 객체 지향의 주요 개념중에 하나로 사용자에게 불필요한 세부 내용을 숨겨 복잡성을 최소화 하는 것을 추구한다.
* 추상화의 범주에는 상속(inheritance), 다형성(polymorphism), 재정의(overriding)이 있음


* 상속(Inheritance)
	- 이미 존재하는 클래스를 물려받아 새로운 클래스를 만드는 기법
	- extends 키워드를이용하여 기존 클래스를 상속
	- Object클래스는 java 최상위 클래스로 모든 java 클래스는 Object 클래스를 상속
	- java는 다중 상속을 지원하지 않음

```java
	public class Manager extends Employ{
		//필드 및 메소드
	}
```

	- 상속 받은 자식 클래스는 부모 클래스의 필드와 메서드를 갖는다.
	- 상속받은 클래스라 할지라도 부모 클래스의 private 필드와 메서드는 접근 불가능
	- 부모 클래스가 private 필드나 메소드에 접근하는 protect, public 메소드를 갖고 있다면 이를 통해 접근 가능


* 메소드 오버라이딩(Method Overriding)
	- 부모 클래스에서 상속받은 메서드를 동일한 시그니처로 새롭게 정의하는 것
	- 오버라이딩은 메서드 시그니처(메서드명, 파라미터)를 같게 정의함
	- 상속 받은 메서드를 재정의 할 때 접근 지정자는 같거나 넓은 범위로 정의가능
	> Overloading
		> 클래스 내부에서 동일한 이름의 메서드를 파라미터를 달리하여 호출하는 것
```java
	public class Object{
		...
		public String toString(){
			return getClass().getName() + "@" + Integer.toHexString(hashCode());
		}
		.....
	}

	public class Point extends Object{
		...
		@Override
		public String toString(){
			return getClass().getName() + "[x="+x+ ", y=" + y + "]";
		}
	}
```

* *Object Casting*
	- Java는 기본 데이터 타입(Primitive Type)에 대해 **Strong Typed**가 적용된 언어
	- 따라서 타입에 대한 연산이 이루어질 때 대상이 되는 피연산 대상은 동일한 타입으로 적용되어야 한다.

```java
	...
	int num = 10;
	String name = (int) num;		//compile Error
	...
```

	- 하지만, 객체 대상의 대임연산에서 상속 관계일 때 예외사항을 두엇음
	- 상속 관계에서 자식 타입의 객체가 부모 타입의 레퍼런스로 참조가 가능
```java
	class Parent{}

	class Child extends Parent{
		...
	}

	Parent parent = new Child();		//compile pass(Up-casting)
	Child child = (Child)parent;		//compile pass(Down-casting)
```

	> Binding
		- 자식 객체를 부모 클래스 타입의 레퍼런스로 참조 햇을 경우 오버라이딩 메서드는 자식 클래스 메서드로 바인딩
		- up-casting 이후에 생성된 인스턴스가 자식클래스 타입이라 할지라도 자식 클래스 고유 메서드 호출 불가
		- 하지만 자식 클래스가 부모 클래스로 부터 상속한 재정의 메서드가 있다면 부모 클래스 타입의 레퍼런스로 호출
		- 상속 관계에서 객체간 형변환과 재정의 메서드 바인딩은 다형성(Polymorphism) 구현의 기본



* 다형성(Polymorphism)
	- 다형성은 동일한 이름의 메서드 호출에 서로 다른 기능을 수행하는 것(ex: toString())
	- 전제 조건 : 상속 관계 구성 + 자식 클래스가 메서드 재정의

* 추상 클래스와 추상 메서드
	- 추상 클래스는 인스턴스 객체를 생성할 수 없는 부모 클래스 역할만 갖는 클래스
	- 하나 이상의 추상메서드를 갖는 클래스는 반드시 추상클래스로 정의되어야 한다.
	- 추상 클래스를 상속한 자식클래스는 상속받은 추상 메서드를 재정의하거나 추상클래스가 되어야 한다.

* 인터페이스(Interface)
	- 인터페이스를 활용하면 설계와 구현을 분리할 수 있다
		* 인터페이스에서는 기능이 필요한 메서드만 선언하고 메서드 정의는 인터페이스를 상속한 클래스가 구현
		* 구현부를 가리는 효과


	- Java 8 이전에는 인터페이스의 모든 메서드는 추상 메서드여야 했음
		* 8 이상부터 static 메소드와 default 메서드 기능 추가
		* default 메서드를 추가함으로서 인터페이스에 확장 기능 추가가 용이
```java
	public interface IBehavior{
		void play();

		default void stop(){
			System.out.println("default method");
		}
	}

	public class Guitar implements IBehavior{
		//추상 메서드는 반드시 구현해야 하지만
		//default 메서드 Overriding은 Optional
		@Override
		public void play(){
			System.out.println("Play the guitar");
		}

		public static void main(String[] args)
		{
			Guitar myGuitar = new Guitar();
			myGuitar.stop();
		}
	}
```

## 2. Collection Framwork
* Java C/F
	- java Collection Framework는 객체들을 관리하기 위해 사용되는 컨테이너 클래스들의 집합체
	- 컨테이너 클래스 종류는 크게 List, Set, Queue, Map 계열로 구분
		* List interface : 순차적 나열로 순서 지정이 가능한 객체들의 집합
		* Set interface : 중복을 허락하지 않는 객체들의 집합
		* Queue interface : FIFO 구조 집합
		* Map interface : 키와 그 키에 대응하는 객체들로 이루어진 집합
	- 컬렉션 관련 인터페이스와 java.util.* 패키지에 포함되어 있음

* Collection Interface
	- 컬렉션 프레임워크 최상위 인터페이스
	- 요소(객체)에 대한 삽입, 삭제, 탐색의 기능
	- 주요 메소드
		* add() 	: 새로운 요소를 삽입. 중복을 허용하지 않는 경우 false 반환
		* clear()	: 모든 요소 제거
		* contains(): 파라미터로 전달되는 객체가 요소로 존재하는지 반환
		* isEmpty()	: 해당 컬렉션이 포함하고 있는 요소가 0인지 반환
		* remove()	: 파라미터로 전달되는 객체를 제거. 전달되는 객체가 요소로 존재하지 않으면 false 반환
		* size()	: 현재 포함하고 잇는 요소 개수 반환
		* iterator(): 해당 컬렉션이 포함하고 있는 요소 순회를 위한 iterator 객체를 반환
	- **Java 8 버전 이후 Stream 관련 메서드 추가**

* Generic Type
	- 컬렉션 프레임워크에 대해서 정확히 이해하기 위해서는 Generic에 대한 이해가 필요
	- Java Generic은 크게 Generic Type과 Generic 메소드로 구분
	- 클래스와 인터페이스에 문법을 통해 매개변수화 하는 것이 Generic Type
```java
	//일반 클래스의 정의
	public class Box{
		private Object object;

		public void setObject(Object object)
		{
			this.object = object;
		}

		public Object getObject(){
			return object;
		}
	}

	//Generic 클래스 정의
	public class GenericBox<T>{
		private T object;

		public void setObject(T object){
			this.object = object;
		}

		public T getObject(){
			return object;
		}
	}
```
	- Object 클래스는 최상위 클래스로서 java의 모든 클래스를 참조가능
	- 객체의 구분없이 배열에 담는것은 담을 때 편리성은 있으나 꺼낼때 문제가 발생

	- Generic 클래스는 타입 패러미터를 한개 이상 받는 클래스
	- 타입 파라미터 타입은 Generic 클래스 생성 시점에 결정
	- Generic 메서드는 Generic 클래스와 마찬가지로 한개 이상의 타입 파라미터를 받는 메서드
```java
	public class GenericClassSample<K, V>{
		private K key;
		private V value;

		public GenericClassSample(K key, V value){
			this.key = key;
			this.value = value;
		}

		public K getKey(){
			return key;
		}

		public void setKey(K key){
			this.key = key;
		}

		...
	}
``
## 3. Lambda & Functional Interface

* 

## 4. Stream