var grid;

function iniciar(){
		grid = new jsGrid("divJGrid",740,400);
		grid.setTextMatrix(0,0,"Produto");

		grid.rows.add();

		grid.rows.addCol("300px");
		grid.rows.addCol("100px");
		grid.rows.addCol("100px");
		grid.rows.addCol("100px");
		

		grid.setTextMatrix(0,0,"Produto");
		grid.setTextMatrix(0,1,"Descricao");
		grid.setTextMatrix(0,2,"Quantidade");
		grid.setTextMatrix(0,3,"Preco");
		grid.setTextMatrix(0,4,"Total");
		grid.setTextMatrix(1,0," ");
		grid.setTextMatrix(1,1," ");
		grid.setTextMatrix(1,2," ");
		grid.setTextMatrix(1,3," ");
		grid.setTextMatrix(1,4," ");		
}

window.addEventListener("load",iniciar);