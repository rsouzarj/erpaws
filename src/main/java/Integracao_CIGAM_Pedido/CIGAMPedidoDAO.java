/*     */ package Integracao_CIGAM_Pedido;
/*     */ 
/*     */ import Integracao_CIGAM.CIGAM;
/*     */ import Util.DateDeserializer;
/*     */ import WSConsumir.WSUtil;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ public class CIGAMPedidoDAO
/*     */ {
/*     */   private static final String srvPedidoSalvar = "http://186.226.209.146:5600/webservice/cigam/integrador/CadastroPedidos.integrador.ashx/CadastrarPedidos";
/*     */   private static final String srvVisualizarPedidoWeb = "http://186.226.209.146:5600/webservice/cigam/integrador/CadastroPedidos.integrador.ashx/VisualizarPedidoWeb";
/*     */   private static final String srvListarPedidosCompleto = "http://186.226.209.146:5600/webservice/cigam/integrador/CadastroPedidos.integrador.ashx/ListarPedidosCompleto";
/*     */   
/*     */   public CIGAMPedidoDAO()
/*     */   {
/*  40 */     GsonBuilder gsonBuilder = new GsonBuilder();
/*  41 */     gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
/*  42 */     CIGAM.gson = gsonBuilder.setDateFormat("dd/MM/yyyy").create();
/*     */   }
/*     */   
/*     */   public CIGAMPedido buscarPedidoPorCodigo(String pCodigoPedido) throws IOException
/*     */   {
/*  47 */     Type tipo = new TypeToken() {}.getType();
/*  50 */     HashMap<String, String> parametros = new HashMap();
/*  51 */     parametros.put("PIN", "001");
/*  52 */     parametros.put("codigoPedido", pCodigoPedido);
/*     */     
/*  54 */     StringBuffer json = WSUtil.sendPostCIGAM("http://186.226.209.146:5600/webservice/cigam/integrador/CadastroPedidos.integrador.ashx/ListarPedidosCompleto", parametros);
/*  55 */     System.out.println(json);
/*     */     
/*  57 */     File fl = new File("c:\\temp\\testando.txt");
/*  58 */     fl.createNewFile();
/*  59 */     System.out.println(fl.getAbsolutePath());
/*  60 */     FileWriter fw = new FileWriter(fl);
/*  61 */     fw.write(json.toString());
/*  62 */     fw.flush();
/*  63 */     fw.close();
/*     */     
/*  65 */     CIGAMPedido pedido = (CIGAMPedido)CIGAM.gson.fromJson(json.toString(), tipo);
/*  66 */     return pedido;
/*     */   }
/*     */   
/*     */   public CIGAMPedidoItem salvar(CIGAMPedidoItem pPedido)
/*     */   {
/*     */     try {
/*  72 */       Class classe = pPedido.getClass();
/*     */       
/*     */ 
/*  75 */       HashMap<String, String> parametros = new HashMap();
/*     */       
/*  77 */       for (Field atributo : classe.getDeclaredFields()) { Method metodo;
					if (atributo.getType().getName().equals("boolean")) {
/*  79 */           metodo = classe.getMethod("is" + atributo.getName().substring(0, 1).toUpperCase().concat(atributo.getName().substring(1)), new Class[0]);
/*     */         } else {
/*  81 */           metodo = classe.getMethod("get" + atributo.getName().substring(0, 1).toUpperCase().concat(atributo.getName().substring(1)), new Class[0]);
/*     */         }
/*  83 */         parametros.put(atributo.getName(), String.valueOf(metodo.invoke(pPedido, new Object[0])));
/*     */       }
/*     */       
/*     */ 
/*  87 */       parametros.put("pin", "001");
/*     */       
/*  89 */       Type tipo = new TypeToken() {}.getType();
/*  92 */       StringBuffer json = WSUtil.sendPostCIGAM("http://186.226.209.146:5600/webservice/cigam/integrador/CadastroPedidos.integrador.ashx/CadastrarPedidos", parametros);
/*  93 */       System.out.println("Resultado do WS: " + json.toString());
/*     */     } catch (NoSuchMethodException ex0) {
/*  95 */       Logger.getLogger(CIGAMPedidoDAO.class.getName()).log(Level.SEVERE, null, ex0);
/*     */     } catch (SecurityException ex) {
/*  97 */       Logger.getLogger(CIGAMPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalArgumentException ex2) {
/*  99 */       Logger.getLogger(CIGAMPedidoDAO.class.getName()).log(Level.SEVERE, null, ex2);
/*     */     }
/*     */     catch (IllegalAccessException ex) {
/* 102 */       Logger.getLogger(CIGAMPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InvocationTargetException ex) {
/* 104 */       Logger.getLogger(CIGAMPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/* 107 */     return pPedido;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM_Pedido/CIGAMPedidoDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */