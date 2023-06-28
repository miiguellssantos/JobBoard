package br.ifsp.dsw3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.dsw3.model.domain.Candidato;

public class CandidatoDAO {
    public void removerTabela(){
        String sql = "DROP TABLE candidatos;";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS candidatos(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL," +
        "cpf INTEGER," +
        "nome VARCHAR(40)," +
        "email VACHAR(40)," +
        "telefone INTEGER)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Candidato candidato){
        String sql = "INSERT INTO candidatos(cpf, nome, email, telefone) VALUES(?, ?, ?, ?)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, candidato.getCPF());
            stmt.setString(2, candidato.getNome());
            stmt.setString(3, candidato.getEmail());
            stmt.setString(4, candidato.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM candidatos WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Candidato candidato){
        String sql = "UPDATE candidatos SET cpf=?, nome=?, email=?, telefone=? WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, candidato.getCPF());
            stmt.setString(2, candidato.getNome());
            stmt.setString(3, candidato.getEmail());
            stmt.setString(4, candidato.getTelefone());
            stmt.setInt(5, candidato.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public ArrayList<Candidato> listar(){
        ArrayList<Candidato> candidatos = new ArrayList<>();
        String sql = "SELECT * FROM candidatos";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet  rs = stmt.executeQuery();
            while (rs.next()){
                Candidato c = new Candidato(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"));
                candidatos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidatos;
    }

    public Candidato pesquisarPorId(int id){
        Candidato candidato = null;
        String sql = "SELECT * FROM candidatos WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                candidato = new Candidato(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"));    
            }    
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return candidato;
    }
}
