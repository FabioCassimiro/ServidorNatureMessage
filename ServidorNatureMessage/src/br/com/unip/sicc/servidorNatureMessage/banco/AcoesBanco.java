
package br.com.unip.sicc.servidorNatureMessage.banco;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class AcoesBanco {

    
    public AcoesBanco(){
        
    }
    

    
    public void salvaMensagem(String mensagem) {
        String[] dados = mensagem.split("----");
        String sqlQuery = "insert into tb_mensagem (NOUSUARIO,NOMENSAGEM,DTENVIO,HRENVIO)VALUES ("+ "'" + dados[0] + "','" + dados[1] + "','" + "05/05" + "','" + dados[2] +"'"+")" ;
        try {
            Statement cadatastro = ConexaoBancoDeDados.conexao().createStatement();
            cadatastro.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null," Erro ao salvar mensagem no Banco de dados");
        }
    }
}
