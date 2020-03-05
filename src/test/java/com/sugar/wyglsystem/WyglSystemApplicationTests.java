package com.sugar.wyglsystem;

import com.sugar.wyglsystem.mbg.mapper.BuildingMapper;
import com.sugar.wyglsystem.mbg.model.Building;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class WyglSystemApplicationTests {

    @Autowired
    private BuildingMapper buildingMapper;
    @Test
    void contextLoads() {
        Building building = buildingMapper.selectByPrimaryKey(13L);
        Date date = building.getCreateTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String res = dateFormat.format(date);
        System.out.println(res);
    }

}
