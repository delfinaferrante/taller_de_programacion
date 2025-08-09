program ejercicio2;
type
 rangoDias = 1..31;
 rangoMeses = 1..12;
 rangoAnios = 2020..2024; 
 
  r_fecha = record
    dia: rangoDias;
    mes: rangoMeses;
    anio: rangoAnios;
  end;
  
  //---- primer arbol y reg ---- //
  venta = record
		codP: integer;
		fecha: r_fecha;
		unidadesV: integer;
  end;

  arbol = ^nodoArbol;
  nodoArbol = record
		dato: venta;
		hi: arbol;
		hd: arbol;
  end;

  //---- segundo arbol y reg ---- //
	ventaII = record
		codigo: integer;
		totalUnidades: integer;
	end;

  arbolII = ^nodoArbolII;
	nodoArbolII = record
		dato: ventaII;
		hi: arbolII;
		hd: arbolII;
	end;

  //--- tercer arbol y lista ---//
	ventaSinCodigo = record {datos que tengo que agregar a la lista}
	 	fecha: r_fecha;
		unidadesVendidas:integer;
	end;
	lista = ^nodoLista;
	nodoLista = record
		dato: ventaSinCodigo;
		sig: lista;
	end;
	ventaIII = record
	    codigo: integer;
	    venta: lista; {otro registro para no cargar en cada nodo de la lista el mismo codigo}
	end;
	
	arbolIII = ^nodoArbolIII;
	nodoArbolIII = record
		dato: ventaIII;
		hd: arbolIII;
		hi: arbolIII;
	end;
  
//----------------------- MODULOS ----------------------------
procedure cargarVentas(var a: arbol; var a2: arbolII; var a3: arbolIII);

		procedure leer(var v: venta);
		begin
			v.codP := random(50); //codigos de 0 a 49
			if (v.codP <> 0) then begin
				v.fecha.dia:= 1 + random(31);
				v.fecha.mes:= 1 + random(12);
				v.fecha.anio:= 2020 + random(5); 
				
				v.unidadesV:= 1 + random(1000);
			end;
		end;

		procedure cargarArbol(var a: arbol; v: venta);
		begin
			if (a = nil) then begin
				new(a);
				a^.dato:= v;
				a^.hi:= nil;
				a^.hd:= nil;
			end
			else if (v.codP >= a^.dato.codP) then
					cargarArbol(a^.hd, v)
			else
					cargarArbol(a^.hi, v);
		end;

		procedure cargarSegundoArbol(var a2: arbolII; v: venta);
		begin
			if (a2 = nil)then begin
				new(a2);
				a2^.dato.codigo:= v.codP;
				a2^.dato.totalUnidades:= v.unidadesV; 
				a2^.hi:= nil;
				a2^.hd:= nil;
			end
			else if (a2^.dato.codigo = v.codP)then   {si es el mismo codigo del nodo del arbol, entonces sumo las unidades vendidas}
				a2^.dato.totalUnidades := a2^.dato.totalUnidades + v.unidadesV
			else if (v.codP > a2^.dato.codigo) then
				cargarSegundoArbol(a2^.hd, v)
			else
				cargarSegundoArbol(a2^.hi, v);
		end;
		
		procedure agregarAdelante(var l: lista; vs: ventaSinCodigo);
		var
		  nue: lista;
		begin
		  new(nue);
		  nue^.dato:= vs;
		  nue^.sig:= l;
		  l:= nue;
		end;
		
		procedure cargarTercerArbol(var a3: arbolIII; v: venta);
		var
		 v2: ventaSinCodigo;
		 nue: arbolIII;
		begin
			if (a3 = nil) then begin
				new(nue);
				nue^.dato.codigo:= v.codP;
				nue^.dato.venta:= nil;
				v2.unidadesVendidas:= v.unidadesV;
				v2.fecha.dia:= v.fecha.dia;
				v2.fecha.mes:= v.fecha.mes;
				v2.fecha.anio:= v.fecha.anio;
				agregarAdelante(nue^.dato.venta, v2);
				nue^.hi:= nil;
				nue^.hd:= nil;
				a3:= nue;
			end
			else if (a3^.dato.codigo = v.codP) then begin   {si es el mismo codigo del nodo del arbol, entonces creo otro nodo de la lista}
				v2.unidadesVendidas:= v.unidadesV;			{si el arbol <> nil, entonces tengo q volver a cargar el registro de la lista}
				v2.fecha.dia:= v.fecha.dia;
				v2.fecha.mes:= v.fecha.mes;
				v2.fecha.anio:= v.fecha.anio;
				agregarAdelante(a3^.dato.venta, v2);
			end
			else if (v.codP > a3^.dato.codigo) then
				cargarTercerArbol(a3^.hd, v)
			else
				cargarTercerArbol(a3^.hi, v);
		end;
	

var
unaVenta: venta;
begin
a:= nil;
a2:= nil;
a3:= nil;
writeln;
writeln ('----- Ingreso de ventas y armado de arboles ----->');
writeln;

leer(unaVenta);
while (unaVenta.codP <> 0) do begin
	cargarArbol(a, unaVenta);
	cargarSegundoArbol(a2, unaVenta);
	cargarTercerArbol(a3, unaVenta);
	leer(unaVenta);
