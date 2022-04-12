package com.wg.pms.common;

public enum ResponseResult {

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    FORBIDDEN(403,"没有相关权限"),
    UNAUTHORIZED(401,"需要进行身份认证"),
    VALIDATEfAILED(404,"验证失败"),
    DELETE_FAILED(100,"删除失败"),
    DELETE_SUCCESS(101,"删除成功"),
    ADD_SUCCESS(102,"添加成功"),
    ADD_FAILED(103,"添加失败"),
    UPDATE_SUCCESS(104,"更新成功"),
    UPDATE_FAILED(105,"更新失败"),
    UPLOAD_SUCCESS(106,"上传成功"),
    UPLOAD_FAILED(107,"上传失败"),
    SELECT_FAILED(108,"查询失败");
    private long status;
    private String message;

    ResponseResult(long status, String message) {
        this.status = status;
        this.message = message;
    }



    public long getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
