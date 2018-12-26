package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Bill;
import model.Provider;
import service.IBillService;
import service.IProviderService;

@Controller
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private IBillService service;
	
	@Autowired
	private IProviderService providerService;

	@RequestMapping("/billlist.do")
	public String billList(HttpSession session, Model model) {

		List<Bill> list  = service.findAll();

		model.addAttribute("list", list);

		return "billlist";
	}

	@RequestMapping("/billinfo.do")
	public String billList(Bill bill, Model model) {

		bill = service.findById(bill);
		List<Provider> list = providerService.findAll();
		
		model.addAttribute("bill", bill);
		model.addAttribute("list", list);
		
		return "billinfo";
	}
	
	@RequestMapping("/billmodify.do")
	public String billModify(Bill bill) {
		System.out.println("----------------------");
		
		System.out.println(bill.getId()+","+bill.getTrading_unit()+","+bill.getNum());
		service.modify(bill);
		
		return "forward:/bill/billlist.do";
	}
	
	@RequestMapping("/tobilladd.do")
	public String toBillAdd(Model model){
		List<Provider> list = providerService.findAll();
		
		model.addAttribute("list", list);
		return "billadd";
	}
	@RequestMapping("/billadd.do")
	public String billAdd(Bill bill){
		bill.setBdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		service.save(bill);
		return "forward:/bill/billlist.do";
	}
	
	@RequestMapping("/billlike.do")
	public String billLike(Bill bill,Model model){
		bill.setGname("%"+bill.getGname()+"%"); 
		List<Bill> list = service.findLike(bill);
		model.addAttribute("list", list);
		
		return "billlist";
	}
	
	

}
