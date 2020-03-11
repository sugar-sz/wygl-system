package com.sugar.wyglsystem.service.impl;

import com.sugar.wyglsystem.mbg.mapper.CarMapper;
import com.sugar.wyglsystem.mbg.model.Car;
import com.sugar.wyglsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：lyj
 * @date ：Created in 2020/3/11 17:44
 * @description：
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public int insertCar(Car car) {
        return carMapper.insert(car);
    }
}
