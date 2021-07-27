#include <stdio.h>

void arr_set(char a[], int n, char val)
{
	int i;
	
	for(i=0; i<n; i++) {
		a[i] = val;
	}
}

int main() {
	int i;
	char *animal[5] = {
		"dog", "cat", "rabbit", "panda", "bear"
	};
	
	arr_set(&animal[1], 2, "h");
	
	for(i=0; i<5; i++) {
		printf("animal[%d] = %s\n", i, animal[i]);
	}
	
}
