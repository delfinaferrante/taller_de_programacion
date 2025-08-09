program ejercicio4;
type
rangoDias = 1..31;
rangoMes = 1..12;

{---------- ESTRUCTURAS ARBOL 1 --------}
prestamo = record
  isbn: integer;
  numSocio: integer;
  dia: rangoDias;
  mes: rangoMes;
  diasPrestados: integer;
end;

arbol1 = ^nodoArbol1;
nodoArbol1 = record
   dato: prestamo;
   hi: arbol1;
   hd: arbol1;
end;

{---------- ESTRUCTURAS ARBOL 2 --------}
prestamoArbol2 = record
  numSocio: integer;
  dia: rangoDias;
  mes: rangoMes;
  diasPrestados: integer;
end;

listaPrestamos = ^nodoLista;
nodoLista = record
   dato: prestamoArbol2;
   sig: listaPrestamos;
end;

prestamoSinISBN = record
	isbn: integer;
	lista: listaPrestamos;
end;

arbol2 = ^nodoArbol2;
nodoArbol2 = record
	dato: prestamoSinISBN;
	hi: arbol2;
	hd: arbol2;
end;

{---------- ESTRUCTURAS ARBOL 3 y 4 --------}
{cantPrestado = record
	vecesPrestado: integer;
end;}
isbnYCant = record
	isbn: integer;
	cant: integer;
end;
arbol3 = ^nodoArbol3;
nodoArbol3 = record
	dato: isbnYCant;
	hi: arbol3;
	hd: arbol3;
end;



//----------------- MODULOS -------------------//

procedure procesarPrestamos(var a1: arbol1; var a2: arbol2);

	procedure leer(var p: prestamo);
	begin
		p.isbn := random(30);
		if (p.isbn <> 0)then begin
			p.numSocio:= 1 + random(100);
			p.dia:= 1 + random(31);
			p.mes:= 1 + random(12);
			p.diasPrestados:= 1 + random(100);
		end;
	end;
	
	procedure cargarArbol1(var a1: arbol1; p:prestamo);
	begin
		if (a1 = nil)then begin
			new(a1);
			a1^.dato:= p;
			a1^.hi:= nil;
			a1^.hd:= nil;
		end
		else
			if (p.isbn >= a1^.dato.isbn)then
				cargarArbol1(a1^.hd, p)
			else
				cargarArbol1(a1^.hi,p);
	end;
	
	procedure cargarArbol2(var a2: arbol2; p:prestamo);
	
			procedure cargarRegistro(var prestamo: prestamoArbol2; p: prestamo);
			begin
			  prestamo.numSocio:= p.numSocio;
			  prestamo.dia:= p.dia;
			  prestamo.mes:= p.mes;
			  prestamo.diasPrestados:= p.diasPrestados; 
			end;

			procedure agregarAdelante(var L: listaPrestamos; p: prestamoArbol2);
			var
				nue: listaPrestamos;
			begin
				new(nue);
				nue^.dato.numSocio:= p.numSocio;
				nue^.dato.dia:= p.dia;
				nue^.dato.mes:= p.mes;
				nue^.dato.diasPrestados:= p.diasPrestados;
				nue^.sig:= L;
				L:= nue;
			end;
		
	var
	  pArbol2: prestamoArbol2;
	begin
		if (a2 = nil)then begin
			new(a2);
			a2^.dato.isbn:= p.isbn;
			a2^.dato.lista:= nil;
			cargarRegistro(pArbol2, p);
			agregarAdelante(a2^.dato.lista, pArbol2);
			a2^.hi:= nil;
			a2^.hd:= nil;
		end
		else if (p.isbn = a2^.dato.isbn) then begin
			cargarRegistro(pArbol2, p);
			agregarAdelante(a2^.dato.lista, pArbol2);
		end
		else if (p.isbn > a2^.dato.isbn) then
			cargarArbol2(a2^.hd, p)
		else
			cargarArbol2(a2^.hi, p);
	end;
	
var
unPrestamo: prestamo;
begin
a1:= nil;
a2:= nil;

writeln('---- Carga de arboles y registros ----->');
leer(unPrestamo);
 while (unPrestamo.isbn <> 0) do begin
	cargarArbol1(a1, unPrestamo);
	cargarArbol2(a2,unPrestamo);
	leer(unPrestamo);
 end;
end;

