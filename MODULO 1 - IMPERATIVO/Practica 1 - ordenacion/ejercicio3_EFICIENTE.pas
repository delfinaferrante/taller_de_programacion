program ejercicio3;

const
max = 8;

type
rango = 1..max;

PeliAGuardar = record
		codPeli:integer;
		puntaje:real;
end;

pelicula = record
	datoAG: PeliAGuardar;
	genero: rango;
end;

lista = ^nodo;

nodo = record
	dato: PeliAGuardar;
	sig: lista;
end;

punteros = record
	pri, ult: lista;
end;

vectorPuntaje = array [rango] of PeliAGuardar;
vector = array [rango] of punteros;

//----------------- MODULOS -----------------------------------
procedure CargarDatos(var v:vector);

	procedure LeerPeli(var p:pelicula);
	begin
		write('Ingresar codigo de pelicula: ');
		readln(p.datoAG.codPeli);
		if (p.datoAG.codPeli <> -1) then begin
			write('Ingresar codigo de genero: ');
			readln(p.genero);
			write('Ingresar puntaje de pelicula: ');
			readln(p.datoAG.puntaje);
			writeln;
		end;
	end;

	procedure CargarVector (var pri,ult: lista; p: PeliAGuardar);
	var
	nue:lista;
	begin
		new(nue);
		nue^.dato:= p;
		nue^.sig:= nil;
		if(pri = nil) then
			pri:= nue
			else 
			ult^.sig:= nue;
		ult:= nue;
	end;

var
p:pelicula;
begin
	LeerPeli(p);
	while(p.datoAG.codPeli <> -1) do begin
		CargarVector(v[p.genero].pri, v[p.genero].ult, p.datoAG); {agregar atras}
		LeerPeli(p);
	end;
end;

procedure inicializoNuevoVector(var v: vectorPuntaje);
var
 i: rango;
begin
 for i:= 1 to 8 do begin
  v[i].puntaje := -1;
  v[i].codPeli:= 0;
 end;
end;

procedure RecorrerLista (L:lista; var maximo: real; var codMax: integer);
begin
	maximo:= -1;
	while (L <> nil) do begin
	  if (L^.dato.puntaje > maximo) then begin
			maximo:= L^.dato.puntaje;
			codMax:= L^.dato.codPeli;
	  end;
	L:= L^.sig;
	end;
end;

procedure NuevoVector(v:vector; var vp: vectorPuntaje);
var
i:integer;
codMax: integer;
maximo: real;
begin
	for i:= 1 to 8 do begin
		if (v[i].pri <> nil) then begin
		  RecorrerLista(v[i].pri, maximo, codMax);
		  vp[i].codPeli:= codMax;
		  vp[i].puntaje:= maximo;
		end 
		else
		  writeln('No se han encontrado peliculas en el genero ', i);
	end;
end;

procedure MostrarMaximo(vp: vectorPuntaje);
var
i: rango;
begin
 for i:= 1 to 8 do begin
    writeln('Genero ', i);
    writeln(' Puntaje maximo: ', vp[i].puntaje:2:2, ' - Cod pelicula: ', vp[i].codPeli);
    writeln;
 end;
end;

procedure OrdenarInsercion(var v: vectorPuntaje);
var
 i, j: integer;
 actual: PeliAGuardar;
begin
 for i:= 2 to 8 do begin
   actual:= v[i];
   j:= i-1;
   while (j > 0) and (v[j].puntaje > actual.puntaje) do begin
     v[j+1] := v[j];
     j:= j-1;
   end;
    v[j+1]:= actual;
 end;
end;


//----------------- PROG. PRINC -----------------------------------
var
v: vector;
vp: vectorPuntaje;

begin
	CargarDatos(v);  {inciso A}
	inicializoNuevoVector(vp);
	NuevoVector(v, vp); {inciso B}
	MostrarMaximo(vp);
	
	writeln;
	write('-- VECTOR ORDENADO POR PUNTAJE --');
	writeln;
	OrdenarInsercion(vp);  {inciso C}
	MostrarMaximo(vp);
	writeln;  {inciso D}
	write('Codigo de pelicula con mayor puntaje: ', vp[8].codPeli, ' - puntaje: ', vp[8].puntaje:2:2);
	writeln;
	write('Codigo de pelicula con menor puntaje: ', vp[1].codPeli, ' - puntaje: ', vp[1].puntaje:2:2);
end.
