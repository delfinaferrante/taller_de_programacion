program ejercicio1;
type
rangoEdad = 12..100;
cadena15 = string[15];

  socio = record
    num: integer;
    nombre: cadena15;
    edad: rangoEdad;
  end;
 
  arbol = ^nodoArbol;
  nodoArbol = record
    dato: socio;
    hi: arbol;
    hd: arbol;
  end;

//----------- MODULOS --------------------------------------------------
 procedure crearArbol(var a: arbol);
	
	procedure leer(var s: socio);
	var
	  vNombres: array [0..9] of string = ('Ana', 'Jose', 'Luis', 'Ema', 'Ariel', 'Pedro', 'Lena', 'Lisa', 'Martin', 'Lola'); 
	begin
	  s.num := random (51) * 100;   
	  if (s.num <> 0) then begin
		s.nombre := vNombres[random(10)];
		s.edad := 12 + random(79);
	  end;
	end;
 
	procedure agregarANodo(var a: arbol; s: socio);
	var
	  nue: arbol;
	begin
	  if (a = nil) then begin
	    new(nue);
	    nue^.dato:= s;
	    nue^.hi := nil;
	    nue^.hd := nil;
	    a := nue;
	  end
	  else 
	    if(s.num < a^.dato.num) then
		   agregarANodo(a^.hi, s)
        else
           agregarANodo(a^.hd, s);
	  end;
 
 var
  unSocio: socio;
 begin
  writeln;
  writeln ('----- Ingreso de socios y armado del arbol ----->');
  writeln;
  a:= nil;
  
  leer(unSocio);
  while (unSocio.num <> 0) do begin
     agregarANodo(a, unSocio);
     leer(unSocio);
  end;
 end;
 
procedure mostrarDatosSocio(s: socio);
begin
  writeln('Numero de socio: ', s.num);
  writeln('Nombre: ', s.nombre);
  writeln('Edad: ', s.edad);
  writeln;
end;

procedure informarSociosOrdenCreciente(a: arbol);
begin
   if ((a <> nil) and (a^.hi <> nil)) then 
     informarSociosOrdenCreciente (a^.HI);
   
   mostrarDatosSocio(a^.dato);

   if ((a <> nil) and (a^.hd <> nil)) then 
     informarSociosOrdenCreciente (a^.HD);
end;

procedure informarSociosOrdenDecreciente(a: arbol);
begin
 if (a <> nil) then begin
   informarSociosOrdenDecreciente(a^.hd);
   mostrarDatosSocio(a^.dato);
   informarSociosOrdenDecreciente(a^.hi);
 end;
end;

function codMayorEdad(a:arbol): integer;
var
 maxTotal, maxDer, maxIzq: integer;
begin
  if (a = nil) then
    codMayorEdad:= 0  //si esta vacio retorna 0 
  else
  begin
    maxDer:= codMayorEdad(a^.hd);
    maxIzq:= codMayorEdad(a^.hi);
    
    maxTotal:= a^.dato.edad;  //inicializo variable con la edad del nodo actual
    
    if (a^.hi <> nil) and (a^.hi^.dato.edad > a^.dato.edad) then  //si existe el arbol izq y ademas la edad q tiene es mayor a la del nodo actual
       maxTotal:= maxIzq;
    if (a^.hd <> nil) and (a^.hd^.dato.edad > a^.dato.edad) then  //si existe el arbol izq y ademas la edad q tiene es mayor a la del nodo actual
       maxTotal:= maxDer;

    codMayorEdad:= maxTotal;
 end;
end;

//------------ PROG PRINCIPAL ------------------------------------------
var
 a: arbol;
begin
 Randomize;
 crearArbol(a);  {inciso A}
 
 writeln ('----- Mostrar socios en Orden Creciente  ----->');
 writeln;
 informarSociosOrdenCreciente(a);    {inciso B - i}
 
 writeln ('----- Mostrar socios en Orden Decreciente  ----->');
 writeln;
 informarSociosOrdenDecreciente(a);  {inciso B - ii}
 
writeln ('----- Numero de socio con mayor edad  ----->');
writeln;
write('El socio con mayor edad es: ', codMayorEdad(a));
end.
