package com.nickc.ratespi.service;

import com.nickc.ratespi.pojo.Rate;

import java.util.List;

/**
 * @author chengxumin
 * @date 2018/7/20
 */
public interface RateService {
    Rate getLatestByName(String name);
    List<Rate> getAllByName(String name);
}
