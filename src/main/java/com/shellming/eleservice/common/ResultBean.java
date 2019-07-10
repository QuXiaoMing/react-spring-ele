package com.shellming.eleservice.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 统一返回结果
 *
 * @author dadiyang
 * @since 2019-06-02
 */
@Data
@NoArgsConstructor
@ApiModel(description = "返回结果")
public class ResultBean<T> {
    public static final String FAIL = "-1";
    public static final String SUCCESS = "0000";
    public static final String UNKNOWN_ERROR = "-9999";
    @ApiModelProperty(value = "处理结果code，0 表示成功，非零表示失败", notes = "正数表示已知错误，负数表示未知异常")
    private String code;
    @ApiModelProperty("错误信息，一般只在处理失败时才有")
    private String msg;
    @ApiModelProperty("结果数据")
    private T data;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean<>(SUCCESS, "成功", data);
    }

    public static <T> ResultBean<T> fail(String msg) {
        return new ResultBean<>(FAIL, msg);
    }

    public static <T> ResultBean<T> fail(String code, String msg) {
        return new ResultBean<>(code, msg);
    }

    public static <T> ResultBean<T> unknownError(String msg) {
        return new ResultBean<>(UNKNOWN_ERROR, msg);
    }

    public Boolean isSuccess() {
        return StringUtils.equals(ResultBean.SUCCESS, this.code);
    }

    public ResultBean(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(T data) {
        this.data = data;
    }
}