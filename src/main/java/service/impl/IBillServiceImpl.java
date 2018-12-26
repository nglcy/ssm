package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapper.BillMapper;
import model.Bill;
import model.Page;
import service.IBillService;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
public class IBillServiceImpl implements IBillService {

	@Autowired
	private BillMapper mapper;

	public void save(Bill bill) {
		mapper.insert(bill);
	}

	public void modify(Bill bill) {
		mapper.update(bill);
	}

	public void remove(Bill bill) {
		mapper.delete(bill);
	}

	// 通过id查询
	@Transactional(readOnly = true)
	public Bill findById(Bill bill) {
		Bill findBill = mapper.selectById(bill);
		return findBill;
	}

	// 通过username查询
	@Transactional(readOnly = true)
	public Bill findByName(Bill bill) {
		Bill findBill = mapper.selectByName(bill);
		return findBill;
	}

	// 查询所有
	@Transactional(readOnly = true)
	public List<Bill> findAll() {
		List<Bill> list = mapper.selectAll();
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
	public List<Bill> findByPage(Page page) {

		List<Bill> list = mapper.selectByPage(page);
		return list;

	}
	@Transactional(readOnly = true)
	@Override
	public List<Bill> findByUsername(Bill bill) {
		
		return mapper.selectByUsername(bill);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Bill> findLike(Bill bill) {
		return mapper.selectLike(bill);
	}
	
	
}
