import com.sun.jmx.snmp.InetAddressAcl;

import java.net.*;
import java.util.ArrayList;

public class Server {
    private static ArrayList<InetSocketAddress> clientIps = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        DatagramSocket socket = new DatagramSocket(null);
        socket.bind(new InetSocketAddress("10.0.0.134", 7777));
        byte[] buffer = new byte[512];

        DatagramPacket request = new DatagramPacket(buffer, buffer.length);
        while (true) {

            socket.receive(request);
            System.out.println(new String(buffer, 0,request.getLength()));
            buffer = "Response from server".getBytes();
            DatagramPacket response = new DatagramPacket(buffer, buffer.length, request.getAddress(), request.getPort());
            socket.send(response);
        }
    }
    public static boolean ipIsInList(InetAddress adr){
        for(InetSocketAddress i : clientIps){
            if(adr.equals(i.getAddress())){
                return true;
            }
        }
        return false;
    }
}