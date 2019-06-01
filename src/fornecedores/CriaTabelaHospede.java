/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fornecedores;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Usuário
 */
public class CriaTabelaHospede {

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        try {
            String url = "jdbc:mysql://localhost:3306/APPHOTEL?useTimezone=true&serverTimezone=UTC";
            Connection con;
            con = DriverManager.getConnection(url, "root", "P@ssw0rd0123");

            Statement stmt;
            stmt = con.createStatement();

            /* ABRE A BASE PARA USO *****************************************/
            String useBase = "USE APPHOTEL;";
            stmt.executeUpdate(useBase);
            /* CRIA A TABELA ************************************************/
            String query = "create table hospede (\n"
                    + "	ID_hospede int(5) AUTO_INCREMENT , \n"
                    + "	Cpf varchar(12), \n"
                    + "	Nome varchar(100),\n"
                    + "	Email varchar(50),\n"
                    + "	Endereco varchar(100),\n"
                    + "	Cidade varchar(30),\n"
                    + "	Estado varchar(30),\n"
                    + "	Cep varchar(12), \n"
                    + "	primary key(ID_hospede)\n"
                    + ")";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
    //JOptionPane.showMessageDialog(null,ex.getMessage(),
            //               "ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }
}
