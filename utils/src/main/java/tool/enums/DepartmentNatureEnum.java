package tool.enums;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:部门性质枚举
 *
 * @author: Calvin(qiudong@copowercpa.com)
 * @data: 2018/6/27
 * @time: 16:43
 */
public enum DepartmentNatureEnum implements Serializable {
    COMPANY(0, "公司部门"), CONSTRUCTION(1, "施工单位"), SUPERVISING(2, "监理单位"), PROPRIETOR(3, "业主单位"), AUDIT(4, "跟审单位");
    private Integer value;
    private String name;

    DepartmentNatureEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public static DepartmentNatureEnum create(Integer value) {
        for (DepartmentNatureEnum e : DepartmentNatureEnum.values()) {
            if (e.getValue()==value) {
                return e;
            }
        }
        return null;
    }

    public static List<KeyValueDto> getDepartmentNatureEnum() {
        List<KeyValueDto> keyValueDtos = new ArrayList<>();
        for (DepartmentNatureEnum e : DepartmentNatureEnum.values()) {
            KeyValueDto keyValueDto = new KeyValueDto();
            keyValueDto.setKey(e.getValue().toString());
            keyValueDto.setValue(e.getName());
            keyValueDtos.add(keyValueDto);
        }
        return keyValueDtos;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
