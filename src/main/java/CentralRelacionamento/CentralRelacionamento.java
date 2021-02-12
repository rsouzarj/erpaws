/*     */ package CentralRelacionamento;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CentralRelacionamento
/*     */ {
/*     */   private String seqEmpresa;
/*     */   private String seqUsuario;
/*     */   private String nivel;
/*     */   private Date clienteDataCadastro;
/*     */   private String usuario;
/*     */   private String seqParceiroVendedor;
/*     */   private String vendedor;
/*     */   private String tipoParceiro;
/*     */   private String seqParceiroCliente;
/*     */   private String cliente;
/*     */   private String clienteTipo;
/*     */   private String clienteDocumento;
/*     */   private String clienteFantasia;
/*     */   private String clienteLogradouro;
/*     */   private String clienteNumero;
/*     */   private String clienteComplemento;
/*     */   private String clienteBairro;
/*     */   private String clienteCidade;
/*     */   private String clienteUf;
/*     */   private String clienteCep;
/*     */   private String clienteTelefone1;
/*     */   private String clienteTelefone2;
/*     */   private String clienteTelefone3;
/*     */   private String clienteTelefone4;
/*     */   private String clienteEmail;
/*     */   private String clientePessoaContato;
/*     */   private String seqParceiroUsuario;
/*     */   
/*     */   public String getNivel()
/*     */   {
/*  45 */     return this.nivel;
/*     */   }
/*     */   
/*     */   public void setNivel(String nivel) {
/*  49 */     this.nivel = nivel;
/*     */   }
/*     */   
/*     */   public Date getClienteDataCadastro() {
/*  53 */     return this.clienteDataCadastro;
/*     */   }
/*     */   
/*     */   public void setClienteDataCadastro(Date clienteDataCadastro) {
/*  57 */     this.clienteDataCadastro = clienteDataCadastro;
/*     */   }
/*     */   
/*     */   public String getUsuario() {
/*  61 */     return this.usuario;
/*     */   }
/*     */   
/*     */   public void setUsuario(String usuario) {
/*  65 */     this.usuario = usuario;
/*     */   }
/*     */   
/*     */   public String getSeqParceiroVendedor() {
/*  69 */     return this.seqParceiroVendedor;
/*     */   }
/*     */   
/*     */   public void setSeqParceiroVendedor(String seqParceiroVendedor) {
/*  73 */     this.seqParceiroVendedor = seqParceiroVendedor;
/*     */   }
/*     */   
/*     */   public String getVendedor() {
/*  77 */     return this.vendedor;
/*     */   }
/*     */   
/*     */   public void setVendedor(String vendedor) {
/*  81 */     this.vendedor = vendedor;
/*     */   }
/*     */   
/*     */   public String getTipoParceiro() {
/*  85 */     return this.tipoParceiro;
/*     */   }
/*     */   
/*     */   public void setTipoParceiro(String tipoParceiro) {
/*  89 */     this.tipoParceiro = tipoParceiro;
/*     */   }
/*     */   
/*     */   public String getSeqParceiroCliente() {
/*  93 */     return this.seqParceiroCliente;
/*     */   }
/*     */   
/*     */   public void setSeqParceiroCliente(String seqParceiroCliente) {
/*  97 */     this.seqParceiroCliente = seqParceiroCliente;
/*     */   }
/*     */   
/*     */   public String getCliente() {
/* 101 */     return this.cliente;
/*     */   }
/*     */   
/*     */   public void setCliente(String cliente) {
/* 105 */     this.cliente = cliente;
/*     */   }
/*     */   
/*     */   public String getClienteTipo() {
/* 109 */     return this.clienteTipo;
/*     */   }
/*     */   
/*     */   public void setClienteTipo(String clienteTipo) {
/* 113 */     this.clienteTipo = clienteTipo;
/*     */   }
/*     */   
/*     */   public String getClienteDocumento() {
/* 117 */     return this.clienteDocumento;
/*     */   }
/*     */   
/*     */   public void setClienteDocumento(String clienteDocumento) {
/* 121 */     this.clienteDocumento = clienteDocumento;
/*     */   }
/*     */   
/*     */   public String getClienteFantasia() {
/* 125 */     return this.clienteFantasia;
/*     */   }
/*     */   
/*     */   public void setClienteFantasia(String clienteFantasia) {
/* 129 */     this.clienteFantasia = clienteFantasia;
/*     */   }
/*     */   
/*     */   public String getClienteLogradouro() {
/* 133 */     return this.clienteLogradouro;
/*     */   }
/*     */   
/*     */   public void setClienteLogradouro(String clienteLogradouro) {
/* 137 */     this.clienteLogradouro = clienteLogradouro;
/*     */   }
/*     */   
/*     */   public String getClienteNumero() {
/* 141 */     return this.clienteNumero;
/*     */   }
/*     */   
/*     */   public void setClienteNumero(String clienteNumero) {
/* 145 */     this.clienteNumero = clienteNumero;
/*     */   }
/*     */   
/*     */   public String getClienteComplemento() {
/* 149 */     return this.clienteComplemento;
/*     */   }
/*     */   
/*     */   public void setClienteComplemento(String clienteComplemento) {
/* 153 */     this.clienteComplemento = clienteComplemento;
/*     */   }
/*     */   
/*     */   public String getClienteBairro() {
/* 157 */     return this.clienteBairro;
/*     */   }
/*     */   
/*     */   public void setClienteBairro(String clienteBairro) {
/* 161 */     this.clienteBairro = clienteBairro;
/*     */   }
/*     */   
/*     */   public String getClienteCidade() {
/* 165 */     return this.clienteCidade;
/*     */   }
/*     */   
/*     */   public void setClienteCidade(String clienteCidade) {
/* 169 */     this.clienteCidade = clienteCidade;
/*     */   }
/*     */   
/*     */   public String getClienteUf() {
/* 173 */     return this.clienteUf;
/*     */   }
/*     */   
/*     */   public void setClienteUf(String clienteUf) {
/* 177 */     this.clienteUf = clienteUf;
/*     */   }
/*     */   
/*     */   public String getClienteCep() {
/* 181 */     return this.clienteCep;
/*     */   }
/*     */   
/*     */   public void setClienteCep(String clienteCep) {
/* 185 */     this.clienteCep = clienteCep;
/*     */   }
/*     */   
/*     */   public String getClienteTelefone1() {
/* 189 */     return this.clienteTelefone1;
/*     */   }
/*     */   
/*     */   public void setClienteTelefone1(String clienteTelefone1) {
/* 193 */     this.clienteTelefone1 = clienteTelefone1;
/*     */   }
/*     */   
/*     */   public String getClienteTelefone2() {
/* 197 */     return this.clienteTelefone2;
/*     */   }
/*     */   
/*     */   public void setClienteTelefone2(String clienteTelefone2) {
/* 201 */     this.clienteTelefone2 = clienteTelefone2;
/*     */   }
/*     */   
/*     */   public String getClienteTelefone3() {
/* 205 */     return this.clienteTelefone3;
/*     */   }
/*     */   
/*     */   public void setClienteTelefone3(String clienteTelefone3) {
/* 209 */     this.clienteTelefone3 = clienteTelefone3;
/*     */   }
/*     */   
/*     */   public String getClienteTelefone4() {
/* 213 */     return this.clienteTelefone4;
/*     */   }
/*     */   
/*     */   public void setClienteTelefone4(String clienteTelefone4) {
/* 217 */     this.clienteTelefone4 = clienteTelefone4;
/*     */   }
/*     */   
/*     */   public String getClienteEmail() {
/* 221 */     return this.clienteEmail;
/*     */   }
/*     */   
/*     */   public void setClienteEmail(String clienteEmail) {
/* 225 */     this.clienteEmail = clienteEmail;
/*     */   }
/*     */   
/*     */   public String getClientePessoaContato() {
/* 229 */     return this.clientePessoaContato;
/*     */   }
/*     */   
/*     */   public void setClientePessoaContato(String clientePessoaContato) {
/* 233 */     this.clientePessoaContato = clientePessoaContato;
/*     */   }
/*     */   
/*     */   public String getSeqParceiroUsuario() {
/* 237 */     return this.seqParceiroUsuario;
/*     */   }
/*     */   
/*     */   public void setSeqParceiroUsuario(String seqParceiroUsuario) {
/* 241 */     this.seqParceiroUsuario = seqParceiroUsuario;
/*     */   }
/*     */   
/*     */   public String getSeqEmpresa() {
/* 245 */     return this.seqEmpresa;
/*     */   }
/*     */   
/*     */   public void setSeqEmpresa(String seqEmpresa) {
/* 249 */     this.seqEmpresa = seqEmpresa;
/*     */   }
/*     */   
/*     */   public String getSeqUsuario() {
/* 253 */     return this.seqUsuario;
/*     */   }
/*     */   
/*     */   public void setSeqUsuario(String seqUsuario) {
/* 257 */     this.seqUsuario = seqUsuario;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/CentralRelacionamento/CentralRelacionamento.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */