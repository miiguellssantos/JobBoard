<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ifsp.dsw3.model.dao.*,br.ifsp.dsw3.model.domain.*"%>
<%@page import="java.util.*"%>

<%
    TrabalhoDAO dao = new TrabalhoDAO();
    dao.criarTabela();
    ArrayList<Trabalho>trabalhos=dao.listar();
    System.out.println("trabalhos " + trabalhos );
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
                <a href="cadastrartrabalho.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Trabalhos</a>
                <a href="cadastrarvaga.jsp">Vagas</a>
                <a href="cadastrarcandidato.jsp">Candidatos</a>
                <a href="cadastrartrabalho.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Cadastrar Trabalhos</a>
            </div>
        </nav>

        <div class="container">
            <% 
                for (Trabalho t:trabalhos){
            %>
            <div class="overview-vaga" id="<%=t.getId()%>">
                <div class="info">
                    <h2><%=t.getVaga().getTitulo()%></h2>
                    <p><b> Empregado: <%=t.getCandidato().getNome()%></b></p>
                    <p>Desde <%=t.getDataInicio()%></p>
                </div>
                
                <div class="actions"> 
                    <a class="btnEditar" href="cadastrartrabalho.jsp?id=<%=t.getId()%>" role="button">
                        Editar
                    </a>
                    <a class="btnExcluir" href="trabalhos?id=<%=t.getId()%>" role="button">
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