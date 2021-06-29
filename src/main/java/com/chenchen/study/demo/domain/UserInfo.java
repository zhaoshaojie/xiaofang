package com.chenchen.study.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @Author:sjZhao
 * @Date:2021/6/2819:00
 */
@Builder
@Getter
@Setter
@Data
public class UserInfo {
    /**
     * 身份证号
     */
    private String idNo;
}
