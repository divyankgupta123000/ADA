#include<stdio.h>

void gcd(int m,int n);

void main()
{
	int m,n;
	printf("Enter 2 values for GCD calculations:\n");
	scanf("%d",&m);
	scanf("%d",&n);
	gcd(m,n);
}

void gcd(int m,int n)
{
	 int r;
	 while(r!=0)
	 {
		 r=m%n;
		 m=n;
	     n=r;
	 }
	 printf("GCD: %d\n",m);
}