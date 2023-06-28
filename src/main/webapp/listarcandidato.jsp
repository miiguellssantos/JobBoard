<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ifsp.dsw3.model.dao.*,br.ifsp.dsw3.model.domain.*"%>
<%@page import="java.util.*"%>

<%
    CandidatoDAO dao = new CandidatoDAO();
    dao.criarTabela();
    ArrayList<Candidato>candidatos=dao.listar();
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style/style.css">
        <title>Document</title>
    </head>

    <body>
        <nav class="navbar">
            <h1>Job Board</h1>
            <div class="links">
                <a href="index.html">Home</a>
                <a href="cadastrartrabalho.jsp">Trabalhos</a>
                <a href="cadastrarvaga.jsp">Vagas</a>
                <a href="cadastrarcandidato.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Candidatos</a>
                <a href="cadastrarcandidato.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Cadastrar Candidatos</a>
            </div>
        </nav>

        <div class="container">
            <%  
                for (Candidato c:candidatos){
            %>
            <div class="overview-vaga" id="<%=c.getId()%>">
                <div class="info">
                    <h2><%=c.getNome()%></h2>
                    <p>CPF: <b><%=c.getCPF()%></b></p>
                    <p><%=c.getEmail()%></p>
                    <p><%=c.getTelefone()%></p>
                </div>
                
                <div class="actions">
                    <a class="btnEditar" href="cadastrarcandidato.jsp?id=<%=c.getId()%>" role="button">
                        Editar
                    </a>
                    <a class="btnExcluir" href="candidatos?id=<%=c.getId()%>" role="button">
                        Excluir
                    </a>
                </div>
                
            </div>
            <%
                }
            %>
        </div>
    </body>
</html>