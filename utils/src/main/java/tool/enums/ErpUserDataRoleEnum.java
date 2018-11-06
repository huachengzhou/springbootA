package tool.enums;

import java.io.Serializable;

/**
 * 描述:流程状态
 *
 * @author: Calvin(qiudong@copowercpa.com)
 * @data: 2017/7/26
 * @time: 14:54
 */
public enum ErpUserDataRoleEnum implements Serializable {
    DEPARTMENT("1", "部门列表"), USERACCOUNTS("2", "下级人员列表"), CREATOR("3", "当前操作人");

    private String value;
    private String name;

    ErpUserDataRoleEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static ErpUserDataRoleEnum create(String value) {
        for (ErpUserDataRoleEnum e : ErpUserDataRoleEnum.values()) {
            if (e.getValue().equals(value)) {
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
