package br.ifsp.dsw3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifsp.dsw3.model.dao.VagaDAO;
import br.ifsp.dsw3.model.domain.Vaga;

@WebServlet(name = "vagaServlet", value = "/vagas")
public class VagaServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        VagaDAO dao = new VagaDAO();
        dao.excluir(id);
        resp.sendRedirect("listarvaga.jsp");
    }

    @Override
    public void init() throws ServletException {
        VagaDAO dao = new VagaDAO();
        dao.criarTabela();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String titulo = req.getParameter("titulo");
        String descricao = req.getParameter("descricao");
        String localizacao = req.getParameter("localizacao");
        double salario = Double.parseDouble(req.getParameter("salario"));
        String enviar = req.getParameter("enviar");
        Vaga v = new Vaga(id, titulo, descricao, localizacao, salario);
        VagaDAO dao = new VagaDAO();
        if (enviar.contains("Salvar")) {
            dao.inserir(v);
        } else {
            dao.alterar(v);
        }
        resp.sendRedirect("listarvaga.jsp");
    }

}
