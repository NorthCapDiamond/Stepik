all: solution

solution: solution.c
	gcc solution.c -fPIC -ldl '-Wl,-rpath=.' -o solution

liba: liba.c
	gcc -shared liba.c -fPIC -o lib.so

clean:
	-rm solution *.o *.so 2>/dev/null