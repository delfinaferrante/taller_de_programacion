program ejercicio4;


procedure leerNumero();
	
	procedure convertirABinario(num: integer);
	var
	  resto: integer;
	begin
	  if (num > 0)then begin
	  	 resto := num mod 2;
	     convertirABinario(num div 2);
	     write(resto);
	  end;
	end;

var
 num: integer;
begin
 write('Ingrese un numero: '); readln(num);
 if (num <> 0) then begin
    write('El numero binario es: ');
    convertirABinario(num);
    writeln;
    leerNumero();
 end;
end;



begin
 leerNumero();
end.
