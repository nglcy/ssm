package mapper;

import java.util.List;

import model.Bill;
import model.Page;

public interface BillMapper {

	// 增加
	public abstract void insert(Bill bill);

	// 按照id修改
	public abstract void update(Bill bill);

	// 按照id(或者商品名称)删除
	public abstract void delete(Bill bill);

	// 通过id查询
	public abstract Bill selectById(Bill bill);

	// 通过username查询
	public abstract Bill selectByName(Bill bill);
	
	public abstract List<Bill> selectByUsername(Bill bill);

	// 查询所有
	public abstract List<Bill> selectAll();

	// 查询总记录数
	public abstract Integer selectCount();

	// 查询分页
	public abstract List<Bill> selectByPage(Page page);
	
	public abstract List<Bill> selectLike(Bill bill);

}
