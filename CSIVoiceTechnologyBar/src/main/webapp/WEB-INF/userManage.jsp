<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html style="height: auto;">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>用户管理</title>

		<link rel="stylesheet" href="static/css/default/bootstrap/bootstrap.css">
		<link rel="stylesheet" href="static/comp/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="static/comp/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="static/comp/adminlte/css/adminlte.css">
		<link rel="stylesheet" href="static/css/default/mask.css" />
	</head>

	<body style="height: auto;">
		
		
		<!--  <div class="container-fluid" id="ORG_LIST_DIV_ID">-->
		<div class="container-fluid" id="POST_LIST_DIV_ID">
			<div class="row">
				<div class="col-md-12" style="">
					<div class="card card-info">
						<div class="card-header">
							<!-- <h3 class="card-title">查询条件</h3> -->
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-md-11">
									<div class="form-inline">
										<div class="form-group col-md-4">
											<!-- <label for="SEARCH_ORG_NAME" class="col-md-4">用户名：</label> -->
											<div class="col-md-8">
												<input type="hidden" id="SEARCH_POST_NAME_HIDDEN" name="SEARCH_POST_NAME_HIDDEN" value="">
												
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-1">
									<!-- <button class="btn btn-block btn-info" onclick="searchByPostName()">查询</button> -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header" style="width:100%">
							<h3  class="card-title col-md-3" >当前：<span id="LABLE_FATHER_ORG_NAME">用户管理</span></h3>
							<div class="card-title col-md-5">
								<!--toAddUser-->
								<a class="btn btn-primary col-md-offset-7" href="${pageContext.request.contextPath}/usermanage/toAddUser">添加用户</a>
							</div>
							
						</div>
						<div class="card-body">
							<div id="example2_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
								<div class="row">
									<div class="col-sm-12 col-md-6"></div>
									<div class="col-sm-12 col-md-6"></div>
								</div>
								
								<div class="row">
									<div class="col-sm-12">
										<table id="example2" class="table table-bordered table-hover dataTable" role="grid">
											<thead>
												<tr role="row">
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">操作</th>	
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">用户名</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">年龄</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">性别</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">注册时间</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">最后登录时间</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">权限</th>
												</tr>
											</thead>
											<tbody id="POST_LIST_TBODY_ID">
												<c:forEach var="user" items="${list}">
													<tr bgcolor="#FFFFFF">		
														<td align="center" width="20">			<div class="col-md-2 col-md-offset-0" ><a class="btn  btn-danger btn-sm"  href="${pageContext.request.contextPath}/usermanage/deleteUser/${user.userid}">删除</a></div>	</td>			
														<td  align="center" width="30">			<a href="${pageContext.request.contextPath}/usermanage//toUpdateUser?userid=${user.userid}">${user.username}</a> 		</td>		
														<td align="center" width="30">${user.age}		</td>		
														<td  align="center" width="110">${user.gender}		</td>		
														<td align="center" width="110"><fmt:formatDate value="${user.create_time}" pattern="yyyy-MM-dd HH:mm:ss" />		</td>		
														<td  align="center" width="100">2020-06-12 23:08:18		</td>		
														<td  align="center" width="100">${user.privilege}		</td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot></tfoot>
										</table>
									</div>
								</div>
								
								<div class="row">
									<div class="col-sm-12 col-md-9 col-md-offset-3">
										<div class="dataTables_paginate paging_simple_numbers">
											<ul class="pagination" id="PAGE_ID"><li style="margin-left: 30px">		<button class="btn btn-primary" type="button" onclick="GOTO_POST_HOME_PAGE('0')">首页</button></li><li style="margin-left: 30px">		<button class="btn btn-primary" type="button" onclick="GOTO_POST_PREVIOUS_PAGE('0')">前一页</button></li><li style="margin-left: 30px">		<button class="btn btn-primary" type="button" onclick="GOTO_POST_NEXT_PAGE('2')">后一页</button></li><li style="margin-left: 30px">		<button class="btn btn-primary" type="button" onclick="GOTO_POST_TAIL_PAGE('2')">末页</button></li><li style="margin-left: 30px">		<input id="JUMP_INPUT_ID" type="text" style="display:inline;width:80px" size="6">		<button class="btn btn-sm btn-outline-primary" onclick="GOTO_POST_PAGE();return false;">跳转</button></li><li style="margin-left: 30px">		<div class="dataTables_info" style="margin-top: 6px;margin-left: 100px"><span>1/1 页</span> <span>共${column} 条</span></div></li></ul>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
						
					</div>

				</div>

			</div>

		</div>
		

		
		
		
		<script src="static/comp/jquery/dist/jquery.js"></script>
		<script src="static/comp/jQuery-Storage-API/jquery.storageapi.js"></script>
		<script src="static/comp/jquery.form/jquery.form.min.js"></script>
		<script src="static/comp/jquery/plugins/scrollbar/perfect-scrollbar.jquery.min.js"></script>
		
		<script src="static/kindeditor/kindeditor-all.js" type="text/javascript"></script> 
		<script src="static/kindeditor/kindeditor-all-min.js" type="text/javascript"></script>
		<script src="static/kindeditor/lang/zh-CN.js" type="text/javascript"></script>
		<script src="static/js/common/mask.js"></script>
		<script src="chinasofti/userManage/js/userManage.js"></script>
		<script type="text/javascript" src="static/js/alert.js"></script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body></html>