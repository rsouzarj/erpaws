/*     */ package NvVistoria;
/*     */ 
/*     */ import java.util.Date;

/*     */ public class NvVistoria
/*     */ {
/*     */   private String seqNvVistoria;
/*     */   private String identificacao;
/*     */   private String seqEmpresa;
/*     */   private Date dataCadastro;
/*     */   private String transporteCombustivel;
/*     */   private String seqNvTipoVistoria;
/*     */   private String seqNvEmbarcacao;
/*     */   private Date dataVistoria;
/*     */   private String cidadeVistoria;
/*     */   private String estadoVistoria;
/*     */   private String seqColaborador;
/*     */   private String situacao;
/*     */   private String EmbarcacaoNome;
/*     */   private String tipoVistoria;
/*     */   private String colaboradorNome;
/*     */   private Date dataDocagem;
/*     */   private Date dataEmissaoLaudo;
/*     */   private String seqNvVistoriaStatus;
/*     */   private String seqEquipamento;
            private String aprovador;
/*     */   private String usuario;
            private String seqUnidadeNegocio;   

/*     */   public String getSeqNvVistoria()
/*     */   {
/*  36 */     return this.seqNvVistoria;
/*     */   }
/*     */   
/*     */   public void setSeqNvVistoria(String seqNvVistoria) {
/*  40 */     this.seqNvVistoria = seqNvVistoria;
/*     */   }
/*     */   
/*     */   public String getIdentificacao() {
/*  44 */     return this.identificacao;
/*     */   }
/*     */   
/*     */   public void setIdentificacao(String identificacao) {
/*  48 */     this.identificacao = identificacao;
/*     */   }
/*     */   
/*     */   public String getSeqEmpresa() {
/*  52 */     return this.seqEmpresa;
/*     */   }
/*     */   
/*     */   public void setSeqEmpresa(String seqEmpresa) {
/*  56 */     this.seqEmpresa = seqEmpresa;
/*     */   }
/*     */   
/*     */   public Date getDataCadastro() {
/*  60 */     return this.dataCadastro;
/*     */   }
/*     */   
/*     */   public void setDataCadastro(Date dataCadastro) {
/*  64 */     this.dataCadastro = dataCadastro;
/*     */   }
/*     */   
/*     */   public String getTransporteCombustivel() {
/*  68 */     return this.transporteCombustivel;
/*     */   }
/*     */   
/*     */   public void setTransporteCombustivel(String transporteCombustivel) {
/*  72 */     this.transporteCombustivel = transporteCombustivel;
/*     */   }
/*     */   
/*     */   public String getSeqNvTipoVistoria() {
/*  76 */     return this.seqNvTipoVistoria;
/*     */   }
/*     */   
/*     */   public void setSeqNvTipoVistoria(String seqNvTipoVistoria) {
/*  80 */     this.seqNvTipoVistoria = seqNvTipoVistoria;
/*     */   }
/*     */   
/*     */   public String getSeqNvEmbarcacao() {
/*  84 */     return this.seqNvEmbarcacao;
/*     */   }
/*     */   
/*     */   public void setSeqNvEmbarcacao(String seqNvEmbarcacao) {
/*  88 */     this.seqNvEmbarcacao = seqNvEmbarcacao;
/*     */   }
/*     */   

            public String getSeqEquipamento () {
              return this.seqEquipamento;  
            }

            public void setseqEquipamento(String seqEquipamento) {
              this.seqEquipamento = seqEquipamento;
            }
              
/*     */   public Date getDataVistoria() {
/*  92 */     return this.dataVistoria;
/*     */   }
/*     */   
/*     */   public void setDataVistoria(Date dataVistoria) {
/*  96 */     this.dataVistoria = dataVistoria;
/*     */   }
/*     */   
/*     */   public String getCidadeVistoria() {
/* 100 */     return this.cidadeVistoria;
/*     */   }
/*     */   
/*     */   public void setCidadeVistoria(String cidadeVistoria) {
/* 104 */     this.cidadeVistoria = cidadeVistoria;
/*     */   }
/*     */   
/*     */   public String getEstadoVistoria() {
/* 108 */     return this.estadoVistoria;
/*     */   }
/*     */   
/*     */   public void setEstadoVistoria(String estadoVistoria) {
/* 112 */     this.estadoVistoria = estadoVistoria;
/*     */   }
/*     */   
/*     */   public String getSeqColaborador() {
/* 116 */     return this.seqColaborador;
/*     */   }
/*     */   
/*     */   public void setSeqColaborador(String seqColaborador) {
/* 120 */     this.seqColaborador = seqColaborador;
/*     */   }
/*     */   
/*     */   public String getSituacao() {
/* 124 */     return this.situacao;
/*     */   }
/*     */   
/*     */   public void setSituacao(String situacao) {
/* 128 */     this.situacao = situacao;
/*     */   }
/*     */   
/*     */   public String getEmbarcacaoNome() {
/* 132 */     return this.EmbarcacaoNome;
/*     */   }
/*     */   
/*     */   public void setEmbarcacaoNome(String EmbarcacaoNome) {
/* 136 */     this.EmbarcacaoNome = EmbarcacaoNome;
/*     */   }
/*     */   
/*     */   public String getTipoVistoria() {
/* 140 */     return this.tipoVistoria;
/*     */   }
/*     */   
/*     */   public void setTipoVistoria(String tipoVistoria) {
/* 144 */     this.tipoVistoria = tipoVistoria;
/*     */   }
/*     */   
/*     */   public String getColaboradorNome() {
/* 148 */     return this.colaboradorNome;
/*     */   }
/*     */   
/*     */   public void setColaboradorNome(String colaboradorNome) {
/* 152 */     this.colaboradorNome = colaboradorNome;
/*     */   }
/*     */   
/*     */   public Date getDataDocagem() {
/* 156 */     return this.dataDocagem;
/*     */   }
/*     */   
/*     */   public void setDataDocagem(Date dataDocagem) {
/* 160 */     this.dataDocagem = dataDocagem;
/*     */   }
/*     */   
/*     */   public String getSeqNvVistoriaStatus() {
/* 164 */     return this.seqNvVistoriaStatus;
/*     */   }
/*     */   
/*     */   public void setSeqNvVistoriaStatus(String seqNvVistoriaStatus) {
/* 168 */     this.seqNvVistoriaStatus = seqNvVistoriaStatus;
/*     */   }
/*     */   
/*     */   public Date getDataEmissaoLaudo() {
/* 172 */     return this.dataEmissaoLaudo;
/*     */   }
/*     */   
/*     */   public void setDataEmissaoLaudo(Date dataEmissaoLaudo) {
/* 176 */     this.dataEmissaoLaudo = dataEmissaoLaudo;
/*     */   }

            public String getAprovador() {
/* 172 */     return this.aprovador;
/*     */   }
/*     */   
/*     */   public void setAprovador(String aprovador) {
/* 176 */     this.aprovador = aprovador;
/*     */   }

             public String getUsuario() {
/* 172 */     return this.usuario;
/*     */   }
/*     */   
/*     */   public void setUsuario(String usuario) {
/* 176 */     this.usuario = usuario;
/*     */   }

            public String getSeqUnidadeNegocio() {
             return this.seqUnidadeNegocio;
            }

            public void setSeqUnidadeNegocio(String seqUnidadeNegocio) {
              this.seqUnidadeNegocio = seqUnidadeNegocio;
            } 
 }
