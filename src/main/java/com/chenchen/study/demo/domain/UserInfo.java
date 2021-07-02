package com.chenchen.study.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description
 * @Author:sjZhao
 * @Date:2021/6/2819:00
 */
@Builder
@Getter
@Setter
@Data
@ApiModel(description = "用户信息返回响应数据")
public class UserInfo implements Serializable {
    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    private String idNo;

}
