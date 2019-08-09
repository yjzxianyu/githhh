package com.demo.im.service;

import java.util.List;

import com.demo.im.entity.Area;

public interface AreaService {


    /**
     * 获取区域列表
     * @return
     */
    List<Area> getAreaList();

    /**
     * 通过id获取地区信息
     * @param areaId
     * @return
     */
    Area getAreaById(int areaId);

    /**
     * 增加信息
     * @param area
     * @return
     */
    boolean addArea(Area area);

    /**
     * 删除信息
     * @param area
     * @return
     */
    boolean modifyArea(Area area);


    /**
     * 根据id删除
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);

}
