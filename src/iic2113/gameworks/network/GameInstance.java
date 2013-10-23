package src.iic2113.gameworks.network;

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

public class GameInstance {
    protected LinkedList<User> users;
    protected String name;
    protected String messages;
    protected List<String> IPs;

    public GameInstance(String name){
       IPs=new ArrayList<String>();
       messages="";
       users = new LinkedList<User>();
       this.name=name;
    }
}
