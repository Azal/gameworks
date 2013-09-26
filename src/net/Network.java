package src.net;

import java.io.FileOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.*;
import java.io.FileOutputStream;

public class Network implements Observer,
       Serializable {
    
    private static Inet4Address localAddress;
    int subnet;
    private static int port;
    private boolean portChosen=false;
    //private LinkedList<NetworkUser> users;
    
    Sender sender;
    Receiver receiver;
    public Network() throws Exception {
        port=6740;
        while(!portChosen){
       if(checkPort(port))portChosen=true;
       else if(port<6750){port+=1;}
        }
        localAddress = (Inet4Address)Inet4Address.getLocalHost();
        
        //users = new LinkedList<NetworkUser>();
        
        sender = new Sender();
        receiver = new Receiver(this);
        receiver.addObserver(this);
    }
    public boolean checkPort(int _port){
        boolean portTaken = false;
        ServerSocket socket = null;
    try {
        socket = new ServerSocket(_port);
        socket.close();
        return true;
    } catch (IOException e) {
        portTaken = true;
        return false;
    } finally {
        if (socket != null)
            try {
                socket.close();
            } catch (IOException e) {return false;}
}
    }
    public void reloadQueue(LinkedBlockingQueue<NetworkMessage> queue){
        sender.messageQueue=queue;
    }
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
    public void restoreQueue(String[] messages){
        for(int i=0;i<messages.length;i++){
            
        }
    }
    public void init() {
        Thread sendThread = new Thread(sender);
        Thread receiveThread = new Thread(receiver);
        
        sendThread.start();
        receiveThread.start();
    }

    public void send(String s,String conversation, InetAddress u, int port) {
        int d = s.indexOf("@PATH:") == -1 ? NetworkMessage.TYPE_TEXT : NetworkMessage.TYPE_FILE;
        NetworkMessage m = new NetworkMessage(d ,conversation,s);
        sender.send(m,u,port);
    }
    
    public void send(NetworkMessage m, InetAddress u,int port) {
        sender.send(m,u,port);
    }
    
    /*
    public void send(String s) {
        for(NetworkUser u : users) {
            this.send(s,u);
        }
    }
    */
    
    public static InetAddress getLocalAddress() {
        return localAddress;
    }
    
    public static int getPort() {
        return port;
    }
    
    public void addReceiverObserver(Observer o) {
        receiver.addObserver(o);
    }
    
    //Observer Interface method. It executes when a message is received.
    @Override
    public void update(Observable obs, Object obj) {
        NetworkMessage message = (NetworkMessage)obj;
        //If we are greeted, we say hi back.
        if(message.getType() == NetworkMessage.TYPE_HELLO)
            sender.send(new NetworkMessage(NetworkMessage.TYPE_HELLO_RES,"",Network.getPort()+""), message.sender,message.port);
            
        if(message.getType() == NetworkMessage.TYPE_HELLO_RES)
            System.out.println("ACK " + message.getString() + "--" + message.sender);
        System.out.println(message.getContent());
    }
    
    
}
