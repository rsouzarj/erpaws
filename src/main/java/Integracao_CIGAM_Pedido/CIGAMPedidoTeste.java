/*    */ package Integracao_CIGAM_Pedido;
/*    */ 
/*    */ import Integracao_CIGAM_PedidoItem.CIGAMPedidoItem;
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.GsonBuilder;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CIGAMPedidoTeste
/*    */ {
/*    */   public static void main(String[] args)
/*    */     throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, ParseException
/*    */   {
/* 35 */     CIGAMPedido c = new CIGAMPedido();
/*    */     
/* 37 */     String dataEmUmFormato = "27/01/2017";
/* 38 */     SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
/* 39 */     Date data = formato.parse(dataEmUmFormato);
/* 40 */     formato.applyPattern("dd/MM/yyyy");
/* 41 */     String dataFormatada = formato.format(data);
/*    */     
/* 43 */     c.setDataPedido("27/01/2017");
/* 44 */     c.setViaTransporte("R");
/* 45 */     c.setCodigoCliente("91774");
/* 46 */     c.setCodigoRepresentante("10600");
/* 47 */     c.setOrdemEnderecoEntrega("01");
/* 48 */     c.setDataEntrega("01/01/2017");
/*    */     
/* 50 */     c.setTipoFrete("F");
/* 51 */     c.setTipoNota("S");
/* 52 */     c.setPrazoProgramado("01/01/2017");
/* 53 */     c.setCodigoUnidadeNegocio("001");
/* 54 */     c.setControle("88");
/* 55 */     c.setCalcularImpostos("true");
/*    */     
/* 57 */     List<CIGAMPedidoItem> listaPedidoItem = new ArrayList();
/* 58 */     CIGAMPedidoItem item = new CIGAMPedidoItem();
/*    */     
/* 60 */     item.setCodigoMaterial("00314");
/* 61 */     item.setQuantidade("1");
/* 62 */     item.setPrecoUnitario("1");
/* 63 */     item.setPrazoEntrega("10/04/2017");
/*    */     
/* 65 */     listaPedidoItem.add(item);
/* 66 */     c.setItens(listaPedidoItem);
/*    */     
/* 68 */     CIGAMPedidoDAO dao = new CIGAMPedidoDAO();
/*    */     
/*    */ 
/* 71 */     Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy'T'HH:mm:ss").create();
/*    */     
/*    */ 
/*    */ 
/* 75 */     CIGAMPedidoItem pi = new CIGAMPedidoItem();
/*    */     
/* 77 */     List<CIGAMPedido> listaPedido = new ArrayList();
/* 78 */     listaPedido.add(c);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 85 */     String pedidoCompleto = gson.toJson(pi);
/* 86 */     System.out.println(pedidoCompleto);
/*    */   }
/*    */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM_Pedido/CIGAMPedidoTeste.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */