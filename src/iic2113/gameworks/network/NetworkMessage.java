package src.iic2113.gameworks.network;

import java.io.Serializable;
import java.net.InetAddress;

public class NetworkMessage implements Serializable{
    
    public static final int TYPE_HELLO = 0;
    public static final int TYPE_HELLO_RES = 1;
    public static final int TYPE_BYE = 2;
    public static final int TYPE_TEXT = 3;
    public static final int TYPE_FILE = 4;
    public static final int TYPE_FILE_END = 5;
    public static final int SYSTEM_MESSAGE = 6;
    public static final int TYPE_FILE_IN = 7;
    public static final int TYPE_READ_IMAGE = 8;
    
    String gameInstance;
    int type;
    String content;
    boolean sent;
    InetAddress sender;
    InetAddress receiver;
    int port;
    int senderPort;
    
    /**  
	NetworkMessage constructor */
    public NetworkMessage(int t,String gameInstance, String c) {
        this.type = t;
        this.gameInstance=gameInstance;
        this.content = c;
        this.senderPort=Network.getPort();
        sent = false;
    }
    
    /**  
	Creates a new NetworkMessage based on a received text */
    public static NetworkMessage parse(String message) {
        String[] s = message.split("-");
        int t = Integer.parseInt(s[0]);
        String gameInstance=s[1];
        
        NetworkMessage res = new NetworkMessage(t,gameInstance,message.substring(s[0].length()+1));
        res.setPort(Network.getPort());
        return res;
    }
    /** The following methods are getters for each of the specified attributes*/
    public String getContent() {
        return this.content;
    }
    
    public boolean getSent() {
        return this.sent;
    }
    
    public void setSender(InetAddress s) {
        this.sender = s;
    }
    
    public InetAddress getSender() {
        return this.sender;
    }
    public int getSenderPort(){
        return this.senderPort;
    }
    public void setReceiver(InetAddress r) {
        this.receiver = r;
    }
    public InetAddress getReceiver() {
        return this.receiver;
    }
    public void setPort(int r) {
        this.port = r;
    }
    public int getPort() {
        return this.port;
    }
    
    
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type=type;
    }
    
    public void setTypeandContent(int t, String c){
        this.content = c;        
        this.type = t;
    }
    
    /**  
	Returns the final form it is send as.
	It's inverse operation in parse */
    public String getString() {
        return this.type + "-" +this.gameInstance + "-" + this.content;
    }
}
