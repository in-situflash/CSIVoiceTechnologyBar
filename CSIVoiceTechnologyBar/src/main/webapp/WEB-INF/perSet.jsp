<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html style="height: auto;">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>所有文章</title>

<link rel="stylesheet" href="static/css/default/bootstrap/bootstrap.css">
<link rel="stylesheet"
	href="static/comp/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="static/comp/ionicons/css/ionicons.min.css">
<link rel="stylesheet" href="static/comp/adminlte/css/adminlte.css">
<link rel="stylesheet" href="static/css/default/mask.css" />
</head>

<body style="height: auto;">






	<!--<div id="ORG_ADD_DIV_ID" class="card card-info" style="display:none">  -->
	<!-- <div id="POST_ADD_DIV_ID" class="card card-info">
		<div class="card-header">
			<h3 class="card-title">个人设置</h3>
		</div>
		<input id="oldUserName" type="hidden" value=""> <input
			id="regUUID" type="hidden" value="" />
		<div class="form-horizontal">
			<form name="PerForm" action="/chinasofti/perSet/js/perSet.js" onsubmit="return subReg()" method="post">
				<div class="card-body">
					<div class="form-group">
						<label for="JI_JOB_NAME" class="col-sm-2 control-label">用户名：</label>
						<div class="col-sm-10">
							<input value="" type="text" name="userName" id="userName"
								class="form-control" style="width: 900px" maxlength="16">
						</div>
					</div>
					<div class="form-group">
						<label for="JI_JOB_NAME" class="col-sm-2 control-label">性别：</label>
						<div class="col-sm-10">
							<select id="regSex" name="regSex"
								class="form-control highlight_green l35" style="width: 900px">
								<option value="0">男</option>
								<option value="1">女</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="JI_JOB_NAME" class="col-sm-2 control-label">年龄：</label>
						<div class="col-sm-10">

							<select id="regAge" name="regAge"
								class="form-control highlight_green l35" style="width: 900px">

							</select>

						</div>
					</div>
					<div class="form-group">
						<label for="JI_JOB_NAME" class="col-sm-2 control-label">邮箱：</label>
						<div class="col-sm-10">
							<input value="" type="text" name="regEmial" id="regEmial"
								class="form-control" style="width: 900px" maxlength="16">
						</div>
					</div>
					/.card-body
					<div class="card-footer col-md-3 col-md-offset-4"
						style="width: 100%" align="center">
						<button type="button" class="btn btn-info" onclick="subReg()">提交</button>
					</div>
					<div class="card-footer col-md-3 col-md-offset-4" id="tishi"
						style="text-align: center; color: red; font-size: 15px"></div>
					/.card-footer
				</div>
		</div>
		</form>
	</div> -->
	<div>
		<h1>个人设置</h1>
			<form action="perSetPost" method="post" enctype="multipart/form-data">
				<!-- 用户名：<input type="text" name="username" id="username" value="" placeholder ="更改用户名"/>
				<br/> -->
				性别：<select id="regSex" name="regSex">
					<option value="0">男</option>
					<option value="1">女</option></select>
				<!-- 性别：<input type="number" name="userag" id="userage" value="" placeholder ="更改用户年龄"/> -->
				<br/>
				年龄：<input type="number" name="userage" id="userage" value="" placeholder ="更改用户年龄"/>
				<br/>
				邮箱：<input type="text" name="userEmail" id="userEmail" value="" placeholder ="更改邮箱"/>
				<br/>
				<h2>请上传个人头像</h2>
				<br/>
				<input type="file" name="file"/>
				<input type="submit" value="提交"/>
				
					
				
			</form>
	</div>





	<script src="static/comp/jquery/dist/jquery.js"></script>
	<script src="static/comp/jQuery-Storage-API/jquery.storageapi.js"></script>
	<script src="static/comp/jquery.form/jquery.form.min.js"></script>
	<script
		src="static/comp/jquery/plugins/scrollbar/perfect-scrollbar.jquery.min.js"></script>

	<script src="static/kindeditor/kindeditor-all.js"
		type="text/javascript"></script>
	<script src="static/kindeditor/kindeditor-all-min.js"
		type="text/javascript"></script>
	<script src="static/kindeditor/lang/zh-CN.js" type="text/javascript"></script>
	<script src="static/js/common/mask.js"></script>
	<!-- 将该jsp与perSet.js文件关联 -->
	<script src="chinasofti/perSet/js/perSet.js"></script>
	<script type="text/javascript" src="static/js/alert.js"></script>

	<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body>
</html>