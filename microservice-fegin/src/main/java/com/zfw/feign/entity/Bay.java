package com.zfw.feign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhengl
 * @since 2019-11-22
 */
@Data
@TableName("t_bay")
public class Bay implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属站Id
     */
    @TableField("StationId")
    private Integer stationId;

    /**
     * 间隔在站中的索引
     */
    @TableField("IndexInStation")
    private Integer indexInStation;

    /**
     * 模板索引
     */
    @TableField("ModuleId")
    private Integer moduleId;

    /**
     * 间隔名称
     */
    @TableField("Name")
    private String name;

    /**
     * 标签
     */
    @TableField("Tag")
    private String tag;

    /**
     * 关键词
     */
    @TableField("Keywords")
    private String keywords;

    /**
     * 备注
     */
    @TableField("Remark")
    private String remark;

    /**
     * 间隔对应的数据点表，用XML格式存储
     */
    @TableField("Datas")
    private String datas;

    /**
     * 间隔参数信息,用XML格式存储
     */
    @TableField("Infos")
    private String infos;

    /**
     * 间隔类型的Id
     */
    @TableField("TypeId")
    private Integer typeId;
}
