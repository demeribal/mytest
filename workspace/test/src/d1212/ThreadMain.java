package d1212;

public class ThreadMain {
	public static void main(String[] args) {
		MyThread1 my1=new MyThread1("first");
		my1.start();
		MyThread1 my2=new MyThread1("second");
		my2.start();
		
		for(int i=0; i<100; i++) {
			System.out.println("i:"+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
