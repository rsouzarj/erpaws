/*     */ package Util;
/*     */ 
/*     */ import Parceiro.Parceiro;
/*     */ import Usuario.Usuario;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Properties;
/*     */ import java.util.UUID;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.mail.Address;
/*     */ import javax.mail.Authenticator;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.Message.RecipientType;
/*     */ import javax.mail.MessagingException;
/*     */ import javax.mail.Multipart;
/*     */ import javax.mail.PasswordAuthentication;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Transport;
/*     */ import javax.mail.internet.InternetAddress;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Util
/*     */ {
/*     */   public static final String raizArquivos = "c:\\temp\\erp\\";
/*  50 */   private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
/*  51 */   private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
/*     */   
/*     */   public static void main(String[] args) {
/*  54 */     Util util = new Util();
/*  55 */     PastaDisco pasta = PastaDisco.Logo;
/*  56 */     System.out.println("asdasd" + pasta);
/*     */   }
/*     */   
/*     */   public static String gerarChave() {
/*  60 */     UUID uuid = UUID.randomUUID();
/*  61 */     return uuid.toString();
/*     */   }
/*     */   
/*     */   public static void executarSql(String pSql)
/*     */   {
/*     */     try {
/*  67 */       Conexao conexao = new Conexao();
/*     */       
/*  69 */       Connection conn = Conexao.getConnection();
/*  70 */       conn.close();
/*  71 */       conn = Conexao.getConnection();
/*     */       
/*     */ 
/*     */ 
/*  75 */       PreparedStatement ps = conn.prepareStatement(pSql);
/*  76 */       ps.execute();
/*     */     }
/*     */     catch (SQLException ex) {
/*  79 */       Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String Consultar(String urlT) throws IOException
/*     */   {
/*  85 */     InputStream is = null;
/*  86 */     BufferedReader reader = null;
/*     */     try
/*     */     {
/*  89 */       URL url = new URL(urlT);
/*  90 */       HttpURLConnection conn = (HttpURLConnection)url.openConnection();
/*  91 */       conn.setReadTimeout(10000);
/*  92 */       conn.setConnectTimeout(15000);
/*  93 */       conn.setRequestMethod("GET");
/*  94 */       conn.setDoInput(true);
/*  95 */       conn.connect();
/*  96 */       conn.getResponseCode();
/*     */       
/*  98 */       is = conn.getInputStream();
/*  99 */       reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
/*     */       
/* 101 */       StringBuilder sb = new StringBuilder();
/* 102 */       String line = null;
/*     */       
/*     */ 
/* 105 */       while ((line = reader.readLine()) != null) {
/* 106 */         sb.append(line);
/*     */       }
/*     */       
/* 109 */       return sb.toString();
/*     */     } finally {
/* 111 */       if (is != null) {
/*     */         try {
/* 113 */           is.close();
/*     */         } catch (IOException e) {
/* 115 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */       
/* 119 */       if (reader != null) {
/*     */         try {
/* 121 */           reader.close();
/*     */         } catch (IOException e) {
/* 123 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static String buscarConteudoDentroJson(String pStringJson, String pChave) {
/* 130 */     int pInicial = pStringJson.indexOf("\"" + pChave + "\": \"") + pChave.length() + 5;
/* 131 */     int pFinal = pInicial;
/*     */     
/* 133 */     for (int i = 0; i < 100; i++) {
/* 134 */       pFinal++;
/* 135 */       if (pStringJson.substring(pFinal, pFinal + 1).equals("\"")) {
/* 136 */         return pStringJson.substring(pInicial, pFinal);
/*     */       }
/*     */     }
/*     */     
/* 140 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public Parceiro buscarDadosReceitaFederal(Parceiro pParceiro)
/*     */   {
/* 146 */     String retorno = null;
/*     */     try {
/* 148 */       String url = "http://receitaws.com.br/v1/cnpj/" + pParceiro.getDocumento().replace(".", "").replace("-", "").replace("/", "");
/* 149 */       retorno = Consultar(url);
/*     */     }
/*     */     catch (IOException ex) {
/* 152 */       Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/* 156 */     pParceiro.setNome(buscarConteudoDentroJson(retorno, "nome"));
/* 157 */     pParceiro.setFantasia(buscarConteudoDentroJson(retorno, "fantasia"));
/* 158 */     pParceiro.setLogradouro(buscarConteudoDentroJson(retorno, "logradouro"));
/* 159 */     pParceiro.setNumero(buscarConteudoDentroJson(retorno, "numero"));
/* 160 */     pParceiro.setComplemento(buscarConteudoDentroJson(retorno, "complemento"));
/* 161 */     pParceiro.setBairro(buscarConteudoDentroJson(retorno, "bairro"));
/* 162 */     pParceiro.setCidade(buscarConteudoDentroJson(retorno, "municipio"));
/* 163 */     pParceiro.setUf(buscarConteudoDentroJson(retorno, "uf"));
/* 164 */     pParceiro.setCep(buscarConteudoDentroJson(retorno, "cep"));
/* 165 */     pParceiro.setTelefone1(buscarConteudoDentroJson(retorno, "telefone"));
/* 166 */     pParceiro.setEmail(buscarConteudoDentroJson(retorno, "email"));
/*     */     
/* 168 */     String dataNascimento = buscarConteudoDentroJson(retorno, "abertura");
/* 169 */     System.out.println("==>" + dataNascimento);
/* 170 */     String formato = "dd/MM/yyyy";
/*     */     try {
/* 172 */       Date data = new SimpleDateFormat(formato).parse(dataNascimento);
/* 173 */       pParceiro.setDataNascimento(data);
/*     */     }
/*     */     catch (ParseException ex) {
/* 176 */       Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/* 179 */     return pParceiro;
/*     */   }
/*     */   
/*     */   private static int calcularDigito(String str, int[] peso) {
/* 183 */     int soma = 0;
/* 184 */     for (int indice = str.length() - 1; indice >= 0; indice--) {
/* 185 */       int digito = Integer.parseInt(str.substring(indice, indice + 1));
/* 186 */       soma += digito * peso[(peso.length - str.length() + indice)];
/*     */     }
/* 188 */     soma = 11 - soma % 11;
/* 189 */     return soma > 9 ? 0 : soma;
/*     */   }
/*     */   
/*     */   public static boolean validarCPF(String pCpf) {
/* 193 */     String cpf = pCpf.replace(".", "").replace("-", "");
/* 194 */     if ((cpf == null) || (cpf.length() != 11)) {
/* 195 */       return false;
/*     */     }
/*     */     
/* 198 */     Integer digito1 = Integer.valueOf(calcularDigito(cpf.substring(0, 9), pesoCPF));
/* 199 */     Integer digito2 = Integer.valueOf(calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF));
/* 200 */     return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
/*     */   }
/*     */   
/*     */   public static boolean validarCNPJ(String pCnpj) {
/* 204 */     String cnpj = pCnpj.replace(".", "").replace("/", "").replace("-", "");
/* 205 */     if ((cnpj == null) || (cnpj.length() != 14)) {
/* 206 */       return false;
/*     */     }
/*     */     
/* 209 */     Integer digito1 = Integer.valueOf(calcularDigito(cnpj.substring(0, 12), pesoCNPJ));
/* 210 */     Integer digito2 = Integer.valueOf(calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ));
/* 211 */     return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
/*     */   }
/*     */   
/*     */   public void copiarArquivoDisco(String pSeqEmpresa, PastaDisco pPastaDisco, String pNomeArquivo, InputStream in) {
/*     */     try {
/* 216 */       String caminho = "c:\\temp\\erp\\" + String.valueOf(pSeqEmpresa) + "\\" + pPastaDisco + "\\";
/*     */       
/*     */ 
/* 219 */       File diretorio = new File(caminho);
/* 220 */       diretorio.mkdirs();
/*     */       
/* 222 */       System.out.println(caminho);
/* 223 */       OutputStream out = new FileOutputStream(new File(caminho + pNomeArquivo));
/*     */       
/* 225 */       int read = 0;
/* 226 */       byte[] bytes = new byte['Ѐ'];
/* 227 */       while ((read = in.read(bytes)) != -1) {
/* 228 */         out.write(bytes, 0, read);
/*     */       }
/*     */       
/* 231 */       in.close();
/* 232 */       out.flush();
/* 233 */       out.close();
/*     */     } catch (IOException e) {
/* 235 */       System.out.println(e.getMessage());
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean localizarArquivo(String pSeqEmpresa, String pNomeArquivo, PastaDisco pPastaDisco) {
/* 240 */     boolean retorno = false;
/* 241 */     String vNomeArquivo = pNomeArquivo;
/*     */     
/* 243 */     int i = 0;
/* 244 */     File arq = new File("c:\\temp\\erp\\" + pSeqEmpresa + "\\" + pPastaDisco + "\\");
/* 245 */     File[] arquivos = arq.listFiles();
/* 246 */     while (i != arquivos.length) {
/* 247 */       if (arquivos[i].getName().equals(vNomeArquivo)) {
/* 248 */         retorno = true;
/*     */       }
/* 250 */       i++;
/*     */     }
/*     */     
/* 253 */     return retorno;
/*     */   }
/*     */   
/*     */   public String NomeDoMes(int i, int tipo) {
/* 257 */     String[] mes = { "janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro" };
/*     */     
/*     */ 
/*     */ 
/* 261 */     if (tipo == 0) {
/* 262 */       return mes[(i - 1)];
/*     */     }
/* 264 */     return mes[(i - 1)].substring(0, 3);
/*     */   }
/*     */   
/*     */ 
/*     */   public String DataPorExtenso(String cidade, Date dt)
/*     */   {
/* 270 */     if (dt == null) {
/* 271 */       return "";
/*     */     }
/*     */     
/* 274 */     int d = dt.getDate();
/* 275 */     int m = dt.getMonth() + 1;
/* 276 */     int a = dt.getYear() + 1900;
/*     */     
/* 278 */     Calendar data = new GregorianCalendar(a, m - 1, d);
/*     */     
/*     */ 
/* 281 */     if (d < 10) {
/* 282 */       return cidade + "0" + d + " de " + NomeDoMes(m, 0) + " de " + a + ".";
/*     */     }
/* 284 */     return cidade + d + " de " + NomeDoMes(m, 0) + " de " + a + ".";
/*     */   }
/*     */   
/*     */   public String DataToString(Date dt)
/*     */   {
/* 289 */     if (dt == null) {
/* 290 */       return "__/__/____";
/*     */     }
/*     */     
/* 293 */     int d = dt.getDate();
/* 294 */     int m = dt.getMonth() + 1;
/* 295 */     int a = dt.getYear() + 1900;
/*     */     
/* 297 */     String retorno = "";
/*     */     
/* 299 */     if (d < 10) {
/* 300 */       retorno = "0" + d;
/*     */     } else {
/* 302 */       retorno = "" + d;
/*     */     }
/*     */     
/* 305 */     if (m < 10) {
/* 306 */       retorno = retorno + "/" + "0" + m;
/*     */     } else {
/* 308 */       retorno = retorno + "/" + m;
/*     */     }
/*     */     
/* 311 */     return retorno + "/" + a;
/*     */   }
/*     */   
/*     */   public static void enviarEmail(String pEmail, Usuario pUsuario) {
/* 315 */     Properties props = new Properties();
/*     */     
/*     */ 
/*     */ 
/* 319 */     props.put("mail.smtp.host", "email-ssl.com.br");
/* 320 */     props.put("mail.transport.protocol", "smtp");
/* 321 */     props.put("mail.smtp.socketFactory.port", "587");
/*     */     
/* 323 */     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
/* 324 */     props.put("mail.smtp.auth", "true");
/* 325 */     props.put("mail.smtp.port", "587");
/*     */     
/* 327 */     props.put("mail.smtp.starttls.enable", "true");
/*     */     
/* 329 */     Session session = Session.getInstance(props, new Authenticator()
/*     */     {
/*     */       protected PasswordAuthentication getPasswordAuthentication() {
/* 332 */         return new PasswordAuthentication("suporte@awsservice.com.br", "AWSsuporte");
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 338 */     });
/* 339 */     session.setDebug(true);
/*     */     
/*     */     try
/*     */     {
/* 343 */       Message message = new MimeMessage(session);
/* 344 */       message.setFrom(new InternetAddress("suporte@awsservice.com.br", "AWS SERVICE"));
/*     */       
/* 346 */       Address[] toUser = InternetAddress.parse(pEmail);
/*     */       
/*     */ 
/* 349 */       message.setRecipients(Message.RecipientType.TO, toUser);
/* 350 */       message.setSubject("AWS Service - Recuperação de Senha ");
/* 351 */       message.setText("AWS Service informa: \n\n\n Seu usuário: " + pUsuario.getUsuario() + " \n Sua Senha: " + pUsuario.getSenha() + " \n\n\n ** Recomendamos a troca da senha após o recebimento desse e-mail.**");
/*     */       
/*     */ 
/*     */ 
/* 355 */       Transport.send(message);
/*     */       
/* 357 */       System.out.println("Feito!!!");
/*     */     }
/*     */     catch (MessagingException e) {
/* 360 */       throw new RuntimeException(e);
/*     */     } catch (UnsupportedEncodingException ex) {
/* 362 */       Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean enviarEmailParceiro(String pEmail, Multipart pConteudo)
/*     */   {
/* 368 */     boolean retorno = false;
/*     */     
/* 370 */     Properties props = new Properties();
/*     */     
/*     */ 
/*     */ 
/* 374 */     props.put("mail.smtp.host", "email-ssl.com.br");
/* 375 */     props.put("mail.transport.protocol", "smtp");
/*     */     
/* 377 */     props.put("mail.smtp.socketFactory.port", "465");
/* 378 */     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
/* 379 */     props.put("mail.smtp.auth", "true");
/* 380 */     props.put("mail.smtp.port", "587");
/*     */     
/* 382 */     props.put("mail.smtp.starttls.enable", "true");
/*     */     
/* 384 */     Session session = Session.getInstance(props, new Authenticator()
/*     */     {
/*     */       protected PasswordAuthentication getPasswordAuthentication() {
/* 387 */         return new PasswordAuthentication("suporte@awsservice.com.br", "AWSsuporte");
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 393 */     });
/* 394 */     session.setDebug(true);
/*     */     
/*     */     try
/*     */     {
/* 398 */       Message message = new MimeMessage(session);
/*     */       try {
/* 400 */         message.setFrom(new InternetAddress("suporte@awsservice.com.br", "AWS SERVICE"));
/*     */       }
/*     */       catch (UnsupportedEncodingException ex) {
/* 403 */         Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */       
/* 406 */       Address[] toUser = InternetAddress.parse(pEmail);
/*     */       
/*     */ 
/* 409 */       message.setRecipients(Message.RecipientType.TO, toUser);
/* 410 */       message.setSubject("AWS Service - Pesquisa de Satisfação ");
/*     */       
/* 412 */       message.setContent(pConteudo);
/*     */       
/*     */ 
/*     */ 
/* 416 */       Transport.send(message);
/*     */       
/* 418 */       System.out.println("Feito!!!");
/* 419 */       retorno = true;
/*     */     }
/*     */     catch (MessagingException e) {
/* 422 */       retorno = false;
/* 423 */       throw new RuntimeException(e);
/*     */     }
/* 425 */     return retorno;
/*     */   }

}

