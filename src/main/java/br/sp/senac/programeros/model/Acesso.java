package br.sp.senac.programeros.model;

/**
 *
 * @author willian.carvalho
 */

public class Acesso{
    //Atributos
    private Long chave;
    private Boolean almoxarifados;
    private Boolean vendas;
    private Boolean compras;
    private Boolean transferencias;
    private Boolean clientes;
    private Boolean fornecedores;
    private Boolean filiais;
    private Boolean produtos;
    private Boolean vendedores;
    private Boolean usuarios;
    private Boolean categorias;
    private Boolean acessos;
    private Boolean notasentrada;
    private Boolean notassaida;
    private Boolean contasreceber;
    private Boolean contaspagar;
    private Boolean usuariosIncluir;
    private Boolean usuariosExcluir;
    private Boolean usuariosAlterar;
    private Boolean acessosIncluir;
    private Boolean acessosExcluir;
    private Boolean acessosAlterar;
    private Boolean categoriasIncluir;
    private Boolean categoriasExcluir;
    private Boolean categoriasAlterar;
    private Boolean almoxarifadosIncluir;
    private Boolean almoxarifadosExcluir;
    private Boolean almoxarifadosAlterar;
    private Boolean filiaisIncluir;
    private Boolean filiaisExcluir;
    private Boolean filiaisAlterar;
    private Boolean fornecedoresIncluir;
    private Boolean fornecedoresExcluir;
    private Boolean fornecedoresAlterar;
    private Boolean produtosIncluir;
    private Boolean produtosExcluir;
    private Boolean produtosAlterar;
    private Boolean transferenciasIncluir;
    private Boolean transferenciasExcluir;
    private Boolean comprasIncluir;
    private Boolean comprasExcluir;
    private Boolean comprasAlterar;
    private Boolean clientesIncluir;
    private Boolean clientesExcluir;
    private Boolean clientesAlterar;
    private Boolean vendedoresIncluir;
    private Boolean vendedoresExcluir;
    private Boolean vendedoresAlterar;
    private Boolean nfeIncluir;
    private Boolean nfeExcluir;
    private Boolean nfeAlterar;
    private Boolean nfsIncluir;
    private Boolean nfsExcluir;
    private Boolean nfsAlterar;
    private Boolean crIncluir;
    private Boolean crExcluir;
    private Boolean crAlterar;
    private Boolean cpIncluir;
    private Boolean cpExcluir;
    private Boolean cpAlterar;
    //Construtor
    public Acesso() {
    }
    //Construtor
    public Acesso(Long chave) {
        this.chave = chave;
    }
    //Metodo - GET 
    public Long getChave() {
        return chave;
    }
    //Metodo - SET
    public void setChave(Long chave) {
        this.chave = chave;
    }
    //Metodo - GET
    public Boolean getAlmoxarifados() {
        return almoxarifados;
    }
    //Metodo - SET
    public void setAlmoxarifados(Boolean almoxarifados) {
        this.almoxarifados = almoxarifados;
    }
    //Metodo - GET
    public Boolean getVendas() {
        return vendas;
    }
    //Metodo - SET
    public void setVendas(Boolean vendas) {
        this.vendas = vendas;
    }
    //Metodo - GET
    public Boolean getCompras() {
        return compras;
    }
    //Metodo - SET
    public void setCompras(Boolean compras) {
        this.compras = compras;
    }
    //Metodo - GET
    public Boolean getTransferencias() {
        return transferencias;
    }
    //Metodo - SET
    public void setTransferencias(Boolean transferencias) {
        this.transferencias = transferencias;
    }
    //Metodo - GET
    public Boolean getClientes() {
        return clientes;
    }
    //Metodo - SET
    public void setClientes(Boolean clientes) {
        this.clientes = clientes;
    }
    //Metodo - GET
    public Boolean getFornecedores() {
        return fornecedores;
    }
    //Metodo - SET
    public void setFornecedores(Boolean fornecedores) {
        this.fornecedores = fornecedores;
    }
    //Metodo - GET
    public Boolean getFiliais() {
        return filiais;
    }
    //Metodo - SET
    public void setFiliais(Boolean filiais) {
        this.filiais = filiais;
    }
    //Metodo - GET
    public Boolean getProdutos() {
        return produtos;
    }
    //Metodo - SET
    public void setProdutos(Boolean produtos) {
        this.produtos = produtos;
    }
    //Metodo - GET
    public Boolean getVendedores() {
        return vendedores;
    }
    //Metodo - SET
    public void setVendedores(Boolean vendedores) {
        this.vendedores = vendedores;
    }
    //Metodo - GET
    public Boolean getUsuarios() {
        return usuarios;
    }
    //Metodo - SET
    public void setUsuarios(Boolean usuarios) {
        this.usuarios = usuarios;
    }
    //Metodo - GET
    public Boolean getCategorias() {
        return categorias;
    }
    //Metodo - SET
    public void setCategorias(Boolean categorias) {
        this.categorias = categorias;
    }
    //Metodo - GET
    public Boolean getAcessos() {
        return acessos;
    }
    //Metodo - SET
    public void setAcessos(Boolean acessos) {
        this.acessos = acessos;
    }
    //Metodo - GET
    public Boolean getNotasentrada() {
        return notasentrada;
    }
    //Metodo - SET
    public void setNotasentrada(Boolean notasentrada) {
        this.notasentrada = notasentrada;
    }
    //Metodo - GET
    public Boolean getNotassaida() {
        return notassaida;
    }
    //Metodo - SET
    public void setNotassaida(Boolean notassaida) {
        this.notassaida = notassaida;
    }
    //Metodo - GET
    public Boolean getContasreceber() {
        return contasreceber;
    }
    //Metodo - SET
    public void setContasreceber(Boolean contasreceber) {
        this.contasreceber = contasreceber;
    }
    //Metodo - GET
    public Boolean getContaspagar() {
        return contaspagar;
    }
    //Metodo - SET
    public void setContaspagar(Boolean contaspagar) {
        this.contaspagar = contaspagar;
    }
    //Metodo - GET
    public Boolean getUsuariosIncluir() {
        return usuariosIncluir;
    }
    //Metodo - SET
    public void setUsuariosIncluir(Boolean usuariosIncluir) {
        this.usuariosIncluir = usuariosIncluir;
    }
    //Metodo - GET
    public Boolean getUsuariosExcluir() {
        return usuariosExcluir;
    }
    //Metodo - SET
    public void setUsuariosExcluir(Boolean usuariosExcluir) {
        this.usuariosExcluir = usuariosExcluir;
    }
    //Metodo - GET
    public Boolean getUsuariosAlterar() {
        return usuariosAlterar;
    }
    //Metodo - SET
    public void setUsuariosAlterar(Boolean usuariosAlterar) {
        this.usuariosAlterar = usuariosAlterar;
    }
    //Metodo - GET
    public Boolean getAcessosIncluir() {
        return acessosIncluir;
    }
    //Metodo - SET
    public void setAcessosIncluir(Boolean acessosIncluir) {
        this.acessosIncluir = acessosIncluir;
    }
    //Metodo - GET
    public Boolean getAcessosExcluir() {
        return acessosExcluir;
    }
    //Metodo - SET
    public void setAcessosExcluir(Boolean acessosExcluir) {
        this.acessosExcluir = acessosExcluir;
    }
    //Metodo - GET
    public Boolean getAcessosAlterar() {
        return acessosAlterar;
    }
    //Metodo - SET
    public void setAcessosAlterar(Boolean acessosAlterar) {
        this.acessosAlterar = acessosAlterar;
    }
    //Metodo - GET
    public Boolean getCategoriasIncluir() {
        return categoriasIncluir;
    }
    //Metodo - SET
    public void setCategoriasIncluir(Boolean categoriasIncluir) {
        this.categoriasIncluir = categoriasIncluir;
    }
    //Metodo - GET
    public Boolean getCategoriasExcluir() {
        return categoriasExcluir;
    }
    //Metodo - SET
    public void setCategoriasExcluir(Boolean categoriasExcluir) {
        this.categoriasExcluir = categoriasExcluir;
    }
    //Metodo - GET
    public Boolean getCategoriasAlterar() {
        return categoriasAlterar;
    }
    //Metodo - SET
    public void setCategoriasAlterar(Boolean categoriasAlterar) {
        this.categoriasAlterar = categoriasAlterar;
    }
    //Metodo - GET
    public Boolean getAlmoxarifadosIncluir() {
        return almoxarifadosIncluir;
    }
    //Metodo - SET
    public void setAlmoxarifadosIncluir(Boolean almoxarifadosIncluir) {
        this.almoxarifadosIncluir = almoxarifadosIncluir;
    }
    //Metodo - GET
    public Boolean getAlmoxarifadosExcluir() {
        return almoxarifadosExcluir;
    }
    //Metodo - SET
    public void setAlmoxarifadosExcluir(Boolean almoxarifadosExcluir) {
        this.almoxarifadosExcluir = almoxarifadosExcluir;
    }
    //Metodo - GET
    public Boolean getAlmoxarifadosAlterar() {
        return almoxarifadosAlterar;
    }
    //Metodo - SET
    public void setAlmoxarifadosAlterar(Boolean almoxarifadosAlterar) {
        this.almoxarifadosAlterar = almoxarifadosAlterar;
    }
    //Metodo - GET
    public Boolean getFiliaisIncluir() {
        return filiaisIncluir;
    }
    //Metodo - SET
    public void setFiliaisIncluir(Boolean filiaisIncluir) {
        this.filiaisIncluir = filiaisIncluir;
    }
    //Metodo - GET
    public Boolean getFiliaisExcluir() {
        return filiaisExcluir;
    }
    //Metodo - SET
    public void setFiliaisExcluir(Boolean filiaisExcluir) {
        this.filiaisExcluir = filiaisExcluir;
    }
    //Metodo - GET
    public Boolean getFiliaisAlterar() {
        return filiaisAlterar;
    }
    //Metodo - SET
    public void setFiliaisAlterar(Boolean filiaisAlterar) {
        this.filiaisAlterar = filiaisAlterar;
    }
    //Metodo - GET
    public Boolean getFornecedoresIncluir() {
        return fornecedoresIncluir;
    }
    //Metodo - SET
    public void setFornecedoresIncluir(Boolean fornecedoresIncluir) {
        this.fornecedoresIncluir = fornecedoresIncluir;
    }
    //Metodo - GET
    public Boolean getFornecedoresExcluir() {
        return fornecedoresExcluir;
    }
    //Metodo - SET
    public void setFornecedoresExcluir(Boolean fornecedoresExcluir) {
        this.fornecedoresExcluir = fornecedoresExcluir;
    }
    //Metodo - GET
    public Boolean getFornecedoresAlterar() {
        return fornecedoresAlterar;
    }
    //Metodo - SET
    public void setFornecedoresAlterar(Boolean fornecedoresAlterar) {
        this.fornecedoresAlterar = fornecedoresAlterar;
    }
    //Metodo - GET
    public Boolean getProdutosIncluir() {
        return produtosIncluir;
    }
    //Metodo - SET
    public void setProdutosIncluir(Boolean produtosIncluir) {
        this.produtosIncluir = produtosIncluir;
    }
    //Metodo - GET
    public Boolean getProdutosExcluir() {
        return produtosExcluir;
    }
    //Metodo - SET
    public void setProdutosExcluir(Boolean produtosExcluir) {
        this.produtosExcluir = produtosExcluir;
    }
    //Metodo - GET
    public Boolean getProdutosAlterar() {
        return produtosAlterar;
    }
    //Metodo - SET
    public void setProdutosAlterar(Boolean produtosAlterar) {
        this.produtosAlterar = produtosAlterar;
    }
    //Metodo - GET
    public Boolean getTransferenciasIncluir() {
        return transferenciasIncluir;
    }
    //Metodo - SET
    public void setTransferenciasIncluir(Boolean transferenciasIncluir) {
        this.transferenciasIncluir = transferenciasIncluir;
    }
    //Metodo - GET
    public Boolean getTransferenciasExcluir() {
        return transferenciasExcluir;
    }
    //Metodo - SET
    public void setTransferenciasExcluir(Boolean transferenciasExcluir) {
        this.transferenciasExcluir = transferenciasExcluir;
    }   
    //Metodo - GET
    public Boolean getComprasIncluir() {
        return comprasIncluir;
    }
    //Metodo - SET
    public void setComprasIncluir(Boolean comprasIncluir) {
        this.comprasIncluir = comprasIncluir;
    }
    //Metodo - GET
    public Boolean getComprasExcluir() {
        return comprasExcluir;
    }
    //Metodo - SET
    public void setComprasExcluir(Boolean comprasExcluir) {
        this.comprasExcluir = comprasExcluir;
    }
    //Metodo - GET
    public Boolean getComprasAlterar() {
        return comprasAlterar;
    }
    //Metodo - SET
    public void setComprasAlterar(Boolean comprasAlterar) {
        this.comprasAlterar = comprasAlterar;
    }
    //Metodo - GET
    public Boolean getClientesIncluir() {
        return clientesIncluir;
    }
    //Metodo - SET
    public void setClientesIncluir(Boolean clientesIncluir) {
        this.clientesIncluir = clientesIncluir;
    }
    //Metodo - GET
    public Boolean getClientesExcluir() {
        return clientesExcluir;
    }
    //Metodo - SET
    public void setClientesExcluir(Boolean clientesExcluir) {
        this.clientesExcluir = clientesExcluir;
    }
    //Metodo - GET
    public Boolean getClientesAlterar() {
        return clientesAlterar;
    }
    //Metodo - SET
    public void setClientesAlterar(Boolean clientesAlterar) {
        this.clientesAlterar = clientesAlterar;
    }
    //Metodo - GET
    public Boolean getVendedoresIncluir() {
        return vendedoresIncluir;
    }
    //Metodo - SET
    public void setVendedoresIncluir(Boolean vendedoresIncluir) {
        this.vendedoresIncluir = vendedoresIncluir;
    }
    //Metodo - GET
    public Boolean getVendedoresExcluir() {
        return vendedoresExcluir;
    }
    //Metodo - SET
    public void setVendedoresExcluir(Boolean vendedoresExcluir) {
        this.vendedoresExcluir = vendedoresExcluir;
    }
    //Metodo - GET
    public Boolean getVendedoresAlterar() {
        return vendedoresAlterar;
    }
    //Metodo - SET
    public void setVendedoresAlterar(Boolean vendedoresAlterar) {
        this.vendedoresAlterar = vendedoresAlterar;
    }
    //Metodo - GET
    public Boolean getNfeIncluir() {
        return nfeIncluir;
    }
    //Metodo - SET
    public void setNfeIncluir(Boolean nfeIncluir) {
        this.nfeIncluir = nfeIncluir;
    }
    //Metodo - GET
    public Boolean getNfeExcluir() {
        return nfeExcluir;
    }
    //Metodo - SET
    public void setNfeExcluir(Boolean nfeExcluir) {
        this.nfeExcluir = nfeExcluir;
    }
    //Metodo - GET
    public Boolean getNfeAlterar() {
        return nfeAlterar;
    }
    //Metodo - SET
    public void setNfeAlterar(Boolean nfeAlterar) {
        this.nfeAlterar = nfeAlterar;
    }
    //Metodo - GET
    public Boolean getNfsIncluir() {
        return nfsIncluir;
    }
    //Metodo - SET
    public void setNfsIncluir(Boolean nfsIncluir) {
        this.nfsIncluir = nfsIncluir;
    }
    //Metodo - GET
    public Boolean getNfsExcluir() {
        return nfsExcluir;
    }
    //Metodo - SE
    public void setNfsExcluir(Boolean nfsExcluir) {
        this.nfsExcluir = nfsExcluir;
    }
    //Metodo - GET
    public Boolean getNfsAlterar() {
        return nfsAlterar;
    }
    //Metodo - SET
    public void setNfsAlterar(Boolean nfsAlterar) {
        this.nfsAlterar = nfsAlterar;
    }
    //Metodo - GET
    public Boolean getCrIncluir() {
        return crIncluir;
    }
    //Metodo - SET
    public void setCrIncluir(Boolean crIncluir) {
        this.crIncluir = crIncluir;
    }
    //Metodo - GET
    public Boolean getCrExcluir() {
        return crExcluir;
    }
    //Metodo - SET
    public void setCrExcluir(Boolean crExcluir) {
        this.crExcluir = crExcluir;
    }
    //Metodo - GET
    public Boolean getCrAlterar() {
        return crAlterar;
    }
    //Metodo - SET
    public void setCrAlterar(Boolean crAlterar) {
        this.crAlterar = crAlterar;
    }
    //Metodo - GET
    public Boolean getCpIncluir() {
        return cpIncluir;
    }
    //Metodo - SET
    public void setCpIncluir(Boolean cpIncluir) {
        this.cpIncluir = cpIncluir;
    }
    //Metodo - GET
    public Boolean getCpExcluir() {
        return cpExcluir;
    }
    //Metodo - SET
    public void setCpExcluir(Boolean cpExcluir) {
        this.cpExcluir = cpExcluir;
    }
    //Metodo - GET
    public Boolean getCpAlterar() {
        return cpAlterar;
    }
    //Metodo - SET
    public void setCpAlterar(Boolean cpAlterar) {
        this.cpAlterar = cpAlterar;
    }


    @Override
    public String toString() {
        return "chave=" + chave + " ]";
    }
    
}
