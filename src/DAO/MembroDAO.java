/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Membro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Desenvolvimento
 */
public class MembroDAO {
    
    public boolean salvar(Membro membro) {
        boolean retorno = false;
        PreparedStatement ps = null;
        String sql = "INSERT INTO membros(nome,cargo,cidade,congregacao,dataExpedicao,dataValidade,estadoCivil,pai,mae,"
                   + "naturalidade,estado,nacionalidade,nascimento,rg,cpf,dataBatismo,localBatismo,observacoes,fotoMembro) "
                   + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = Conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, membro.getNome());
            ps.setString(2, membro.getCargo());
            ps.setString(3, membro.getCidade());
            ps.setString(4, membro.getCongregacao());
            ps.setString(5, membro.getDataExpedicao());
            ps.setString(6, membro.getDataValidade());
            ps.setString(7, membro.getEstadoCivil());
            ps.setString(8, membro.getPai());
            ps.setString(9, membro.getMae());
            ps.setString(10, membro.getNatural());
            ps.setString(11, membro.getEstado());
            ps.setString(12, membro.getNacionalidade());
            ps.setString(13, membro.getNascimento());
            ps.setString(14, membro.getRg());
            ps.setString(15, membro.getCpf());
            ps.setString(16, membro.getDataBatismo());
            ps.setString(17, membro.getLocalBatismo());
            ps.setString(18, membro.getObservacoes());
            ps.setBytes(19, membro.getFoto());
            ps.executeUpdate();
            retorno = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar membro!\n"+ex.toString(),"Atenção",JOptionPane.WARNING_MESSAGE);
        }
        return retorno;
    }
    
    public boolean alterar(Membro membro) {
     boolean retorno = false;
        PreparedStatement ps = null;
        String sql = "UPDATE membros set nome=?,cargo=?,cidade=?,congregacao=?,dataExpedicao=?,dataValidade=?,estadoCivil=?,pai=?,mae=?,naturalidade=?,estado=?,nacionalidade=?,nascimento=?,rg=?,cpf=?,dataBatismo=?,localBatismo=?,observacoes=?,fotoMembro=? WHERE codigo = ?";
        try {
            ps = Conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, membro.getNome());
            ps.setString(2, membro.getCargo());
            ps.setString(3, membro.getCidade());
            ps.setString(4, membro.getCongregacao());
            ps.setString(5, membro.getDataExpedicao());
            ps.setString(6, membro.getDataValidade());
            ps.setString(7, membro.getEstadoCivil());
            ps.setString(8, membro.getPai());
            ps.setString(9, membro.getMae());
            ps.setString(10, membro.getNatural());
            ps.setString(11, membro.getEstado());
            ps.setString(12, membro.getNacionalidade());
            ps.setString(13, membro.getNascimento());
            ps.setString(14, membro.getRg());
            ps.setString(15, membro.getCpf());
            ps.setString(16, membro.getDataBatismo());
            ps.setString(17, membro.getLocalBatismo());
            ps.setString(18, membro.getObservacoes());
            ps.setBytes(19, membro.getFoto());
            ps.setInt(20, membro.getCodigo());
            ps.executeUpdate();
            retorno = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar membro!\n"+ex.toString(),"Atenção",JOptionPane.WARNING_MESSAGE);
        }
        return retorno;
    } 
    
    public Membro buscarPorParteNome(String nome) {
        Membro membro = null;
        String sql = "SELECT * FROM membros WHERE nome = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = Conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            if(rs.next()) {
                membro = new Membro();
                membro.setCargo(rs.getString("cargo"));
                membro.setCidade(rs.getString("cidade"));
                membro.setCodigo(rs.getInt("codigo"));
                membro.setCongregacao(rs.getString("congregacao"));
                membro.setCpf(rs.getString("cpf"));
                membro.setDataBatismo(rs.getString("dataBatismo"));
                membro.setDataExpedicao(rs.getString("dataExpedicao"));
                membro.setDataValidade(rs.getString("dataValidade"));
                membro.setEstado(rs.getString("estado"));
                membro.setEstadoCivil(rs.getString("estadoCivil"));
                membro.setFoto(rs.getBytes("fotoMembro"));
                membro.setLocalBatismo(rs.getString("localBatismo"));
                membro.setMae(rs.getString("mae"));
                membro.setNacionalidade(rs.getString("nacionalidade"));
                membro.setNascimento(rs.getString("nascimento"));
                membro.setNatural(rs.getString("naturalidade"));
                membro.setNome(rs.getString("nome"));
                membro.setObservacoes(rs.getString("observacoes"));
                membro.setPai(rs.getString("pai"));
                membro.setRg(rs.getString("rg"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar membro!\n"+ex.toString(),"Atenção",JOptionPane.WARNING_MESSAGE);
        }
        return membro;
    }
    
    public List<Membro> buscaAproximada(String parteNome) {
        
        Membro membro = null;
        List<Membro> listaMembros = new ArrayList<>();
        String sql = "SELECT * FROM membros WHERE nome LIKE '%"+parteNome+"%'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = Conexao.Conexao.getConexao().prepareStatement(sql);
            //ps.setString(1, parteNome);
            rs = ps.executeQuery();
            while(rs.next()) {
                membro = new Membro();
                membro.setCargo(rs.getString("cargo"));
                membro.setCidade(rs.getString("cidade"));
                membro.setCodigo(rs.getInt("codigo"));
                membro.setCongregacao(rs.getString("congregacao"));
                membro.setCpf(rs.getString("cpf"));
                membro.setDataBatismo(rs.getString("dataBatismo"));
                membro.setDataExpedicao(rs.getString("dataExpedicao"));
                membro.setDataValidade(rs.getString("dataValidade"));
                membro.setEstado(rs.getString("estado"));
                membro.setEstadoCivil(rs.getString("estadoCivil"));
                membro.setFoto(rs.getBytes("fotoMembro"));
                membro.setLocalBatismo(rs.getString("localBatismo"));
                membro.setMae(rs.getString("mae"));
                membro.setNacionalidade(rs.getString("nacionalidade"));
                membro.setNascimento(rs.getString("nascimento"));
                membro.setNatural(rs.getString("naturalidade"));
                membro.setNome(rs.getString("nome"));
                membro.setObservacoes(rs.getString("observacoes"));
                membro.setPai(rs.getString("pai"));
                membro.setRg(rs.getString("rg"));
                listaMembros.add(membro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar membros!\n"+ex.toString(),"Atenção",JOptionPane.WARNING_MESSAGE);
        }
        return listaMembros;
    }
    
    
    public List<Membro> buscarTodosMembros() {
        
        Membro membro = null;
        List<Membro> listaMembros = new ArrayList<>();
        String sql = "SELECT * FROM membros";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = Conexao.Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                membro = new Membro();
                membro.setCargo(rs.getString("cargo"));
                membro.setCidade(rs.getString("cidade"));
                membro.setCodigo(rs.getInt("codigo"));
                membro.setCongregacao(rs.getString("congregacao"));
                membro.setCpf(rs.getString("cpf"));
                membro.setDataBatismo(rs.getString("dataBatismo"));
                membro.setDataExpedicao(rs.getString("dataExpedicao"));
                membro.setDataValidade(rs.getString("dataValidade"));
                membro.setEstado(rs.getString("estado"));
                membro.setEstadoCivil(rs.getString("estadoCivil"));
                membro.setFoto(rs.getBytes("fotoMembro"));
                membro.setLocalBatismo(rs.getString("localBatismo"));
                membro.setMae(rs.getString("mae"));
                membro.setNacionalidade(rs.getString("nacionalidade"));
                membro.setNascimento(rs.getString("nascimento"));
                membro.setNatural(rs.getString("naturalidade"));
                membro.setNome(rs.getString("nome"));
                membro.setObservacoes(rs.getString("observacoes"));
                membro.setPai(rs.getString("pai"));
                membro.setRg(rs.getString("rg"));
                listaMembros.add(membro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar membros!\n"+ex.toString(),"Atenção",JOptionPane.WARNING_MESSAGE);
        }
        return listaMembros;
    }
    
}
