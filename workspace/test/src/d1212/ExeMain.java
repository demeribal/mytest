package d1212;

public class ExeMain {

	public static void main(String[] args) {
		Module module1=new Module("모듈1");
		Module module2=new Module("모듈2");
		Module module3=new Module("모듈3");
		
//		module1.run();
//		module2.run();
//		module3.run();
		
		module1.start();
		module2.start();
		module3.start();
	}

}
