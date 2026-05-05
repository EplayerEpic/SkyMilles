package modelo;

public class PontoTuristico {
    private int codPonto;
    private String descricao;
    private String endereco;
    private Cidade cidade;

    public PontoTuristico() {}

    public PontoTuristico(int codPonto, String descricao, String endereco, Cidade cidade) {
        this.codPonto = codPonto;
        this.descricao = descricao;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    // Getters e Setters
    public int getCodPonto() { return codPonto; }
    public void setCodPonto(int codPonto) { this.codPonto = codPonto; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public Cidade getCodCidade() { return cidade; }
    public void setCodCidade(Cidade cidade) { this.cidade = cidade; }

    @Override
    public String toString() {
        return "PontoTuristico{" + "cod_ponto=" + codPonto + ", descricao=" + descricao + 
               ", endereco=" + endereco + ", cod_cidade=" + cidade + '}';
    }
}