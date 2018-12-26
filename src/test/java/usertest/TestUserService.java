package usertest;

import org.junit.Before;
import org.junit.Test;

import model.User;
import service.IUserService;
import service.impl.IUserServiceImpl;

public class TestUserService {

	private IUserService service ;
	
	@Before
	public void init(){
		service = new IUserServiceImpl();
	}
	
	@Test
	public void userSaveAndUpdate(){
		User user = new User();
		user.setUsername("soap");
		user.setPassword("description");
		user.setSex(1);
		user.setPhone(110);
		user.setAge(22);
		user.setAddress("杭州");
		user.setIsadmin(1);
		
		service.save(user);
		
		//改一下地址
		user.setAddress("天津");
		user.setId(22);
		System.out.println(user);
		
		service.modify(user);
		
		
	}

	public static void main(String[] args) {
		//Integer i = 
	}
}
