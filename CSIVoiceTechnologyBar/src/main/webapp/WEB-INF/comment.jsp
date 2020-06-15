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
	href="/CSIVoiceTechnologyBar/static/css/default/bootstrap/bootstrap.css">
<link rel="stylesheet"
	href="/CSIVoiceTechnologyBar/static/comp/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/CSIVoiceTechnologyBar/static/comp/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="/CSIVoiceTechnologyBar/static/comp/adminlte/css/adminlte.css">
<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/css/default/mask.css" />
</head>

<body style="height: auto;">
	<!--  <div class="container-fluid" id="ORG_LIST_DIV_ID">-->
	<div class="container-fluid" id="COM_LIST_DIV_ID">
		<div class="row">
			<div class="col-md-12" style="">
				<div class="card card-info">
					
					<div class="card-body">
						<div class="card-header">
							<h3 class="card-title">文章 </h3>
						</div>
						<div class="row">
							<div class="col-md-11" style="padding:0;">
								<div class="form-inline col-md-11" style="width: 100%">
									<div class="form-group " style="width: 100%">
										<div id="postPhoto">
											<img src="http://localhost:8080/CSIVoiceTechnologyBar/articleDetail/downloadImage?filename=${AImageUrl}"
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
						<div id="postText">
							<span>${articleDetail.essay}</span>
						</div>
						<div id="postAtt">
							|&nbsp;<a id="praisecNum" href="javascript:void(0);" class="a_likes" style="color:default;">赞：${articleDetail.a_likes}</a>
							<input value="${articleDetail.a_id}" hidden="true"></input>
						</div>
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
									 
										<img src="http://localhost:8080/CSIVoiceTechnologyBar/articleDetail/downloadImage?filename=${CImageUrls[status.index]}"
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
												
											</tbody>
										</table>
									</div>
								</div>
								<div class="col-sm-12">
									<span>${item.content }</span>
								</div>
								<div style="width:86%;"> 
									<div style="float:left;">
										<div class="col-sm-12" id="commentVoice${status.count}" >
											<audio  controls="controls"  style="height:20px"></audio>
											<button type="button" class="audioPlay btn  btn-success btn-sm" value="${status.index}" style="margin-top:-10px;">下载</button>
											&nbsp;|<a id="praisecNum" class="c_likes" style="color:default;"  href="javascript:void(0);" onclick="hotsPraiseClick('46dc37890bbc49629384024d2f17beda','c9c8ee13e83149379d56d34ea7913d69')">赞：${item.c_likes}</a>
											<input value="${item.c_id}" hidden="true"></input>
										</div>
									</div>
									<div style="float:right" id="comAddAndDeleteDiv${item.c_id}">
										<button id="DELETE${item.c_id}" value="${item.c_id}" class="btn  btn-danger btn-sm DELETE_COM" type="button" hidden="true">删除</button>
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




	<script src="/CSIVoiceTechnologyBar/static/comp/jquery/dist/jquery.js"></script>
	<script
		src="/CSIVoiceTechnologyBar/static/comp/jQuery-Storage-API/jquery.storageapi.js"></script>
	<script src="/CSIVoiceTechnologyBar/static/comp/jquery.form/jquery.form.min.js"></script>
	<script
		src="/CSIVoiceTechnologyBar/static/comp/jquery/plugins/scrollbar/perfect-scrollbar.jquery.min.js"></script>

	<script src="/CSIVoiceTechnologyBar/static/kindeditor/kindeditor-all.js"
		type="text/javascript"></script>
	<script src="/CSIVoiceTechnologyBar/static/kindeditor/kindeditor-all-min.js"
		type="text/javascript"></script>
	<script src="/CSIVoiceTechnologyBar/static/kindeditor/lang/zh-CN.js"
		type="text/javascript"></script>
	<script src="/CSIVoiceTechnologyBar/static/js/common/mask.js"></script>
	<script src="/CSIVoiceTechnologyBar/static/js/common/baidu_tts_cors.js"></script>
	<script src="/CSIVoiceTechnologyBar/chinasofti/comment/js/comment.js"></script>
	<script type="text/javascript" src="/CSIVoiceTechnologyBar/static/js/alert.js"></script>
	<script type="text/javascript" src="/CSIVoiceTechnologyBar/static/js/layer/layer.js"></script>
	
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
		function tts(text, id, speed, tone, volume, type) {

	        // 调用语音合成接口
	        // 参数含义请参考 https://ai.baidu.com/docs#/TTS-API/41ac79a6
	        audio = btts({
	            tex: text,
	            tok: '25.d134c5f4a951a8bed186317f3b36e1a6.315360000.1907381403.282335-20381539',
	            spd: speed,
	            pit: tone,
	            vol: volume,
	            per: type
	        }, {
	            volume: 0.3,
	            autoDestory: true,
	            timeout: 10000,
	            hidden: false,
	            onInit: function (htmlAudioElement) {

	            },
	            onSuccess: function(htmlAudioElement) {
	                audio = htmlAudioElement;
	                $(id).prepend(audio);
	                $("audio").css("height","20px");
	            },
	            onError: function(text) {
	                alert(text)
	            },
	            onTimeout: function () {
	                alert('timeout')
	            }
	        });
	    }
	    var voicetype;
		switch("${audioSet.voicetype}") {
	     case "普通女声":
	        voicetype = 0;
	        break;
	     case "普通男声":
	        voicetype = 1;
	        break;
	     case "度逍遥（武侠）":
	    	voicetype = 3;
		    break;
	     case "度丫丫（软萌）":
		    voicetype = 4;
			break;
	     default:
	    	voicetype = 4;
		} 
		$(".audioPlay").click(function(){
			var id = "#" + $(this).parent().attr('id'); 
			var index = $(this).val();
			$(this).prev().remove();
			<c:forEach var="item" items="${comments}" varStatus="status"> 
				if(${status.index}==index){
					tts("${item.content}",id, ${audioSet.speed}, ${audioSet.tone}, ${audioSet.volume},voicetype);
				}
			</c:forEach> 
			
			
			
		})
	    tts("${articleDetail.essay}","#postAtt", ${audioSet.speed}, ${audioSet.tone}, ${audioSet.volume},voicetype); 
	    /* <c:forEach var="item" items="${comments}" varStatus="status"> 
			var id = "#commentVoice"+${status.count};
			tts("${item.content}",id, ${audioSet.speed}, ${audioSet.tone}, ${audioSet.volume},voicetype);
		</c:forEach>  */
		/* function audioPlay(text,id) {
			var zhText = text;
			zhText = encodeURI(zhText);
			var audio = "<audio style=\"height:20px\" controls=\"controls\">"
					+ "<source src=\"http://tts.baidu.com/text2audio?per=111&lan=zh&ie=UTF-8&spd=5&text=" 
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
		</c:forEach>  */

		
		$(function() {
			var dataSend = {
		       	username:"${username}"
		    };
			$.ajax({
			    type: "POST",
			    url: "http://localhost:8080/CSIVoiceTechnologyBar/articleDetail/selectC_idsByUsername",
			    data: JSON.stringify(dataSend),
			    contentType: "application/json; charset=utf-8",
			    dataType: "json",
			    async: false,
			    success: function (data) {
			    	var c_ids = data.c_ids;
			    	for(i=0; i<c_ids.length;i++){
			    		$("#DELETE"+c_ids[i]).attr("hidden",false);
					}
			        
			    }, 
			    error:function(){ 
			        alert("发生错误"); 
			    }
			});
		});
		$(".DELETE_COM").click(function(){
		    var c_id = $(this).val();
		    layer.confirm('确定删除这条评论吗？', {
		    	  btn: ['确定','取消'] //按钮
		    	}, function(){
		    	  layer.msg('成功删除', {icon: 1},{
		    		time: 2000,//2s后自动关闭
			      });
		    	  window.location.href = "http://localhost:8080/CSIVoiceTechnologyBar/articleDetail/deleteCommentByC_id?c_id="+c_id+"&a_id="+${a_id};
		    	}, function(){
		    	  
		    	}); 
		    //window.location.href = "http://localhost:8080/CSIVoiceTechnologyBar/articleDetail/deleteCommentByC_id?c_id="+c_id;
		});	
		$(".c_likes").click(function(){
			var that = $(this);
		   	var dataSend = {
	       		c_id:that.next().val()
	       	};
			var color = that.css("color");  
			var rgb = color.split(",");
			if(rgb[1] == 86){
				that.css({"color":"red"}); 
				$.ajax({
		         	type: "POST",
		         	url: "http://localhost:8080/CSIVoiceTechnologyBar/articleDetail/updateC_likesByC_id",
		         	data: JSON.stringify(dataSend),
		         	contentType: "application/json; charset=utf-8",
		         	dataType: "json",
		         	async: false,
		         	success: function (data) {
		         		that.html("已点赞："+data.c_likes);	            	
		         	}, 
		            error:function(){ 
		                alert("发生错误"); 
		            }
		        });
			}
 
		});		    	
		$(".a_likes").click(function(){
			var that = $(this);
		   	var dataSend = {
	       		a_id:that.next().val()
	       	}; 
			var color = that.css("color");  
			var rgb = color.split(",");
			if(rgb[1] == 86){
				that.css({"color":"red"}); 
				$.ajax({
		         	type: "POST",
		         	url: "http://localhost:8080/CSIVoiceTechnologyBar/articleDetail/updateA_likesByA_id",
		         	data: JSON.stringify(dataSend),
		         	contentType: "application/json; charset=utf-8",
		         	dataType: "json",
		         	async: false,
		         	success: function (data) {
		            	that.html("已点赞："+data.a_likes);  
		         	}, 
		            error:function(){ 
		                alert("发生错误"); 
		            }
		        });
			}
		});		    
		function returnPostList(){
			window.history.go(-1);
		}
			
	</script>
</body>
</html>