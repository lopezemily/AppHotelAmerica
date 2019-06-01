package hospedes;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BotaoPainel extends JPanel{
    private JButton consultar, adicionar, alterar, relatorio, limpar, apagar;
    public BotaoPainel(Connection c, MontaTela s, JTextArea t){
        setLayout(new GridLayout(1,5));
        
        adicionar = new JButton("Adicionar");
        adicionar.addActionListener(new adicionaRegistro(c, s, t));
        add(adicionar);       

        consultar = new JButton("Consultar");
        consultar.addActionListener(new consultaRegistro(c, s, t));
        add(consultar);

        alterar = new JButton("Alterar");
        alterar.addActionListener(new alteraRegistro(c, s, t));
        add(alterar); 

        apagar = new JButton("Apagar");
        apagar.addActionListener(new apagarRegistro(c, s, t));
        add(apagar);       

        //relatorio = new JButton("Limpar");
        //relatorio.addActionListener(new Relatorio(c, s, t));
        //add(relatorio);        
        
        limpar = new JButton("Limpar");
        limpar.addActionListener(new limparRegistros (s));
        add(limpar);
    }
}