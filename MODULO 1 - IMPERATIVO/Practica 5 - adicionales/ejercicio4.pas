program ejercicio4;
type

reclamo = record
	dni: integer;
	cod: integer;
	anio: integer;
	tipo: string;
end;

reclamoSinDni = record
	cod: integer;
	anio: integer;
	tipo: string;
end;

lista = ^nodoLista;
nodoLista = record
	dato: reclamoSinDni;
	sig: lista;
end;

infodni = record
	dni: integer;
	cantReclamos: integer;
	reclamos: lista;
end;

arbol = ^nodoArbol;
nodoArbol = record
	dato: infodni;
	hi: arbol;
	hd: arbol;
end;

//---------- MODULOS ----------------
procedure cargarDatos(var a: arbol);

	procedure leer(var r: reclamo);
	var
		vTipo: array[1..6] of string =('comercial', 'administrativo', 'espera', 'tecnico', 'interrupcion', 'fallos');
	begin
		r.cod := random(20);
		if (r.cod <> 0) then begin
			write('Ingrese un DNI: '); readln(r.dni);
			r.anio:= 2010 + random(15);
			r.tipo:= vTipo[1 + random(6)];
		end;
	end;
	
	procedure crearArbol(var a: arbol; r: reclamo);
	
		procedure cargarRegistro(r: reclamo; var sinDni: reclamoSinDni);
		begin
			sinDni.cod:= r.cod;
			sinDni.anio:= r.anio;
			sinDni.tipo:= r.tipo;
		end;
	
		procedure agregarAdelante(var L: lista; r: reclamoSinDni);
		var
		 nue: lista;
		begin
		 new(nue);
		 nue^.dato:= r;
		 nue^.sig:= L;
		 L:= nue;
		end;
	
	var
		r_sinDni:reclamoSinDni;
	begin
		if (a = nil) then begin
			new(a);
			a^.dato.dni:= r.dni;
			a^.dato.cantReclamos:= 1;
			a^.dato.reclamos:= nil;
			cargarRegistro(r, r_sinDni);
			agregarAdelante(a^.dato.reclamos, r_sinDni);
			a^.hi:= nil;
			a^.hd:= nil;
		end
		else if(a^.dato.dni = r.dni) then begin
			a^.dato.cantReclamos:= a^.dato.cantReclamos + 1;
			cargarRegistro(r, r_sinDni);
			agregarAdelante(a^.dato.reclamos, r_sinDni);
		end
		else if (a^.dato.dni > r.dni) then
			crearArbol(a^.hi, r)
		else
			crearArbol(a^.hd,r);
	end;

var
 unReclamo: reclamo;
begin
 a:= nil;
 leer(unReclamo);
 while (unReclamo.cod <> 0) do begin
	crearArbol(a, unReclamo);
	leer(unReclamo);
 end;
end;

procedure mostrarArbol(a:arbol);

	procedure imprimirLista(L:lista);
	begin
		while (L <> nil) do begin
			writeln;
			write('Codigo: ', L^.dato.cod, ' - Anio: ', L^.dato.anio, ' - Tipo de reclamo: ', L^.dato.tipo);
			writeln;
			L:= L^.sig;
		end;
	end;
	
begin
	if (a <> nil) then begin
		mostrarArbol(a^.hi);
		writeln;
		write(' -- DNI: ', a^.dato.dni, ' --');
		if (a^.dato.reclamos <> nil) then
			imprimirLista(a^.dato.reclamos);
			
		writeln;
		mostrarArbol(a^.hd);
	end;
end;

function cantidadReclamos(a:arbol; dni:integer): integer;
begin
	if (a = nil) then
		cantidadReclamos:= 0
	else
		if(a^.dato.dni = dni) then
			cantidadReclamos:= a^.dato.cantReclamos
		else if (a^.dato.dni > dni) then
			cantidadReclamos:= cantidadReclamos(a^.hi,dni)
		else
			cantidadReclamos:= cantidadReclamos(a^.hd,dni);
end;

function reclamosDentroDeRango(a: arbol; dni1, dni2: integer): integer;

	function contarReclamos(L:lista): integer;
	var
	  cant: integer;
	begin
	  cant:= 0;
		while(L <> nil) do begin
			cant:= cant + 1;
			L:= L^.sig;
		end;
		contarReclamos:= cant;
	end;

var
  cantR: integer;
begin
	if (a = nil) then
		reclamosDentroDeRango:= 0
	else begin
		if (a^.dato.dni > dni1) and (a^.dato.dni < dni2) then begin
			cantR:= contarReclamos(a^.dato.reclamos);
			reclamosDentroDeRango:= cantR + reclamosDentroDeRango(a^.hd,dni1,dni2) + reclamosDentroDeRango(a^.hi,dni1,dni2)
		end
		else if (a^.dato.dni < dni1) then
			reclamosDentroDeRango:= reclamosDentroDeRango(a^.hd, dni1,dni2)
		else
			reclamosDentroDeRango:= reclamosDentroDeRango(a^.hi,dni1,dni2);
	end;
end;

procedure reclamosRecibidos(a:arbol; anio: integer);

	procedure buscoEnLista(L:lista; anio: integer);
	begin
		if (L <> nil) then begin
			if (L^.dato.anio = anio) then
				writeln('Reclamos en el anio ', anio, ' - Codigo: ', L^.dato.cod)
			else
				L:= L^.sig;
		end;
	end;

begin
	if (a <> nil) then begin
		writeln;
		buscoEnLista(a^.dato.reclamos, anio);
		reclamosRecibidos(a^.hi,anio);
		reclamosRecibidos(a^.hd,anio);
	end;
end;

//---------- PROG. PRINCIPAL -------
var
a: arbol;
dni, cant, dni1, dni2, cant2, anio: integer;
begin
Randomize;
cargarDatos(a);  {inciso A}
mostrarArbol(a);

writeln;
write('Ingrese un DNI: '); readln(dni);
cant:= cantidadReclamos(a, dni);  {inciso B}
if ( cant = 0) then
	writeln('El dni ', dni, ' no realizo ningun reclamo.')
else
	writeln('El dni ', dni, ' realizo ', cant, ' reclamos. ');
	
writeln;
write('Ingrese primer dni: '); readln(dni1);
write('Ingrese segundo dni: '); readln(dni2);
cant2:= reclamosDentroDeRango(a, dni1, dni2);  {inciso C}
if (cant2 = 0) then
	writeln('Dentro del rango de DNI (', dni1, ', ', dni2, ') no hay ningun reclamo.')
else
	writeln('Dentro del rango de DNI (', dni1, ', ', dni2, ') hay ', cant2, ' reclamos.');
	
writeln;
write('Ingrese un anio entre 2010 y 2024: '); readln(anio);
reclamosRecibidos(a, anio);
end.
