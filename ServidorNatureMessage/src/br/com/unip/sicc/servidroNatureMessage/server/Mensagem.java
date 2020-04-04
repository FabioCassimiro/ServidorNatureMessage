package br.com.unip.sicc.servidroNatureMessage.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class Mensagem {

    private Socket s;
    private ArrayList<PrintStream> clientes;

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
                        enviarMensagem(mensagem);
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

            clientes.get(i).println(msg);
            clientes.get(i).flush();

        }
    }

}
