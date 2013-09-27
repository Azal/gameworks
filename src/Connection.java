package src;
import src.net.Network;
import src.net.NetworkMessage;

import java.io.IOException;
import java.net.InetAddress;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Connection implements Observer {
	Network network;
    private User localUser;
    private Conversation activeConversation;
    private LinkedList<Conversation> conversations;
	/**
	 * @param args
	 */
	public Connection(){
        conversations = new LinkedList<Conversation>();
		conversations.add(new Conversation("Default"));
		activeConversation=conversations.get(0);
		System.out.println("Inicializando red");
		try {
			network = new Network();
			network.init();
			network.addReceiverObserver(this);
			System.out.println("Red inicializada correctamente");
		}
		catch(Exception e) {
			System.err.println("Error al inicializar red\n" + e.getMessage());
		}
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                
            }
        });
        
        localUser = new User(Network.getLocalAddress(),Network.getPort());
	}
    @Override
    public void update(Observable o, Object message) {
    	
        src.net.NetworkMessage m = (src.net.NetworkMessage)message;
        if(m.getType() == src.net.NetworkMessage.TYPE_TEXT){
            String contenido=m.getContent();
            System.out.print("Dice: "+contenido);
            // ui.newMessage(m.getContent(),m.getSender().toString());
        }
       // else if(m.getType() == NetworkMessage.TYPE_HELLO_RES)
            // ui.newStatus("Usuario confirmo conexion :" + m.getSender().toString());
        else if(m.getType() == NetworkMessage.TYPE_BYE) {
            // this.deleteUser(m.getSender());
            System.out.println("Usuario desconectado " + m.getSender().toString());
           // ui.newStatus("Usuario se desconecto :" + m.getSender().toString());
        }
        else if(m.getType() == NetworkMessage.TYPE_HELLO) {
            String contenido=m.getContent();
            String[] puertoSplitted=contenido.split("-");
            //ui.newMessage(m.getContent(), m.getSender().toString(), Integer.parseInt(puertoSplitted[puertoSplitted.length-1]));
          //  ui.newMessage(puertoSplitted[0]+"-Conexion Creada",m.getSender().toString()+":"+puertoSplitted[puertoSplitted.length-1]);
            //ui.addAddressBack(m.getSender().toString().substring(1)+":"+puertoSplitted[puertoSplitted.length-1], puertoSplitted[0]);
        }
        else if(m.getType()==NetworkMessage.TYPE_READ_IMAGE){
            System.out.print("leer imagen");
           //  ui.addImage(m.getContent().toString());
        }
    }
    public void sendMessage(String text,String conversacion, User dest) {
        System.out.println("Enviando mensaje");
        String puerto=String.valueOf(localUser.getPort());
        network.send(text,conversacion,dest.getAddress(),dest.getPort());
        System.out.println("Mensaje enviado");
    }
    public boolean addUser(String address,String Group) {
        try {
            InetAddress ad = InetAddress.getByName(address);
            User u = new User(ad,Integer.parseInt("6140"));
            System.out.println("Usuario agregado correctamente");
            //return conversacionUser.users.add(u);
            return activeConversation.users.add(u);
        }
        catch(Exception e) {
            System.out.println("Error al agregar usuario con ip "+address+"\n"+e.getMessage());
        }
        return false;
    }
    public void sendMessage(String text,String conversacion) {
        if(activeConversation.users.size() == 0)
            System.out.println("No hay usuarios para mandar el mensaje");
        for(User u : activeConversation.users){
          sendMessage(text,conversacion, u);
        }
    }
}
