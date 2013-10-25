package iic2113.gameworks.network;

import java.net.*;
import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;


public class Sender implements Runnable{
    
    public LinkedBlockingQueue<NetworkMessage> messageQueue;

    Socket senderSocket;
    
    public Sender() {
        messageQueue = new LinkedBlockingQueue<NetworkMessage>(); 
        //messageQueue = new Collection.synchronizedList(new LinkedList());
   }
    
    public void send(NetworkMessage m, InetAddress u, int port) {
        m.setSender(Network.getLocalAddress());
        m.setReceiver(u);
        m.setPort(port);
        messageQueue.add(m);
    }
    
    private void pullStack(){
      NetworkMessage m =  messageQueue.poll();
      if(m == null)
          return;
      
      try
      {
         Socket client = new Socket(m.getReceiver() , m.getPort() );
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         //out.writeUTF(m.getString());
          switch (m.type){
              case NetworkMessage.TYPE_FILE: 
                   
                   String address  = m.content.replaceAll("@PATH:", "");
                 //  address= "/Users/anttikulppi/Documents/Trabajo/Brainshots/rails data.txt";
                  // address= "/Users/anttikulppi/Pictures/d.jpg";
                   File f = new File(address );
                   NetworkMessage m2 = new NetworkMessage(NetworkMessage.TYPE_FILE, m.gameInstance, f.getName()  );
                   
                   System.out.println(m2.content);                   
                   System.out.println("FILE START SEND");
                   out.writeBytes(m2.getString()+"!#!");
                   client.close();
                   client = new Socket(m.getReceiver() , m.getPort() );
                   outToServer = client.getOutputStream();
                   out = new DataOutputStream(outToServer);
                   
                   streamFile(f,out);       
                    client.close();           
                   System.out.println("filestream");
              break;
                  
              default:  
              //  System.out.println("enviando ##" + m.getString());
                out.writeBytes(m.getString()); 
                client.close();
              break;
                  
          }
             
         //client.close();
         
         
         
      }catch(Exception e)
      {
          messageQueue.add(m);
      }
      
      
    }
    public void streamFile(File file, DataOutputStream outStream) throws IOException {
        
        System.out.println("FILE STREAMING");
        long fileSize = file.length();
        long completed = 0;
        int step = 150000;
        outStream.flush();
        System.out.println("FILE STREAMING2");
        
        
        
        System.out.println("SIZE: "+fileSize);
         // creates the file stream
        FileInputStream fileStream = new FileInputStream(file);
        // sending a message before streaming the file
        System.out.println("START BUFFER");
        byte[] buffer = new byte[step];
        while (completed <= fileSize) {
            fileStream.read(buffer);
            System.out.println(buffer);
            outStream.write(buffer);
            completed += step;
            System.out.println("BUFFER STEP: "+step);
        }
        
        System.out.println("buffer: "+buffer.length);
        System.out.println("END BUFFERS");
        outStream.close();
    }
    
    
    @Override
    public void run(){
        
        while(true){
            if (messageQueue.size() > 0){
                pullStack();
            }
        }
        
    }
}
