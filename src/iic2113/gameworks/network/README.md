Group 8 - Network & Connection
=============================

### Objective:
 
Support internet connection between different devices(computers) to allow multiplayer modus.


### Description:
We will start by creating low-level socket connection between computers to allow chat in java, based on a 1-host-to-many-players where anyone can host a ‘game’. This will be followed by a real-time display and movement(for this we need other groups work). More details will come with time.  

For now we should add generic methods that will receive and return certain type of objects. Clients will send serialized and minimized information about their input (clicks, keyboard keys) which will be queued and interpreted by the server. The server will return in response a single event to all clients with the result of all of their actions.
We’ll work with a game hosted by one computer, which means that every player in a game will have to communicate to the in order to send messages to the other players in game.

### Public Interfaces: 
...

### Members
...