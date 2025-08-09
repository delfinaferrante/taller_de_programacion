program ejercicio4;
const
 dimF = 8;
type
 rango1 = 1..8;
 rango2 = 1..30;
 
producto = record
  codP: integer;
  codR: rango1;
  precio: real;
end;

lista = ^nodo;
nodo = record
  dato: producto;
  sig: lista;
end;

 vectorP = array [rango1] of lista;
 vectorRubro3 = array [rango2] of producto;


// -------------------- MODULOS -------------------------------

procedure inicializarVector(var v: vectorP);
var
 i: rango1;
begin
 for i:= 1 to dimF do 
    v[i] := nil;
end;

procedure procesarDatos(var v: vectorP);
	
	procedure leer(var p: producto);
	begin
	  write('Precio: '); readln(p.precio);
	  if (p.precio <> 0) then begin
		write('Codigo de producto: '); readln(p.codP);
		write('Codigo de rubro: '); readln(p.codR);
		writeln;
	  end;
	end;
	
	procedure cargarVectorOrdenado(var l: lista; p: producto);
	var
	  nue, act, ant: lista;
	begin
	  new(nue);
	  nue^.dato := p;
	  act := l;
	  ant := l;
	  while (act <> nil) and (p.codP > act^.dato.codP) do begin
	     ant := act;
	     act := act^.sig;
	  end;
	  if (act = ant) then
	    l:= nue
	  else
	    ant^.sig := nue;
	  
	  nue^.sig := act;
	end;

var
 unProducto: producto;
begin
 leer(unProducto);
 while (unProducto.precio <> 0) do begin
   cargarVectorOrdenado(v[unProducto.codR], unProducto);
   leer(unProducto);
 end;
end;

procedure mostrarCodigos(v: vectorP);

	procedure recorrerLista(l: lista);
	begin
	  while (l <> nil) do begin
		writeln('Codigo de producto: ', l^.dato.codP);
		l := l^.sig;
	  end;
	end;

var
 i: rango1;
begin
 for i:= 1 to dimF do begin
   writeln;
   writeln('--- RUBRO ', i, ' ---'); 
   recorrerLista(v[i]);
   writeln;
 end; 
end;

	
procedure recorrerRubro3(l: lista; var vRubro3: vectorRubro3; var dimL: integer);
begin
  while (l <> nil) and (dimL < 30) do begin
    dimL := dimL + 1;
    vRubro3[dimL]:= l^.dato;
    l := l^.sig;
  end;
  if (l <> nil) and (dimL = 30) then
    writeln('Se agregaron 30 productos.')
  else 
    if (l = nil) then
      writeln('No hay mas productos del rubro 3 para agregar.');
end;
	
procedure ordenarSeleccion(var v: vectorRubro3; dimL: integer);
var
 i, j, pos: integer;
 item: producto;
begin
 for i:= 1 to dimL-1 do begin
   pos:= i;
   
   for j:= i+1 to dimL do
     if (v[j].precio < v[pos].precio) then
       pos := j;
   
   item:= v[pos];
   v[pos]:= v[i];
   v[i]:= item;
 end;
end;

procedure mostrarPrecios (v: vectorRubro3; dimL: integer);

	procedure recorrerRubro3(p: producto);
	begin
	    writeln;
		writeln('Precio: ', p.precio:2:2);
	end;
var
 i: integer;
begin
 for i:= 1 to dimL do begin
   writeln;
   write(' Producto: ', i);
   recorrerRubro3(v[i]);
 end;
    writeln;
    writeln('DimL: ', dimL);
end;

function calcularPromedio (v2: vectorRubro3; cantProductos: integer): real;
var
 sumaTotal: real;
 i: integer;
begin
 sumaTotal:= 0;
 for i:= 1 to cantProductos do
   sumaTotal:= sumaTotal + v2[i].precio;

 calcularPromedio:= (sumaTotal / cantProductos);
end;

// -------------------- PROGRAMA PRINCIPAL --------------------
var
v: vectorP;
v2: vectorRubro3;
dimL: integer;
begin
inicializarVector(v);
procesarDatos(v);   {inciso A}
mostrarCodigos(v);  {inciso B}

dimL := 0;
recorrerRubro3(v[3], v2, dimL);   {inciso C}

ordenarSeleccion(v2, dimL);  {inciso D}
mostrarPrecios(v2, dimL);    {inciso E}
writeln;
write('Promedio de los precios del rubro 3: ', calcularPromedio(v2, dimL):2:2);
end.
