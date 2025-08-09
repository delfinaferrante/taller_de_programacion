program ejercicio3;
type
 rangoDias = 1..31;
 rangoMeses = 1..12;
 rangoAnios = 2020..2024; 
 
  regFecha = record
    dia: rangoDias;
    mes: rangoMeses;
    anio: rangoAnios;
  end;
  
  finales = record
    codMateria: integer;
    fecha: regFecha;
    nota: real;
  end;
  
  listaFinales = ^nodoLista;
  nodoLista = record
    dato: finales;
    sig: listaFinales;
  end;
  
  alumno = record
    legajo: integer;
    finales: listaFinales;
  end;
  
  arbol = ^nodoArbol;
  nodoArbol = record
    dato: alumno;
    hi: arbol;
    hd: arbol;
  end;	

//----------------------- MODULOS ----------------------------
procedure cargarDatos(var a: arbol);

	procedure leer(var a: alumno; var f: finales);
	begin
		a.legajo:= random(20);
		//write('Ingrese legajo: '); readln(a.legajo);
		if (a.legajo <> 0) then begin
			f.codMateria:= 1 + random(50);
			f.fecha.dia:= 1 + random(31);
			f.fecha.mes:= 1 + random(12);
			f.fecha.anio:= 2020 + random(5); 
			f.nota:= 1 + random(10);
			//write('Ingrese nota: '); readln(f.nota); 
		end;
	end;
	
	procedure agregarAdelante(var L: listaFinales; f: finales);
	var
		nue: listaFinales;
	begin
		new(nue);
		nue^.dato.codMateria:= f.codMateria;
		nue^.dato.fecha.dia:= f.fecha.dia;
		nue^.dato.fecha.mes:= f.fecha.mes;
		nue^.dato.fecha.anio:= f.fecha.anio;
		nue^.dato.nota:= f.nota;
		nue^.sig:= L;
		L := nue;
	end;
	
	procedure crearArbol(var a: arbol; alum: alumno; f: finales);	
	var
		nue: arbol;
	begin
		if (a = nil) then begin
			new(nue);
			nue^.dato.legajo:= alum.legajo;
			nue^.dato.finales := nil;
			agregarAdelante(nue^.dato.finales, f);
			nue^.hi:= nil;
			nue^.hd:= nil;
			a:= nue;
		end
		else if (a^.dato.legajo = alum.legajo) then
			agregarAdelante(a^.dato.finales, f)
		else if(a^.dato.legajo > alum.legajo) then
			crearArbol(a^.hi, alum, f)
		else
			crearArbol(a^.hd, alum, f);
	end;
	

var
unAlumno: alumno;
unFinal: finales;
begin
  leer(unAlumno, unFinal);
  while(unAlumno.legajo <> 0) do begin
     crearArbol(a, unAlumno, unFinal);
     leer(unAlumno, unFinal);
  end;
end;

procedure imprimirArbol(a: arbol);

	procedure recorroLista(l: listaFinales);
	begin
	  while (l <> nil) do begin
	    write('Codigo de materia: ', l^.dato.codMateria, '. ');
	    write('Fecha: ', l^.dato.fecha.dia, '/', l^.dato.fecha.mes, '/', l^.dato.fecha.anio, '. ');
	    writeln('Nota: ', l^.dato.nota:2:2);
	    l:= l^.sig;
	  end;
	end;
	
begin
  if (a <> nil) then begin
     imprimirArbol(a^.hi);
     write('Legajo: ', a^.dato.legajo);
     writeln;
     recorroLista(a^.dato.finales);
     writeln;
     imprimirArbol(a^.hd);
  end;
end;

function cantLegImpar(a: arbol): integer;
begin
  if (a = nil) then
	cantLegImpar:= 0
  else begin
    if ( (a^.dato.legajo mod 2) <> 0) then
       cantLegImpar:= 1 + cantLegImpar(a^.hd) + cantLegImpar(a^.hi)
    else
       cantLegImpar:= cantLegImpar(a^.hd) + cantLegImpar(a^.hi);
   end;
end;

procedure informarAlumnosAprobados(a:arbol);

	function finalesAprobados(L: listaFinales): integer;
	var
	  cant: integer;
	begin
	  cant:= 0;
	  while (L <> nil) do begin
	    if (L^.dato.nota >= 4) then
			cant:= cant + 1;
		
		L:= L^.sig;
	  end;
	  finalesAprobados:= cant;
	end;
	
begin
	if (a <> nil) then begin
	  informarAlumnosAprobados(a^.hi);
	  writeln;
	  write('Legajo: ', a^.dato.legajo);
	  writeln(' - Cantidad de finales aprobados: ', finalesAprobados(a^.dato.finales));
	  informarAlumnosAprobados(a^.hd);
    end;
end;

procedure calcularPromedios(a: arbol; valor: real);

	function verificarPromedio(L:listaFinales): real;
	var
	  sumaNotas:real;
	  cantMaterias: integer;
	begin
      sumaNotas:= 0;
      cantMaterias:= 0;
		while (L <> nil) do begin
		  sumaNotas:= sumaNotas + L^.dato.nota;
		  cantMaterias:= cantMaterias + 1;
		  L:= L^.sig;
		end;
		verificarPromedio:= (sumaNotas/cantMaterias);
	end;

begin
  if (a <> nil) then begin
      calcularPromedios(a^.hi, valor);
      
      if (verificarPromedio(a^.dato.finales) > valor) then begin
		write('Legajo: ', a^.dato.legajo);
		write(' - Promedio: ', verificarPromedio(a^.dato.finales):2:2);
		writeln;
     end
     else begin
       writeln('El alumno ', a^.dato.legajo, ' no supera el promedio.');
       calcularPromedios(a^.hd, valor);
     end;
  end;
end;

//----------------------- PROG. PRINC ----------------------------
var
a: arbol;
valor: real;
begin
writeln('--- INCISO A --->');
cargarDatos(a);
writeln('------ ARBOL DE LISTAS ------>');
imprimirArbol(a);

writeln('--- INCISO B --->');
write('Cantidad de alumnos con legajo impar: ', cantLegImpar(a)); 
writeln;

writeln;
writeln('--- INCISO C --->');
informarAlumnosAprobados(a);
writeln;

writeln('--- INCISO D --->');
write('Ingrese un valor de tipo real: '); 
readln(valor);
calcularPromedios(a, valor);
end.
