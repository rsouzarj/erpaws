    package NvListaCertificado;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ClausulaSQL.ClausulaWhere;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import Util.Conexao;
import Util.Sequence;

public class NvListaCertificadoDAO
{
    public NvListaCertificado inserir(final NvListaCertificado nvListaCertificado) {
        try {
            final String seq = Sequence.buscarNumeroSequence("SEQ_NV_LISTA_CERTIFICADO");
            nvListaCertificado.setSeqNvListaCertificado(seq);
            final Connection conn = Conexao.getConnection();
            final String sql = "insert into NV_LISTA_CERTIFICADO(SEQ_NV_LISTA_CERTIFICADO,DATA_CADASTRO,TIPO_CERTIFICADO, SEQ_USUARIO,NOME_ARQUIVO,SEQ_EMPRESA) values  (?,?,?,?,?,?)";
            final PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nvListaCertificado.getSeqNvListaCertificado());
            try {
                ps.setDate(2, new Date(nvListaCertificado.getDataCadastro().getTime()));
            }
            catch (NullPointerException ex2) {
                ps.setDate(2, null);
            }
            ps.setString(3, nvListaCertificado.getTipoCertificado());
            ps.setString(4, nvListaCertificado.getSeqUsuario());
            ps.setString(5, nvListaCertificado.getNomeArquivo());
            ps.setString(6, nvListaCertificado.getSeqEmpresa());
            ps.execute();
            ps.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(NvListaCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return nvListaCertificado;
    }
    
    public List<NvListaCertificado> listar(final ClausulaWhere sClausula) {
        try {
            final Connection conn = Conexao.getConnection();
            final String sql = "select nv_lista_certificado.*,usuario.usuario from nv_lista_certificado \njoin usuario on nv_lista_certificado.seq_usuario = usuario.seq_usuario\n"  + sClausula.montarsClausula();;
            System.out.println(sql);
            final List<NvListaCertificado> listaNvListaCertificado = new ArrayList<NvListaCertificado>();
            final PreparedStatement ps = conn.prepareStatement(sql);
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final NvListaCertificado nvListaCertificado = new NvListaCertificado();
                nvListaCertificado.setSeqNvListaCertificado(rs.getString("SEQ_NV_LISTA_CERTIFICADO"));
                nvListaCertificado.setTipoCertificado(rs.getString("TIPO_CERTIFICADO"));
                nvListaCertificado.setSeqUsuario(rs.getString("SEQ_USUARIO"));
                nvListaCertificado.setUsuario(rs.getString("USUARIO"));
                nvListaCertificado.setDataCadastro(rs.getDate("DATA_CADASTRO"));
                nvListaCertificado.setNomeArquivo(rs.getString("NOME_ARQUIVO"));
                nvListaCertificado.setSeqEmpresa(rs.getString("SEQ_EMPRESA"));
                listaNvListaCertificado.add(nvListaCertificado);
            }
            ps.execute();
            ps.close();
            return listaNvListaCertificado;
        }
        catch (SQLException ex) {
            Logger.getLogger(NvListaCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public boolean deletar(final NvListaCertificado nvListaCertificado) {
        try {
            final Connection conn = Conexao.getConnection();
            final String sql = "DELETE FROM NV_LISTA_CERTIFICADO WHERE SEQ_NV_LISTA_CERTIFICADO =  ? ";
            final PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nvListaCertificado.getSeqNvListaCertificado());
            ps.execute();
            ps.close();
            return true;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
