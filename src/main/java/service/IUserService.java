package service;

import java.util.List;

import model.Page;
import model.User;

public interface IUserService {

	public void save(User user) ;

	public void modify(User user);

	public void remove(User user);

	// 通过id查询
	public User findById(User user);

	// 通过username查询
	public User findByNanme(User user);
	
	// 查询所有
	public List<User> findAll();

	// 查询总记录数
	public Integer findCount();

	// 查询分页
	public List<User> findByPage(Page page);
}
