import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class EchoServer {
    public static void main(String[] args) {
        try {
            out.println("Waiting for connection");
            ServerSocket ss = new ServerSocket(8080);
            Socket soc = ss.accept();
            out.println("Connection successful");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            Integer num = Integer.valueOf(in.readLine());
            Integer ans = 1;
            while(num>0) {
                ans *= num;
                num--;
            }
            String msg = Integer.toString(ans);
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println("Server says: " + msg);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}