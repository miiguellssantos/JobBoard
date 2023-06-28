<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ifsp.dsw3.model.dao.*,br.ifsp.dsw3.model.domain.*"%>

<%
  Candidato c = null;
  String botao;

  if (request.getParameter("id")!=null){
    CandidatoDAO dao = new CandidatoDAO();
    int id = Integer.parseInt(request.getParameter("id"));
    c = dao.pesquisarPorId(id);
    botao = "Alterar";
  } else {
    c = new Candidato();
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
                <a href="listarcandidato.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Listar Candidatos</a>

            </div>
        </nav>

        <div class="container" id="cadastro">
            <div class="create">
                <form action="candidatos" method="POST">
                    <label for="cpf">CPF do Candidato:</label><br>
                    <input type="text" id="cpf"
                           placeholder="XXX.XXX.XXX-XX"
                           autofocus="autofocus" 
                           name="cpf" 
                           value="<%=c.getCPF()%>"/>

                    <label for="nome">Nome do Cadidato</label><br>
                    <input type="text" id="nome"
                            placeholder="Nome do Candidato" 
                            autofocus="autofocus" 
                            name="nome" 
                            value="<%=c.getNome()%>"/>
                
                    <label for="nome">Email do Cadidato</label><br>
                    <input type="text" id="email"
                            placeholder="Email" 
                            autofocus="autofocus" 
                            name="email" 
                            value="<%=c.getEmail()%>"/>
                
                    <label for="telefone">Telefone do Candidato:</label><br>
                    <input type="text" id="telefone"
                            placeholder="(XX) XXXXX-XXXX"
                            autofocus="autofocus" 
                            name="telefone" 
                            value="<%=c.getTelefone()%>"/>
                    <input type="hidden" id="id" name="id" value="<%=c.getId()%>"/>
                    <button type="submit" name="enviar" value="<%=botao%>"><%=botao%></button>
                </form>
            </div>
            
        </div>

    </body>
</html>