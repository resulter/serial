package com.xs.frame.controller;

import com.xs.frame.common.code.BusinessSerialValueRange;
import com.xs.frame.common.sequence.RedisSequence;
import com.xs.frame.common.utils.DateUtil;
import com.xs.frame.iserial.BusinessSerial;
import com.xs.frame.iserial.ILogicSerialService;
import com.xs.frame.iserial.PublicResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CodeController {
    private Logger log = LoggerFactory.getLogger(CodeController.class);

    @Autowired
    ILogicSerialService logicSerialService;
    @Autowired
    private RedisSequence redisSequence;


    @RequestMapping(value = "/getCode",method = {RequestMethod.GET,RequestMethod.POST})
    public String getCode(){
        return "hello";
    }

    @RequestMapping(value = "/maxValue",method = RequestMethod.GET)
    public String getMaxCodeByDate(){
        Long result = redisSequence.getMaxValue("01001_181205");
        System.out.println(String.valueOf(result));
        return String.valueOf(result);
    }


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        BusinessSerial businessSerial = new BusinessSerial();
        businessSerial.setBusinessNo("1001");
        businessSerial.setPlatform("1");
        businessSerial.setSystemNo("1");
        businessSerial.setServiceNo("XV");
        businessSerial.setTerminalType("1");
        PublicResult publicResult = logicSerialService.getProfessionSerialNumber(businessSerial);
        if(!publicResult.isSuccess()){
           return  publicResult.getErrorMsg();
        }else {
            return  publicResult.getResult().toString();
        }
    }


    private String getNow(){
        return DateUtil.format(new Date(), BusinessSerialValueRange.formatStr);
    }
}
