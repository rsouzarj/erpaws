/*    */ package _Teste;
/*    */ 
/*    */ import CondicaoPagamento.CondicaoPagamento;
/*    */ import CondicaoPagamento.CondicaoPagamentoService;
/*    */ import Documento.Documento;
/*    */ import Documento.DocumentoService;
/*    */ import DocumentoItemMaterial.DocumentoItemMaterial;
/*    */ import FormaPagamento.FormaPagamento;
/*    */ import FormaPagamento.FormaPagamentoService;
/*    */ import MaterialPreco.MaterialPreco;
/*    */ import MaterialPreco.MaterialPrecoService;
/*    */ import Util.Situacao;
/*    */ import java.io.PrintStream;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PedidoAppTeste
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 30 */     DocumentoService documentoService = new DocumentoService();
/* 31 */     List<Documento> listaDocumento = documentoService.listarPorParceiro("64", "001");
/* 32 */     for (Documento pedido : listaDocumento) {
/* 33 */       System.out.println(pedido.getSeqDocumento() + " - " + pedido.getSeqParceiro() + " - " + pedido.getParceiro());
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 39 */     Documento documento = new Documento();
/*    */     
/*    */ 
/* 42 */     documento.setData(new Date());
/* 43 */     documento.setDataCadastro(new Date());
/* 44 */     documento.setDataPrevisaoConclusao(new Date());
/* 45 */     documento.setSeqParceiro("001");
/* 46 */     documento.setSeqEmpresa("64");
/* 47 */     documento.setSeqFormaPagamento("");
/* 48 */     documento.setSeqCondicaoPagamento("");
/*    */     
/*    */ 
/*    */ 
/* 52 */     DocumentoItemMaterial item = new DocumentoItemMaterial();
/* 53 */     item.setSeqMaterial("PR001");
/* 54 */     item.setVlUnitario(BigDecimal.valueOf(10L));
/* 55 */     item.setQtde(BigDecimal.valueOf(10.2D));
/* 56 */     documento.getListaDocumentoItemMaterial().add(item);
/*    */     
/*    */ 
/* 59 */     item = new DocumentoItemMaterial();
/* 60 */     item.setSeqMaterial("PR002");
/* 61 */     item.setVlUnitario(BigDecimal.valueOf(100L));
/* 62 */     item.setQtde(BigDecimal.valueOf(1.2D));
/* 63 */     documento.getListaDocumentoItemMaterial().add(item);
/*    */     
/* 65 */     documentoService.salvar(documento);
/*    */     
/*    */ 
/* 68 */     MaterialPrecoService materialPrecoService = new MaterialPrecoService();
/* 69 */     List<MaterialPreco> listaMaterialPreco = materialPrecoService.listarPorParceiro("64", "001");
/* 70 */     for (MaterialPreco preco : listaMaterialPreco) {
/* 71 */       System.out.println(preco.getCodigo() + " - " + preco.getMaterial() + " - " + preco.getPreco());
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 80 */     CondicaoPagamentoService condicaoPagamentoService = new CondicaoPagamentoService();
/* 81 */     List<CondicaoPagamento> listaCondicaoPagamento = condicaoPagamentoService.listar("64", "", Situacao.ATIVO);
/*    */     
/*    */ 
/* 84 */     FormaPagamentoService formaPagamentoService = new FormaPagamentoService();
/* 85 */     List<FormaPagamento> listaFormaPagamento = formaPagamentoService.listar("64", "", Situacao.ATIVO);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/_Teste/PedidoAppTeste.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */