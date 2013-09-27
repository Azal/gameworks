package src.Network;

import java.io.IOException;
import java.net.InetAddress;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Connection implements Observer {
    /**
	-Connection via IP to other computers based on events. Now a functional chat.-
		-Reference to external code:-
		-Based on the code written by Felipe Cortés Saavedra(PUC)
	 *
	 *	@version  -
	    @created_by @group8/jpeeblesg
	    @update_log
	    	26/09/2013 - @group8/jpeeblesg
	 */
	
	Network network;
    private User localUser;
    private Conversation activeConversation;
    private LinkedList<Conversation> conversations;
    
    /**  
	Connection constructor */
	public Connection(){
        conversations = new LinkedList<Conversation>();
		conversations.add(new Conversation("Default"));
		activeConversation=conversations.get(0);
		System.out.println("Initiating network");
		try {
			network = new Network();
			network.init();
			network.addReceiverObserver(this);
			System.out.println("Network successfully initiated");
		}
		catch(Exception e) {
			System.err.println("Error initiating network\n" + e.getMessage());
		}
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                
            }
        });
        
        localUser = new User(Network.getLocalAddress(),Network.getPort());
	}
    @Override
    /**  
	Manages the types of messages and reaction such as the initial connection message(TYPE_HELLO) 
	and the normal chat text(TYPE_TEXT) */
    public void update(Observable o, Object message) {
        NetworkMessage m = (NetworkMessage)message;
        if(m.getType() == NetworkMessage.TYPE_TEXT){
            String contenido=m.getContent();
            System.out.print("Says: "+contenido);
            // ui.newMessage(m.getContent(),m.getSender().toString());
        }
       // else if(m.getType() == NetworkMessage.TYPE_HELLO_RES)
            // ui.newStatus("Usuario confirmo conexion :" + m.getSender().toString());
        else if(m.getType() == NetworkMessage.TYPE_BYE) {
            // this.deleteUser(m.getSender());
            System.out.println("User disconnected " + m.getSender().toString());
           // ui.newStatus("Usuario se desconecto :" + m.getSender().toString());
        }
        else if(m.getType() == NetworkMessage.TYPE_HELLO) {
            String contenido=m.getContent();
            String[] puertoSplitted=contenido.split("-");
        	String IP = m.getSender().toString().substring(1);
        	addUser(IP, " ",false);
            //for(int i=0; i<puertoSplitted.length-1; i++){
            //	System.out.println(puertoSplitted[i]);
           // }
            //ui.newMessage(m.getContent(), m.getSender().toString(), Integer.parseInt(puertoSplitted[puertoSplitted.length-1]));
            //ui.newMessage(puertoSplitted[0]+"-Conexion Creada",m.getSender().toString()+":"+puertoSplitted[puertoSplitted.length-1]);
            //ui.addAddressBack(m.getSender().toString().substring(1)+":"+puertoSplitted[puertoSplitted.length-1], puertoSplitted[0]);
        }
        else if(m.getType()==NetworkMessage.TYPE_READ_IMAGE){
            System.out.print("read image");
           //  ui.addImage(m.getContent().toString());
        }
    }
    public void sendMessage(String text,String conversacion, User dest) {
        System.out.println("Sending message");
        String puerto=String.valueOf(localUser.getPort());
        network.send(text,conversacion,dest.getAddress(),dest.getPort());
        System.out.println("Message sent");
    }
    public boolean addUser(String address,String Group,boolean firstTime) {
        try {
            InetAddress ad = InetAddress.getByName(address);
            User u = new User(ad,Integer.parseInt("6740"));
            System.out.println("User successfully added");
            if(firstTime)sendHiMessage(u);
            return activeConversation.users.add(u);
        }
        catch(Exception e) {
            System.out.println("Error adding user with ip "+address+"\n"+e.getMessage());
        }
        return false;
    }
    private void sendHiMessage(User dest) {
        System.out.println("Sending invite to user " + dest.toString());
        String puerto="6740";
        network.send(new NetworkMessage(NetworkMessage.TYPE_HELLO,activeConversation.name,Network.getPort()+""), dest.getAddress(),dest.getPort());
    }
    public void sendMessage(String text,String conversacion) {
        if(activeConversation.users.size() == 0)
            System.out.println("There are no users to send this message to");
        for(User u : activeConversation.users){
          sendMessage(text,conversacion, u);
        }
    }
}
