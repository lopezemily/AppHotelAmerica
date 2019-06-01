package fornecedores;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class apagarRegistro implements ActionListener {
   private MontaTela campos;
   private JTextArea saida;
   private Connection conecta;

   public apagarRegistro( Connection c, MontaTela f,JTextArea o )
   {
      conecta = c;
      campos = f;
      saida = o;
   }

   public void actionPerformed( ActionEvent e )
   {
      try {
         Statement statement = conecta.createStatement();

         if (!campos.ID_hospede.getText().equals("")) {
            String query = "DELETE FROM hospede " +
                   "WHERE ID_hospede= "+campos.ID_hospede.getText();

            int result = statement.executeUpdate( query );
            
            if ( result == 1 ){
               JOptionPane.showMessageDialog(null,
                     "Deletado com Sucesso","Atenção",
                        JOptionPane.ERROR_MESSAGE);
                campos.CPF.setText( "" ); 
                campos.Nome.setText( "" );
                campos.Email.setText( "" );
                campos.Endereco.setText( "" );
                campos.Cidade.setText( "" );
                campos.Estado.setText( "" );
                campos.Cep.setText( "" );
            }else {
               JOptionPane.showMessageDialog(null,
                       "N�o Deletado","Atenção",
                       JOptionPane.ERROR_MESSAGE);
            }

            statement.close();
         }
         else 
           JOptionPane.showMessageDialog(null,
                "Clique em Consultar para encontrar um registro",
                "Aten��o",JOptionPane.ERROR_MESSAGE);
      }
      catch ( SQLException sqlex ) {
               JOptionPane.showMessageDialog(null,
                       "OCORREU ALGUM ERRO","Aten��o",
                       JOptionPane.ERROR_MESSAGE);
      }
   }
}