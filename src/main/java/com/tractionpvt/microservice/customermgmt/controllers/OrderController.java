package com.tractionpvt.microservice.customermgmt.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tractionpvt.microservice.customermgmt.dto.OrderDto;
import com.tractionpvt.microservice.customermgmt.restapi.OrderDtoList;
import com.tractionpvt.microservice.customermgmt.service.CustomerService;
import com.tractionpvt.microservice.customermgmt.service.RemoteOrderService;

@Controller
@RequestMapping(path = "/controller/order")
public class OrderController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RemoteOrderService orderService;
	
	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String newOrder(Model model) {
		model.addAttribute("order", new OrderDto());
		return "create_customer_order";
	}
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createOrder(@RequestParam(name = "customerId") Long customerId,
			@ModelAttribute("order") @Valid OrderDto orderDto, BindingResult result, 
			RedirectAttributes redirectAttr) {
		
		if(result.hasErrors())
			return "create_customer_order";
		
		customerService.placeOrder(customerId,orderDto);
		redirectAttr.addFlashAttribute("success", "Orders successfully placed");
		return "redirect:/controller/customer/list";
	}
	
	@RequestMapping(path = "/{customerId}", method = RequestMethod.GET)
	public String getAllOrdersForCustomer(@PathVariable("customerId") String customerId,Model model) {
		
		OrderDtoList orderList = orderService.getAllCustomerOrdersFromRemoteOrderService(customerId);
		
		model.addAttribute("order",orderList);
		model.addAttribute("customerId", customerId);
		
		return "orders";
	}
}
