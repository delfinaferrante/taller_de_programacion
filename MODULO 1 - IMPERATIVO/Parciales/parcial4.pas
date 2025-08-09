program parcial4;
type

  compra = record
	cod_comida: integer;
	cod_cliente: integer;
	categoria: string;
  end;
  
  r_arbol = record
    cod_comida: integer;
    cantEntregas: integer;
  end;
  
  arbol = ^nodoArbol;
  nodoArbol = record
	dato: r_arbol;
	hi: arbol;
	hd: arbol;
  end;
  
  r_vector = record
	categoria: string;
	cantEntregas: integer;
  end;
  
  vector = array [1..5] of r_vector;

//---- MODULOS --------

procedure inicializoVector(var v: vector);
var
 i: integer;
begin
	v[1].categoria:= 'Full';
	v[2].categoria:= 'Super';
	v[3].categoria:= 'Media';
	v[4].categoria:= 'Normal';
	v[5].categoria:= 'Basica';
	
	for i:= 1 to 5 do
		v[i].cantEntregas:= 0;
end;

procedure cargarDatos(var a: arbol; var v: vector);

	procedure leerCompra(var c: compra);
	var
	  v: array[1..5] of string = ('Full', 'Super', 'Media', 'Normal', 'Basica');
	begin
		c.cod_cliente:= random(200);
		if (c.cod_cliente <> 0) then begin
			c.categoria:= v[random(5)+1];
			c.cod_comida:= random(200)+1000;
		end;
	end;
	
	procedure crearArbol(var a: arbol; c: compra);
	begin
		if (a = nil) then begin
			new(a);
			a^.dato.cod_comida:= c.cod_comida;
			a^.dato.cantEntregas:= 1;
			a^.hi:= nil;
			a^.hd:= nil;
		end
		else if (a^.dato.cod_comida = c.cod_comida) then
			a^.dato.cantEntregas:= a^.dato.cantEntregas + 1
		else if (a^.dato.cod_comida > c.cod_comida) then
			crearArbol(a^.hi, c)
		else
			crearArbol(a^.hd,c);
	end;
	
	procedure crearVector(var v: vector; c: compra);
	begin
		if (v[1].categoria = c.categoria) then
			v[1].cantEntregas:= v[1].cantEntregas + 1
			
		else if (v[2].categoria = c.categoria) then
			v[2].cantEntregas:= v[2].cantEntregas + 1	
			
		else if (v[3].categoria = c.categoria) then
			v[3].cantEntregas:= v[3].cantEntregas + 1
			
		else if (v[4].categoria = c.categoria) then
			v[4].cantEntregas:= v[4].cantEntregas + 1	
			
		else if (v[5].categoria = c.categoria) then
			v[5].cantEntregas:= v[5].cantEntregas + 1;	
	end;
	
var
 unaCompra: compra;
begin
 leerCompra(unaCompra);
 while(unaCompra.cod_cliente <> 0) do begin
	crearArbol(a, unaCompra);
	crearVector(v, unaCompra);
	leerCompra(unaCompra);
 end;
end;

procedure mostrarArbol(a: arbol);
begin
	if (a <> nil) then begin
		mostrarArbol(a^.hi);
		write('Codigo de comida: ', a^.dato.cod_comida, ' - Cantidad de entregas: ', a^.dato.cantEntregas);
		writeln;
		mostrarArbol(a^.hd);
	end;
end;

procedure mostrarVector(v: vector);
var
 i: integer;
begin
	for i:= 1 to 5 do begin
		writeln('Categoria: ', v[i].categoria, ' ---');
		writeln('Cantidad de entregas: ', v[i].cantEntregas);
		writeln;
	end;
end;

function cantEntregas(a:arbol; codComida: integer): integer;
begin
	if (a = nil) then
		cantEntregas:= 0
	else
		if (a^.dato.cod_comida = codComida) then
			cantEntregas:= a^.dato.cantEntregas
		else if (a^.dato.cod_comida > codComida) then
			cantEntregas:= cantEntregas(a^.hi, codComida)
		else
			cantEntregas:= cantEntregas(a^.hd,codComida);
end;

procedure ordenarVectorInsercion(var v: vector; var cat: string);
var
 i, j: integer;
 actual: r_vector;
begin
 for i:= 2 to 5 do begin
	actual:= v[i];
	j:= i-1;
	
	while (j > 0) and (v[j].cantEntregas > actual.cantEntregas) do begin
		v[j+1]:= v[j];
		j:= j-1;
	end;
	
	v[j+1]:= actual;
 end;
  cat:= v[5].categoria;
end;

//---- PROG. PRINC --------
var
 a: arbol;
 v: vector;
 codComida, cant: integer;
 catMax: string;
begin
 Randomize;
 inicializoVector(v);
 cargarDatos(a, v);
 
 writeln(' ARBOL ---');
 mostrarArbol(a);
 writeln;
 
 writeln(' Vector ---');
 mostrarVector(v);
 writeln;
 
 write('Ingrese un codigo de comida: '); readln(codComida);
 cant:= cantEntregas(a, codComida);
 if (cant = 0) then
	write('El codigo de comida ', codComida, ' no realizo ninguna compra.')
 else
	write('El codigo de comida ', codComida, ' realizo ', cant, ' compras.');
	
 writeln;
 ordenarVectorInsercion(v, catMax);
 writeln('Categoria con mayor cantidad de entregas: ', catMax);
 writeln;
 mostrarVector(v);
end.
