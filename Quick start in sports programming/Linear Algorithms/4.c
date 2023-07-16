#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>
#include<inttypes.h>


int main(){
	int64_t n; int64_t q; int64_t l; int64_t r;

	scanf("%"PRId64, &n);
	scanf("%"PRId64, &q);

	int64_t* array = (int64_t*) malloc((n+1)*sizeof(int64_t));

	for (int64_t i = 1; i < n+1; i++){
		scanf("%"PRId64, &array[i]);
	}
	for (int64_t i = 1; i < n+1; i++){
		array[i] = array[i-1] + array[i];
	}


	for (int64_t j = 0; j < q; j++){
		scanf("%"PRId64, &l);
		scanf("%"PRId64, &r);
		printf("%"PRId64"\n", array[r] - array[l-1]);
	}

	free(array);

}