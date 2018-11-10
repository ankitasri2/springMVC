package com.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dataholder.Contact;
@Controller
@SessionAttributes
public class ContactController {
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute("contact")    Contact contact, BindingResult result) {
        System.out.println(contact.getFirstname()+contact.getLastname());
        return new ModelAndView("success", "contactData", contact);
    }
   
    
    @RequestMapping("/contact")
    public ModelAndView showContacts() {
    	System.out.println("hello");
        return new ModelAndView("contact", "command", new Contact());
    }
    
    @RequestMapping("/modeldata")
    public String displayModal(Model model) {
    	System.out.println(">>>>>Data From Model of Spring MVC");
    	model.addAttribute("modelMsg", "Data From Model of Spring MVC");
    	model.addAttribute("modelAttr1", "Model Attribute another param");
    	Map<String, String> map = new HashMap<String, String>();
        map.put("map1", "mvc1");
        map.put("map2", "mvc2");
        
        model.mergeAttributes(map);
        return "modeldata";
    }
    
    @RequestMapping("/modelmap")
    public String displayModelMap(ModelMap modelMap) {
    	System.out.println(">>>>>Data From Model Map");
    	modelMap.addAttribute("modelMap1", "Model Map 1");
    	modelMap.addAttribute("modelMap2", "Model Map 2");
        return "modelmap";
    }
}
