package com.zfw.feign.controller;


import com.zfw.feign.entity.Bay;
import com.zfw.feign.service.BayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhengl
 * @since 2019-11-22
 */
@RestController
public class BayController {

    @Autowired
    private BayService bayService;

    @PostMapping("/queryBay")
    public List<Bay> queryBay(){
//        bayService.
        return bayService.list();
    }

    @PostMapping("/queryBayById")
    public Bay queryBayById(Integer id){
//        bayService.
        return bayService.queryBayById(id);
    }

}

