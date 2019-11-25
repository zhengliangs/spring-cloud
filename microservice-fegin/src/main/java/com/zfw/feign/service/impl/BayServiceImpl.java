package com.zfw.feign.service.impl;

import com.zfw.feign.entity.Bay;
import com.zfw.feign.mapper.BayMapper;
import com.zfw.feign.service.BayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhengl
 * @since 2019-11-22
 */
@Service(value = "bayService")
public class BayServiceImpl extends ServiceImpl<BayMapper, Bay> implements BayService {

    @Autowired
    private BayMapper bayMapper;

    @Override
    public Bay queryBayById(Integer id) {

        return bayMapper.selectBayById(id);
    }
}
