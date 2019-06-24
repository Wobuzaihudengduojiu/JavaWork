package dao;

import pojo.entity.AutionInfoDo;

import java.util.List;


public interface AutionInfoDAO extends BaseDAO{


    /**
     * 查询所有商品
     */
    List<AutionInfoDo> selectAllAution() throws Exception;


    /**
     * 通过商品id查询商品详情
     */
    AutionInfoDo queryAutionById(String autionId) throws Exception;










}
