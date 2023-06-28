package br.ifsp.dsw3.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifsp.dsw3.model.dao.*;
import br.ifsp.dsw3.model.domain.*;

@WebServlet(name = "trabalhoServlet", value = "/trabalhos")
public class TrabalhoServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TrabalhoDAO dao = new TrabalhoDAO();
        dao.excluir(id);
        resp.sendRedirect("listartrabalho.jsp");
    }

    @Override
    public void init() throws ServletException {
        TrabalhoDAO dao = new TrabalhoDAO();
        dao.criarTabela();
    }

    /*
        PROBLEMA NO SQL P/ NÃO ESQUECER:
        No servlet, ele insere t com os *OBJETOS* VAGA e CANDIDATO, porém, na tabela
        SQL, apenas são inseridos os IDs de vaga e candidato. Como resolver?
         

    */


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        VagaDAO vDAO = new VagaDAO();
        Vaga vaga = null;
        CandidatoDAO cDAO = new CandidatoDAO();
        Candidato candidato = null;

        int id = Integer.parseInt(req.getParameter("id"));
        int idV = Integer.parseInt(req.getParameter("idVaga"));
        vaga = vDAO.pesquisarPorId(idV);
        int idC = Integer.parseInt(req.getParameter("idCandidato"));
        candidato = cDAO.pesquisarPorId(idC);
        Date dataInicio = Date.valueOf(req.getParameter("dataInicio"));
        String enviar = req.getParameter("enviar");
        Trabalho t = new Trabalho(id, vaga, candidato, dataInicio);
        TrabalhoDAO dao = new TrabalhoDAO();
        if (enviar.contains("Salvar")) {
            dao.inserir(t);
        } else {
            dao.alterar(t);
        }
        resp.sendRedirect("listartrabalho.jsp");
    }
}
