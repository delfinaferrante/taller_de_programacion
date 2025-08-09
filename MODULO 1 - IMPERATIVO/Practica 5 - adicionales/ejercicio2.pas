program ejercicio2;
type
cadena7 = string[7];
rango1 = 2010..2018;

{------- ARBOL 1 ---------}
auto = record
	patente: cadena7;
	anio: rango1;
	marca: string;
	modelo: string;
end;

arbol1 = ^nodoArbol1;
nodoArbol1 = record
	dato: auto;
	hi: arbol1; 
	hd: arbol1;
end;

{------- ARBOL 2 ---------}
autoSinMarca = record
	patente: cadena7;
	anio: rango1;
	modelo: string;
end;

lista = ^nodoLista;
nodoLista = record
	dato: autoSinMarca;
	sig: lista;
end;

marcaYLista = record
	marca: string;
	info: lista;
end;

arbol2 = ^nodoArbol2;
nodoArbol2 = record
	dato: marcaYLista;
	hi: arbol2; 
	hd: arbol2;
end;

{------- VECTOR POR AÑO DE FABRIC ---------}
regSinAnio = record
	patente: cadena7;
	marca: string;
	modelo: string;
end;

listaV = ^nodoListaV;
nodoListaV = record
	dato: regSinAnio;
	sig: listaV;
end;
vectorAnios = array [rango1] of listaV;

//------ MODULOS -------------->> 

procedure procesarDatos(var a1: arbol1; var a2: arbol2);

	procedure leer(var a: auto);
	begin
		writeln;
		write('Marca: '); readln(a.marca);
		if (a.marca <> 'mmm') then begin
			write('Patente: '); readln(a.patente);
			a.anio:= 2010 + random(9);
			write('Modelo: '); readln(a.modelo);
		end;
	end;

	procedure crearArbol1(var a1: arbol1; a: auto);
	begin
		if (a1 = nil) then begin
			new(a1);
			a1^.dato:= a;
			a1^.hi:= nil;
			a1^.hd:= nil;
		end
		else if (a1^.dato.patente <= a.patente) then
			crearArbol1(a1^.hd, a)
		else
			crearArbol1(a1^.hi, a);
	end;

	procedure crearArbol2(var a2: arbol2; a: auto);
	
		procedure cargarRegistro(var info: autoSinMarca; a: auto);
		begin
			info.patente:= a.patente;
			info.modelo:= a.modelo;
			info.anio:= a.anio;
		end;
		
		procedure agregarAdelante(var L: lista; info: autoSinMarca);
		var
			nue: lista;
		begin
			new(nue);
			nue^.dato:= info;
			nue^.sig:= L;
			L:= nue;
		end;
	
	var
		infoAuto: autoSinMarca;
	begin
		if (a2 = nil) then begin
			new(a2);
			a2^.dato.marca:= a.marca;
			a2^.dato.info:= nil;
			cargarRegistro(infoAuto, a);
			agregarAdelante(a2^.dato.info, infoAuto);
			a2^.hi:= nil;
			a2^.hd:= nil;
		end
		else if (a2^.dato.marca = a.marca) then begin
			cargarRegistro(infoAuto, a);
			agregarAdelante(a2^.dato.info, infoAuto);
		end
		else if (a2^.dato.marca > a.marca) then
			crearArbol2(a2^.hi, a)
		else
			crearArbol2(a2^.hd, a);
	end;

var
 unAuto: auto;
begin
 leer(unAuto);
 while(unAuto.marca <> 'mmm') do begin
	crearArbol1(a1, unAuto);
	crearArbol2(a2, unAuto);
	leer(unAuto);
 end;
end;

procedure imprimirArbol1(a1: arbol1);
begin
	if (a1 <> nil) then begin
		imprimirArbol1(a1^.hi);
		writeln;
		write('Patente: ', a1^.dato.patente, ' - Anio: ', a1^.dato.anio, ' - Marca: ', a1^.dato.marca, ' - Modelo: ', a1^.dato.modelo);
		writeln;
		imprimirArbol1(a1^.hd);
	end;
end;

procedure imprimirArbol2(a2:arbol2);

	procedure mostrarLista(L:lista);
	begin
		while (L <> nil) do begin
			writeln;
			write('Patente: ', L^.dato.patente, ' - Anio: ', L^.dato.anio, ' - Modelo: ', L^.dato.modelo);
			L:= L^.sig;
		end;
	end;
	
begin
	if(a2 <> nil) then begin
		imprimirArbol2(a2^.hi);
		writeln;
		write('--- MARCA: ', a2^.dato.marca, ' ---');
		writeln;
		if (a2^.dato.info <> nil) then
			mostrarLista(a2^.dato.info);
		writeln;
		imprimirArbol2(a2^.hd);	
	end;
end;

function autosConMarca(a1:arbol1; marca: string): integer;
begin
	if (a1 = nil) then
		autosConMarca:= 0
	else
		if (a1^.dato.marca = marca) then
			autosConMarca:= 1 + autosConMarca(a1^.hd, marca) + autosConMarca(a1^.hi,marca)
		else
			autosConMarca:= autosConMarca(a1^.hd,marca) + autosConMarca(a1^.hi,marca);
end;

function autosConMarca(a2:arbol2; marca:string; cant: integer): integer;

	function cuentoAutos(L:lista): integer;
	var
	 cant: integer;
	begin
	 cant:= 0;
		while(L <> nil) do begin
			cant:= cant + 1;
			L:= L^.sig;
		end;
		cuentoAutos:= cant;
	end;
	
