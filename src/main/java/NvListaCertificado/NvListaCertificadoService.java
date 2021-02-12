package NvListaCertificado;

import ClausulaSQL.TipoCondicaoWhere;
import ClausulaSQL.GeneroCondicaoWhere;
import ClausulaSQL.OperacaoCondicaoWhere;
import ClausulaSQL.ClausulaWhere;
import java.util.List;
import java.util.Date;

public class NvListaCertificadoService
{
    public NvListaCertificado salvar(final NvListaCertificado nvCertificado) {
        final NvListaCertificadoDAO dao = new NvListaCertificadoDAO();
        nvCertificado.setDataCadastro(new Date());
        dao.inserir(nvCertificado);
        return nvCertificado;
    }
    
    public boolean deletar(final NvListaCertificado nvCertificado) {
        final NvListaCertificadoDAO dao = new NvListaCertificadoDAO();
        return dao.deletar(nvCertificado);
    }
    
    public List<NvListaCertificado> listar(final String seqEmpresa) {
        final NvListaCertificadoDAO dao = new NvListaCertificadoDAO();
        final ClausulaWhere condicao = new ClausulaWhere();
        condicao.AdicionarCondicao(OperacaoCondicaoWhere.vazio, "NV_LISTA_CERTIFICADO.seq_empresa", GeneroCondicaoWhere.igual, String.valueOf(seqEmpresa), TipoCondicaoWhere.Numero);
        return (List<NvListaCertificado>)dao.listar(condicao);
    }
    
    public List<NvListaCertificado> listarql(final String tipoCertificado) {
        final NvListaCertificadoDAO dao = new NvListaCertificadoDAO();
        final ClausulaWhere condicao = new ClausulaWhere();
        condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_LISTA_CERTIFICADO.tipo_certificado", GeneroCondicaoWhere.igual,"Qualidade", TipoCondicaoWhere.Texto);
        return (List<NvListaCertificado>)dao.listar(condicao);
    }
    
    public List<NvListaCertificado> listarsms(final String tipoCertificado) {
        final NvListaCertificadoDAO dao = new NvListaCertificadoDAO();
        final ClausulaWhere condicao = new ClausulaWhere();
        condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_LISTA_CERTIFICADO.tipo_certificado", GeneroCondicaoWhere.igual,"SMS", TipoCondicaoWhere.Texto);
        return (List<NvListaCertificado>)dao.listar(condicao);
    }
    
      public List<NvListaCertificado> listarpt(final String tipoCertificado) {
        final NvListaCertificadoDAO dao = new NvListaCertificadoDAO();
        final ClausulaWhere condicao = new ClausulaWhere();
        condicao.AdicionarCondicao(OperacaoCondicaoWhere.and, "NV_LISTA_CERTIFICADO.tipo_certificado", GeneroCondicaoWhere.igual,"Procedimento Técnico", TipoCondicaoWhere.Texto);
        return (List<NvListaCertificado>)dao.listar(condicao);
    }
    
    
}
