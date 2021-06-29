package com.chenchen.study.demo.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;


/**
 * @Author : chenbin
 * @Description : 用户主体实体类
 * @Date : 2020/8/4
 **/

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "T_USER_CORE",resultMap = "UserCore")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -960192869772520197L;

    /**
     * 出生日期格式
     */
    public static final String USER_BIRTHDAY_PATTERN = "yyyyMMdd";

    /**
     * 用户审批状态  1-未申请  2-待审 3-审批通过，正常使用 4-审批被驳回
     **/
    public static final String AUDIT_STATE_NOT_APPLIED = "1";
    public static final String AUDIT_STATE_PENDING = "2";
    public static final String AUDIT_STATE_PASS = "3";
    public static final String AUDIT_STATE_REJECT = "4";

    /**
     * 身份证号
     */
    @TableId(value = "GMSFHM", type = IdType.AUTO)
    private String idNo;

    /**
     * 职位编码
     */
    @TableField(value = "ZWBM")
    private String dutyCode;

    /**
     * 机构编码
     */
    @TableField(value = "JGBM",exist = true)
    private String orgCode;

    /**
     * UKey编码
     */
    @TableField(value = "UKBM")
    private String uKeyCode;

    /**
     * 认证状态-是否通过市局身份认证系统认证
     * 0-false-未认证
     * 1-true-已认证
     */
    @TableField(value = "SFRZ")
    private Boolean verifyState = false;

    /**
     * 可用状态-是否可用
     * 0-false-不可用
     * 1-true-可用
     */
    @TableField(value = "SFKY")
    private Boolean ableState = true;

    /**
     * 角色标志
     */
    @TableField(value = "JSDM")
    private String roleCode;

    /**
     * 用户审批状态  1-未申请  2-待审 3-审批通过，正常使用 4-审批被驳回
     */
    @TableField(value = "SPZT")
    private String approveState;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity that = (UserEntity) o;
        return Objects.equals(idNo, that.idNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNo, dutyCode, orgCode, verifyState, ableState);
    }
}
