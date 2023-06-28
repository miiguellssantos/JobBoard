<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ifsp.dsw3.model.dao.*,br.ifsp.dsw3.model.domain.*"%>
<%@page import="java.util.*"%>

<%
  Trabalho t = null;
  String botao;

    VagaDAO vdao = new VagaDAO();
    vdao.criarTabela();
    ArrayList<Vaga>vagas=vdao.listar();

    CandidatoDAO cdao = new CandidatoDAO();
    cdao.criarTabela();
    ArrayList<Candidato>candidatos=cdao.listar();

  if (request.getParameter("id")!=null){
    TrabalhoDAO dao = new TrabalhoDAO();
    int id = Integer.parseInt(request.getParameter("id"));
    t = dao.pesquisarPorId(id);
    botao = "Alterar";
  } else {
    t = new Trabalho();
    botao = "Salvar";
  }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style/style.css">
        <title>JobBoard</title>
    </head>

    <body>
        
        <nav class="navbar">
            <h1>Job Board</h1>
            <div class="links">
                <a href="index.html">Home</a>
                <a href="#cadastrartrabalho.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Trabalhos</a>
                <a href="cadastrarvaga.jsp">Vagas</a>
                <a href="cadastrarcandidato.jsp">Candidatos</a>
                <a href="listartrabalho.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Listar Trabalhos</a>

            </div>
        </nav>

        <div class="container" id="cadastro">
            <div class="create">
                <form action="trabalhos" method="POST">
                    <label for="idVaga">Vaga:</label>
                    <select
                        name="idVaga"
                        id="idVaga"
                    >
                    <%
                        for (Vaga v:vagas){
                    %>
                        <option
                            value="<%=v.getId()%>"><%=v.getTitulo()%></option>
                    <%
                        }
                    %>
                    </select>

                    <label for="idCandidato">Candidato:</label>
                    <select
                        name="idCandidato"
                        id="idCandidato"
                    >
                    <%
                        for (Candidato c:candidatos){
                    %>
                        <option
                            value="<%=c.getId()%>"><%=c.getNome()%></option>
                    <%
                        }
                    %>
                    </select>
                    <label for="dataInicio">Data de Início</label>
                    <input type="date" 
                            name="dataInicio"
                            id="dataInicio" 
                            value="<%=t.getDataInicio()
                            %>" />
                    <input type="hidden" id="id" name="id" value="<%=t.getId()%>"/>
                    <button type="submit" name="enviar" value="<%=botao%>"><%=botao%></button>
                </form>
            </div>
            
        </div>

    </body>
</html>