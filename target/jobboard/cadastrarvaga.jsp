<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ifsp.dsw3.model.dao.*,br.ifsp.dsw3.model.domain.*"%>

<%
  Vaga v = null;
  String botao;

  if (request.getParameter("id")!=null){
    VagaDAO dao = new VagaDAO();
    int id = Integer.parseInt(request.getParameter("id"));
    v = dao.pesquisarPorId(id);
    botao = "Alterar";
  } else {
    v = new Vaga();
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
                <a href="cadastrarvaga.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Vagas</a>
                <a href="cadastrarcandidato.jsp">Candidatos</a>
                <a href="listarvaga.jsp" style="color: white; background-color: #0a66c2; border-radius: 10px; border:1px solid #0a66c2">Listar Vagas</a>

            </div>
        </nav>

        <div class="container" id="cadastro">
            <div class="create">
                <form action="vagas" method="POST">
                    <label for="titulo">Título da Vaga</label><br>
                    <input type="text" id="titulo"
                            placeholder="Título da vaga" 
                            autofocus="autofocus" 
                            name="titulo" 
                            value="<%=v.getTitulo()%>"/>
                
                    <label for="descricao">Descrição da vaga</label><br>
                    <textarea id="descricao"
                               placeholder="Descrição da vaga" 
                               autofocus="autofocus" 
                               name="descricao" 
                               value="<%=v.getDescricao()%>"></textarea>
                
                    <label for="localizacao">Localização da Vaga</label><br>
                    <input type="text" id="localizacao"
                            placeholder="Localização da vaga" 
                            autofocus="autofocus" 
                            name="localizacao" 
                            value="<%=v.getLocalizacao()%>"/>
                    <label for="salário">Salário da vaga</label><br>
                    <input type="number" id="salario"
                            step="any"
                            autofocus="autofocus" 
                            name="salario" 
                            value="<%=v.getSalario()%>"/>
                    <input type="hidden" id="id" name="id" value="<%=v.getId()%>"/>
                    <button type="submit" name="enviar" value="<%=botao%>"><%=botao%></button>
                </form>
            </div>
            
        </div>

    </body>
</html>