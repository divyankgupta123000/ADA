#include<stdio.h>

int b_search(int k,int a[50],int n);

void main()
{
	int a[50];
	int i,k,n,res;
	printf("Enter total number of values: ");
	scanf("%d",&n);
	printf("Enter sorted array values:\n");
	for(i=0;i<n;i++)
	  scanf("%d",&a[i]);
	printf("\nEnter Key value to be searched: ");
	scanf("%d",&k);
	res=b_search(k,a,n);
	if(res==-1)
	  printf("-1");
}

int b_search(int k,int a[50],int n)
{
	int i=0,res=0;
	int b[50],count=0,min,max;
	int first=0,mid,last=n-1;
	mid=(first+last)/2;
	
	if(res==-1)
	 return res;
	 
	while(first<=last || res==-1)
	{
		
	    if(k<a[mid])
	    {
		    last=a[mid]-1;
		    mid=(first+last)/2;
	    }
	    else if(k>a[mid])
	    {
		    first=a[mid]+1;
		    mid=(first+last)/2;
	    }
		else if(k==a[mid])
		{
			b[i]=mid;
			i++;
			b[i]=-2;
		    a[mid]=-99;
		} 
	   else
	    res=-1;
	}
	i=0;
	if(res!=-1)
	{
		printf("Total Count= %d",1);
		printf("First Occurence: %d\n",mid);
		printf("Last Occurence: %d\n",mid);
	}
   while(b[i]!=-2)
	{
		count++;
	    i++;
	}
	
	printf("Total Count= %d",count);
	
	min=b[0];
	max=b[0];
	for(i=1;i<count;i++)
	{
		if(b[i]<min)
			min=b[i];
	}
	
    printf("First Occurence: %d\n",min);
	
	for(i=1;i<count;i++)
	{
		if(b[i]<min)
			min=b[i];
	}
	
	printf("Last Occurence: %d\n",max);
	return 0;
}