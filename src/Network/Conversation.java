package src.Network;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
-...-
 *
 *	@version  -
    @created_by @group8/maxfindel
    @update_log
    	22/10/2013 - @group8/maxfindel
    	26/09/2013 - @group8/jpeeblesg
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
