var btnIncluir,btnVisualizar,btnAlterar,btnExcluir, btnSair, linha;

function iniciar(){
	
	btnIncluir = document.querySelector("#incluir");
	btnVisualizar = document.querySelector("#visualizar");
	btnAlterar = document.querySelector("#alterar");
	btnExcluir = document.querySelector("#excluir");
        btnSair = document.querySelector("#sair");
        linha = document.querySelector("tr");
	
	btnIncluir.addEventListener("click",adicionar);
	btnVisualizar.addEventListener("click",visualizar);
	btnAlterar.addEventListener("click",alterar);
	btnExcluir.addEventListener("click",excluir);
        btnSair.addEventListener("click",sair);
        linha.addEventListener("click",teste);
	
}

function adicionar(){
	alert("Clicou no Incluir");
}

function alterar(){
	alert("Clicou no alterar");
}

function visualizar(){
	alert("Clicou no visualizar");
}

function excluir(){
	alert("Clicou no excluir");
}

function sair(){
    window.location.assign("../menu.jsp");
}

function teste(){
	alert("Clicou na linha");
}

window.addEventListener("load",iniciar);