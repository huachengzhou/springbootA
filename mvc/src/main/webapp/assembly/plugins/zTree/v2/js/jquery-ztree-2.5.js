/*
 * JQuery zTree 2.5
 * http://code.google.com/p/jquerytree/
 *
 * Copyright (c) 2010 Hunter.z
 *
 * Date: 2011-03-08
 *
 */

(function($) {

	var ZTREE_NODECREATED = "ZTREE_NODECREATED";
	var ZTREE_CLICK = "ZTREE_CLICK";
	var ZTREE_RIGHTCLICK = "ZTREE_RIGHTCLICK";
	var ZTREE_CHANGE = "ZTREE_CHANGE";
	var ZTREE_RENAME = "ZTREE_RENAME";
	var ZTREE_REMOVE = "ZTREE_REMOVE";
	var ZTREE_DRAG = "ZTREE_DRAG";
	var ZTREE_DROP = "ZTREE_DROP";
	var ZTREE_EXPAND = "ZTREE_EXPAND";
	var ZTREE_COLLAPSE = "ZTREE_COLLAPSE";
	var ZTREE_ASYNC_SUCCESS = "ZTREE_ASYNC_SUCCESS";
	var ZTREE_ASYNC_ERROR = "ZTREE_ASYNC_ERROR";

	var IDMark_Switch = "_switch";
	var IDMark_Icon = "_ico";
	var IDMark_Span = "_span";
	var IDMark_Input = "_input";
	var IDMark_Check = "_check";
	var IDMark_Edit = "_edit";
	var IDMark_Remove = "_remove";
	var IDMark_Ul = "_ul";
	var IDMark_A = "_a";

	var LineMark_Root = "root";
	var LineMark_Roots = "roots";
	var LineMark_Center = "center";
	var LineMark_Bottom = "bottom";
	var LineMark_NoLine = "noLine";
	var LineMark_Line = "line";

	var FolderMark_Open = "open";
	var FolderMark_Close = "close";
	var FolderMark_Docu = "docu";

	var Class_CurSelectedNode = "curSelectedNode";
	var Class_CurSelectedNode_Edit = "curSelectedNode_Edit";
	var Class_TmpTargetTree = "tmpTargetTree";
	var Class_TmpTargetNode = "tmpTargetNode";
	
	var Check_Style_Box = "checkbox";
	var Check_Style_Radio = "radio";
	var CheckBox_Default = "chk";
	var CheckBox_False = "false";
	var CheckBox_True = "true";
	var CheckBox_Full = "full";
	var CheckBox_Part = "part";
	var CheckBox_Focus = "focus";
	var Radio_Type_All = "all";
	var Radio_Type_Level = "level";
	
	var MoveType_Inner = "inner";
	var MoveType_Before = "before";
	var MoveType_After = "after";
	var MinMoveSize = "5";

	var settings = new Array();
	var zTreeId = 0;

	//zTree���캯��
	$.fn.zTree = function(zTreeSetting, zTreeNodes) {

		var setting = {
			//Tree Ψһ��ʶ����UL��ID
			treeObjId: "",
			//�Ƿ���ʾCheckBox
			checkable: false,
			//�Ƿ��ڱ༭״̬
			editable: false,
			//�༭״̬�Ƿ���ʾ�޸İ�ť
			edit_renameBtn:true,
			//�༭״̬�Ƿ���ʾɾ���ڵ㰴ť
			edit_removeBtn:true,
			//�Ƿ���ʾ������
			showLine: true,
			//�Ƿ���ʾͼ��
			showIcon: true,
			//�Ƿ��������ڵ�״̬
			keepParent: false,
			//�Ƿ�����Ҷ�ӽڵ�״̬
			keepLeaf: false,
			//��ǰ��ѡ���TreeNode
			curTreeNode: null,
			//��ǰ�����༭��TreeNode
			curEditTreeNode: null,
			//�Ƿ�����ק�ڼ� 0: not Drag; 1: doing Drag
			dragStatus: 0,
			dragNodeShowBefore: false,
			//ѡ��CheckBox �� Radio
			checkStyle: Check_Style_Box,
			//checkBox�����Ӱ�츸�ӽڵ����ã�checkStyle=Check_Style_Radioʱ��Ч�� 			
			checkType: {
				"Y": "ps",
				"N": "ps"
			},
			//radio �������������ͣ�ÿһ���ڵ����� �� ����Tree��ȫ���ڵ����ƣ�checkStyle=Check_Style_Boxʱ��Ч��
			checkRadioType:Radio_Type_Level,
			//checkRadioType = Radio_Type_All ʱ�����汻ѡ��ڵ�Ķ�ջ
			checkRadioCheckedList:[],
			//�Ƿ��첽��ȡ�ڵ�����
			async: false,
			//��ȡ�ڵ����ݵ�URL��ַ
			asyncUrl: "",
			//��ȡ�ڵ�����ʱ��������������ƣ����磺id��name
			asyncParam: [],
			//��������
			asyncParamOther: [],
			//��Array����ת��ΪJSONǶ�����ݲ���
			isSimpleData: false,
			treeNodeKey: "",
			treeNodeParentKey: "",
			rootPID: null,
			//�û��Զ���������
			nameCol: "name",
			//�û��Զ����ӽڵ���
			nodesCol: "nodes", 
			//�û��Զ���checked��
			checkedCol: "checked", 
			//�۵���չ����Ч�ٶ�
			expandSpeed: "fast",
			//�۵���չ��Trigger����
			expandTriggerFlag:false,
			//hover ���Ӱ�ť�ӿ�
			addHoverDom:null,
			//hover ɾ����ť�ӿ�
			removeHoverDom:null,
			//�����Զ�����ʾ�ؼ�����
			addDiyDom:null,
			//������Ի���ʽ�ӿ�
			fontCss:{},
			
			root: {
				isRoot: true,
				nodes: []
			},
			//event Function
			callback: {
				beforeAsync:null,
				beforeClick:null,
				beforeRightClick:null,
				beforeMouseDown:null,
				beforeMouseUp:null,
				beforeChange:null,
				beforeDrag:null,
				beforeDrop:null,
				beforeRename:null,
				beforeRemove:null,
				beforeExpand:null,
				beforeCollapse:null,
				
				nodeCreated:null,
				click:null,
				rightClick:null,
				mouseDown:null,
				mouseUp:null,
				change:null,
				drag:null,
				drop:null,
				rename:null,
				remove:null,
				expand:null,
				collapse:null,
				asyncSuccess:null,
				asyncError:null
			}			
		};

		if (zTreeSetting) {
			var tmp_checkType = zTreeSetting.checkType;
			zTreeSetting.checkType = undefined;
			var tmp_callback = zTreeSetting.callback;
			zTreeSetting.callback = undefined;
			var tmp_root = zTreeSetting.root;
			zTreeSetting.root = undefined;
			
			$.extend(setting, zTreeSetting);
			
			zTreeSetting.checkType = tmp_checkType;				
			$.extend(true, setting.checkType, tmp_checkType);
			zTreeSetting.callback = tmp_callback;				
			$.extend(setting.callback, tmp_callback);
			zTreeSetting.root = tmp_root;				
			$.extend(setting.root, tmp_root);
		}

		setting.treeObjId = this.attr("id");
		setting.treeObj = this;
		setting.root.tId = -1;
		setting.root.name = "ZTREE ROOT";
		setting.root.isRoot = true;
		setting.checkRadioCheckedList = [];
		setting.curTreeNode = null;
		setting.curEditTreeNode = null;
		setting.dragNodeShowBefore = false;
		setting.dragStatus = 0;
		setting.expandTriggerFlag = false;
		if (!setting.root[setting.nodesCol]) setting.root[setting.nodesCol]= [];
		zTreeId = 0;

		if (zTreeNodes) {
			setting.root[setting.nodesCol] = zTreeNodes;
		}
		if (setting.isSimpleData) {
			setting.root[setting.nodesCol] = transformTozTreeFormat(setting, setting.root[setting.nodesCol]);
		}
		settings[setting.treeObjId] = setting;

		setting.treeObj.empty();

		bindTreeNodes(setting, this);

		if (setting.root[setting.nodesCol] && setting.root[setting.nodesCol].length > 0) {
			initTreeNodes(setting, 0, setting.root[setting.nodesCol]);
		} else if (setting.async && setting.asyncUrl && setting.asyncUrl.length > 0) {
			asyncGetNode(setting);
		}
		
		return new zTreePlugin().init(this);

	};

	//���¼�
	function bindTreeNodes(setting, treeObj) {
		treeObj.unbind(ZTREE_NODECREATED);		
		treeObj.bind(ZTREE_NODECREATED, function (event, treeId, treeNode) {
			if ((typeof setting.callback.nodeCreated) == "function") setting.callback.nodeCreated(event, treeId, treeNode);
		});

		treeObj.unbind(ZTREE_CLICK);		
		treeObj.bind(ZTREE_CLICK, function (event, treeId, treeNode) {
		  if ((typeof setting.callback.click) == "function") setting.callback.click(event, treeId, treeNode);
		});
		
		treeObj.unbind(ZTREE_CHANGE);
		treeObj.bind(ZTREE_CHANGE, function (event, treeId, treeNode) {
		  if ((typeof setting.callback.change) == "function") setting.callback.change(event, treeId, treeNode);
		});

		treeObj.unbind(ZTREE_RENAME);
		treeObj.bind(ZTREE_RENAME, function (event, treeId, treeNode) {
			if ((typeof setting.callback.rename) == "function") setting.callback.rename(event, treeId, treeNode);
		});
		
		treeObj.unbind(ZTREE_REMOVE);
		treeObj.bind(ZTREE_REMOVE, function (event, treeId, treeNode) {
			if ((typeof setting.callback.remove) == "function") setting.callback.remove(event, treeId, treeNode);
		});

		treeObj.unbind(ZTREE_DRAG);
		treeObj.bind(ZTREE_DRAG, function (event, treeId, treeNode) {
		  if ((typeof setting.callback.drag) == "function") setting.callback.drag(event, treeId, treeNode);
		});

		treeObj.unbind(ZTREE_DROP);
		treeObj.bind(ZTREE_DROP, function (event, treeId, treeNode, targetNode, moveType) {
		  if ((typeof setting.callback.drop) == "function") setting.callback.drop(event, treeId, treeNode, targetNode, moveType);
		});

		treeObj.unbind(ZTREE_EXPAND);
		treeObj.bind(ZTREE_EXPAND, function (event, treeId, treeNode) {
			if ((typeof setting.callback.expand) == "function") setting.callback.expand(event, treeId, treeNode);
		});

		treeObj.unbind(ZTREE_COLLAPSE);
		treeObj.bind(ZTREE_COLLAPSE, function (event, treeId, treeNode) {
			if ((typeof setting.callback.collapse) == "function") setting.callback.collapse(event, treeId, treeNode);
		});

		treeObj.unbind(ZTREE_ASYNC_SUCCESS);
		treeObj.bind(ZTREE_ASYNC_SUCCESS, function (event, treeId, treeNode, msg) {
		  if ((typeof setting.callback.asyncSuccess) == "function") setting.callback.asyncSuccess(event, treeId, treeNode, msg);
		});

		treeObj.unbind(ZTREE_ASYNC_ERROR);
		treeObj.bind(ZTREE_ASYNC_ERROR, function (event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
		  if ((typeof setting.callback.asyncError) == "function") setting.callback.asyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown);
		});
		
		setting.treeObj.bind('contextmenu',
			function(event) {
				var targetObj = $(event.target);
				var treeNode = getTreeNodeByDom(setting, targetObj);
				var doRight = true;
				if ((typeof setting.callback.beforeRightClick) == "function") {
					doRight = setting.callback.beforeRightClick(setting.treeObjId, treeNode);
				}
				//����rightClick�¼�
				if (doRight && (typeof setting.callback.rightClick) == "function") {
					setting.callback.rightClick(event, setting.treeObjId, treeNode);
					return false;
				} 
				return (typeof setting.callback.rightClick) != "function";
			});
		
		setting.treeObj.bind('mouseup',
			function(event) {
				var targetObj = $(event.target);
				var treeNode = getTreeNodeByDom(setting, targetObj);
				var doMouseUp = true;
				if ((typeof setting.callback.beforeMouseUp) == "function") {
					doMouseUp = setting.callback.beforeMouseUp(setting.treeObjId, treeNode);
				}
				//����mouseUp�¼�
				if (doMouseUp && (typeof setting.callback.mouseUp) == "function") {
					setting.callback.mouseUp(event, setting.treeObjId, treeNode);
				}
				return true;
			});
		setting.treeObj.bind('mousedown',
			function(event) {
				var targetObj = $(event.target);
				var treeNode = getTreeNodeByDom(setting, targetObj);
				var doMouseDown = true;
				if ((typeof setting.callback.beforeMouseDown) == "function") {
					doMouseDown = setting.callback.beforeMouseDown(setting.treeObjId, treeNode);
				}
				//����mouseDown�¼�
				if (doMouseDown && (typeof setting.callback.mouseDown) == "function") {
					setting.callback.mouseDown(event, setting.treeObjId, treeNode);
				}
				return true;
			});
	}
	
	//����Dom��ȡtreeNode����
	function getTreeNodeByDom(setting, obj) {
		var treeNode;
		var targetObj = $(obj);
		if (targetObj.attr("id") == setting.treeObjId) {
			treeNode = null;
		} else {
			while (!targetObj.is("li") && targetObj.attr("id") != setting.treeObjId) {
				targetObj = targetObj.parent();
			};
			var tId = targetObj.attr("id");
			treeNode = getTreeNodeByTId(setting, tId);
		}
		return treeNode;
	}

	//��ʼ������ʾ�ڵ�Json����
	function initTreeNodes(setting, level, treeNodes, parentNode) {
		if (!treeNodes) return;

		for (var i = 0; i < treeNodes.length; i++) {
			var node = treeNodes[i];
			node.level = level;
			node.tId = setting.treeObjId + "_" + (++zTreeId);
			node.parentNode = parentNode;
			node[setting.checkedCol] = (node[setting.checkedCol] == true);
			node.checkedOld = node[setting.checkedCol];
			node.check_Focus = false;
			node.check_True_Full = true;
			node.check_False_Full = true;
			node.editNameStatus = false;
			fixParentKeyValue(setting, node);
			
			var tmpParentNode = (parentNode) ? parentNode: setting.root;

			//�����ڷǿսڵ������ӽڵ�
			node.isFirstNode = (tmpParentNode[setting.nodesCol].length == treeNodes.length) && (i == 0);
			node.isLastNode = (i == (treeNodes.length - 1));

			if (node[setting.nodesCol] && node[setting.nodesCol].length > 0) {
				node.open = (node.open) ? true: false;
				node.isParent = true;
				showTree(setting, node);
				initTreeNodes(setting, level + 1, node[setting.nodesCol], node);

			} else {
				node.isParent = (node.isParent) ? true: false;
				showTree(setting, node);
				
				//ֻ��ĩ���ڵ�����һ������checkBox����
				if (setting.checkable && i == treeNodes.length - 1) {
					repairParentChkClass(setting, node);
				}
			}
		}
	}

	//��ʾ�����ڵ�
	function showTree(setting, treeNode) {

		//��ȡ���ڵ�
		var p = treeNode.parentNode;
		if (!p) {
			p = setting.treeObj;
		} else {
			p = $("#" + treeNode.parentNode.tId + IDMark_Ul);
		}

		var html = "<li id='" + treeNode.tId + "' class='tree-node'>" + "<button type=\"button\" id='" + treeNode.tId + IDMark_Switch + "' title='' onfocus='this.blur();'></button>" + "<a id='" + treeNode.tId + IDMark_A + "' onclick=\"" + (treeNode.click || '') + "\" ><button type=\"button\" id='" + treeNode.tId + IDMark_Icon + "' title='' onfocus='this.blur();'></button><span id='" + treeNode.tId + IDMark_Span + "'></span></a>" + "<ul id='" + treeNode.tId + IDMark_Ul + "'></ul>" + "</li>";
		p.append(html);
		
		var switchObj = $("#" + treeNode.tId + IDMark_Switch);
		var aObj = $("#" + treeNode.tId + IDMark_A);
		var nObj = $("#" + treeNode.tId + IDMark_Span);
		var ulObj = $("#" + treeNode.tId + IDMark_Ul);
		var icoObj = $("#" + treeNode.tId + IDMark_Icon);
		
		setNodeName(setting, treeNode);
		setNodeLineIcos(setting, treeNode);
		setNodeFontCss(setting, treeNode);
		
		//�������ڵ�չ�����ر��¼�
		ulObj.css({
			"display": (treeNode.open ? "block": "none")
		});
		if (treeNode.isParent) {
			switchObj.bind('click', {
				treeObjId: setting.treeObjId,
				treeNode: treeNode
			},
			onSwitchNode);
			aObj.bind('dblclick', {
				treeObjId: setting.treeObjId,
				treeNode: treeNode
			},
			onSwitchNode);
		}
		aObj.bind('click',
		function() {
			var beforeClick = true;
			if ((typeof setting.callback.beforeClick) == "function") beforeClick = setting.callback.beforeClick(setting.treeObjId, treeNode);
			if (beforeClick == false) return;
			//����Ĭ���¼�����ֹ�ı���ѡ��
			window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty();
			//���ýڵ�Ϊѡ��״̬
			selectNode(setting, treeNode);
			//����click�¼�
			setting.treeObj.trigger(ZTREE_CLICK, [setting.treeObjId, treeNode]);
		});
		icoObj.bind('mousedown',
		function() {
			treeNode.editNameStatus = false;
		});

		//��ʾCheckBox Or Radio
		if (setting.checkable) {
			switchObj.after("<BUTTON type='BUTTON' ID='" + treeNode.tId + IDMark_Check + "' onfocus='this.blur();' ></BUTTON>");
			
			var checkObj = $("#" + treeNode.tId + IDMark_Check);
			
			if (setting.checkStyle == Check_Style_Radio && setting.checkRadioType == Radio_Type_All && treeNode[setting.checkedCol] ) {
				setting.checkRadioCheckedList = setting.checkRadioCheckedList.concat([treeNode]);
			}
			
			setChkClass(setting, checkObj, treeNode);
			
			checkObj.bind('click',
			function() {
				var beforeChange = true;
				if ((typeof setting.callback.beforeChange) == "function") beforeChange = setting.callback.beforeChange(setting.treeObjId, treeNode);
				if (beforeChange == false) return;
				
				treeNode[setting.checkedCol] = !treeNode[setting.checkedCol];
				checkNodeRelation(setting, treeNode);
				
				setChkClass(setting, checkObj, treeNode);
				repairParentChkClassWithSelf(setting, treeNode);

				//���� CheckBox ����¼�
				setting.treeObj.trigger(ZTREE_CHANGE, [setting.treeObjId, treeNode]);

			});
			
			checkObj.bind('mouseover',
			function() {
				treeNode.checkboxFocus = true;
				setChkClass(setting, checkObj, treeNode);
			});

			checkObj.bind('mouseout',
			function() {
				treeNode.checkboxFocus = false;
				setChkClass(setting, checkObj, treeNode);
			});
		}
		
		setNodeTarget(treeNode);
		setNodeUrl(setting, treeNode);
		
		//�༭��ɾ����ť
		aObj.hover(
			function() {
				addTreeDom(setting, treeNode);
			},
			function() {
				if (setting.curTreeNode != treeNode)
					removeTreeDom(setting, treeNode);
			}
		);

		aObj.bind('mousedown',
		function(eventMouseDown) {

			//�Ҽ�������ק
			if (eventMouseDown.button == 2 || !setting.editable) return;

			var doc = document;
			var curNode;
			var tmpArrow;
			var tmpTarget;
			var isOtherTree = false;
			var targetSetting = setting;
			var preTmpTargetNodeId = null;
			var preTmpMoveType = null;
			var tmpTargetNodeId = null;
			var moveType = MoveType_Inner;
			var mouseDownX = eventMouseDown.clientX;
			var mouseDownY = eventMouseDown.clientY;
			var startTime = (new Date()).getTime();

			$(doc).mousemove(function(event) {
				
				//Ϊ�����������������������������ƶ���겻����ק�ڵ�
				if (treeNode.editNameStatus) {
					return true;
				}

				//����Ĭ���¼�����ֹ�ı���ѡ��
				window.getSelection ? window.getSelection().removeAllRanges() : document.selection.empty();
				
				//�����������������ڵ�һ���ƶ�С��MinMoveSizeʱ����������ק����
				if (setting.dragStatus == 0 && Math.abs(mouseDownX - event.clientX) < MinMoveSize
						 && Math.abs(mouseDownY - event.clientY) < MinMoveSize) {
					return true;
				}

				$("body").css("cursor", "pointer");
				var switchObj = $("#" + treeNode.tId + IDMark_Switch);

				if (setting.dragStatus == 0 && treeNode.isParent && treeNode.open) {
					expandAndCollapseNode(setting, treeNode, !treeNode.open);
					setting.dragNodeShowBefore = true;
				}

				if (setting.dragStatus == 0) {
					//����beforeDrag alertʱ���õ�����ֵ֮ǰ������ק��Bug
					setting.dragStatus = -1;
					var beforeDrag = true;
					if ((typeof setting.callback.beforeDrag) == "function") beforeDrag = setting.callback.beforeDrag(setting.treeObjId, treeNode);
					if (beforeDrag == false) return;
					
					setting.dragStatus = 1;
					showIfameMask(true);

					//���ýڵ�Ϊѡ��״̬
					selectNode(setting, treeNode);
					removeTreeDom(setting, treeNode);

					var tmpNode = $("#" + treeNode.tId).clone();
					tmpNode.attr("id", treeNode.tId + "_tmp");
					tmpNode.css("padding", "0");
					tmpNode.children("#" + treeNode.tId + IDMark_A).removeClass(Class_CurSelectedNode);
					tmpNode.children("#" + treeNode.tId + IDMark_Ul).css("display", "none");

					curNode = $("<ul class='zTreeDragUL'></ul>").append(tmpNode);
					curNode.attr("id", treeNode.tId + IDMark_Ul + "_tmp");
					curNode.addClass(setting.treeObj.attr("class"));
					curNode.appendTo("body");

					tmpArrow = $("<button class='tmpzTreeMove_arrow'></button>");
					tmpArrow.attr("id", "zTreeMove_arrow_tmp");
					tmpArrow.appendTo("body");

					//���� DRAG ��ק�¼�������������ק��Դ���ݶ���
					setting.treeObj.trigger(ZTREE_DRAG, [setting.treeObjId, treeNode]);
				}
				
				if (setting.dragStatus == 1 && tmpArrow.attr("id") != event.target.id) {
					if (tmpTarget) {
						tmpTarget.removeClass(Class_TmpTargetTree);
						if (tmpTargetNodeId) $("#" + tmpTargetNodeId + IDMark_A, tmpTarget).removeClass(Class_TmpTargetNode);
					}
					tmpTarget = null;
					tmpTargetNodeId = null;					
					
					//�ж��Ƿ�ͬ����
					isOtherTree = false;
					targetSetting = setting;
					for (var s in settings) {
						if (settings[s].editable && settings[s].treeObjId != setting.treeObjId 
								&& (event.target.id == settings[s].treeObjId || $(event.target).parents("#" + settings[s].treeObjId).length>0)) {
							isOtherTree = true;
							targetSetting = settings[s];
						}
					}

					var docScrollTop = $(doc).scrollTop();
					var docScrollLeft = $(doc).scrollLeft();
					var treeOffset = targetSetting.treeObj.offset();
					var scrollHeight = targetSetting.treeObj.get(0).scrollHeight;
					var scrollWidth = targetSetting.treeObj.get(0).scrollWidth;
					var dTop = (event.clientY + docScrollTop - treeOffset.top);
					var dBottom = (targetSetting.treeObj.height() + treeOffset.top - event.clientY - docScrollTop);
					var dLeft = (event.clientX + docScrollLeft - treeOffset.left);
					var dRight = (targetSetting.treeObj.width() + treeOffset.left - event.clientX - docScrollLeft);
					var isTop = (dTop < 10 && dTop > -5);
					var isBottom = (dBottom < 10 && dBottom > -5);
					var isLeft = (dLeft < 10 && dLeft > -5);
					var isRight = (dRight < 10 && dRight > -5);
					var isTreeTop = (isTop && targetSetting.treeObj.scrollTop() <= 0);
					var isTreeBottom = (isBottom && (targetSetting.treeObj.scrollTop() + targetSetting.treeObj.height()+10) >= scrollHeight);
					var isTreeLeft = (isLeft && targetSetting.treeObj.scrollLeft() <= 0);
					var isTreeRight = (isRight && (targetSetting.treeObj.scrollLeft() + targetSetting.treeObj.width()+10) >= scrollWidth);

					if (event.target.id && targetSetting.treeObj.find("#" + event.target.id).length > 0) {
						//����ڵ� �Ƶ� �����ڵ�
						var targetObj = $("#" + event.target.id);
						while (!targetObj.is("li") && targetObj.attr("id") != targetSetting.treeObjId) {
							targetObj = targetObj.parent();
						};

						var canMove = false;
						//����Ƶ��Լ� �����Լ����Ӽ������ܵ�����ʱĿ��
						if (treeNode.parentNode && targetObj.attr("id") != treeNode.tId && $("#" + treeNode.tId).find("#" + targetObj.attr("id")).length == 0) {
							//�Ǹ��ڵ��ƶ�
							canMove = true;
						} else if (treeNode.parentNode == null && targetObj.attr("id") != treeNode.tId && $("#" + treeNode.tId).find("#" + targetObj.attr("id")).length == 0) {
							//���ڵ��ƶ�
							canMove = true;
						}
						if (canMove) {
							if (event.target.id && 
								(event.target.id == (targetObj.attr('id') + IDMark_A) || $(event.target).parents("#" + targetObj.attr('id') + IDMark_A).length > 0)) {
								tmpTarget = targetObj;
								tmpTargetNodeId = targetObj.attr('id');
								$("#" + tmpTargetNodeId + IDMark_A, tmpTarget).addClass(Class_TmpTargetNode);
							}
						}
					}
					
					//ȷ�������zTree�ڲ�
					if (event.target.id == targetSetting.treeObjId || $(event.target).parents("#" + targetSetting.treeObjId).length>0) {
						//ֻ���ƶ���zTree�����ı�Ե�����Ƶ� �����ų����ڵ��ڱ������ڵ��ƶ���
						if (!tmpTarget && (isTreeTop || isTreeBottom || isTreeLeft || isTreeRight) && (isOtherTree || (!isOtherTree && treeNode.parentNode != null))) {
							tmpTarget = targetSetting.treeObj;
							tmpTarget.addClass(Class_TmpTargetTree);
						}
						//�������Զ�����
						if (isTop) {
							targetSetting.treeObj.scrollTop(targetSetting.treeObj.scrollTop()-10);
						} else if (isBottom)  {
							targetSetting.treeObj.scrollTop(targetSetting.treeObj.scrollTop()+10);
						}
						if (isLeft) {
							targetSetting.treeObj.scrollLeft(targetSetting.treeObj.scrollLeft()-10);
						} else if (isRight) {
							targetSetting.treeObj.scrollLeft(targetSetting.treeObj.scrollLeft()+10);
						}
						//Ŀ��ڵ��ڿ���������࣬�Զ��ƶ����������
						if (tmpTarget && tmpTarget != targetSetting.treeObj && tmpTarget.offset().left < targetSetting.treeObj.offset().left) {
							targetSetting.treeObj.scrollLeft(targetSetting.treeObj.scrollLeft()+ tmpTarget.offset().left - targetSetting.treeObj.offset().left);
						}
					}
					
					curNode.css({
						"top": (event.clientY + docScrollTop + 3) + "px",
						"left": (event.clientX + docScrollLeft + 3) + "px"
					});
					
					var dX = 0;
					var dY = 0;
					if (tmpTarget && tmpTarget.attr("id")!=targetSetting.treeObjId) {
						var tmpTargetNode = tmpTargetNodeId == null ? null: getTreeNodeByTId(targetSetting, tmpTargetNodeId);
						var tmpNodeObj = $("#" + treeNode.tId);
						var isPrev = (tmpNodeObj.prev().attr("id") == tmpTargetNodeId) ;
						var isNext = (tmpNodeObj.next().attr("id") == tmpTargetNodeId) ;
						var isInner = (treeNode.parentNode && treeNode.parentNode.tId == tmpTargetNodeId) ;
						
						var canPrev = !isNext;
						var canNext = !isPrev;
						var canInner = !isInner && !(targetSetting.keepLeaf && !tmpTargetNode.isParent);
						var prevPercent = canPrev ? (canInner ? 0.25 : (canNext ? 0.5 : 1) ) : -1;
						var nextPercent = canNext ? (canInner ? 0.75 : (canPrev ? 0.5 : 0) ) : -1;
						
						
						var tmpTargetA = $("#" + tmpTargetNodeId + IDMark_A, tmpTarget);
						var dY_percent = (event.clientY + docScrollTop - tmpTargetA.offset().top)/tmpTargetA.height();
						
						if ((prevPercent==1 ||dY_percent<=prevPercent && dY_percent>=-.2) && canPrev) {
							dX = 1 - tmpArrow.width();
							dY = 0 - tmpArrow.height()/2;
							moveType = MoveType_Before;
						} else if ((nextPercent==0 || dY_percent>=nextPercent && dY_percent<=1.2) && canNext) {
							dX = 1 - tmpArrow.width();
							dY = tmpTargetA.height() - tmpArrow.height()/2;
							moveType = MoveType_After;
						} else {
							dX = 5 - tmpArrow.width();
							dY = 0;
							moveType = MoveType_Inner;
						}
						tmpArrow.css({
							"display":"block",
							"top": (tmpTargetA.offset().top + dY) + "px",
							"left": (tmpTargetA.offset().left + dX) + "px"
						});
						
						if (preTmpTargetNodeId != tmpTargetNodeId || preTmpMoveType != moveType) {
							startTime = (new Date()).getTime();
						}
						if (moveType == MoveType_Inner) {
							window.moveTimer = setTimeout(function() {
								if (moveType != MoveType_Inner) return;
								var targetNode = getTreeNodeByTId(targetSetting, tmpTargetNodeId);
								if (targetNode && targetNode.isParent && !targetNode.open && (new Date()).getTime() - startTime > 500) {
									switchNode(targetSetting, targetNode);
								}
							}, 600);
						}
					} else {
						moveType = MoveType_Inner;
						tmpArrow.css({"display":"none"});
						if (window.moveTimer) {clearTimeout(window.moveTimer);}
					}
					preTmpTargetNodeId = tmpTargetNodeId;
					preTmpMoveType = moveType;
				}
				return false;
			});

			$(doc).mouseup(function(event) {
				if (this.moveTimer) {clearTimeout(this.moveTimer);}
				preTmpTargetNodeId = null;
				preTmpMoveType = null;
				$(doc).unbind("mousemove");
				$(doc).unbind("mouseup");
				$("body").css("cursor", "auto");
				if (tmpTarget) {
					tmpTarget.removeClass(Class_TmpTargetTree);
					if (tmpTargetNodeId) $("#" + tmpTargetNodeId + IDMark_A, tmpTarget).removeClass(Class_TmpTargetNode);
				}
				showIfameMask(false);

				if (setting.dragStatus == 0) return;
				setting.dragStatus = 0;

				if (treeNode.isParent && setting.dragNodeShowBefore && !treeNode.open) {
					expandAndCollapseNode(setting, treeNode, !treeNode.open);
					setting.dragNodeShowBefore = false;
				}

				if (curNode) curNode.remove();
				if (tmpArrow) tmpArrow.remove();

				//��ʾ���� �ƶ���Ľڵ�
				if (tmpTarget && tmpTargetNodeId && treeNode.parentNode && tmpTargetNodeId==treeNode.parentNode.tId && moveType == MoveType_Inner) {
					tmpTarget = null;
				}
				if (tmpTarget) {
					var dragTargetNode = tmpTargetNodeId == null ? null: getTreeNodeByTId(targetSetting, tmpTargetNodeId);
					var beforeDrop = true;
					if ((typeof targetSetting.callback.beforeDrop) == "function") beforeDrop = targetSetting.callback.beforeDrop(targetSetting.treeObjId, treeNode, dragTargetNode, moveType);
					if (beforeDrop == false) return;
					
					if (isOtherTree) {
						removeTreeNode(setting, treeNode);
						addTreeNodes(targetSetting, null, [treeNode], false);
						moveTreeNode(targetSetting, dragTargetNode, treeNode, moveType);
						selectNode(targetSetting, treeNode);
					} else {
						moveTreeNode(targetSetting, dragTargetNode, treeNode, moveType);
					}
					$("#" + treeNode.tId + IDMark_Icon).focus().blur();
					
					//���� DROP ��ק�¼���������ק��Ŀ�����ݶ���
					setting.treeObj.trigger(ZTREE_DROP, [targetSetting.treeObjId, treeNode, dragTargetNode, moveType]);

				} else {
					//���� DROP ��ק�¼�������null
					setting.treeObj.trigger(ZTREE_DROP, [setting.treeObjId, null, null, null]);
				}
			});
			
			//��ֹĬ���¼�ר�����ڴ��� FireFox ��Bug��
			//�� Bug ������� zTree Div CSS �д��� overflow ���ã�����ק�ڵ��Ƴ� zTree ʱ���޷��õ���ȷ��event.target
			if(eventMouseDown.preventDefault) {
				eventMouseDown.preventDefault();
		    }
		});
		
		if ((typeof setting.addDiyDom) == "function") {
			setting.addDiyDom(setting.treeObjId, treeNode);
		}
		//����nodeCreated�¼�
		setting.treeObj.trigger(ZTREE_NODECREATED, [setting.treeObjId, treeNode]);
	}

	//��ȡ����ľ�������
	function getAbsPoint(obj) {
		var r = new Array(2);
		oRect = obj.getBoundingClientRect();
		r[0] = oRect.left;
		r[1] = oRect.top;
		return r;
	}
	
	//���ù��λ�ú���
	function setCursorPosition(obj, pos){
		if(obj.setSelectionRange) {
			obj.focus();
			obj.setSelectionRange(pos,pos);
		} else if (obj.createTextRange) {
			var range = obj.createTextRange();
			range.collapse(true);
			range.moveEnd('character', pos);
			range.moveStart('character', pos);
			range.select();
		}
	}

	var dragMaskList = new Array();
	//��ʾ������ Iframe�����ֲ㣨��Ҫ���ڱ�����ק��������
	function showIfameMask(showSign) {
		//�����������
		while (dragMaskList.length > 0) {
			dragMaskList[0].remove();
			dragMaskList.shift();
		}
		if (showSign) {
			//��ʾ����
			var iframeList = $("iframe");
			for (var i = 0; i < iframeList.length; i++) {
				var obj = iframeList.get(i);
				var r = getAbsPoint(obj);
				var dragMask = $("<div id='zTreeMask_" + i + "' class='zTreeMask' style='top:" + r[1] + "px; left:" + r[0] + "px; width:" + obj.offsetWidth + "px; height:" + obj.offsetHeight + "px;'></div>");
				dragMask.appendTo("body");
				dragMaskList.push(dragMask);
			}
		}
	}
	
	//����Name
	function setNodeName(setting, treeNode) {
		var nObj = $("#" + treeNode.tId + IDMark_Span);
		nObj.text(treeNode[setting.nameCol]);
	}
	//����Target
	function setNodeTarget(treeNode) {
		var aObj = $("#" + treeNode.tId + IDMark_A);
		aObj.attr("target", (treeNode.target || "_blank"));
	}
	//����URL
	function setNodeUrl(setting, treeNode) {
		var aObj = $("#" + treeNode.tId + IDMark_A);
		if (treeNode.url && !setting.editable) aObj.attr("href", treeNode.url);
		else aObj.removeAttr("href");
	}
	//����Line��Ico��css����
	function setNodeLineIcos(setting, treeNode) {
		if (!treeNode) return;
		var switchObj = $("#" + treeNode.tId + IDMark_Switch);
		var aObj = $("#" + treeNode.tId + IDMark_A);
		var ulObj = $("#" + treeNode.tId + IDMark_Ul);
		var icoObj = $("#" + treeNode.tId + IDMark_Icon);
		
		switchObj.attr("class", "switch");
		if (setting.showLine) {
			if (treeNode.level == 0 && treeNode.isFirstNode && treeNode.isLastNode) {
				switchObj.attr("class", "switch_" + LineMark_Root);
			} else if (treeNode.level == 0 && treeNode.isFirstNode) {
				switchObj.attr("class", "switch_" + LineMark_Roots);
			} else if (treeNode.isLastNode) {
				switchObj.attr("class", "switch_" + LineMark_Bottom);
			} else {
				switchObj.attr("class", "switch_" + LineMark_Center);
			}
			if (treeNode.isLastNode) {
				ulObj.removeClass(LineMark_Line);
			} else {
				ulObj.addClass(LineMark_Line);
			}
		} else {
			switchObj.attr("class", "switch_" + LineMark_NoLine);
		}
		
		var tmpOpen = (treeNode.open ? ("_" + FolderMark_Open) : ("_" + FolderMark_Close));
		switchObj.attr("class", treeNode.isParent ? (switchObj.attr("class") + tmpOpen) : (switchObj.attr("class") + "_" + FolderMark_Docu));

		if (!treeNode.isAjaxing) {
			icoObj.attr("class", (treeNode.iconSkin ? treeNode.iconSkin : ""));
			icoObj.addClass(treeNode.isParent ? ("ico" + tmpOpen) : ("ico_" + FolderMark_Docu));
			var icoStyle = "";
			if (treeNode.icon) icoStyle += "background:url(" + treeNode.icon + ") 0 0 no-repeat;";
			if (setting.showIcon == false || ((typeof setting.showIcon) == "function" && !setting.showIcon(setting.treeObjId, treeNode))) {
				icoStyle += "width:0px;height:0px;";
			}
			if (icoStyle != "")	icoObj.attr("style", icoStyle);
			else icoObj.attr("style", "");
		}

	}
	//�����Զ���������ʽ
	function setNodeFontCss(setting, treeNode) {
		var aObj = $("#" + treeNode.tId + IDMark_A);
		var fontCss = {};
		if ((typeof setting.fontCss) == "function") {
			fontCss = setting.fontCss(setting.treeObjId, treeNode);
		} else {
			fontCss = setting.fontCss;
		}
		if (fontCss) {
			aObj.css(fontCss);
		}
	}

	//����button�滻class ƴ���ַ���
	function replaceSwitchClass(obj, newName) {
		if (!obj) return;

		var tmpName = obj.attr("class");
		if (tmpName == undefined) return;
		var tmpList = tmpName.split("_");
		switch (newName) {
		case LineMark_Root:
		case LineMark_Roots:
		case LineMark_Center:
		case LineMark_Bottom:
		case LineMark_NoLine:
			tmpList[1] = newName;
			break;
		case FolderMark_Open:
		case FolderMark_Close:
		case FolderMark_Docu:
			tmpList[2] = newName;
			break;
		}

		obj.attr("class", tmpList.join("_"));
	}
	function replaceIcoClass(treeNode, obj, newName) {
		if (!obj || treeNode.isAjaxing) return;

		var tmpName = obj.attr("class");
		if (tmpName == undefined) return;
		var tmpList = tmpName.split("_");
		switch (newName) {
		case FolderMark_Open:
		case FolderMark_Close:
		case FolderMark_Docu:
			tmpList[1] = newName;
			break;
		}

		obj.attr("class", tmpList.join("_"));
	}
	
	//���zTree�İ�ť�ؼ�
	function addTreeDom(setting, treeNode) {
		if (setting.dragStatus == 0) {
			treeNode.isHover = true;
			if (setting.editable) {
				addEditBtn(setting, treeNode);
				addRemoveBtn(setting, treeNode);
			}
			if ((typeof setting.addHoverDom) == "function") {
				setting.addHoverDom(setting.treeObjId, treeNode);
			}
		}
	}
	//ɾ��zTree�İ�ť�ؼ�
	function removeTreeDom(setting, treeNode) {
		treeNode.isHover = false;
		removeEditBtn(treeNode); 
		removeRemoveBtn(treeNode); 
		if ((typeof setting.removeHoverDom) == "function") {
			setting.removeHoverDom(setting.treeObjId, treeNode);
		}
	}
	//ɾ�� �༭��ɾ����ť
	function removeEditBtn(treeNode) {		
		$("#" + treeNode.tId + IDMark_Edit).unbind().remove();
	}
	function removeRemoveBtn(treeNode) {		
		$("#" + treeNode.tId + IDMark_Remove).unbind().remove();
	}
	function addEditBtn(setting, treeNode) {
		if (treeNode.editNameStatus || $("#" + treeNode.tId + IDMark_Edit).length > 0) {
			return;
		}
		var showEdit_RenameBtn = setting.edit_renameBtn;
		if (typeof setting.edit_renameBtn == "function") {
			showEdit_RenameBtn = setting.edit_renameBtn(treeNode);
		}
		if (!showEdit_RenameBtn) {
			return;
		}

		var aObj = $("#" + treeNode.tId + IDMark_A);
		var nObj = $("#" + treeNode.tId + IDMark_Span);
		var editStr = "<button type='button' class='edit' id='" + treeNode.tId + IDMark_Edit + "' title='' onfocus='this.blur();' style='display:none;'></button>";
		nObj.after(editStr);
		
		var editBtnObj = $("#" + treeNode.tId + IDMark_Edit);
//		var right = (setting.treeObj.offset().left+ setting.treeObj.width() + setting.treeObj.scrollLeft() - aObj.offset().left - aObj.width() - 2*editBtnObj.width() - 15);
//		if (right < 0) {
//			//����ڵ㴦��tree�����Ҳ࣬Ϊ�����޷�����������ť�����������ʾ
//			editBtnObj.remove();
//			aObj.prepend(editStr);
//			editBtnObj = $("#" + treeNode.tId + IDMark_Edit);
//		}
		editBtnObj.bind('click', 
			function() {
				var beforeRename = true;
				if ((typeof setting.callback.beforeRename) == "function") beforeRename = setting.callback.beforeRename(setting.treeObjId, treeNode);
				if (beforeRename == false) return;
				removeTreeDom(setting, treeNode);
				editTreeNode(setting, treeNode);
				return false;
			}
		).bind('mousedown',
			function(eventMouseDown) {return true;}
		).show();
	}
	function addRemoveBtn(setting, treeNode) {		
		if (!setting.edit_removeBtn || $("#" + treeNode.tId + IDMark_Remove).length > 0) {
			return;
		}
		var showEdit_RemoveBtn = setting.edit_removeBtn;
		if (typeof setting.edit_removeBtn == "function") {
			showEdit_RemoveBtn = setting.edit_removeBtn(treeNode);
		}
		if (!showEdit_RemoveBtn) {
			return;
		}
		
		var aObj = $("#" + treeNode.tId + IDMark_A);
		var removeStr = "<button type='button' class='remove' id='" + treeNode.tId + IDMark_Remove + "' title='' onfocus='this.blur();' style='display:none;'></button>";
		aObj.append(removeStr);
		
		var removeBtnObj = $("#" + treeNode.tId + IDMark_Remove);
//		var right = (setting.treeObj.offset().left + setting.treeObj.width() - aObj.offset().left - aObj.width() - 1*removeBtnObj.width() - 15);
//		if (right < 0) {
//			//����ڵ㴦��tree�����Ҳ࣬Ϊ�����޷�����������ť�����������ʾ
//			removeBtnObj.remove();
//			aObj.prepend(removeStr);
//			removeBtnObj = $("#" + treeNode.tId + IDMark_Remove);
//		}
		
		$("#" + treeNode.tId + IDMark_Remove).bind('click', 
			function() {
				var beforeRemove = true;
				if ((typeof setting.callback.beforeRemove) == "function") beforeRemove = setting.callback.beforeRemove(setting.treeObjId, treeNode);
				if (beforeRemove == false) return;
				removeTreeNode(setting, treeNode);
				//����remove�¼�
				setting.treeObj.trigger(ZTREE_REMOVE, [setting.treeObjId, treeNode]);
				return false;
			}
		).bind('mousedown',
			function(eventMouseDown) {return true;}
		).show();
	}
	
	//����check�󣬸��ӽڵ�������ϵ
	function checkNodeRelation(setting, treeNode) {
		if (setting.checkStyle == Check_Style_Radio) {
			if (treeNode[setting.checkedCol]) {
				if (setting.checkRadioType == Radio_Type_All) {
					for (var i = setting.checkRadioCheckedList.length-1; i >= 0; i--) {
						var pNode = setting.checkRadioCheckedList[i];
						pNode[setting.checkedCol] = false;
						setting.checkRadioCheckedList.splice(i, 1);
						
						setChkClass(setting, $("#" + pNode.tId + IDMark_Check), pNode);
						if (pNode.parentNode != treeNode.parentNode) {
							repairParentChkClassWithSelf(setting, pNode);
						}
					}
					setting.checkRadioCheckedList = setting.checkRadioCheckedList.concat([treeNode]);
				} else {
					var parentNode = (treeNode.parentNode) ? treeNode.parentNode : setting.root;
					for (var son = 0; son < parentNode[setting.nodesCol].length; son++) {
						var pNode = parentNode[setting.nodesCol][son];
						if (pNode[setting.checkedCol] && pNode != treeNode) {
							pNode[setting.checkedCol] = false;
							setChkClass(setting, $("#" + pNode.tId + IDMark_Check), pNode);
						}
					}
				}
			} else if (setting.checkRadioType == Radio_Type_All) {
				for (var i = 0; i < setting.checkRadioCheckedList.length; i++) {
					if (treeNode == setting.checkRadioCheckedList[i]) {
						setting.checkRadioCheckedList.splice(i, 1);
						break;
					}
				}
			}
			
		} else {
			if (treeNode[setting.checkedCol] && setting.checkType.Y.indexOf("s") > -1) {
				setSonNodeCheckBox(setting, treeNode, true);
				repairSonChkClass(setting, treeNode);
			}
			if (treeNode[setting.checkedCol] && setting.checkType.Y.indexOf("p") > -1) {
				setParentNodeCheckBox(setting, treeNode, true);
			}
			if (!treeNode[setting.checkedCol] && setting.checkType.N.indexOf("s") > -1) {
				setSonNodeCheckBox(setting, treeNode, false);
				repairSonChkClass(setting, treeNode);
			}
			if (!treeNode[setting.checkedCol] && setting.checkType.N.indexOf("p") > -1) {
				setParentNodeCheckBox(setting, treeNode, false);
			}
		}
	}
	
	//����CheckBox��Class���ͣ���Ҫ������ʾ�ӽڵ��Ƿ�ȫ����ѡ�����ʽ
	function setChkClass(setting, obj, treeNode) {
		if (!obj) return;
		obj.removeClass();
		var chkName = setting.checkStyle + "_" + (treeNode[setting.checkedCol] ? CheckBox_True : CheckBox_False)
			+ "_" + ((treeNode[setting.checkedCol] || setting.checkStyle == Check_Style_Radio) ? (treeNode.check_True_Full? CheckBox_Full:CheckBox_Part) : (treeNode.check_False_Full? CheckBox_Full:CheckBox_Part) );
		chkName = treeNode.checkboxFocus ? chkName + "_" + CheckBox_Focus : chkName;
		obj.addClass(CheckBox_Default);
		obj.addClass(chkName);
	}
	function repairAllChk(setting, checked) {
		if (setting.checkable) {
			for (var son = 0; son < setting.root[setting.nodesCol].length; son++) {
				var treeNode = setting.root[setting.nodesCol][son];
				treeNode[setting.checkedCol] = checked;
				checkNodeRelation(setting, treeNode);
				var checkObj = $("#" + treeNode.tId + IDMark_Check);
				setChkClass(setting, checkObj, treeNode);
				repairParentChkClassWithSelf(setting, treeNode);
			}
		}
	}
	//�������ڵ�ѡ�����ʽ
	function repairParentChkClass(setting, treeNode) {
		if (!treeNode || !treeNode.parentNode) return;
		repairChkClass(setting, treeNode.parentNode);
		repairParentChkClass(setting, treeNode.parentNode);
	}	
	function repairParentChkClassWithSelf(setting, treeNode) {
		if (treeNode[setting.nodesCol] && treeNode[setting.nodesCol].length > 0) {
			repairParentChkClass(setting, treeNode[setting.nodesCol][0]);
		} else {
			repairParentChkClass(setting, treeNode);
		}
	}
	//�����ӽڵ�ѡ�����ʽ
	function repairSonChkClass(setting, treeNode) {
		if (!treeNode || !treeNode[setting.nodesCol]) return;
		for (var son = 0; son < treeNode[setting.nodesCol].length; son++) {
			if (treeNode[setting.nodesCol][son][setting.nodesCol]) {
				repairSonChkClass(setting, treeNode[setting.nodesCol][son]);
			}
		}
		repairChkClass(setting, treeNode);
	}	
	function repairChkClass(setting, treeNode) {
		if (!treeNode) return;
		var trueSign = true;
		var falseSign = true;
		if (treeNode[setting.nodesCol]) {
			for (var son = 0; son < treeNode[setting.nodesCol].length; son++) {
				if (setting.checkStyle == Check_Style_Radio && (treeNode[setting.nodesCol][son][setting.checkedCol] || !treeNode[setting.nodesCol][son].check_True_Full)) {
					trueSign = false;
				} else if (setting.checkStyle != Check_Style_Radio && treeNode[setting.checkedCol] && (!treeNode[setting.nodesCol][son][setting.checkedCol] || !treeNode[setting.nodesCol][son].check_True_Full)) {
					trueSign = false;
				} else if (setting.checkStyle != Check_Style_Radio && !treeNode[setting.checkedCol] && (treeNode[setting.nodesCol][son][setting.checkedCol] || !treeNode[setting.nodesCol][son].check_False_Full)) {
					falseSign = false;
				}
				if (!trueSign || !falseSign) break;
			}
		}
		treeNode.check_True_Full = trueSign;
		treeNode.check_False_Full = falseSign;
		var checkObj = $("#" + treeNode.tId + IDMark_Check);
		setChkClass(setting, checkObj, treeNode);
	}

	//���չ�����۵��ڵ�
	function onSwitchNode(event) {
		var setting = settings[event.data.treeObjId];
		var treeNode = event.data.treeNode;
		
		if (treeNode.open) {
			var beforeCollapse = true;
			if ((typeof setting.callback.beforeCollapse) == "function") beforeCollapse = setting.callback.beforeCollapse(setting.treeObjId, treeNode);
			if (beforeCollapse == false) return;
			setting.expandTriggerFlag = true;
			switchNode(setting, treeNode);
		} else {
			var beforeExpand = true;
			if ((typeof setting.callback.beforeExpand) == "function") beforeExpand = setting.callback.beforeExpand(setting.treeObjId, treeNode);
			if (beforeExpand == false) return;
			setting.expandTriggerFlag = true;
			switchNode(setting, treeNode);
		}
	}

	function switchNode(setting, treeNode) {
		if (treeNode.open || (treeNode && treeNode[setting.nodesCol] && treeNode[setting.nodesCol].length > 0)) {
			expandAndCollapseNode(setting, treeNode, !treeNode.open);
		} else if (setting.async) {
			var beforeAsync = true;
			if ((typeof setting.callback.beforeAsync) == "function") beforeAsync = setting.callback.beforeAsync(setting.treeObjId, treeNode);
			if (beforeAsync == false) {
				expandAndCollapseNode(setting, treeNode, !treeNode.open);
				return;
			}
			
			asyncGetNode(setting, treeNode);
		} else if (treeNode) {
			expandAndCollapseNode(setting, treeNode, !treeNode.open);
		}
	}

	function asyncGetNode(setting, treeNode) {
		if (treeNode && (treeNode.isAjaxing || !treeNode.isParent)) {
			return;
		}
		if (treeNode) {
			treeNode.isAjaxing = true;
			var icoObj = $("#" + treeNode.tId + IDMark_Icon);
			icoObj.attr("class", "ico_loading");
		}

		var tmpParam = "";
		for (var i = 0; treeNode && i < setting.asyncParam.length; i++) {
			tmpParam += (tmpParam.length > 0 ? "&": "") + setting.asyncParam[i] + "=" + treeNode[setting.asyncParam[i]];
		}
		if (Object.prototype.toString.apply(setting.asyncParamOther) === "[object Array]") {
			for (var i = 0; i < setting.asyncParamOther.length; i += 2) {
				tmpParam += (tmpParam.length > 0 ? "&": "") + setting.asyncParamOther[i] + "=" + setting.asyncParamOther[i + 1];
			}
		} else {
			for (var p in setting.asyncParamOther) {
	            tmpParam += (tmpParam.length > 0 ? "&" : "") + p + "=" + setting.asyncParamOther[p];
			}
		}
		
		var url = setting.asyncUrl;
		if (typeof setting.asyncUrl == "function") {
			url =  setting.asyncUrl(treeNode);
		}

		$.ajax({
			type: "POST",
			url: url,
			data: tmpParam,
			success: function(msg) {
				var newNodes = [];
				try {
					if (!msg || msg.length == 0) {
						newNodes = [];
					} else if (typeof msg == "string") {
						newNodes = eval("(" + msg + ")");
					} else {
						newNodes = msg;
					}
				} catch(err) {}
				
				if (treeNode) treeNode.isAjaxing = undefined;
				setNodeLineIcos(setting, treeNode);
				if (newNodes && newNodes != "") {
					addTreeNodes(setting, treeNode, newNodes, false);
				} else {
					addTreeNodes(setting, treeNode, [], false);
				}
				setting.treeObj.trigger(ZTREE_ASYNC_SUCCESS, [setting.treeObjId, treeNode, msg]);

			},
			error: function(XMLHttpRequest, textStatus, errorThrown) {
				setting.expandTriggerFlag = false;
				setNodeLineIcos(setting, treeNode);
				if (treeNode) treeNode.isAjaxing = undefined;
				setting.treeObj.trigger(ZTREE_ASYNC_ERROR, [setting.treeObjId, treeNode, XMLHttpRequest, textStatus, errorThrown]);
			}
		});
	}

	// չ�� ���� �۵� �ڵ��¼�
	function expandAndCollapseNode(setting, treeNode, expandSign, animateSign, callback) {
		if (!treeNode || treeNode.open == expandSign) {
			if (typeof callback == "function") callback();
			return;
		}
		
		if (setting.expandTriggerFlag) {
			callback = function(){
				if (treeNode.open) {
					//����expand�¼�
					setting.treeObj.trigger(ZTREE_EXPAND, [setting.treeObjId, treeNode]);
				} else {
					//����collapse�¼�
					setting.treeObj.trigger(ZTREE_COLLAPSE, [setting.treeObjId, treeNode]);
				}
			};
			setting.expandTriggerFlag = false;
		}
		
		var switchObj = $("#" + treeNode.tId + IDMark_Switch);
		var icoObj = $("#" + treeNode.tId + IDMark_Icon);
		var ulObj = $("#" + treeNode.tId + IDMark_Ul);

		if (treeNode.isParent) {
			if (!treeNode.open) {
				replaceSwitchClass(switchObj, FolderMark_Open);
				replaceIcoClass(treeNode, icoObj, FolderMark_Open);
				treeNode.open = true;
				if (animateSign == false || setting.expandSpeed == "") {
					ulObj.show();
					if (typeof callback == "function") callback();
				} else {
					if (treeNode[setting.nodesCol] && treeNode[setting.nodesCol].length > 0) {
						ulObj.show(setting.expandSpeed, callback);
					} else {
						ulObj.show();
						if (typeof callback == "function") callback();
					}
				}
			} else {
				replaceSwitchClass(switchObj, FolderMark_Close);
				replaceIcoClass(treeNode, icoObj, FolderMark_Close);
				treeNode.open = false;
				if (animateSign == false || setting.expandSpeed == "") {
					ulObj.hide();
					if (typeof callback == "function") callback();
				} else {
					ulObj.hide(setting.expandSpeed, callback);
				}
			}
		} else {
			if (typeof callback == "function") callback();
		}
	}

	//�����ӽڵ�չ�� �� �۵�
	function expandCollapseSonNode(setting, treeNode, expandSign, animateSign, callback) {
		var treeNodes = (treeNode) ? treeNode[setting.nodesCol]: setting.root[setting.nodesCol];
		
		//��Զ��������Ż�,һ����˵ֻ���ڵ�һ���ʱ�򣬲Ž��ж���Ч��
		var selfAnimateSign = (treeNode) ? false : animateSign;
		if (treeNodes) {
			for (var son = 0; son < treeNodes.length; son++) {
				if (treeNodes[son]) expandCollapseSonNode(setting, treeNodes[son], expandSign, selfAnimateSign);
			}
		}
		//��֤callbackִֻ��һ��
		expandAndCollapseNode(setting, treeNode, expandSign, animateSign, callback );

	}

	//�������ڵ�չ�� �� �۵�
	function expandCollapseParentNode(setting, treeNode, expandSign, animateSign, callback) {
		//��Զ��������Ż�,һ����˵ֻ���ڵ�һ���ʱ�򣬲Ž��ж���Ч��
		if (!treeNode) return;
		if (!treeNode.parentNode) {
			//��֤callbackִֻ��һ��
			expandAndCollapseNode(setting, treeNode, expandSign, animateSign, callback);
			return ;
		} else {
			expandAndCollapseNode(setting, treeNode, expandSign, animateSign);
		}
		
		if (treeNode.parentNode) {
			expandCollapseParentNode(setting, treeNode.parentNode, expandSign, animateSign, callback);
		}
	}

	//�������ڵ�����checkbox
	function setParentNodeCheckBox(setting, treeNode, value) {
		var checkObj = $("#" + treeNode.tId + IDMark_Check);
		treeNode[setting.checkedCol] = value;
		setChkClass(setting, checkObj, treeNode);
		if (treeNode.parentNode) {
			var pSign = true;
			if (!value) {
				for (var son = 0; son < treeNode.parentNode[setting.nodesCol].length; son++) {
					if (treeNode.parentNode[setting.nodesCol][son][setting.checkedCol]) {
						pSign = false;
						break;
					}
				}
			}
			if (pSign) {
				setParentNodeCheckBox(setting, treeNode.parentNode, value);
			}
		}
	}

	//�����ӽڵ�����checkbox
	function setSonNodeCheckBox(setting, treeNode, value) {
		if (!treeNode) return;
		var checkObj = $("#" + treeNode.tId + IDMark_Check);
		
		if (treeNode != setting.root) {
			treeNode[setting.checkedCol] = value;
			setChkClass(setting, checkObj, treeNode);
		}
		
		if (!treeNode[setting.nodesCol]) return;
		for (var son = 0; son < treeNode[setting.nodesCol].length; son++) {
			if (treeNode[setting.nodesCol][son]) setSonNodeCheckBox(setting, treeNode[setting.nodesCol][son], value);
		}
	}

	//�����ӽڵ�����level,��Ҫ�����ƶ��ڵ��Ĵ���
	function setSonNodeLevel(setting, parentNode, treeNode) {
		if (!treeNode) return;
		treeNode.level = (parentNode)? parentNode.level + 1 : 0;
		if (!treeNode[setting.nodesCol]) return;
		for (var son = 0; son < treeNode[setting.nodesCol].length; son++) {
			if (treeNode[setting.nodesCol][son]) setSonNodeLevel(setting, treeNode, treeNode[setting.nodesCol][son]);
		}
	}

	//�����ӽڵ�
	function addTreeNodes(setting, parentNode, newNodes, isSilent) {
		if (setting.keepLeaf && parentNode && !parentNode.isParent) {
			return;
		}
		if (setting.isSimpleData) {
			newNodes = transformTozTreeFormat(setting, newNodes);
		}
		if (parentNode) {
			//Ŀ��ڵ�����ڵ�ǰ����
			if (setting.treeObj.find("#" + parentNode.tId).length == 0) return;

			target_switchObj = $("#" + parentNode.tId + IDMark_Switch);
			target_icoObj = $("#" + parentNode.tId + IDMark_Icon);
			target_aObj = $("#" + parentNode.tId + IDMark_A);
			target_ulObj = $("#" + parentNode.tId + IDMark_Ul);

			//����ڵ���Ŀ��ڵ��ͼƬ����
			if (!parentNode.open) {
				replaceSwitchClass(target_switchObj, FolderMark_Close);
				replaceIcoClass(parentNode, target_icoObj, FolderMark_Close);			
				parentNode.open = false;
				target_ulObj.css({
					"display": "none"
				});
			}
			
			//���Ŀ��ڵ㲻�Ǹ��ڵ㣬�������ڵ�չ�����ر��¼�
			if (!parentNode.isParent) {
				target_switchObj.unbind('click');
				target_switchObj.bind('click', {
					treeObjId: setting.treeObjId,
					treeNode: parentNode
				},
				onSwitchNode);
				target_aObj.unbind('dblclick');
				target_aObj.bind('dblclick', {
					treeObjId: setting.treeObjId,
					treeNode: parentNode
				},
				onSwitchNode);
			}

			addTreeNodesData(setting, parentNode, newNodes);
			initTreeNodes(setting, parentNode.level + 1, newNodes, parentNode);
			//���ѡ��ĳ�ڵ㣬�����չ����ȫ�����ڵ�
			if (!isSilent) {
				expandCollapseParentNode(setting, parentNode, true);
			}
		} else {
			addTreeNodesData(setting, setting.root, newNodes);
			initTreeNodes(setting, 0, newNodes, null);
		}
	}

	//���ӽڵ�����
	function addTreeNodesData(setting, parentNode, treenodes) {
		if (!parentNode[setting.nodesCol]) parentNode[setting.nodesCol] = [];
		if (parentNode[setting.nodesCol].length > 0) {
			parentNode[setting.nodesCol][parentNode[setting.nodesCol].length - 1].isLastNode = false;
			setNodeLineIcos(setting, parentNode[setting.nodesCol][parentNode[setting.nodesCol].length - 1]);
		}
		parentNode.isParent = true;
		parentNode[setting.nodesCol] = parentNode[setting.nodesCol].concat(treenodes);
	}

	//�ƶ��ӽڵ�
	function moveTreeNode(setting, targetNode, treeNode, moveType, animateSign) {
		if (targetNode == treeNode) return;
		if (setting.keepLeaf && targetNode && !targetNode.isParent && moveType == MoveType_Inner) return;
		var oldParentNode = treeNode.parentNode == null ? setting.root: treeNode.parentNode;
		
		var targetNodeIsRoot = (targetNode === null || targetNode == setting.root);
		if (targetNodeIsRoot && targetNode === null) targetNode = setting.root;
		if (targetNodeIsRoot) moveType = MoveType_Inner;
		var targetParentNode = (targetNode.parentNode ? targetNode.parentNode : setting.root);

		if (moveType != MoveType_Before && moveType != MoveType_After) {
			moveType = MoveType_Inner;
		}
		
		//�������ݽṹ����
		var tmpSrcIndex = -1;
		var tmpTargetIndex = 0;
		var oldNeighbor = null;
		var newNeighbor = null;
		if (treeNode.isFirstNode) {
			tmpSrcIndex = 0;
			if (oldParentNode[setting.nodesCol].length > 1 ) {
				oldNeighbor = oldParentNode[setting.nodesCol][1];
				oldNeighbor.isFirstNode = true;
			}
		} else if (treeNode.isLastNode) {
			tmpSrcIndex = oldParentNode[setting.nodesCol].length -1;
			oldNeighbor = oldParentNode[setting.nodesCol][tmpSrcIndex - 1];
			oldNeighbor.isLastNode = true;
		} else {
			for (var i = 0; i < oldParentNode[setting.nodesCol].length; i++) {
				if (oldParentNode[setting.nodesCol][i].tId == treeNode.tId) tmpSrcIndex = i;
			}
		}
		if (tmpSrcIndex >= 0) {
			oldParentNode[setting.nodesCol].splice(tmpSrcIndex, 1);
		}
		if (moveType != MoveType_Inner) {
			for (var i = 0; i < targetParentNode[setting.nodesCol].length; i++) {
				if (targetParentNode[setting.nodesCol][i].tId == targetNode.tId) tmpTargetIndex = i;
			}
		}
		var targetIsNewParent = false;
		if (moveType == MoveType_Inner) {
			if (targetNodeIsRoot) {
				//��Ϊ���ڵ㣬�򲻲���Ŀ��ڵ�����
				treeNode.parentNode = null;
			} else {
				targetIsNewParent = !targetNode.isParent;
				targetNode.isParent = true;
				treeNode.parentNode = targetNode;
			}
			
			if (!targetNode[setting.nodesCol]) targetNode[setting.nodesCol] = new Array();
			if (targetNode[setting.nodesCol].length > 0) {
				newNeighbor = targetNode[setting.nodesCol][targetNode[setting.nodesCol].length - 1];
				newNeighbor.isLastNode = false;
			}
			targetNode[setting.nodesCol].splice(targetNode[setting.nodesCol].length, 0, treeNode);
			treeNode.isLastNode = true;
			treeNode.isFirstNode = (targetNode[setting.nodesCol].length == 1);
		} else if (targetNode.isFirstNode && moveType == MoveType_Before) {
			targetParentNode[setting.nodesCol].splice(tmpTargetIndex, 0, treeNode);
			newNeighbor = targetNode;
			newNeighbor.isFirstNode = false;
			treeNode.parentNode = targetNode.parentNode;
			treeNode.isFirstNode = true;
			treeNode.isLastNode = false;
			
		} else if (targetNode.isLastNode && moveType == MoveType_After) {
			targetParentNode[setting.nodesCol].splice(tmpTargetIndex + 1, 0, treeNode);
			newNeighbor = targetNode;
			newNeighbor.isLastNode = false;
			treeNode.parentNode = targetNode.parentNode;
			treeNode.isFirstNode = false;
			treeNode.isLastNode = true;
			
		} else {
			if (moveType == MoveType_Before) {
				targetParentNode[setting.nodesCol].splice(tmpTargetIndex, 0, treeNode);
			} else {
				targetParentNode[setting.nodesCol].splice(tmpTargetIndex + 1, 0, treeNode);
			}
			treeNode.parentNode = targetNode.parentNode;
			treeNode.isFirstNode = false;
			treeNode.isLastNode = false;
		}
		fixParentKeyValue(setting, treeNode);
		
		setSonNodeLevel(setting, treeNode.parentNode, treeNode);
		
		//����HTML�ṹ����
		var src_switchObj = $("#" + treeNode.tId + IDMark_Switch);
		var src_ulObj = $("#" + treeNode.tId + IDMark_Ul);

		var targetObj;
		var target_switchObj;
		var target_icoObj;
		var target_aObj;
		var target_ulObj;

		if (targetNodeIsRoot) {
			//ת�Ƶ����ڵ�
			targetObj = setting.treeObj;
			target_ulObj = targetObj;
		} else {
			//ת�Ƶ��ӽڵ�
			targetObj = $("#" + targetNode.tId);
			target_switchObj = $("#" + targetNode.tId + IDMark_Switch);
			target_icoObj = $("#" + targetNode.tId + IDMark_Icon);
			target_aObj = $("#" + targetNode.tId + IDMark_A);
			target_ulObj = $("#" + targetNode.tId + IDMark_Ul);
		}
		
		//����Ŀ��ڵ�
		if (moveType == MoveType_Inner) {
			replaceSwitchClass(target_switchObj, FolderMark_Open);
			replaceIcoClass(targetNode, target_icoObj, FolderMark_Open);
			targetNode.open = true;
			target_ulObj.css({"display":"block"});
			//���Ŀ��ڵ㲻�Ǹ��ڵ㣬�Ҳ��Ǹ����������ڵ�չ�����ر��¼�
			if (targetIsNewParent && !targetNodeIsRoot) {
				target_switchObj.unbind('click');
				target_switchObj.bind('click',{
					treeObjId: setting.treeObjId,
					treeNode: targetNode
				},
				onSwitchNode);
				target_aObj.unbind('dblclick');
				target_aObj.bind('dblclick', {
					treeObjId: setting.treeObjId,
					treeNode: targetNode
				},
				onSwitchNode);
			}
			target_ulObj.append($("#" + treeNode.tId).detach());
		} else if (moveType == MoveType_Before) {
			targetObj.before($("#" + treeNode.tId).detach());
			
		} else if (moveType == MoveType_After) {
			targetObj.after($("#" + treeNode.tId).detach());
		}

		//�����ƶ��Ľڵ�
		setNodeLineIcos(setting, treeNode);
		
		//����ԭ�ڵ�ĸ��ڵ�
		if (!setting.keepParent && oldParentNode[setting.nodesCol].length < 1) {
			//ԭ���ڸ��ڵ����ӽڵ�
			oldParentNode.isParent = false;
			var tmp_ulObj = $("#" + oldParentNode.tId + IDMark_Ul);
			var tmp_switchObj = $("#" + oldParentNode.tId + IDMark_Switch);
			var tmp_icoObj = $("#" + oldParentNode.tId + IDMark_Icon);
			replaceSwitchClass(tmp_switchObj, FolderMark_Docu);
			replaceIcoClass(oldParentNode, tmp_icoObj, FolderMark_Docu);
			tmp_ulObj.css("display", "none");

		} else if (oldNeighbor) {
			//ԭ����λ����Ҫ��������ڽڵ�
			setNodeLineIcos(setting, oldNeighbor);
		}
		
		//����Ŀ��ڵ�����ڽڵ�
		if (newNeighbor) {
			setNodeLineIcos(setting, newNeighbor);
		}
		
		//�������ڵ�Check״̬
		if (setting.checkable) {
			repairChkClass(setting, oldParentNode);
			repairParentChkClassWithSelf(setting, oldParentNode);
			if (oldParentNode != treeNode.parent) 
				repairParentChkClassWithSelf(setting, treeNode);
		}
		
		//�ƶ��������չ����λ�õ�ȫ�����ڵ�
		expandCollapseParentNode(setting, treeNode.parentNode, true, animateSign);
	}
	
	//����pId
	function fixParentKeyValue(setting, treeNode) {
		if (setting.isSimpleData) {
			treeNode[setting.treeNodeParentKey] = treeNode.parentNode ? treeNode.parentNode[setting.treeNodeKey] : setting.rootPID;
		}
	}
	
	//�༭�ӽڵ�����
	function editTreeNode(setting, treeNode) {
		treeNode.editNameStatus = true;
		selectNode(setting, treeNode);
	}

	//ɾ���ӽڵ�
	function removeTreeNode(setting, treeNode) {
		var parentNode = treeNode.parentNode == null ? setting.root: treeNode.parentNode;
		if (setting.curTreeNode === treeNode) setting.curTreeNode = null;
		if (setting.curEditTreeNode === treeNode) setting.curEditTreeNode = null;

		$("#" + treeNode.tId).remove();

		//�������ݽṹ����
		var tmpSrcIndex = -1;
		for (var i = 0; i < parentNode[setting.nodesCol].length; i++) {
			if (parentNode[setting.nodesCol][i].tId == treeNode.tId) tmpSrcIndex = i;
		}
		if (tmpSrcIndex >= 0) {
			parentNode[setting.nodesCol].splice(tmpSrcIndex, 1);
		}

		//����ԭ�ڵ�ĸ��ڵ��ͼ�ꡢ��
		if (!setting.keepParent && parentNode[setting.nodesCol].length < 1) {
			//ԭ���ڸ��ڵ����ӽڵ�
			parentNode.isParent = false;
			parentNode.open = false;
			var tmp_ulObj = $("#" + parentNode.tId + IDMark_Ul);
			var tmp_switchObj = $("#" + parentNode.tId + IDMark_Switch);
			var tmp_icoObj = $("#" + parentNode.tId + IDMark_Icon);
			replaceSwitchClass(tmp_switchObj, FolderMark_Docu);
			replaceIcoClass(parentNode, tmp_icoObj, FolderMark_Docu);
			tmp_ulObj.css("display", "none");

		} else if (setting.showLine && parentNode[setting.nodesCol].length > 0) {
			//ԭ���ڸ��ڵ����ӽڵ�
			parentNode[setting.nodesCol][parentNode[setting.nodesCol].length - 1].isLastNode = true;
			parentNode[setting.nodesCol][parentNode[setting.nodesCol].length - 1].isFirstNode = (parentNode[setting.nodesCol].length == 1);
			var tmp_ulObj = $("#" + parentNode[setting.nodesCol][parentNode[setting.nodesCol].length - 1].tId + IDMark_Ul);
			var tmp_switchObj = $("#" + parentNode[setting.nodesCol][parentNode[setting.nodesCol].length - 1].tId + IDMark_Switch);
			var tmp_icoObj = $("#" + parentNode[setting.nodesCol][parentNode[setting.nodesCol].length - 1].tId + IDMark_Icon);
			if (parentNode == setting.root) {
				if (parentNode[setting.nodesCol].length == 1) {
					//ԭΪ���ڵ� �����ƶ���ֻ��һ�����ڵ�
					replaceSwitchClass(tmp_switchObj, LineMark_Root);
				} else {
					var tmp_first_switchObj = $("#" + parentNode[setting.nodesCol][0].tId + IDMark_Switch);
					replaceSwitchClass(tmp_first_switchObj, LineMark_Roots);
					replaceSwitchClass(tmp_switchObj, LineMark_Bottom);
				}

			} else {
				replaceSwitchClass(tmp_switchObj, LineMark_Bottom);
			}

			tmp_ulObj.removeClass(LineMark_Line);
		}
	}

	//���� tId ��ȡ �ڵ�����ݶ���
	function getTreeNodeByTId(setting, treeId) {
		return getTreeNodeByParam(setting, setting.root[setting.nodesCol], "tId", treeId);
	}
	//����Ψһ���� ��ȡ �ڵ�����ݶ���
	function getTreeNodeByParam(setting, treeNodes, key, value) {
		if (!treeNodes || !key) return null;
		for (var i = 0; i < treeNodes.length; i++) {
			if (treeNodes[i][key] == value) {
				return treeNodes[i];
			}
			var tmp = getTreeNodeByParam(setting, treeNodes[i][setting.nodesCol], key, value);
			if (tmp) return tmp;
		}
		return null;
	}
	//�������� ��ȡ �ڵ�����ݶ��󼯺�
	function getTreeNodesByParam(setting, treeNodes, key, value) {
		if (!treeNodes || !key) return [];
		var result = [];
		for (var i = 0; i < treeNodes.length; i++) {
			if (treeNodes[i][key] == value) {
				result.push(treeNodes[i]);
			}
			result = result.concat(getTreeNodesByParam(setting, treeNodes[i][setting.nodesCol], key, value));
		}
		return result;
	}
	//�������� ģ��������ȡ �ڵ�����ݶ��󼯺ϣ�����String��
	function getTreeNodesByParamFuzzy(setting, treeNodes, key, value) {
		if (!treeNodes || !key) return [];
		var result = [];
		for (var i = 0; i < treeNodes.length; i++) {
			if (typeof treeNodes[i][key] == "string" && treeNodes[i][key].indexOf(value)>-1) {
				result.push(treeNodes[i]);
			}
			result = result.concat(getTreeNodesByParamFuzzy(setting, treeNodes[i][setting.nodesCol], key, value));
		}
		return result;
	}

	//ȡ��֮ǰѡ�нڵ�״̬
	function cancelPreSelectedNode(setting) {
		if (setting.curTreeNode) {
			$("#" + setting.curTreeNode.tId + IDMark_A).removeClass(Class_CurSelectedNode);
			$("#" + setting.curTreeNode.tId + IDMark_Span).text(setting.curTreeNode[setting.nameCol]);
			removeTreeDom(setting, setting.curTreeNode);
			setting.curTreeNode = null;
		}
	}
	//ȡ��֮ǰ�༭�ڵ�״̬
	function cancelPreEditNode(setting) {
		if (setting.curEditTreeNode) {
			$("#" + setting.curEditTreeNode.tId + IDMark_A).removeClass(Class_CurSelectedNode_Edit);
			$("#" + setting.curEditTreeNode.tId + IDMark_Input).unbind();
			$("#" + setting.curEditTreeNode.tId + IDMark_Span).text(setting.curEditTreeNode[setting.nameCol]);
			setting.curEditTreeNode.editNameStatus = false;
			setting.curEditTreeNode = null;
		}
	}
	
	//���ýڵ�Ϊ��ǰѡ�нڵ�
	function selectNode(setting, treeNode) {
		if (setting.curTreeNode == treeNode && !treeNode.editNameStatus) return;
		
		cancelPreSelectedNode(setting);	
		cancelPreEditNode(setting);
			
		if (setting.editable && treeNode.editNameStatus) {
			$("#" + treeNode.tId + IDMark_Span).html("<input type=text class='rename' id='" + treeNode.tId + IDMark_Input + "'>");
			
			var inputObj = $("#" + treeNode.tId + IDMark_Input);
			inputObj.attr("value", treeNode[setting.nameCol]);
			inputObj.focus();
			setCursorPosition(inputObj.get(0), treeNode[setting.nameCol].length);
			
			//����A��click dblclick����
			inputObj.bind('blur', function(event) {
				editNameOver(this.value, setting, treeNode);
			}).bind('keypress', function(event) {
				if (event.keyCode=="13") {
					editNameOver(this.value, setting, treeNode);
				}
			}).bind('click', function(event) {
				return false;
			}).bind('dblclick', function(event) {
				return false;
			});
			
			$("#" + treeNode.tId + IDMark_A).addClass(Class_CurSelectedNode_Edit);
			setting.curEditTreeNode = treeNode;
		} else {
			$("#" + treeNode.tId + IDMark_A).addClass(Class_CurSelectedNode);
		}
		addTreeDom(setting, treeNode);
		setting.curTreeNode = treeNode;
	}
	
	//�༭���ƽ���
	function editNameOver(newName, setting, treeNode) {
		treeNode[setting.nameCol] = newName;
		//����rename�¼�
		setting.treeObj.trigger(ZTREE_RENAME, [setting.treeObjId, treeNode]);
		selectNode(setting, treeNode);
	}
	
	//��ȡȫ�� checked = true or false �Ľڵ㼯��
	function getTreeCheckedNodes(setting, treeNodes, checked) {
		if (!treeNodes) return [];
		var results = [];
		for (var i = 0; i < treeNodes.length; i++) {
			if (treeNodes[i][setting.checkedCol] == checked) {
				results = results.concat([treeNodes[i]]);
			}
			var tmp = getTreeCheckedNodes(setting, treeNodes[i][setting.nodesCol], checked);
			if (tmp.length > 0) results = results.concat(tmp);
		}
		return results;
	}
	
	//��ȡȫ�� ���޸�Check״̬ �Ľڵ㼯��
	function getTreeChangeCheckedNodes(setting, treeNodes) {
		if (!treeNodes) return [];
		var results = [];
		for (var i = 0; i < treeNodes.length; i++) {
			if (treeNodes[i][setting.checkedCol] != treeNodes[i].checkedOld) {
				results = results.concat([treeNodes[i]]);
			}
			var tmp = getTreeChangeCheckedNodes(setting, treeNodes[i][setting.nodesCol]);
			if (tmp.length > 0) results = results.concat(tmp);
		}
		return results;
	}
	
	//��Ҫ����ת��Ϊ��׼JSON����
	function transformTozTreeFormat(setting, simpleTreeNodes) {
		var key = setting.treeNodeKey;
		var parentKey = setting.treeNodeParentKey;
		if (!key || key=="" || !simpleTreeNodes) return [];
		
		if (Object.prototype.toString.apply(simpleTreeNodes) === "[object Array]") {
			var r = [];
			var tmpMap = [];
			for (var i=0; i<simpleTreeNodes.length; i++) {
				tmpMap[simpleTreeNodes[i][key]] = simpleTreeNodes[i];
			}
			for (var i=0; i<simpleTreeNodes.length; i++) {
				if (tmpMap[simpleTreeNodes[i][parentKey]]) {
					if (!tmpMap[simpleTreeNodes[i][parentKey]][setting.nodesCol])
						tmpMap[simpleTreeNodes[i][parentKey]][setting.nodesCol] = [];
					tmpMap[simpleTreeNodes[i][parentKey]][setting.nodesCol].push(simpleTreeNodes[i]);
				} else {
					r.push(simpleTreeNodes[i]);
				}
			}
			return r;
		} else {
			return [simpleTreeNodes];
		}
	}
	
	//��׼JSON zTreeNode ����ת��Ϊ��ͨArray��Ҫ����
	function transformToArrayFormat(setting, treeNodes) {
		if (!treeNodes) return [];
		var r = [];
		if (Object.prototype.toString.apply(treeNodes) === "[object Array]") {
			for (var i=0; i<treeNodes.length; i++) {
				r.push(treeNodes[i]);
				if (treeNodes[i][setting.nodesCol])
					r = r.concat(transformToArrayFormat(setting, treeNodes[i][setting.nodesCol]));
			}
		} else {
			r.push(treeNodes);
			if (treeNodes[setting.nodesCol])
				r = r.concat(transformToArrayFormat(setting, treeNodes[setting.nodesCol]));
		}
		return r;
	}

	function zTreePlugin(){
		return {
			container:null,
			setting:null,

			init: function(obj) {
				this.container = obj;
				this.setting = settings[obj.attr("id")];
				return this;
			},

			refresh : function() {
				this.setting.treeObj.empty();
				this.setting.curTreeNode = null;
				this.setting.curEditTreeNode = null;
				this.setting.dragStatus = 0;
				this.setting.dragNodeShowBefore = false;
				this.setting.checkRadioCheckedList = [];
				zTreeId = 0;
				initTreeNodes(this.setting, 0, this.setting.root[this.setting.nodesCol]);
			},

			setEditable : function(editable) {
				this.setting.editable = editable;
				return this.refresh();
			},
			
			transformTozTreeNodes : function(simpleTreeNodes) {
				return transformTozTreeFormat(this.setting, simpleTreeNodes);
			},
			
			transformToArray : function(treeNodes) {
				return transformToArrayFormat(this.setting, treeNodes);
			},

			getNodes : function() {
				return this.setting.root[this.setting.nodesCol];
			},

			getSelectedNode : function() {
				return this.setting.curTreeNode;
			},

			getCheckedNodes : function(selected) {
				selected = (selected != false);
				return getTreeCheckedNodes(this.setting, this.setting.root[this.setting.nodesCol], selected);
			},
			
			getChangeCheckedNodes : function() {
				return getTreeChangeCheckedNodes(this.setting, this.setting.root[this.setting.nodesCol]);
			},

			getNodeByTId : function(treeId) {
				if (!treeId) return;
				return getTreeNodeByTId(this.setting, treeId);
			},
			getNodeByParam : function(key, value) {
				if (!key) return;
				return getTreeNodeByParam(this.setting, this.setting.root[this.setting.nodesCol], key, value);
			},
			getNodesByParam : function(key, value) {
				if (!key) return;
				return getTreeNodesByParam(this.setting, this.setting.root[this.setting.nodesCol], key, value);
			},
			getNodesByParamFuzzy : function(key, value, parentNode) {
				if (!key) return;
				return getTreeNodesByParamFuzzy(this.setting, parentNode?parentNode[this.setting.nodesCol]:this.setting.root[this.setting.nodesCol], key, value);
			},
			
			getNodeIndex : function(treeNode) {
				if (!treeNode) return;
				var parentNode = (treeNode.parentNode == null) ? this.setting.root : treeNode.parentNode;
				for (var i=0; i<parentNode[this.setting.nodesCol].length; i++) {
					if (parentNode[this.setting.nodesCol][i] == treeNode) return i;
				}
				return -1;
			},
			
			getSetting : function() {
				var zTreeSetting = this.setting;
				var setting = {checkType:{}, callback:{}};
				
				var tmp_checkType = zTreeSetting.checkType;
				zTreeSetting.checkType = undefined;
				var tmp_callback = zTreeSetting.callback;
				zTreeSetting.callback = undefined;
				var tmp_root = zTreeSetting.root;
				zTreeSetting.root = undefined;
				
				$.extend(setting, zTreeSetting);
				
				zTreeSetting.checkType = tmp_checkType;				
				zTreeSetting.callback = tmp_callback;				
				zTreeSetting.root = tmp_root;				

				//���ܻ�ȡroot��Ϣ
				$.extend(true, setting.checkType, tmp_checkType);
				$.extend(setting.callback, tmp_callback);
				
				return setting;
			},
			
			updateSetting : function(zTreeSetting) {
				if (!zTreeSetting) return;
				var setting = this.setting;
				var treeObjId = setting.treeObjId;
				
				var tmp_checkType = zTreeSetting.checkType;
				zTreeSetting.checkType = undefined;
				var tmp_callback = zTreeSetting.callback;
				zTreeSetting.callback = undefined;
				var tmp_root = zTreeSetting.root;
				zTreeSetting.root = undefined;
				
				$.extend(setting, zTreeSetting);
				
				zTreeSetting.checkType = tmp_checkType;				
				zTreeSetting.callback = tmp_callback;				
				zTreeSetting.root = tmp_root;				
				
				//���ṩroot��Ϣupdate
				$.extend(true, setting.checkType, tmp_checkType);
				$.extend(setting.callback, tmp_callback);
				setting.treeObjId = treeObjId;
				setting.treeObj = this.container;
				
			},

			expandAll : function(expandSign) {
				expandCollapseSonNode(this.setting, null, expandSign, true);
			},

			expandNode : function(treeNode, expandSign, sonSign) {
				if (!treeNode) return;

				if (expandSign) {
					//���չ��ĳ�ڵ㣬�����չ����ȫ�����ڵ�
					//Ϊ�˱�֤Ч��,չ�����ڵ�ʱ��ʹ�ö���
					if (treeNode.parentNode) expandCollapseParentNode(this.setting, treeNode.parentNode, expandSign, false);
				}
				if (sonSign) {
					//���ͼ��ͬʱ���ж��������²������ӳٺ����ô���׼ȷ���񶯻����ս���ʱ��
					//���Ϊ�˱�֤׼ȷ���ڵ�focus���ж�λ�������js�����ڵ�ʱ�������ж���
					expandCollapseSonNode(this.setting, treeNode, expandSign, false, function() {
						$("#" + treeNode.tId + IDMark_Icon).focus().blur();
					});
				} else if (treeNode.open != expandSign) {
					switchNode(this.setting, treeNode);
					$("#" + treeNode.tId + IDMark_Icon).focus().blur();
				}
			},

			selectNode : function(treeNode) {
				if (!treeNode) return;

				selectNode(this.setting, treeNode);
				//���ѡ��ĳ�ڵ㣬�����չ����ȫ�����ڵ�
				//���ͼ��ͬʱ���ж��������²������ӳٺ����ô���׼ȷ���񶯻����ս���ʱ��
				//���Ϊ�˱�֤׼ȷ���ڵ�focus���ж�λ�������js�����ڵ�ʱ�������ж���
				if (treeNode.parentNode) {
					expandCollapseParentNode(this.setting, treeNode.parentNode, true, false, function() {
						$("#" + treeNode.tId + IDMark_Icon).focus().blur();
					});
				} else {
					$("#" + treeNode.tId + IDMark_Icon).focus().blur();
				}
			},
			
			cancleSelectedNode : function() {
				this.cancelSelectedNode();
			},
			cancelSelectedNode : function() {
				cancelPreSelectedNode(this.setting);
			},
			
			checkAllNodes : function(checked) {
				repairAllChk(this.setting, checked);
			},
			
			reAsyncChildNodes : function(parentNode, reloadType) {
				if (!this.setting.async) return;
				var isRoot = !parentNode;
				if (isRoot) {
					parentNode = this.setting.root;
				}
				if (reloadType=="refresh") {
					parentNode[this.setting.nodesCol] = [];
					if (isRoot) {
						this.setting.treeObj.empty();
					} else {
						var ulObj = $("#" + parentNode.tId + IDMark_Ul);
						ulObj.empty();
					}
				}
				asyncGetNode(this.setting, isRoot? null:parentNode);
			},

			addNodes : function(parentNode, newNodes, isSilent) {
				if (!newNodes) return;
				if (!parentNode) parentNode = null;
				var xNewNodes = (Object.prototype.toString.apply(newNodes) === "[object Array]")? newNodes: [newNodes];
				addTreeNodes(this.setting, parentNode, xNewNodes, (isSilent==true));
			},
			
			updateNode : function(treeNode, checkTypeFlag) {
				if (!treeNode) return;
				var checkObj = $("#" + treeNode.tId + IDMark_Check);
				if (this.setting.checkable) {
					if (checkTypeFlag == true) checkNodeRelation(this.setting, treeNode);
					setChkClass(this.setting, checkObj, treeNode);
					repairParentChkClassWithSelf(this.setting, treeNode);
				}
				setNodeName(this.setting, treeNode);
				setNodeTarget(treeNode);
				setNodeUrl(this.setting, treeNode);
				setNodeLineIcos(this.setting, treeNode);
				setNodeFontCss(this.setting, treeNode);
			},

			moveNode : function(targetNode, treeNode, moveType) {
				if (!treeNode) return;
				
				if (targetNode && ((treeNode.parentNode == targetNode && moveType == MoveType_Inner) || $("#" + treeNode.tId).find("#" + targetNode.tId).length > 0)) {
					return;
				} else if (!targetNode) {
					targetNode = null;
				}
				moveTreeNode(this.setting, targetNode, treeNode, moveType, false);
			},

			removeNode : function(treeNode) {
				if (!treeNode) return;
				removeTreeNode(this.setting, treeNode);
			}

		};
	};
})(jQuery);