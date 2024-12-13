package d1212;

	abstract class Sum {
	    //추상메소드 입니다.
	    public abstract String toString();
	    
	    public String sum(int i, int k){
	        int sum = i+k;
	        return ""+ sum;
	    }
	}
	
class My1Sum extends Sum{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "두 수의 합은 "+ sum(10,20);
	}
	
}

class My2Sum extends Sum{
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "result "+ sum(10,20);
	}
	
}


public class SumMain {
	public static void main(String[] args) {
		Sum s=new My1Sum();
		System.out.println(s);
		
		s=new My2Sum();
		System.out.println(s);
		
	}

}
