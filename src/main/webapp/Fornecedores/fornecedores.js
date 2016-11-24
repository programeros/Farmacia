var btnIncluir,btnVisualizar,btnAlterar,btnExcluir, btnSair,linha,tabela;
var selected=0,id=0,coluna, celula;
var cod=0;

function iniciar(){
	
	btnIncluir = document.querySelector("#incluir");
	btnVisualizar = document.querySelector("#visualizar");
	btnAlterar = document.querySelector("#alterar");
	btnExcluir = document.querySelector("#excluir");
        btnSair = document.querySelector("#sair");
        	
	btnIncluir.addEventListener("click",incluir);
	btnVisualizar.addEventListener("click",visualizar);
	btnAlterar.addEventListener("click",alterar);
	btnExcluir.addEventListener("click",excluir);
        btnSair.addEventListener("click",sair);
       
}

function incluir(){
    window.location.assign("cadastroFornecedor.jsp");
}

function alterar(){
    linha = document.getElementsByTagName('tr')[selected];
    coluna = linha.getElementsByTagName("td");
    celula = coluna[0].innerText;

    document.location.href = "/Farmacia/AlterarFornecedor?id="+celula;
}
//ARRUMAR!!!
function visualizar(){
    linha = document.getElementsByTagName('tr')[selected];
    coluna = linha.getElementsByTagName("td");
    celula = coluna[0].innerText;
  
     document.location.href = "/Farmacia/VisualizarFornecedor?id="+celula;
}

function excluir(){  
    linha = document.getElementsByTagName('tr')[selected];
    coluna = linha.getElementsByTagName("td");
    celula = coluna[0].innerText;
    document.location.href = "/Farmacia/ExcluirFornecedor?id="+celula;
}

function sair(){
    window.location.assign("../menu.jsp");
}

function selecionar(x){
    id = x.rowIndex;
    if (id !== selected){
        linha = document.getElementsByTagName('tr')[selected];
        linha.removeAttribute("class","cor");           
    }
    
    linha = document.getElementsByTagName('tr')[x.rowIndex];
    linha.setAttribute("class","cor");
    selected = x.rowIndex;        
}

window.addEventListener("load",iniciar);