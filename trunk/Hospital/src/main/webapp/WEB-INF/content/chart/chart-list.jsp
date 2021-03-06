<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<title></title>
	<link rel="stylesheet" href="/statics/css/bootstrap.min.css">
	<link rel="stylesheet" href="/statics/js/simditor/styles/font-awesome.css">
    <link rel="stylesheet" href="/statics/js/rangepicker/style.css">
	<link rel="stylesheet" href="/statics/css/style.css">
</head>
<body>
	
	<jsp:include page="../include/side.jsp">
		<jsp:param value="chart" name="menu"/>
	</jsp:include>
	
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
       <div class="box">
         <div class="box-header">
           <span class="title"><i class="fa fa-bar-chart-o"></i> 疾病统计</span>
         </div>
         <div class="box-body form">
            <label>选择统计时间段</label>
            <input type="text" id="rangepicker">
            <br/>
            <canvas id="myChart" width="900" height="400"></canvas>    
         </div>
       </div>    


      </div>
		</div>
	</div>

		

  <script src="/statics/js/jquery-1.9.1-min.js"></script>
  <script src="/statics/js/bootstrap.min.js"></script>
  <script src="/statics/js/chart.js"></script>
  <script src="/statics/js/moment.min.js"></script>
  <script src="/statics/js/rangepicker/rangepicker.js"></script>
  <script>
    $(function(){

        //初始化值
        /* var data = {
          labels: ["肺结核", "骨折", "沙眼", "流感", "肿瘤", "腹泻", "小儿麻痹"],
          datasets: [
              {
                  fillColor: "#40d47e",
                  strokeColor: "rgba(220,220,220,0.8)",
                  highlightFill: "rgba(220,220,220,0.75)",
                  highlightStroke: "rgba(220,220,220,1)",
                  data: [0, 0, 0, 0, 0, 0, 0]
              }
          ]
        };
        var ctx = $("#myChart").get(0).getContext("2d");
        new Chart(ctx).Bar(data);
 */

       $("#rangepicker").daterangepicker(
          {
            ranges: {
             '今天': [new Date(), new Date()],
             '昨天': [moment().subtract('days', 1), moment().subtract('days', 1)],
             '最近7天': [moment().subtract('days', 6), new Date()],
             '最近30天': [moment().subtract('days', 29), new Date()],
             '本月': [moment().startOf('month'), moment().endOf('month')],
             '上一月': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
            },
            opens: 'left',
            format:'YYYY/MM/DD'
          },
          function(start,end,label){
            console.log("start:" + start.format('YYYY-MM-DD'));
            console.log("end:" + end.format('YYYY-MM-DD'));
         	
            $.ajax({
            	url:"/chartJson.action",
            	data:{"q_S_BT_createtime":$("#rangepicker").val()},
            	dataType:"json",
            	type:"get",
            	
            	success:function(json){
            		
            		var data = {
                            labels: json.labels,
                            datasets: [
                              {
                                  fillColor: "#40d47e",
                                  strokeColor: "rgba(220,220,220,0.8)",
                                  highlightFill: "rgba(220,220,220,0.75)",
                                  highlightStroke: "rgba(220,220,220,1)",
                                  data: json.data
                              }
                            ]
                          }; 
            		var ctx = $("#myChart").get(0).getContext("2d");
                    new Chart(ctx).Bar(data);
                          
             	 },
				error:function(){
					alert("获取任务数据失败");
				}
            		
            });
          }

        );

    });
  </script>
	
	
</body>
</html>