(function($){
    $.fn.TreePanel = {
        defaults: {
			url:'',
			data:null,
			id:'',
            setting: {
                isSimpleData: true,
                treeNodeKey: "id",
                treeNodeParentKey: "pid",
                showLine: true,
                root: {
                    isRoot: true,
                    nodes: []
                }
            }
        },
        /**
         * config = {
         * 	  url
         *    data
         *    setting:{
         *    	treeNodeKey: "rid"
         *    }
         * }
         * @param {Object} config
         */
        createTree: function(config){
        	var con = {};
			/**
			 * �û����ݹ��������ø��ǵ�Ĭ�ϵ�����
			 *    trueΪ��ȸ���
			 */
			con = $.extend(true,$.fn.TreePanel.defaults,config);
            $.post(config.url, config.data, function(data){
                $("#" + config.id).zTree(con.setting, data);
            });
        }
    };
})($);
