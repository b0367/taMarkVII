import java.io.*;
import java.net.*;
public class MulticastServer {
    // java UDPServer port
    public static void main(String args[ ]) throws Exception
    {



        int serverport = 7777;
        int count=0;
        int [] clientport=new int[100];


        // Open a new datagram socket on the specified port
        DatagramSocket udpServerSocket = new DatagramSocket(serverport);

        while(true)


        {

            // create byte buffers to hold the messages to send and recieve, which are at least as long as the number of bytes in the message
            // 1024 bytes is pretty long, we could count the bytes in the message first, then create this buffer, but we'll keep it like this for the time being
            byte[] receiveData = new byte[1024];


            // create an empty DatagramPacket packet
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // block until there is a packet to recieve, then recieve it  (into our empty packet)
            udpServerSocket.receive(receivePacket);


            // extract the message from the packet and make it into a string, then trim off any end characters
            String clientMessage = (new String(receivePacket.getData())).trim();

            String t = "Client Connected";
            if(clientMessage.compareTo(t) > 0)
            {



                for(int i=0; i<clientport.length;i++)
                {
                    clientport[i]=receivePacket.getPort();
                }
                System.out.println(""+clientport);
            }


            else{



                System.out.println("Client message: "+clientMessage);


                // get the IP address of the recieved packet

                InetAddress clientaddress=receivePacket.getAddress();





                // get the port number which the recieved connection came from (i.e. the port number the client automatically assigned to it's end when it created the UDP connection to the port on the server)
                //int clientport=receivePacket.getPort();

                // compose a response message
                String letter = "Message Sent";
                byte[] data = letter.getBytes();

                // create an empty buffer/array of bytes to send back


                // assign the message to the send buffer


                int packetSize = data.length;


                for(int i=0;i<=clientport.length ; i++)
                {

                    DatagramPacket sendPacket = new DatagramPacket(data, packetSize, clientaddress, clientport[i]);
                    udpServerSocket.send(sendPacket);

                }
            }
        }

    }

}