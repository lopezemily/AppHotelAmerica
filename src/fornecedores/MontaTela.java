package fornecedores;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MontaTela extends JPanel{
      private JPanel telaPanel;
      private JLabel lID_hospede,lCPF,lNome,lEmail,lCidade,lEndereco,lEstado,lCep;
      JTextField CPF,Nome,Email, ID_hospede, Endereco,Cidade,Cep,Estado;
      public MontaTela(){
            setLayout(new GridLayout(8,2));
          
            lID_hospede = new JLabel("ID_hospede:");
            add(lID_hospede);
            ID_hospede = new JTextField();
            ID_hospede.setEditable(false);
            add(ID_hospede);
            
            lCPF = new JLabel("CPF:");
            add(lCPF);
            CPF = new JTextField();
            add(CPF);
            
            lNome = new JLabel("Nome:");
            add(lNome);
            Nome = new JTextField();
            add(Nome);
            
            lEmail = new JLabel("Email:");
            add(lEmail);
            Email = new JTextField();
            add(Email);

            lEndereco = new JLabel("Endereço:");
            add(lEndereco);
            Endereco = new JTextField();
            add(Endereco);
            
            lCidade = new JLabel("Cidade:");
            add(lCidade);            
            Cidade = new JTextField();
            add(Cidade);

            lEstado = new JLabel("Estado:");
            add(lEstado);
            Estado = new JTextField();
            add(Estado);

            lCep = new JLabel("Cep:");
            add(lCep);
            Cep = new JTextField();
            add(Cep);
       }	
}