package src.iic2113.gameworks.network;

import java.io.FileOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.*;

public class Network implements Observer,Serializable {
    /**Necessary attributes to implement a network: localAddress is a unique Inet4Address for the computer
     * The port is the port used by the computer to interact with other game instances.
     * Sender and receiver take care of the messages.
     */
    private static Inet4Address localAddress;
    int subnet;
    private static int port;
    private boolean portChosen=false;
    Sender sender;
    Receiver receiver;
    /**Constructor of Network: it sets the port, data receiver and sender.*/
    public Network() throws Exception {
        port=6740;
        while(!portChosen){
       if(checkPort(port))portChosen=true;
       else if(port<6750){port+=1;}
        }
        localAddress = (Inet4Address)Inet4Address.getLocalHost();
                
        sender = new Sender();
        receiver = new Receiver(port);
        receiver.addObserver(this);
    }
    /**In case the default is used by other application, we try using a new port. */
    public boolean checkPort(int _port){
        ServerSocket socket = null;
    try {
        socket = new ServerSocket(_port);
        socket.close();
        return true;
    } catch (IOException e) {
        return false;
    } finally {
        if (socket != null)
            try {
                socket.close();
            } catch (IOException e) {return false;}
}
    }
    /**If connection was lost/application was closed, we reload the queue of messages which weren't sent*/
    public void reloadQueue(LinkedBlockingQueue<NetworkMessage> queue){
        sender.messageQueue=queue;
    }
    /**If there are any  messages to be sent, we take care of adding them to the queue
     * These messages are stored in the file qtemp.ser */
    public void messagesQueue() throws IOException{
        try{
            if(!sender.messageQueue.isEmpty()){
            FileOutputStream f_out = new FileOutputStream("qtemp.ser");
            ObjectOutputStream out = new ObjectOutputStream(f_out);
            out.writeObject(sender.messageQueue);
            out.close();
            f_out.close();
            }
        }
        catch(IOException e){
        e.printStackTrace();
        }
    }
    /** The receiver and sender are initialized */
    public void init() {
        Thread sendThread = new Thread(sender);
        Thread receiveThread = new Thread(receiver);
        
        sendThread.start();
        receiveThread.start();
    }
    public static String getIP(){
    	return Network.getLocalAddress().toString().split("/")[1];
    }
    public static String getFullIP()
    {
    	return Network.getIP()+":"+Network.getPort();
    }
    /** Method to send messages to a given game instance*/
    public void send(String s,String gameInstance, InetAddress u, int port) {
        int d = s.indexOf("@PATH:") == -1 ? NetworkMessage.TYPE_TEXT : NetworkMessage.TYPE_FILE;
        NetworkMessage m = new NetworkMessage(d ,gameInstance,s);
        sender.send(m,u,port);
    }
    /** Method to send a network message to a given game instance */
    public void send(NetworkMessage m, InetAddress u,int port) {
        sender.send(m,u,port);
    }
    /** Getter of local address*/
    public static InetAddress getLocalAddress() {
        return localAddress;
    }
    /**Getter of port*/
    public static int getPort() {
        return port;
    }
    /**Adds a new observer (user) to the gameinstance*/
    public void addReceiverObserver(Observer o) {
        receiver.addObserver(o);
    }
    
    @Override
    /**Observer Interface method. It executes when a message is received.*/
    public void update(Observable obs, Object obj) {
        NetworkMessage message = (NetworkMessage)obj;
        //If we are greeted, we say hi back.
        if(message.getType() == NetworkMessage.TYPE_HELLO){
            sender.send(new NetworkMessage(NetworkMessage.TYPE_HELLO_RES,"",Network.getPort()+""), message.sender,message.port);
        }
    }
    
    
}
