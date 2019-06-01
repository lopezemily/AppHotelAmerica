package fornecedores;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class consultaRegistro implements ActionListener {
   private MontaTela campos;
   private JTextArea saida;
   private Connection conecta;
   private JButton limpa;
   public consultaRegistro( Connection c, MontaTela f, JTextArea o ){
      conecta = c;
      campos = f;
      saida = o;
   }
   public void actionPerformed( ActionEvent e ){
      try {
         if ( !campos.CPF.getText().equals( "" ) ) {
            Statement statement =conecta.createStatement();
            String query = "SELECT * FROM hospede " +
                           "WHERE Cpf=" +
                           campos.CPF.getText();
            ResultSet rs = statement.executeQuery( query );
            display( rs );
            statement.close();
         }
         else
             JOptionPane.showMessageDialog(null,"Digite o CPF");
      }
      catch ( SQLException sqlex ) {
         sqlex.printStackTrace();
         saida.append( sqlex.toString() );
      }
   }

   public void display( ResultSet rs )
   {
      try {         
         rs.next();

         int registroNumero = rs.getInt( 1 );

         if ( registroNumero  != 0 ) {
            campos.ID_hospede.setText( String.valueOf( registroNumero));
            campos.CPF.setText( rs.getString( 2 ) );
            campos.Nome.setText( rs.getString( 3 ) );
            campos.Email.setText( rs.getString( 4 ) );
            campos.Endereco.setText( rs.getString( 5 ) );
            campos.Cidade.setText( rs.getString( 6 ) );
            campos.Estado.setText( rs.getString( 7 ) );
            campos.Cep.setText( rs.getString( 8 ) );
         }   
         else
            saida.append( "Registro não localizado\n" );         
      }
      catch ( SQLException sqlex ) {
          saida.append("\nRegistro não encontrado\n");
      }
   }
}