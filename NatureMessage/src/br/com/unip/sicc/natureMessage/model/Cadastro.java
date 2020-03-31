package br.com.unip.sicc.natureMessage.model;

import br.com.unip.sicc.natureMessage.banco.AcoesBancoDeDados;
import br.com.unip.sicc.natureMessage.control.ConfigCadastro;
import br.com.unip.sicc.natureMessage.exception.InsufficientCharactersException;
import br.com.unip.sicc.natureMessage.exception.PasswordsDontMatch;
import br.com.unip.sicc.natureMessage.exception.UserRegisteredException;
import javax.swing.JTextField;

public class Cadastro {

    private String criaQuerySql;
    AcoesBancoDeDados banco = new AcoesBancoDeDados();
    ConfigCadastro configCad = new ConfigCadastro();

    public void CadastroUsuario(String noPessoa, String noSobrenome, String noCargo, String noEmpresa, String noEndereco,
            String dtNascimento, String noEmail, String noLogin, String noSenha, String confirmacaoSenha) throws InsufficientCharactersException, UserRegisteredException, PasswordsDontMatch {

        banco.ConsultaLoginSenha("SELECT * FROM TB_USUARIO WHERE NOLOGIN = '" + noLogin + "'");
        if (!noPessoa.equals("") && !noSobrenome.equals("") && !noCargo.equals("") && !noEmpresa.equals("") && !noEndereco.equals("")
                && !dtNascimento.equals("") && !noEmail.equals("") && !noLogin.equals("") && !noSenha.equals("")) {

            if (!noLogin.equals(banco.getResultNome())) {
                if (noSenha.equals(confirmacaoSenha)) {
                    criaQuerySql = "INSERT INTO TB_USUARIO VALUES(" + "'" + noPessoa + "'" + "," + "'" + noSobrenome + "'" + "," + "'" + noCargo + "'" + "," + "'" + noEmpresa + "'" + "," + "'" + noEndereco + "'" + "," + "'" + dtNascimento + "'" + "," + "'" + noEmail + "'" + "," + "'" + noLogin + "'" + "," + "'" + noSenha + "'"+")";
                    banco.CriaCadastroUsuario(criaQuerySql);
                } else {
                    throw new PasswordsDontMatch("Senhas não conferemem");
                }

            } else {
                throw new UserRegisteredException("Usuario já registrado");
            }

        } else {
            throw new InsufficientCharactersException("Campo obrigatorios não precenchidos");

        }

    }

    public void AcaoLimpar(JTextField txfNome, JTextField txfSobreNome, JTextField txfCargo, JTextField txfEmpresa, JTextField txfEndereco, JTextField txfDataNasc,
            JTextField txfEmail, JTextField txfUsuario, JTextField pwdSenha, JTextField pwdConfirmaSenha) {
        txfNome.setText("");
        txfSobreNome.setText("");
        txfCargo.setText("");
        txfEmpresa.setText("");
        txfEndereco.setText("");
        txfDataNasc.setText("");
        txfEmail.setText("");
        txfUsuario.setText("");
        pwdSenha.setText("");
        pwdConfirmaSenha.setText("");

    }

}
