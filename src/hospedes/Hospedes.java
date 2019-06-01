package hospedes;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class Hospedes extends JFrame
{
	private MontaTela mostraTela;   
      	private JTextArea saida; 
	private JScrollPane painelTexto;   
      	private BotaoPainel controles;   

        private String url;                  
        private Connection conecta;  
            
	public Hospedes(){
		setTitle("CADASTRO DE HOSPEDES");
        	Container tela = getContentPane();
		mostraTela = new MontaTela();         
		saida = new JTextArea(4,4);
		tela.setLayout(new BorderLayout());
		tela.add(new JScrollPane(mostraTela),BorderLayout.CENTER);
		painelTexto = new JScrollPane(saida);
		tela.add(painelTexto, BorderLayout.SOUTH);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            //==========CONFIGURA A CONEXÃO DE BANCO DE DADOS===============
            try{
                    url = "jdbc:mysql://localhost:3306/APPHOTEL?useTimezone=true&serverTimezone=UTC";
                    Class.forName("com.mysql.cj.jdbc.Driver"); 
                    conecta = DriverManager.getConnection(url,"root","P@ssw0rd0123" );
                    saida.append("Conexão Efetuada com Sucesso \n");
            }catch(ClassNotFoundException e){
                    saida.append("Não foi possível efetuar a conexão, classe não encontrada \n");                              
            }catch(SQLException d){
                    saida.append("Não foi possível efetuar a conexão com o banco de dados \n");    
                    System.out.println(d);
            }    
            controles = new BotaoPainel(conecta,mostraTela,saida);
            tela.add(controles, BorderLayout.NORTH);
            setLocation(300,100);
            setSize(700,350);
	}

        public static void main( String args[] ){
              new Hospedes().setVisible(true);
        }
 }