package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Provider;
import service.IProviderService;

@Controller
@RequestMapping("/provider")
public class ProviderController {

	@Autowired
	private IProviderService service;
	
	@RequestMapping("/providerlist.do")
	public String providerList(Model model){
		List<Provider> list = service.findAll();
		model.addAttribute("list", list);
		return "providerlist";
	}
	@RequestMapping("/providerinfo.do")
	public String providerInfo(Model model,Provider provider){
		 provider = service.findById(provider);
		 model.addAttribute("provider", provider);
		return "providerinfo";
	}
	
	@RequestMapping("/providermodify.do")
	public String providerModify(Model model,Provider provider){
		service.modify(provider);
		
		return "forward:/provider/providerlist.do";
	}
	
	@RequestMapping("/toprovideradd.do")
	public String toProviderAdd(){
		
		return "provideradd";
	}
	@RequestMapping("/provideradd.do")
	public String providerAdd(Provider provider){
		service.save(provider);
		return "forward:/provider/providerlist.do";
	}
	
	@RequestMapping("/providerdelete.do")
	public String providerDelete(Provider provider){
		service.remove(provider);
		return "forward:/provider/providerlist.do";
	}
	
	@RequestMapping("/providerlike.do")
	public String providerLike(Provider provider,Model model){
		String pname=provider.getPname();
		provider.setPname("%".concat(provider.getPname()).concat("%"));
		
		List<Provider> list = service.findLike(provider);
		model.addAttribute("list", list);
		model.addAttribute("pname",pname);
		return "providerlist";
	}
	
}
