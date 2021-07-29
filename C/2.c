#include <stdio.h>

int main()
{
	int i,j;
	int a;
	int count[10] = {0};
	int max = 0;
	
	while((a = getchar()) != EOF) {
		if(a >= '0' && a <= '9') {
			count[a-'0']++;
		}
	}
	for(i=0; i<10; i++) {
		if(count[i] > max) {
			max = count[i];
		}
	}
	
	printf("숫자가 등장한 횟수\n");
	for(i=max; i>=1; i--) {
		for(j=0; j<10; j++) {
			if(count[j] >= i) {
				printf(" * ");
			} else {
				printf("   ");
			}
			printf("\n");
		}
	}
	
	for(j=0; j<10; j++) {
		printf(" %d", j);
	}
}
