package com.zfw.feign.service;

import com.zfw.feign.entity.Bay;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhengl
 * @since 2019-11-22
 */
public interface BayService extends IService<Bay> {

    Bay queryBayById(Integer id);

}
