package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapper.UserMapper;
import model.Page;
import model.User;
import service.IUserService;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public void save(User user) {
        mapper.insert(user);
    }

    @Override
    public void modify(User user) {
        mapper.update(user);
    }

    @Override
    public void remove(User user) {
        mapper.delete(user);
    }

    @Override
    // 通过id查询
    @Transactional(readOnly = true)
    public User findById(User user) {
        User findUser = mapper.selectById(user);
        return findUser;
    }

    // 通过username查询
    @Transactional(readOnly = true)
    @Override
    public User findByNanme(User user) {
        User findUser = mapper.selectByNanme(user);
        return findUser;

    }

    // 查询所有
    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        List<User> list = mapper.selectAll();
        return list;

    }

    // 查询总记录数
    @Transactional(readOnly = true)
    public Integer findCount() {
        int count = mapper.selectCount();
        return count;

    }

    // 查询分页
    @Transactional(readOnly = true)
    public List<User> findByPage(Page page) {

        List<User> list = mapper.selectByPage(page);
        return list;

    }
}
