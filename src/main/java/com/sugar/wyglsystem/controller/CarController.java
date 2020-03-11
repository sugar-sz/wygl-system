package com.sugar.wyglsystem.controller;

import com.sugar.wyglsystem.common.api.CommonResult;
import com.sugar.wyglsystem.mbg.model.Car;
import com.sugar.wyglsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/11 17:45
 * @description： 车辆信息
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public CommonResult insertCar(@RequestBody Car car) {
        int count = carService.insertCar(car);
        if (count > 0) {
            return CommonResult.success(car);
        }
        return CommonResult.failed("插入失败");
    }
}
