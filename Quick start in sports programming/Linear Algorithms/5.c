#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>
#include<inttypes.h>

int64_t max(int64_t a, int64_t b){
	if (a > b){
		return a;
	}
	return b;
}

int64_t MAX_VALUE = -1000000001;
int main(){
	int64_t n;
	int64_t summ = MAX_VALUE;
	scanf("%" PRId64, &n);

	int64_t* array = (int64_t*) malloc(n*sizeof(int64_t));

	for (int64_t i = 0; i < n; i++){
		scanf("%"PRId64, &array[i]);
		summ = max(array[i], summ);
	}
	if (summ < 0){
		printf("%"PRId64, summ);
		return 0;
	}
	summ = 0;

	// Jay Kadane

	for(int64_t i = 0; i < n; i++){
		summ+=array[i];
		MAX_VALUE = max(MAX_VALUE, summ);
		summ = max(summ, 0);
	}
	MAX_VALUE = max(summ, MAX_VALUE);


	printf("%"PRId64, MAX_VALUE);
	free(array);
	return 0;
}