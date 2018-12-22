<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2017/10/28
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>根据困难程度的错题率最高的十题</title>
    <script type="text/javascript" src="./js/echarts.min.js"></script>

</head>
<body style="height: 100%; margin: 0;">
<style type="text/css">
    h3 {
        font-size: 12px;
        color: #ffffff;
        display: inline
    }
</style>
<h4 style="text-align:center">错题率</h4>
<%--<h3 style="margin-left: 70%">通话次数</h3>--%>
<%--<h3 style="margin-left: 20%">通话时长</h3>--%>


 <div id="main" style="width: 900px;height:400px;"></div>
 <script type="text/javascript">
        var question_id = "${requestScope.question_id}"
        var error_rate = "${requestScope.error_rate}"
        alert(error_rate);
    // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '错题率最高的五题'
        },
        tooltip: {},
        legend: {
            data:['题号']
        },
        xAxis: {
            data: question_id.split(",")
        },
        yAxis: {},
        series: [{
            name: '错误率',
            type: 'bar',
            data: error_rate.split(",")
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>

</body>
</html>
