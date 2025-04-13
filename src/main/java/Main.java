import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
  public static void main(String[] args) {
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Logs from your program will appear here!");

    
    try {
      ServerSocket serverSocket = new ServerSocket(4221);
    
      // Since the tester restarts your program quite often, setting SO_REUSEADDR
      // ensures that we don't run into 'Address already in use' errors
      serverSocket.setReuseAddress(true);
    
      Socket client = serverSocket.accept(); // Wait for connection from client.

     // input stream
     BufferedReader inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
      
     final String serverResponse = new HttpResponse(Status.OK).getResponse();

      // read the request line
     while (inputStream.readLine(); != null) {
        System.out.println("request line: " + inputStream.readLine());
      
     }
  
     client.getOutputStream().write(serverResponse.getBytes());

      System.out.println("accepted new connection");
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    }
  }

  /**
   * Notes:
   *  - Http request is separated into 3 parts separated by CRLF (\r\n):
   *    1. Request line
   *   2. Headers - Zero or more each ended with the CRLF
   *   3. Body - Optional
   *  
   * First part is the reuqest line in format: HTTP METHOD PATH VERSION
   * - The second part is the headers, each header is in the format: KEY: VALUE2
   */
}
