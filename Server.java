import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String args[]) throws Exception{
        int port = 9991;
        System.out.println("Server has started ");
        ServerSocket ss = new ServerSocket(port);
        Socket s = ss.accept();
        System.out.println("Client connected ");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String output = br.readLine();
        System.out.println("Client : "+output+" Connected");
        String nickname = output.substring(0,3);
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);
        out.println(nickname);
        os.flush();
    }
    
}