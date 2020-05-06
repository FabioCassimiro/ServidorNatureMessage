
package br.com.unip.sicc.servidorNatureMessage.viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Componentes {

    public static JLabel montaTexto(String conteudo, int tamanhoFonte, Color corfonte, int x, int y, int altura, int largura) {
        JLabel texto = new JLabel(conteudo);
        texto.setForeground(corfonte);
        texto.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
        texto.setBounds(x, y, altura, largura);
        return texto;
    }
    
    public static JSeparator montaSeparadora(int x, int y, int altura, int largura) {
        JSeparator linha = new JSeparator();
        linha.setForeground(Color.WHITE);
        linha.setBounds(x, y, altura, largura);
        return linha;
    }
    
        public static JButton montaBotaoIcone(ImageIcon icone, int x, int y, int altura, int largura, ActionListener acao) {
        JButton btnIcon = new JButton();
        btnIcon.setBounds(x, y, altura, largura);
        btnIcon.setBorder(null);
        btnIcon.setBackground(null);
        btnIcon.setForeground(Color.WHITE);
        btnIcon.setContentAreaFilled(false);
        btnIcon.setIcon(icone);
        btnIcon.addActionListener(acao);
        return btnIcon;
    }
}
