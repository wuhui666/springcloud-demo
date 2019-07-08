package application.service;

import application.mappers.DeptMapper;
import application.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wuhui
 * @time: 2019/7/1 13:45
 * @desc:
 */
@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    DeptMapper mapper;
    @Override
    public Dept findDeptById(long id) {
        return mapper.selectByPrimaryKey(id);
    }
}
