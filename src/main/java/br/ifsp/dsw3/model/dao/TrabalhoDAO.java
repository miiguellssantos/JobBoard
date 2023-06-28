package br.ifsp.dsw3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import br.ifsp.dsw3.model.domain.Candidato;
import br.ifsp.dsw3.model.domain.Trabalho;
import br.ifsp.dsw3.model.domain.Vaga;

public class TrabalhoDAO {
    public void removerTabela(){
        String sql = "DROP TABLE trabalhos;";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS trabalhos(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL," +
                "idVaga INTEGER," +
                "idCandidato INTEGER," +
                "dataInicio DATE," +
                "FOREIGN KEY(idVaga) REFERENCES vagas(id)," +
                "FOREIGN KEY(idCandidato) REFERENCES candidatos(id))";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Trabalho trabalho) {
        int inseriu = 0;
        String sql = "INSERT INTO trabalhos(idVaga, idCandidato, dataInicio) VALUES(?, ?, ?)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, trabalho.getVaga().getId());
            stmt.setInt(2, trabalho.getCandidato().getId());
            stmt.setDate(3, trabalho.getDataInicio());
            
            inseriu = stmt.executeUpdate();
            System.out.println("inseriu " + inseriu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM trabalhos WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Trabalho trabalho) {
        String sql = "UPDATE trabalhos SET idVaga=?, idCandidato=?, dataInicio=? WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, trabalho.getVaga().getId());
            stmt.setInt(2, trabalho.getCandidato().getId());
            stmt.setDate(3, trabalho.getDataInicio());
            stmt.setInt(5, trabalho.getId());
            int alterou = 0;
            alterou = stmt.executeUpdate();
            System.out.println("alterou " + alterou);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Trabalho> listar() {
        ArrayList<Trabalho> trabalhos = new ArrayList<>();
        String sql = "SELECT * FROM trabalhos";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VagaDAO vDAO = new VagaDAO();
                CandidatoDAO cDAO = new CandidatoDAO(); 
                int id = rs.getInt("id");
                int idVaga = rs.getInt("idVaga");
                int idCandidato = rs.getInt("idCandidato");
                Date d = rs.getDate("dataInicio");
                Vaga vaga = vDAO.pesquisarPorId(idVaga);
                Candidato candidato = cDAO.pesquisarPorId(idCandidato);
                Trabalho t = new Trabalho(id, vaga, candidato, d);
                trabalhos.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trabalhos;
    }

    public Trabalho pesquisarPorId(int id) {
        Trabalho trabalho = null;
        String sql = "SELECT * FROM trabalhos WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idTrabalho = rs.getInt("id");
                int idVaga = rs.getInt("idVaga");
                int idCandidato = rs.getInt("idCandidato");
                Date d = rs.getDate("dataInicio");
                Vaga vaga = new Vaga();
                vaga.setId(idVaga);
                Candidato candidato = new Candidato();
                candidato.setId(idCandidato);
                trabalho = new Trabalho(idTrabalho, vaga, candidato, d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trabalho;
    }
}
