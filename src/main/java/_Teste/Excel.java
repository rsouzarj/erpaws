/*     */ package _Teste;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;

/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Excel
/*     */ {
/*     */   private String template;
/*     */   private XSSFWorkbook book;
/*     */   private XSSFSheet sheet;
/*     */   
/*     */   public Excel(String template)
/*     */   {
/*  33 */     this.template = template;
/*     */   }
/*     */   
/*     */   public ByteArrayOutputStream salvar() {
/*  37 */     ByteArrayOutputStream retorno = new ByteArrayOutputStream();
/*     */     
/*     */     try
/*     */     {
/*  41 */       this.book.write(retorno);
/*     */     }
/*     */     catch (IOException ex) {
/*  44 */       Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*  46 */     return retorno;
/*     */   }
/*     */   
/*     */   public void substituir(HashMap<String, String> pConteudo) {
/*  50 */     XSSFWorkbook doc = null;
/*     */     try
/*     */     {
/*  53 */       this.book = new XSSFWorkbook(this.template);
/*  54 */       this.sheet = this.book.getSheetAt(0);
/*     */       
/*  56 */       for (Map.Entry<String, String> c : pConteudo.entrySet()) {
/*  57 */         System.out.println((String)c.getKey() + " - " + (String)c.getValue());
/*  58 */         Iterator<Row> itr = this.sheet.iterator();
/*     */         
/*  60 */         while (itr.hasNext()) {
/*  61 */           Row row = (Row)itr.next();
/*  62 */           Iterator<Cell> cellIterator = row.cellIterator();
/*  63 */           while (cellIterator.hasNext()) {
/*  64 */             Cell cell = (Cell)cellIterator.next();
/*  65 */             if (cell.toString().contains((CharSequence)c.getKey())) {
/*  66 */               cell.setCellValue((String)c.getValue());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (FileNotFoundException fe) {
/*  73 */       fe.printStackTrace();
/*     */     } catch (IOException ie) {
/*  75 */       ie.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void adicionarCelula(int pLinha, int pColuna, String pConteudo)
/*     */   {
/*  81 */     Row linha = this.sheet.createRow(pLinha);
/*  82 */     linha.createCell(pColuna).setCellValue(pConteudo);
/*     */   }
/*     */   
/*     */   public String getTemplate() {
/*  86 */     return this.template;
/*     */   }
/*     */   
/*     */   public void setTemplate(String template) {
/*  90 */     this.template = template;
/*     */   }
/*     */   
/*     */   public XSSFWorkbook getBook() {
/*  94 */     return this.book;
/*     */   }
/*     */   
/*     */   public void setBook(XSSFWorkbook book) {
/*  98 */     this.book = book;
/*     */   }
/*     */   
/*     */   public XSSFSheet getSheet() {
/* 102 */     return this.sheet;
/*     */   }
/*     */   
/*     */   public void setSheet(XSSFSheet sheet) {
/* 106 */     this.sheet = sheet;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/_Teste/Excel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */