/*     */ package Equipamento;
/*     */ 
/*     */ import ClausulaSQL.ClausulaWhere;
/*     */ import Util.Conexao;
/*     */ import Util.Sequence;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EquipamentoDAO
/*     */ {
/*     */   public Equipamento inserir(Equipamento equipamento)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       String seq = Sequence.buscarNumeroSequence("SEQ_EQUIPAMENTO");
/*  28 */       equipamento.setSeqEquipamento(seq);
/*  29 */       Conexao conexao = new Conexao();
/*  30 */       Connection conn = Conexao.getConnection();
/*  31 */       String sql = "insert into EQUIPAMENTO (SEQ_EQUIPAMENTO,NOME,SITUACAO,SEQ_EMPRESA,DATA_CADASTRO,SEQ_PARCEIRO,FMAS,CARGA,MSPR,TIPO_ACIONAMENTO,CABO_TRACAO,DIAMETRO,PERNAS,DIMENSAO_CLA,PESO,TIPO_EQUIPAMENTO,MODELO,ANO,NSERIE,MSERIE,POTENCIA,RPM,MBL) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*     */       
/*     */ 
/*     */ 
/*  35 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  37 */       ps.setString(1, equipamento.getSeqEquipamento());
/*  38 */       ps.setString(2, equipamento.getNome());
/*  39 */       ps.setString(3, equipamento.getSituacao());
/*  40 */       ps.setString(4, equipamento.getSeqEmpresa());
/*     */       try {
/*  42 */         ps.setDate(5, new java.sql.Date(equipamento.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  44 */         ps.setDate(5, null);
/*     */       }
/*  46 */       ps.setString(6, equipamento.getSeqParceiro());
/*     */       ps.setString(7, equipamento.getFmas());
                ps.setString(8, equipamento.getCarga());
                ps.setString(9, equipamento.getMspr());
                ps.setString(10, equipamento.getTipoAcionamento());
                ps.setString(11, equipamento.getCaboTracao());
                ps.setString(12, equipamento.getDiametro());
                ps.setString(13, equipamento.getPernas());
                ps.setString(14, equipamento.getDimensaoCla());
                ps.setString(15, equipamento.getPeso());
                ps.setString(16, equipamento.getTipoequipamento());
                ps.setString(17, equipamento.getModelo());
                ps.setString(18, equipamento.getAno());
                ps.setString(19, equipamento.getNserie());
                ps.setString(20, equipamento.getMserie());
                ps.setString(21, equipamento.getPotencia());
                ps.setString(22, equipamento.getRpm());
                ps.setString(23, equipamento.getMbl());


/*  48 */       ps.execute();
/*  49 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  52 */       Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  53 */       System.out.println(ex.getMessage());
/*     */     }
/*  55 */     return equipamento;
/*     */   }
/*     */   
/*     */   public Equipamento alterar(Equipamento equipamento) {
/*     */     try {
/*  60 */       Conexao conexao = new Conexao();
/*  61 */       Connection conn = Conexao.getConnection();
/*  62 */       String sql = "update EQUIPAMENTO set NOME = ?,SITUACAO = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ?, SEQ_PARCEIRO = ?,FMAS = ?,CARGA = ?,MSPR = ?,TIPO_ACIONAMENTO = ?,CABO_TRACAO = ?,DIAMETRO = ?,PERNAS = ?,DIMENSAO_CLA = ?,PESO = ?,TIPO_EQUIPAMENTO = ?,MODELO = ?,ANO = ?,NSERIE = ?,MSERIE = ?,POTENCIA = ?,RPM = ?,MBL = ? where SEQ_EQUIPAMENTO = ?";
/*     */       
/*  64 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/*  66 */       ps.setString(1, equipamento.getNome());
/*  67 */       ps.setString(2, equipamento.getSituacao());
/*  68 */       ps.setString(3, equipamento.getSeqEmpresa());
/*     */       try {
/*  70 */         ps.setDate(4, new java.sql.Date(equipamento.getDataCadastro().getTime()));
/*     */       } catch (NullPointerException e) {
/*  72 */         ps.setDate(4, null);
/*     */       }
/*  74 */       ps.setString(5, equipamento.getSeqParceiro());
/*  75 */       ps.setString(6, equipamento.getFmas());
/*  76 */       ps.setString(7, equipamento.getCarga());
                ps.setString(8, equipamento.getMspr());
                ps.setString(9, equipamento.getTipoAcionamento());
                ps.setString(10, equipamento.getCaboTracao());
                ps.setString(11, equipamento.getDiametro());
                ps.setString(12, equipamento.getPernas());
                ps.setString(13, equipamento.getDimensaoCla());
                ps.setString(14, equipamento.getPeso());
                ps.setString(15, equipamento.getTipoequipamento());
                ps.setString(16, equipamento.getSeqEquipamento());
                ps.setString(17, equipamento.getModelo());
                ps.setString(18, equipamento.getAno());
                ps.setString(19, equipamento.getNserie());
                ps.setString(20, equipamento.getMserie());
                ps.setString(21, equipamento.getPotencia());
                ps.setString(22, equipamento.getRpm());
                ps.setString(23, equipamento.getMbl());
                
                ps.execute();
/*  77 */       ps.close();
/*     */     }
/*     */     catch (SQLException ex) {
/*  80 */       Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  81 */       System.out.println(ex.getMessage());
/*     */     }
/*     */     
/*  84 */     return equipamento;
/*     */   }
/*     */   
/*     */   public List<Equipamento> listar(ClausulaWhere sClausula) {
/*     */     try {
/*  89 */       Conexao conexao = new Conexao();
/*  90 */       Connection conn = Conexao.getConnection();
/*  91 */       String sql = "SELECT * FROM EQUIPAMENTO" + sClausula.montarsClausula() + "ORDER BY EQUIPAMENTO.NOME";
/*     */       
/*     */ 
/*     */ 
/*  95 */       List<Equipamento> listaEquipamento = new ArrayList();
/*  96 */       PreparedStatement ps = conn.prepareStatement(sql);
/*  97 */       ResultSet rs = ps.executeQuery();
/*     */       
/*  99 */       while (rs.next()) {
/* 100 */         Equipamento equipamento = new Equipamento();
/* 101 */         equipamento.setSeqEquipamento(rs.getString("SEQ_EQUIPAMENTO"));
/* 102 */         equipamento.setNome(rs.getString("NOME"));
/* 103 */         equipamento.setSituacao(rs.getString("SITUACAO"));
/* 104 */         equipamento.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 105 */         equipamento.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 106 */         equipamento.setSeqParceiro(rs.getString("SEQ_PARCEIRO"));
                  equipamento.setFmas(rs.getString("FMAS"));
                  equipamento.setCarga(rs.getString("CARGA")); 
                  equipamento.setMspr(rs.getString("MSPR"));
                  equipamento.setTipoAcionamento(rs.getString("TIPO_ACIONAMENTO"));
                  equipamento.setCaboTracao(rs.getString("CABO_TRACAO"));  
                  equipamento.setDiametro(rs.getString("DIAMETRO"));
                  equipamento.setPernas(rs.getString("PERNAS"));
                  equipamento.setDimensaoCla(rs.getString("DIMENSAO_CLA"));
                  equipamento.setPeso(rs.getString("PESO"));
                  equipamento.setTipoequipamento(rs.getString("TIPO_EQUIPAMENTO"));
                  equipamento.setModelo(rs.getString("MODELO"));
                  equipamento.setAno(rs.getString("ANO"));
                  equipamento.setNserie(rs.getString("NSERIE"));
                  equipamento.setMserie(rs.getString("MSERIE"));
                  equipamento.setPotencia(rs.getString("POTENCIA"));
                  equipamento.setRpm(rs.getString("RPM"));
                  equipamento.setMbl(rs.getString("MBL"));
                  listaEquipamento.add(equipamento);
/*     */       }
/*     */       
/* 110 */       ps.execute();
/* 111 */       ps.close();                                                                                             
/*     */       
/* 113 */       return listaEquipamento;
/*     */     } catch (SQLException ex) {
/* 115 */       Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 116 */       System.out.println(ex.getMessage()); }
/* 117 */     return null;
/*     */   }
/*     */   
/*     */   public List<Equipamento> listarPorDono(ClausulaWhere sClausula) {
/*     */     try {
/* 122 */       Conexao conexao = new Conexao();
/* 123 */       Connection conn = Conexao.getConnection();
/* 124 */       String sql = "SELECT * FROM EQUIPAMENTO \n  inner join documento_item_equipamento on documento_item_equipamento.SEQ_EQUIPAMENTO = equipamento.seq_equipamento" + sClausula.montarsClausula();
/*     */       
/*     */ 
/* 127 */       System.out.println(sql);
/*     */       
/* 129 */       List<Equipamento> listaEquipamento = new ArrayList();
/* 130 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 131 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 133 */       while (rs.next()) {
/* 134 */         Equipamento equipamento = new Equipamento();
/* 135 */         equipamento.setSeqEquipamento(rs.getString("SEQ_EQUIPAMENTO"));
/* 136 */         equipamento.setNome(rs.getString("NOME"));
/* 137 */         equipamento.setSituacao(rs.getString("SITUACAO"));
/* 138 */         equipamento.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 139 */         equipamento.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 140 */         equipamento.setSeqParceiro(rs.getString("SEQ_PARCEIRO"));
                  equipamento.setFmas(rs.getString("FMAS"));
                  equipamento.setCarga(rs.getString("CARGA")); 
                  equipamento.setMspr(rs.getString("MSPR"));
                  equipamento.setTipoAcionamento(rs.getString("TIPO_ACIONAMENTO"));
                  equipamento.setCaboTracao(rs.getString("CABO_TRACAO"));  
                  equipamento.setDiametro(rs.getString("DIAMETRO"));
                  equipamento.setPernas(rs.getString("PERNAS"));
                  equipamento.setDimensaoCla(rs.getString("DIMENSAO_CLA"));
                  equipamento.setPeso(rs.getString("PESO"));
                  equipamento.setTipoequipamento(rs.getString("TIPO_EQUIPAMENTO"));
/* 141 */         listaEquipamento.add(equipamento);
/*     */       }
/*     */       
/* 144 */       ps.execute();
/* 145 */       ps.close();
/*     */       
/* 147 */       return listaEquipamento;
/*     */     } catch (SQLException ex) {
/* 149 */       Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 150 */       System.out.println(ex.getMessage()); }
/* 151 */     return null;
/*     */   }
/*     */   
/*     */   public List<Equipamento> listarParceiro(ClausulaWhere sClausula)
/*     */   {
/*     */     try {
/* 157 */       Conexao conexao = new Conexao();
/* 158 */       Connection conn = Conexao.getConnection();
/* 159 */       String sql = "SELECT equipamento.*, \nequipamento_parceiro.* \n FROM EQUIPAMENTO inner join equipamento_parceiro on equipamento_parceiro.seq_equipamento = equipamento.seq_equipamento \n inner join parceiro on parceiro.seq_parceiro = equipamento_parceiro.seq_parceiro\n " + sClausula.montarsClausula();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 165 */       System.out.println(sql);
/*     */       
/* 167 */       List<Equipamento> listaEquipamento = new ArrayList();
/* 168 */       PreparedStatement ps = conn.prepareStatement(sql);
/* 169 */       ResultSet rs = ps.executeQuery();
/*     */       
/* 171 */       while (rs.next()) {
/* 172 */         Equipamento equipamento = new Equipamento();
/* 173 */         equipamento.setSeqEquipamento(rs.getString("SEQ_EQUIPAMENTO"));
/* 174 */         equipamento.setNome(rs.getString("NOME"));
/* 175 */         equipamento.setSituacao(rs.getString("SITUACAO"));
/* 176 */         equipamento.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
/* 177 */         equipamento.setDataCadastro(rs.getDate("DATA_CADASTRO"));
/* 178 */         equipamento.setSeqParceiro(rs.getString("SEQ_PARCEIRO"));
                  equipamento.setFmas(rs.getString("FMAS"));
                  equipamento.setCarga(rs.getString("CARGA")); 
                  equipamento.setMspr(rs.getString("MSPR"));
                  equipamento.setTipoAcionamento(rs.getString("TIPO_ACIONAMENTO"));
                  equipamento.setCaboTracao(rs.getString("CABO_TRACAO"));  
                  equipamento.setDiametro(rs.getString("DIAMETRO"));
                  equipamento.setPernas(rs.getString("PERNAS"));
                  equipamento.setDimensaoCla(rs.getString("DIMENSAO_CLA"));
                  equipamento.setPeso(rs.getString("PESO"));
                  equipamento.setTipoequipamento(rs.getString("TIPO_EQUIPAMENTO"));
/* 179 */         listaEquipamento.add(equipamento);
/*     */       }
/*     */       
/* 182 */       ps.execute();
/* 183 */       ps.close();
/*     */       
/* 185 */       return listaEquipamento;
/*     */     } catch (SQLException ex) {
/* 187 */       Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 188 */       System.out.println(ex.getMessage()); }
/* 189 */     return null;
/*     */   }
/*     */   
/*     */   public boolean deletar(Equipamento equipamento)
/*     */   {
/*     */     try {
/* 195 */       Conexao conexao = new Conexao();
/* 196 */       Connection conn = Conexao.getConnection();
/* 197 */       String sql = "DELETE FROM EQUIPAMENTO WHERE SEQ_EQUIPAMENTO =  ? ";
/*     */       
/* 199 */       PreparedStatement ps = conn.prepareStatement(sql);
/*     */       
/* 201 */       ps.setString(1, equipamento.getSeqEquipamento());
/*     */       
/* 203 */       ps.execute();
/* 204 */       ps.close();
/*     */       
/* 206 */       return true;
/*     */     } catch (SQLException ex) {
/* 208 */       System.out.println(ex.getMessage()); }
/* 209 */     return false;
/*     */   }
/*     */ }

