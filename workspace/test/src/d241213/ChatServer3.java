package d241213;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class ChatServer3 {

	public static void main(String[] args) {
		ServerSocket server=null;
		Socket client=null;
		InputStream in=null;
		OutputStream out=null;
		
		System.out.println("서버프로그램");
		
		try {
		server=new ServerSocket(7777);
		System.out.println("서버 대기중...");
		client=server.accept();
		System.out.println("클라이언트 접속");
		in=client.getInputStream();
		out=client.getOutputStream();

		while(true) {
		//String msg="hello client!";
		System.out.println("채팅입력");
		String msg=new Scanner(System.in).nextLine();
		out.write(msg.getBytes());
		out.flush();
		Thread.sleep(1000);
		while(in.available()==0) {}
		while(in.available()>0) {
			System.out.println((char)in.read());
			if(in.available()==0) {
				System.out.println();
			}
		}
		
		//System.out.println("서버접속 종료");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
