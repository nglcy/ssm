package mapper;

import java.util.List;

import model.Page;
import model.Provider;

public interface  ProviderMapper {

	// 增加
	public abstract void insert(Provider provider);

	// 按照id修改
	public abstract void update(Provider provider);

	// 按照id
	public abstract void delete(Provider provider);

	// 通过id查询
	public abstract Provider selectById(Provider provider);

	// 通过username查询
	public abstract Provider selectByNanme(Provider provider);

	// 查询所有
	public abstract List<Provider> selectAll();

	// 查询总记录数
	public abstract Integer selectCount();

	// 查询分页
	public abstract List<Provider> selectByPage(Page page);
	
	public abstract List<Provider> selectLike(Provider provider);

}
