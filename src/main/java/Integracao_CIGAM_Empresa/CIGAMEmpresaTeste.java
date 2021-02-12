/*    */ package Integracao_CIGAM_Empresa;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CIGAMEmpresaTeste
/*    */ {
/*    */   public static void main(String[] args)
/*    */     throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException
/*    */   {
/* 18 */     CIGAMEmpresaService cigamEmpresaService = new CIGAMEmpresaService();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 28 */     CIGAMEmpresa c = new CIGAMEmpresa();
/* 29 */     c.setPin("001");
/* 30 */     c.setStatusRegistro("L");
/* 31 */     c.setCodigoUnidadeNegocio("001");
/* 32 */     c.setCnpjCpf("51356872000128");
/* 33 */     c.setNomeCompleto("TESTE BLUECOM CROSS 5 ABC 2020");
/* 34 */     c.setCodigoEmpresa("91774");
/* 35 */     c.setCodigoDivisao("IF");
/* 36 */     c.setTipoEmpresa("Fisica");
/* 37 */     c.setMunicipio("LIMEIRA");
/* 38 */     c.setUf("SP");
/* 39 */     c.setCodigoPais("311");
/* 40 */     c.setCodigoRepresentante("60088");
/* 41 */     c.setCodigoResponsavel("90802");
/* 42 */     c.setTabelaPrecos(" ");
/* 43 */     c.setCodigoCondicaoPagamento(" ");
/* 44 */     c.setCodigoIndicacao(" ");
/* 45 */     c.setCodigoTipoPagamento(" ");
/*    */     
/* 47 */     c.setCodigoPortadorPadrao(" ");
/* 48 */     c.setCodigoMercado(" ");
/* 49 */     c.setCodigoCentroArmazenagem(" ");
/* 50 */     c.setCodigoTipoOperacao(" ");
/* 51 */     c.setTipoEmpresa(" ");
/* 52 */     c.setAtividade(" ");
/* 53 */     c.setCodigoCentralizadora(" ");
/* 54 */     c.setCodigoIndiceCredito(" ");
/* 55 */     c.setConceito(" ");
/* 56 */     c.setContabilCliente(" ");
/* 57 */     c.setCodigoContabilFornecedor(" ");
/* 58 */     c.setCodigoContabilAdiantamentoCli(" ");
/* 59 */     c.setCodigoContabilAdiantamentoForn(" ");
/* 60 */     c.setCodigoSetor(" ");
/* 61 */     c.setAtivo(Boolean.valueOf(true));
/* 62 */     c.setCodigoEmpresa("91774");
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM_Empresa/CIGAMEmpresaTeste.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */