package d1212;

public class FileCopyMain {

	public static void main(String[] args) {
		FileCopyWithProgress copy1
		=new FileCopyWithProgress("copy1", "source.txt","dest1.txt");
		FileCopyWithProgress copy2
		=new FileCopyWithProgress("copy2", "source2.txt","dest2.txt");
		FileCopyWithProgress copy3
		=new FileCopyWithProgress("copy3", "source3.txt","dest3.txt");
		
		copy1.start();
		copy2.start();
		copy3.start();
	}

}
