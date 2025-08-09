program ejercicio3;
type
rangoRubro = 1..10;

producto = record
	cod: integer;
	rubro: rangoRubro;
	stock: integer;
	precioUnidad: real;
end;

pSinRubro = record
	cod: integer;
	stock: integer;
	precioUnidad: real;
end;

arbol = ^nodoArbol;
nodoArbol = record
	dato: pSinRubro;
	hi: arbol;
	hd: arbol;
end;
vecRubro = array [rangoRubro] of arbol;


//------- MODULOS -------------

procedure inicializo (var v: vecRubro);
var
 i: rangoRubro;
begin
 for i:= 1 to 10 do
	v[i]:= nil;
end;

procedure cargarDatos(var v: vecRubro);

	procedure leer(var p: producto);
	begin
	  p.cod:= random(21);
	  if (p.cod <> 0) then begin
		p.rubro:= 1 + random(10);
		p.stock:= 1 + random (1000);
		write('Precio unidad: '); readln(p.precioUnidad);
	  end;
	end;
	
	procedure cargoVector(var a: arbol; p: producto);
	
		procedure cargoRegistro(p: producto; var s: pSinRubro);
		begin
			s.cod:= p.cod;
			s.stock:= p.stock;
			s.precioUnidad:= p.precioUnidad;
		end;
		
	var
	  sinRubro: pSinRubro;
	begin
		if (a = nil) then begin
			new(a);
			cargoRegistro(p, sinRubro);
			a^.dato:= sinRubro;
			a^.hi:= nil;
			a^.hd:= nil;
		end
		else if(p.cod >= a^.dato.cod) then
			cargoVector(a^.hd, p)
		else
			cargoVector(a^.hi,p);
	end;
	
var
 unProducto: producto;
begin
 leer(unProducto);
 while(unProducto.cod <> 0) do begin
	cargoVector(v[unProducto.rubro], unProducto);
	leer(unProducto);
 end;
end;

procedure mostrarVector(v:vecRubro);

	procedure imprimoArbol(a: arbol);
	begin
		if (a <> nil) then begin
			imprimoArbol(a^.hi);
			writeln;
			write('Codigo: ', a^.dato.cod, ' - Stock: ', a^.dato.stock, ' - Precio unidad: $', a^.dato.precioUnidad:2:2);
			writeln;
			imprimoArbol(a^.hd);
		end;
	end;

var
 i:rangoRubro;
begin
 for i:= 1 to 10 do begin
	writeln('-- RUBRO ', i, ' --');
	if (v[i] <> nil) then
		imprimoArbol(v[i])
	else
		write('No hay productos en el rubro ', i);
	writeln;
	writeln;
 end;
end;

function existeCod(v: vecRubro; rubro: rangoRubro; cod: integer): boolean;

	function buscoEnArbol(a:arbol; cod: integer):boolean;
	begin
		if (a = nil)then
			buscoEnArbol:= false
		else
			if (a^.dato.cod = cod) then
				buscoEnArbol:= true
			else if (a^.dato.cod > cod) then
				buscoEnArbol:= buscoEnArbol(a^.hi, cod)
			else
				buscoEnArbol:= buscoEnArbol(a^.hd, cod);
	end;

begin
	if (v[rubro] = nil) then
		existeCod:= false
	else
		existeCod:= buscoEnArbol(v[rubro], cod);
end;

procedure codYStockMax(a: arbol; var codMax: integer; var stockMax: integer);
begin
	if (a <> nil) then begin
		if (codMax < a^.dato.cod) then begin
			codMax:= a^.dato.cod;
			stockMax:= a^.dato.stock;
		end;
		codYStockMax(a^.hd, codMax, stockMax);
	end;
end;

function cantProductosRango(a: arbol; cod1, cod2: integer): integer;
begin
	if (a = nil) then 
		cantProductosRango:= 0
	else begin
		if (a^.dato.cod > cod1) and (a^.dato.cod < cod2) then
			cantProductosRango:= 1 + cantProductosRango(a^.hd, cod1,cod2) + cantProductosRango(a^.hi,cod1,cod2)
		else begin
			if (a^.dato.cod < cod1) then
				cantProductosRango:= cantProductosRango(a^.hd,cod1,cod2)
			else
				cantProductosRango:= cantProductosRango(a^.hi,cod1,cod2);
		end;
	end;
end;


//---------- PROG. PRINCIPAL -------
var
v: vecRubro;
unRubro, i, j: rangoRubro;
unCod, codMax, stockMax, cod1, cod2, cant:integer;
begin
Randomize;
inicializo(v);
cargarDatos(v);   {inciso A}
writeln;
writeln('--- Vector de arboles --->');
mostrarVector(v); 

writeln;
write('Ingrese un rubro: '); readln(unRubro);
write('Ingrese un codigo: '); readln(unCod);
if (existeCod(v,unRubro,unCod)) then   {inciso B}
	write('El codigo ', unCod, ' existe en el rubro ', unRubro)
else
	write('El codigo ', unCod, ' no existe en el rubro ', unRubro);
	
writeln;
codMax:= 0;
stockMax:= 0;
for i:= 1 to 10 do begin	{inciso C}
	codMax:= 0;
	stockMax:= 0;
	writeln;
	write('-- Rubro ', i, ' --');
	writeln;
	
	if (v[i] <> nil) then begin
		codYStockMax(v[i], codMax, stockMax);
		write('Codigo de producto mayor: ', codMax, ' - Stock: ', stockMax);
		writeln;
	end
	else 
		writeln('El rubro ', i, ' esta vacio. ');

end;
writeln;
write('Ingrese codigo 1: '); readln(cod1);
write('Ingrese codigo 2 (mayor al 1): '); readln(cod2);

for j:= 1 to 10 do begin    {inciso D}
	
	writeln;
	write('-- Rubro ', j, ' --');

	if (v[j] <> nil) then
		cant:= cantProductosRango(v[j], cod1, cod2)
	else
		write('No hay productos en el rubro ', j);
	
	
	writeln('Cantidad de productos entre los codigos (', cod1, ', ', cod2, '): ', cant);
	writeln;

end;
end.
