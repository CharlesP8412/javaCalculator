
import java.io.*;
import java.net.Socket;

import org.json.JSONObject;

class RequestProcessor implements Runnable{
  private Socket socket = null;
  private OutputStream os = null;
  private BufferedReader in = null;
  private DataInputStream dis = null;
  private String msgToClient = "HTTP/1.1 200 OK\n"  
  + "Server: HTTP server/0.1\n" 
  + "Access-Control-Allow-Origin: *\n\n";
  private JSONObject jsonObject = new JSONObject();
  
  public RequestProcessor(Socket Socket){
    super();
    try {
      socket = Socket;
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      os = socket.getOutputStream();
          } catch(IOException e){
            e.printStackTrace();
          }
  }

  public void run() {
    //Your Code here
    //Rx JSON from html
    /* 
    {
      leftOperand: x
      rightOperand: y
      operation: *
    }
    */
    //Parse JSON into a function that will return the result  (Expressoin will be )
    /* 
    function (num1, num2, operation){
      //May need to convert nums to Numbers
      switch(operation){
        case '+':
        num1 + num2
        break;
        case '-':
        num1 - num2
        break;
        case '*':
        num1 * num2
        break;
        case '/':
        num1 / num2
        break;
        case '%':
        num1 % num2
        break;
      }
    }
 */
    //End your Code
    String response = msgToClient + jsonObject.toString();
    os.write(response.getBytes());
    os.flush();
    socket.close();
  }
}