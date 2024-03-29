package br.com.unip.sicc.servidorNatureMessage.viewer;

import br.com.unip.sicc.servidorNatureMessage.server.ServidorNatureMessage;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaServidor {

    private JLabel btnFechar;
    private JTextField txfPorta;
    private JButton btnEntra;
    private JButton btnParar;
    public JLabel lblStatusServer;
    public static String noEndereco = "";
    public static String senhaBanco = "";
    public static String usuarioBanco = "";
    public static String noBanco = "";

    private JPanel pnlServidor = new JPanel();
    private JFrame telaServidor = new JFrame();
    public ServidorNatureMessage server;
    private Componentes componentes = new Componentes();

    public TelaServidor() {
        telaServidor.add(montaPainelServidor());
        telaServidor.setSize(500, 230);
        telaServidor.setLocationRelativeTo(null);
        telaServidor.setUndecorated(true);
        telaServidor.setVisible(true);
        componentes.montaIconeFrame(telaServidor);
    }

    ImageIcon imagemExecute = new ImageIcon(getClass().getResource("/br/com/unip/sicc/servidorNatureMessage/image/execute.png"));
    ImageIcon imagemServidor = new ImageIcon(getClass().getResource("/br/com/unip/sicc/servidorNatureMessage/image/servidor.png"));

    public JPanel montaPainelServidor() {
        
        pnlServidor.add(Componentes.montaBtnMinimizar(telaServidor));

        pnlServidor.setLayout(null);
        pnlServidor.setBackground(new Color(138, 43, 226));

        JLabel lblImagServidor = new JLabel(imagemServidor);
        lblImagServidor.setBounds(15, 35, 170, 170);

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

        pnlServidor.add(Componentes.montaTexto("Porta:", 12, Color.WHITE, 172, 91, 70, 25));
        pnlServidor.add(Componentes.montaTexto("SERVIDOR", 30, Color.WHITE, 174, 25, 350, 32));
        pnlServidor.add(Componentes.montaSeparadora(150, 140, 140, 1));

        txfPorta = new JTextField();
        txfPorta.setBorder(null);
        txfPorta.setForeground(Color.WHITE);
        txfPorta.setBackground(null);
        txfPorta.setBounds(173, 110, 115, 30);
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
                                JOptionPane.showMessageDialog(null, "Porta nao informada ou invalida", "Mensagem Servidor", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    });

                    executaServer.start();

                }
            }
        });

        btnEntra = new JButton();
        btnEntra.setText("Iniciar");
        btnEntra.setBounds(275, 180, 100, 30);
        btnEntra.setBackground(new Color(0, 255, 127));
        btnEntra.setForeground(Color.WHITE);
        btnEntra.setBorder(null);
        btnEntra.setFocusPainted(false);
        btnEntra.setFont(new Font("Arial", Font.BOLD, 15));
        btnEntra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread executaServer = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ServidorNatureMessage server = new ServidorNatureMessage(Integer.parseInt(txfPorta.getText()));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Porta nao informada ou invalida", "Mensagem Servidor", JOptionPane.ERROR_MESSAGE);

                        }

                    }
                });
                executaServer.start();

            }
        });

        btnParar = new JButton();
        btnParar.setText("Parar");
        btnParar.setBounds(380, 180, 100, 30);
        btnParar.setBackground(new Color(255, 99, 71));
        btnParar.setForeground(Color.WHITE);
        btnParar.setBorder(null);
        btnParar.setFocusPainted(false);
        btnParar.setFont(new Font("Arial", Font.BOLD, 15));
        btnParar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja realmente encerrar o servidor?", "Mensagem Servidor", JOptionPane.YES_OPTION) == 0) {
                    System.exit(0);
                }
            }
        });

        JButton btnDAO = Componentes.montaBotaoIcone(imagemExecute, 20, 172, 50, 50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noBanco = JOptionPane.showInputDialog("Digite o nome do Banco de Dados");
                noEndereco = JOptionPane.showInputDialog("Digite o IP do Banco de Dados");
                usuarioBanco = JOptionPane.showInputDialog("Digite o Usuario do Banco de Dados");
                senhaBanco = JOptionPane.showInputDialog("Digite a Senha do Banco de Dados");
            }
        });
        btnDAO.setToolTipText("Banco de dados");

        pnlServidor.add(lblImagServidor);
        pnlServidor.add(txfPorta);
        pnlServidor.add(btnDAO);
        pnlServidor.add(btnEntra);
        pnlServidor.add(btnFechar);
        pnlServidor.add(btnParar);

        return pnlServidor;

    }
}
