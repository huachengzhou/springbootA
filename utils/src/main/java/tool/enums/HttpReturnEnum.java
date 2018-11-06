package tool.enums;

/**
 * 描述: 保存数据库数据提示消息
 *
 * @author: Calvin(qiudong@copowercpa.com)
 * @data: 2017/7/20
 * @time: 11:43
 */
public enum HttpReturnEnum {
    STARTPROCESS("发起流程失败"),
    DELETEFAIL("删除数据失败"),
    SAVEFAIL("保存数据失败"),
    NOTFIND("数据库中没有相应的数据"),
    COPYFAIL("对象拷贝异常"),
    DELETETABLEFAIL("DDL操作数据库表结构失败"),
    SQLFAIL("执行语句保存数据库数据失败"),
    EMPTYPARAM("参数为空"),
    EXIST("数据已存在");
    private String name;

    private HttpReturnEnum(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
