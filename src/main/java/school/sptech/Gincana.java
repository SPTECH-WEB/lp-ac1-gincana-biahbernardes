package school.sptech;

public class Gincana {
    private String nome;
    private Double premio;
    private Integer qtdInscrito;
    private Boolean ativa;

    public Gincana(String nome, Double premio) {
        this.nome = nome;
        this.premio = premio;
        qtdInscrito = 0;
        ativa = true;
    }

    public void inscrever(Integer qtd) {
        if (qtd == null || qtd <= 0 || !ativa) return;
        qtdInscrito += qtd;
    }

    public Integer remover(Integer qtd) {
        if (qtd == null || qtd <= 0 || qtd > qtdInscrito || !ativa) return null;
        qtdInscrito -= qtd;
        return qtd;
    }

    public Integer desativar() {
        if (!ativa) return null;
        int retirados = qtdInscrito;
        qtdInscrito = 0;
        ativa = false;
        return retirados;
    }

    public void transferir(Gincana destino, Integer qtdATransferir) {
        if (destino == null || qtdATransferir == null || qtdATransferir <= 0) return;
        if (!ativa || !destino.getAtiva()) return;
        if (qtdATransferir > qtdInscrito) return;
        qtdInscrito -= qtdATransferir;
        destino.inscrever(qtdATransferir);
    }

    public Boolean reajustarPremio(Double reajuste) {
        if (reajuste == null || reajuste <= 0) return false;
        premio += premio * reajuste;
        return true;
    }

    public String getNome() {
        return nome;
    }

    public Double getPremio() {
        return premio;
    }

    public Integer getQtdInscrito() {
        return qtdInscrito;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}