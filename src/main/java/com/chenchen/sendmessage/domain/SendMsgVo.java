package com.chenchen.sendmessage.domain;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author:sjZhao
 * @Date:2021/7/139:44
 */
@Data
public class SendMsgVo {

    @NotNull
    private String msg;

    @NotNull
    private Date sendDate;

    public SendMsgVo(){
        sendDate = new Date();
        msg = "666666";
    }
}
