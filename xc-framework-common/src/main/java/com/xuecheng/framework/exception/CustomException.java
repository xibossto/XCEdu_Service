package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @author xiboss
 * @create 2019-03-20 21:16
 */
public class CustomException extends RuntimeException {
    private ResultCode resultCode ;

    public CustomException(ResultCode resultCode){
        //异常信息：错误代码+异常信息
        super("错误代码："+resultCode.code()+"————错误信息："+resultCode.message()) ;
        this.resultCode = resultCode ;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }
}
