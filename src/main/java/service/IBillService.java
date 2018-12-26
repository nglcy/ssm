package service;

import java.util.List;

import model.Bill;
import model.Page;

public interface IBillService {

	public void save(Bill bill);

	public void modify(Bill bill);

	public void remove(Bill bill);

	// 通过id查询
	public Bill findById(Bill bill);

	// 通过username查询
	public Bill findByName(Bill bill);
	
	public List<Bill> findByUsername(Bill bill);

	// 查询所有
	public List<Bill> findAll();

	// 查询总记录数
	public Integer findCount();

	// 查询分页
	public List<Bill> findByPage(Page page);
	
	public List<Bill> findLike(Bill bill);
}
