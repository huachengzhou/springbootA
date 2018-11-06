package tool.enums;

/**
 * 描述: Excel常用类
 *
 * @author: Calvin(qiudong@copowercpa.com)
 * @data: 2018-9-4
 * @time: 9:57
 */
public enum ExcelCellStyleEnum {
    INTEGER("integer", "数字"), STRING("string", "字符"), DECIMAL("decimal", "小数"), CURRENCY("currency", "货币"), PERCENTAGE("percentage", "百分数"), DATE("date", "日期"), DATETIME("datetime", "日期时间"),
    COUNTING("counting", "科学计数"), UPPERCHINESE("upperchinese", "中文大写");

    private String value;
    private String name;

    ExcelCellStyleEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static ExcelCellStyleEnum create(String value) {
        for (ExcelCellStyleEnum e : ExcelCellStyleEnum.values()) {
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
