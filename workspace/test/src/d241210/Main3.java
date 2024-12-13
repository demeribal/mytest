package d241210;

public class Main3 {

	public static void main(String[] args) {
		int i=40;
		if(i>=1 && i<=100) {
			System.out.println("i는 1에서 100사이 값");
		}
		if(i<1 || i>100) {
			System.out.println("i는 1과 100사이의 값이 아님");
		}
		int s= 1>100 ? 1 :100; //앞에 조건문이 참이면 1 거짓이면 100

	}

}
