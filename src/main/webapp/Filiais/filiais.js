var btnIncluir,btnVisualizar,btnAlterar,btnExcluir, btnSair,linha,tabela;
var selected=0,id=0,coluna, celula;
var cod=0;

//Funcao Iniciar
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

//Funcao Incuir
function incluir(){
    window.location.assign("filialCadastro.jsp");
}

//Funcao Alterar
function alterar(){
    linha = document.getElementsByTagName('tr')[selected];
    coluna = linha.getElementsByTagName("td");
    celula = coluna[0].innerText;

    document.location.href = "/Farmacia/AlterarFilial?id="+celula;
}

//Funcao Visualizar
function visualizar(){
    linha = document.getElementsByTagName('tr')[selected];
    coluna = linha.getElementsByTagName("td");
    celula = coluna[0].innerText;
  
     document.location.href = "/Farmacia/VisualizarFilial?id="+celula;
}

//Funcao Excluir
function excluir(){  
    linha = document.getElementsByTagName('tr')[selected];
    coluna = linha.getElementsByTagName("td");
    celula = coluna[0].innerText;
    document.location.href = "/Farmacia/ExcluirFilial?id="+celula;
}

//Funcao Sair
function sair(){
    window.location.assign("../menu.jsp");
}

//Funcao Selecionar
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