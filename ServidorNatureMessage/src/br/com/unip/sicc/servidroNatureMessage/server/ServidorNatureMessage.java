package br.com.unip.sicc.servidroNatureMessage.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorNatureMessage implements Runnable {

    String noMensagemRecebida;
    ServerSocket socketServer;
    public boolean statusServer;
    int portaServer;

    public ServerSocket getSocketServer() {
        return socketServer;
    }

    public boolean getStatusServer() {
        return statusServer;
    }

    public ServidorNatureMessage(int porta) throws Exception {
        socketServer = new ServerSocket(porta);
        Socket socket;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                new trataCliente(socketServer.accept()).start();
            } catch (IOException ex) {
                Logger.getLogger(ServidorNatureMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class trataCliente extends Thread {

        private Socket client;

        public trataCliente(Socket socket) {
            client = socket;
        }

        public void run() {
            try {

                client = socketServer.accept();
                InputStreamReader input = new InputStreamReader(client.getInputStream());
                BufferedReader buffer = new BufferedReader(input);

                while ((noMensagemRecebida = buffer.readLine()) != null) {
                    System.out.println(noMensagemRecebida);
                }

            } catch (IOException ex) {
                Logger.getLogger(ServidorNatureMessage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
