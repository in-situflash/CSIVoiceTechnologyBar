<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html style="height: auto;">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>æææç« è¯è®º</title>

		<link rel="stylesheet" href="static/css/default/bootstrap/bootstrap.css">
		<link rel="stylesheet" href="static/comp/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="static/comp/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="static/comp/adminlte/css/adminlte.css">
		<link rel="stylesheet" href="static/css/default/mask.css" />
	</head>

	<body style="height: auto;">
		
		
		<!--  <div class="container-fluid" id="ORG_LIST_DIV_ID">-->
		<div class="container-fluid" id="COM_LIST_DIV_ID">
			<div class="row">
				<div class="col-md-12" style="">
					<div class="card card-info">
						<div class="card-header">
							<h3 class="card-title">æç« </h3>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-md-11">
									<div class="form-inline col-md-11" style="width:100%">
										<div class="form-group " style="width:100%">
											<div id="postPhoto"><img src="headPhoto/default/default.jpg" style="whith:80px;height:80px"></div>
											&nbsp;&nbsp;
											<div id="postInfo"><table> <tbody><tr>  <td>ä¸»é¢ï¼æµè¯æç« 3</td> </tr> <tr>  <td>åå¸äººï¼sjm</td>	</tr> <tr>  <td>åå¸äººæ³¨åæ¶é´:2019-03-12 12:46:38</td> </tr> <tr>  <td>åå¸æ¶é´ï¼2019-03-18 20:43:37</td> </tr></tbody></table></div>

										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="postText"><span>è¿æ¯æµè¯æç« 3</span></div>
						<div id="postAtt"><audio src="/postbar/audio/c9c8ee13e83149379d56d34ea7913d69.mp3" controls="controls" style="height:20px"></audio>&nbsp;|&nbsp;<a id="praisecNum" href="javascript:void(0);" onclick="praiseclick('46dc37890bbc49629384024d2f17beda','0','/postbar/audio/c9c8ee13e83149379d56d34ea7913d69.mp3')">èµï¼</a> 0</div>
					</div>
					
				</div>
				
			</div>
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card-header" style="width:100%">
							<h3  class="card-title col-md-3" >å½åï¼<span id="LABLE_FATHER_ORG_NAME">æææç« ->è¯è®º</span></h3>
							<div class="col-md-2 col-md-offset-7" id="comAddAndDeleteDiv"><button class="btn  btn-success btn-sm" type="button" onclick="ADD_COM()">è¯è®º</button><button class="btn  btn-danger btn-sm" type="button" onclick="DELETE_COM()">å é¤</button><button class="btn btn-default btn-sm" type="button" onclick="returnPostList()">è¿å</button></div>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-12">
					<div class="card">
					
						<div class="card-body">
							<div id="example2_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4"><div class="card-header" style="background-color:#17a2b8"><h3 class="card-title">ç­é¨è¯è®º</h3></div><div class="row"><div class="form-inline col-sm-12"><div><img src="headPhoto/default/default.jpg" style="whith:80px;height:80px"></div><div><table><tbody><tr><td>è¯è®ºäººï¼wangxiaohua</td></tr><tr><td>è¯è®ºäººæ³¨åæ¶é´:2019-03-12 12:47:11</td></tr><tr><td>è¯è®ºæ¶é´ï¼2019-03-18 21:03:05</td></tr><tr><td>å é¤éä¸­ï¼<input name="DELETE_CHECK_NAME" type="checkbox" value="c9c8ee13e83149379d56d34ea7913d69"></td></tr></tbody></table></div></div><div class="col-sm-12"><span>è¿æ¯æµè¯æç« 3è¯è®º</span></div><div class="col-sm-12"><audio src="/postbar/audio/c9c8ee13e83149379d56d34ea7913d69.mp3" controls="controls" style="height:20px"></audio>&nbsp;|&nbsp;<a id="praisecNum" href="javascript:void(0);" onclick="hotsPraiseClick('46dc37890bbc49629384024d2f17beda','c9c8ee13e83149379d56d34ea7913d69')">èµï¼</a> 1</div></div><hr></div>
						</div>
						<!-- /.card-body -->
					</div>

				</div>

			</div>

			<div class="row">
				<div class="col-12">
					<div class="card">
					
						<div class="card-body">
							<div id="example3_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4"><div class="card-header" style="background-color:#17a2b8"><h3 class="card-title">å¨é¨è¯è®º</h3></div><div class="row"><div class="form-inline col-sm-12"><div><img src="headPhoto/default/default.jpg" style="whith:80px;height:80px"></div><div><table><tbody><tr><td>è¯è®ºäººï¼wangxiaohua</td></tr><tr><td>è¯è®ºäººæ³¨åæ¶é´:2019-03-12 12:47:11</td></tr><tr><td>è¯è®ºæ¶é´ï¼2019-03-18 21:03:05</td></tr><tr><td>å é¤éä¸­ï¼<input name="DELETE_CHECK_NAME" type="checkbox" value="c9c8ee13e83149379d56d34ea7913d69"></td></tr></tbody></table></div></div><div class="col-sm-12"><span>è¿æ¯æµè¯æç« 3è¯è®º</span></div><div class="col-sm-12"><audio src="/postbar/audio/c9c8ee13e83149379d56d34ea7913d69.mp3" controls="controls" style="height:20px"></audio>&nbsp;|&nbsp;<a id="praisecNum" href="javascript:void(0);" onclick="hotsPraiseClick('46dc37890bbc49629384024d2f17beda','c9c8ee13e83149379d56d34ea7913d69')">èµï¼</a> 1</div></div><hr></div>
						</div>
						<!-- /.card-body -->
					</div>

				</div>

			</div>

		</div>
		
		
		
		<!--<div id="ORG_ADD_DIV_ID" class="card card-info" style="display:none">  -->
		<div id="COM_ADD_DIV_ID" class="card card-info" style="display:none">
	    	<div class="card-header">
	             <h3 class="card-title">è¯è®ºç¼è¾</h3>
	        </div> 
	        <div class="form-horizontal">
	        							
	             <div class="card-body">
		
			            
			            <div class="form-group" >
			                 <label for="JI_JOB_NAME" class="col-sm-2 control-label">è¯è®ºï¼</label>
			              	 <div class="col-sm-10" >
			                 	<textarea  name="POST_ADD_DES" id="COM_ADD_DES" class="form-control" style="height:100px;"> </textarea>
			                 </div>
			            </div>
			              <!-- /.card-body -->
			             <div class="card-footer col-md-3 col-md-offset-4" style="width:100%"align="center">
			               <button type="button" class="btn btn-info" onclick="addComCheck()">æäº¤</button>
			               <button type="button" class="btn btn-default" onclick="returnComList()">è¿å</button>
			             </div>
			             <div class="card-footer col-md-3 col-md-offset-4" id="tishi" style="text-align: center;color: red;font-size: 15px">
									     
						</div>
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
		<script src="chinasofti/comment/js/comment.js"></script>
		<script type="text/javascript" src="static/js/alert.js"></script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->


</body></html>