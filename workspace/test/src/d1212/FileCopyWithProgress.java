package d1212;

import java.io.*;
import java.nio.file.*;
//클래스는 하나의 기능에 대한 집합
public class FileCopyWithProgress extends Thread{
	String name;
    String sourcePath; // 원본 파일 경로
    String destinationPath; // 목적지 파일 경로
    
    public FileCopyWithProgress() {}
        
	public FileCopyWithProgress(String name, String sourcePath
			, String destinationPath) {
			
		this.name=name;
		this.sourcePath = sourcePath;
		this.destinationPath = destinationPath;
		}


	public void run() {

        try {
            File sourceFile = new File(sourcePath);
            File destFile = new File(destinationPath);

            // 원본 파일의 크기를 가져옵니다.
            long totalBytes = sourceFile.length();
            long copiedBytes = 0;

            // 파일 스트림을 설정합니다.
            try (FileInputStream fis = new FileInputStream(sourceFile);
                 FileOutputStream fos = new FileOutputStream(destFile)) {

                byte[] buffer = new byte[4096]; // 4KB씩 읽고 씁니다.
                int bytesRead;
    
                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                    copiedBytes += bytesRead;
                    try {
                    	Thread.sleep(500);
                    }catch (InterruptedException e) {
                    	e.printStackTrace();
                    }

                    // 복사 진행률을 계산하여 출력합니다.
                    int progress = (int) ((copiedBytes  * 100) / totalBytes);
                    System.out.print("\r" + name + ": " + progress + "%");
                }

                System.out.println("\n"+name+":File copied successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
        // 예시 실행
        String sourcePath = "source.txt"; // 원본 파일 경로
        String destPath = "destination.txt"; // 목적지 파일 경로

        FileCopyWithProgress copyThread = new FileCopyWithProgress("FileCopy", sourcePath, destPath);
        copyThread.start(); // 쓰레드 실행
    }
}