begin
	if (a2 = nil) then
		autosConMarca:= 0
	else begin
		if (marca > a2^.dato.marca) then
			autosConMarca:= autosConMarca(a2^.hd,marca,cant)
		else 
			if (marca < a2^.dato.marca) then
				autosConMarca:= autosConMarca(a2^.hi,marca,cant)
			else
				if (marca = a2^.dato.marca) then begin
					if (a2^.dato.info <> nil) then 
						cant:= cuentoAutos(a2^.dato.info);
					autosConMarca:= cant + autosConMarca(a2^.hd,marca,cant) + autosConMarca(a2^.hi,marca,cant);
				end;
	end;
end;


procedure inicializoVector(var v: vectorAnios);
var
  i: rango1;
begin
  for i:= 2010 to 2018 do
	v[i]:= nil;
end;

procedure crearVectorAnios(a1: arbol1; var v: vectorAnios);

	procedure cargarRegistro(a: auto; var r: regSinAnio);
	begin
		r.patente:= a.patente;
		r.marca:= a.marca;
		r.modelo:= a.modelo;
	end;

	procedure crearLista(var L: listaV; r: regSinAnio);
	var
	  nue: listaV;
	begin
	  new(nue);
	  nue^.dato:= r;
	  nue^.sig:= L;
	  L:= nue;
	end;

var
  rSinAnio: regSinAnio;
begin 
	if (a1 <> nil) then begin
		cargarRegistro(a1^.dato, rSinAnio);
		crearLista(v[a1^.dato.anio], rSinAnio);
	end;	
	
	if (a1^.hd <> nil) then	
		crearVectorAnios(a1^.hd, v);
		
	if (a1^.hi <> nil) then
		crearVectorAnios(a1^.hi, v);

end;

procedure imprimirVector(v: vectorAnios);

	procedure imprimir(L:listaV);
	begin
	  while (L <> nil) do begin
			write('Patente: ', L^.dato.patente, ' - Marca: ', L^.dato.marca, ' - Modelo: ', L^.dato.modelo);
			writeln;
			L:= L^.sig;
	  end;
	end;
var
 i: rango1;
begin
 for i:= 2010 to 2018 do begin
	writeln('-- Anio de fabricación: ', i, ' --');
	if (v[i] <> nil) then begin
		imprimir(v[i]);
		writeln;
	end
	else
		write('En este anio no hay autos. ');
 end;
end;

procedure modeloAuto(a1: arbol1; patente: string; var modelo: string);
begin
	if (a1 = nil) then
		modelo:= 'nohay'
	else
		if (a1^.dato.patente = patente) then
			modelo:= a1^.dato.modelo
		else
			if (a1^.dato.patente > patente) then
				modeloAuto(a1^.hi, patente, modelo)
			else
				modeloAuto(a1^.hd,patente,modelo);
end;

procedure modeloAutoArbol2(a2: arbol2; patente: string; var modelo: string; var encontre: boolean);

	procedure buscoPatente(L: lista; patente: string; var modelo: string; var encontre: boolean);
	begin
		encontre:= false;
		while(L <> nil) and (not encontre) do begin
			if (L^.dato.patente = patente) then begin
				modelo:= L^.dato.modelo;
				encontre:= true;
			end
			else
				L:= L^.sig;
		end;	
	end;

begin
	if (a2 = nil) then
		modelo:= 'nohay'
	else begin
		if (a2^.dato.info <> nil) then 
			buscoPatente(a2^.dato.info, patente, modelo, encontre);
		
		if (not encontre) then begin
			modeloAutoArbol2(a2^.hd, patente, modelo, encontre);
			if (not encontre) then 		
				modeloAutoArbol2(a2^.hi, patente, modelo, encontre);
		end;
	end;
end;

//------ PROG. PRINCIPAL ------->> 
var
 a1:arbol1;
 a2: arbol2;
 cantAutos, cant: integer;
 marca, modelo: string;
 vecAnios: vectorAnios;
 patente: cadena7;
 encontre: boolean;
begin
 a1:= nil;
 a2:= nil;
 Randomize;

 procesarDatos(a1, a2);  {inciso A}
 writeln;
 writeln('----------- ARBOL 1 --------->');
 imprimirArbol1(a1);
 writeln;
 
 writeln;
 writeln('----------- ARBOL 2 --------->');
 imprimirArbol2(a2);
 writeln;
 
 writeln('--- INCISO B ----');
 writeln('Ingrese una marca: '); readln(marca);
 cantAutos:= autosConMarca(a1, marca);
 if (cantAutos <> 0) then
	writeln('Hay ', cantAutos, ' autos de la marca ', marca)
 else
	writeln('No hay autos de la marca ', marca);
	
 writeln;
 writeln('--- INCISO C ----');
 writeln('Ingrese una marca: '); readln(marca);
 cant:= 0;
 cantAutos:= autosConMarca(a2, marca, cant);
 if (cantAutos <> 0) then
	writeln('Hay ', cantAutos, ' autos de la marca ', marca)
 else
	writeln('No hay autos de la marca ', marca);
	
 writeln;
 writeln('--- INCISO D ----');
 inicializoVector(vecAnios);
 crearVectorAnios(a1, vecAnios);
 writeln;
 writeln('--- VECTOR ---->');
 imprimirVector(vecAnios);
 
 writeln;
 writeln('--- INCISO E ---');
 write('Ingrese una patente: '); readln(patente);
 modeloAuto(a1, patente, modelo);
 if (modelo = 'nohay') then
	write('La patente ', patente, ' no existe.')
 else
	write('El modelo del auto con patente ', patente, ' es: ', modelo);
	
 writeln;
 writeln('--- INCISO F ---');
 write('Ingrese una patente: '); readln(patente);
 modeloAutoArbol2(a2, patente, modelo, encontre);
 if (modelo = 'nohay') then
	write('La patente ', patente, ' no existe.')
 else
	write('El modelo del auto con patente ', patente, ' es: ', modelo);
end.
