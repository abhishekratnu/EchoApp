import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.out;

public class EchoServer {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(8080);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        out.println("Waiting for connection");

        while(true) {
            Socket soc = ss.accept();
            out.println("Connection successful");
            pool.submit(() -> {
                try {
                    Socket client = soc;
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    Integer num = Integer.valueOf(in.readLine());
                    Integer ans = 1;
                    while(num>0) {
                        ans *= num;
                        num--;
                    }
                    String msg = Integer.toString(ans);
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    out.println("Server says: " + msg);
                }
                catch (IOException | NumberFormatException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}