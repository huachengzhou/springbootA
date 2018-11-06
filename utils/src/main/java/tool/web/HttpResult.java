package tool.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import tool.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zch
 * @Date: 2018/8/26 09:40
 * @Description:实现描述：标准接口的JSON数据返回值
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResult {
    private static final long serialVersionUID = 1L;

    private static final Boolean CORRECT_RET = Boolean.TRUE;
    private static final Boolean ERR_RET = Boolean.FALSE;

    private static final int DEFAULT_ERR_CODE = 0;

    /** 表示调用是否成功，成功为true，失败为false */
    private Boolean ret;

    /** 业务数据 */
    private Object data;

    /** 调用码，当调用出错时，此字段才会出现 */
    private Integer code;

    /** 错误信息，输出出错码对应的出错信息 */
    private String errmsg;

    /**
     * 生成一个标准的正确返回对象，{"ret": true}
     *
     * @return 标准正确返回对象，不带data值
     */
    public static HttpResult newCorrectResult() {
        HttpResult correctJsonObject = new HttpResult();
        correctJsonObject.setRet(HttpResult.CORRECT_RET);
        return correctJsonObject;
    }

    /**
     * 生成一个标准的正确返回DTO，{"ret": true, "data": {JsonStringOfObject}}
     *
     * @param object 业务信息<Map>
     * @return
     */
    public static HttpResult newCorrectResult(Object object) {
        HttpResult correctJsonObject = HttpResult.newCorrectResult();
        correctJsonObject.setData(object);
        return correctJsonObject;
    }

    /**
     *
     * @param code
     * @param object
     * @return
     */
    public static HttpResult newCorrectResult(Integer code, Object object) {
        HttpResult correctJsonObject = HttpResult.newCorrectResult();
        correctJsonObject.setCode(code);
        correctJsonObject.setData(object);
        return correctJsonObject;
    }

    /**
     * 生成一个标准的错误返回DTO，{"ret": false,"errcode": code,"errmsg" : "msg"}
     *
     * @param code
     * @param msg
     * @return
     */
    public static HttpResult newErrorResult(Integer code, String msg) {
        HttpResult errorReturnObject = new HttpResult();
        errorReturnObject.setRet(HttpResult.ERR_RET);
        errorReturnObject.setCode(code);
        errorReturnObject.setErrmsg(msg);
        return errorReturnObject;
    }

    public static HttpResult newErrorResult(Integer code, Exception ex) {
        HttpResult errorReturnObject = new HttpResult();
        errorReturnObject.setRet(HttpResult.ERR_RET);
        errorReturnObject.setCode(code);
        errorReturnObject.setErrmsg(ex.getMessage());

        if (ex instanceof NullPointerException) {
            errorReturnObject.setErrmsg("存在空指针风险,请检查后台逻辑.");
        }
        return errorReturnObject;
    }

    /**
     * 生成一个标准的错误返回DTO，{"ret": false,"errmsg" : "msg"}
     *
     * @param msg
     * @return
     */
    public static HttpResult newErrorResult(String msg) {
        return HttpResult.newErrorResult(HttpResult.DEFAULT_ERR_CODE, msg);
    }

    public static HttpResult newErrorResult(Exception ex) {
        return HttpResult.newErrorResult(HttpResult.DEFAULT_ERR_CODE, ex);
    }

    /**
     * json
     * @param result
     * @return
     */
    public static String toJson(HttpResult result) {
        return JsonUtils.json(result);
    }

    /**
     * 添加 Key—Value 条目到 data 里，data 如果不是 map 结构则出错
     *
     * @param key
     * @param value
     * @return
     */
    public HttpResult putEntry(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            return this;
        }

        if (this.data == null) {
            this.data = new HashMap<String, Object>();
        }

        boolean isMapStructure = (this.data instanceof Map);
        if (!isMapStructure) {
            throw new RuntimeException("Can't put k-v into not-map data");
        }

        ((Map<String, Object>) data).put(key, value);
        return this;
    }

    /**
     * 获取一个的结果（服务端方法只有一个返回结果时调用）
     *
     * @param clazz 结果类型
     * @return 结果值
     */
    public <T> T getData(Class<T> clazz) {
        if (clazz == null || data == null) {
            return null;
        }
        return JsonUtils.parse(JsonUtils.json(data), clazz);
    }

    /** -----------------setter/getter--------------------- **/
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Boolean getRet() {
        return ret;
    }

    public void setRet(Boolean ret) {
        this.ret = ret;
    }

    /** -----------------equals/hashCode--------------------- **/

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
