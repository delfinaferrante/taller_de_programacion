program ejercicio3;
type

venta = record
  codV: integer;
  codP: integer;
  cantUnidades: integer;
  precioUnidad: real;
end;

producto = record
  codP: integer;
  cantTotal: integer;
  montoTotal: real;
end;

arbol = ^nodoArbol;
nodoArbol = record
  dato: producto;
  hi: arbol;
  hd: arbol;
end;


// --------------- MODULOS -------------- //

procedure cargarDatos(var a: arbol);

	procedure leer(var v: venta);
	begin
	  write('Codigo de venta: '); readln(v.codV); 
	  if (v.codV <> -1) then begin
		  v.codP:= 1 + random(50);
		  v.cantUnidades:= 1 + random(50);
		  write('Precio unidad: '); readln(v.precioUnidad); 
	  end;
	end;
	
	procedure crearArbol(var a: arbol; v: venta);
	
		procedure cargarProducto(var p: producto; v: venta);
		begin
			p.codP:= v.codP;
			p.cantTotal:= v.cantUnidades;
			p.montoTotal:= (v.cantUnidades * v.precioUnidad);
		end;
	
	begin
	  if (a = nil) then begin
	     new(a);
	     cargarProducto(a^.dato, v);
	     a^.hd:= nil;
	     a^.hi:= nil;
	  end
	  else if (v.codP = a^.dato.codP)then begin
		a^.dato.cantTotal:= a^.dato.cantTotal + v.cantUnidades;
		a^.dato.montoTotal:= a^.dato.montoTotal + (v.cantUnidades * v.precioUnidad);
	  end
	  else if (v.codP > a^.dato.codP) then
		crearArbol(a^.hd, v)
	  else
		crearArbol(a^.hi, v);
	end;
	
var
 unaVenta: venta;
begin
 Randomize;
 writeln('----- Carga de registro y arbol ----->');
 leer(unaVenta);
 while(unaVenta.codV <> -1) do begin
	crearArbol(a, unaVenta);
	leer(unaVenta);
 end;
end;

procedure imprimirArbol(a:arbol);

	procedure mostrarDatos(p: producto);
	begin
		write('Codigo de producto: ', p.codP, ' - Cantidad total de unidades vendidas: ', 
		p.cantTotal, ' - Monto total: $', p.montoTotal:2:2);
	end;

begin
	if (a <> nil) then begin
		imprimirArbol(a^.hi);
		writeln;
		mostrarDatos(a^.dato);
		writeln;
		imprimirArbol(a^.hd);
	end;
end;

procedure codMasUnidades(a: arbol; var max: integer; var maxCod: integer);
begin
  if(a <> nil) then begin
	if (a^.dato.cantTotal > max) then begin
		max:= a^.dato.cantTotal;
		maxCod:= a^.dato.codP;	
    end;
     codMasUnidades(a^.hi, max, maxCod);
     codMasUnidades(a^.hd, max, maxCod);
  end;
end;

function codigosMenores(a:arbol; num: integer): integer;
begin
	if (a = nil) then
		codigosMenores:= 0
	else 
		if (a^.dato.codP < num) then
			codigosMenores:= 1 + codigosMenores(a^.hi, num) + codigosMenores(a^.hd, num)
		else
			codigosMenores:= codigosMenores(a^.hi, num);
end;

function montoTotalRango(a:arbol; cod1, cod2: integer): real;
begin
	if (a = nil) then
		montoTotalRango:= 0
	else begin
		if (a^.dato.codP > cod1) and (a^.dato.codP < cod2) then
			montoTotalRango:= a^.dato.montoTotal + montoTotalRango(a^.hd,cod1,cod2) + montoTotalRango(a^.hi,cod1,cod2)
		else
		   if (a^.dato.codP < cod1) then
				montoTotalRango:= montoTotalRango(a^.hd,cod1,cod2)
			else
				montoTotalRango:= montoTotalRango(a^.hi,cod1,cod2);
	end;
end;

// -------------- PROG. PRINCIPAL ----------- //
var
a: arbol;
max, maxCod, valor, cod1, cod2: integer;
begin
a:= nil;
cargarDatos(a);   {inciso A}
writeln;

writeln('---- Arbol ordenado por producto ---->');
imprimirArbol(a); {inciso B}
writeln;

writeln;
writeln('---- Inciso C ---->');
max:= -1;
codMasUnidades(a, max, maxCod);
write('Codigo de producto con mayor cantidad de unidades: ', maxCod);

writeln;
writeln('---- Inciso D ---->');
write('Ingrese un valor: '); readln(valor);
write('Cantidad de codigos menores a ', valor, ': ', codigosMenores(a, valor));
writeln;

writeln('---- Inciso E ---->');
write('Valor 1: '); readln(cod1);
write('Valor 2: '); readln(cod2);
write('Monto total entre el rango (', cod1, ', ', cod2, '): ', montoTotalRango(a, cod1, cod2):2:2);
end.
