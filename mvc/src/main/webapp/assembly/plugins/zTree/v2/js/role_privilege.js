var privilege = {
	/* ������� save data */
	data:{
		role : {
			rid : '',
			name : ''
		},
	},
	/*��ʼ��*/
	init:{
		/*��ʼ������*/
		initData:function(){
			/* a ��ǩ�ĸ��ڵ�,Ȼ���������ֵܽڵ�,����������ֵܽڵ�ĵ�һ��Ԫ��,��ȡֵ,��ֵ */
			privilege.data.role.name = $(this).parent().siblings("td:first").text();
    		/* a ��ǩ�ĸ��ڵ� ��td,Ȼ�����������ֵܽڵ� ,Ȼ���ҵ�input,����Ϊhidden */
    		privilege.data.role.rid = $(this).parent().siblings("input").val();
		},
		/*-------------------------------��ʼ���¼� initEvent start----------------------*/
		initEvent:function(){
			/*������Ȩ�����click�¼�?*/
			$("a").each(function() {
				if ($(this).attr("title")=="N_QUAN") {
					$(this).unbind("click");
					$(this).bind("click",function(){
						/*1:ʹ���е�����div��ʾ*/
						privilege.option.divOpt.showDiv();
						/*2:��user�е�name��uid��ֵ*/
						privilege.data.role.rid = $(this).parent().siblings("input").val();
						privilege.data.role.name = $(this).parent().siblings("td:first").text();
						/*3:��̬����ʾ�û���*/
						privilege.option.roleOpt.showRoleName();
						/*
						 * �����������Եó�
						 * ��ɫ��û�м��س����������,ȫѡ��ѡ���ǲ��ܵ��,ֻ�е���ɫ�����س���������²��ܵ��
						 */
						/* ����ȫѡ���ֵΪ������ */
						privilege.option.privilegeTree.isAllChecked(false);
						/* ��ʾloading ����roleTree */
						privilege.option.roleOpt.changeLoadingAndRoleTree({privilegeTree:true});
						/*4:���ؽ�ɫ��*/
						privilege.option.privilegeTree.loadPrivilegeTree();
						return false;
					});
				}
			});
			/*��ȫѡ��ѡ�����change�¼�*/
    		$("#cbSelectAll").unbind("change");
			$("#cbSelectAll").bind("change", function() {
				privilege.option.privilegeTree.allChecked.call(this);
			});
			/* ������������click�¼� */
			$("#savePrivilege").unbind("click");
			$("#savePrivilege").bind("click", function() {
				privilege.option.privilegeTree.savePrivilege();
			});
		}
		/*-------------------------------��ʼ���¼� initEvent end----------------------*/
	},
	/*------------------------------�ָ���option start-----------------------------*/
	option:{
		roleOpt:{
			showRoleName:function(){
				$("#roleNameImage").text(privilege.data.role.name);
			},
			/* ��Loading.gif��roleTree��ת�� */
			changeLoadingAndRoleTree:function(json){
				if (json.privilegeTree) {
    				$("#privilegeTree").show();
					$("#loading").hide();
				}else {
					$("#privilegeTree").hide();
					$("#loading").show();
				}
			}
		},
		divOpt:{
			showDiv:function(){
				$("div:hidden").show();
			}
		},
		/*........................�ָ���privilegeTree start.............................*/
		privilegeTree:{
			zTreeplugin:'',
			setting: {
				isSimpleData: true,
				treeNodeKey: "id",
				treeNodeParentKey: "pid",
				showLine: true,
				root: {
					isRoot: true,
					nodes: []
				},
				checkable:true,
				callback:function(){
					privilege.option.privilegeTree.setAllCheckedValue();
				}
			},
			/*����Ȩ����*/
			loadPrivilegeTree:function(){
				$("#privilegeTree").zTree(privilege.option.privilegeTree.setting);
				$.post("http://localhost:8080/oa/showPrivilegeByRid","rid="+privilege.data.role.rid,function(data){
					privilege.option.privilegeTree.zTreeplugin = $("#privilegeTree").zTree(privilege.option.privilegeTree.setting,data);
					/* ����Ƚ�ɫ�����س����Ժ�Żָ�����״̬ ����ȫѡ��Ϊ����״̬ */
					privilege.option.privilegeTree.isAllChecked(false);
					/* ��������ɫ�������������Ժ�,����loading.gif����releTree */
					privilege.option.roleOpt.changeLoadingAndRoleTree({privilegeTree:true});
					/*����ȫѡ��ѡ���ʼ��״̬��ֵ*/
					privilege.option.privilegeTree.setAllCheckedValue();
				},"json");
			},
			/*����ȫѡ��ѡ���״̬*/
			isAllChecked:function(checked){
				$("#cbSelectAll").attr("disabled", checked);
			},
			/*����ȫѡ��ѡ���Ĭ��ֵ */
			setAllCheckedValue:function(){
				/*���� zTree ��ǰcheckBox / radio �����ѡ�� �� δѡ��Ľڵ㼯��:false��ʾȫ��û��ѡ�еļ���*/
				var uncheckedNodes = privilege.option.privilegeTree.zTreeplugin.getCheckedNodes(true);
				if (uncheckedNodes.length==0) {
					$("#cbSelectAll").attr("checked",true);
				}else {
					$("#cbSelectAll").attr("checked",false);
				}
			},
			/*ȫѡ��ѡ��Ĺ���*/
			allChecked:function(){
				if ($(this).attr("checked")) {
					privilege.option.privilegeTree.zTreeplugin.checkAllNodes(true);
				}else {
					privilege.option.privilegeTree.zTreeplugin.checkAllNodes(false);
				}
			},
			/*����*/
			savePrivilege:function(){
				/*1:��ȡ���н�ɫ����rid*/
				var checkedNodes = privilege.option.privilegeTree.zTreeplugin.getCheckedNodes(true);/*��ȡ��ѡ��ɫ*/
				var str = "";
				for (var i = 0; i < checkedNodes.length; i++) {
					if ((checkedNodes.length-1)==i) {
						str += checkedNodes[i].id;
					}else {
						str += checkedNodes[i].id + ",";
					}
				}
				var rid = privilege.data.role.rid;
				$.post("/oa/savePrivilege__","rid="+rid+"&str="+str,function(data){
					if (data!=null) {
						alert(data);
					}else {
						alert("error");
					}
				});
//				var url = "/oa/savePrivilege__?"+"rid="+rid+"&str="+str;
//				window.location.href = url;
			}
		}
		/*........................�ָ���privilegeTree end.............................*/
	}
	/*------------------------------�ָ���option end-----------------------------*/
};

$().ready(function() {
	privilege.init.initEvent();
});