import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


public class Main {
  public static void main(String[] args) {
    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.out.println("Logs from your program will appear here!");

    final List<String> VALID_PATHS = List.of(
      "/"
    );

    try {

      ServerSocket serverSocket = new ServerSocket(4221);
    
      // Since the tester restarts your program quite often, setting SO_REUSEADDR
      // ensures that we don't run into 'Address already in use' errors
      serverSocket.setReuseAddress(true);
    
      Socket client = serverSocket.accept(); // Wait for connection from client.

     // input stream
     BufferedReader inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
      
     final String serverResponse = new HttpResponse(Status.OK).getResponse();

     // splits each line in the inputStream by the CRLF line terminator for windows, line feed for unxix/mac/linux and carriage return for old mac
      List<String> lines = inputStream.lines().toList();
      String requestline = lines.get(0);
      List<String> headers = lines.subList(1, lines.size());
      // Split out the request line into its components
      List<String> requestLineParts = List.of(requestline.split(" "));
      String method = requestLineParts.get(0);
      String path = requestLineParts.get(1);
      String version = requestLineParts.get(2);

      String response = "Heello World!";
      if (path.equals("/")) {
        response = serverResponse;
      } else {
        response = new HttpResponse(Status.NOT_FOUND).getResponse();
      }

      // write the response
      client.getOutputStream().write(response.getBytes());

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
