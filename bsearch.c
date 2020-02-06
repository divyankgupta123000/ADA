#include<stdio.h>

void b_search(int k,int a[50],int n);

void main()
{
	int a[50];
	int i,k,n;
	printf("Enter total number of values: ");
	scanf("%d",&n);
	printf("Enter sorted array values:\n");
	for(i=0;i<n;i++)
	  scanf("%d",&a[i]);
	printf("\nEnter Key value to be searched: ");
	scanf("%d",&k);
	b_search(k,a,n);
}

void b_search(int k,int a[50],int n)
{
	int i=0,res=-1;
	int b[50],count=0,min,max;
	int first,mid,last;

	do
	{
	  first=0;
	  last=n-1;
	  mid=(first+last)/2;
	  while(first<=last)
	  {
	    if(k<a[mid])
	    {
		    last=mid-1;
		    mid=(first+last)/2;
	    }
	    else if(k>a[mid])
	    {
		    first=mid+1;
		    mid=(first+last)/2;
	    }
		else if(k==a[mid])
		{
			b[i]=mid;
			b[++i]=-2;
		    a[mid]=-99;
		    res=0;
		    break;
		}
		else
        {
            if(first=last && a[mid]!=k)
             break;
        }
	  }
	}while(first<=last);

	i=0;
	if(res==-1)
    {
      printf("-1");
    }
    else
    {
      while(b[i]!=-2)
	  {
		count++;
	    i++;
	  }
      for(i=0;i<count;i++)
        printf("%d",b[i]);
	  printf("\nTotal Count= %d\n",count);

	  min=b[0];
	  max=b[0];
	  for(i=1;i<count;i++)
	  {
		if(b[i]<min)
			min=b[i];
      }

      printf("First Occurence: %d\n",min+1);

	  for(i=1;i<count;i++)
	  {
		if(b[i]>max)
			max=b[i];
	  }

	  printf("Last Occurence: %d\n",max+1);
   }
}
