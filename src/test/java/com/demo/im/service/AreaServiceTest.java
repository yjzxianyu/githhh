package com.demo.im.service;

import com.demo.im.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {
    @Autowired AreaService areaService;

    @Test
    public void getAreaList() {
        List<Area> areas = areaService.getAreaList();
        System.out.println(areas);;
    }

    @Test
    public void getAreaById() {
        int a=1;
        Area area = areaService.getAreaById(a);
        System.out.println(area);
    }

    @Test
    public void addArea() {
        int id=3;
        String name = "中央";
        int po = 5;
        boolean b = true;
        Date now = new Date();
        Date la = new Date();
        Area area = new Area();
        area.setAreaName(name);
        area.setPriority(po);
        area.setCreateTime(now);
        area.setLastEditTime(la);
        b = areaService.addArea(area);
        System.out.println(b);
    }

    @Test
    public void modifyArea() {
        int id = 1;
        String name = "东北苑";
        Date now = new Date();
        boolean b = false;
        Area area = new Area();
     //   area.setAreaId(id);
        area.setAreaName(name);
        area.setLastEditTime(now);

        b = areaService.modifyArea(area);
        System.out.println(b);
    }

    @Test
    public void deleteArea() {
        int id = 3;
        boolean b = false;
        b = areaService.deleteArea(id);
        System.out.println(b);
    }
}