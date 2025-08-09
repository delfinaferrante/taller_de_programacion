program parcial3;
type
rangomes = 1..12;

  compra = record
	codCliente: integer;
	mes: rangomes;
	monto: real;
  end;
  
  vectorMeses = array [rangomes] of real;
  
  cliente = record
    codCliente: integer;
	montoTotal: vectorMeses;
  end;
  
  arbol = ^nodoArbol;
  nodoArbol = record
	dato: cliente;
	hi: arbol;
	hd: arbol;
  end;

// -------- MODULOS -------------

procedure cargarDatos(var a: arbol);

	procedure leer(var c: compra);
	begin
		c.codCliente:= random(400);
		if (c.codCliente <> 0) then begin
			c.monto:= random(20000)/random(10)+1;
			c.mes:= random(12)+1;
		end;
	end;

	procedure crearArbol(var a: arbol; c: compra);
		
		procedure inicializoVector(var v: vectorMeses);
		var
		 i: rangomes;
		begin
		 write(' inicializo vector');
		 for i:= 1 to 12 do
		   v[i]:= 0;
		end;
	
	begin
	 write(' crear arbol');
		if (a = nil) then begin
			new(a);
			a^.dato.codCliente:= c.codCliente;
			inicializoVector(a^.dato.montoTotal);
			a^.dato.montoTotal[c.mes]:= c.monto;
			a^.hi:= nil;
			a^.hd:= nil;
		end
		else if (c.codCliente = a^.dato.codCliente) then
			a^.dato.montoTotal[c.mes]:= a^.dato.montoTotal[c.mes] + c.monto	
		else if (c.codCliente > a^.dato.codCliente) then 
			crearArbol(a^.hd, c)
		else 
			crearArbol(a^.hi, c);	
	end;

var
 unaCompra: compra;
begin
 write(' cargar datos');
 a:= nil;
 leer(unaCompra);
 while(unaCompra.codCliente <> 0) do begin
	crearArbol(a, unaCompra);
	leer(unaCompra);
 end;
end;

procedure imprimoArbol(a:arbol);

	procedure imprimoVector(v: vectorMeses);
	var
	 i: rangomes;
	begin
	 for i:= 1 to 12 do begin
		writeln('-- MES ', i, ' --');
		writeln('Monto total gastado: ', v[i]:2:2);
		writeln;
	 end;
	end;
	
begin
	if (a <> nil) then begin
		imprimoArbol(a^.hi);
		writeln;
		write('-- Codigo de cliente: ', a^.dato.codCliente, ' --');
		imprimoVector(a^.dato.montoTotal);
		writeln;
		imprimoArbol(a^.hd);
	end;
end;

// --------- PROG. PRINC ---------
var
 a: arbol;
begin
 Randomize;
 cargarDatos(a);
 imprimoArbol(a);
end.
