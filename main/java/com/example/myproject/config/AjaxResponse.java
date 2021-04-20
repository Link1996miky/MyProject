package com.example.myproject.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "通用响应数据结构类")
public class AjaxResponse {

    @Schema(title = "请求是否处理成功")
    private boolean isok;
    @Schema(title = "请求响应的状态码，example=200,400,500")
    private int code;
    @Schema(title = "请求结果的描述信息")
    private String message;
    @Schema(title = "请求结果数据")
    private Object data;

    public AjaxResponse() {
    }

    public static AjaxResponse success() {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功");
        return ajaxResponse;
    }

    public static AjaxResponse success(Object obj) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
