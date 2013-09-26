package src;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author johnpeebles
 */
public class Conversation {
    protected LinkedList<User> users;
    protected String name;
    protected String conversacionTotal;
    protected List<String> IPs;

    public Conversation(String name){
       IPs=new ArrayList<String>();
       conversacionTotal="";
       users = new LinkedList<User>();
       this.name=name;
    }
}
