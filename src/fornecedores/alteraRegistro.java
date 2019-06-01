package fornecedores;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class alteraRegistro implements ActionListener {
   private MontaTela campos;
   private JTextArea saida;
   private Connection conecta;

   public alteraRegistro( Connection c, MontaTela f,JTextArea o ){
      conecta = c;
      campos = f;
      saida = o;
   }

   public void actionPerformed( ActionEvent e ){
      try {
         Statement statement = conecta.createStatement();
         if ( ! campos.ID_hospede.getText().equals( "" ) ) {
            String query = "UPDATE hospede SET " +
                   "CPF='" + campos.CPF.getText() + 
                    "', Nome='" + campos.Nome.getText() + 
                   "', Email='" + campos.Email.getText() + 
                   "', Endereco='" + campos.Endereco.getText() +
                   "', Cidade='" + campos.Cidade.getText() + 
                   "', Estado='" + campos.Estado.getText() + 
                   "', Cep='" + campos.Cep.getText() +
                   "' WHERE ID_hospede=" + campos.ID_hospede.getText();
                   

            int result = statement.executeUpdate( query );
            
            if ( result == 1 )
                saida.append( "\nAlterado com Sucesso\n" );
            else {
               saida.append( "\nErro! na alteração\n" );
               campos.CPF.setText( "" );
               campos.Nome.setText( "" );
               campos.Email.setText( "" );
               campos.Endereco.setText( "" );
               campos.Cidade.setText( "" );
               campos.Estado.setText( "" );
               campos.Cep.setText( "" );
            }

            statement.close();
         }
         else 
             saida.append( "\nClique em Consultar para encontrar um registro\n" );
      }
      catch ( SQLException sqlex ) {
         sqlex.printStackTrace();
         saida.append( sqlex.toString() );
      }
   }
}