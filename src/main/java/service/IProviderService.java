package service;

import java.util.List;

import model.Page;
import model.Provider;

public interface IProviderService {

	public void save(Provider provider);

	public void modify(Provider provider);

	public void remove(Provider provider);

	// 通过id查询
	public Provider findById(Provider provider);

	// 通过username查询
	public Provider findByName(Provider provider);

	// 查询所有
	public List<Provider> findAll();

	// 查询总记录数
	public Integer findCount();

	// 查询分页
	public List<Provider> findByPage(Page page);
	
	public List<Provider> findLike(Provider provider);
}
