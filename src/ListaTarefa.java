import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ListaTarefa {
    static HashSet<Tarefa> listaTarefa = new HashSet<>();

    public static void main(String[] args) {
        // Adicionando tarefas à lista
        adicionarTarefa("Estudar Java");
        adicionarTarefa("Fazer exercícios físicos");
        adicionarTarefa("Organizar a mesa de trabalho");
        adicionarTarefa("Ler livro");
        adicionarTarefa("Preparar apresentação");

        System.out.println("--------------------------------------------------");
        exibirTarefas();
        System.out.println(contarTarefas());
        System.out.println("--------------------------------------------------");
        marcarTarefaConcluida("Estudar Java");
        marcarTarefaConcluida("Fazer exercícios físicos");
        marcarTarefaConcluida("Ler livro");
        System.out.println("Concluidas");
        obterTarefasConcluidas().forEach(System.out::println);
        System.out.println("Pendentes");
        obterTarefasPendentes().forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        marcarTarefaPendente("Ler livro");
        exibirTarefas();
        System.out.println("--------------------------------------------------");
        limparListaTarefas();
        exibirTarefas();
        System.out.println(contarTarefas());
        System.out.println("--------------------------------------------------");
    }

    static void adicionarTarefa(String descricao) {
        listaTarefa.add(new Tarefa(descricao));
    }

    static void removerTarefa(String descricao) {
        listaTarefa.removeIf(conteudo -> Objects.equals(conteudo.getDescricao(), descricao));
    }

    static void exibirTarefas() {
        listaTarefa.forEach(System.out::println);
    }

    static String contarTarefas() {
        return "Temos "+listaTarefa.size()+" tarefas na lista.";
    }

    static Set<Tarefa> obterTarefasConcluidas() {
        HashSet<Tarefa> tarefasConcluidas = new HashSet<>();

        for (Tarefa tarefa : listaTarefa) {
            if (Objects.equals(tarefa.isConcluida(), true)) {
                tarefasConcluidas.add(tarefa);
            }
        }

        return tarefasConcluidas;
    }

    static Set<Tarefa> obterTarefasPendentes() {
        HashSet<Tarefa> tarefasPendentes = new HashSet<>();

        for (Tarefa tarefa : listaTarefa) {
            if (Objects.equals(tarefa.isConcluida(), false)) {
                tarefasPendentes.add(tarefa);
            }
        }

        return tarefasPendentes;
    }

    static void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefa : listaTarefa) {
            if (Objects.equals(tarefa.getDescricao(), descricao)) {
                tarefa.setConcluida(true);
            }
        }
    }

    static void marcarTarefaPendente(String descricao) {
        for (Tarefa tarefa : listaTarefa) {
            if (Objects.equals(tarefa.getDescricao(), descricao)) {
                tarefa.setConcluida(false);
            }
        }
    }

    static void limparListaTarefas() {
        listaTarefa.clear();
    }

}