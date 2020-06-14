const commentPerPage=5; // 每一页显示的数量
var currentPage=0; // 当前页数
var allPageCount=3;	// 总页数
var allCommentCount=7;	// 总评论数量

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
$(function(){
  
	KindEditor.options.cssData = 'body {font-family:微软雅黑;}',
	editor = KindEditor.create('textarea[id="COM_ADD_DES"]', {
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

	_readInfo();
	_initPageDisplay();
});

function _setIndexedPageVisibility(pageIndex, hidden){

	var startPage = pageIndex*commentPerPage;
	var endPage = Math.min(startPage+commentPerPage, allCommentCount);	// 如果当前页数的数量小于一页的总数量，则只显示到所有页数结束为止
	// console.log("setIndexedPageVis:"+" Page="+pageIndex+" hidden="+hidden+" start="+startPage+" end="+endPage);

	for (let i=startPage; i < endPage; i++){
		var id_ = "#comment_"+i;
		var id_hr = "#comment_"+i+"_hr";
		// console.log(id_+" display->"+hidden);
		$(id_)[0].style.display = hidden ? "none" : "";			// 对评论栏进行可视调整
		$(id_hr)[0].style.display = hidden ? "none" : "";		// 对水平横线进行可视调整
	}
}

function _displayIndexedPage(pageIndex){
	_setIndexedPageVisibility(currentPage, true);	// 关闭跳转前页数的元素显示
	_setIndexedPageVisibility(pageIndex, false);			// 开启跳转后页数的元素显示
}

function _initPageDisplay(){
	for (let i=0; i < allPageCount; i++){
		if (i==currentPage){
			_setIndexedPageVisibility(i, false);
		}
		else {
			_setIndexedPageVisibility(i, true);
		}
	}
	refreshPageIndicator();
}

function refreshPageIndicator(){
	$("#comment_page_indicator").text(currentPage+1);		// 实际页数是页面下标+1
}

// 读取评论的初始化信息
function _readInfo(){
	allCommentCount = parseInt($("#comment_data_totalComment").attr("value"));
	allPageCount = Math.ceil(allCommentCount / commentPerPage);
	$("#comment_totalpage_indicator").text(allPageCount);
	console.log("allCommentCount:"+allCommentCount);
	console.log("allPageCount:"+allPageCount);
}

function allCommentlist(allCommentlist,postAllNum,allPage,pageIndex){
	
}

function post_detailed(postUUID){

	window.location.replace("comment.html?page=myCom&postid="+postUUID);

}
function DELETE_COM(){
	let chk_value =[];
	$('input[name="DELETE_CHECK_NAME"]:checked').each(function(){ 
	    chk_value.push($(this).val()); 
	}); 
	if(chk_value.length==0){
		$.MsgBox.Alert("消息","请先选择需要删除的评论！");
		return;
	}

	// 使用-字符拼接所有要删除的id
	const cid_concat = chk_value.join("-");
	const url = "/CSIVoiceTechnologyBar/comment/delete?ids="+cid_concat;

	window.location.replace(url);
}
function returnComList(){
	editor.html("");
	$("#tishi").html("");
	$("#COM_LIST_DIV_ID").attr("style","display:block;");//隐藏div
	$("#COM_ADD_DIV_ID").attr("style","display:none;");//隐藏div
}
function EDIT_COM(com_idx){

	var com_cont_id = "#comment_"+com_idx+" #comment_content";
	var content = $(com_cont_id).text();

	var com_cid_id = "#comment_"+com_idx;
	var c_id = $(com_cid_id).attr("value");

	// console.log("comment content: "+content);
	// console.log("c_id: "+c_id);

	editor.html(content);
	var html="";

	// TODO: 嵌入评论ID(Done)
	html+='<button type="button" class="btn btn-info" onclick="editComCheck(\''+c_id+'\')">编辑</button>';
	html+='<button type="button" class="btn btn-default" onclick="returnComList()">返回</button>';
	$("#editButtion").html(html);
    
    
	$("#COM_LIST_DIV_ID").attr("style","display:none;");//隐藏div
	$("#COM_ADD_DIV_ID").attr("style","display:block;");//隐藏div
	
}
function GOTO_POST_NEXT_PAGE(){
	if (currentPage == allPageCount-1){
		$.MsgBox.Alert("消息","已经是最后一页了!");
		return;
	}


	_displayIndexedPage(currentPage+1);
	currentPage++;
	refreshPageIndicator();									// 刷新当前页面的提示数字

}

function GOTO_POST_PREVIOUS_PAGE(){
	if (currentPage == 0){
		$.MsgBox.Alert("消息","已经是第一页了!");
		return;
	}

	_displayIndexedPage(currentPage-1);
	currentPage--;
	refreshPageIndicator();									// 刷新当前页面的提示数字

}

function GOTO_POST_HOME_PAGE(){
	_displayIndexedPage(0);
	currentPage = 0;
	refreshPageIndicator();									// 刷新当前页面的提示数字

}

function GOTO_POST_TAIL_PAGE(){
	_displayIndexedPage(allPageCount -1);
	currentPage = allPageCount - 1;
	refreshPageIndicator();									// 刷新当前页面的提示数字

}

function GOTO_POST_PAGE(){
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
	if(jumpVal>allPageCount){
		$.MsgBox.Alert("消息","页码超出上限");
		return;
	}

	_displayIndexedPage(jumpVal-1);
	currentPage = jumpVal - 1;
	refreshPageIndicator();									// 刷新当前页面的提示数字

}



function editComCheck(cid){
	var cmText=editor.html().trim();

	if(cmText==""){

		return;
	}
	

//	    		window.location.replace("myComment.html?radm="+Math.random());
	var url = "/CSIVoiceTechnologyBar/comment/edit?cid="+cid+"&cont="+cmText;
	// console.log("edit url: "+url);
	$("#tishi").html("编辑成功!");

	setTimeout(()=>{
		window.location.replace(url);
	}, 2000);
	
}


