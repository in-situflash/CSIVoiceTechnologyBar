<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String path = request.getContextPath();String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html>
	<head style="height: auto;">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title  >>修改用户</title>
		<link rel="stylesheet" href="static/css/default/bootstrap/bootstrap.css">
		<link rel="stylesheet" href="static/comp/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="static/comp/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="static/comp/adminlte/css/adminlte.css">
		<link rel="stylesheet" href="static/css/default/mask.css" />
		
	</head>
	<body>
		<div id="POST_ADD_DIV_ID" class="card card-info" >
	    	<div class="card-header">
	             <h3 class="card-title">修改用户</h3>
	        </div> 
	        <input type="hidden" id="userUUID" name="userUUID" value="">
	        <div class="form-horizontal">
	        	 <input type="hidden" value="" id=oldUserName>				
	             <div class="card-body">
	             	
	             	<form action="${pageContext.request.contextPath}/usermanage/updateUser" method="post">
			             <div class="form-group" >
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">用户名：</label>
			              	 <div class="col-sm-10" >
			                 	<input value="${Quser.username}" readonly="readonly" name="username" id="username" class="form-control" style="width:900px"  >
			                 	
			                 </div>
			             </div>
			            
			         	
						
						 <div class="form-group">
				        	<label for="JI_JOB_NAME" class="col-sm-2 control-label">密码：</label>
				        	<div class="col-sm-10" >
				        		<input id="password" name="password" value="${Quser.password}"  class="form-control" style="width:900px"  type="password" minlength="6"   required="required">
				        	</div>
				         </div>

					        <div class="form-group">
					        	<label for="JI_JOB_NAME" class="col-sm-2 control-label">性别：</label>
					        	<div class="col-sm-10" >
				
					        		<select id="gender" name="gender" class="form-control" style="width:900px" >
									  <option value="${Quser.gender}">${Quser.gender}</option>
									  <option value ="男">男</option>
									  <option value ="女">女</option>
									</select>
					        	</div>
					        </div>
					        <div class="form-group">
					        	<label for="JI_JOB_NAME" class="col-sm-2 control-label">年龄：</label>
					        	<div class="col-sm-10" >
					        		<select id="age" name="age" class="form-control" style="width:900px" >
									 <option value="${Quser.age}">${Quser.age}</option>
									 <option value ="11">11</option>
									 <option value ="12">12</option>
									 <option value ="13">13</option>
									 <option value ="14">14</option>
									 <option value ="15">15</option>
									 <option value ="16">16</option>
									 <option value ="17">17</option>
									 <option value ="18">18</option>
									 <option value ="19">19</option>
									 <option value ="21">21</option>
									 <option value ="22">22</option>
									 <option value ="23">23</option>
									 <option value ="24">24</option>
									 <option value ="25">25</option>
									</select>
					        	</div>
					        </div>
					         <div class="form-group">
					        	<label for="JI_JOB_NAME" class="col-sm-2 control-label">邮箱：</label>
					        	<div class="col-sm-10" >
					        		<input id="email" name="email" value="${Quser.email}" class="form-control" style="width:900px" type="text"   required="required">
					        	</div>
					        </div>
					        
					        <div class="form-group">
					        	<label for="JI_JOB_NAME" class="col-sm-2 control-label">权限：</label>
					        	<div class="col-sm-10" >
					        		<select id="privilege" name="privilege" class="form-control" style="width:900px" >
									 	
									 	<option value="${Quser.privilege}">${Quser.privilege}</option>
									 	<option value ="普通用户">普通用户</option>
									  	<option value ="管理员">管理员</option>
									</select>
					        	</div>
					        </div>
					        <div class="form-group" >
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">用户ID：</label>
			              	 <div class="col-sm-10" >
			                 	<input value="${Quser.userid}" type="text" name="userid" id="userid" class="form-control" style="width:900px"  maxlength="16" required="required">
			                 </div>
			             </div>
					        <div class="form-group ">
					        	<input  type="submit" class="btn btn-info  col-md-1 col-md-offset-4" value="修改" >
					        	<input  type="reset" class="btn btn-default  col-md-1 col-md-offset-1" value="重置">
					        </div>
					    </form>
			             <!-- /.card-body -->
			             <!--<div class="card-footer col-md-3 col-md-offset-4" style="width:100%"align="center">
			               <button type="button" class="btn btn-info" onclick="editUserCheck()">添加用户</button>
			               <button type="button" class="btn btn-default" onclick="returnPostList()">返回</button>
			             </div>
			             <div class="card-footer col-md-3 col-md-offset-4" id="tishi" style="text-align: center;color: red;font-size: 15px">
											     
						</div>-->
			             <!-- /.card-footer -->
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
	</body>
</html>
