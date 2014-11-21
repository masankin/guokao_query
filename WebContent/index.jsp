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
  	text-align:center;
}
#jobInfo_table{

	border : 1px ;
	align:center;
	text-align:center;
}
#searchform{
text-align:left;
}
th{
	text-align:center;
}
</style>
</head>
<body>
  <div id = "div1">
     <h2>国考信息筛选系统 </h2>
     
     
     
     <hr>
     <div id="searchform">
<h4>搜索条件：</h4>
 <form class="form-inline" role="form">
  <div class="form-group">
    <div class="input-group">
      <div class="input-group-addon">学历</div>
        <select class="form-control">
		  <option>大专</option>
		  <option>本科</option>
		  <option>硕士</option>
		  <option>博士</option>
		  <option>其他</option>
		</select>
   	 </div>
  </div>
  <div class="form-group">
    <div class="input-group">
      <div class="input-group-addon">学位</div>
        <select class="form-control">
		  <option>学士</option>
		  <option>硕士</option>
		  <option>博士</option>
		</select>
   	 </div>
  </div>
  <div class="form-group">
    <div class="input-group">
      <div class="input-group-addon">专业</div>
        <select class="form-control">
		  <option>计算机科学与技术</option>
		  <option>土木工程</option>
		  <option>软件工程</option>
		  <option>法学</option>
		  <option>经济学</option>
		</select>
   	 </div>
  </div>
  <div class="form-group">
    <div class="input-group">
      <div class="input-group-addon">毕业时间</div>
        <select class="form-control">
		  <option>2010</option>
		  <option>2010</option>
		  <option>2011</option>
		  <option>2012</option>
		  <option>2013</option>
		  <option>2014</option>
		  <option>2015</option>
		</select>
   	 </div>
  </div>
  <div class="form-group">
    <div class="input-group">
      <div class="input-group-addon">政治面貌</div>
        <select class="form-control">
		  <option>团员</option>
		  <option>党员</option>
		  <option>群众</option>
		</select>
   	 </div>
  </div>
  <div class="form-group">
    <div class="input-group">
      <div class="input-group-addon">基层工作年限</div>
        <select class="form-control">
		  <option>无</option>
		  <option>一年</option>
		  <option>两年</option>
		</select>
   	 </div>
  </div>
  <div class="form-group">
    <div class="input-group">
      <div class="input-group-addon">欲工作地点</div>
        <select class="form-control">
		  <option>北京</option>
		  <option>上海</option>
		  <option>山西</option>
		</select>
   	 </div>
  </div>
 
  <button type="submit" class="btn btn-success">搜索</button>
</form>
</div>
     <hr>
    <table class="table table-striped table-bordered table-condensed table-hover" id="jobInfo_table">
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
	  <th>'三支一扶'大学生</th>
	  <th>西部志愿者</th>
	  <th>大学生村官</th>
	  <th>特岗计划教师</th>
	  <th>无限制</th>
	  <th>是否组织专业考试</th>
	  <th>面试人选与计划录用人数的确定比例</th>
	  <th>其他条件</th>
	  <th>备注</th>
	  <th>职位分布</th>
	  <th style="display:none;">部门网站</th>
	  <th style="display:none;">咨询电话1</th>
	  <th style="display:none;">咨询电话2</th>
	  <th style="display:none;">咨询电话3</th> 
	  </tr> 
	 
	</table>
		<div>
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
		    <li><a>共有:<em>13478</em> 条</a></li>
		  </ul>
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
    				 
    				 tab.append("<tr onDblClick  = \"getCutInfo(this)\" ><td>"+(i+1)
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
													+"</td><td style=\"display:none;\">"+data[i].website
													+"</td><td style=\"display:none;\">"+data[i].telephone1
													+"</td><td style=\"display:none;\">"+data[i].telephone2
													+"</td><td style=\"display:none;\">"+data[i].telephone3
												+"</td></tr>");
 				
    			 }
    			 
    			}, 'json'
    			
    		); 
    	});
    	
    	
    	function getCutInfo(_this_){
    	
    		var cur = _this_;
    		
    		var tds = $(cur).children();
    		
    		var td_content = [];
    		
    		for(var i=0;i<tds.length;i++){
    			
    		 td_content.push($(tds[i]).html());
    		}
    		
    		
    		alert(td_content);
    	}
    </script>
</body>
</html>