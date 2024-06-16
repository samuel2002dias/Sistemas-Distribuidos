package com.example.webrestmysql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping(path = "/")
    public String home(Model model) {
        model.addAttribute("ListCursos", cursoRepository.findAll());
        model.addAttribute("ListAlunos", alunoRepository.findAll());
        model.addAttribute("ListProfessores", professorRepository.findAll());
        model.addAttribute("ListDisciplinas", disciplinaRepository.findAll());
        return "index";
    }

    @GetMapping("/addAluno")
    public String showAddAlunoForm(Model model) {
        Aluno a = new Aluno();
        model.addAttribute("aluno", a);
        return "addAluno";
    }

    @PostMapping("/addAluno")
    public String addAluno(@ModelAttribute Aluno aluno) {
        alunoRepository.save(aluno);
        return "redirect:/";
    }

    @GetMapping("/deleteAluno/{id}")
    public String deleteAluno(@PathVariable(value = "id") Integer id) {
        alunoRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/updateAluno/{id}")
    public String showUpdateAlunoForm(@PathVariable(value = "id") Integer id, Model model) {
        Optional<Aluno> optional = alunoRepository.findById(id);
        Aluno aluno = null;
        if (optional.isPresent()) {
            aluno = optional.get();
        } else {
            throw new RuntimeException(" Aluno not found for id :: " + id);
        }
        model.addAttribute("aluno", aluno);
        return "updateAluno";
    }

}