procedure imprimirArbol1(a1: arbol1);
begin
	if(a1 <> nil)then begin
		imprimirArbol1(a1^.hi);
		writeln;
		write('ISBN: ', a1^.dato.isbn, ' - Numero de socio: ', a1^.dato.numSocio,
		' - Dia: ', a1^.dato.dia, ' del mes: ', a1^.dato.mes, ' - Cantidad de dias prestados: ', a1^.dato.diasPrestados, '.');
		writeln;
		imprimirArbol1(a1^.hd);
	end;
end;

procedure imprimirArbol2(a2:arbol2);

		procedure recorrerLista(L:listaPrestamos);
		begin
			while (L <> nil) do begin
				writeln('Numero de socio: ', L^.dato.numSocio, ' - Dia: ', L^.dato.dia, ' del mes: ', L^.dato.mes, ' - Cantidad de dias prestados: ',
				L^.dato.diasPrestados, '.');
				L:= L^.sig;
			end;
		end;
		
begin
	if (a2 <> nil) then begin
		imprimirArbol2(a2^.hi);
		writeln;
		write('--- ISBN: ', a2^.dato.isbn, ' --- ');
		writeln;
		recorrerLista(a2^.dato.lista);
		writeln;
		imprimirArbol2(a2^.hd);
	end;
end;

function calcularMayorISBN(a1:arbol1):integer;
begin
	if (a1 = nil) then 
		calcularMayorISBN:= 0
	else 
		if (a1^.hd = nil) then
			calcularMayorISBN:= a1^.dato.isbn
		else
			calcularMayorISBN:= calcularMayorISBN(a1^.hd);
end;
{procedure calcularMayorISBN(a1: arbol1; var max: integer);
begin
	if (a1 <> nil) then begin
		if (a1^.dato.isbn > max) then
			max:= a1^.dato.isbn;
	
	calcularMayorISBN(a1^.hd, max);
	end;
end;}

function calcularMenorISBN(a2: arbol2): integer;
begin
	if (a2 = nil) then
		calcularMenorISBN:= 0
	else
		if (a2^.hi = nil) then
			calcularMenorISBN:= a2^.dato.isbn
		else
			calcularMenorISBN:= calcularMenorISBN(a2^.hi);
end;

function cantPrestamosSocio(a1: arbol1; num: integer): integer;
begin
	if (a1 = nil) then
		cantPrestamosSocio:= 0
	else
		if (a1^.dato.numSocio = num) then
			cantPrestamosSocio:= 1 + cantPrestamosSocio(a1^.hi, num) + cantPrestamosSocio(a1^.hd, num)
		else
			cantPrestamosSocio:= cantPrestamosSocio(a1^.hi, num) + cantPrestamosSocio(a1^.hd, num);
end;

procedure cantPrestamosSocioArbol2(a2: arbol2; num: integer; var cant: integer);

	procedure buscarSocioEnLista(L:listaPrestamos; num: integer; var cant: integer);
	begin
		while (L <> nil) do begin
			if (L^.dato.numSocio = num) then
				cant:= cant + 1;
			L:= L^.sig;
		end;
	end;

begin
	if (a2 = nil) then
		cant:= 0
	else begin
		if (a2^.dato.lista <> nil) then
			buscarSocioEnLista(a2^.dato.lista, num, cant);		
		if (a2^.hd <> nil) then
			cantPrestamosSocioArbol2(a2^.hd,num,cant);
		if (a2^.hi <> nil) then
			cantPrestamosSocioArbol2(a2^.hi,num,cant);
	end;
end;

procedure crearNuevoArbol(a1: arbol1; var a3: arbol3);

	procedure crearArbol3(isbn: integer; var a3: arbol3);
	begin
		if (a3 = nil) then begin
			new(a3);
			a3^.dato.isbn:= isbn;
			a3^.dato.cant:= 1;
			a3^.hi:= nil;
			a3^.hd:= nil;
		end
		else if (a3^.dato.isbn = isbn) then
			a3^.dato.cant:= a3^.dato.cant + 1
		else
			if (a3^.dato.isbn > isbn) then
				crearArbol3(isbn, a3^.hi)
			else
				crearArbol3(isbn, a3^.hd);
	end;
	
begin
	if (a1 <> nil) then
		crearArbol3(a1^.dato.isbn, a3);
	if (a1^.hd <> nil) then
		crearNuevoArbol(a1^.hd, a3);
	if (a1^.hi <> nil) then
		crearNuevoArbol(a1^.hi, a3);
end;

