
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;



public class Client{

    public static void main(String[] args) throws Exception{
        String ip = "localhost";
        int port = 9991;
        Socket s = new Socket(ip,port);

        String str = "Tathya Dixit";

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);
        out.println(str);
        os.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String output = br.readLine();
        System.out.println("Nickname : "+output);
        s.close();





    }
}