package src.Network;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.InetAddress;

public class User {
    private InetAddress address;
    private int port;
    public User(InetAddress address,int port) {
        this.address = address;
        this.port = port;
    }
    
    public InetAddress getAddress() {
        return this.address;
    }
    public int getPort() {
        return this.port;
    }
    
    public String toString() {
        return this.address.toString();
    }
}
