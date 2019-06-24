package service.impl;

import dao.AutionInfoDAO;
import pojo.entity.AutionInfoDo;
import pojo.entity.param.Page;
import service.AutionInfoService;
import utils.DaoFactory;
import utils.factory.FactoryProducer;

import java.util.List;

public class AutionServiceImpl implements AutionInfoService {


    AutionInfoDAO autionInfoDAO= (AutionInfoDAO) FactoryProducer.getFactory(FactoryProducer.DAO_FACTORY)
            .getDao(DaoFactory.AUTION_INFO_DAO_CLASS_PATH);


    @Override
    public Page<AutionInfoDo> selectAllAutionInfo(int pageSize, int pageIndex)  {


        List<AutionInfoDo> list=null;

        try {

            list=autionInfoDAO.selectAllAution();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return new Page<>(list,pageIndex,pageSize);
    }
}
