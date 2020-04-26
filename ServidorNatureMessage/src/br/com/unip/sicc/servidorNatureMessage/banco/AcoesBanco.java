
package br.com.unip.sicc.servidorNatureMessage.banco;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class AcoesBanco {
    private final String noUsuario = "root";
    private final String noSenha = "";
    private Connection connect;
    private final String url = "jdbc:mysql://localhost:3306/naturemessage?useTimeZone=true&serverTimezone=UTC";
    private String sqlQuery;
    
    public AcoesBanco(){
     conexao();
    }
    
    public Connection conexao() {
        try {
            connect = DriverManager.getConnection(url, noUsuario, noSenha);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Não foi possivel estabeler conexão");
            e.printStackTrace();
        }
        return connect;

    }
    public void salvaMensagem(String noLogin, String noMensagem,String dtEnvioMensagem,String hrEnvio) {
        sqlQuery = "INSERT INTO TB_MENSAGEM VALUES("+ "'" + noLogin + "','" + noMensagem + "','" + dtEnvioMensagem + "','" + hrEnvio +"'"+")" ;
        try {
            Statement cadatastro = connect.createStatement();
            cadatastro.executeUpdate(sqlQuery);
            

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage() + " Erro de Banco de dados");
            e.printStackTrace();
        }
    }
    
}
