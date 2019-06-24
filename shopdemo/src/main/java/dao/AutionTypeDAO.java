package dao;

import pojo.entity.AutionTypeDo;

import java.util.List;

public interface AutionTypeDAO extends BaseDAO {


    /**
     * 获取所有类目信息
     */
    List<AutionTypeDo> selectAllAutionType();



}
