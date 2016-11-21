var btnIncluir,btnVisualizar,btnAlterar,btnExcluir, btnSair,linha,tabela;
var btnSenha,selected=0,id=0,coluna, celula;
var cod=0;

function iniciar(){
	
	btnIncluir = document.querySelector("#incluir");
	btnVisualizar = document.querySelector("#visualizar");
	btnAlterar = document.querySelector("#alterar");
	btnExcluir = document.querySelector("#excluir");
        btnSenha = document.querySelector("#senha");
        btnSair = document.querySelector("#sair");
        	
	btnIncluir.addEventListener("click",incluir);
	btnVisualizar.addEventListener("click",visualizar);
	btnAlterar.addEventListener("click",alterar);
	btnExcluir.addEventListener("click",excluir);
        btnSenha.addEventListener("click",senha);
        btnSair.addEventListener("click",sair);
       
}

function incluir(){
    window.location.assign("usuarioAdicionar.jsp");
}

function alterar(){
    linha = document.getElementsByTagName('tr')[selected];
    coluna = linha.getElementsByTagName("td");
    celula = coluna[0].innerText;

    document.location.href = "/Farmacia/AlterarUsuario?id="+celula;
}

function visualizar(){
    linha = document.getElementsByTagName('tr')[selected];
    coluna = linha.getElementsByTagName("td");
    celula = coluna[0].innerText;
  
     document.location.href = "/Farmacia/VisualizarUsuario?id="+celula;
}

function senha(){
    linha = document.getElementsByTagName('tr')[selected];
    coluna = linha.getElementsByTagName("td");
    celula = coluna[0].innerText;
  
     document.location.href = "/Farmacia/AlterarSenhaUsuario?id="+celula;
}

function excluir(){  
    linha = document.getElementsByTagName('tr')[selected];
    coluna = linha.getElementsByTagName("td");
    celula = coluna[0].innerText;

     document.location.href = "/Farmacia/ExcluirUsuario?id="+celula;
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