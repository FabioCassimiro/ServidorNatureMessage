package br.com.unip.sicc.servidorNatureMessage.banco;

import br.com.unip.sicc.servidorNatureMessage.viewer.TelaServidor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBancoDeDados {

    public static final String url = TelaServidor.ipBanco.equals("")?
            "jdbc:mysql://localhost:3306/teste?useTimeZone=true&serverTimezone=UTC":
            "jdbc:mysql://"+TelaServidor.ipBanco+":3306/teste?useTimeZone=true&serverTimezone=UTC";
    public static final String noLoginBanco = TelaServidor.usuarioBanco.equals("") ?"root":TelaServidor.usuarioBanco;
    public static final String noSenhaBanco = TelaServidor.senhaBanco.equals("") ?"":TelaServidor.senhaBanco;
    public static Connection conect = null;

    public static Connection conexao() {
        try {
            return conect = DriverManager.getConnection(url, noLoginBanco, noSenhaBanco);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Nao foi possivel conectar ao Banco de Dados informado");
        }
        return null;

    }
}
