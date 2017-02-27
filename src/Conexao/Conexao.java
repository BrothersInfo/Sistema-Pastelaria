/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/** 
 *
 * @author Desenvolvimento
 */
public class Conexao {
    
    public static String     Driver  = "com.mysql.jdbc.Drive";
    public static String     Banco   = "Igreja";
    public static String     Caminho = "jdbc:mysql://localhost:3306/" + Banco;
    public static String     Usuario = "root";
    public static String     Senha   = "root";
    public static Connection Conexao = null;
    
    public static Connection getConexao() throws SQLException {
        try {
            Class.forName(Driver);
            Conexao = DriverManager.getConnection(Caminho,Usuario,Senha);
        } catch (SQLException ERRO) {
            JOptionPane.showMessageDialog(null,"Falha no Banco de Dados!\n" + ERRO.toString());
       } catch (ClassNotFoundException e) {
           
       }
        return Conexao;
    }
    
}
