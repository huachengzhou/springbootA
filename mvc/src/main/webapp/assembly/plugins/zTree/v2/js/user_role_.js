var role = {
	/*�������*/
    data:{
    	user:{
    		name:'',
    		uid:''
    	}
    },
    init:{
    	/*---------------------------�ָ���---------------------------------------*/
    	/*��ʼ������*/
    	initData:function(){
    		/* a ��ǩ�ĸ��ڵ�,Ȼ���������ֵܽڵ�,����������ֵܽڵ�ĵ�һ��Ԫ��,��ȡֵ,��ֵ */
    		role.data.user.name = $(this).parent().siblings("td:first").text();
    		/* a ��ǩ�ĸ��ڵ� ��td,Ȼ�����������ֵܽڵ� ,Ȼ���ҵ�input,����Ϊhidden */
    		role.data.user.uid = $(this).parent().siblings("input").val();
    	},
    	/*��ʼ���¼�*/
    	initEvent:function(){
    		/*������Ȩ�����click�¼�?*/
    		$("a").each(function() {
				if ($(this).attr("title")=="N_QUAN") {
					$(this).unbind("click");
					$(this).bind("click",function(){
						/*1:ʹ���е�����div��ʾ*/
						role.option.divopt.showDiv();
						/*2:��user�е�name��uid��ֵ*/
						role.data.user.name = $(this).parent().siblings("td:first").text();
						role.data.user.uid = $(this).parent().siblings("input").val();
						/*3:��̬����ʾ�û���*/
						role.option.useropt.showUserName();
						/*
						 * �����������Եó�
						 * ��ɫ��û�м��س����������,ȫѡ��ѡ���ǲ��ܵ��,ֻ�е���ɫ�����س���������²��ܵ��
						 */
						/* ����ȫѡ���ֵΪ������ */
						role.option.roleopt.changeCheckBoxStatus(true);
						/* ��ʾloading ����roleTree */
						role.option.roleopt.changeLoadingAndRoleTree({roleTree:false});
						/*4:���ؽ�ɫ��*/
						role.option.roleopt.roleTree.loadRoleTree();
						return false;
					});
				}
			});
    		/*��ȫѡ��ѡ�����change�¼�*/
    		$("#cbSelectAll").unbind("change");
			$("#cbSelectAll").bind("change", function() {
				role.option.roleopt.allchecked.call(this);
			});
			/* ������������click�¼� */
			$("#savePrivilege").unbind("click");
			$("#savePrivilege").bind("click", function() {
				alert("save()");
				role.option.roleopt.saveRole();
			});
    	}
    	/*---------------------------�ָ���---------------------------------------*/
    },
    /*����*/
    option:{
    	/*...........................�ָ���...................................*/
    	/* �漰div�Ĳ��� */
    	divopt:{
    		showDiv:function(){
    			/*ʹ���е�����div��ʾ����*/
    			$("div:hidden").show();
    		}
    	},
    	/*...........................�ָ���...................................*/
    	/*�漰�����û�����*/
    	useropt:{
    		showUserName:function(){
    			$("#userNameImage").text(role.data.user.name);
    		}
    	},
    	/*...........................�ָ���...................................*/
    	/* �漰����ɫ���Ĳ��� */
    	roleopt:{
    		/*����zTree�����ķ���ֵ*/
    		zTreePlugin:'',
    		/*???????????????????????*/
    		setting : {
				checkable : true,
				showLine : true,
				isSimpleData : true,
				treeNodeKey : "rid",
				treeNodeParentKey : "pid",
				root : {
					isRoot : true,
					nodes : []
				},
				/*��ʾ���ϵĸ�ѡ��*/
				checkable : true,
				callback:{
					change:function(){
						/*����setAllChecked��������ȫѡ��ѡ���״̬*/
						role.option.roleopt.setAllChecked();
					}
				}
			},
			/*???????????????????????*/
			roleTree:{
				/* ���ؽ�ɫ�� http://localhost:8080/oa/showTreeRoleObject ������� */
				loadRoleTree:function(){
					$("#roleTree").zTree(role.option.roleopt.setting);
					$.post("http://localhost:8080/oa/showTreeRoleObject","uid="+role.data.user.uid,function(data){
						/*���С����,��Ϊ����Ҫ������,���Ҽ���֮��Ҫ����һ��ֵ,�������ֵȥ�������ݺ��¼�*/
						role.option.roleopt.zTreePlugin = $("#roleTree").zTree(role.option.roleopt.setting,data);
//						$("#roleTree").zTree(role.option.roleopt.setting,data);
						/* ����Ƚ�ɫ�����س����Ժ�Żָ�����״̬ ����ȫѡ��Ϊ����״̬ */
						role.option.roleopt.changeCheckBoxStatus(false);
						/* ��������ɫ�������������Ժ�,����loading.gif����releTree */
						role.option.roleopt.changeLoadingAndRoleTree({roleTree:true});
						/*����ȫѡ��ѡ���ʼ��״̬��ֵ*/
						role.option.roleopt.setAllChecked();
					},"json");
				}
			},
			/*???????????????????????*/
    		/*����ѡ�����ֵ */
    		changeCheckBoxStatus:function(status){
    			$("#cbSelectAll").attr("disabled", status);
    		},
    		/*???????????????????????*/
    		/* ��Loading.gif��roleTree��ת�� */
    		changeLoadingAndRoleTree:function(json){
    			if (json.roleTree) {
    				$("#roleTree").show();
					$("#loading").hide();
				}else {
					$("#roleTree").hide();
					$("#loading").show();
				}
    		},
    		/*???????????????????????*/
    		/* ȫѡ��ѡ��Ĺ��� */
    		allchecked:function(){
    			if ($(this).attr("checked")) {
					role.option.roleopt.zTreePlugin.checkAllNodes(true);
				}else {
					role.option.roleopt.zTreePlugin.checkAllNodes(false);
				}
    		},
    		/* ����ȫѡ��ѡ���״̬ */
    		setAllChecked:function(){
    			/*���� zTree ��ǰcheckBox / radio �����ѡ�� �� δѡ��Ľڵ㼯��:false��ʾȫ��û��ѡ�еļ���*/
    			var uncheckedNodes = role.option.roleopt.zTreePlugin.getCheckedNodes(false);
    			if (uncheckedNodes.length==0) {/*˵��ȫ����ѡ��*/
					$("#cbSelectAll").attr("checked",true);/*����ѡ��ȫ����ѡ��,��ôȫѡ������뱻ѡ��*/
				}else {/*û�б�ȫ��ѡ��*/
					$("#cbSelectAll").attr("checked",false);
				}
    		},
    		/*����*/
    		/*�����û��ͽ�ɫ֮��Ĺ�ϵ*/
    		saveRole:function(){
    			/*1:��ȡuid�ͱ�ѡ�е����еĽ�ɫ��rid*/
    			var checkedNodes = role.option.roleopt.zTreePlugin.getCheckedNodes(true);/*��ѡ�е����н�ɫ*/
    			var checkedStr = "";
    			/*2:��ֻ̨Ҫ���û�����update����*/
    			for (var i = 0; i < checkedNodes.length; i++) {
					if (i==checkedNodes.length-1) {//���һ��
						checkedStr += checkedNodes[i].rid;
					}else {
						checkedStr += checkedNodes[i].rid + ',';
					}
				};
    			/*ajax�����̨���ݵĲ���*/
				alert(checkedStr+"....");
				var url = "/oa/userRoleController?"+"uid="+role.data.user.uid+"&checkedStr="+checkedStr;
				window.location.href = url;
//    			$.post("/oa/userRoleController","uid="+role.data.user.uid+"&checkedStr="+checkedStrr,function(){
//    				alert("save success!");
//    			});
    		}
    	}
    }
};
$().ready(function() {
	role.init.initEvent();
});