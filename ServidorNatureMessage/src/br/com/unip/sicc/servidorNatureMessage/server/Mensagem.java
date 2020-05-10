package br.com.unip.sicc.servidorNatureMessage.server;

import br.com.unip.sicc.servidorNatureMessage.banco.AcoesBanco;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class Mensagem {

    private Socket socket;
    private ArrayList<PrintStream> clientes;
    private AcoesBanco banco = new AcoesBanco();

    public Mensagem(Socket socket, ArrayList<PrintStream> clientes) {
        this.socket = socket;
        this.clientes = clientes;
        Thread();
    }

    public void Thread() {

        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {

                String mensagem = "";
                try {
                    InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                    BufferedReader bff = new BufferedReader(isr);

                    while ((mensagem = bff.readLine()) != null) {
                        enviarMensagem(mensagem);
                        AcoesBanco.salvaMensagem(mensagem);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        tr.start();

    }

    private void enviarMensagem(String msg) {
        for (int i = 0; i < clientes.size(); i++) {
            String[] mensagem = msg.split("----");
            String montaMensagem = "";
            if (montaMensagem.equals("")) {
                montaMensagem = mensagem[0] + "  " + mensagem[1] + "  " + mensagem[2];
            } else {
                montaMensagem += mensagem[0] + "  " + mensagem[1] + "  " + mensagem[2];
            }
            clientes.get(i).println(montaMensagem + "**");
            clientes.get(i).flush();
        }

    }

}
