program parcial1;
type
sub_dia = 1..31;

envio = record
	cod_cliente: integer;
	dia: sub_dia;
	peso: real;
end;

lista = ^nodoLista;
nodoLista = record
	dato: envio;
	sig: lista;
end;

regLista = record
	codPostal: integer;
	envio: lista;
end;

arbol = ^nodoArbol;
nodoArbol = record
	dato: regLista;
	hi: arbol;
	hd: arbol;
end;

// ------ MODULOS -----------

procedure cargarDatos(var a: arbol);

	procedure leerEnvio(var e: envio);
	begin
		//e.cod_cliente:= random(10000);
		e.cod_cliente:= random(100);
		if (e.cod_cliente <> 0) then begin
			e.dia:= random(30)+1;
			e.peso:= random(20000)/(random(10)+1);
		end;
	end;
	
	procedure crearArbol(var a: arbol; e: envio; cod: integer);
			
			procedure agregarAdelante(var L: lista; e: envio);
			var
			  nue: lista;
			begin
			  new(nue);
			  nue^.dato:= e;
			  nue^.sig:= L;
			  L:= nue;
			end;
			
	begin
		if (a = nil) then begin
			new(a);
			a^.dato.codPostal:= cod;
			a^.dato.envio:= nil;
			agregarAdelante(a^.dato.envio, e);
			a^.hi:= nil;
			a^.hd:= nil;
		end
		else if (a^.dato.codPostal = cod) then
			agregarAdelante(a^.dato.envio, e)
		else if (a^.dato.codPostal > cod) then
			crearArbol(a^.hi, e, cod)
		else
			crearArbol(a^.hd,e,cod);
	end;

var
unEnvio: envio;
codPostal: integer;
begin
a:= nil;
leerEnvio(unEnvio);
while (unEnvio.cod_cliente <> 0) do begin
	//write('Codigo postal: '); readln(codPostal);
	codPostal:= 1 + random(50);
	crearArbol(a, unEnvio, codPostal);
	leerEnvio(unEnvio);
end;
end;

procedure imprimirArbol(a:arbol);

	procedure imprimirLista(L:lista);
	begin
		while (L <> nil) do begin
			write('Cod cliente: ', L^.dato.cod_cliente, ' - Dia: ', L^.dato.dia, ' - Peso: ', L^.dato.peso:2:2);
			writeln;
			L:= L^.sig;
		end;
	end;

begin
	if (a <> nil) then begin
		imprimirArbol(a^.hi);
		write('Codigo postal: ', a^.dato.codPostal);
		writeln;
		imprimirLista(a^.dato.envio);
		writeln;
		imprimirArbol(a^.hd);	
	end;
end;

procedure imprimirNuevaLista(L: lista);
begin
	while (L <> nil) do begin
		write('Cod cliente: ', L^.dato.cod_cliente, ' - Dia: ', L^.dato.dia, ' - Peso: ', L^.dato.peso:2:2);
		writeln;
		L:= L^.sig;
	end;
end;

function enviosCodPostal(a: arbol; codPostal: integer): lista;
begin
	if (a = nil) then
		enviosCodPostal:= nil
	else begin
		if (a^.dato.codPostal = codPostal) then
			enviosCodPostal:= a^.dato.envio
		else if (codPostal > a^.dato.codPostal) then
			enviosCodPostal:= enviosCodPostal(a^.hd, codPostal)
		else
			enviosCodPostal:= enviosCodPostal(a^.hi, codPostal);
	end;
end;

procedure codigosClientes(L:lista; var codMin, codMax: integer; var maxPeso, minPeso: real);
begin
	if (L <> nil) then begin
	   if (L^.dato.peso > maxPeso) then begin
			maxPeso:= L^.dato.peso;
			codMax:= L^.dato.cod_cliente;
		end;
		
		if (L^.dato.peso < minPeso) then begin
			minPeso:= L^.dato.peso;
			codMin:= L^.dato.cod_cliente;
		end;
			
		codigosClientes(L^.sig, codMin, codMax, maxPeso, minPeso);
	end;
end;

// ------ PROG. PRINCIPAL -------
var
a: arbol;
cod, codmin,codmax: integer;
nuevaLista: lista;
maxpeso, minpeso: real;
begin
Randomize;
cargarDatos(a);  {inciso A}
imprimirArbol(a);
writeln;

writeln('INCISO B');
write('Ingrese un codigo postal: '); readln(cod);
nuevaLista:= nil;
nuevaLista:= enviosCodPostal(a, cod);
imprimirNuevaLista(nuevaLista);

writeln;
writeln('INCISO C');
maxpeso:= -1;
minpeso:= 32767;
codigosClientes(nuevaLista, codmin, codmax, maxpeso, minpeso);
if (nuevaLista <> nil) then begin
	writeln('Codigo del cliente con envio de menor peso: ', codmin);
	writeln('Codigo del cliente con envio de mayor peso: ', codmax);
end
else
	writeln('La lista esta vacia.');
end.
