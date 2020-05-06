package br.com.unip.sicc.servidorNatureMessage.server;

import br.com.unip.sicc.servidorNatureMessage.banco.AcoesBanco;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Mensagem {

    private Socket s;
    private ArrayList<PrintStream> clientes;
    private AcoesBanco banco = new AcoesBanco();

    public void setS(Socket s) {
        this.s = s;
    }

    public void setClientes(ArrayList<PrintStream> clientes) {
        this.clientes = clientes;
    }

    public Mensagem(Socket s, ArrayList<PrintStream> clientes) {
        this.s = s;
        this.clientes = clientes;
        Thread();
    }

    public void Thread() {

        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {

                String mensagem = "";
                try {
                    InputStreamReader isr = new InputStreamReader(s.getInputStream());
                    BufferedReader bff = new BufferedReader(isr);

                    while ((mensagem = bff.readLine()) != null) {
                        /*String[] mensage = mensagem.split("----");
                        String msg = "";
                        msg += mensage[0] + "  " + mensage[1] + "  " + mensage[2];*/
                        enviarMensagem(mensagem);
                        banco.salvaMensagem(mensagem);
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
            montaMensagem += mensagem[0] + "  " + mensagem[1] + "  " + mensagem[2];
            clientes.get(i).println(montaMensagem);
            clientes.get(i).flush();

        }

    }

}
