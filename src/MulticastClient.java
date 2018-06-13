import java.io.*;
import java.net.*;
public class MulticastClient {
    // get the port number to use from the command line

    public static void main(String args[ ]) throws Exception {
        int clientport = 7777;







        // create a DatagramSocket


        DatagramSocket udpClientSocket = new DatagramSocket();
        // get the IP address of the local machine - we will use this as the address to send the data to (i.e. the server program running locally)
        InetAddress serverIPAddress = InetAddress.getByName("localhost");

        //connect to server



        byte[] connectData = new byte[1024];

        String connect="Client Connected";

        connectData = connect.getBytes();

        int connectpacketSize = connectData.length;

        DatagramPacket connectPacket = new DatagramPacket(connectData, connectpacketSize, serverIPAddress, clientport);
        udpClientSocket.send(connectPacket);


        while(true)
        {


            // create byte buffer to hold the message to send, which is at lease as long as the number of bytes in the message
            // 1024 bytes is pretty long, we could count the bytes in the message first, then creat this buffer, but we'll keep it like this for the time being
            byte[] sendData = new byte[1024];
            // form a message to send


            BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
            String letter = null;
            System.out.println ("Enter message: ");
            try
            {
                letter= in.readLine ();
            }
            catch (IOException ex)
            {
                System.out.println("there was a problem an the keyboard could not be read.");
            }


            // put this message into our emty buffer/array of bytes



            sendData = letter.getBytes();




            //InetAddress address = InetAddress.getByName("localhost");
            int packetSize = sendData.length;





            // create a DatagramPacket with the data, IP address and port number
            DatagramPacket sendPacket = new DatagramPacket(sendData, packetSize, serverIPAddress, clientport);


            // send the UDP packet


            udpClientSocket.send(sendPacket);
            // Create a byte buffer/arrag
            byte[] receiveData = new byte[1024];

            // set up a DatagramPacket to recieve the data into - call it receivePacket
            // Hint: see the server class
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);


            // recieve a packet from the server (blocks until the packets are recieved)
            // Hint: see the server class
            udpClientSocket.receive(receivePacket);

            // extract the reply from the DatagramPacket
            String serverReply = (new String(receivePacket.getData())).trim();




            // print to the screen

            System.out.println(""+serverReply);



        }


        //udpClientSocket.close();

    }


}