package d1212;

public class  MyRuns implements Runnable
{
	public void run(){
		show();
	}
	public void show(){
		for(int i=0;i<100;i++){
			if(((Thread.currentThread()).getName()).equals("a") ){
				System.out.print("a");
			}else if(((Thread.currentThread()).getName()).equals("b") ){
				System.out.print("b");
			}else if(((Thread.currentThread()).getName()).equals("c") ){
				System.out.print("c");
			}else{
				System.out.print("["+Thread.currentThread().getName()+i+"]");
			}
		}
	}
}