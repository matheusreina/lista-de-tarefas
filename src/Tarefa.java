public class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        setDescricao(descricao);
        setConcluida(false);
    }

    @Override
    public String toString() {
        String conclusao = "";
        if (this.isConcluida()) {
            conclusao = "[X]";
        } else {
            conclusao = "[ ]";
        }
        return "{ "+conclusao+" | Tarefa: "+getDescricao()+" }";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
