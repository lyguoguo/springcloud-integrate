package com.gly.redisdemo.exception;

import com.gly.redisdemo.enums.ResultEnum;
import lombok.Data;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.gly.redisdemo.exception
 * @date:2019/6/13
 **/
@Data
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }


    public SellException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code=code;
    }
}
