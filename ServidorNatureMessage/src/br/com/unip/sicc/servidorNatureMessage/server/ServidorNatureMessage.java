package br.com.unip.sicc.servidorNatureMessage.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorNatureMessage {
    
        public ServidorNatureMessage( int porta){
        ArrayList<PrintStream> clientes = new ArrayList<>();
        
        try {
            ServerSocket serverSocket = new ServerSocket(porta);
            Socket socket;
            
            while(true){
                socket = serverSocket.accept();  
                
                //Guarda ip clientes
                clientes.add(new PrintStream(socket.getOutputStream()));
                Mensagem msg = new Mensagem(socket,clientes);

            }
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
