package com.lpcoder.agile.mind.palace.service;

import com.lpcoder.agile.mind.palace.entity.TypeDO;

import ren.lingpai.lpagile.annotation.Service;
import ren.lingpai.lpagile.part.DataBasePart;

import java.util.List;

/**
 * Created by lrp on 17-5-14.
 */
@Service
public class TypeService {

    /**
     * 获取父ID获取Type列表
     */
    public List<TypeDO> getListByPid(Integer pid) {
        String sql = "SELECT " +
                " m_id as id , m_pid as pId , m_topic as topic , m_direction as direction " +
                " , m_expanded as expanded " +
                " FROM t_type where m_pid = ? ";
        return DataBasePart.queryEntityList(TypeDO.class, sql, pid);
    }

    /**
     * 获取ID获取Type
     */
    public TypeDO getById(Integer id) {
        String sql = "SELECT " +
                " m_id as id , m_pid as pId , m_topic as topic , m_direction as direction " +
                " , m_expanded as expanded " +
                " FROM t_type where m_id = ? ";
        return DataBasePart.queryEntity(TypeDO.class, sql, id);
    }

    /**
     * 获取Type列表
     */
    public List<TypeDO> getTypeList() {
        String sql = "SELECT " +
                " m_id as id , m_pid as pId , m_topic as topic , m_direction as direction " +
                " , m_expanded as expanded " +
                " FROM t_type where m_id > 1 ";
        return DataBasePart.queryEntityList(TypeDO.class, sql);
    }

}
