package d1212;

public class Main3 {

	public static void main(String[] args) {
		Cal cal=new Cal();
		
		AbstractCal acal=new AbstractCal() {
			@Override
			public int mux(int a, int b) {
				// TODO Auto-generated method stub
				return a*b;
			}};
		System.out.println(acal.mux(10, 20));
		
		AbstractCal acal2=new ImplCal();
	}

}

class ImplCal extends AbstractCal{

	@Override
	public int mux(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}