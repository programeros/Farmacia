package br.sp.senac.programeros.model;

/**
 *
 * @author willian.carvalho
 */

public class Acesso{

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

    public Acesso() {
    }

    public Acesso(Long chave) {
        this.chave = chave;
    }

    public Long getChave() {
        return chave;
    }

    public void setChave(Long chave) {
        this.chave = chave;
    }

    public Boolean getAlmoxarifados() {
        return almoxarifados;
    }

    public void setAlmoxarifados(Boolean almoxarifados) {
        this.almoxarifados = almoxarifados;
    }

    public Boolean getVendas() {
        return vendas;
    }

    public void setVendas(Boolean vendas) {
        this.vendas = vendas;
    }

    public Boolean getCompras() {
        return compras;
    }

    public void setCompras(Boolean compras) {
        this.compras = compras;
    }

    public Boolean getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(Boolean transferencias) {
        this.transferencias = transferencias;
    }

    public Boolean getClientes() {
        return clientes;
    }

    public void setClientes(Boolean clientes) {
        this.clientes = clientes;
    }

    public Boolean getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Boolean fornecedores) {
        this.fornecedores = fornecedores;
    }

    public Boolean getFiliais() {
        return filiais;
    }

    public void setFiliais(Boolean filiais) {
        this.filiais = filiais;
    }

    public Boolean getProdutos() {
        return produtos;
    }

    public void setProdutos(Boolean produtos) {
        this.produtos = produtos;
    }

    public Boolean getVendedores() {
        return vendedores;
    }

    public void setVendedores(Boolean vendedores) {
        this.vendedores = vendedores;
    }

    public Boolean getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Boolean usuarios) {
        this.usuarios = usuarios;
    }

    public Boolean getCategorias() {
        return categorias;
    }

    public void setCategorias(Boolean categorias) {
        this.categorias = categorias;
    }

    public Boolean getAcessos() {
        return acessos;
    }

    public void setAcessos(Boolean acessos) {
        this.acessos = acessos;
    }

    public Boolean getNotasentrada() {
        return notasentrada;
    }

    public void setNotasentrada(Boolean notasentrada) {
        this.notasentrada = notasentrada;
    }

    public Boolean getNotassaida() {
        return notassaida;
    }

    public void setNotassaida(Boolean notassaida) {
        this.notassaida = notassaida;
    }

    public Boolean getContasreceber() {
        return contasreceber;
    }

    public void setContasreceber(Boolean contasreceber) {
        this.contasreceber = contasreceber;
    }

    public Boolean getContaspagar() {
        return contaspagar;
    }

    public void setContaspagar(Boolean contaspagar) {
        this.contaspagar = contaspagar;
    }

    public Boolean getUsuariosIncluir() {
        return usuariosIncluir;
    }

    public void setUsuariosIncluir(Boolean usuariosIncluir) {
        this.usuariosIncluir = usuariosIncluir;
    }

    public Boolean getUsuariosExcluir() {
        return usuariosExcluir;
    }

    public void setUsuariosExcluir(Boolean usuariosExcluir) {
        this.usuariosExcluir = usuariosExcluir;
    }

    public Boolean getUsuariosAlterar() {
        return usuariosAlterar;
    }

    public void setUsuariosAlterar(Boolean usuariosAlterar) {
        this.usuariosAlterar = usuariosAlterar;
    }

    public Boolean getAcessosIncluir() {
        return acessosIncluir;
    }

    public void setAcessosIncluir(Boolean acessosIncluir) {
        this.acessosIncluir = acessosIncluir;
    }

    public Boolean getAcessosExcluir() {
        return acessosExcluir;
    }

    public void setAcessosExcluir(Boolean acessosExcluir) {
        this.acessosExcluir = acessosExcluir;
    }

    public Boolean getAcessosAlterar() {
        return acessosAlterar;
    }

    public void setAcessosAlterar(Boolean acessosAlterar) {
        this.acessosAlterar = acessosAlterar;
    }

    public Boolean getCategoriasIncluir() {
        return categoriasIncluir;
    }

    public void setCategoriasIncluir(Boolean categoriasIncluir) {
        this.categoriasIncluir = categoriasIncluir;
    }

    public Boolean getCategoriasExcluir() {
        return categoriasExcluir;
    }

    public void setCategoriasExcluir(Boolean categoriasExcluir) {
        this.categoriasExcluir = categoriasExcluir;
    }

    public Boolean getCategoriasAlterar() {
        return categoriasAlterar;
    }

    public void setCategoriasAlterar(Boolean categoriasAlterar) {
        this.categoriasAlterar = categoriasAlterar;
    }

    public Boolean getAlmoxarifadosIncluir() {
        return almoxarifadosIncluir;
    }

    public void setAlmoxarifadosIncluir(Boolean almoxarifadosIncluir) {
        this.almoxarifadosIncluir = almoxarifadosIncluir;
    }

    public Boolean getAlmoxarifadosExcluir() {
        return almoxarifadosExcluir;
    }

    public void setAlmoxarifadosExcluir(Boolean almoxarifadosExcluir) {
        this.almoxarifadosExcluir = almoxarifadosExcluir;
    }

    public Boolean getAlmoxarifadosAlterar() {
        return almoxarifadosAlterar;
    }

    public void setAlmoxarifadosAlterar(Boolean almoxarifadosAlterar) {
        this.almoxarifadosAlterar = almoxarifadosAlterar;
    }

    public Boolean getFiliaisIncluir() {
        return filiaisIncluir;
    }

    public void setFiliaisIncluir(Boolean filiaisIncluir) {
        this.filiaisIncluir = filiaisIncluir;
    }

    public Boolean getFiliaisExcluir() {
        return filiaisExcluir;
    }

    public void setFiliaisExcluir(Boolean filiaisExcluir) {
        this.filiaisExcluir = filiaisExcluir;
    }

    public Boolean getFiliaisAlterar() {
        return filiaisAlterar;
    }

    public void setFiliaisAlterar(Boolean filiaisAlterar) {
        this.filiaisAlterar = filiaisAlterar;
    }

    public Boolean getFornecedoresIncluir() {
        return fornecedoresIncluir;
    }

    public void setFornecedoresIncluir(Boolean fornecedoresIncluir) {
        this.fornecedoresIncluir = fornecedoresIncluir;
    }

    public Boolean getFornecedoresExcluir() {
        return fornecedoresExcluir;
    }

    public void setFornecedoresExcluir(Boolean fornecedoresExcluir) {
        this.fornecedoresExcluir = fornecedoresExcluir;
    }

    public Boolean getFornecedoresAlterar() {
        return fornecedoresAlterar;
    }

    public void setFornecedoresAlterar(Boolean fornecedoresAlterar) {
        this.fornecedoresAlterar = fornecedoresAlterar;
    }

    public Boolean getProdutosIncluir() {
        return produtosIncluir;
    }

    public void setProdutosIncluir(Boolean produtosIncluir) {
        this.produtosIncluir = produtosIncluir;
    }

    public Boolean getProdutosExcluir() {
        return produtosExcluir;
    }

    public void setProdutosExcluir(Boolean produtosExcluir) {
        this.produtosExcluir = produtosExcluir;
    }

    public Boolean getProdutosAlterar() {
        return produtosAlterar;
    }

    public void setProdutosAlterar(Boolean produtosAlterar) {
        this.produtosAlterar = produtosAlterar;
    }

    public Boolean getTransferenciasIncluir() {
        return transferenciasIncluir;
    }

    public void setTransferenciasIncluir(Boolean transferenciasIncluir) {
        this.transferenciasIncluir = transferenciasIncluir;
    }

    public Boolean getTransferenciasExcluir() {
        return transferenciasExcluir;
    }

    public void setTransferenciasExcluir(Boolean transferenciasExcluir) {
        this.transferenciasExcluir = transferenciasExcluir;
    }

    public Boolean getComprasIncluir() {
        return comprasIncluir;
    }

    public void setComprasIncluir(Boolean comprasIncluir) {
        this.comprasIncluir = comprasIncluir;
    }

    public Boolean getComprasExcluir() {
        return comprasExcluir;
    }

    public void setComprasExcluir(Boolean comprasExcluir) {
        this.comprasExcluir = comprasExcluir;
    }

    public Boolean getComprasAlterar() {
        return comprasAlterar;
    }

    public void setComprasAlterar(Boolean comprasAlterar) {
        this.comprasAlterar = comprasAlterar;
    }

    public Boolean getClientesIncluir() {
        return clientesIncluir;
    }

    public void setClientesIncluir(Boolean clientesIncluir) {
        this.clientesIncluir = clientesIncluir;
    }

    public Boolean getClientesExcluir() {
        return clientesExcluir;
    }

    public void setClientesExcluir(Boolean clientesExcluir) {
        this.clientesExcluir = clientesExcluir;
    }

    public Boolean getClientesAlterar() {
        return clientesAlterar;
    }

    public void setClientesAlterar(Boolean clientesAlterar) {
        this.clientesAlterar = clientesAlterar;
    }

    public Boolean getVendedoresIncluir() {
        return vendedoresIncluir;
    }

    public void setVendedoresIncluir(Boolean vendedoresIncluir) {
        this.vendedoresIncluir = vendedoresIncluir;
    }

    public Boolean getVendedoresExcluir() {
        return vendedoresExcluir;
    }

    public void setVendedoresExcluir(Boolean vendedoresExcluir) {
        this.vendedoresExcluir = vendedoresExcluir;
    }

    public Boolean getVendedoresAlterar() {
        return vendedoresAlterar;
    }

    public void setVendedoresAlterar(Boolean vendedoresAlterar) {
        this.vendedoresAlterar = vendedoresAlterar;
    }

    public Boolean getNfeIncluir() {
        return nfeIncluir;
    }

    public void setNfeIncluir(Boolean nfeIncluir) {
        this.nfeIncluir = nfeIncluir;
    }

    public Boolean getNfeExcluir() {
        return nfeExcluir;
    }

    public void setNfeExcluir(Boolean nfeExcluir) {
        this.nfeExcluir = nfeExcluir;
    }

    public Boolean getNfeAlterar() {
        return nfeAlterar;
    }

    public void setNfeAlterar(Boolean nfeAlterar) {
        this.nfeAlterar = nfeAlterar;
    }

    public Boolean getNfsIncluir() {
        return nfsIncluir;
    }

    public void setNfsIncluir(Boolean nfsIncluir) {
        this.nfsIncluir = nfsIncluir;
    }

    public Boolean getNfsExcluir() {
        return nfsExcluir;
    }

    public void setNfsExcluir(Boolean nfsExcluir) {
        this.nfsExcluir = nfsExcluir;
    }

    public Boolean getNfsAlterar() {
        return nfsAlterar;
    }

    public void setNfsAlterar(Boolean nfsAlterar) {
        this.nfsAlterar = nfsAlterar;
    }

    public Boolean getCrIncluir() {
        return crIncluir;
    }

    public void setCrIncluir(Boolean crIncluir) {
        this.crIncluir = crIncluir;
    }

    public Boolean getCrExcluir() {
        return crExcluir;
    }

    public void setCrExcluir(Boolean crExcluir) {
        this.crExcluir = crExcluir;
    }

    public Boolean getCrAlterar() {
        return crAlterar;
    }

    public void setCrAlterar(Boolean crAlterar) {
        this.crAlterar = crAlterar;
    }

    public Boolean getCpIncluir() {
        return cpIncluir;
    }

    public void setCpIncluir(Boolean cpIncluir) {
        this.cpIncluir = cpIncluir;
    }

    public Boolean getCpExcluir() {
        return cpExcluir;
    }

    public void setCpExcluir(Boolean cpExcluir) {
        this.cpExcluir = cpExcluir;
    }

    public Boolean getCpAlterar() {
        return cpAlterar;
    }

    public void setCpAlterar(Boolean cpAlterar) {
        this.cpAlterar = cpAlterar;
    }


    @Override
    public String toString() {
        return "chave=" + chave + " ]";
    }
    
}
