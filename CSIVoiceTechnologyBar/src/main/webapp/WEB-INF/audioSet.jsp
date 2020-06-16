<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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
		
		
		
		
		
		
		<!-- <div id="ORG_ADD_DIV_ID" class="card card-info" style="display:none">
		<div id="POST_ADD_DIV_ID" class="card card-info">
	    	<div class="card-header">
	             <h3 class="card-title">语音设置</h3>
	        </div> 
	        <input id="auSetUUID" type="hidden" value=""/>
	        <div class="form-horizontal">
				<div class="card-body">
			             <div class="form-group" >
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">发声人：</label>
			              	 <div class="col-sm-10" >
			                 	<select id="auSetVoiPer" name="auSetVoiPer" class="form-control highlight_green l35" >
									  <option value ="0">普通女声</option>
									  <option value ="1">普通男声</option>
									  <option value ="3">度逍遥（武侠）</option>
									  <option value ="4">度丫丫（软萌）</option>
								</select>
			                 </div>
			            </div>
			            <div class="form-group" >
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">语速：</label>
			              	 <div class="col-sm-10" >
			                 	<select id="auSetSpd" name="auSetSpd" class="form-control highlight_green l35" >
									  <option value ="0">0</option>
									  <option value ="1">1</option>
									  <option value ="2">2</option>
									  <option value ="3">3</option>
									  <option value ="4">4</option>
									  <option value ="5">5</option>
									  <option value ="6">6</option>
									  <option value ="7">7</option>
									  <option value ="8">8</option>
									  <option value ="9">9</option>
								</select>
			                 </div>
			            </div>
			           <div class="form-group" >
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">音调：</label>
			              	 <div class="col-sm-10" >
			                 	<select id="auSetPit" name="auSetPit" class="form-control highlight_green l35" >
									  <option value ="0">0</option>
									  <option value ="1">1</option>
									  <option value ="2">2</option>
									  <option value ="3">3</option>
									  <option value ="4">4</option>
									  <option value ="5">5</option>
									  <option value ="6">6</option>
									  <option value ="7">7</option>
									  <option value ="8">8</option>
									  <option value ="9">9</option>
								</select>
			                 </div>
			            </div>
			            <div class="form-group" >
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">音量：</label>
			              	 <div class="col-sm-10" >
			                 	<select id="auSetVol" name="auSetVol" class="form-control highlight_green l35" >
									  <option value ="0">0</option>
									  <option value ="1">1</option>
									  <option value ="2">2</option>
									  <option value ="3">3</option>
									  <option value ="4">4</option>
									  <option value ="5">5</option>
									  <option value ="6">6</option>
									  <option value ="7">7</option>
									  <option value ="8">8</option>
									  <option value ="9">9</option>
									  <option value ="10">10</option>
									  <option value ="11">11</option>
									  <option value ="12">12</option>
									  <option value ="13">13</option>
									  <option value ="14">14</option>
									  <option value ="15">15</option>
								</select>
			                 </div>
			            </div>
			            <div class="form-group" >
			            	<label for="JI_JOB_NAME" class="col-sm-2 control-label" ></label>
			             	<div class="col-sm-10" style="color:red;">注：此配置更改后，只在您本人之后发表的文章及评论中生效。对于已经存在或其他用户的文章评论不生效。</div>
			             </div>
	             </div>
	             
	             /.card-body
	             <div class="card-footer col-md-3 col-md-offset-4" style="width:100%"align="center">
	               <button type="button" class="btn btn-info" onclick="updateAudioSetUp()">提交</button>
	             </div>
	             /.card-footer
	        </div>
	    </div>
		 -->
		 
	<div>
		<h1>语音设置</h1>
			<form action="audioSetPost" method="post" enctype="multipart/form-data">
				<!-- 用户名：<input type="text" name="username" id="username" value="" placeholder ="更改用户名"/>
				<br/> -->
				
				发声人：<select id="auSetVoiPer" name="auSetVoiPer" class="form-control highlight_green l35" >
									  <option value ="0">普通女声</option>
									  <option value ="1">普通男声</option>
									  <option value ="2">度逍遥（武侠）</option>
									  <option value ="3">度丫丫（软萌）</option>
				       </select>
				<!-- 性别：<input type="number" name="userag" id="userage" value="" placeholder ="更改用户年龄"/> -->
				<br/>
				语速：<select id="auSetSpd" name="auSetSpd" class="form-control highlight_green l35" >
									  <option value ="0">0</option>
									  <option value ="1">1</option>
									  <option value ="2">2</option>
									  <option value ="3">3</option>
									  <option value ="4">4</option>
									  <option value ="5">5</option>
									  <option value ="6">6</option>
									  <option value ="7">7</option>
									  <option value ="8">8</option>
									  <option value ="9">9</option>
					</select>
				<br/>
				音调：<select id="auSetPit" name="auSetPit" class="form-control highlight_green l35" >
									  <option value ="0">0</option>
									  <option value ="1">1</option>
									  <option value ="2">2</option>
									  <option value ="3">3</option>
									  <option value ="4">4</option>
									  <option value ="5">5</option>
									  <option value ="6">6</option>
									  <option value ="7">7</option>
									  <option value ="8">8</option>
									  <option value ="9">9</option>
								</select>
				<br/>
				音量：<select id="auSetVol" name="auSetVol" class="form-control highlight_green l35" >
									  <option value ="0">0</option>
									  <option value ="1">1</option>
									  <option value ="2">2</option>
									  <option value ="3">3</option>
									  <option value ="4">4</option>
									  <option value ="5">5</option>
									  <option value ="6">6</option>
									  <option value ="7">7</option>
									  <option value ="8">8</option>
									  <option value ="9">9</option>
									  <option value ="10">10</option>
									  <option value ="11">11</option>
									  <option value ="12">12</option>
									  <option value ="13">13</option>
									  <option value ="14">14</option>
									  <option value ="15">15</option>
								</select>
				<br/>
				<input type="submit" value="提交"/>
				
					
				
			</form>
	</div>
		
		
		
		
		<script src="static/comp/jquery/dist/jquery.js"></script>
		<script src="static/comp/jQuery-Storage-API/jquery.storageapi.js"></script>
		<script src="static/comp/jquery.form/jquery.form.min.js"></script>
		<script src="static/comp/jquery/plugins/scrollbar/perfect-scrollbar.jquery.min.js"></script>
		
		<script src="static/kindeditor/kindeditor-all.js" type="text/javascript"></script> 
		<script src="static/kindeditor/kindeditor-all-min.js" type="text/javascript"></script>
		<script src="static/kindeditor/lang/zh-CN.js" type="text/javascript"></script>
		<script src="static/js/common/mask.js"></script>
		<script src="chinasofti/audioSet/js/audioSet.js"></script>
		<script type="text/javascript" src="static/js/alert.js"></script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body></html>