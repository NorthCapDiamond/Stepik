#include <stdbool.h>
#include <stdio.h>
#include <dlfcn.h>
#include <stddef.h>
#include <stdlib.h>

int  (*someSecretFunctionPrototype)(const int);

bool init_library(char* name_lib, char* name_func){
	void* hdl = dlopen(name_lib, RTLD_LAZY);

	if(hdl == NULL){
		printf("Error with Lib Name\n");
		return false;
	}

	someSecretFunctionPrototype = (int (*) (const int))dlsym(hdl, name_func);

	if(someSecretFunctionPrototype == NULL){
		printf("Error with Func Name/n");
		return false;
	}

	return true;
}


int main(int argc, char** args){
	if((init_library(args[1], args[2]))==false){
		printf("%s\n", args[1]);
		printf("%s\n", args[2]);
		printf("Lib was not Loaded\n");
		return 0;
	}
	printf("%d\n", someSecretFunctionPrototype(atoi(args[3])));
	return 0;
}