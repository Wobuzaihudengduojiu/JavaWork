package service;

import pojo.entity.AutionInfoDo;
import pojo.entity.param.Page;

public interface AutionInfoService extends BaseService{


    /**
     * 用于首页显示数据
     */

    Page<AutionInfoDo> selectAllAutionInfo(int pageSize,int pageIndex);



}
