<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>国考报名查询系统</title>

    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" />

<style>

#div1{
  margin-left:10px;
  margin-right:10px;
  margin-bottom:20px;
}
#jobInfo_table{

	border : 1px ;
}
</style>
</head>
<body>
  <div id = "div1">
     <h2>国考信息筛选系统</h2>
     
     <hr>
     
     筛选条件：
     <div class="dropdown">
		  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
		   部门名称
		    <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
		    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">中央纪委、监察部机关</a></li>
		    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
		    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
		    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
		  </ul>
	</div>
  
     <hr>
     
    <table class="table table-bordered table-condensed" id="jobInfo_table">
	  <tr class="active">
	  <th>索引</th>
	  <th>部门代码</th>
	  <th>部门名称</th>
	  <th>用人司局</th>
	  <th>机构性质</th>
	  <th>机构层级</th>
	  <th>职位属性</th>
	  <th>职位名称</th>
	  <th>职位简介</th>
	  <th>职位代码</th>
	  <th>考试类别</th>
	  <th>招考人数</th>
	  <th>专业</th>
	  <th>学位</th>
	  <th>学历</th>
	  <th>政治面貌</th>
	  <th>基层工作最低年限</th>
	  <th>‘三支一扶’大学生</th>
	  <th>西部志愿者</th>
	  <th>大学生村官</th>
	  <th>特岗计划教师</th>
	  <th>无限制</th>
	  <th>是否组织专业考试</th>
	  <th>比例</th>
	  <th>其他条件</th>
	  <th>备注</th>
	  <th>职位分布</th>
	  <th>部门网站</th>
	  <th>咨询电话1</th>
	  <th>咨询电话2</th>
	  <th>咨询电话3</th> 
	  </tr> 
	 
	</table>
	<div style="text-align: center;">
		<nav>
		  <ul class="pagination">
		    <li><a href="#">&laquo;</a></li>
		    <li><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li>
		    <li><a href="#">...</a></li>
		    <li><a href="#">100</a></li>
		    <li><a href="#">&raquo;</a></li>
		  </ul>
		</nav>

</nav>
	</div>
	
    </div>

<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	
	
    <script type="text/javascript">
    	$(function(){
    		 $.post("${pageContext.request.contextPath}/jobInfoList/getList.do",
    				function(data) {
    		
    			 var tab = $('#jobInfo_table');
    			 
    			 for(var i=0;i<data.length;i++){
    				 
    				 tab.append("<tr class=\"success\"><td>"+(i+1)
													+"</td><td>"+data[i].deptcode
													+"</td><td>"+data[i].deptname
													+"</td><td>"+data[i].employplace
													+"</td><td>"+data[i].institutional_properties
													+"</td><td>"+data[i].institutional_level
													+"</td><td>"+data[i].position_property
													+"</td><td>"+data[i].position_name
													+"</td><td>"+data[i].position_summary
													+"</td><td>"+data[i].position_number
													+"</td><td>"+data[i].test_category
													+"</td><td>"+data[i].recruit_number
													+"</td><td>"+data[i].speciality
													+"</td><td>"+data[i].degree
													+"</td><td>"+data[i].education
													+"</td><td>"+data[i].political_status
													+"</td><td>"+data[i].basic_level
													+"</td><td>"+data[i].three_hand_students
													+"</td><td>"+data[i].volunteers_west
													+"</td><td>"+data[i].village_officials
													+"</td><td>"+data[i].special_teacther
													+"</td><td>"+data[i].unlimit
													+"</td><td>"+data[i].professional_exam
													+"</td><td>"+data[i].percentage
													+"</td><td>"+data[i].other
													+"</td><td>"+data[i].notes
													+"</td><td>"+data[i].position
													+"</td><td>"+data[i].website
													+"</td><td>"+data[i].telephone1
													+"</td><td>"+data[i].telephone2
													+"</td><td>"+data[i].telephone3
												+"</td></tr>");
 				
    			 }
    			 
    			}, 'json'
    			
    		); 
    	});
    </script>
</body>
</html>