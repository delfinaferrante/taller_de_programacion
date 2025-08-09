program parcial2;
type
  subrangoMes = 1..12;
  
  atencion = record
	matricula: integer;
	dnipaciente: integer;
	mes: integer;
	diagnostico: char;
  end;
  
  r_arbol = record
	dnipaciente: integer;
	diagnostico: char;
  end;
  
  arbol = ^nodoArbol;
  nodoArbol = record
	dato: r_arbol;
	hi: arbol;
	hd: arbol;
  end;
  
  vector = array [subrangoMes] of arbol;
  
// ------------ MODULOS -------------------

procedure inicializar(var v: vector);
var
  i: subrangoMes;
begin
  for i:= 1 to 12 do
	v[i]:= nil;
end;

procedure cargarDatos(var v: vector);

	procedure leerAtencion(var a: atencion);
	var
	  v: array[1..5] of char =('L', 'M', 'N', 'O', 'P');
	begin
	  a.matricula:= random(100);
	  if (a.matricula <> 0) then begin
		a.dnipaciente:= random(5000) + 1000;
		a.mes:= random(12)+1;
		a.diagnostico:= v[random(5)+1];
	  end;
	end;
	
	procedure crearVector(var a:arbol; at: atencion);
	begin
		if (a = nil) then begin
			new(a);
			a^.dato.dnipaciente:= at.dnipaciente;
			a^.dato.diagnostico:= at.diagnostico;
			a^.hi:= nil;
			a^.hd:= nil;
		end
		else if (at.dnipaciente > a^.dato.dnipaciente) then
			crearVector(a^.hd, at)
		else
			crearVector(a^.hi, at);
	end;
	
var
 unaAtencion: atencion;	
begin
 leerAtencion(unaAtencion);
 while(unaAtencion.matricula <> 0) do begin
	crearVector(v[unaAtencion.mes], unaAtencion);
	leerAtencion(unaAtencion);
 end;
end;

procedure imprimirVector(v: vector);

	procedure recorroArbol(a:arbol);
	begin
		if (a <> nil) then begin
			recorroArbol(a^.hi);
			writeln;
			write('Dni del paciente: ', a^.dato.dnipaciente, ' -Diagnostico: ', a^.dato.diagnostico);
			writeln;
			recorroArbol(a^.hd);	
		end;
	end;
	
var
  i: subrangoMes;
begin
  for i:= 1 to 12 do begin
	if (v[i] <> nil) then begin
		write('-- Mes ', i, ' --');
		recorroArbol(v[i]);
		writeln;
	end
	else 
		write('Mes ', i, ' sin atenciones.');
		
  end;
end;

procedure mesMasAtenciones(i: integer; v: vector; var max, mes: integer);

	function cuentoAtenciones(a: arbol): integer;
	begin
		if (a = nil) then
			cuentoAtenciones:= 0
		else
			cuentoAtenciones:= 1 + cuentoAtenciones(a^.hd) + cuentoAtenciones(a^.hi);
	end;

begin
	if (i <> 0) then begin
		mesMasAtenciones(i-1, v, max, mes);
		
		if (cuentoAtenciones(v[i]) > max) then begin
			writeln('Mes ', i, ', cant de atenciones: ', cuentoAtenciones(v[i]));
			max:= cuentoAtenciones(v[i]);
			mes:= i;
		end;
	end;
end;

function fueAtendido(v:vector; dni:integer): boolean;

	function buscoEnArbol(a:arbol; dni: integer):boolean;
	begin
		if (a = nil) then
			buscoEnArbol:= false
		else
			if (a^.dato.dnipaciente = dni) then
				buscoEnArbol:= true
			else if (a^.dato.dnipaciente > dni) then
				buscoEnArbol:= buscoEnArbol(a^.hi,dni)
			else
				buscoEnArbol:= buscoEnArbol(a^.hd,dni);
	end;
	
var
 i: integer;
 encontre: boolean;
begin
  encontre:= false;
  i:= 1;
 
  while (i <= 12) and (not encontre) do begin
	encontre:= buscoEnArbol(v[i], dni);
	i:= i+1;
  end;
 fueAtendido:= encontre;
end;


// ------------ PROG. PRINC ------------------
var
 v: vector;
 max, dimF, mes, dni: integer;
begin
 inicializar(v);
 cargarDatos(v);
 write('--- Vector ---');
 writeln;
 imprimirVector(v);
 writeln;
 max:= -1;
 dimF:= 12;
 mesMasAtenciones(dimF, v, max, mes);
 writeln('El mes con mas atenciones fue: ', mes);
 writeln;
 
 write('Ingrese un dni del paciente: '); readln(dni);
 if (fueAtendido(v, dni)) then
	writeln('El paciente con dni ', dni, ' fue atendido.')
 else
	writeln('El paciente con dni ', dni, ' no fue atendido.');

end.
