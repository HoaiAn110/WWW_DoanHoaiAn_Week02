<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.JsonObject" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.repositories.OrderDetailRepository" %>
<%@ page import="com.example.www_doanhoaian_week02_restapi.repositories.ProductRepository" %>

<%
    Gson gsonObj = new Gson();
    List<Map<Object, Object>> list = new ArrayList<>();

    // Fetch data from the repository
    OrderDetailRepository orderDetailRepository = new OrderDetailRepository();
    Map<Long, Double> mapOrder = orderDetailRepository.staticsPriceByProduct();

    // Iterate over the map to create a list of data points
    ProductRepository productRepository = new ProductRepository();
    for (Long key : mapOrder.keySet()) {
        Map<Object, Object> map = new HashMap<>();
        map.put("label", productRepository.getProductNameById(key));
        map.put("y", mapOrder.get(key));
        list.add(map);
    }

    // Convert data points to JSON
    String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="cdn.jsp" %>
    <script type="text/javascript">
        window.onload = function() {
            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2",
                title: {
                    text: "Chart Of Total Revenue Of Each Product"
                },
                subtitles: [{
                    text: "2023"
                }],
                axisY: {
                    title: "USD",
                    labelFormatter: addSymbols
                },
                data: [{
                    type: "bar",
                    indexLabel: "{y}",
                    indexLabelFontColor: "#444",
                    indexLabelPlacement: "inside",
                    dataPoints: <%= dataPoints %>
                }]
            });

            chart.render();

            function addSymbols(e) {
                var suffixes = ["", "K", "M", "B"];
                var order = Math.max(Math.floor(Math.log(Math.abs(e.value)) / Math.log(1000)), 0);

                if (order > suffixes.length - 1)
                    order = suffixes.length - 1;

                var suffix = suffixes[order];
                return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;
            }
        }
    </script>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
</body>
</html>
