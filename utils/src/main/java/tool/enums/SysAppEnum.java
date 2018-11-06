package tool.enums;

/**
 * 描述:
 *
 * @author Red
 * @version 1.0
 * @date: 2017/12/19 16:36
 */
public enum SysAppEnum {
    ERP("pmcc-erp"),
    HR("pmcc-hr"),
    BPM("pmcc-bpm"),
    COSTS("pmcc-costs"),
    FINANCE("pmcc-finance"),
    BID("pmcc-bid"),
    CONTRACT("pmcc-contract"),
    KBS("pmcc-kbs"),
    CHKS("pmcc-chks");

    private String value;

    SysAppEnum(String value) {
        this.value = value;
    }

    public static SysAppEnum create(String value) {
        for (SysAppEnum e : SysAppEnum.values()) {
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
}
