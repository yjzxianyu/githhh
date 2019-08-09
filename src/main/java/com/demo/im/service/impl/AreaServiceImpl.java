package com.demo.im.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.im.dao.AreaDao;
import com.demo.im.entity.Area;
import com.demo.im.service.AreaService;

@Service
public class  AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        // 返回所有的区域信息
        return areaDao.queryArea();
    }

    @Override
    /**
     * 通过id得到该区域的信息
     */
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        // 空值判断，主要是判断areaName不为空
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            // 设置默认值
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("添加区域信息失败!");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("添加区域信息失败:" + e.toString());
                return false;
            }
        } else {
            System.out.println("区域信息不能为空！");
            return false;
        }
    }

    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        // 空值判断，主要是areaId不为空
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            // 设置默认值
            area.setLastEditTime(new Date());
            try {
                // 更新区域信息
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("更改失败");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("更新区域信息失败:" + e.toString());
                return false;
            }
        } else {
            System.out.println("信息不能为空");
            return false;
        }
    }

    @Transactional
    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                // 删除区域信息
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    System.out.println("删除区域信息失败!");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("删除区域信息失败:" + e.toString());
                return false;
            }
        } else {
            System.out.println("区域Id不能为空！");
            return false;
        }
    }
}
