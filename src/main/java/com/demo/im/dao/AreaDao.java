package com.demo.im.dao;
import com.demo.im.entity.Area;
import java.util.List;

public interface AreaDao {
    /**
     * 查找所有地区
     * @return
     */
    List<Area> queryArea();

    /**
     * 按id查找地区
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 增加地区
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 修改
     * @param area
     * @return
     */
    int updateArea(Area area);


    /**
     * 根据id删除地区
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);
}
