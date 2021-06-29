package freemarker.sysroley.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author sjzhao
 * @since 2021-06-29
 */
@Data
@Accessors(chain = true)
@TableName("T_SYS_ROLE")
public class TSysRole {

    private static final long serialVersionUID = 1L;

    /**
     * 角色描述
     */
    @TableField("JSMS")
    private String jsms;

    /**
     * 角色名称
     */
    @TableField("JSMC")
    private String jsmc;

    /**
     * 修改时间
     */
    @TableField("XGSJ")
    private Date xgsj;

    /**
     * 角色代码
     */
    @TableId(value = "JSDM", type = IdType.AUTO)
    private String jsdm;


}
