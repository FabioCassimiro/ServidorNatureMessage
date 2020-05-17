package br.com.unip.sicc.servidorNatureMessage.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ServidorNatureMessage {

    public ServidorNatureMessage(int porta) {
        ArrayList<PrintStream> clientes = new ArrayList<>();

        try {
            ServerSocket serverSocket = new ServerSocket(porta);
            Socket socket;
            JOptionPane.showMessageDialog(null, "Servidor hospedado na porta: " + porta, "Mensagem Servidor", JOptionPane.INFORMATION_MESSAGE);

            while (true) {
                //Encaminha a conexao.
                socket = serverSocket.accept();
                //Guarda ip clientes.
                clientes.add(new PrintStream(socket.getOutputStream()));
                Mensagem msg = new Mensagem(socket, clientes);
                System.out.println(socket.toString());

            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Esta porta ja esta em uso, informe uma que nao esteja ocupada!",
                    "Mensagem Servidor", JOptionPane.ERROR_MESSAGE);
        }
    }
}
