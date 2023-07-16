#include<stdio.h>
#include<stdint.h>
#include<stdlib.h>
#include<inttypes.h>

//globals
int64_t mod = 1791791791;
int64_t a;
int64_t b;
int64_t cur;
int64_t MAX_VALUE = -1791791792;
int64_t SECOND_MAX_VALUE = -1791791792;

//rand function
int64_t NextRand(int64_t cur, int64_t a, int64_t b) {
    cur = (cur * a + b) % mod;
    return cur;
}


//solution
int main(){
	int64_t n;
	int64_t i1 = 0;
	int64_t i2 = 0;
	scanf("%lli", &n);
	scanf("%lli", &cur
	);
	scanf("%lli", &a);
	scanf("%lli", &b);
	cur = NextRand(cur, a, b);
	for (int64_t i = 0; i < n; i++){
		if (cur > MAX_VALUE){
			SECOND_MAX_VALUE = MAX_VALUE;
			i2 = i1;
			MAX_VALUE = cur;
			i1 = i;
		}
		else if(cur > SECOND_MAX_VALUE){
			SECOND_MAX_VALUE = cur;
			i2 = i;
		}
		cur = NextRand(cur, a, b);
	}
	printf("%" PRId64 " ",i1+1);
	printf("%" PRId64 "\n",i2+1);
}