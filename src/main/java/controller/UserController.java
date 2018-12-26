package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.User;
import service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	// 去登陆界面
	@RequestMapping("/tologin.do")
	public String toLogin() {

		return "login";
	}

	// 通过ajax验证.返回结果值
	@ResponseBody
	@RequestMapping("/login.do")
	public boolean login(HttpSession session, User user, String username) {

		if (user != null) {

			User findUser = service.findByNanme(user);
			if (findUser != null && findUser.getPassword().equals(user.getPassword())) {
				session.setAttribute("sessionUser", findUser);
				return true;
			}
		}
		return false;
	}

	@RequestMapping("/index.do")
	public String index() {

		return "index";
	}

	@RequestMapping("/top.do")
	public String top() {
		return "top";
	}

	@RequestMapping("/left.do")
	public String left() {
		return "left";
	}

	@RequestMapping("/welcome.do")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping("/userlist.do")
	public String userList(Model model) {
		List<User> list = service.findAll();
		model.addAttribute("userlist", list);
		return "userlist";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("sessionUser");
		return "login";
	}

	@RequestMapping("/userdelete.do")
	public String userString(User user) {
		// 根据id来删除用户
		service.remove(user);
		return "forward:/user/userlist.do";
	}

	@RequestMapping("/userinfo.do")
	public String userInfo(User user, Model model) {
		User findUser = service.findById(user);
		model.addAttribute("user", findUser);
		return "userinfo";
	}

	@RequestMapping("/usermodify.do")
	public String userModify(User user) {
		
		service.modify(user);
		return "forward:/user/userlist.do";
	}

	@RequestMapping("/topw.do")
	public String toPW(User user, Model model) {
		model.addAttribute("user", user);
		return "pw";
	}

	@ResponseBody
	@RequestMapping("/pw.do")
	public String pw(User user) {

		User findUser = service.findById(user);
		if (findUser != null) {
			if (findUser.getPassword().equals(user.getPassword())) {
				return "true";
			}
		}
		return "false";
	}

	@RequestMapping("/pwmodify.do")
	public String pwModify(User user, HttpSession session) {
		
		service.modify(user);
		session.removeAttribute("sessionUser");
		return "forward:/user/tologin.do";
	}

	@RequestMapping("/touseradd.do")
	public String pwModify() {

		return "useradd";
	}

	@RequestMapping("/useradd.do")
	public String userAdd(User user) {
		service.save(user);

		return "forward:/user/userlist.do";
	}

	@ResponseBody
	@RequestMapping("/usercheck.do")
	public String userCheck(User user) {

		User findUser = service.findByNanme(user);
		if (findUser == null) {
			return "true";
		}
		return "false";
	}

}
