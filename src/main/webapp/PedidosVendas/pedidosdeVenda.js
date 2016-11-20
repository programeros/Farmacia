var btnIncluir,btnVisualizar,btnAlterar,btnExcluir;

function iniciar(){
	
	btnIncluir = document.querySelector("#incluir");
	btnVisualizar = document.querySelector("#visualizar");
	btnAlterar = document.querySelector("#alterar");
	btnExcluir = document.querySelector("#excluir");
	
	btnIncluir.addEventListener("click",adicionar);
	btnVisualizar.addEventListener("click",visualizar);
	btnAlterar.addEventListener("click",alterar);
	btnExcluir.addEventListener("click",excluir);
	
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

window.addEventListener("load",iniciar);