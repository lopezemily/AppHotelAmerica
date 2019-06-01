package fornecedores;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class adicionaRegistro implements ActionListener {
   private MontaTela campos;
   private JTextArea saida;
   private Connection conecta;

   public adicionaRegistro( Connection c, MontaTela f, JTextArea o ){
      conecta = c;
      campos = f;
      saida = o;
   }

   public void actionPerformed( ActionEvent e ){
      try {
         Statement statement = conecta.createStatement();
         if ( !campos.CPF.getText().equals( "" ) && 
              !campos.Nome.getText().equals( "" ) ) {
              String query = "INSERT INTO hospede (" +
                     "CPF, Nome, Email, Endereco, Cidade, Estado, Cep"+") VALUES ( ' "+
                     campos.CPF.getText() + " ', ' "+
                     campos.Nome.getText() + " ', ' "+
                     campos.Email.getText() + " ', ' "+
                     campos.Endereco.getText() + " ', ' "+
                     campos.Cidade.getText() + " ', ' "+ 
                     campos.Estado.getText() + " ', ' "+
                     campos.Cep.getText() + " ')";

            int result = statement.executeUpdate( query );
               
            if ( result == 1 ){
                saida.append( "Inserido com Sucesso\n" );
                campos.CPF.setText( "" );
                campos.Nome.setText( "" );
                campos.Email.setText( "" );
                campos.Endereco.setText( "" );
                campos.Cidade.setText( "" );
                campos.Estado.setText( "" );
                campos.Cep.setText( "" );
            }    
            else{
               saida.append( "Erro na Inclusão\n" );
               campos.CPF.setText( "" );
               campos.Nome.setText( "" );
               campos.Email.setText( "" );
               campos.Endereco.setText( "" );
               campos.Cidade.setText( "" );
               campos.Estado.setText( "" );
               campos.Cep.setText( "" );
            }
         }
         else 
              JOptionPane.showMessageDialog(null,
                           "PREENCHA OS CAMPOS",
                           "Atenção",JOptionPane.ERROR_MESSAGE);
         statement.close();
      }
      catch ( SQLException sqlex ) {
         sqlex.printStackTrace();
         saida.append( sqlex.toString() );
      }
   }
}