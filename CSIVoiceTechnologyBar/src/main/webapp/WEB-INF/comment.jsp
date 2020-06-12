<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="height: auto;">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>comment</title>

<link rel="stylesheet"
	href="/new_ssm/static/css/default/bootstrap/bootstrap.css">
<link rel="stylesheet"
	href="/new_ssm/static/comp/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/new_ssm/static/comp/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="/new_ssm/static/comp/adminlte/css/adminlte.css">
<link rel="stylesheet" href="/new_ssm/static/css/default/mask.css" />
</head>

<body style="height: auto;">


	<!--  <div class="container-fluid" id="ORG_LIST_DIV_ID">-->
	<div class="container-fluid" id="COM_LIST_DIV_ID">
		<div class="row">
			<div class="col-md-12" style="">
				<div class="card card-info">
					<div class="card-header">
						<h3 class="card-title">文章 </h3>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-11">
								<div class="form-inline col-md-11" style="width: 100%">
									<div class="form-group " style="width: 100%">
										<div id="postPhoto">
											<img src="/new_ssm/headPhoto/default/default.jpg"
												style="whith: 80px; height: 80px">
										</div>
										&nbsp;&nbsp;
										<div id="postInfo">
											<table>
												<tbody>
													<tr>
														<td>主题：${articleDetail.title}</td>
													</tr>
													<tr>
														<td>发帖人：${articleDetail.username}</td>
													</tr>
													<tr>
														<td>发帖人注册时间：${articleDetail.create_time}</td>
													</tr>
													<tr>
														<td id="a_createtime">发帖时间：${articleDetail.a_createtime}</td>
													</tr>
												</tbody>
											</table>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div id="postText">
						<span>${articleDetail.essay}</span>
					</div>
						<div id="postAtt">
							|&nbsp;<a id="praisecNum" href="javascript:void(0);" class="a_likes" >赞：${articleDetail.a_likes}</a>
							<input value="${articleDetail.a_id}" hidden="true"></input>
						</div>
					</div>

			</div>
 
		</div>
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-header" style="width: 100%">
						<h3 class="card-title col-md-3">
							<span id="LABLE_FATHER_ORG_NAME">当前：所有文章->评论</span>
						</h3>
						<div class="col-md-2 col-md-offset-7" id="comAddAndDeleteDiv">
							<button class="btn  btn-success btn-sm" type="button"
								onclick="ADD_COM()">评论</button>
							<button class="btn btn-default btn-sm" type="button"
								onclick="returnPostList()">返回</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<c:forEach items="${comments}" var="item" varStatus="status"> 
		<div class="row">
			<div class="col-12">
				<div class="card">

					<div class="card-body">
						<div id="example2_wrapper"
							class="dataTables_wrapper container-fluid dt-bootstrap4">
							<div class="card-header" style="background-color: #17a2b8">
								<h3 class="card-title">热门评论</h3>
							</div>
							<div class="row">
								<div class="form-inline col-sm-12">
									<div>
										<img src="/new_ssm/headPhoto/default/default.jpg"
											style="whith: 80px; height: 80px">
									</div>
									<div>
										<table>
											<tbody>
												<tr>
													<td>评论人：${item.username }</td>
												</tr>
												<tr>
													<td>评论人注册时间：</td>
												</tr>
												<tr>
													<td id="c_createtime${status.count}"></td>
												</tr>
												<tr>
													<td>删除选中：<input name="DELETE_CHECK_NAME"
														type="checkbox" value="c9c8ee13e83149379d56d34ea7913d69"></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="col-sm-12">
									<span>${item.content }</span>
								</div>
								<div style="width:86%;"> 
									<div style="float:left">
										<div class="col-sm-12" id="commentVoice${status.count}" >
											&nbsp;|&nbsp;
											<a id="praisecNum" class="c_likes"  href="javascript:void(0);" onclick="hotsPraiseClick('46dc37890bbc49629384024d2f17beda','c9c8ee13e83149379d56d34ea7913d69')">赞：${item.c_likes}</a>
											<input value="${item.c_id}" hidden="true"></input>
										</div>
									</div>
									<div style="float:right" id="comAddAndDeleteDiv">
										<button value="${item.c_id}" class="btn  btn-danger btn-sm DELETE_COM" type="button" >删除</button>
									</div>   
								</div>
							</div>
							<hr>
						</div>
					</div>
					<!-- /.card-body -->
				</div>

			</div>

		</div>
		</c:forEach>
		
	</div>



	<!--<div id="ORG_ADD_DIV_ID" class="card card-info" style="display:none">  -->
	<div id="COM_ADD_DIV_ID" class="card card-info" style="display: none">
		<div class="card-header">
			<h3 class="card-title">评论编辑</h3>
		</div>
		<div class="form-horizontal">

			<div class="card-body">


				<div class="form-group">
					<label for="JI_JOB_NAME" class="col-sm-2 control-label">评论：</label>
					<div class="col-sm-10">
						<textarea name="POST_ADD_DES" id="COM_ADD_DES"
							class="form-control" style="height: 100px;"> </textarea>
					</div>
				</div>
				<!-- /.card-body -->
				<div class="card-footer col-md-3 col-md-offset-4"
					style="width: 100%" align="center">
					<button type="button" class="btn btn-info" onclick="addComCheck()">提交</button>
					<button type="button" class="btn btn-default"
						onclick="returnComList()">返回</button>
				</div>
				<div class="card-footer col-md-3 col-md-offset-4" id="tishi"
					style="text-align: center; color: red; font-size: 15px"></div>
				<!-- /.card-footer -->
			</div>

		</div>
	</div>





	<script src="/new_ssm/static/comp/jquery/dist/jquery.js"></script>
	<script
		src="/new_ssm/static/comp/jQuery-Storage-API/jquery.storageapi.js"></script>
	<script src="/new_ssm/static/comp/jquery.form/jquery.form.min.js"></script>
	<script
		src="/new_ssm/static/comp/jquery/plugins/scrollbar/perfect-scrollbar.jquery.min.js"></script>

	<script src="/new_ssm/static/kindeditor/kindeditor-all.js"
		type="text/javascript"></script>
	<script src="/new_ssm/static/kindeditor/kindeditor-all-min.js"
		type="text/javascript"></script>
	<script src="/new_ssm/static/kindeditor/lang/zh-CN.js"
		type="text/javascript"></script>
	<script src="/new_ssm/static/js/common/mask.js"></script>
	<script src="/new_ssm/chinasofti/comment/js/comment.js"></script>
	<script type="text/javascript" src="/new_ssm/static/js/alert.js"></script>

	<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->

	<script type="text/javascript">
		function GMTToStr(time) {
			let date = new Date(time);
			let Str = date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
					+ date.getDate() + ' ' + date.getHours() + ':'
					+ date.getMinutes() + ':' + date.getSeconds();
			return Str;
		}
		$(function() {
			var a = "${articleDetail.a_createtime}";
			$("#a_createtime").html("发帖时间：" + GMTToStr(a));
			<c:forEach var="item" items="${comments}" varStatus="status"> 
				var text = "#c_createtime"+${status.count};
				$(text).html("评论时间：" + GMTToStr("${item.c_createtime}"));
			</c:forEach> 
		});

		function audioPlay(text,id) {
			var zhText = text;
			zhText = encodeURI(zhText);
			var audio = "<audio style=\"height:20px\" controls=\"controls\">"
					+ "<source src=\"http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=4&text="
					+ zhText
					+ "\" type=\"audio/mpeg\">"
					+ "<embed height=\"100\" width=\"100\" src=\"http://tts.baidu.com/text2audio?text="
					+ zhText + "\">" + "</audio>";
			$(id).prepend(audio);
		}
		audioPlay("${articleDetail.essay}","#postAtt");
		<c:forEach var="item" items="${comments}" varStatus="status"> 
			var id = "#commentVoice"+${status.count};
			audioPlay("${item.content}",id);
		</c:forEach> 

		$(".DELETE_COM").click(function(){
			var chk_value =[]; 
		    $('input[name="DELETE_CHECK_NAME"]:checked').each(function(){ 
		        chk_value.push($(this).val()); 
		    }); 
		    if(chk_value.length==0){
		    	$.MsgBox.Alert("消息","我是新的请先选择需要删除的评论！");
		    	return;
		    }
		    var c_id = $(this).val();
		    window.location.href = "http://localhost:8080/new_ssm/articleDetail/deleteCommentByC_id?c_id="+c_id;
		});	
		$(".c_likes").click(function(){
			var target = $(this);
		   	var dataSend = {
	       		c_id:target.next().val()
	       	};
	       
		    $.ajax({
                type: "POST",
                url: "http://localhost:8080/new_ssm/articleDetail/updateC_likesByC_id",
                data: JSON.stringify(dataSend),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                async: false,
                success: function (data) {
                	target.html("赞："+data.c_likes); 
                }, 
                error:function(){ 
                	alert("发生错误"); 
                }
                
            });
		});		    	
		$(".a_likes").click(function(){
			var target = $(this);
		   	var dataSend = {
	       		a_id:target.next().val()
	       	};
	       
		    $.ajax({
                type: "POST",
                url: "http://localhost:8080/new_ssm/articleDetail/updateA_likesByA_id",
                data: JSON.stringify(dataSend),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                async: false,
                success: function (data) {
                	target.html("赞："+data.a_likes); 
                }, 
                error:function(){ 
                	alert("发生错误"); 
                }
                
            });
		});		    		
	</script>
</body>
</html>