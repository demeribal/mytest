package d241210;

public class Main1 {

	public static void main(String[] args) {
		System.out.println(10%3);
		
		//홀수 짝수 판별
		int a=100;

		if(a%2==0){
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
			
		//3의 배수 출력(0~100)
		for(int i=0; i<=100; i++) {
			if(i%3==0) {
				System.out.println(i);
			}
			
		//3의 배수의 개수 확인(0~100)
		int cnt=0;
		for(int j=0; j<=100; j++) {
			if(j%3==0) {
				cnt++;
			}
		}
			System.out.println(cnt);
			
	}
		}
	}
