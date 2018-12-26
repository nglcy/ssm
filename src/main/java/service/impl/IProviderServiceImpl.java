package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapper.ProviderMapper;
import model.Page;
import model.Provider;
import service.IProviderService;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
public class IProviderServiceImpl implements IProviderService {

	@Autowired
	private ProviderMapper mapper;
	
	@Override
	public void save(Provider provider) {
		mapper.insert(provider);
	}

	@Override
	public void modify(Provider provider) {
		mapper.update(provider);
	}

	@Override
	public void remove(Provider provider) {
		mapper.delete(provider);
	}

	@Transactional(readOnly=true)
	@Override
	public Provider findById(Provider provider) {
		return mapper.selectById(provider);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Provider findByName(Provider provider) {
		return mapper.selectByNanme(provider);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Provider> findAll() {
		return mapper.selectAll();
	}

	@Transactional(readOnly=true)
	@Override
	public Integer findCount() {
		return mapper.selectCount();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Provider> findByPage(Page page) {
		return mapper.selectByPage(page);
	}

	@Override
	public List<Provider> findLike(Provider provider) {
		
		return mapper.selectLike(provider);
	}

}
