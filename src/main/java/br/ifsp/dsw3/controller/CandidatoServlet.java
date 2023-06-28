package br.ifsp.dsw3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifsp.dsw3.model.dao.CandidatoDAO;
import br.ifsp.dsw3.model.domain.Candidato;

@WebServlet(name = "candidatoServlet", value = "/candidatos")
public class CandidatoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CandidatoDAO dao = new CandidatoDAO();
        dao.excluir(id);
        resp.sendRedirect("listarcandidato.jsp");
    }

    @Override
    public void init() throws ServletException {
        CandidatoDAO dao = new CandidatoDAO();
        dao.criarTabela();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String cpf = req.getParameter("cpf");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");
        String enviar = req.getParameter("enviar");
        Candidato c = new Candidato(id, cpf, nome, email, telefone);
        CandidatoDAO dao = new CandidatoDAO();
        if (enviar.contains("Salvar")) {
            dao.inserir(c);
        } else {
            dao.alterar(c);
        }
        resp.sendRedirect("listarcandidato.jsp");
    }
}
