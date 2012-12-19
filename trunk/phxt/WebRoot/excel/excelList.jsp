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
		$(document).ready(function(){
			$("input[type='checkbox']").bind("click",function(){
			if($(this).attr("id")=="selectAllID"){
				if($(this).attr("checked")){
					$("input[type='checkbox']").each(function(){
						$(this).attr("checked","true");
					});
				}else{
					$("input[type='checkbox']").each(function(){
						$(this).removeAttr("checked");
					});
				}
			}
			});
		});
		function showFilemx(fileName,drtime){
			$("#dr_time").val(drtime);
			$("#fileName").val(fileName);
			$("#chakan").click();
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
		<form action="excelAction!list.action" method="post">
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
							<a href="tag.html">导入功能 </a> - 明细展示
						</h2>

						<div class="tag_container">
							<div class="kemuleft2">
								<span style="font-weight: bold;">
									导入列表展示们，提供导出excel，明细展示，批量删除等功能。 </span>
							</div>
							<div class="clear"></div>
							<div class="kemutotal">
								<div class="kemumid">
									<s:iterator value="fileTjjgList">
										<a class="midlist" href="#"
											onclick="showFilemx('<s:property value="fileName" />','<s:property value="dr_time" />')">文件名：<s:property
												value="fileName" />||导入时间：<s:property value="dr_time" /> </a>
									</s:iterator>
								</div>
							</div>
						</div>
						请选择查看的记录:学校名称:
						<input type="text" name="bean.name"
							value="<s:property value="bean.name" />">
						<input type="hidden" name="event" id="event" />
						<input type="hidden" name="bean.fileName" id="fileName" />
						<input type="hidden" name="bean.dr_time" id="dr_time" />
						<input type="submit" value="查看所有" id="chakan"
							onclick="document.getElementById('event').value='list'"
							class="submit" style="height: 20px; padding: 0 12px;" />
						<input type="submit" value="删除"
							onclick="document.getElementById('event').value='delete'"
							class="button" style="height: 20px; padding: 0 12px;" />
						<input type="submit" value="导出选中数据"
							onclick="document.getElementById('event').value='exportExcel'"
							class="button" style="height: 20px; padding: 0 12px;" />
						<input type="submit" value="导出全部数据"
							onclick="document.getElementById('event').value='exportExcelAll'"
							class="button" style="height: 20px; padding: 0 12px;" />
						<div id="taghospital_list">
							<div class="doctorname">
								对以下列表统计的结果为：
								<s:property value="jg" />
							</div>
							<table class="doctor_rowtd">
								<tr id="header_tr">
									<td style="width: 5%; text-align: center;">
										<input type="checkbox" id="selectAllID">
									</td>
									<td style="width: 49%; text-align: center;">
										学校名称
									</td>
									<td style="width: 10%; text-align: center;">
										金额
									</td>
									<td style="width: 12%; text-align: center;">
										100元发票数量
									</td>
									<td style="width: 12%; text-align: center;">
										50元发票数量
									</td>
									<td style="width: 12%; text-align: center;">
										20元发票数量
									</td>
								</tr>
								<s:iterator value="fjjgList">
									<tr class="twon">
										<td style="text-align: center;">
											<input type="checkbox" name="fjjgList.id"
												value="<s:property value="id" />" />
										</td>
										<td style="text-align: center;">
											<s:property value="name" />
										</td>
										<td style="text-align: center;">
											<s:property value="je" />
										</td>
										<td style="text-align: center;">
											<s:property value="pmje100" />
										</td>
										<td style="text-align: center;">
											<s:property value="pmje50" />
										</td>
										<td style="text-align: center;">
											<s:property value="pmje20" />
										</td>
									</tr>
								</s:iterator>
							</table>
							<!-- 
							<div class="page">
								<em>&nbsp;20&nbsp;</em><a href="#"
									class="prev">&lsaquo;&lsaquo;</a><a
									href="#">1</a><strong>2</strong>
							</div> -->
						</div>
					</div>
					<div id="bottom"></div>
				</div>
			</div>
		</form>
	</body>
</html>