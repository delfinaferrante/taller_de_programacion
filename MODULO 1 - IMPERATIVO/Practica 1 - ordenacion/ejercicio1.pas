program ejercicio1;
const
dimF = 50;
type
dias = 0..31;
rango1 = 1..15;
rango2 = 1..99;
rango3 = 0..50;

venta = record
  dia: dias;
  cod: rango1;
  cant: rango2;
end;

nuevaVenta = record
  cod: rango1;
  cant: rango2;
end; 

vector = array [1..dimF] of venta;
lista = ^nodo;
nodo = record
  dato: nuevaVenta;
  sig: lista;
end;

{----------------------- MÓDULOS ----------------------------------------------}

procedure mostrarLista(l: lista);
begin
 while (l <> nil) do begin
   writeln('Codigo: ', l^.dato.cod, ' - Cantidad: ', l^.dato.cant);
   l := l^.sig;
 end;
end;

procedure nuevaEstructura (v: vector; dimL: integer; var l: lista);

    function codPar(codigo:rango1):boolean;
    begin
      codPar := (codigo mod 2 = 0); 
    end;

    procedure cargarRegistro (unaVenta: venta; var r: nuevaVenta);
    begin
      r.cod:= unaVenta.cod;
      r.cant:= unaVenta.cant;
    end;
    
    procedure agregoAdelante(var l: lista; r: nuevaVenta);
    var
      nue: lista;
    begin
      new(nue);
      nue^.dato:= r;
      nue^.sig:= l;
      l:= nue;
    end;

var
i: integer;
r: nuevaVenta;
begin
 for i:= dimL downto 1 do begin
   if (codPar(v[i].cod)) then begin
     cargarRegistro(v[i], r);
     agregoAdelante(l, r);
   end;
 end;
end;

procedure eliminar (var v: vector; var dimL: rango3; valorInferior, valorSuperior: rango1);

     function buscarPosicionInicial (v: vector; dimL: rango3; codABuscar: rango1): rango3;
     var
      pos: rango3;
     begin
      pos:= 1;
      while (pos <= dimL) and (codABuscar > v[pos].cod) do
        pos := pos + 1;
      if (pos > dimL) then
         buscarPosicionInicial := 0
      else
        buscarPosicionInicial := pos;
     end;
     
     function buscarPosicionDesde (v: vector; dimL, posInf: integer; codABuscar: rango1): rango3;
     begin
       while (posInf <= dimL) and (codABuscar >= v[posInf].cod) do
          posInf := posInf + 1;
       if (posInf > dimL) then  {si no hay un valor más grande q el cod del valor sup, significa que el rango abarca todo el vector restante}
          buscarPosicionDesde := dimL
       else
          buscarPosicionDesde := posInf - 1;  {sino, significa q encontre un cod mayor entonces ya tengo el valor superior del rango}
     end;
    
var
posInf, posSup, salto, i: rango3;
begin
posInf := buscarPosicionInicial (v, dimL, valorInferior); {busca primera posicion del rango}
if (posInf <> 0) then begin
   posSup := buscarPosicionDesde(v, dimL, posInf, valorSuperior);  {busca segunda posicion del rango }      
   salto:= (posSup - posInf)+ 1;
   
   for i:= posSup+1 to dimL do
     v[i-salto] := v[i];
   
   dimL := dimL - 1;
end;

end;

procedure ordenarVectorSeleccion (var v: vector; dimL:rango3);
var
i, j, pos: rango3; 
item: venta;	
		
begin
 for i:= 1 to dimL - 1 do begin {busca el mínimo y guarda en pos la posición}
   pos := i;
   for j := i+1 to dimL do 
        if (v[j].cod < v[pos].cod) then
          pos:= j;

   {intercambia v[i] y v[pos]}
   item := v[pos];   
   v[pos] := v[i];   
   v[i] := item;
 end;
end;

procedure mostrarVector (v: vector; dimL: rango3);
var
i: integer;
begin
for i:= 1 to dimL do begin
  writeln;
  writeln (' Posicion ', i);
  write ('Dia: ', v[i].dia, ' - Codigo: ', v[i].cod, ' - Cantidad : ', v[i].cant);
  writeln;
end;
end;

procedure almacenarInformacion(var v: vector; var dimL: rango3);

	procedure leerVenta(var r: venta);
	begin
	  Randomize;
      write ('Ingresar dia: ');
	  //r.dia := random (32); {valor entre 0 y 31}
	  readln(r.dia);
	  writeln ('Dia: ', r.dia);
	  if (r.dia <> 0) then begin
	     write('Codigo: ');
	     r.cod := random (16) + 1; {valor entre 1 y 15}
	     writeln (r.cod);
	     write ('Ingrese cantidad (entre 1 y 99): ');
	     readln (r.cant);
	  end;
	end;

var
unaVenta: venta;
begin
dimL := 0;
leerVenta(unaVenta);
while (unaVenta.dia <> 0) and (dimL < dimF) do begin
	dimL := dimL + 1;
	v[dimL]:= unaVenta;
	leerVenta(unaVenta);
end;
end;

{----------------------- PROG. PRINCIPAL ----------------------------------------------}

var
v: vector;
dimL: rango3;
valorInf, valorSup: rango1;
l: lista;

begin
almacenarInformacion(v, dimL);  {inciso A}
mostrarVector(v, dimL);      {inciso B}

writeln;
write('--- VECTOR ORDENADO ---');
ordenarVectorSeleccion(v, dimL);   {inciso C}
mostrarVector(v, dimL);     {inciso D}

writeln;
writeln('Valor inferior: '); 
readln(valorInf);
writeln('Valor superior: ');
readln(valorSup);
writeln; 
eliminar(v, dimL, valorInf, valorSup);  {inciso E}
writeln;
write('--- VECTOR POST ELIMINACIÓN ---');
mostrarVector(v, dimL);    {inciso F}

l := nil;
nuevaEstructura(v, dimL, l);  {inciso G}
mostrarLista(l);   {inciso H}
end.
