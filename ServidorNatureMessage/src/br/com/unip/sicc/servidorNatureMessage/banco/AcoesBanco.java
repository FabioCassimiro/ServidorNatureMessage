package br.com.unip.sicc.servidorNatureMessage.banco;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AcoesBanco {

    public static void salvaMensagem(String mensagem) {
        String[] dados = mensagem.split("----");
        String sqlQuery = "insert into tb_mensagem (NOUSUARIO,NOMENSAGEM,DTENVIO,NOSERVIDOR)VALUES ("
                + "'" + dados[0] + "','" + dados[1] + "','" + dados[2] + "','" + dados[3] + "'" + ")";

        try {
            Statement cadatastro = ConexaoBancoDeDados.conexao().createStatement();
            cadatastro.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Erro ao salvar mensagem no Banco de dados",
                    "Mensagem Servidor", JOptionPane.ERROR_MESSAGE);
        }
    }
}
