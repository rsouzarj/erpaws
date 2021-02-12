/*     */ package Integracao_CIGAM_Empresa;
/*     */ 
/*     */ import Integracao_CIGAM.CIGAM;
/*     */ import Parceiro.Parceiro;
/*     */ import Util.DateDeserializer;
/*     */ import Util.Retorno;
/*     */ import WSConsumir.WSUtil;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
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
/*     */ public class CIGAMEmpresaDAO
/*     */ {
/*     */   private static final String srvEmpresaListarId = "http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/ListarId";
/*     */   private static final String srvEmpresaListarEmpresas = "http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/ListarEmpresas";
/*     */   private static final String srvEmpresaSalvarEmpresas = "http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/Cadastrar";
/*     */   private static final String srvEmpresaListarPendente = "http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/ListarPendentes";
/*     */   private static final String srvEmpresaLiberarPendente = "http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/LiberarPendentes";
/*     */   private static final String srvEmpresaListarIndividual = "http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/ListarIndividual";
/*     */   
/*     */   public CIGAMEmpresaDAO()
/*     */   {
/*  43 */     GsonBuilder gsonBuilder = new GsonBuilder();
/*  44 */     gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
/*  45 */     Gson gson = gsonBuilder.setDateFormat("dd/MM/yyyy").create();
/*     */   }
/*     */   
/*     */   public CIGAMEmpresa listarEmpresaPorCodigo(String pCodigoEmpresa)
/*     */   {
/*  50 */     Type tipo = new TypeToken() {}.getType();
/*  53 */     HashMap<String, String> parametros = new HashMap();
/*  54 */     parametros.put("PIN", "001");
/*  55 */     parametros.put("codigoEmpresaInicial", pCodigoEmpresa);
/*  56 */     parametros.put("codigoEmpresaFinal", pCodigoEmpresa);
/*  57 */     StringBuffer json = WSUtil.sendPostCIGAM("http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/ListarEmpresas", parametros);
/*  58 */     System.out.println(json);
/*     */     
/*  60 */     List<CIGAMEmpresa> listaCigamEmpresa = new ArrayList();
/*     */     
/*  62 */     listaCigamEmpresa = (List)CIGAM.gson.fromJson(json.toString(), tipo);
/*  63 */     return (CIGAMEmpresa)listaCigamEmpresa.get(0);
/*     */   }
/*     */   
/*     */   public List<Parceiro> listarEmpresaPorDivisao(String pCodigoDivisao) {
/*  67 */     List<Parceiro> retorno = new ArrayList();
/*     */     
/*  69 */     Type tipo = new TypeToken() {}.getType();
/*  72 */     HashMap<String, String> parametros = new HashMap();
/*  73 */     parametros.put("PIN", "001");
/*  74 */     parametros.put("codigoDivisaoinicial", pCodigoDivisao);
/*  75 */     parametros.put("codigoDivisaoFinal", pCodigoDivisao);
/*     */     
/*  77 */     StringBuffer json = WSUtil.sendPostCIGAM("http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/ListarEmpresas", parametros);
/*  78 */     System.out.println(json);
/*     */     
/*  80 */     List<CIGAMEmpresa> listaCigamEmpresa = new ArrayList();
/*     */     
/*  82 */     listaCigamEmpresa = (List)CIGAM.gson.fromJson(json.toString(), tipo);
/*     */     
/*     */ 
/*  85 */     for (CIGAMEmpresa lista : listaCigamEmpresa) {
/*  86 */       Parceiro parceiro = new Parceiro();
/*  87 */       parceiro.setCodigo(lista.getCodigoEmpresa());
/*  88 */       parceiro.setNome(lista.getNomeCompleto());
/*     */       
/*  90 */       retorno.add(parceiro);
/*     */     }
/*     */     
/*  93 */     return retorno;
/*     */   }
/*     */   
/*     */   public List<CIGAMEmpresa> listarEmpresaPorNome(String pNome)
/*     */   {
/*  98 */     Type tipo = new TypeToken() {}.getType();
/* 101 */     HashMap<String, String> parametros = new HashMap();
/* 102 */     parametros.put("PIN", "001");
/* 103 */     parametros.put("nomeInicial", pNome);
/* 104 */     parametros.put("nomeFinal", pNome);
/*     */     
/* 106 */     StringBuffer json = WSUtil.sendPostCIGAM("http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/ListarEmpresas", parametros);
/* 107 */     System.out.println(json);
/*     */     
/* 109 */     List<CIGAMEmpresa> listaCigamEmpresa = new ArrayList();
/*     */     
/* 111 */     listaCigamEmpresa = (List)CIGAM.gson.fromJson(json.toString(), tipo);
/* 112 */     return listaCigamEmpresa;
/*     */   }
/*     */   
/*     */   public void listarID()
/*     */   {
/* 117 */     HashMap<String, String> parametros = new HashMap();
/* 118 */     parametros.put("PIN", "001");
/*     */     
/* 120 */     StringBuffer json = WSUtil.sendPostCIGAM("http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/ListarId", parametros);
/* 121 */     System.out.println(json);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public StringBuffer listarPendencia(String pAcao, String pStatus)
/*     */   {
/* 131 */     HashMap<String, String> parametros = new HashMap();
/* 132 */     parametros.put("pin", "001");
/* 133 */     parametros.put("acao", pAcao);
/* 134 */     parametros.put("statusRegistro", pStatus);
/*     */     
/* 136 */     StringBuffer json = WSUtil.sendPostCIGAM("http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/ListarPendentes", parametros);
/* 137 */     return json;
/*     */   }
/*     */   
/*     */   public StringBuffer liberarPendencia(String pId) {
/* 141 */     HashMap<String, String> parametros = new HashMap();
/* 142 */     parametros.put("PIN", "001");
/* 143 */     parametros.put("id", pId);
/* 144 */     parametros.put("liberarCorrelatos", "false");
/*     */     
/* 146 */     StringBuffer json = WSUtil.sendPostCIGAM("http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/LiberarPendentes", parametros);
/* 147 */     return json;
/*     */   }
/*     */   
/*     */   public Retorno salvarEmpresa(Parceiro pParceiro) {
/* 151 */     Retorno retorno = new Retorno();
/* 152 */     retorno.setClasse(pParceiro);
/* 153 */     retorno.setMsg("Falha ao inserir registro!");
/* 154 */     retorno.setTransacaoOK(false);
/*     */     
/*     */     try
/*     */     {
/* 158 */       CIGAMEmpresa pCigamEmpresa = new CIGAMEmpresa();
/* 159 */       pCigamEmpresa.setNomeCompleto(pParceiro.getNome());
/* 160 */       pCigamEmpresa.setEndereco(pParceiro.getLogradouro());
/* 161 */       pCigamEmpresa.setStatusRegistro("L");
/* 162 */       pCigamEmpresa.setUf("SP");
/* 163 */       pCigamEmpresa.setMunicipio("LIMEIRA");
/* 164 */       pCigamEmpresa.setCodigoSetor(" ");
/* 165 */       pCigamEmpresa.setCodigoPortadorPadrao(" ");
/*     */       
/*     */ 
/* 168 */       Class classe = pCigamEmpresa.getClass();
/*     */       
/*     */ 
/* 171 */       HashMap<String, String> parametros = new HashMap();
/*     */       
/* 173 */       for (Field atributo : classe.getDeclaredFields()) { Method metodo;
					if (atributo.getType().getName().equals("boolean")) {
/* 175 */           metodo = classe.getMethod("is" + atributo.getName().substring(0, 1).toUpperCase().concat(atributo.getName().substring(1)), new Class[0]);
/*     */         } else {
/* 177 */           metodo = classe.getMethod("get" + atributo.getName().substring(0, 1).toUpperCase().concat(atributo.getName().substring(1)), new Class[0]);
/*     */         }
/* 179 */         parametros.put(atributo.getName(), String.valueOf(metodo.invoke(pCigamEmpresa, new Object[0])));
/* 180 */         System.out.println(atributo.getName() + " ==> " + metodo.invoke(pCigamEmpresa, new Object[0]));
/*     */       }
/*     */       
/* 183 */       parametros.put("pin", "001");
/*     */       
/* 185 */       Type tipo = new TypeToken() {}.getType();
/* 188 */       StringBuffer json = WSUtil.sendPostCIGAM("http://186.226.209.146:5600/webservice/cigam/integrador/CadastroEmpresas.integrador.ashx/Cadastrar", parametros);
/* 189 */       System.out.println("Cadastro Novo: " + json);
/*     */       
/* 191 */       retorno.setClasse(pParceiro);
/* 192 */       retorno.setMsg("Registro Inserido om sucesso!");
/* 193 */       retorno.setTransacaoOK(true);
/*     */     }
/*     */     catch (NoSuchMethodException ex0) {
/* 196 */       Logger.getLogger(CIGAMEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex0);
/*     */     } catch (SecurityException ex) {
/* 198 */       Logger.getLogger(CIGAMEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (IllegalArgumentException ex2) {
/* 200 */       Logger.getLogger(CIGAMEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex2);
/*     */     }
/*     */     catch (IllegalAccessException ex) {
/* 203 */       Logger.getLogger(CIGAMEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } catch (InvocationTargetException ex) {
/* 205 */       Logger.getLogger(CIGAMEmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/* 208 */     return retorno;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM_Empresa/CIGAMEmpresaDAO.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */