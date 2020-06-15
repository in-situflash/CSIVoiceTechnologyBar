<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">

<!DOCTYPE html>
<html style="height: auto;">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>所有文章</title>

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
							<h3 class="card-title">查询条件</h3>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-md-11">
									<div class="form-inline">
										<div class="form-group col-md-4">
											<label for="SEARCH_ORG_NAME" class="col-md-4">文章标题：</label>
											<div class="col-md-8">
												<input type="hidden" id="SEARCH_POST_NAME_HIDDEN" name="SEARCH_POST_NAME_HIDDEN" value="">
												<input type="text" id="SEARCH_POST_NAME" name="SEARCH_POST_NAME" size="45" value="" class="form-control"  placeholder="请输入文章标题">
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-1">
									<button class="btn btn-block btn-info" onclick="searchByPostName()">查询</button>
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
							<h3  class="card-title col-md-3" >当前：<span id="LABLE_FATHER_ORG_NAME">所有文章</span></h3>
							<div class="col-md-2 col-md-offset-7" id="postAddAndDeleteDiv"><button class="btn  btn-success btn-sm" type="button" onclick="ADD_POST()">新增</button>&nbsp;&nbsp;
							<button class="btn  btn-danger btn-sm" type="button" onclick="DELETE_POST('${title}','${privilege}')">删除</button></div>
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
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1"></th>	
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">阅读人数</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">评论人数</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">文章标题</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">文章作者</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">发表日期</th>
													<th style="text-align:center;" class="sorting" rowspan="1" colspan="1">最后评论</th>
												</tr>
											</thead>
											<tbody id="POST_LIST_TBODY_ID">
											<tr bgcolor="#FFFFFF">
											<c:forEach var="article" items="${allarticle}">
											<td align="center" width="%6"><input name="DELETE_CHECK_NAME" type="checkbox" value="${article.a_id}"></td>
											<td valign="center" align="center" width="%7">${article.a_likes}</td>
											<td valign="center" align="center" width="%7">${article.a_comments}</td>
											<td valign="center" align="center" width="%20"><a href="" onclick="post_detailed('0c5bad26938041459423277878dbafbe'); return false;">${article.title}</a></td>
											<td valign="center" align="center" width="%20">${article.username}</td>
											<td valign="center" align="center" width="%20">${article.a_createtime}</td>
											<td valign="center" align="center" width="%20">${article.a_lastcomment}</td>
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
											<ul class="pagination" id="PAGE_ID">
											<li style="margin-left: 30px">		
											<button class="btn btn-primary" type="button" onclick="GOTO_POST_HOME_PAGE(${SELECT_TYPE},'${title}')">首页</button>
											</li>
											<li style="margin-left: 30px">		
											<button class="btn btn-primary" type="button" onclick="GOTO_POST_PREVIOUS_PAGE(${page},${SELECT_TYPE},'${title}')">前一页</button>
											</li>
											<li style="margin-left: 30px">		
											<button class="btn btn-primary" type="button" onclick="GOTO_POST_NEXT_PAGE(${page},${maxpage},${SELECT_TYPE},'${title}')">后一页</button>
											</li>
											<li style="margin-left: 30px">		
											<button class="btn btn-primary" type="button" onclick="GOTO_POST_TAIL_PAGE(${maxpage},${SELECT_TYPE},'${title}')">末页</button>
											</li>
											<li style="margin-left: 30px">		
											<input id="JUMP_INPUT_ID" type="text" style="display:inline;width:80px" size="6">		
											<button class="btn btn-sm btn-outline-primary" onclick="GOTO_POST_PAGE(${maxpage},${SELECT_TYPE},'${title}');return false;">跳转</button>
											</li>
											<li style="margin-left: 30px">		
											<div class="dataTables_info" style="margin-top: 6px;margin-left: 100px">
											<span>${page}/${maxpage}页</span> 
											<span>共${alldata}条</span>
											</div>
											</li>
											</ul>
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
		
		
		
		<!--<div id="ORG_ADD_DIV_ID" class="card card-info" style="display:none">  -->
		<div id="POST_ADD_DIV_ID" class="card card-info" style="display:none">
	    	<div class="card-header">
	             <h3 class="card-title">文章编辑</h3>
	        </div> 
	        <div class="form-horizontal">
	        							
	             <div class="card-body">
			             <div class="form-group" >
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">文章标题：</label>
			              	 <div class="col-sm-10" style="display:inline">
			                 	<input value="" type="text" name="POST_ADD_TITLE" id="POST_ADD_TITLE" class="form-control" style="width:900px"  maxlength="16">
			                 	
			                 </div>
			                 
			            </div>
			            
			            <div class="form-group" >
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">文章内容：</label>
			              	 <div class="col-sm-10" >
			                 	<textarea  name="POST_ADD_DES" id="POST_ADD_DES" class="form-control" style="height:100px;"> </textarea>
			                 </div>
			            </div>
			             <!-- /.card-body -->
			             <div class="card-footer col-md-3 col-md-offset-4" style="width:100%"align="center">
			               <button type="button" class="btn btn-info" onclick="addPostCheck(${lastid})">提交</button>
			               <button type="button" class="btn btn-default" onclick="returnPostList()">返回</button>
			             </div>
			             <!-- /.card-footer -->
			             <div class="card-footer col-md-3 col-md-offset-4" id="tishi" style="text-align: center;color: red;font-size: 15px">
							     
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
		<script src="chinasofti/post/js/post.js"></script>
		<script type="text/javascript" src="static/js/alert.js"></script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body></html>