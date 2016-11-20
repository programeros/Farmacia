var btnIncluir,btnVisualizar,btnAlterar,btnExcluir, btnSair;

function iniciar(){
	
	btnIncluir = document.querySelector("#incluir");
	btnVisualizar = document.querySelector("#visualizar");
	btnAlterar = document.querySelector("#alterar");
	btnExcluir = document.querySelector("#excluir");
        btnSair = document.querySelector("#sair");
	
	btnIncluir.addEventListener("click",adicionar);
	btnVisualizar.addEventListener("click",visualizar);
	btnAlterar.addEventListener("click",alterar);
	btnExcluir.addEventListener("click",excluir);
        btnSair.addEventListener("click",sair);
	
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

window.addEventListener("load",iniciar);