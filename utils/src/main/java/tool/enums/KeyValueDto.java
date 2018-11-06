package tool.enums;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangpc on 2017/8/17.
 */
public class KeyValueDto implements Serializable {
    private String key;

    private String value;

    private String explain;

    private KeyValueDto keyValueDto;

    private List<KeyValueDto> keyValueDtos;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public KeyValueDto getKeyValueDto() {
        return keyValueDto;
    }

    public void setKeyValueDto(KeyValueDto keyValueDto) {
        this.keyValueDto = keyValueDto;
    }

    public List<KeyValueDto> getKeyValueDtos() {
        return keyValueDtos;
    }

    public void setKeyValueDtos(List<KeyValueDto> keyValueDtos) {
        this.keyValueDtos = keyValueDtos;
    }
}
