program ejercicio1;
const
 dimF = 15;
type
rango1 = 1..15;
vectorRandom = array [rango1] of integer;


//------------------ MODULOS ----------------------------

procedure cargarVector(var v: vectorRandom; var dimL: integer);

	procedure cargarVectorRecursivo(var v: vectorRandom; var dimL: integer);
	var
	 valor: integer;
	begin
	 valor := 10 + random(145 + 1); {formula: min + random(max - min + 1) }
	 if (valor <> 20) and (dimL < dimF) then begin
	   dimL := dimL + 1;
	   v[dimL]:= valor;
	   cargarVectorRecursivo(v, dimL);
	 end;
	end;

begin
  dimL:= 0;
  cargarVectorRecursivo(v, dimL);
end;

{procedure imprimirVectorNoRecursivo(v: vectorRandom; dimL:integer);
var
 i: rango1;
begin
 for i:= 1 to dimL do
   writeln ('Posicion ', i, ' : ', v[i]);
end;}

procedure imprimirVectorRecursivo(v: vectorRandom; dimL: integer);
begin
 if (dimL <> 0) then begin
   imprimirVectorRecursivo(v, dimL-1);
   writeln ('Posicion ', dimL, ': ', v[dimL]);
 end; 
end;


function sumar (v: vectorRandom; dimL: integer): integer; 

  function sumarRecursivo (v: vectorRandom; pos, dimL: integer): integer;
  begin
    if (pos <= dimL)then begin
      if ( (v[pos] mod 2) = 0) then
        sumarRecursivo:= sumarRecursivo (v, pos + 1, dimL) + v[pos]  //si es par, continua con el sig elemento pero suma el actual
    else 
      sumarRecursivo:= sumarRecursivo (v, pos + 1, dimL); //si es impar, continua con el sig elemento sin sumarlo
    end
    else 
      sumarRecursivo:= 0 //caso base: si no hay mas elementos, retorna 0
  end;
 
var
 pos: integer; 
begin
 pos:= 1;
 sumar:= sumarRecursivo (v, pos, dimL);
end;

function maximo  (v: vectorRandom; dimL: integer): integer;
var
 max: integer; 
begin
 if (dimL = 1) then
   max:= v[1]
 else
 begin
   max := maximo(v, dimL - 1);
   if (v[dimL] > max) then
     maximo:= v[dimL]
   else
     maximo := max; 
 end; 
end;

function BuscarValor  (v: vectorRandom; dimL: integer; valor: integer): boolean;
begin
  if (dimL = 0) then 
     BuscarValor:= false
  else if (v[dimL] = valor) then
     BuscarValor:= true
  else
     BuscarValor:= BuscarValor(v, dimL - 1, valor);
end;

procedure imprimirDigitos(v: vectorRandom; dimL: integer);

				procedure imprimirDigitosDeNumero(num: integer);
				begin
					if (num > 0) then begin
						imprimirDigitosDeNumero(num div 10);       {va hasta el primer digito}
						write('  ', num mod 10);                                  {imprime digitos en orden}
					end;
				end;

begin
if (dimL > 0) then begin
  imprimirDigitos(v, dimL - 1);
  write('Posicion ', dimL, ' - Digitos: ');
  imprimirDigitosDeNumero(v[dimL]);
  writeln;
end; 
end;


//------------------ PROG. PRINCIPAL ----------------------------
var
 vRandom: vectorRandom;
 dimL, suma, valor: integer;
 encontre: boolean;
begin
 Randomize;
 cargarVector(vRandom, dimL);   {inciso A}
 
 if (dimL = 0) then
   writeln('Vector sin elementos. ')
 else 
   //imprimirVectorNoRecursivo(vRandom, dimL); {inciso B}
   imprimirVectorRecursivo(vRandom, dimL);   {inciso C}
 
 writeln;
 suma:= sumar(vRandom, dimL);
 writeln;
 writeln('La suma de los valores del vector es: ', suma); {inciso D}
 writeln;
 
 writeln('Valor maximo del vector: ', maximo(vRandom, dimL));   {inciso E}
 
 writeln('Ingrese un numero entero: ');
 read (valor);
 encontre:= BuscarValor(vRandom, dimL, valor);  {inciso F}
 writeln;
 if (encontre) then 
    writeln('El ', valor, ' esta en el vector')
    else 
    writeln('El ', valor, ' no esta en el vector');
    
writeln;
imprimirDigitos(vRandom, dimL);  {inciso G}
end.
