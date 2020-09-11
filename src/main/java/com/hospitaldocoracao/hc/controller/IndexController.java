package com.hospitaldocoracao.hc.controller;


import com.hospitaldocoracao.hc.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    PacienteRepository repository;


    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("Home");
        modelAndView.addObject("pacientes" , repository.listarPacienteNaoAtendidos());
        return modelAndView;
    }





}
