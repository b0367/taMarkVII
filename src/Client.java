import java.net.*;
import java.util.Scanner;

public class Client {


    public static void main(String args[]) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        Scanner s = new Scanner(System.in);
        DatagramPacket request = new DatagramPacket(new byte[1], 1, new InetSocketAddress("10.0.0.134", 7777));
        while (true) {
            request.setData(s.nextLine().getBytes());
            socket.send(request);
            byte[] buffer = new byte[512];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);
            String response_string = new String(buffer, 0, response.getLength());
            System.out.println(response_string);
            Thread.sleep(1000);
        }

    }
}