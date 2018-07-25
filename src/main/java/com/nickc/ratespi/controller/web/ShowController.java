package com.nickc.ratespi.controller.web;

import com.nickc.ratespi.pojo.Rate;
import com.nickc.ratespi.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengxumin
 * @date 2018/7/20
 */
@Controller
public class ShowController {
    @Autowired
    RateService rateService;

    @RequestMapping(value = "/rate/{name}",method = RequestMethod.GET)
    public String showByName(@PathVariable String name, Model model){
        name=name.toUpperCase();
        String cname="";
        List<Rate> list=rateService.getAllByName(name);
        List<String> listTime=new ArrayList<>();
        List<String> listRate=new ArrayList<>();
        double max=0,min=10000,avg;
        if (list.size()!=0){
            for (int i=list.size()-1;i>=0;i--){
                listTime.add(list.get(i).getTime().substring(14,16));
                listRate.add(list.get(i).getRate());
                if (Double.parseDouble(list.get(i).getRate())>max){
                    max=Double.parseDouble(list.get(i).getRate());
                }
                if (Double.parseDouble(list.get(i).getRate())<min){
                    min=Double.parseDouble(list.get(i).getRate());
                }
            }
            cname=list.get(0).getCname();
        }

        avg=(max-min)/10;
        System.out.println(max+" "+min+" "+avg);
        model.addAttribute("list",list);
        model.addAttribute("time",listTime);
        model.addAttribute("rate",listRate);
        model.addAttribute("max",max);
        model.addAttribute("min",min);
        model.addAttribute("avg",avg);
        model.addAttribute("cname",cname);
        model.addAttribute("name",name);
        return "show";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String search){
        System.out.println(search);
        String url="redirect:/rate/"+search;
        System.out.println(url);
        return url;
    }
}
