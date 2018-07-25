package com.nickc.ratespi.service.impl;

import com.nickc.ratespi.Repo.RateRepo;
import com.nickc.ratespi.pojo.Rate;
import com.nickc.ratespi.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengxumin
 * @date 2018/7/20
 */
@Service
public class RateServiceImpl implements RateService{
    @Autowired
    RateRepo rateRepo;

    @Override
    public Rate getLatestByName(String name) {
        List<Rate> list= rateRepo.findAllByName(name,new Sort(Sort.Direction.DESC,"id"));
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Rate> getAllByName(String name) {
        return rateRepo.findTop10ByNameOrderByIdDesc(name);
    }
}
