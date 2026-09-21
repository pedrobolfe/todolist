package br.edu.ifpr.todolist.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpr.todolist.model.Tarefa;
import br.edu.ifpr.todolist.repository.TarefaRepository;
import org.springframework.web.bind.annotation.PostMapping;


@RestController 
@RequestMapping("/tarefas")
public class TarefaController {
    private TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    public Tarefa cadastrar(@RequestBody Tarefa tarefa){
        if(tarefa.getTitulo()== null || tarefa.getTitulo().isBlank()) {
            throw new RuntimeException("Título obrigatório");
        }

        tarefa.setStatus("PENDENTE");
        return repository.save(tarefa);
    }

    


}
