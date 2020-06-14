<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html style="height: auto;">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>我的评论</title>

		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/css/default/bootstrap/bootstrap.css">
		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/comp/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/comp/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/comp/adminlte/css/adminlte.css">
		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/css/default/mask.css" />
	</head>

	<body style="height: auto;">
		
<%--		<br/><h1>Welcome, ${username}</h1>--%>
		
		<!--  <div class="container-fluid" id="ORG_LIST_DIV_ID">-->
		<div class="container-fluid" id="COM_LIST_DIV_ID">
	
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header" style="width:100%">
							<h3  class="card-title col-md-3" >当前：<span id="LABLE_FATHER_ORG_NAME">我的评论</span></h3>
							<div class="col-md-2 col-md-offset-7" id="comAddAndDeleteDiv"><button class="btn  btn-danger btn-sm" type="button" onclick="DELETE_COM()">删除</button></div>
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-12">
					<div class="card">
					
						<div class="card-body">
							<div id="example3_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4"><div class="card-header" style="background-color:#17a2b8"><h3 class="card-title">我的评论</h3></div>
							
							<c:forEach items="${mycomments}" var="comment" varStatus="com_status">
							<%--每一条评论的顶层容器的value都是评论的id，即c_id	--%>
							<div class="row" id="comment_${com_status.index}" value="${comment.c_id}">
							    	<div class="form-inline col-sm-12">
							    		<span id="comment_content">${comment.content}</span>
							    	</div>
							    	<div class="col-sm-12">
							    		<audio id="comment_audio_${com_status.index}" src="" controls="controls" style="height:20px"></audio>
										<button type="button" id="comment_audiobtn_${com_status.index}" onclick="tts('${comment.content}','${com_status.index}')">播放</button>
							    	</div>
							    	<div class="col-sm-12">
							    		<div>
							    			<table>
							    				<tbody>
							    					<tr>
							    						<td id="comment_time">
															评论时间：<fmt:formatDate value="${comment.c_createtime}" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp;|&nbsp;&nbsp;&nbsp;
														</td>
														<td>
														<%-- TODO: 显示文章名称而非文章ID (Done)--%>
															评论文章：<a href="" id="comment_articleId">${comment.title}</a>
															<%-- 在评论的文章详情时时，将评论div的index传给js --%>
															<a href="" onclick="post_detailed(${com_status.index}); return false;"></a> &nbsp;&nbsp;|&nbsp;&nbsp;
							    						</td>
							    						<td>
															<%-- 在点击编辑时，将评论div的index传给js --%>
							    							<a href="" onclick="EDIT_COM(${com_status.index}); return false;">评论编辑</a> ：&nbsp;&nbsp;|&nbsp;&nbsp;
							    						</td>
							    						<td>删除评论：<input name="DELETE_CHECK_NAME" type="checkbox" value="${comment.c_id}"></td>
							    					</tr>
							    				</tbody>
							    			</table>
							    		</div>
							    	</div>
							    </div>
								<div id="comment_${com_status.index}_hr">
									<hr /><hr/>
								</div>

							</c:forEach>
 -->							</div>
						</div>
						<!-- /.card-body -->
					</div>

				</div>

			</div>
			<div class="row">
				<div class="col-sm-12 col-md-9 col-md-offset-3">
					<div class="dataTables_paginate paging_simple_numbers">
						<ul class="pagination" id="PAGE_ID">
							<li style="margin-left: 30px">
								<button class="btn btn-primary" type="button" onclick="GOTO_POST_HOME_PAGE('0')">首页</button></li><li style="margin-left: 30px">
								<button class="btn btn-primary" type="button" onclick="GOTO_POST_PREVIOUS_PAGE('0')">前一页</button></li><li style="margin-left: 30px">
								<button class="btn btn-primary" type="button" onclick="GOTO_POST_NEXT_PAGE('2')">后一页</button></li><li style="margin-left: 30px">
								<button class="btn btn-primary" type="button" onclick="GOTO_POST_TAIL_PAGE('2')">末页</button></li><li style="margin-left: 30px">
								<input id="JUMP_INPUT_ID" type="text" style="display:inline;width:80px" size="6">
								<button class="btn btn-sm btn-outline-primary" onclick="GOTO_POST_PAGE();return false;">跳转</button></li><li style="margin-left: 30px">
								<div class="dataTables_info" style="margin-top: 6px;margin-left: 100px">
								<div class="dataTables_info" style="margin-top: 6px;margin-left: 100px">
									<span><text id="comment_page_indicator">2</text>/<text id="comment_totalpage_indicator">3</text> 页</span>
									<span>共${totalComment}条</span>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		
		
		<!--<div id="ORG_ADD_DIV_ID" class="card card-info" style="display:none">  -->
		<div id="COM_ADD_DIV_ID" class="card card-info" style="display:none">
	    	<div class="card-header">
	             <h3 class="card-title">评论编辑</h3>
	        </div> 
	        <div class="form-horizontal">
	        							
	             <div class="card-body">
		
			            
			            <div class="form-group" >
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">评论：</label>
			              	 <div class="col-sm-10" >
			                 	<textarea  name="POST_ADD_DES" id="COM_ADD_DES" class="form-control" style="height:100px;"> </textarea>
			                 </div>
			            </div>
			             <!-- /.card-body -->
	             <div id="editButtion" class="card-footer col-md-3 col-md-offset-4" style="width:100%"align="center">
	               
	             </div>
	             <div class="card-footer col-md-3 col-md-offset-4" id="tishi" style="text-align: center;color: #ff0000;font-size: 15px">
									     
						</div>
	             <!-- /.card-footer -->
	             </div>
	            
	        </div>
	    </div>
		
		<div id="comment_data_totalComment" value="${totalComment}" hidden/>
		
		
		<script src="/CSIVoiceTechnologyBar/static/comp/jquery/dist/jquery.js"></script>
		<script src="/CSIVoiceTechnologyBar/static/comp/jQuery-Storage-API/jquery.storageapi.js"></script>
		<script src="/CSIVoiceTechnologyBar/static/comp/jquery.form/jquery.form.min.js"></script>
		<script src="/CSIVoiceTechnologyBar/static/comp/jquery/plugins/scrollbar/perfect-scrollbar.jquery.min.js"></script>
		
		<script src="/CSIVoiceTechnologyBar/static/kindeditor/kindeditor-all.js" type="text/javascript"></script>
		<script src="/CSIVoiceTechnologyBar/static/kindeditor/kindeditor-all-min.js" type="text/javascript"></script>
		<script src="/CSIVoiceTechnologyBar/static/kindeditor/lang/zh-CN.js" type="text/javascript"></script>
		<script src="/CSIVoiceTechnologyBar/static/js/common/mask.js"></script>
		<script src="/CSIVoiceTechnologyBar/chinasofti/myComment/js/myComment.js"></script>
		<script type="text/javascript" src="/CSIVoiceTechnologyBar/static/js/alert.js"></script>
		<script src="/CSIVoiceTechnologyBar/static/js/common/baidu_tts_cors.js"></script>

		<script type="text/javascript">
			function tts(text, idx) {

                var audio_comp = $("#comment_audio_"+idx)[0];
                var audio_btn_comp = $("#comment_audiobtn_"+idx)[0];

				// 调用语音合成接口
				// 参数含义请参考 https://ai.baidu.com/docs#/TTS-API/41ac79a6
				audio = myCommentBtts({
					tex: text,
					tok: '25.d134c5f4a951a8bed186317f3b36e1a6.315360000.1907381403.282335-20381539',
					spd: 5,
					pit: 5,
					vol: 15,
					per: 4
				}, {
					volume: 0.3,
					autoDestory: true,
					timeout: 10000,
					hidden: false,
					onInit: function (htmlAudioElement) {

					},
					onSuccess: function(htmlAudioElement) {
                        // 成功调用api后自动播放
						audio_comp.play();
						// 隐藏播放按钮
						audio_btn_comp.style.display = "none";
					},
					onError: function(text) {
						alert(text)
					},
					onTimeout: function () {
						alert('timeout')
					}
				},
                audio_comp);
			}
		</script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/CSIVoiceTechnologyBar/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/CSIVoiceTechnologyBar/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body></html>