Program ejercicio2;

type 
rangoEdad = 12..100;
cadena15 = string [15];
socio = record
  numero: integer;
  nombre: cadena15;
  edad: rangoEdad;
end;
arbol = ^nodoArbol;
nodoArbol = record
  dato: socio;
  HI: arbol;
  HD: arbol;
end;
     
procedure GenerarArbol (var a: arbol);
{ Implementar un modulo que almacene informacion de socios de un club en un arbol binario de busqueda. De cada socio se debe almacenar numero de socio, 
nombre y edad. La carga finaliza con el numero de socio 0 y el arbol debe quedar ordenado por numero de socio. La informacion de cada socio debe generarse
aleatoriamente. }

  Procedure CargarSocio (var s: socio);
  var vNombres:array [0..9] of string= ('Ana', 'Jose', 'Luis', 'Ema', 'Ariel', 'Pedro', 'Lena', 'Lisa', 'Martin', 'Lola'); 
  
  begin
    s.numero:= random (51) * 100;
    If (s.numero <> 0)
    then begin
           s.nombre:= vNombres[random(10)];
           s.edad:= 12 + random (79);
         end;
  end;  
  
  Procedure InsertarElemento (var a: arbol; elem: socio);
  Begin
    if (a = nil) 
    then begin
           new(a);
           a^.dato:= elem; 
           a^.HI:= nil; 
           a^.HD:= nil;
         end
    else if (elem.numero < a^.dato.numero) 
         then InsertarElemento(a^.HI, elem)
         else InsertarElemento(a^.HD, elem); 
  End;

var unSocio: socio;  
Begin
 writeln;
 writeln ('----- Ingreso de socios y armado del arbol ----->');
 writeln;
 a:= nil;
 CargarSocio (unSocio);
 while (unSocio.numero <> 0)do
  begin
   InsertarElemento (a, unSocio);
   CargarSocio (unSocio);
  end;
 writeln;
 writeln ('//////////////////////////////////////////////////////////');
 writeln;
end;

procedure InformarSociosOrdenCreciente (a: arbol);
{ Informar los datos de los socios en orden creciente. }
  
  procedure InformarDatosSociosOrdenCreciente (a: arbol);
  begin
    if ((a <> nil) and (a^.HI <> nil)) then 
		InformarDatosSociosOrdenCreciente (a^.HI);
    writeln ('Numero: ', a^.dato.numero, ' Nombre: ', a^.dato.nombre, ' Edad: ', a^.dato.edad);
    if ((a <> nil) and (a^.HD <> nil)) then 
		InformarDatosSociosOrdenCreciente (a^.HD);
  end;  

Begin
 writeln;
 writeln ('----- Socios en orden creciente por numero de socio ----->');
 writeln;
 InformarDatosSociosOrdenCreciente (a);
 writeln;
 writeln ('//////////////////////////////////////////////////////////');
 writeln;
end;

procedure InformarSociosOrdenDecreciente (a:arbol);
begin
	if ((a <> nil) and (a^.HD <> nil)) then 
		InformarSociosOrdenDecreciente (a^.HD);
    writeln ('Numero: ', a^.dato.numero, ' Nombre: ', a^.dato.nombre, ' Edad: ', a^.dato.edad);
    if ((a <> nil) and (a^.HI <> nil)) then 
		InformarSociosOrdenDecreciente (a^.HI);
end;

procedure InformarNumeroSocioConMasEdad (a: arbol);
{ Informar el numero de socio con mayor edad. Debe invocar a un modulo recursivo que retorne dicho valor.  }

     procedure actualizarMaximo(var maxValor,maxElem : integer; nuevoValor, nuevoElem : integer);
	begin
	  if (nuevoValor >= maxValor) then
	  begin
		maxValor := nuevoValor;
		maxElem := nuevoElem;
	  end;
	end;
	
	procedure NumeroMasEdad (a: arbol; var maxEdad: integer; var maxNum: integer);
	begin
	   if (a <> nil) then
	   begin
		  actualizarMaximo(maxEdad,maxNum,a^.dato.edad,a^.dato.numero);
		  numeroMasEdad(a^.hi, maxEdad,maxNum);
		  numeroMasEdad(a^.hd, maxEdad,maxNum);
	   end; 
	end;

var maxEdad, maxNum: integer;
begin
  writeln;
  writeln ('----- Informar Numero Socio Con Mas Edad ----->');
  writeln;
  maxEdad := -1;
  NumeroMasEdad (a, maxEdad, maxNum);
  if (maxEdad = -1) 
  then writeln ('Arbol sin elementos')
  else begin
         writeln;
         writeln ('Numero de socio con mas edad: ', maxNum);
         writeln;
       end;
  writeln;
  writeln ('//////////////////////////////////////////////////////////');
  writeln;
end;

procedure AumentarEdadNumeroImpar (a: arbol);
{Aumentar en 1 la edad de los socios con edad impar e informar la cantidad de socios que se les aumento la edad.}
  
  function AumentarEdad (a: arbol): integer;
  var resto: integer;
  begin
     if (a = nil) 
     then AumentarEdad:= 0
     else begin
            resto:= a^.dato.edad mod 2;
            if (resto = 1) then 
				a^.dato.edad:= a^.dato.edad + 1;
            AumentarEdad:= resto + AumentarEdad (a^.HI) + AumentarEdad (a^.HD);
          end;  
  end;

