<html>
<head>
  <title>NETS150 Homework 5</title>
</head>
<%@ page import="code.Graph" %>
<%@ page import="code.BFS_Driver" %>
<%@ page import="code.Driver" %>
<body>
  <h3>Choose an algorithm:</h3>
  <form method="get">
    <input type="radio" name="algorithm" value="BFS">BFS
    <input type="radio" name="algorithm" value="DFS">DFS
    <input type="radio" name="algorithm" value="Dijkstra">Dijkstra
    <input type="submit" value="Execute">
  </form>
 
  <%
  String[] algorithms = request.getParameterValues("algorithm");
  if (algorithms != null) {
  %>
    <h3>You have selected algorithm(s):</h3>
    <ul>
      <li><%= algorithms[0] %></li>
    </ul>
    <a href="<%= request.getRequestURI() %>">Choose Another</a>
  <%
 	 switch (algorithms[0]) {
 	 	case "BFS":
 			Driver.runBFS();
 			break;
 	 	case "DFS":
 	 		Driver.runDFS();
 			break;
 	 	case "Dijkstra":
 	 		Driver.runDIJKSTRA();
 			break;
 	 }
  }
  %>
</body>
</html>