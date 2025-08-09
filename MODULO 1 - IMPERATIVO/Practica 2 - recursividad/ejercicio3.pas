program ejercicio3;
const
 dimF = 20;
 min = 300;
 max = 1550;
type
rango = 1..20;
vector = array [rango] of integer;

// ---------------------------- MODULOS ---------------------------------

procedure cargarVector(var v: vector; pos: integer);
begin
 if (pos <= dimF) then begin
		v[pos] := min + random (max-min + 1);
		cargarVector(v, pos+1);
 end;
end;

procedure imprimirVector(v: vector; pos: integer);
begin
 if (pos <= dimF) then begin
   writeln('Posicion ', pos, ': ', v[pos]);
   imprimirVector(v, pos + 1);
end;   
end;

procedure ordenarVectorInsercion(var v: vector);
var
  i, j, actual: integer;
begin
 
 for i:= 2 to dimF do begin
   actual:= v[i];
   j:= i-1;
   
   while (j > 0) and (v[j] > actual) do begin
     v[j+1]:= v[j];
     j:= j-1;
   end;
   
   v[j+1]:= actual;
 end;
end;

procedure busquedaDicotomica(v: vector; ini, fin: rango; dato: integer; var pos: integer);
var
 medio: rango;
begin
if (ini <= fin) then begin
  medio:= (ini+fin) div 2;
  
 if (v[medio] = dato) then
   pos := medio
 else
   if (v[medio] > dato) then
     busquedaDicotomica(v, ini, medio - 1, dato, pos)
   else
     busquedaDicotomica(v, medio + 1, fin, dato, pos);  
end
else
  pos:= -1;
end;

// ---------------------------- PROG PRINCIPAL  ---------------------------------

var
v: vector;
pos, dato: integer;
ini, fin: rango;
begin
Randomize;
pos:= 1;
writeln ('--- VECTOR ORIGINAL ---');
cargarVector(v, pos);  {inciso A}
imprimirVector(v, pos);

writeln;
writeln ('--- VECTOR ORDENADO ---');
ordenarVectorInsercion(v);  {inciso B}
imprimirVector(v, pos);

writeln;
write('Dato a buscar: ');
readln(dato);
ini:= 1;
fin:= 20;
pos:= -1;
busquedaDicotomica(v, ini, fin, dato, pos);

if (pos = -1) then
  write('El dato ', dato, ' no esta en el vector.')
else
  write('El dato: ', dato, ' esta en la posicion ', pos, '.');
  

end.