procedure imprimirArbol3(a3: arbol3);
begin
	if (a3 <> nil) then begin
		imprimirArbol3(a3^.hi);
		writeln;
		write('ISBN: ', a3^.dato.isbn, ' - Cantidad de veces que se presto: ', a3^.dato.cant);
		writeln;
		imprimirArbol3(a3^.hd);
	end;
end;

procedure crearOtroNuevoArbol(a2: arbol2; vecesPrestado: integer; var a4: arbol3);

	procedure calcularVecesQueSePresto(L: listaPrestamos; var cant: integer);
	begin
		while (L <> nil) do begin
			cant:= cant + 1;
			L:= L^.sig;
		end;
	end;

	procedure crearArbol4(isbn: integer; cant: integer; var a4: arbol3);
	begin
		if (a4 = nil) then begin
			new(a4);
			a4^.dato.isbn:= isbn;
			a4^.dato.cant:= cant;
			a4^.hi:= nil;
			a4^.hd:= nil;
		end
		else
			if (a4^.dato.isbn = isbn) then
				a4^.dato.cant:= a4^.dato.cant + 1
			else
				if (a4^.dato.isbn > isbn) then
					crearArbol4(isbn,cant, a4^.hi)
				else
					crearArbol4(isbn,cant, a4^.hd);
	end;
	
begin
vecesPrestado:= 0;

	if (a2 <> nil) then begin
		if (a2^.dato.lista = nil) then
			vecesPrestado:= 0
		else begin
			calcularVecesQueSePresto(a2^.dato.lista, vecesPrestado);
			crearArbol4(a2^.dato.isbn, vecesPrestado, a4);
		end;
	end;
	
	if (a2^.hd <> nil) then
		crearOtroNuevoArbol(a2^.hd, vecesPrestado, a4);
	if (a2^.hi <> nil) then
		crearOtroNuevoArbol(a2^.hi, vecesPrestado, a4);
end;

procedure imprimirArbol4(a4: arbol3);
begin
	if (a4 <> nil) then begin
		imprimirArbol4(a4^.hi);
		writeln;
		write('ISBN: ', a4^.dato.isbn, ' - Cantidad de veces que se presto: ', a4^.dato.cant);
		writeln;
		imprimirArbol4(a4^.hd);
	end;
end;

//----------- PROG. PRINCIPAL -----------------//
var
a1: arbol1;
a2: arbol2;
a3: arbol3;
a4: arbol3;
//isbnMax: integer;
num, prestamosArbol1, cant, vecesPrestado: integer;
begin
Randomize;
procesarPrestamos(a1,a2);  {inciso A}
writeln('--- ARBOL 1 ordenado por ISBN --->');
imprimirArbol1(a1);
writeln;

writeln('--- ARBOL 2, lista por isbn  --->');
imprimirArbol2(a2);
writeln;

writeln('--- Inciso B  --->');
{isbnMax:= 0;
calcularMayorISBN(a1, isbnMax);
write('ISBN mas grande: ', isbnMax);}
write('ISBN mas grande: ', calcularMayorISBN(a1)); {inciso B}
writeln;

writeln;
writeln('--- Inciso C  --->');
write('ISBN mas chico: ', calcularMenorISBN(a2));  {inciso C}
writeln;

writeln;
writeln('--- Inciso D  --->');
write('Ingrese numero de socio: '); readln(num);
prestamosArbol1 := cantPrestamosSocio(a1, num);
if (prestamosArbol1 <> 0) then
	write('Cantidad de prestamos realizados por el socio ', num, ': ', prestamosArbol1)
else
	write('El socio ', num, ' no ha realizado ningun prestamo.');
writeln;

writeln;
writeln('--- Inciso E  --->');
write('Ingrese numero de socio: '); readln(num);
cantPrestamosSocioArbol2(a2, num, cant);
if (cant <> 0) then
	write('Cantidad de prestamos realizados por el socio ', num, ': ', cant)
else
	write('El socio ', num, ' no ha realizado ningun prestamo.');
writeln;

writeln;cantPrestamosSocioArbol2
writeln('--- Inciso F  --->');
a3:= nil;
crearNuevoArbol(a1,a3);
writeln('--- ARBOL 3 ----->');
imprimirArbol3(a3);
writeln;

writeln;
writeln('--- Inciso G  --->');
a4:= nil;
vecesPrestado:= 0;
crearOtroNuevoArbol(a2, vecesPrestado, a4);
writeln('--- ARBOL 4 ----->');
imprimirArbol4(a4);  					{inciso H}
writeln;
end.
