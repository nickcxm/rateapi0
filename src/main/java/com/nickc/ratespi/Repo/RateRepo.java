package com.nickc.ratespi.Repo;

import com.nickc.ratespi.pojo.Rate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chengxumin
 * @date 2018/7/20
 */
public interface RateRepo extends JpaRepository<Rate,Long>{
    List<Rate> findAllByName(String name, Sort sort);
    List<Rate> findTop10ByNameOrderByIdDesc(String name);
}
