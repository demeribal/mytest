package d1212;

class ParentA{
	public ParentA() {
		System.out.println("parentA 생성자");
	}
	public ParentA(int a) {
		System.out.println("필드 parentA 생성자");
	}
	public void parentPrint() {
		// TODO Auto-generated method stub
		
	}
}

class ChildA extends ParentA{
	public ChildA() {
		//super();
		//super(0);
		System.out.println("ChildA 생성자");
		//super(0); //super는 부모 생성자를 호출하지만 부모가 먼저 생성한 후 나의 생성자 호출
		super.parentPrint();
	}
}

public class Main2 {
	public static void main(String[] args) {
		new ChildA(); //자식 생성 시 부모도 함께 생성
	}
	
}
