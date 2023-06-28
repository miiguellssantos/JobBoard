package br.ifsp.dsw3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.dsw3.model.domain.Vaga;

public class VagaDAO {
    
    public void removerTabela(){
        String sql = "DROP TABLE vagas;";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void criarTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS vagas( id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, titulo VARCHAR(40), descricao VARCHAR(40), localizacao VACHAR(40), salario double)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Vaga vaga){
        String sql = "INSERT INTO vagas(titulo, descricao, localizacao, salario) VALUES(?, ?, ?, ?)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, vaga.getTitulo());
            stmt.setString(2, vaga.getDescricao());
            stmt.setString(3, vaga.getLocalizacao());
            stmt.setDouble(4, vaga.getSalario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM vagas WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Vaga vaga){
        String sql = "UPDATE vagas SET titulo=?, descricao=?, localizacao=?, salario=? WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1, vaga.getTitulo());
            stmt.setString(2, vaga.getDescricao());
            stmt.setString(3, vaga.getLocalizacao());
            stmt.setDouble(4, vaga.getSalario());
            stmt.setInt(5, vaga.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public ArrayList<Vaga> listar(){
        ArrayList<Vaga> vagas = new ArrayList<>();
        String sql = "SELECT * FROM vagas";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet  rs = stmt.executeQuery();
            while (rs.next()){
                Vaga v = new Vaga(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("localizacao"), rs.getDouble("salario"));
                vagas.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vagas;
    }

    public Vaga pesquisarPorId(int id){
        Vaga vaga = null;
        String sql = "SELECT * FROM vagas WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                vaga = new Vaga(rs.getInt("id"), rs.getString("titulo"), rs.getString("descricao"), rs.getString("localizacao"), rs.getDouble("salario"));
            }    
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vaga;
    }
}
