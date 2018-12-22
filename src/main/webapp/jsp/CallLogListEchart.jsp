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
    <title>班级每个人正确率</title>
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
<h4 style="text-align:center">每个班的正确率</h4>
<%--<h3 style="margin-left: 70%">通话次数</h3>--%>
<%--<h3 style="margin-left: 20%">通话时长</h3>--%>


 <div id="main" style="width: 900px;height:500px;"></div>
 <script type="text/javascript">
        var stu_id = "${requestScope.stu_id}"
        var true_rate = "${requestScope.true_rate}"
        alert(true_rate);
    // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '班级成员正确率'
        },
        tooltip: {},
        legend: {
            data:['班级成员']
        },
        xAxis: {
            data: stu_id.split(",")
        },
        yAxis: {},
        series: [{
            name: '正确率',
            type: 'bar',
            data: true_rate.split(",")
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>

</body>
</html>
