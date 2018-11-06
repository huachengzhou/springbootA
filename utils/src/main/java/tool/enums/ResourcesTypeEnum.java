package tool.enums;

/**
 * 描述: 资源类型
 *
 * @author Red
 * @version 1.0
 * @date: 2017/12/19 17:00
 */
public enum ResourcesTypeEnum {
    MENU_REQUEST("menu", "菜单资源"), VIEW_REQUEST("view", "视图请求资源"), QUERY_REQUEST("query", "查询请求资源"),
    CREATE_REQUEST("create", "新增请求资源"), UPDATE_REQUEST("update", "更新请求资源"), DELETE_REQUEST("delete", "删除请求资源");

    private String value;
    private String name;

    ResourcesTypeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}