package tool.enums;

/**
 * 描述: 资源类型
 *
 * @author Red
 * @version 1.0
 * @date: 2017/12/19 17:00
 */
public enum SysProjectEnum {
    NONE("none", "所有"), FINISH("finish", "已完成"), CLOSE("close", "关闭"),RUNING("runing", "运行中");

    private String value;
    private String name;

    SysProjectEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static String getNameByKey(String value){
        for (SysProjectEnum e : SysProjectEnum.values()) {
            if (e.getValue().equals(value)) {
                return e.getName();
            }
        }
        return null;
    }

    public static SysProjectEnum getEnumByName(String name) {
        for (SysProjectEnum e : SysProjectEnum.values()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
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