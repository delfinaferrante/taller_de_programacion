program ejercicio2;
const
 dimF = 300;
type
 oficina = record
   cod: integer;
   dni: integer;
   expensa: real;
 end;
 vector = array [1..dimF] of oficina;

{----------------------- MÓDULOS ------------------------------------------------------}

procedure mostrarVector (v: vector; dimL: integer);
var
i: integer;
begin
for i:= 1 to dimL do begin
  writeln;
  writeln (' Posicion ', i);
  write ('Codigo: ', v[i].cod, ' - DNI: ', v[i].dni, ' - Valor de expensas: ', v[i].expensa:2:1);
  writeln;
end;
end;

procedure ordenarVectorInsercion(var v: vector; dimL: integer);
var
 i, j: integer;
 actual: oficina;
begin
 for i:= 2 to dimL do begin
   actual := v[i];
   j := i-1;
   
   while (j > 0) and (v[j].cod > actual.cod) do begin
     v[j+1]:= v[j];
     j:= j-1;
   end;
   
   v[j+1]:= actual;
 end;
end;

procedure ordenarVectorSeleccion(var v: vector; dimL: integer);
var
 i, j, pos: integer;
 item: oficina;
begin
 for i:= 1 to dimL-1 do begin
   pos:= i;
   
   for j:= i+1 to dimL do 
     if (v[j].cod < v[pos].cod) then
       pos:= j;
   
   item:= v[pos];
   v[pos]:= v[i];
   v[i]:= item;
   
 end;
end;

procedure procesarDatos(var v: vector; var dimL: integer);

	procedure leerOficina(var r: oficina);
	begin
	  write('Codigo: '); readln(r.cod);
	  if (r.cod <> -1) then begin
	    write('Dni: '); readln(r.dni);
	    write('Valor de expensas: '); readln(r.expensa);
	  end;
	end;

var
 unaOficina: oficina;
begin
 leerOficina(unaOficina);
 while (unaOficina.cod <> -1) and (dimL < dimF) do begin
   dimL:= dimL + 1;
   v[dimL]:= unaOficina;
   leerOficina(unaOficina);
 end;
end;


{----------------------- PROG. PRINCIPAL ----------------------------------------------}

var
 v: vector;
 dimL: integer;
begin
 dimL:= 0;
 procesarDatos(v, dimL);  {inciso A}
 ordenarVectorInsercion(v, dimL);  {inciso B}
 ordenarVectorSeleccion(v, dimL);  {inciso C}
 
 writeln('--- VECTOR ORDENADO ---');
 mostrarVector(v, dimL);
end.
