package d241213;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class URLMain {

	public static void main(String[] args) {
		try {
//		URL url=new URL("https://localhos:8080/insert?a=10&b=20");
//		System.out.println(url.getProtocol()); //https
//		System.out.println(url.getHost()); //localhos
//		System.out.println(url.getPort()); //8080
//		System.out.println(url.getPath()); // /insert
//		System.out.println(url.getQuery()); //a=10&b=20
			
		URL url=new URL("https://n.news.naver.com/mnews/article/052/0002127250");
		InputStream in=url.openStream();
		
		/*
		while(in.available()>0) {
			System.out.println((char)in.read());
		}
		*/
		
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String temp="";
		while((temp=br.readLine())!=null) {
			System.out.println(temp);
		}
		br.close();
		}catch (Exception e) {}
	}

}
