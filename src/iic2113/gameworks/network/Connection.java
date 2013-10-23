package src.iic2113.gameworks.network;

import java.net.InetAddress;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

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

public class Connection implements Observer {	
	private Network network;
    private GameInstance activeConversation;
    private LinkedList<GameInstance> conversations;
    
    /**  
	Connection constructor */
	public Connection(){
        conversations = new LinkedList<GameInstance>();
		conversations.add(new GameInstance("Default"));
		activeConversation=conversations.get(0);
		System.out.println("Initiating network");
		try {
			setNetwork(new Network());
			getNetwork().init();
			getNetwork().addReceiverObserver(this);
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
            System.out.print("Says: "+contenido + "\n");
        }
        else if(m.getType() == NetworkMessage.TYPE_BYE) {
            System.out.println("User disconnected " + m.getSender().toString());
        }
        else if(m.getType() == NetworkMessage.TYPE_HELLO) {
        	String IP = m.getSender().toString().substring(1);
        	addUser(IP, " ");
        }
        else if(m.getType()==NetworkMessage.TYPE_READ_IMAGE){
            System.out.print("read image");
        }
    }
    public void sendMessage(String text,String conversacion, User dest) {
        //System.out.println("Sending message");
        getNetwork().send(text,conversacion,dest.getAddress(),dest.getPort());
        //System.out.println("Message sent");
    }
    public boolean addUser(String address,String Group) {
        try {
            InetAddress ad = InetAddress.getByName(address);
            User u = new User(ad,Integer.parseInt("6740"));
            System.out.println("User successfully added");
            sendHiMessage(u);
            return activeConversation.users.add(u);
        }
        catch(Exception e) {
            System.out.println("Error adding user with ip "+address+"\n"+e.getMessage());
        }
        return false;
    }
    private void sendHiMessage(User dest) {
        System.out.println("Sending invite to user " + dest.toString());
        getNetwork().send(new NetworkMessage(NetworkMessage.TYPE_HELLO,activeConversation.name,Network.getPort()+""), dest.getAddress(),dest.getPort());
    }
    public void sendMessage(String text,String conversacion) {
        if(activeConversation.users.size() == 0)
            System.out.println("There are no users to send this message to");
        for(User u : activeConversation.users){
          sendMessage(text,conversacion, u);
        }
    }
	public Network getNetwork() {
		return network;
	}
	public void setNetwork(Network network) {
		this.network = network;
	}
}
