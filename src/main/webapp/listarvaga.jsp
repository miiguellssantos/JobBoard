<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ifsp.dsw3.model.dao.*,br.ifsp.dsw3.model.domain.*"%>
<%@page import="java.util.*"%>

<%
    VagaDAO dao = new VagaDAO();
    dao.criarTabela();
    ArrayList<Vaga>vagas=dao.listar();
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
                <a href="cadastrarvaga.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Vagas</a>
                <a href="cadastrarcandidato.jsp">Candidatos</a>
                <a href="cadastrarvaga.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Cadastrar Vagas</a>
            </div>
        </nav>

        <div class="container">
            <%
                for (Vaga v:vagas){
            %>
            <div class="overview-vaga" id="<%=v.getId()%>">
                <div class="info">
                    <h2><%=v.getTitulo()%></h2>
                    <p><b><%=v.getLocalizacao()%></b></p>
                    <p><%=v.getDescricao()%></p>
                    <div>Salário: <b><%=v.getSalario()%></b></div>
                </div>
                
                <div>
                    <a class="btnEditar" href="cadastrarvaga.jsp?id=<%=v.getId()%>" role="button">
                        Editar
                    </a>
                    <a class="btnExcluir" href="vagas?id=<%=v.getId()%>" role="button">
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