package modelo;

public class Usuario {

    private int usuCodigo;
    private String usuLogin;
    private String usuSenha;
    private String usuEmail;
    private Clientes usuCliente;

    public Usuario() {
    }

    public Usuario(int usuCodigo, String usuLogin, String usuSenha, String usuEmail, Clientes usuCliente) {
        this.usuCodigo = usuCodigo;
        this.usuLogin = usuLogin;
        this.usuSenha = usuSenha;
        this.usuEmail = usuEmail;
        this.usuCliente = usuCliente;
    }

    public int getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(int usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public Clientes getUsuCliente() {
        return usuCliente;
    }

    public void setUsuCliente(Clientes usuCliente) {
        this.usuCliente = usuCliente;
    }

    @Override
    public String toString() {
        return "Usuario{"
                + "usuCodigo=" + usuCodigo
                + ", usuLogin=" + usuLogin
                + ", usuSenha=" + usuSenha
                + ", usuEmail=" + usuEmail
                + ", usuCodCliente=" + usuCliente
                + '}';
    }
}
