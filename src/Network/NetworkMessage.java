
package src.Network;
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
    
    String conversation;
    int type;
    String content;
    boolean sent;
    InetAddress sender;
    InetAddress receiver;
    int port;
    int senderPort;
    
    //Cambiar para que despues se puedan mandar otras cosas
    //Posiblemente por un arreglo de bytes
    public NetworkMessage(int t,String conversation, String c) {
        this.type = t;
        this.conversation=conversation;
        this.content = c;
        this.senderPort=Network.getPort();
        sent = false;
    }
    
    //Crea un objeto networkMessage a partir de un texto recibido
    public static NetworkMessage parse(String message) {
        System.out.println("Recibiendo mensaje: " + message);
        String[] s = message.split("-");
        int t = Integer.parseInt(s[0]);
        String conversation=s[1];
        
        NetworkMessage res = new NetworkMessage(t,conversation,message.substring(s[0].length()+1));
        res.setPort(Network.getPort());
        return res;
    }
    
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
    
    
    //Retorna la representacion final que se manda.
    //La operacion inversa es parse
    public String getString() {
        return this.type + "-" +this.conversation + "-" + this.content;
    }
}
