<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>列表</title>
		<link href="template/default/style.css" rel="stylesheet"
			type="text/css">
		<link href="template/green/style.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="jquery/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/ymPrompt.js"></script>
		<link href="js/skin/dmm-green/ymPrompt.css" rel="stylesheet"
			type="text/css">
		<script type="text/javascript">
		function showFilemx(fileName,drtime){
			$("#dr_time").val(drtime);
			$("#fileName").val(fileName);
			$("#chakan").click();
		}
		function importEmp(){
		   //检验导入的文件是否为Excel文件  
		   var excelPath = document.getElementById("upload").value;  
		   if(excelPath == null || excelPath == ''){  
		       alert("请选择要上传的Excel文件");  
		       return false;  
		   }else{  
		       var fileExtend = excelPath.substring(excelPath.lastIndexOf('.')).toLowerCase();   
		       if(fileExtend == '.xls'||fileExtend == '.xlsx'){  
		       }else{  
		           alert("文件格式需为'.xls'格式");  
		           return false;  
		       }  
		   }  
		   return true;
		} 
		</script>
	</head>
	<body>
		<div id="header">
			<div class="headerwarp">
				<ul class="menu">
					<li>
						<a>XXXX系统</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="wrap">
			<div id="main">
				<div id="append_parent"></div>
				<div id="app_sidebar">
					<div class="bar_text">
						<p class="title">
							功能列表
						</p>
						<p>
							<a href="excelAction!init.action">导入</a>
						</p>
						<p>
							<a href="excelAction!list.action">详细信息</a>
						</p>
					</div>
				</div>
				<div id="mainarea">
					<h2 class="title">
						<a href="tag.html">导入功能 </a> - 文件导入
					</h2>

					<div class="tag_container">
						<div class="kemuleft2">
							<span style="font-weight: bold;"> 以文件上传的方式导入excel文件。 </span>
						</div>
						<form action="excelAction!drExcel.action"
							enctype="multipart/form-data" method="post">
							<input id="upload" type="file" name="upload">
							<input type="submit" value="上传" onclick="return importEmp();">
						</form>
					</div>
				</div>
				<div id="bottom"></div>
			</div>
		</div>
	</body>
</html>