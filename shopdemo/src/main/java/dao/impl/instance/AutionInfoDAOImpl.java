package dao.impl.instance;

import dao.AutionInfoDAO;
import pojo.entity.AutionInfoDo;

import java.util.List;
import java.util.stream.Collectors;

public class AutionInfoDAOImpl implements AutionInfoDAO {


    @Override
    public List<AutionInfoDo> selectAllAution() throws Exception{

        return AutionList.list;
    }

    @Override
    public AutionInfoDo queryAutionById(String autionId) throws Exception{

        return  AutionList.list.stream()
                .filter(v-> autionId.equals(v.getAutionId()))
                .collect(Collectors.toList())
                .get(0);
    }


}
