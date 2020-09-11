package com.hospitaldocoracao.hc.controller;


import com.hospitaldocoracao.hc.model.Atendimento;
import com.hospitaldocoracao.hc.model.Paciente;
import com.hospitaldocoracao.hc.repository.AtendimentoRepository;
import com.hospitaldocoracao.hc.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller("/atendimento")
public class AtendimentoController {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping("/formulario/{id}")
    public ModelAndView formulario(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("FormularioAtendimento");
        modelAndView.addObject("paciente", pacienteRepository.findById(id));
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping("/formulario/{id}")
    public String salvarConsulta(@PathVariable("id") Long id, Atendimento atendimento){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        atendimento.setPaciente(paciente.get());
        paciente.get().setAtendido(true);
        atendimentoRepository.save(atendimento);
        pacienteRepository.save(paciente.get());
        return "redirect:/";
    }





}
