/*     */ package Integracao_CIGAM_Pedido;
/*     */ 
/*     */ import Integracao_CIGAM_PedidoItem.CIGAMPedidoItem;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CIGAMPedido
/*     */ {
/*     */   String codigoRepresentante;
/*     */   String dataPedido;
/*     */   String ordemEnderecoEntrega;
/*     */   String prazoProgramado;
/*     */   String dataEntrega;
/*     */   String tipoFrete;
/*     */   String codigoUnidadeNegocio;
/*     */   String codigoCliente;
/*     */   String viaTransporte;
/*     */   String pedidoAmostra;
/*     */   String alteracaoFt;
/*     */   String controle;
/*     */   String tipoNota;
/*     */   String calcularImpostos;
/*     */   List<CIGAMPedidoItem> itens;
/*     */   
/*     */   public String getCodigoRepresentante()
/*     */   {
/*  36 */     return this.codigoRepresentante;
/*     */   }
/*     */   
/*     */   public void setCodigoRepresentante(String codigoRepresentante) {
/*  40 */     this.codigoRepresentante = codigoRepresentante;
/*     */   }
/*     */   
/*     */   public String getDataPedido() {
/*  44 */     return this.dataPedido;
/*     */   }
/*     */   
/*     */   public void setDataPedido(String dataPedido) {
/*  48 */     this.dataPedido = dataPedido;
/*     */   }
/*     */   
/*     */   public String getOrdemEnderecoEntrega() {
/*  52 */     return this.ordemEnderecoEntrega;
/*     */   }
/*     */   
/*     */   public void setOrdemEnderecoEntrega(String ordemEnderecoEntrega) {
/*  56 */     this.ordemEnderecoEntrega = ordemEnderecoEntrega;
/*     */   }
/*     */   
/*     */   public String getPrazoProgramado() {
/*  60 */     return this.prazoProgramado;
/*     */   }
/*     */   
/*     */   public void setPrazoProgramado(String prazoProgramado) {
/*  64 */     this.prazoProgramado = prazoProgramado;
/*     */   }
/*     */   
/*     */   public String getDataEntrega() {
/*  68 */     return this.dataEntrega;
/*     */   }
/*     */   
/*     */   public void setDataEntrega(String dataEntrega) {
/*  72 */     this.dataEntrega = dataEntrega;
/*     */   }
/*     */   
/*     */   public String getTipoFrete() {
/*  76 */     return this.tipoFrete;
/*     */   }
/*     */   
/*     */   public void setTipoFrete(String tipoFrete) {
/*  80 */     this.tipoFrete = tipoFrete;
/*     */   }
/*     */   
/*     */   public String getCodigoUnidadeNegocio() {
/*  84 */     return this.codigoUnidadeNegocio;
/*     */   }
/*     */   
/*     */   public void setCodigoUnidadeNegocio(String codigoUnidadeNegocio) {
/*  88 */     this.codigoUnidadeNegocio = codigoUnidadeNegocio;
/*     */   }
/*     */   
/*     */   public String getCodigoCliente() {
/*  92 */     return this.codigoCliente;
/*     */   }
/*     */   
/*     */   public void setCodigoCliente(String codigoCliente) {
/*  96 */     this.codigoCliente = codigoCliente;
/*     */   }
/*     */   
/*     */   public String getViaTransporte() {
/* 100 */     return this.viaTransporte;
/*     */   }
/*     */   
/*     */   public void setViaTransporte(String viaTransporte) {
/* 104 */     this.viaTransporte = viaTransporte;
/*     */   }
/*     */   
/*     */   public String getPedidoAmostra() {
/* 108 */     return this.pedidoAmostra;
/*     */   }
/*     */   
/*     */   public void setPedidoAmostra(String pedidoAmostra) {
/* 112 */     this.pedidoAmostra = pedidoAmostra;
/*     */   }
/*     */   
/*     */   public String getAlteracaoFt() {
/* 116 */     return this.alteracaoFt;
/*     */   }
/*     */   
/*     */   public void setAlteracaoFt(String alteracaoFt) {
/* 120 */     this.alteracaoFt = alteracaoFt;
/*     */   }
/*     */   
/*     */   public String getControle() {
/* 124 */     return this.controle;
/*     */   }
/*     */   
/*     */   public void setControle(String controle) {
/* 128 */     this.controle = controle;
/*     */   }
/*     */   
/*     */   public String getTipoNota() {
/* 132 */     return this.tipoNota;
/*     */   }
/*     */   
/*     */   public void setTipoNota(String tipoNota) {
/* 136 */     this.tipoNota = tipoNota;
/*     */   }
/*     */   
/*     */   public String getCalcularImpostos() {
/* 140 */     return this.calcularImpostos;
/*     */   }
/*     */   
/*     */   public void setCalcularImpostos(String calcularImpostos) {
/* 144 */     this.calcularImpostos = calcularImpostos;
/*     */   }
/*     */   
/*     */   public List<CIGAMPedidoItem> getItens() {
/* 148 */     return this.itens;
/*     */   }
/*     */   
/*     */   public void setItens(List<CIGAMPedidoItem> itens) {
/* 152 */     this.itens = itens;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM_Pedido/CIGAMPedido.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */