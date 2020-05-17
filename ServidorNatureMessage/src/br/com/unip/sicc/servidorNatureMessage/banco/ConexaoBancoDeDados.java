package br.com.unip.sicc.servidorNatureMessage.banco;

import br.com.unip.sicc.servidorNatureMessage.viewer.TelaServidor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBancoDeDados {

    public static final String url = TelaServidor.noEndereco.equals("")
            ? "jdbc:mysql://25.104.205.56:3306/naturemessage?useTimeZone=true&serverTimezone=UTC"
            : "jdbc:mysql://" + TelaServidor.noEndereco + ":3306/" + TelaServidor.noBanco + "?useTimeZone=true&serverTimezone=UTC";
    public static final String noLoginBanco = TelaServidor.usuarioBanco.equals("") ? "admin" : TelaServidor.usuarioBanco;
    public static final String noSenhaBanco = TelaServidor.senhaBanco.equals("") ? "naturemessage@_@125311314" : TelaServidor.senhaBanco;
    public static final String noBanco = !TelaServidor.noBanco.equals("nulo") ? "teste" : "";
    public static Connection conect = null;

    public static Connection conexao() {
        try {
            return conect = DriverManager.getConnection(url, noLoginBanco, noSenhaBanco);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Não foi possivel conectar ao Banco de dados",
                    "Mensagem Servidor", JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }
}
