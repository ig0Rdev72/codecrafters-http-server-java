import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args) {
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Logs from your program will appear here!");

    // Uncomment this block to pass the first stage
    
    try {
      ServerSocket serverSocket = new ServerSocket(4221);
    
      // Since the tester restarts your program quite often, setting SO_REUSEADDR
      // ensures that we don't run into 'Address already in use' errors
      serverSocket.setReuseAddress(true);
    
      Socket client = serverSocket.accept(); // Wait for connection from client.

     // get stream to output data to
     PrintWriter outputStream = new PrintWriter(client.getOutputStream(), true);
     // input stream
     BufferedReader inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
      
     final String serverResponse = "HTTP/1.1 200 OK\r\n\r\n";
      outputStream.println(serverResponse);

      System.out.println("accepted new connection");
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    }
  }
}
