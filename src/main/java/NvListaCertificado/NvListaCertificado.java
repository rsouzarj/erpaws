package NvListaCertificado;

import java.util.Date;

public class NvListaCertificado
{
    private String seqNvListaCertificado;
    private Date dataCadastro;
    private String tipoCertificado;
    private String seqEmpresa;
    private String seqUsuario;
    private String usuario;
    private String nomeArquivo;
    
    public Date getDataCadastro() {
        return this.dataCadastro;
    }
    
    public void setDataCadastro(final Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public String getTipoCertificado() {
        return this.tipoCertificado;
    }
    
    public void setTipoCertificado(final String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }
    
    public String getSeqUsuario() {
        return this.seqUsuario;
    }
    
    public void setSeqUsuario(final String seqUsuario) {
        this.seqUsuario = seqUsuario;
    }
    
    public String getNomeArquivo() {
        return this.nomeArquivo;
    }
    
    public void setNomeArquivo(final String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    
    public String getSeqNvListaCertificado() {
        return this.seqNvListaCertificado;
    }
    
    public void setSeqNvListaCertificado(final String seqNvListaCertificado) {
        this.seqNvListaCertificado = seqNvListaCertificado;
    }
    
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }
    
    public String getSeqEmpresa() {
        return this.seqEmpresa;
    }
    
    public void setSeqEmpresa(final String seqEmpresa) {
        this.seqEmpresa = seqEmpresa;
    }
}
