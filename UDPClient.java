import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        System.out.println("Enter the number to send : ");
        int i = sc.nextInt();
        System.out.println("Sending the data for multiplication ");
        byte[] b = String.valueOf(i).getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println("ip : "+ia);

        DatagramPacket dp = new DatagramPacket(b,b.length,ia, 9991);
        ds.send(dp);
        byte[] b1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(b1,b1.length);
        ds.receive(dp1);

        String str = new String(dp1.getData());
        System.out.println("Server sent : " +str);
        

        ds.close();
        
    }
}
