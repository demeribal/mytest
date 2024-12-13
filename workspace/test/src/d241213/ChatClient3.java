package d241213;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient3 {

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
			//데이터가 올 때까지 이 자리에 머물러 있게 반복
			//들어오는 데이터가 0이면 계속 반복
			while(in.available()==0) {}
			while(in.available()>0) {
				System.out.println((char)in.read());
				if(in.available()==0) {
					System.out.println();
				}
			}
			System.out.println("채팅입력");
			String msg=new Scanner(System.in).nextLine();
			out.write(msg.getBytes());
			out.flush();
			Thread.sleep(1000);
			}
			//System.out.println("클라이언트 종료");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
