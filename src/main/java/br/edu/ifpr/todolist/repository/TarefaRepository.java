package br.edu.ifpr.todolist.repository;

import br.edu.ifpr.todolist.model.Tarefa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TarefaRepository {
    private final Map<Long, Tarefa> tarefas = new LinkedHashMap<>();
    private long proximoId = 1;

    public synchronized Tarefa save(Tarefa tarefa) {
        if (tarefa.getId() == null) {
            tarefa.setId(proximoId++);
        }
        tarefas.put(tarefa.getId(), tarefa);
        return tarefa;
    }

    public synchronized List<Tarefa> findAll() {
        return new ArrayList<>(tarefas.values());
    }

    public synchronized Optional<Tarefa> findById(Long id) {
        return Optional.ofNullable(tarefas.get(id));
    }

    public synchronized void delete(Tarefa tarefa) {
        tarefas.remove(tarefa.getId());
    }
}
