#include<stdio.h>
void tower_hanoi(int n,char src,char temp,char dest);

void main()
{
	int n;
	char a='A',b='B',c='C';
	printf("Enter total no. of discs: ");
	scanf("%d",&n);
	tower_hanoi(n,a,b,c);
}

void tower_hanoi(int n,char src,char temp,char dest)
{
	if(n==1)
	{
		printf("Move disc %d from %c to %c\n",n,src,dest);
		return;
	}
	
	tower_hanoi(n-1,src,dest,temp);
	printf("Move disc %d from %c to %c\n",n,src,dest);
	tower_hanoi(n-1,temp,src,dest);
}