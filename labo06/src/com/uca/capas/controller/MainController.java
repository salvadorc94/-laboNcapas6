package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student",new Student());
		mav.setViewName("form");
		return mav;
	}
	
	@RequestMapping(value="/formData", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			studentDao.save(s, 1);
		}catch(Exception e) {}
		
		students = studentDao.findAll();
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			studentDao.save(s, 0);
		}catch(Exception e) {}
		
		students = studentDao.findAll();
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/editar")
	public ModelAndView edit(@RequestParam("cstudent") Integer cstudent) {
		ModelAndView mav = new ModelAndView();
		Student student = null;
		try{
			student = studentDao.findOne(cstudent);
		}catch(Exception e) {}
		mav.addObject("student",student);
		mav.setViewName("edit");
		return mav;
	}
	
	@RequestMapping("/del")
	public ModelAndView del(@RequestParam("nombre") String name) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			studentDao.delete(name);
		}catch(Exception e) {}
		students = studentDao.findAll();
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	
	@RequestMapping("/")
	public ModelAndView initMain(){
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
		 students = studentDao.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}

}
