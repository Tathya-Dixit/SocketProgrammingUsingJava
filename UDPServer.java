import java.net.*;


public class UDPServer {
    public static void main(String[] args) throws Exception{
     
        DatagramSocket ds = new DatagramSocket(9991);
        byte[] b1 = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b1, b1.length);
        ds.receive(dp);
        String str = new String(dp.getData());
        int num = Integer.parseInt(str.trim());
        System.out.println("Client sent : "+num);
        int result  = num*num;
        System.out.println("Sending result : "+result);
        byte[] b2 = String.valueOf(result).getBytes();
        InetAddress ia = InetAddress.getLocalHost();

        DatagramPacket dp1 = new DatagramPacket(b2, b2.length,ia,dp.getPort());
        ds.send(dp1);

    }
}
