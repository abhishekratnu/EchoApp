import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try {
            System.out.println("Initiating connection");
            Socket soc = new Socket("localhost", 8080);
            //system.in is for reading data from keyboard
            BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a message");
            String msg = userinput.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(msg);
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println(in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
