/*    */ package FormaPagamento;
/*    */ 
/*    */ import Util.Situacao;
/*    */ import java.io.PrintStream;
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
/*    */ public class FormaPagamentoTeste
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 19 */     FormaPagamento formaPagamento = new FormaPagamento();
/* 20 */     formaPagamento.setNome("TESTE 2017 123");
/* 21 */     formaPagamento.setSituacao("ATIVO");
/* 22 */     formaPagamento.setDataCadastro(new Date());
/*    */     
/* 24 */     formaPagamento.setTeste("102");
/* 25 */     formaPagamento.setSeqEmpresa("2");
/*    */     
/*    */ 
/* 28 */     FormaPagamentoService s = new FormaPagamentoService();
/* 29 */     s.salvar(formaPagamento);
/* 30 */     List<FormaPagamento> lista = s.listar("2L", "", Situacao.TODOS);
/* 31 */     for (FormaPagamento l : lista) {
/* 32 */       System.out.println(l.getNome());
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/FormaPagamento/FormaPagamentoTeste.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */