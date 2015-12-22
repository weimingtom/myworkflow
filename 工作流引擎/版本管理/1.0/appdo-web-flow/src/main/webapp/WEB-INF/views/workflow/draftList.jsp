<%@ page language="java" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>草稿箱</title>
<%@ include file="../../../common/common.jsp"%>

</head>
<body>
	<div class="easyui-layout" style="width: 100%; height: 100%;"
		fit="true">
	<div region="north" split="false" border="false" class="st_head">
		<div class="titleTop">
			<span><img class="titleImage" src="${ctx }/static/images/daohang.png">
			</span>
			<span>任务管理->草稿箱</span>
		</div>
	</div>
	<div  region="center" style=" overflow-y: hidden;padding:5px;">
	<table id="draftTaskTable" class="easyui-datagrid" 
	    url="${ctx}/workflow/dataGridDraft" //数据加载路径 
        title="草稿箱管理" //表格标题
        iconCls="icon-table"//表格图标
        rownumbers="true" 		//是否显示行号
        pagination="true" 		//是否使用分页
        toolbar="#toolbar"  	//工具栏绑定
        pageList="[10,20,30]" 	//页大小选择
        pageSize="10" 			//每页的条数
        striped="true" 			//行条纹
        collapsible="false"  	//显示可折叠按钮
        loadMsg="正在加载，请稍后"	//加载提示
        singleSelect="true"		//是否只能选择单行
        fitColumns="true"
        fit="true"
        >
	    <thead >
	        <tr align="center">
	            <!-- <th field="ck"  checkbox="true" ></th> -->
	            <th field="id">id</th> 
	            <th field="title" width="15%" >标题</th>
	            <!-- <th field="code" width="15%">编码</th> -->
	            <th field="businame" width="15%">单据类型</th>
	            <th field="createtime" width="15%" type="date">创建时间</th>
	            <th field="_operate" formatter="formatOper" width="10%">操作</th>
			</tr>
	    </thead>
	</table>
	<div id="enlarge_images" style="display:none;position: absolute;">			
			<img id="limg" src="">
	</div>
	</div>
</div>
</body>
<script type="text/javascript">
//增加自定义列
function formatOper(val,row,index){
	var format = '<a href="javascript:void(0)" onclick="openForm('+index+')">查看单据</a>';
	return format ;
} 
function openForm(index){
	var row = $('#draftTaskTable').datagrid('getRows')[index];
	if (row){ 
		window.location.href='${ctx}/myflow/flow_base_jsp/'+row.busipath+'/'+row.id;
	}
}
</script>
</html>