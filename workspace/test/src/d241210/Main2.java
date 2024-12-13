package d241210;

public class Main2 {

	public static void main(String[] args) {
		// 1에서 100까지 합을 구하세요
		// 최종합 출력 목표
		
		int sum=0;
		for(int i=1; i<=100; i++) {
			sum=sum+i;
		}
		System.out.println(sum);

		//최대값 최솟값
		int max=0;
		int[] data= {100, 400, 304, 32, 65};
		for(int i=0; i<data.length; i++) {
			if(data[i]>max) {
				max=data[i];
			}
		}
		System.out.println(max);
		
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++) {
				System.out.println(i+","+j);
				System.out.println(" ");
			}
			System.out.println();
		}
		
		int k=0;
		System.out.println(k++);
		System.out.println(++k);
	}

}