begin
  writeln;
  writeln ('----- Cantidad de socios con edad aumentada ----->');
  writeln;
  writeln ('Cantidad: ', AumentarEdad (a));
  writeln;
  writeln;
  writeln ('//////////////////////////////////////////////////////////');
  writeln;
end;

function InformarExistenciaNombreSocio (a:arbol;nombre:cadena15):boolean;
var
	retorna:boolean;
begin
	if (a = nil) then
		InformarExistenciaNombreSocio:= false
	else
		if (a^.dato.nombre = nombre) then
			InformarExistenciaNombreSocio:= true
	else begin
		retorna:= InformarExistenciaNombreSocio (a^.HI, nombre);
		if (not retorna) then
			retorna:= InformarExistenciaNombreSocio(a^.HD, nombre);
		InformarExistenciaNombreSocio:= retorna;	
	end;	
end;

function InformarCantidadSocios (a:arbol): integer;
begin
	if (a = nil) then
		InformarCantidadSocios:= 0
	else
		InformarCantidadSocios:= 1 + InformarCantidadSocios(a^.HI) + InformarCantidadSocios(a^.HD);						
end;

function InformarPromedioDeEdad(a:arbol): integer;
begin
	if (a = nil) then
		InformarPromedioDeEdad:= 0
	else
		InformarPromedioDeEdad:= a^.dato.edad + InformarPromedioDeEdad(a^.HI) + InformarPromedioDeEdad(a^.HD);
end;

function numSocioMasGrande(a: arbol): integer;
begin
  if (a = nil) then
    numSocioMasGrande:= 0
  else
     if (a^.HD = nil) then
         numSocioMasGrande:= a^.dato.numero
     else
        numSocioMasGrande:= numSocioMasGrande(a^.HD);
end;

procedure numSocioMasChico(a:arbol);
begin
  if (a <> nil) then begin
	if (a^.HI <> nil) then 
		numSocioMasChico(a^.HI)
	else begin
		writeln('Numero de socio con numero mas chico: ', a^.dato.numero, ' - Nombre: ', a^.dato.nombre, ' - Edad: ', a^.dato.edad);
		writeln;
	end;
  end;
end;

function existeSocio(a:arbol; num: integer): boolean;
begin
  if (a = nil) then
     existeSocio:= false
  else begin
    if (num = a^.dato.numero) then
       existeSocio:= true
    else if (num > a^.dato.numero) then
		existeSocio:= existeSocio(a^.HD, num)
    else
        existeSocio:= existeSocio(a^.HI, num);
  end;
end;

function cantSociosRango(a: arbol; cod1, cod2: integer): integer;
begin
  if(a = nil) then 
	cantSociosRango:= 0
  else
    if (a^.dato.numero <= cod2) then begin
		if (a^.dato.numero >= cod1) then
			cantSociosRango:= 1 + cantSociosRango(a^.HD,cod1,cod2) + cantSociosRango(a^.HI,cod1,cod2);
	end
	else if (a^.dato.numero < cod1) then
		cantSociosRango:= cantSociosRango(a^.HD,cod1,cod2)
	else
		cantSociosRango:= cantSociosRango(a^.HI,cod1,cod2);		
end;


// --------------- PROGRAMA PRINCIPAL ---------------- //
var 
	a: arbol;
	nombre:cadena15; 
	valor, cod1, cod2: integer;
Begin
  randomize;
  GenerarArbol (a);
  InformarSociosOrdenCreciente (a);
  InformarSociosOrdenDecreciente (a);
  InformarNumeroSocioConMasEdad (a);
  AumentarEdadNumeroImpar (a);
  writeln;
  writeln ('Ingrese un nombre de socio');
  read (nombre);
  writeln;

  if (InformarExistenciaNombreSocio (a,nombre)) then
	  writeln ('El nombre existe')
  else
	  writeln ('El nombre no existe');	
	writeln;  
    writeln('La cantidad de socios es: ', InformarCantidadSocios(a));
    writeln;

    writeln('El promedio de edad de todos los socios es: ', InformarPromedioDeEdad(a) / InformarCantidadSocios(a):2:0);
    
 writeln;
 writeln('------- Practica 4 -------->');
 writeln;
 
 writeln('-- Primer ejercicio -- ');
 writeln('Numero de socio mas grande: ', numSocioMasGrande(a));  {Informar el número de socio más grande. Debe invocar a un módulo recursivo que retorne dicho valor.}
 writeln;
 
 writeln('-- Segundo ejercicio --'); {Informar los datos del socio con el número de socio más chico. Debe invocar a un módulo recursivo que retorne dicho socio.}
 numSocioMasChico(a);
 writeln;
 
 writeln('-- Tercer ejercicio --'); {Leer un valor entero e informar si existe o no existe un socio con ese valor. Debe invocar a un módulo recursivo que reciba el valor leído y retornar verdadero o falso.}
 write('Ingrese un valor: '); readln(valor);
 if (existeSocio(a, valor)) then
  	writeln('El socio con numero ', valor, ' existe.')
 else
    writeln('El socio con numero ', valor, ' no existe.');
 
 writeln;
 writeln('-- Cuarto ejercicio --'); {Leer e informar la cantidad de socios cuyos códigos se encuentran comprendidos entre los valores leídos. Debe invocar a un módulo recursivo que reciba los valores
									leídos y retorne la cantidad solicitada}
 write('Primer valor del rango: '); readln(cod1);   
 write('Segundo valor del rango: '); readln(cod2);   
 writeln('Cantidad de socios dentro del rango (', cod1, ', ', cod2, '): ', cantSociosRango(a, cod1, cod2));
 
End.
