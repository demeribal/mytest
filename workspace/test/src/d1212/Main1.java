package d1212;

class A{
	public void aprint() {
		System.out.println("A print");
	}
}

class AA extends A{
	@Override
	public void aprint() {
		System.out.println("AA print");
	}
}

public class Main1 {

	public static void main(String[] args) {
		A a=new A();
		a.aprint();
		AA aa=new AA();
		aa.aprint();
		//aa.super(); //super는 부모 객체를 의미(오류발생)
		A b=new AA(); //좌측은 부모클래스, 우측은 자식클래스
		//b.bprint(); //사용 불가, 부모클래스는 bprint를 가지고 있지 않다
		b.aprint();
		AA c=(AA) new A();
		c.aprint();
	}

}
