package NvLicenca;

import ClausulaSQL.ClausulaWhere;
import ClausulaSQL.GeneroCondicaoWhere;
import ClausulaSQL.OperacaoCondicaoWhere;
import ClausulaSQL.TipoCondicaoWhere;
import Util.Situacao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NvLicencaService {
   public NvLicenca salvar(NvLicenca nvLicenca) {
      NvLicencaDAO dao = new NvLicencaDAO();
      if (nvLicenca.getSeqNvLicenca() == null) {
         nvLicenca.setDataCadastro(new Date());
         dao.inserir(nvLicenca);
         return nvLicenca;
      } else {
         dao.alterar(nvLicenca);
         return nvLicenca;
      }
   }

   public List<NvLicenca> listar(ClausulaWhere sClausula) {
      NvLicencaDAO dao = new NvLicencaDAO();
      return dao.listar(sClausula);
   }

   public List<NvLicenca> listar(String pSeqEmpresa, String pString, Situacao pSituacao) {
      NvLicencaDAO dao = new NvLicencaDAO();
      new ArrayList();
      ClausulaWhere condicao = new ClausulaWhere();
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "NV_LICENCA.identificacao", GeneroCondicaoWhere.contem, pString, TipoCondicaoWhere.Texto);
      condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_LICENCA.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(pSeqEmpresa), TipoCondicaoWhere.Numero);
      if (pSituacao == Situacao.ATIVO) {
         condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_LICENCA.situacao", GeneroCondicaoWhere.igual, "ATIVO", TipoCondicaoWhere.Texto);
      } else if (pSituacao == Situacao.INATIVO) {
         condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_LICENCA.situacao", GeneroCondicaoWhere.igual, "INATIVO", TipoCondicaoWhere.Texto);
      }

      List<NvLicenca> listaNvLicenca = dao.listar(condicao);
      return listaNvLicenca;
   }

   public boolean deletar(NvLicenca nvLicenca) {
      NvLicencaDAO dao = new NvLicencaDAO();
      return dao.deletar(nvLicenca);
   }
}