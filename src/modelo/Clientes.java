package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Clientes {

    private int cliCodigo;
    private String cliNome;
    private String cliEndereco;
    private String cliCPF;
    private String cliTelefone;
    private LocalDate cliDataNasc;
    private char cliSexo;

    public Clientes() {
    }

    public Clientes(int cliCodigo, String cliNome, String cliEndereco, String cliCPF,
            String cliTelefone, LocalDate cliDataNasc, char cliSexo) {
        this.cliCodigo = cliCodigo;
        this.cliNome = cliNome;
        this.cliEndereco = cliEndereco;
        this.cliCPF = cliCPF;
        this.cliTelefone = cliTelefone;
        this.cliDataNasc = cliDataNasc;
        this.cliSexo = cliSexo;
    }
    

    public int getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(int cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliEndereco() {
        return cliEndereco;
    }

    public void setCliEndereco(String cliEndereco) {
        this.cliEndereco = cliEndereco;
    }

    public String getCliCPF() {
        return cliCPF;
    }

    public void setCliCPF(String cliCPF) {
        this.cliCPF = cliCPF;
    }

    public String getCliTelefone() {
        return cliTelefone;
    }

    public void setCliTelefone(String cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    public LocalDate getCliDataNasc() {
        return cliDataNasc;
    }

    public void setCliDataNasc(LocalDate cliDataNasc) {
        this.cliDataNasc = cliDataNasc;
    }

    public char getCliSexo() {
        return cliSexo;
    }

    public void setCliSexo(char cliSexo) {
        this.cliSexo = cliSexo;
    }

    @Override
    public String toString() {
        return cliNome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cliNome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clientes other = (Clientes) obj;
        return Objects.equals(this.cliNome, other.cliNome);
    }
}
