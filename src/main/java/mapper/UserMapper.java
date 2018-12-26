package mapper;

import java.util.List;

import model.Page;
import model.User;

public interface UserMapper {

	//增加
	public abstract void insert(User user);
	
	//按照id修改
	public abstract void update(User user);
	
	//按照id(或者username)删除
	public abstract void delete(User user);
	
	//通过id查询
	public abstract User selectById(User user);
	
	//通过username查询
	public abstract User selectByNanme(User user);
	
	//查询所有
	public abstract List<User> selectAll();
	
	//查询总记录数
	public abstract Integer selectCount();
	
	//查询分页
	public abstract List<User> selectByPage(Page page);
	
	
}
