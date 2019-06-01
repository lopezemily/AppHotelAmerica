package fornecedores;
import java.awt.*;
import java.awt.event.*;

public class limparRegistros implements ActionListener {
   private MontaTela campos;

   public limparRegistros( MontaTela f )
   {
      campos = f;
   }

   public void actionPerformed( ActionEvent e )
   {
      campos.CPF.setText( "" );
      campos.Nome.setText( "" );
      campos.Email.setText( "" );
      campos.Endereco.setText( "" );
      campos.Cidade.setText( "" );
      campos.Estado.setText( "" );
      campos.Cep.setText( "" );
   }
}