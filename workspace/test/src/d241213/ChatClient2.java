package d241213;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatClient2 {

	public static void main(String[] args) {
		Socket socket=null;
		InputStream in=null;
		OutputStream out=null;
		
		System.out.println("클라이언트 프로그램");
		
		try {
			socket=new Socket("211.253.53.72",7777);
			System.out.println("서버 접속");
			in=socket.getInputStream();
			out=socket.getOutputStream();
			
			while(true) {
			while(in.available()>0) {
				System.out.println((char)in.read());
				if(in.available()==0) {
					System.out.println();
				}
			}
			}
			//System.out.println("클라이언트 종료");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
