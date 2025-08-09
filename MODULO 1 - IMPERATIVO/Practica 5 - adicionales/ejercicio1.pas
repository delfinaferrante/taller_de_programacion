program ejercicio1;
const
	dimF = 300;
type
  rango1 = 1..300;
  
  oficina = record
    cod: integer;
    dni: integer;
    expensa: real;
  end;
  
  vectorOficinas = array [1..dimF] of oficina;

// -------- MODULOS ----------------------->>

procedure cargarVector(var v: vectorOficinas; var dimL: integer);
	
	procedure leer(var o: oficina);
	begin
		o.cod := random(30);
		if (o.cod <> 0) then begin
			o.dni := random(9999);
			write('Valor expensas: '); readln(o.expensa);
		end;
	end;

var
  unaOficina: oficina;
begin
  leer(unaOficina);
  while (unaOficina.cod <> 0) and (dimL <= dimF) do begin
	dimL:= dimL + 1;
	v[dimL]:= unaOficina;
	leer(unaOficina);
	end;
  end;


procedure ordenarInsercion(var v: vectorOficinas; dimL: integer);
var
 i, j: integer;
 actual: oficina;
begin
 for i:= 2 to dimL do begin
	actual:= v[i];
	j:= i-1;
	
	while (j > 0) and (v[j].cod > actual.cod) do begin
		v[j+1]:= v[j];
		j:= j-1;
	end;
	v[j+1]:= actual;
 end
end;

procedure busquedaDicotomica(v: vectorOficinas; ini, fin: rango1; cod: integer; var pos: integer);
var
  medio: rango1;
begin

 if (ini <= fin) then begin
    medio:= (ini + fin) div 2;
  
	if (v[medio].cod = cod) then begin
		pos := medio;
		writeln('DNI del propietario: ', v[medio].dni);
	end
	else
		if (v[medio].cod > cod) then
			busquedaDicotomica(v, ini, medio - 1, cod, pos)
		else
			busquedaDicotomica(v, medio + 1, fin, cod, pos);
  end
  else 
	pos:= 0;
end;

procedure imprimirVector(v: vectorOficinas; dimL:integer);
begin
	if (dimL <> 0) then begin
		imprimirVector(v, dimL-1);
		writeln;
		write('Codigo de oficina: ', v[dimL].cod, ' - DNI: ', v[dimL].dni, ' - Valor expensas: $', v[dimL].expensa:2:2);
		writeln;
	end;
end;

function montoTotal(v: vectorOficinas; dimL: integer): real;
begin
	if (dimL <> 0) then 
		montoTotal := v[dimL].expensa + montoTotal(v, dimL - 1);
end;

// -------- PROG. PRINCIPAL --------------->>
var
 v: vectorOficinas;
 dimL, cod, pos: integer;
 ini: rango1;
begin
Randomize;
dimL:= 0;
cargarVector(v, dimL);     {inciso A}
ordenarInsercion(v, dimL); {inciso B}
writeln;
write('--- VECTOR ORDENADO --->');
imprimirVector(v, dimL); 

writeln;
write('Ingrese codigo de id de oficina: '); readln(cod);   {inciso C}
ini:= 1;
pos:= 0;
busquedaDicotomica(v, ini, dimL, cod, pos);

if (pos = 0) then
	write('El codigo ', cod, ' no esta en el vector.')
else
	write('Posicion del vector donde esta el codigo ', cod, ': ', pos);
	

writeln;
write('Monto total de expensas: $', montoTotal(v, dimL):2:2);
end.
