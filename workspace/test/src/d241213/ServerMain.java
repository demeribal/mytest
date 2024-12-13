package d241213;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		ServerSocket server=null;
		Socket client=null;
		InputStream in=null;
		OutputStream out=null;
		
		// ip 주소: 211.253.53.72:1234
		System.out.println("서버프로그램");
		while(true) {
			try {
		server=new ServerSocket(1234);
			}catch (Exception e) {}
		System.out.println("접속 대기중...");
		try {
		client=server.accept();//대기상태
		System.out.println("클라이언트가 접속했습니다.");
		in=client.getInputStream();
		out=client.getOutputStream();
		}catch (Exception e) {}
		while(true) {
			try {
			System.out.println((char)in.read());
			}catch(Exception e) {}
		}
		}
		//System.out.println("서버프로그램 종료");
	}

}
