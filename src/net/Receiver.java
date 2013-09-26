/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.net;
import java.io.*;
import java.net.*;
import java.util.Observable;

/**
 *
 * @author felipecortessaavedra
 */
public class Receiver extends Observable implements Runnable  {
    
    private ServerSocket server;
    private Network network;
    
    public Receiver(Network n) throws Exception{
        server = new ServerSocket(Network.getPort());
        this.network = n;
    }
    

    @Override
    public void run() {
        while(true) {
            
            try {
                Socket socket = server.accept();
                BufferedReader inFromClient =
               new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        
                        
                StringBuilder builder = new StringBuilder();
                String aux = "";

                while ((aux = inFromClient.readLine()) != null) {
                    builder.append(aux);
                }
                String text = builder.toString();
                NetworkMessage message = NetworkMessage.parse(text);
                message.setSender(socket.getInetAddress());
                message.setReceiver(Network.getLocalAddress());
                
                System.out.println("DOWNLOAD");
                switch (message.type){
                    case NetworkMessage.TYPE_FILE:
                        
                        System.out.println("DOWNLOADING IN");
                        String[] s = message.content.split(",");
                        inFromClient.close();
                        //server.close();
                          socket = server.accept();
                        message.content=download( s[0], socket);
                        message.setType(8);
                        break;
                    default:
                        break;
                }
                        
                
                
                
                //Evento
                setChanged();
                notifyObservers(message);
                
            }
            catch(Exception e) {
                System.err.println("Error de conexion al recibir mensaje\n"+e.getMessage());
            }
        }
    }
    
    
     private String download( String fileName, Socket socket) {
        try {
            System.out.println("DOWNLOADING FILE");
            String[] d = fileName.split("!#!"); 
            System.out.println("SPLIT");
            System.out.println(d[0]);
            FileOutputStream outStream = new FileOutputStream("download/"+d[0]);
            
            System.out.println("filename: "+fileName);         
            System.out.println("filestream OK");
            byte[] buffer = new byte[20000000];
            int bytesRead = 0, counter = 0;
            System.out.println("bytes OK");
            InputStream inputStream = socket.getInputStream();
            System.out.println("stream OK");
              
            /*byte[] bytes = d[1].getBytes();
            outStream.write(bytes,0,d[1].length());*/
            
            while (bytesRead >= 0) {
                bytesRead = inputStream.read(buffer);
                
                System.out.println("Buffer reader: "+bytesRead);
                if (bytesRead >= 0) {
                    outStream.write(buffer, 0, bytesRead);
                    counter += bytesRead;
                    System.out.println("total bytes read: " +
                                                    counter);
                }
                if (bytesRead < 1024) {
                    outStream.flush();
                    break;
                }
            }
 
            System.out.println("Downloaded Successfully!");
            
            outStream.close();
            socket.close();
            return "download/"+d[0];
            
        } catch (Exception e) {
            System.out.println("Error on downloading file!");
            return null;
        }
    }
}
