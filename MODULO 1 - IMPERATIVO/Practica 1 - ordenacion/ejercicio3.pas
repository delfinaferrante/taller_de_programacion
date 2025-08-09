program ejercicio3;
const
 dimF = 8;
type
rango1 = 1..8;

 pelicula = record
   codPelicula: integer;
   codGenero: rango1;
   puntaje: real; 
 end;
 
 reg_max = record
   cod: integer;
   puntaje: real;
 end;
 
 lista = ^nodo;
 nodo = record
   dato: pelicula;
   sig: lista;
 end;
 
 vectorPeli = array [rango1] of lista;
 vectorMax = array [rango1] of reg_max;

{----------------------- MÓDULOS ------------------------------------------------------}
procedure inicializarVector(var v: vectorPeli);
var
 i: rango1;
begin
 for i:= 1 to dimF do 
   v[i]:= nil;
end;

procedure procesarDatos(var v: vectorPeli);

	procedure leerPelicula(var r: pelicula);
	begin
		write('Codigo pelicula: '); readln(r.codPelicula);
		if (r.codPelicula <> -1) then begin
		  write('Codigo genero: '); readln(r.codGenero);
		  write('Puntaje promedio: '); readln(r.puntaje);
		  writeln;
		end;
	end;

	procedure agregarAtras(var l, ult: lista; r: pelicula);
	var
	 nue: lista;
	begin
	 new(nue);
	 nue^.dato:= r;
	 nue^.sig:= nil;
	 if (l = nil) then
	   l:= nue
	 else
	   ult^.sig:= nue;
	 ult:= nue;
	end;

var
  unaPelicula: pelicula;
  ult: lista;
begin
  leerPelicula(unaPelicula);
  while (unaPelicula.codPelicula <> -1) do begin
    agregarAtras(v[unaPelicula.codGenero], ult, unaPelicula);
    leerPelicula(unaPelicula);
  end;
end;

procedure buscarMayorPuntaje(vpelis: vectorPeli; var vMax: vectorMax);

	procedure max(l: lista; var pelimax: reg_max);
	begin

	  pelimax.puntaje:= -1;
	  while (l <> nil) do begin
	  
	    if (l^.dato.puntaje > pelimax.puntaje) then begin
	       pelimax.puntaje:= l^.dato.puntaje;
	       pelimax.cod := l^.dato.codPelicula;
	       
	    l:= l^.sig; 
	    end;   
	  end;	  
	end;

var
 i: rango1;
begin
 for i:= 1 to dimF do
   max(vpelis[i], vMax[i]);
end;

procedure imprimirVector(v: vectorMax);
var
 i: rango1;
begin
 for i:= 1 to dimF do begin
   writeln;
   write('--- Posicion ', i, ' ---- ');
   writeln(' Codigo pelicula: ', v[i].cod, ' - Puntaje maximo: ', v[i].puntaje:2:2);
   writeln;
 end;
end;

procedure ordenarVectorInsercion(var v: vectorMax);
var
 i, j: integer;
 actual: reg_max;
begin
 for i:= 2 to dimF do begin
   actual := v[i];
   j := i-1;
   
   while (j > 0) and (v[j].puntaje > actual.puntaje) do begin
      v[j+1]:= v[j];
      j:= j-1;
   end;
   
   v[j+1]:= actual; 
 end;
end;
{----------------------- PROG. PRINCIPAL ----------------------------------------------}

var
  v1: vectorPeli;
  v2: vectorMax;
begin
  inicializarVector(v1);
  procesarDatos(v1);   {inciso A}
  
  buscarMayorPuntaje(v1, v2);  {inciso B}
  writeln( ' ----- VECTOR MAXIMO PUNTAJE SEGUN GENERO ----- ');
  imprimirVector(v2);
  
  ordenarVectorInsercion(v2);  {inciso C}
  writeln( ' ----- VECTOR ORDENADO DE MENOR A MAYOR SEGUN PUNTAJE ----- ');
  imprimirVector(v2);
  
  writeln;
  writeln('Codigo de pelicula con mayor puntaje: ', v2[8].cod, ' - Puntaje: ', v2[8].puntaje:2:2);
  writeln('Codigo de pelicula con menor puntaje: ', v2[1].cod, ' - Puntaje: ', v2[1].puntaje:2:2);
  
end.
