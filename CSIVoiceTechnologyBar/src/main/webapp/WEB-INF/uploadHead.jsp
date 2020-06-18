<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html style="height: auto;">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>所有文章</title>

		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/css/default/bootstrap/bootstrap.css">
		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/comp/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/comp/ionicons/css/ionicons.min.css">
		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/comp/adminlte/css/adminlte.css">
		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/static/css/default/mask.css" />
		<link rel="stylesheet" href="/CSIVoiceTechnologyBar/chinasofti/uploadHead/css/cropper.min.css">
    	<link rel="stylesheet" href="/CSIVoiceTechnologyBar/chinasofti/uploadHead/css/ImgCropping.css">
	</head>

	<body style="height: auto;">

		
		<!--<div id="ORG_ADD_DIV_ID" class="card card-info" style="display:none">  -->
		<div id="POST_ADD_DIV_ID" class="card card-info">
	    	<div class="card-header">
	             <h3 class="card-title">上传头像</h3>
	        </div> 
	        <input id="regUUID" type="hidden" value=""/>
	        <div class="form-horizontal">
				<div class="card-body" style="text-align: center;">
			       <!-- ------------ -->
			       <form method="post" action="http://localhost:8080/CSIVoiceTechnologyBar/articleDetail/uploadImage" enctype="multipart/form-data">
				   <button type="submit" class="l-btn" onclick="submitbtn()">提交头像</button>
					<div style="height:10px"></div>
					<div style="width: 150px;height: 150px;border: solid 1px #555;padding: 5px; margin: 0 auto;">
					    <input type="file"  name="file"/>
					    <img src="http://localhost:8080/CSIVoiceTechnologyBar/articleDetail/downloadImage?filename=${image}"
												style="whith: 80px; height: 80px"> 
					</div>
					</form>

					<!--图片裁剪框 start-->
					<div style="display: none" class="tailoring-container">
					    <div class="black-cloth" onclick="closeTailor(this)"></div>
					    <div class="tailoring-content">
					            <div class="tailoring-content-one">
					                <label title="上传图片" for="chooseImg" class="l-btn choose-btn">
					                    <input type="file" accept="image/jpg,image/jpeg,image/png" name="file" id="chooseImg" class="hidden" onchange="selectImg(this)">
					                    选择图片
					                </label>
					                <div class="close-tailoring"  onclick="closeTailor(this)">×</div>
					            </div>
					            <div class="tailoring-content-two">
					                <div class="tailoring-box-parcel">
					                    <img id="tailoringImg">
					                </div>
					                <div class="preview-box-parcel">
					                    <p>图片预览：</p>
					                    <div class="square previewImg"></div>
					                    <div class="circular previewImg"></div>
					                </div>
					            </div>
					            <div class="tailoring-content-three">
					                <button class="l-btn cropper-reset-btn">复位</button>
					                <button class="l-btn cropper-rotate-btn">旋转</button>
					                <button class="l-btn cropper-scaleX-btn">换向</button>
					                <button class="l-btn sureCut" id="sureCut">确定</button>
					            </div>
					        </div>
					</div>
			      <!-- --------------- -->
	             </div>

	        </div>
	    </div>
		
		
		
		
		
		<script src="/CSIVoiceTechnologyBar/static/comp/jquery/dist/jquery.js"></script>
		<script src="/CSIVoiceTechnologyBar/static/comp/jQuery-Storage-API/jquery.storageapi.js"></script>
		<script src="/CSIVoiceTechnologyBar/static/comp/jquery.form/jquery.form.min.js"></script>
		<script src="/CSIVoiceTechnologyBar/static/comp/jquery/plugins/scrollbar/perfect-scrollbar.jquery.min.js"></script>
		
		<script src="/CSIVoiceTechnologyBar/static/kindeditor/kindeditor-all.js" type="text/javascript"></script> 
		<script src="/CSIVoiceTechnologyBar/static/kindeditor/kindeditor-all-min.js" type="text/javascript"></script>
		<script src="/CSIVoiceTechnologyBar/static/kindeditor/lang/zh-CN.js" type="text/javascript"></script>
		<script src="/CSIVoiceTechnologyBar/static/js/common/mask.js"></script>
		<script src="/CSIVoiceTechnologyBar/chinasofti/uploadHead/js/cropper.min.js"></script>
		<script src="/CSIVoiceTechnologyBar/chinasofti/uploadHead/js/uploadHead.js"></script>
		<script type="text/javascript" src="/CSIVoiceTechnologyBar/static/js/alert.js"></script>
		<script type="text/javascript" src="/CSIVoiceTechnologyBar/static/js/layer/layer.js"></script>
		
		<!--  
		<script src="/stmadc/stma/dc/include/js/jcommon.js"></script>
		
		<script language="JavaScript" src="/stmadc/jquery/jquery-ui-1.8.20.min.js"></script>
		<script src="/stmadc//CSIVoiceTechnologyBar/static/comp/bootstrap/dist/js/bootstrap.js"></script>
		<script src="/stmadc//CSIVoiceTechnologyBar/static/comp/adminlte/js/adminlte.min.js"></script>
		<script language="JavaScript" src="/stmadc/stma/dc/include/js/jcommon.js"></script>
	-->
	<script type="text/javascript">
	function submitbtn(){
		layer.msg('上传成功!',{
	        icon:1 ,
	        time:10000,
	        end:function () {
	           
	        }
	    })
	}
	</script>

</body></html>