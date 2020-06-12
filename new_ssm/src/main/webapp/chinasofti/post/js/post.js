var everyPageDataCount=7;
var postPageIndex=0;
var postAllPage=0;
$(document).ready(function () {
	KindEditor.options.cssData = 'body {font-family:微软雅黑;}',
	editor = KindEditor.create('textarea[id="POST_ADD_DES"]', {
		allowUpload : true,
	    uploadJson: '/postbar/postController/kindEditorImgInput',
	    allowFileManager: false,
	    width:'900px',
	    height: '300px',
	    items: [ 'fullscreen','|','undo', 'redo', '|', 'preview', 'print', 'cut', 'copy', 'paste',
	            'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
	            'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
	            'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
	            'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image',
	             'table', 'hr', 'emoticons', ]
	});
	
	
	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(searchNameVal,0,everyPageDataCount,true,"/postbar/postController/getPostList");
	
});
function getPostList(postTitle,pageIndex,everyPageDataCount,SynOrAsyn,url){

	  	$("#SEARCH_POST_NAME_HIDDEN").val(postTitle.trim());
	  		
}

function returnPostList(){
	$("#POST_ADD_TITLE").val("");
	editor.html("");
	$("#tishi").html("");
	$("#POST_LIST_DIV_ID").attr("style","display:block;");//隐藏div
	$("#POST_ADD_DIV_ID").attr("style","display:none;");//隐藏div
}

function ADD_POST(){
	 $("#POST_LIST_DIV_ID").attr("style","display:none;");//隐藏div
	 $("#POST_ADD_DIV_ID").attr("style","display:block;");//隐藏div
}



function addPostCheck(lastid){
	var title=$("#POST_ADD_TITLE").val().trim();
	var text=editor.html().trim();
	if(title==""){
		$("#tishi").html("文章标题不能为空");
		return;
	}
	if(title.length>16){
		$("#tishi").html("文章标题最多16个字符");
		return;
	}
	if(text==""){
		$("#tishi").html("文章内容不能为空");
		return;
	}

	var url;
	url = "http://localhost:8080/new_ssm/postController/addpost?lastid=" + lastid + "&title=" + title + "&essay=" + text;
	window.location.replace(url);
}

function showPostlist(admin,postList,postAllNum,allPage,pageIndex){
	
}

function GOTO_POST_NEXT_PAGE(page,maxpage,SELECT_TYPE,title){

	if(SELECT_TYPE == 0){
		var temp = page + 1;
		var url;
		if(page==maxpage)
			url = "http://localhost:8080/new_ssm/postController/topost?page=" + page;
		else if(maxpage-page>0)
			url = "http://localhost:8080/new_ssm/postController/topost?page=" + temp;
		window.location.replace(url);
	}
	else if(SELECT_TYPE == 1){
		var temp = page + 1;
		var url;
		if(page==maxpage)
			url = "http://localhost:8080/new_ssm/postController/selectpost?title=" + title + "&selectpage=" + page;
		else if(maxpage-page>0)
			url = "http://localhost:8080/new_ssm/postController/selectpost?title=" + title + "&selectpage=" + temp;
		window.location.replace(url);
	}
}

function GOTO_POST_TAIL_PAGE(maxpage,SELECT_TYPE,title){
	if(SELECT_TYPE == 0){
		var url;
		url = "http://localhost:8080/new_ssm/postController/topost?page=" + maxpage;
		window.location.replace(url);
	}
	else if(SELECT_TYPE == 1){
		var url;
		url = "http://localhost:8080/new_ssm/postController/selectpost?title=" + title + "&selectpage=" + maxpage;
		window.location.replace(url);
	}
}

function GOTO_POST_PAGE(maxpage,SELECT_TYPE,title){
	if(SELECT_TYPE == 0){
		var jumpVal=$("#JUMP_INPUT_ID").val().trim();
		if(jumpVal==""){
			$.MsgBox.Alert("消息","跳转页不能为空");
			return;
		}
		if(!(/^[0-9]+$/.test(jumpVal))){
			$.MsgBox.Alert("消息","页码必须为数字");
			return;
		}
		if(jumpVal<=0){
			$.MsgBox.Alert("消息","页码必须大于等于1");
			return;
		}
		if(jumpVal>maxpage){
			$.MsgBox.Alert("消息","页码超出上限");
			return;
		}
	
		var url = "http://localhost:8080/new_ssm/postController/topost?page=" + jumpVal;
		window.location.replace(url);
	}
	
	else if(SELECT_TYPE == 1){
		var jumpVal=$("#JUMP_INPUT_ID").val().trim();
		if(jumpVal==""){
			$.MsgBox.Alert("消息","跳转页不能为空");
			return;
		}
		if(!(/^[0-9]+$/.test(jumpVal))){
			$.MsgBox.Alert("消息","页码必须为数字");
			return;
		}
		if(jumpVal<=0){
			$.MsgBox.Alert("消息","页码必须大于等于1");
			return;
		}
		if(jumpVal>maxpage){
			$.MsgBox.Alert("消息","页码超出上限");
			return;
		}
	
		var url = "http://localhost:8080/new_ssm/postController/selectpost?title=" + title + "&selectpage=" + jumpVal;
		window.location.replace(url);
	}
}


function GOTO_POST_HOME_PAGE(SELECT_TYPE,title){
	if(SELECT_TYPE == 0){
		window.location.replace("http://localhost:8080/new_ssm/postController/topost?page=1");
	}
	else if(SELECT_TYPE == 1){
		var url;
		url = "http://localhost:8080/new_ssm/postController/selectpost?title=" + title + "&selectpage=" + 1;
		window.location.replace(url);
	}
}

function GOTO_POST_PREVIOUS_PAGE(page,SELECT_TYPE,title){
	if(SELECT_TYPE == 0){
		var url;
		var temp = page-1;
		if(temp==0)
			window.location.replace("http://localhost:8080/new_ssm/postController/topost?page=1");
		else if(temp>0)
		{
			url = "http://localhost:8080/new_ssm/postController/topost?page=" +temp;
			window.location.replace(url);
		}
	}
	else if(SELECT_TYPE == 1){
		var url;
		var temp = page-1;
		if(temp==0)
		{
			url = "http://localhost:8080/new_ssm/postController/selectpost?title=" + title + "&selectpage=" + 1;
			window.location.replace(url);
		}
		else if(temp>0)
		{
			url = "http://localhost:8080/new_ssm/postController/selectpost?title=" + title + "&selectpage=" + temp;
			window.location.replace(url);
		}
	}
}
function searchByPostName(){
	var searchNameVal=$("#SEARCH_POST_NAME").val().trim();
	var url;
	if(searchNameVal != "")
		url = "http://localhost:8080/new_ssm/postController/selectpost?title=" + searchNameVal + "&selectpage=" +1;
	else if(searchNameVal == "")
		url = "http://localhost:8080/new_ssm/postController/topost?page=1";
	window.location.replace(url);
}

function post_detailed(postUUID){

	window.location.replace("comment.html?page=post&postid=0000000000000");

}

function DELETE_POST(){
	var chk_value =[]; 
    $('input[name="DELETE_CHECK_NAME"]:checked').each(function(){ 
        chk_value.push($(this).val()); 
    }); 
    if(chk_value.length==0){
    	$.MsgBox.Alert("消息","请先选择需要删除的文章");
    	return;
    }
    
    var url;
    url = "http://localhost:8080/new_ssm/postController/deletepost?a_id=" + chk_value;
    
    window.location.replace(url);
}



