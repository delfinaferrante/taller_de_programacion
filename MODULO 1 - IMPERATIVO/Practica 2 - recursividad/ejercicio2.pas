program ejercicio2;
type
rango = 100..200;

lista = ^nodo;
nodo = record
 dato: rango;
 sig: lista;
end;

//------------------ MODULOS -------------------------------
procedure cargarLista(var L: lista);

					procedure agregarALista(var L: lista; num: rango);
					var
					 nue: lista;
					begin
					 new(nue);
					 nue^.dato:= num;
					 nue^.sig:= L;
					 L:= nue;
					 
					 writeln('Valor: ', num);
					end;
					
var
 num: rango;
begin
		num:= 100 + random(101);
		 if (num <> 100) then begin
			 agregarALista(L, num);
			 cargarLista(L);
		 end;
end;

procedure imprimirListaOrden(L: lista);
begin
		if (L <> nil) then begin
			imprimirListaOrden(L^.sig);
			writeln;
			writeln(L^.dato);
		end;
end;

procedure imprimirListaOrdenInverso(L: lista);
begin
		 if (L <> nil) then begin
			 writeln;
			 writeln(L^.dato);
			 imprimirListaOrdenInverso(L^.sig);
		 end;
end;

function valorMinimo(L: lista): integer;
var
 minSig: integer;
begin
 if (L = nil) then  
   minSig:= 300                                          // si la lista esta vacia retorna 300 (los numeros van de 100 a 200)
 else 
 begin
   minSig := valorMinimo(L^.sig);              // sino, llamo recursivamente para encontrar el minimo 
   
   if (L^.dato < minSig) then                    // si el dato actual es menor que el mínimo del resto, se actualiza
      valorMinimo := L^.dato
   else
      valorMinimo := minSig;                    // sino, el minimo se mantiene
 end;
end;

function buscarValor(L: lista; dato: integer): boolean;
begin
			 if (L = nil) then  // caso base
				 buscarValor:= false
			 else
			 if (L^.dato <> dato) then
				 buscarValor:= buscarValor(L^.sig, dato)
			 else
				 buscarValor:= true;
end;

//------------------ PROG. PRINC ----------------------------

var
L: lista;
valor: integer;
begin
Randomize;
L:= nil;
cargarLista(L);  {inciso A}
writeln('------- LISTA EN ORDEN ---------');
imprimirListaOrden(L);  {inciso B}

writeln('------- LISTA EN ORDEN INVERSO  ---------');
imprimirListaOrdenInverso(L); {inciso C}

writeln;
writeln ('Valor minimo de la lista: ', valorMinimo(L));   {inciso D}

writeln;
writeln('Ingrese un valor entero: ');
read(valor);   {inciso E}
		if (buscarValor(L, valor)) then
			write('El valor ', valor, ' esta en la lista.')
		else
			write('El valor ', valor, ' no esta en la lista.');

end.
