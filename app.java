package RequestProcessor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args){
    System.out.println("Starting Server...");
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(8080);
      while(true){
        System.out.println("Listening on 8080...");
        Socket clientSocket = serverSocket.accept();
        new RequestProcessor(clientSocket).run();
      }
    } catch (IOException e){
    }
  }
}