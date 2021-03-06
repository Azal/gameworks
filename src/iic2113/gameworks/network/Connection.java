package iic2113.gameworks.network;

import java.net.InetAddress;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
-Connection via IP to other computers based on events. Now a functional chat.-
	-Reference to external code:-
	-Based on the code written by Felipe Cort�s Saavedra(PUC)
 *
 *	@version  -
    @created_by @group8/jpeeblesg
    @update_log
    	26/09/2013 - @group8/jpeeblesg
 */

public class Connection implements Observer {	
	private Network network;
    private GameInstance activeGame;
    private LinkedList<GameInstance> gameInstances;
    
    /**  
	Connection constructor */
	public Connection(){
        gameInstances = new LinkedList<GameInstance>();
		gameInstances.add(new GameInstance("Default"));
		activeGame=gameInstances.get(0);
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
        
	}
    @Override
    /**  
	Manages the types of messages and reaction such as the initial connection message(TYPE_HELLO) 
	and the normal chat text(TYPE_TEXT) */
    public void update(Observable o, Object message) {
        NetworkMessage m = (NetworkMessage)message;
        if(m.getType() == NetworkMessage.TYPE_TEXT){
            String contenido=m.getContent();
            System.out.print(m.getSender().toString().substring(1)+" says: "+contenido + "\n");
        }
        else if(m.getType() == NetworkMessage.TYPE_BYE) {
            System.out.println("User disconnected " + m.getSender().toString());
        }
        else if(m.getType() == NetworkMessage.TYPE_HELLO) {
        	String IP = m.getSender().toString().substring(1);
        	
        	addUser(IP+":"+m.getPort(),false);
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
    public void newUser(String address){
    	addUser(address,true);
    }
    public boolean addUser(String address,boolean firstTime) {
        try {
        	String[] splittedAddress=address.split(":");
            User u = new User(InetAddress.getByName(splittedAddress[0]),Integer.parseInt(splittedAddress[1]));
            System.out.println("User successfully added");
            if(firstTime)sendHiMessage(u);
            return activeGame.users.add(u);
        }
        catch(Exception e) {
            System.out.println("Error adding user with ip "+address+"\n"+e.getMessage());
        }
        return false;
    }
    private void sendHiMessage(User dest) {
        System.out.println("Sending invite to user " + dest.toString());
        getNetwork().send(new NetworkMessage(NetworkMessage.TYPE_HELLO,activeGame.name,Network.getPort()+""), dest.getAddress(),dest.getPort());
    }
    public void sendMessage(String text) {
        if(activeGame.users.size() == 0)
            System.out.println("There are no users to send this message to");
        for(User u : activeGame.users){
          sendMessage(text,"", u);
        }
    }
	public Network getNetwork() {
		return network;
	}
	public void setNetwork(Network network) {
		this.network = network;
	}
}
