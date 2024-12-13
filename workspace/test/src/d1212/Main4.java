package d1212;

final class MyFinal{
	String MENU1="김밥";
	
	public void print() {
		System.out.println(MENU1);
	}
}

//class MyFinal extends MyFinal{
//		
//}

public class Main4 {
	
	public static void main(String[] args) {
		MyFinal my=new MyFinal();
		my.MENU1="라면";
	}
}	