end;
end;

procedure imprimirArbol(a: arbol);
begin
 if (a <> nil) then begin
    imprimirArbol(a^.hi);
    write('Codigo de producto: ', a^.dato.codP, 
	' -- Fecha: ', a^.dato.fecha.dia, '/', a^.dato.fecha.mes, '/', a^.dato.fecha.anio,
	' -- Unidades vendidas: ', a^.dato.unidadesV);
    writeln;
    imprimirArbol(a^.hd);
 end;
end;

procedure imprimirArbol2(a2: arbolII);
begin
 if (a2 <> nil) then begin
    imprimirArbol2(a2^.hi);
    write('Codigo de producto: ', a2^.dato.codigo, 
	' -- Total de unidades vendidas: ', a2^.dato.totalUnidades);
    writeln;
    imprimirArbol2(a2^.hd);
 end;
end;

procedure imprimirArbol3(a3: arbolIII);

	procedure recorroLista(l: lista);
	begin
	  while (l <> nil) do begin
	    write('Fecha: ', l^.dato.fecha.dia, '/', l^.dato.fecha.mes, '/', l^.dato.fecha.anio, '. ');
	    writeln('Unidades vendidas: ', l^.dato.unidadesVendidas);
	    l:= l^.sig;
	  end;
	end;
	
begin
  if (a3 <> nil) then begin
     imprimirArbol3(a3^.hi);
     write('Codigo de producto: ', a3^.dato.codigo);
     writeln;
     recorroLista(a3^.dato.venta);
     writeln;
     imprimirArbol3(a3^.hd);
  end;
end;

function productosVendidos(a: arbol; r: r_fecha): integer;
begin
  if (a = nil) then
    productosVendidos:= 0 {si esta vacio retorna 0}
  else begin
    if ((r.dia = a^.dato.fecha.dia) and (r.mes = a^.dato.fecha.mes) and (r.anio = a^.dato.fecha.anio)) then
		productosVendidos := a^.dato.unidadesV  {si la fecha coincide suma las unidades }
	else
	   productosVendidos:= 0;  {si no coincide la fecha, suma 0}
	   
    productosVendidos := productosVendidos + productosVendidos(a^.hi, r) + productosVendidos(a^.hd, r);
  end;
end;
	
function codMaxUnidades(a2: arbolII): integer;
var
  maxUni: integer;
begin
  if (a2 = nil) then 
    maxUni:= 0
  else begin
    if (a2^.dato.totalUnidades > maxUni) then begin
      maxUni:= a2^.dato.totalUnidades;
      codMaxUnidades:= a2^.dato.codigo;
    end
    else
      codMaxUnidades:= codMaxUnidades(a2^.hi) + codMaxUnidades(a2^.hd);
  end;
end;

procedure codMaxVentas(a3: arbolIII; var maxCant, maxCod: integer);

	function recorroListaVentas(L: lista): integer;
	var
	 cantVentas: integer;
	begin
	  cantVentas:= 0;
	  while (L <> nil) do begin
	    cantVentas:= cantVentas + 1;
	    L:= L^.sig;
	  end;
	  recorroListaVentas:= cantVentas;
	end;

begin
 if (a3 <> nil) then begin
	if (recorroListaVentas(a3^.dato.venta) > maxCant) then begin
		maxCant:= recorroListaVentas(a3^.dato.venta);
		maxCod:= a3^.dato.codigo;
	end;
	codMaxVentas(a3^.hi, maxCant, maxCod);
	codMaxVentas(a3^.hd, maxCant, maxCod);
 end;
end;
//----------------------- PROG. PRINC ----------------------------

var
 a: arbol;
 a2: arbolII;
 a3: arbolIII;
 reg_fecha: r_fecha;
 maxCod, maxCant: integer;
begin
 Randomize;
 cargarVentas(a, a2, a3);  {inciso A}
 
 writeln;
 writeln('---------- ARBOL 1 de menor a mayor ---------->');
 imprimirArbol(a);
 writeln;
 
 writeln('------------------ ARBOL 2 ------------------->');
 imprimirArbol2(a2);
 writeln;
 
 writeln('------------------ ARBOL 3 ------------------->');
 imprimirArbol3(a3);
 writeln;
 
 writeln('----------- INCISO B ----------->');
 write('Ingrese dia: '); readln(reg_fecha.dia);
 write('Ingrese mes: '); readln(reg_fecha.mes);
 write('Ingrese anio (de 2020 a 2024): '); readln(reg_fecha.anio);

 write('El total de productos vendidos en la fecha ', reg_fecha.dia, '/', reg_fecha.mes, '/', reg_fecha.anio,
 ' fue de: ', productosVendidos(a, reg_fecha)); 
 writeln;
 
 writeln;
 writeln('----------- INCISO C ----------->');
 write('Codigo de producto con mayor cantidad de unidades vendidas: ', codMaxUnidades(a2));
 writeln;
 
 writeln;
 writeln('----------- INCISO D ----------->');
 maxCant:= -999;
 codMaxVentas(a3, maxCant, maxCod);
 write('Codigo de producto con mayor cantidad de ventas: ', maxCod); 
end.
