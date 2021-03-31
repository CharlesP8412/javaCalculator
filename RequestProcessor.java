
import java.io.*;
import java.net.Socket;

// import org.json.JSONObject;

class RequestProcessor implements Runnable{
  private Socket socket = null;
  private OutputStream os = null;
  private BufferedReader in = null;
  private DataInputStream dis = null;
  private String msgToClient = "HTTP/1.1 200 OK\n"  
  + "Server: HTTP server/0.1\n" 
  + "Access-Control-Allow-Origin: *\n\n";
  // private JSONObject jsonObject = new JSONObject();
  
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
    System.out.println("RUN CLASS");
    int leftOperand = 2;
    int rightOperand =3;
    String operator = "+";
    int result = 0;
    switch(operator)
    {
       case "+":
       result = leftOperand + rightOperand;
       case "-":
       result = leftOperand - rightOperand;
       case "*":
       result = leftOperand * rightOperand;
       case "/":
       result = leftOperand / rightOperand;
       case "%":
       result = leftOperand % rightOperand;
    }
    System.out.println(result);
    // jsonObject={
    //   "Expression": leftOperand + operator + rightOperand,
    //   "Result": result
    // };
    //End your Code
    String response = msgToClient + jsonObject.toString();
    os.write(response.getBytes());
    os.flush();
    socket.close();
  }
}