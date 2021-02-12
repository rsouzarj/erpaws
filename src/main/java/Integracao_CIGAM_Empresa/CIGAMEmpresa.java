/*     */ package Integracao_CIGAM_Empresa;
/*     */ 
/*     */ import java.math.BigDecimal;
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
/*     */ 
/*     */ public class CIGAMEmpresa
/*     */ {
/*     */   String pin;
/*     */   String statusRegistro;
/*     */   String codigoEmpresa;
/*     */   String nomeCompleto;
/*     */   String contato;
/*     */   String fone;
/*     */   String faxFone;
/*     */   String endereco;
/*     */   String bairro;
/*     */   String municipio;
/*     */   String Uf;
/*     */   String cep;
/*     */   String cnpjCpf;
/*     */   Boolean inscrito;
/*     */   String inscricao;
/*     */   String conceito;
/*     */   String codigoDivisao;
/*     */   String dataNascimento;
/*     */   String ultimoMovimento;
/*     */   String cadastro;
/*     */   String codigoIndicacao;
/*     */   String codigoRepresentante;
/*     */   BigDecimal percentualComissaoBaixa;
/*     */   String contabilCliente;
/*     */   String codigoResponsavel;
/*     */   String fantasia;
/*     */   Boolean pessoa;
/*     */   String codigoContabilFornecedor;
/*     */   String codigoCondicaoPagamento;
/*     */   String codigoTipoPagamento;
/*     */   String codigoTipoOperacao;
/*     */   BigDecimal irrfAcumulado;
/*     */   String tipoEmpresa;
/*     */   String atividade;
/*     */   String funcionarios;
/*     */   BigDecimal faturamento;
/*     */   BigDecimal limiteCredito;
/*     */   String codigoMercado;
/*     */   String codigoUsuarioModificacao;
/*     */   String enviarCarta;
/*     */   String tabelaPrecos;
/*     */   String agendaInterna;
/*     */   String codigoPais;
/*     */   String codigoCentralizadora;
/*     */   String atrasoMedio;
/*     */   String numero;
/*     */   String complemento;
/*     */   String inscricaoMunicipal;
/*     */   String suframa;
/*     */   String tipoFrete;
/*     */   BigDecimal percentualIndenizacao;
/*     */   BigDecimal percDescontoSugestaoItens;
/*     */   BigDecimal percentualDesconto2;
/*     */   BigDecimal jurosPadrao;
/*     */   String codigoUnidadeNegocio;
/*     */   String codigoPortadorPadrao;
/*     */   Boolean ativo;
/*     */   String sessao;
/*     */   String codigoContabilAdiantamentoCli;
/*     */   String codigoContabilAdiantamentoForn;
/*     */   String codigoCentroArmazenagem;
/*     */   String codigoIndiceCredito;
/*     */   String codigoUsuarioCriacao;
/*     */   String dataModificacao;
/*     */   String codigoRegiaoEntrega;
/*     */   String dataValidadeCredito;
/*     */   String codigoSetor;
/*     */   String codigoRegimeTriburario;
/*     */   String ultimaConsultaCredito;
/*     */   String validadeCobrancaAdmin;
/*     */   String ultimaVenda;
/*     */   String prefixoCnae;
/*     */   String basePrazoDiferenciado;
/*     */   String possuiRetencaoIss;
/*     */   String centroArmazenagemMaterialAlt;
/*     */   String filtroDataDirf;
/*     */   String tipoImovel;
/*     */   String listarIss;
/*     */   String diaVencimento;
/*     */   String limiteFaturamento;
/*     */   String grauRelacionamento;
/*     */   String sufixoCnae;
/*     */   String toleranciaVencimento;
/*     */   String nivelCredito;
/*     */   Boolean listarDirf;
/*     */   Boolean conveniada;
/*     */   Boolean creditoLiberado;
/*     */   BigDecimal percentualFrete;
/*     */   BigDecimal codigoEan;
/*     */   BigDecimal percentualAcrescimoLimite;
/*     */   BigDecimal percentualAcrescimoPreco;
/*     */   BigDecimal utilizaPrazoDiferenciado;
/*     */   BigDecimal tgPadraoNfs;
/*     */   BigDecimal limiteCreditoMensal;
/*     */   BigDecimal optanteSimples;
/*     */   String Usrempr1;
/*     */   String Usrempr2;
/*     */   String cnaeServico;
/*     */   String Usrempr4;
/*     */   BigDecimal valorFrete;
/*     */   
/*     */   public String getCodigoEmpresa()
/*     */   {
/* 120 */     return this.codigoEmpresa;
/*     */   }
/*     */   
/*     */   public void setCodigoEmpresa(String codigoEmpresa) {
/* 124 */     this.codigoEmpresa = codigoEmpresa;
/*     */   }
/*     */   
/*     */   public String getNomeCompleto() {
/* 128 */     return this.nomeCompleto;
/*     */   }
/*     */   
/*     */   public void setNomeCompleto(String nomeCompleto) {
/* 132 */     this.nomeCompleto = nomeCompleto;
/*     */   }
/*     */   
/*     */   public String getContato() {
/* 136 */     return this.contato;
/*     */   }
/*     */   
/*     */   public void setContato(String contato) {
/* 140 */     this.contato = contato;
/*     */   }
/*     */   
/*     */   public String getFone() {
/* 144 */     return this.fone;
/*     */   }
/*     */   
/*     */   public void setFone(String fone) {
/* 148 */     this.fone = fone;
/*     */   }
/*     */   
/*     */   public String getFaxFone() {
/* 152 */     return this.faxFone;
/*     */   }
/*     */   
/*     */   public void setFaxFone(String faxFone) {
/* 156 */     this.faxFone = faxFone;
/*     */   }
/*     */   
/*     */   public String getEndereco() {
/* 160 */     return this.endereco;
/*     */   }
/*     */   
/*     */   public void setEndereco(String endereco) {
/* 164 */     this.endereco = endereco;
/*     */   }
/*     */   
/*     */   public String getBairro() {
/* 168 */     return this.bairro;
/*     */   }
/*     */   
/*     */   public void setBairro(String bairro) {
/* 172 */     this.bairro = bairro;
/*     */   }
/*     */   
/*     */   public String getMunicipio() {
/* 176 */     return this.municipio;
/*     */   }
/*     */   
/*     */   public void setMunicipio(String municipio) {
/* 180 */     this.municipio = municipio;
/*     */   }
/*     */   
/*     */   public String getUf() {
/* 184 */     return this.Uf;
/*     */   }
/*     */   
/*     */   public void setUf(String Uf) {
/* 188 */     this.Uf = Uf;
/*     */   }
/*     */   
/*     */   public String getCep() {
/* 192 */     return this.cep;
/*     */   }
/*     */   
/*     */   public void setCep(String cep) {
/* 196 */     this.cep = cep;
/*     */   }
/*     */   
/*     */   public String getCnpjCpf() {
/* 200 */     return this.cnpjCpf;
/*     */   }
/*     */   
/*     */   public void setCnpjCpf(String cnpjCpf) {
/* 204 */     this.cnpjCpf = cnpjCpf;
/*     */   }
/*     */   
/*     */   public Boolean getInscrito() {
/* 208 */     return this.inscrito;
/*     */   }
/*     */   
/*     */   public void setInscrito(Boolean inscrito) {
/* 212 */     this.inscrito = inscrito;
/*     */   }
/*     */   
/*     */   public String getInscricao() {
/* 216 */     return this.inscricao;
/*     */   }
/*     */   
/*     */   public void setInscricao(String inscricao) {
/* 220 */     this.inscricao = inscricao;
/*     */   }
/*     */   
/*     */   public String getConceito() {
/* 224 */     return this.conceito;
/*     */   }
/*     */   
/*     */   public void setConceito(String conceito) {
/* 228 */     this.conceito = conceito;
/*     */   }
/*     */   
/*     */   public String getCodigoDivisao() {
/* 232 */     return this.codigoDivisao;
/*     */   }
/*     */   
/*     */   public void setCodigoDivisao(String codigoDivisao) {
/* 236 */     this.codigoDivisao = codigoDivisao;
/*     */   }
/*     */   
/*     */   public String getDataNascimento() {
/* 240 */     return this.dataNascimento;
/*     */   }
/*     */   
/*     */   public void setDataNascimento(String dataNascimento) {
/* 244 */     this.dataNascimento = dataNascimento;
/*     */   }
/*     */   
/*     */   public String getUltimoMovimento() {
/* 248 */     return this.ultimoMovimento;
/*     */   }
/*     */   
/*     */   public void setUltimoMovimento(String ultimoMovimento) {
/* 252 */     this.ultimoMovimento = ultimoMovimento;
/*     */   }
/*     */   
/*     */   public String getCadastro() {
/* 256 */     return this.cadastro;
/*     */   }
/*     */   
/*     */   public void setCadastro(String cadastro) {
/* 260 */     this.cadastro = cadastro;
/*     */   }
/*     */   
/*     */   public String getCodigoIndicacao() {
/* 264 */     return this.codigoIndicacao;
/*     */   }
/*     */   
/*     */   public void setCodigoIndicacao(String codigoIndicacao) {
/* 268 */     this.codigoIndicacao = codigoIndicacao;
/*     */   }
/*     */   
/*     */   public String getCodigoRepresentante() {
/* 272 */     return this.codigoRepresentante;
/*     */   }
/*     */   
/*     */   public void setCodigoRepresentante(String codigoRepresentante) {
/* 276 */     this.codigoRepresentante = codigoRepresentante;
/*     */   }
/*     */   
/*     */   public BigDecimal getPercentualComissaoBaixa() {
/* 280 */     return this.percentualComissaoBaixa;
/*     */   }
/*     */   
/*     */   public void setPercentualComissaoBaixa(BigDecimal percentualComissaoBaixa) {
/* 284 */     this.percentualComissaoBaixa = percentualComissaoBaixa;
/*     */   }
/*     */   
/*     */   public String getContabilCliente() {
/* 288 */     return this.contabilCliente;
/*     */   }
/*     */   
/*     */   public void setContabilCliente(String contabilCliente) {
/* 292 */     this.contabilCliente = contabilCliente;
/*     */   }
/*     */   
/*     */   public String getCodigoResponsavel() {
/* 296 */     return this.codigoResponsavel;
/*     */   }
/*     */   
/*     */   public void setCodigoResponsavel(String codigoResponsavel) {
/* 300 */     this.codigoResponsavel = codigoResponsavel;
/*     */   }
/*     */   
/*     */   public String getFantasia() {
/* 304 */     return this.fantasia;
/*     */   }
/*     */   
/*     */   public void setFantasia(String fantasia) {
/* 308 */     this.fantasia = fantasia;
/*     */   }
/*     */   
/*     */   public Boolean getPessoa() {
/* 312 */     return this.pessoa;
/*     */   }
/*     */   
/*     */   public void setPessoa(Boolean pessoa) {
/* 316 */     this.pessoa = pessoa;
/*     */   }
/*     */   
/*     */   public String getCodigoContabilFornecedor() {
/* 320 */     return this.codigoContabilFornecedor;
/*     */   }
/*     */   
/*     */   public void setCodigoContabilFornecedor(String codigoContabilFornecedor) {
/* 324 */     this.codigoContabilFornecedor = codigoContabilFornecedor;
/*     */   }
/*     */   
/*     */   public String getCodigoCondicaoPagamento() {
/* 328 */     return this.codigoCondicaoPagamento;
/*     */   }
/*     */   
/*     */   public void setCodigoCondicaoPagamento(String codigoCondicaoPagamento) {
/* 332 */     this.codigoCondicaoPagamento = codigoCondicaoPagamento;
/*     */   }
/*     */   
/*     */   public String getCodigoTipoPagamento() {
/* 336 */     return this.codigoTipoPagamento;
/*     */   }
/*     */   
/*     */   public void setCodigoTipoPagamento(String codigoTipoPagamento) {
/* 340 */     this.codigoTipoPagamento = codigoTipoPagamento;
/*     */   }
/*     */   
/*     */   public String getCodigoTipoOperacao() {
/* 344 */     return this.codigoTipoOperacao;
/*     */   }
/*     */   
/*     */   public void setCodigoTipoOperacao(String codigoTipoOperacao) {
/* 348 */     this.codigoTipoOperacao = codigoTipoOperacao;
/*     */   }
/*     */   
/*     */   public BigDecimal getIrrfAcumulado() {
/* 352 */     return this.irrfAcumulado;
/*     */   }
/*     */   
/*     */   public void setIrrfAcumulado(BigDecimal irrfAcumulado) {
/* 356 */     this.irrfAcumulado = irrfAcumulado;
/*     */   }
/*     */   
/*     */   public String getTipoEmpresa() {
/* 360 */     return this.tipoEmpresa;
/*     */   }
/*     */   
/*     */   public void setTipoEmpresa(String tipoEmpresa) {
/* 364 */     this.tipoEmpresa = tipoEmpresa;
/*     */   }
/*     */   
/*     */   public String getAtividade() {
/* 368 */     return this.atividade;
/*     */   }
/*     */   
/*     */   public void setAtividade(String atividade) {
/* 372 */     this.atividade = atividade;
/*     */   }
/*     */   
/*     */   public String getFuncionarios() {
/* 376 */     return this.funcionarios;
/*     */   }
/*     */   
/*     */   public void setFuncionarios(String funcionarios) {
/* 380 */     this.funcionarios = funcionarios;
/*     */   }
/*     */   
/*     */   public BigDecimal getFaturamento() {
/* 384 */     return this.faturamento;
/*     */   }
/*     */   
/*     */   public void setFaturamento(BigDecimal faturamento) {
/* 388 */     this.faturamento = faturamento;
/*     */   }
/*     */   
/*     */   public BigDecimal getLimiteCredito() {
/* 392 */     return this.limiteCredito;
/*     */   }
/*     */   
/*     */   public void setLimiteCredito(BigDecimal limiteCredito) {
/* 396 */     this.limiteCredito = limiteCredito;
/*     */   }
/*     */   
/*     */   public String getCodigoMercado() {
/* 400 */     return this.codigoMercado;
/*     */   }
/*     */   
/*     */   public void setCodigoMercado(String codigoMercado) {
/* 404 */     this.codigoMercado = codigoMercado;
/*     */   }
/*     */   
/*     */   public String getCodigoUsuarioModificacao() {
/* 408 */     return this.codigoUsuarioModificacao;
/*     */   }
/*     */   
/*     */   public void setCodigoUsuarioModificacao(String codigoUsuarioModificacao) {
/* 412 */     this.codigoUsuarioModificacao = codigoUsuarioModificacao;
/*     */   }
/*     */   
/*     */   public String getEnviarCarta() {
/* 416 */     return this.enviarCarta;
/*     */   }
/*     */   
/*     */   public void setEnviarCarta(String enviarCarta) {
/* 420 */     this.enviarCarta = enviarCarta;
/*     */   }
/*     */   
/*     */   public String getTabelaPrecos() {
/* 424 */     return this.tabelaPrecos;
/*     */   }
/*     */   
/*     */   public void setTabelaPrecos(String tabelaPrecos) {
/* 428 */     this.tabelaPrecos = tabelaPrecos;
/*     */   }
/*     */   
/*     */   public String getAgendaInterna() {
/* 432 */     return this.agendaInterna;
/*     */   }
/*     */   
/*     */   public void setAgendaInterna(String agendaInterna) {
/* 436 */     this.agendaInterna = agendaInterna;
/*     */   }
/*     */   
/*     */   public String getCodigoPais() {
/* 440 */     return this.codigoPais;
/*     */   }
/*     */   
/*     */   public void setCodigoPais(String codigoPais) {
/* 444 */     this.codigoPais = codigoPais;
/*     */   }
/*     */   
/*     */   public String getCodigoCentralizadora() {
/* 448 */     return this.codigoCentralizadora;
/*     */   }
/*     */   
/*     */   public void setCodigoCentralizadora(String codigoCentralizadora) {
/* 452 */     this.codigoCentralizadora = codigoCentralizadora;
/*     */   }
/*     */   
/*     */   public String getAtrasoMedio() {
/* 456 */     return this.atrasoMedio;
/*     */   }
/*     */   
/*     */   public void setAtrasoMedio(String atrasoMedio) {
/* 460 */     this.atrasoMedio = atrasoMedio;
/*     */   }
/*     */   
/*     */   public String getNumero() {
/* 464 */     return this.numero;
/*     */   }
/*     */   
/*     */   public void setNumero(String numero) {
/* 468 */     this.numero = numero;
/*     */   }
/*     */   
/*     */   public String getComplemento() {
/* 472 */     return this.complemento;
/*     */   }
/*     */   
/*     */   public void setComplemento(String complemento) {
/* 476 */     this.complemento = complemento;
/*     */   }
/*     */   
/*     */   public String getInscricaoMunicipal() {
/* 480 */     return this.inscricaoMunicipal;
/*     */   }
/*     */   
/*     */   public void setInscricaoMunicipal(String inscricaoMunicipal) {
/* 484 */     this.inscricaoMunicipal = inscricaoMunicipal;
/*     */   }
/*     */   
/*     */   public String getSuframa() {
/* 488 */     return this.suframa;
/*     */   }
/*     */   
/*     */   public void setSuframa(String suframa) {
/* 492 */     this.suframa = suframa;
/*     */   }
/*     */   
/*     */   public String getTipoFrete() {
/* 496 */     return this.tipoFrete;
/*     */   }
/*     */   
/*     */   public void setTipoFrete(String tipoFrete) {
/* 500 */     this.tipoFrete = tipoFrete;
/*     */   }
/*     */   
/*     */   public BigDecimal getPercentualIndenizacao() {
/* 504 */     return this.percentualIndenizacao;
/*     */   }
/*     */   
/*     */   public void setPercentualIndenizacao(BigDecimal percentualIndenizacao) {
/* 508 */     this.percentualIndenizacao = percentualIndenizacao;
/*     */   }
/*     */   
/*     */   public BigDecimal getPercDescontoSugestaoItens() {
/* 512 */     return this.percDescontoSugestaoItens;
/*     */   }
/*     */   
/*     */   public void setPercDescontoSugestaoItens(BigDecimal percDescontoSugestaoItens) {
/* 516 */     this.percDescontoSugestaoItens = percDescontoSugestaoItens;
/*     */   }
/*     */   
/*     */   public BigDecimal getPercentualDesconto2() {
/* 520 */     return this.percentualDesconto2;
/*     */   }
/*     */   
/*     */   public void setPercentualDesconto2(BigDecimal percentualDesconto2) {
/* 524 */     this.percentualDesconto2 = percentualDesconto2;
/*     */   }
/*     */   
/*     */   public BigDecimal getJurosPadrao() {
/* 528 */     return this.jurosPadrao;
/*     */   }
/*     */   
/*     */   public void setJurosPadrao(BigDecimal jurosPadrao) {
/* 532 */     this.jurosPadrao = jurosPadrao;
/*     */   }
/*     */   
/*     */   public String getCodigoUnidadeNegocio() {
/* 536 */     return this.codigoUnidadeNegocio;
/*     */   }
/*     */   
/*     */   public void setCodigoUnidadeNegocio(String codigoUnidadeNegocio) {
/* 540 */     this.codigoUnidadeNegocio = codigoUnidadeNegocio;
/*     */   }
/*     */   
/*     */   public String getCodigoPortadorPadrao() {
/* 544 */     return this.codigoPortadorPadrao;
/*     */   }
/*     */   
/*     */   public void setCodigoPortadorPadrao(String codigoPortadorPadrao) {
/* 548 */     this.codigoPortadorPadrao = codigoPortadorPadrao;
/*     */   }
/*     */   
/*     */   public Boolean getAtivo() {
/* 552 */     return this.ativo;
/*     */   }
/*     */   
/*     */   public void setAtivo(Boolean ativo) {
/* 556 */     this.ativo = ativo;
/*     */   }
/*     */   
/*     */   public String getSessao() {
/* 560 */     return this.sessao;
/*     */   }
/*     */   
/*     */   public void setSessao(String sessao) {
/* 564 */     this.sessao = sessao;
/*     */   }
/*     */   
/*     */   public String getCodigoContabilAdiantamentoCli() {
/* 568 */     return this.codigoContabilAdiantamentoCli;
/*     */   }
/*     */   
/*     */   public void setCodigoContabilAdiantamentoCli(String codigoContabilAdiantamentoCli) {
/* 572 */     this.codigoContabilAdiantamentoCli = codigoContabilAdiantamentoCli;
/*     */   }
/*     */   
/*     */   public String getCodigoContabilAdiantamentoForn() {
/* 576 */     return this.codigoContabilAdiantamentoForn;
/*     */   }
/*     */   
/*     */   public void setCodigoContabilAdiantamentoForn(String codigoContabilAdiantamentoForn) {
/* 580 */     this.codigoContabilAdiantamentoForn = codigoContabilAdiantamentoForn;
/*     */   }
/*     */   
/*     */   public String getCodigoCentroArmazenagem() {
/* 584 */     return this.codigoCentroArmazenagem;
/*     */   }
/*     */   
/*     */   public void setCodigoCentroArmazenagem(String codigoCentroArmazenagem) {
/* 588 */     this.codigoCentroArmazenagem = codigoCentroArmazenagem;
/*     */   }
/*     */   
/*     */   public String getCodigoIndiceCredito() {
/* 592 */     return this.codigoIndiceCredito;
/*     */   }
/*     */   
/*     */   public void setCodigoIndiceCredito(String codigoIndiceCredito) {
/* 596 */     this.codigoIndiceCredito = codigoIndiceCredito;
/*     */   }
/*     */   
/*     */   public String getCodigoUsuarioCriacao() {
/* 600 */     return this.codigoUsuarioCriacao;
/*     */   }
/*     */   
/*     */   public void setCodigoUsuarioCriacao(String codigoUsuarioCriacao) {
/* 604 */     this.codigoUsuarioCriacao = codigoUsuarioCriacao;
/*     */   }
/*     */   
/*     */   public String getDataModificacao() {
/* 608 */     return this.dataModificacao;
/*     */   }
/*     */   
/*     */   public void setDataModificacao(String dataModificacao) {
/* 612 */     this.dataModificacao = dataModificacao;
/*     */   }
/*     */   
/*     */   public String getCodigoRegiaoEntrega() {
/* 616 */     return this.codigoRegiaoEntrega;
/*     */   }
/*     */   
/*     */   public void setCodigoRegiaoEntrega(String codigoRegiaoEntrega) {
/* 620 */     this.codigoRegiaoEntrega = codigoRegiaoEntrega;
/*     */   }
/*     */   
/*     */   public String getDataValidadeCredito() {
/* 624 */     return this.dataValidadeCredito;
/*     */   }
/*     */   
/*     */   public void setDataValidadeCredito(String dataValidadeCredito) {
/* 628 */     this.dataValidadeCredito = dataValidadeCredito;
/*     */   }
/*     */   
/*     */   public String getCodigoSetor() {
/* 632 */     return this.codigoSetor;
/*     */   }
/*     */   
/*     */   public void setCodigoSetor(String codigoSetor) {
/* 636 */     this.codigoSetor = codigoSetor;
/*     */   }
/*     */   
/*     */   public String getCodigoRegimeTriburario() {
/* 640 */     return this.codigoRegimeTriburario;
/*     */   }
/*     */   
/*     */   public void setCodigoRegimeTriburario(String codigoRegimeTriburario) {
/* 644 */     this.codigoRegimeTriburario = codigoRegimeTriburario;
/*     */   }
/*     */   
/*     */   public String getUltimaConsultaCredito() {
/* 648 */     return this.ultimaConsultaCredito;
/*     */   }
/*     */   
/*     */   public void setUltimaConsultaCredito(String ultimaConsultaCredito) {
/* 652 */     this.ultimaConsultaCredito = ultimaConsultaCredito;
/*     */   }
/*     */   
/*     */   public String getValidadeCobrancaAdmin() {
/* 656 */     return this.validadeCobrancaAdmin;
/*     */   }
/*     */   
/*     */   public void setValidadeCobrancaAdmin(String validadeCobrancaAdmin) {
/* 660 */     this.validadeCobrancaAdmin = validadeCobrancaAdmin;
/*     */   }
/*     */   
/*     */   public String getUltimaVenda() {
/* 664 */     return this.ultimaVenda;
/*     */   }
/*     */   
/*     */   public void setUltimaVenda(String ultimaVenda) {
/* 668 */     this.ultimaVenda = ultimaVenda;
/*     */   }
/*     */   
/*     */   public String getPrefixoCnae() {
/* 672 */     return this.prefixoCnae;
/*     */   }
/*     */   
/*     */   public void setPrefixoCnae(String prefixoCnae) {
/* 676 */     this.prefixoCnae = prefixoCnae;
/*     */   }
/*     */   
/*     */   public String getBasePrazoDiferenciado() {
/* 680 */     return this.basePrazoDiferenciado;
/*     */   }
/*     */   
/*     */   public void setBasePrazoDiferenciado(String basePrazoDiferenciado) {
/* 684 */     this.basePrazoDiferenciado = basePrazoDiferenciado;
/*     */   }
/*     */   
/*     */   public String getPossuiRetencaoIss() {
/* 688 */     return this.possuiRetencaoIss;
/*     */   }
/*     */   
/*     */   public void setPossuiRetencaoIss(String possuiRetencaoIss) {
/* 692 */     this.possuiRetencaoIss = possuiRetencaoIss;
/*     */   }
/*     */   
/*     */   public String getCentroArmazenagemMaterialAlt() {
/* 696 */     return this.centroArmazenagemMaterialAlt;
/*     */   }
/*     */   
/*     */   public void setCentroArmazenagemMaterialAlt(String centroArmazenagemMaterialAlt) {
/* 700 */     this.centroArmazenagemMaterialAlt = centroArmazenagemMaterialAlt;
/*     */   }
/*     */   
/*     */   public String getFiltroDataDirf() {
/* 704 */     return this.filtroDataDirf;
/*     */   }
/*     */   
/*     */   public void setFiltroDataDirf(String filtroDataDirf) {
/* 708 */     this.filtroDataDirf = filtroDataDirf;
/*     */   }
/*     */   
/*     */   public String getTipoImovel() {
/* 712 */     return this.tipoImovel;
/*     */   }
/*     */   
/*     */   public void setTipoImovel(String tipoImovel) {
/* 716 */     this.tipoImovel = tipoImovel;
/*     */   }
/*     */   
/*     */   public String getListarIss() {
/* 720 */     return this.listarIss;
/*     */   }
/*     */   
/*     */   public void setListarIss(String listarIss) {
/* 724 */     this.listarIss = listarIss;
/*     */   }
/*     */   
/*     */   public String getDiaVencimento() {
/* 728 */     return this.diaVencimento;
/*     */   }
/*     */   
/*     */   public void setDiaVencimento(String diaVencimento) {
/* 732 */     this.diaVencimento = diaVencimento;
/*     */   }
/*     */   
/*     */   public String getLimiteFaturamento() {
/* 736 */     return this.limiteFaturamento;
/*     */   }
/*     */   
/*     */   public void setLimiteFaturamento(String limiteFaturamento) {
/* 740 */     this.limiteFaturamento = limiteFaturamento;
/*     */   }
/*     */   
/*     */   public String getGrauRelacionamento() {
/* 744 */     return this.grauRelacionamento;
/*     */   }
/*     */   
/*     */   public void setGrauRelacionamento(String grauRelacionamento) {
/* 748 */     this.grauRelacionamento = grauRelacionamento;
/*     */   }
/*     */   
/*     */   public String getSufixoCnae() {
/* 752 */     return this.sufixoCnae;
/*     */   }
/*     */   
/*     */   public void setSufixoCnae(String sufixoCnae) {
/* 756 */     this.sufixoCnae = sufixoCnae;
/*     */   }
/*     */   
/*     */   public String getToleranciaVencimento() {
/* 760 */     return this.toleranciaVencimento;
/*     */   }
/*     */   
/*     */   public void setToleranciaVencimento(String toleranciaVencimento) {
/* 764 */     this.toleranciaVencimento = toleranciaVencimento;
/*     */   }
/*     */   
/*     */   public String getNivelCredito() {
/* 768 */     return this.nivelCredito;
/*     */   }
/*     */   
/*     */   public void setNivelCredito(String nivelCredito) {
/* 772 */     this.nivelCredito = nivelCredito;
/*     */   }
/*     */   
/*     */   public Boolean getListarDirf() {
/* 776 */     return this.listarDirf;
/*     */   }
/*     */   
/*     */   public void setListarDirf(Boolean listarDirf) {
/* 780 */     this.listarDirf = listarDirf;
/*     */   }
/*     */   
/*     */   public Boolean getConveniada() {
/* 784 */     return this.conveniada;
/*     */   }
/*     */   
/*     */   public void setConveniada(Boolean conveniada) {
/* 788 */     this.conveniada = conveniada;
/*     */   }
/*     */   
/*     */   public Boolean getCreditoLiberado() {
/* 792 */     return this.creditoLiberado;
/*     */   }
/*     */   
/*     */   public void setCreditoLiberado(Boolean creditoLiberado) {
/* 796 */     this.creditoLiberado = creditoLiberado;
/*     */   }
/*     */   
/*     */   public BigDecimal getPercentualFrete() {
/* 800 */     return this.percentualFrete;
/*     */   }
/*     */   
/*     */   public void setPercentualFrete(BigDecimal percentualFrete) {
/* 804 */     this.percentualFrete = percentualFrete;
/*     */   }
/*     */   
/*     */   public BigDecimal getCodigoEan() {
/* 808 */     return this.codigoEan;
/*     */   }
/*     */   
/*     */   public void setCodigoEan(BigDecimal codigoEan) {
/* 812 */     this.codigoEan = codigoEan;
/*     */   }
/*     */   
/*     */   public BigDecimal getPercentualAcrescimoLimite() {
/* 816 */     return this.percentualAcrescimoLimite;
/*     */   }
/*     */   
/*     */   public void setPercentualAcrescimoLimite(BigDecimal percentualAcrescimoLimite) {
/* 820 */     this.percentualAcrescimoLimite = percentualAcrescimoLimite;
/*     */   }
/*     */   
/*     */   public BigDecimal getPercentualAcrescimoPreco() {
/* 824 */     return this.percentualAcrescimoPreco;
/*     */   }
/*     */   
/*     */   public void setPercentualAcrescimoPreco(BigDecimal percentualAcrescimoPreco) {
/* 828 */     this.percentualAcrescimoPreco = percentualAcrescimoPreco;
/*     */   }
/*     */   
/*     */   public BigDecimal getUtilizaPrazoDiferenciado() {
/* 832 */     return this.utilizaPrazoDiferenciado;
/*     */   }
/*     */   
/*     */   public void setUtilizaPrazoDiferenciado(BigDecimal utilizaPrazoDiferenciado) {
/* 836 */     this.utilizaPrazoDiferenciado = utilizaPrazoDiferenciado;
/*     */   }
/*     */   
/*     */   public BigDecimal getTgPadraoNfs() {
/* 840 */     return this.tgPadraoNfs;
/*     */   }
/*     */   
/*     */   public void setTgPadraoNfs(BigDecimal tgPadraoNfs) {
/* 844 */     this.tgPadraoNfs = tgPadraoNfs;
/*     */   }
/*     */   
/*     */   public BigDecimal getLimiteCreditoMensal() {
/* 848 */     return this.limiteCreditoMensal;
/*     */   }
/*     */   
/*     */   public void setLimiteCreditoMensal(BigDecimal limiteCreditoMensal) {
/* 852 */     this.limiteCreditoMensal = limiteCreditoMensal;
/*     */   }
/*     */   
/*     */   public BigDecimal getOptanteSimples() {
/* 856 */     return this.optanteSimples;
/*     */   }
/*     */   
/*     */   public void setOptanteSimples(BigDecimal optanteSimples) {
/* 860 */     this.optanteSimples = optanteSimples;
/*     */   }
/*     */   
/*     */   public String getUsrempr1() {
/* 864 */     return this.Usrempr1;
/*     */   }
/*     */   
/*     */   public void setUsrempr1(String Usrempr1) {
/* 868 */     this.Usrempr1 = Usrempr1;
/*     */   }
/*     */   
/*     */   public String getUsrempr2() {
/* 872 */     return this.Usrempr2;
/*     */   }
/*     */   
/*     */   public void setUsrempr2(String Usrempr2) {
/* 876 */     this.Usrempr2 = Usrempr2;
/*     */   }
/*     */   
/*     */   public String getCnaeServico() {
/* 880 */     return this.cnaeServico;
/*     */   }
/*     */   
/*     */   public void setCnaeServico(String cnaeServico) {
/* 884 */     this.cnaeServico = cnaeServico;
/*     */   }
/*     */   
/*     */   public String getUsrempr4() {
/* 888 */     return this.Usrempr4;
/*     */   }
/*     */   
/*     */   public void setUsrempr4(String Usrempr4) {
/* 892 */     this.Usrempr4 = Usrempr4;
/*     */   }
/*     */   
/*     */   public BigDecimal getValorFrete() {
/* 896 */     return this.valorFrete;
/*     */   }
/*     */   
/*     */   public void setValorFrete(BigDecimal valorFrete) {
/* 900 */     this.valorFrete = valorFrete;
/*     */   }
/*     */   
/*     */   public String getPin() {
/* 904 */     return this.pin;
/*     */   }
/*     */   
/*     */   public void setPin(String pin) {
/* 908 */     this.pin = pin;
/*     */   }
/*     */   
/*     */   public String getStatusRegistro() {
/* 912 */     return this.statusRegistro;
/*     */   }
/*     */   
/*     */   public void setStatusRegistro(String statusRegistro) {
/* 916 */     this.statusRegistro = statusRegistro;
/*     */   }
/*     */ }


/* Location:              /Users/diogo.lima/Documents/PEDIDO.jar!/Integracao_CIGAM_Empresa/CIGAMEmpresa.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */