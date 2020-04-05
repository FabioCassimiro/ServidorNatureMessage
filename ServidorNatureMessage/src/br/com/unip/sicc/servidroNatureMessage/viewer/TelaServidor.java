package br.com.unip.sicc.servidroNatureMessage.viewer;

import br.com.unip.sicc.servidroNatureMessage.server.ServidorNatureMessage;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class TelaServidor {

    //Agora com versionamento
    public JLabel btnFechar;
    public JTextField txfPorta;
    public JLabel txtLblTitulo;
    public JButton btnEntra;
    public JLabel txtLblStatus;
    public JButton btnParar;
    public JButton btnExecute;
    public JLabel txtLblOn;
    public JLabel txtLblOff;

    Font fonte = new Font("Arial", Font.BOLD, 15);

    JPanel painelServidor = new JPanel();
    JFrame telaServidor = new JFrame();
    ServidorNatureMessage server;

    public TelaServidor() {
        telaServidor.add(montaPainelServidor());
        telaServidor.setSize(500, 230);
        telaServidor.setLocationRelativeTo(null);
        telaServidor.setUndecorated(true);
        telaServidor.setVisible(true);
    }

    ImageIcon imagemExecute = new ImageIcon(getClass().getResource("execute.png"));
    JLabel mostraExecute = new JLabel(imagemExecute);

    public JPanel montaPainelServidor() {

        painelServidor.setLayout(null);
        painelServidor.setBackground(new Color(138, 43, 226));

        btnFechar = new JLabel("X");
        btnFechar.setForeground(Color.WHITE);
        btnFechar.setFont(new Font("Arial", Font.BOLD, 25));
        btnFechar.setBounds(470, 10, 25, 25);
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });

        txtLblTitulo = new JLabel("SERVIDOR");
        txtLblTitulo.setForeground(Color.WHITE);
        txtLblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        txtLblTitulo.setBounds(170, 40, 350, 32);

        JLabel txtLblPorta = new JLabel("Porta:");
        txtLblPorta.setForeground(Color.WHITE);
        txtLblPorta.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblPorta.setBounds(30, 91, 70, 25);

        txtLblOn = new JLabel("On-line");
        txtLblOn.setForeground(new Color(0, 255, 127));
        txtLblOn.setFont(new Font("Arial", Font.BOLD, 12));

        txtLblOff = new JLabel("Off-line");
        txtLblOff.setForeground(new Color(255, 99, 71));
        txtLblOff.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblOff.setBounds(340, 119, 70, 25);

        txtLblStatus = new JLabel("Status servidor:");
        txtLblStatus.setForeground(Color.WHITE);
        txtLblStatus.setFont(new Font("Arial", Font.BOLD, 12));
        txtLblStatus.setBounds(340, 91, 100, 25);

        txfPorta = new JTextField();
        txfPorta.setBorder(null);
        txfPorta.setForeground(Color.WHITE);
        txfPorta.setBackground(null);
        txfPorta.setBounds(30, 110, 300, 30);
        txfPorta.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();
                int tecla = KeyEvent.VK_ENTER;
                if (codigo == tecla) {
                    Thread executaServer = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                ServidorNatureMessage server = new ServidorNatureMessage(Integer.parseInt(txfPorta.getText()));

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                        }
                    });

                    txtLblOff.setVisible(false);
                    txtLblOn.setBounds(340, 119, 70, 25);

                    executaServer.start();

                }
            }
        });

        JSeparator linhaSeparatorPorta = new JSeparator();
        linhaSeparatorPorta.setForeground(Color.WHITE);
        linhaSeparatorPorta.setBounds(30, 140, 300, 1);

        btnEntra = new JButton();
        btnEntra.setText("Iniciar");
        btnEntra.setBounds(275, 180, 100, 30);
        btnEntra.setBackground(new Color(0, 255, 127));
        btnEntra.setForeground(Color.WHITE);
        btnEntra.setBorder(null);
        btnEntra.setFocusPainted(false);
        btnEntra.setFont(fonte);
        btnEntra.setMnemonic(KeyEvent.VK_ENTER);
        
        /*btnEntra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread executaServer = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ServidorNatureMessage server = new ServidorNatureMessage(Integer.parseInt(txfPorta.getText()));
                            
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        

                    }
                });
                
                txtLblOff.setVisible(false);
                txtLblOn.setBounds(340, 119, 70, 25);

                executaServer.start();

            }
        });*/

        btnParar = new JButton();
        btnParar.setText("Parar");
        btnParar.setBounds(380, 180, 100, 30);
        btnParar.setBackground(new Color(255, 99, 71));
        btnParar.setForeground(Color.WHITE);
        btnParar.setBorder(null);
        btnParar.setFocusPainted(false);
        btnParar.setFont(fonte);
        btnParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        btnExecute = new JButton();
        btnExecute.setBounds(20, 172, 50, 50);
        btnExecute.setBorder(null);
        btnExecute.setFocusPainted(false);
        btnExecute.setFont(fonte);
        btnExecute.setBackground(null);
        btnExecute.setForeground(null);
        btnExecute.setContentAreaFilled(false);
        btnExecute.setIcon(imagemExecute);
        btnParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        painelServidor.add(btnExecute);
        painelServidor.add(txtLblTitulo);
        painelServidor.add(txtLblPorta);
        painelServidor.add(txtLblTitulo);
        painelServidor.add(txfPorta);
        painelServidor.add(linhaSeparatorPorta);
        painelServidor.add(txtLblStatus);
        painelServidor.add(btnEntra);
        painelServidor.add(btnFechar);
        painelServidor.add(btnParar);
        painelServidor.add(txtLblOn);
        painelServidor.add(txtLblOff);

        return painelServidor;

    }
}
