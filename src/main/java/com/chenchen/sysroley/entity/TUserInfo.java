package com.chenchen.sysroley.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author sjzhao
 * @since 2021-06-30
 */
@Data
@Accessors(chain = true)
@TableName("T_USER_INFO")
public class TUserInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 身份证号
     */
    @TableId(value = "GMSFHM", type = IdType.AUTO)
    private String gmsfhm;

    /**
     * 姓名
     */
    @TableField("XM")
    private String xm;

    /**
     * 头像
     */
    @TableField("TX")
    private String tx;

    /**
     * 出生日期
     */
    @TableField("CSRQ")
    private Date csrq;

    /**
     * 性别-字典项code
     */
    @TableField("XBDM")
    private String xbdm;

    /**
     * 手机号
     */
    @TableField("SJHM")
    private String sjhm;

    /**
     * 座机号
     */
    @TableField("ZJHM")
    private String zjhm;

    /**
     * 警号
     */
    @TableField("JH")
    private String jh;

    /**
     * 非正常状态备注
     */
    @TableField("FZCSM")
    private String fzcsm;

    /**
     * 修改时间
     */
    @TableField("XGSJ")
    private Date xgsj;

    /**
     * 创建时间
     */
    @TableField("CJSJ")
    private Date cjsj;

    /**
     * 三类网头像
     */
    @TableField("SLWTX")
    private String slwtx;


}
