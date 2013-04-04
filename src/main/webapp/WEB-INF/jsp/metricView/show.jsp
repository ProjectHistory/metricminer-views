<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Metric Miner</title>

</head>
<body>

<div id="chart_committers" />

</body>
</html>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">

  google.load('visualization', '1.0', {'packages':['corechart']});
  google.setOnLoadCallback(all);

  function all() {
	  
	  var c1 = [
	   <c:forEach var="item" items="${cc}">
		['${item.name}', ${item.commits}],
	   </c:forEach>
	           ];
	  drawPie("chart_committers", "Committers of the Project", "Developer", "Number of Commits", c1);
  }
  
  function drawPie(div, title, x, y, content) {

    var data = new google.visualization.DataTable();
    data.addColumn('string', x);
    data.addColumn('number', y);
    data.addRows(content);

    var options = {'title': title,
                   'width':400,
                   'height':300};

    var chart = new google.visualization.PieChart(document.getElementById(div));
    chart.draw(data, options);
  }
</script>