package com.nickc.ratespi.controller;

import com.nickc.ratespi.pojo.Rate;
import com.nickc.ratespi.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chengxumin
 * @date 2018/7/20
 */
@RestController
@RequestMapping("/api/rate")
public class RateApiController {
    @Autowired
    RateService rateService;

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public Rate getRateByName(@PathVariable String name){
        name=name.toUpperCase();
        return rateService.getLatestByName(name);
    }

    @RequestMapping(value = "/all/{name}",method = RequestMethod.GET)
    public List<Rate> getAllByName(@PathVariable String name){
        name=name.toUpperCase();
        return rateService.getAllByName(name);
    }

}
