#include <stdio.h> 
#include <stdlib.h>
#include <time.h>
#include <windows.h>

int main(void)
{
	int a;
	int val;
	srand(time(NULL));
	
	a = (rand() % 3) + 1;
	
	
	switch(a) {
		while(1) {
		val = (rand() % 3) + 1;
		printf("%d", val);
		case 1:
			if(val == 1) {
			printf("hi");
			break;
		}
		case 2:
			if(val == 1) {
			printf("hi");
			break;
		}
		case 3:
			if(val == 1) {
			printf("hi");
			break;
		}
	}
	Sleep(1000);
}
	
}
