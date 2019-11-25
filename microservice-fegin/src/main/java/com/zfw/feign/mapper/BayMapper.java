package com.zfw.feign.mapper;

import com.zfw.feign.entity.Bay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhengl
 * @since 2019-11-22
 */
@Mapper
public interface BayMapper extends BaseMapper<Bay> {

    Bay selectBayById(@Param("id") Integer id);

}
