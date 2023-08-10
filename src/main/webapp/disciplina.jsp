<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.unb.dominio.Professor" %>

<html>
<head>
    <title>Cadastro de Disciplinas</title>
  <!-- Outras meta tags, títulos, etc... -->
  <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>

    <h1>Cadastro de Disciplinas</h1>

    <html:form action="/disciplina" method="post">

        <html:hidden property="method" value="${disciplinaForm.id == 0 || disciplinaForm.id == null ? 'salvar' : 'atualizar'}"/>
		<html:hidden property="id" value="${disciplinaForm.id}"/>
		
		<span style="color: red">
        <html:errors/>
		</span>
        <p>
            <label for="nome">Nome:</label>
            <html:text property="nome" size="50"/>
        </p>
        <p>
            <label for="curso">Curso:</label>
            <html:text property="curso" size="50"/>
        </p>
        <p>
            <label for="turma">Turma:</label>
            <html:text property="turma" size="50"/>
        </p>
        <p>
            <label for="local">Local:</label>
            <html:text property="local" size="50"/>
        </p>
        <p>
		    <label for="professores">Selecioe o Professor:</label>
		    <html:select property="professorSelecionado" style="width: 200px; background-color: #f0f0f0; border: 1px solid #ccc;">
		        <c:forEach var="professor" items="${professores}">
		            <html:option value="${professor.id}">
		                <c:out value="${professor.nome}"/>
		            </html:option>
		        </c:forEach>
		    </html:select>
		</p>
        
        
        
        <p>
            <html:submit value="${disciplinaForm.id == 0 || disciplinaForm.id == null ? 'Salvar' : 'Atualizar'}"/>
        </p>

    </html:form>

    <h2>Lista de Disciplinas</h2>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Curso</th>
            <th>Turma</th>
            <th>Local</th> 
            <th>Professor</th>                                      
            <th>Editar</th>
            <th>Excluir</th>
        </tr>
        <logic:iterate name="disciplinas" id="disciplina">
             <tr>
                <td><bean:write name="disciplina" property="id" /></td>
                <td><bean:write name="disciplina" property="nome" /></td>
                <td><bean:write name="disciplina" property="curso" /></td>
                <td><bean:write name="disciplina" property="local" /></td>
                <td><bean:write name="disciplina" property="turma" /></td>    
                <td><bean:write name="disciplina" property="professor" /></td>                                  
                <td>
                    <a href="<%= request.getContextPath() %>/disciplina.do?method=editar&id=<bean:write name='disciplina' property='id' />">Editar</a>
                </td>
                <td>
                    <a href="<%= request.getContextPath() %>/disciplina.do?method=excluir&id=<bean:write name='disciplina' property='id' />"
                       onclick="return confirm('Tem certeza que deseja excluir a disciplina?');">Excluir</a>
                </td>
            </tr>
        </logic:iterate>
    </table>

</body>
</html>
