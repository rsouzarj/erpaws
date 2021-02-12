package NvLicenca;

import ClausulaSQL.ClausulaWhere;
import Util.Conexao;
import Util.Sequence;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NvLicencaDAO {
   public NvLicenca inserir(NvLicenca nvLicenca) {
      try {
         String seq = Sequence.buscarNumeroSequence("SEQ_NV_LICENCA");
         nvLicenca.setSeqNvLicenca(seq);
         new Conexao();
         Connection conn = Conexao.getConnection();
         String sql = "insert into NV_LICENCA (SEQ_NV_LICENCA,IDENTIFICACAO,SEQ_EMPRESA,DATA_CADASTRO,SITUACAO,SEQ_NV_TIPO_LICENCA,SEQ_NV_EMBARCACAO,DATA_EMISSAO,NOME_VISTORIADOR, ANO_TERMINO_CONSTRUCAO, SEQ_COLABORADOR, OBSERVACAO, local_emissao, VALIDADE_LICENCA_PROVISORIA, status, assinatura_digital,seq_unidade_negocio) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, nvLicenca.getSeqNvLicenca());
         ps.setString(2, nvLicenca.getIdentificacao());
         ps.setString(3, nvLicenca.getSeqEmpresa());

         try {
            ps.setDate(4, new Date(nvLicenca.getDataCadastro().getTime()));
         } catch (NullPointerException var10) {
            ps.setDate(4, (Date)null);
         }

         ps.setString(5, nvLicenca.getSituacao());
         ps.setString(6, nvLicenca.getSeqNvTipoLicenca());
         ps.setString(7, nvLicenca.getSeqNvEmbarcacao());

         try {
            ps.setDate(8, new Date(nvLicenca.getDataEmissao().getTime()));
         } catch (NullPointerException var9) {
            ps.setDate(8, (Date)null);
         }

         ps.setString(9, nvLicenca.getNomeVistoriador());
         ps.setString(10, nvLicenca.getAnoTerminoConstrucao());
         ps.setString(11, nvLicenca.getSeqColaborador());
         ps.setString(12, nvLicenca.getObservacao());
         ps.setString(13, nvLicenca.getLocalEmissao());

         try {
            ps.setDate(14, new Date(nvLicenca.getValidadeLicencaTemporaria().getTime()));
         } catch (NullPointerException var8) {
            ps.setDate(14, (Date)null);
         }

         ps.setString(15, nvLicenca.getStatus());
         ps.setString(16, nvLicenca.getAssinaturaDigital());
         ps.setString(17, nvLicenca.getSeqUnidadeNegocio());  
         ps.execute();
         ps.close();
      } catch (SQLException var11) {
         Logger.getLogger(NvLicencaDAO.class.getName()).log(Level.SEVERE, (String)null, var11);
         System.out.println(var11.getMessage());
      }

      return nvLicenca;
   }

   public NvLicenca alterar(NvLicenca nvLicenca) {
      try {
         new Conexao();
         Connection conn = Conexao.getConnection();
         String sql = "update NV_LICENCA set IDENTIFICACAO = ?,SEQ_EMPRESA = ?,DATA_CADASTRO = ?,SITUACAO = ?,SEQ_NV_TIPO_LICENCA = ?,SEQ_NV_EMBARCACAO = ?,DATA_EMISSAO = ?,NOME_VISTORIADOR = ?, ANO_TERMINO_CONSTRUCAO = ?, SEQ_COLABORADOR = ?, observacao = ?, local_emissao = ?, VALIDADE_LICENCA_PROVISORIA = ?,status = ?, assinatura_digital = ?, seq_unidade_negocio = ? where SEQ_NV_LICENCA = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, nvLicenca.getIdentificacao());
         ps.setString(2, nvLicenca.getSeqEmpresa());
         ps.setDate(3, new Date(nvLicenca.getDataCadastro().getTime()));
         ps.setString(4, nvLicenca.getSituacao());
         ps.setString(5, nvLicenca.getSeqNvTipoLicenca());
         ps.setString(6, nvLicenca.getSeqNvEmbarcacao());
         ps.setDate(7, new Date(nvLicenca.getDataEmissao().getTime()));
         ps.setString(8, nvLicenca.getNomeVistoriador());
         ps.setString(9, nvLicenca.getAnoTerminoConstrucao());
         ps.setString(10, nvLicenca.getSeqColaborador());
         ps.setString(11, nvLicenca.getObservacao());
         ps.setString(12, nvLicenca.getLocalEmissao());

         try {
            ps.setDate(13, new Date(nvLicenca.getValidadeLicencaTemporaria().getTime()));
         } catch (NullPointerException var7) {
            ps.setDate(13, (Date)null);
         }

         ps.setString(14, nvLicenca.getStatus());
         ps.setString(15, nvLicenca.getAssinaturaDigital());
         ps.setString(16, nvLicenca.getSeqUnidadeNegocio()); 
         ps.setString(17, nvLicenca.getSeqNvLicenca());
         ps.execute();
         ps.close();
      } catch (SQLException var8) {
         Logger.getLogger(NvLicencaDAO.class.getName()).log(Level.SEVERE, (String)null, var8);
         System.out.println(var8.getMessage());
      }

      return nvLicenca;
   }

   public List<NvLicenca> listar(ClausulaWhere sClausula) {
      try {
         new Conexao();
         Connection conn = Conexao.getConnection();
         String sql = "SELECT NV_LICENCA.*, nv_embarcacao.nome embarcacao_nome FROM NV_LICENCA\ninner join nv_embarcacao on nv_embarcacao.seq_nv_embarcacao = NV_LICENCA.seq_nv_embarcacao" + sClausula.montarsClausula();
         System.out.println(sql);
         List<NvLicenca> listaNvLicenca = new ArrayList();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();

         while(rs.next()) {
            NvLicenca nvLicenca = new NvLicenca();
            nvLicenca.setSeqNvLicenca(rs.getString("SEQ_NV_LICENCA"));
            nvLicenca.setIdentificacao(rs.getString("IDENTIFICACAO"));
            nvLicenca.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
            nvLicenca.setDataCadastro(rs.getDate("DATA_CADASTRO"));
            nvLicenca.setSituacao(rs.getString("SITUACAO"));
            nvLicenca.setSeqNvTipoLicenca(rs.getString("SEQ_NV_TIPO_LICENCA"));
            nvLicenca.setSeqNvEmbarcacao(rs.getString("SEQ_NV_EMBARCACAO"));
            nvLicenca.setDataEmissao(rs.getDate("DATA_EMISSAO"));
            nvLicenca.setNomeVistoriador(rs.getString("NOME_VISTORIADOR"));
            nvLicenca.setEmbarcacaoNome(rs.getString("embarcacao_nome"));
            nvLicenca.setAnoTerminoConstrucao(rs.getString("ANO_TERMINO_CONSTRUCAO"));
            nvLicenca.setSeqColaborador(rs.getString("SEQ_COLABORADOR"));
            nvLicenca.setObservacao(rs.getString("OBSERVACAO"));
            nvLicenca.setValidadeLicencaTemporaria(rs.getDate("VALIDADE_LICENCA_PROVISORIA"));
            nvLicenca.setLocalEmissao(rs.getString("local_emissao"));
            nvLicenca.setStatus(rs.getString("status"));
            nvLicenca.setAssinaturaDigital(rs.getString("ASSINATURA_DIGITAL"));
            nvLicenca.setSeqUnidadeNegocio(rs.getString("SEQ_UNIDADE_NEGOCIO"));
           /* nvLicenca.setSeqNvTipoLicenca(rs.getString("nome_unidade"));*/
            listaNvLicenca.add(nvLicenca);
         }

         ps.execute();
         ps.close();
         return listaNvLicenca;
      } catch (SQLException var9) {
         Logger.getLogger(NvLicencaDAO.class.getName()).log(Level.SEVERE, (String)null, var9);
         System.out.println(var9.getMessage());
         return null;
      }
   }

   public boolean deletar(NvLicenca nvLicenca) {
      try {
         new Conexao();
         Connection conn = Conexao.getConnection();
         String sql = "DELETE FROM NV_LICENCA WHERE SEQ_NV_LICENCA =  ? ";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, nvLicenca.getSeqNvLicenca());
         ps.execute();
         ps.close();
         return true;
      } catch (SQLException var6) {
         System.out.println(var6.getMessage());
         return false;
      }
   }
}