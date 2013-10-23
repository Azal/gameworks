Group 8 - Network & Connection
=============================

### Objective:
 
Support internet connection between different devices(computers) to allow multiplayer modus.


### Description:
We started by creating low-level socket connection between computers that allows chat in java, based on a 1-host-to-many-players architecture where anyone can host a ‘game’. To start it just run the Main.java in this folder. 

We created a method called **---** to send events with data. *Players* should send serialized and minimized information about their input (clicks, keyboard keys) which should be queued and interpreted by the *Admin*.  

We’ll work with a game hosted by one computer, which means that every *Player* in a game will have to communicate to the *Admin* in order to send messages to the other players in game. This will be decided at the beginning of each game.

### Instructions & Public Interfaces: 
Start by creating an instance of the class *Network*
	
	...
	

### Members of Group 8
Max Findel  
John Peebles  
Eduardo Ramírez  