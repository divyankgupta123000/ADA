/*#include<iostream>
using namespace std;

int bsearch(int arr[] , int l , int r , int x)
{ 
    if (r >= l) { 
        int mid = l + (r - l) / 2; 
  
        if (arr[mid] == x)
        { 
            if(arr[mid-1] - x == 0)
            return mid; 
  
        if (arr[mid] > x) 
            return bsearch(arr, l, mid - 1, x); 
  
        return bsearch(arr, mid + 1, r, x); 
    } 
    return -1; 
} 

int main(){
  int arr[] = {1 , 1 , 1 , 2 , 2 , 5 , 5 , 7 , 8 , 9} , i;
  int size = 10;
  int x = 1;
  int result = bsearch(arr , 0 , size-1 , x);
  if(result == -1)
    cout<<"-1 -1 0"<<"\n";
  else
    cout<<"Element is found at index "<<result<"\n";
}
*/


#include<bits/stdc++.h> 
using namespace std; 
int first(int arr[], int low, int high, int x, int n) 
{ 
    if(high >= low) 
    { 
        int mid = low + (high - low)/2; 
        if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x)
            return mid; 
        else if(x > arr[mid]) 
            return first(arr, (mid + 1), high, x, n); 
        else
            return first(arr, low, (mid -1), x, n); 
    } 
    return -1; 
} 
  
  
int last(int arr[], int low, int high, int x, int n) 
{ 
    if (high >= low) 
    { 
        int mid = low + (high - low)/2; 
        if (( mid == n-1 || x < arr[mid+1]) && arr[mid] == x) 
            return mid; 
        else if (x < arr[mid]) 
            return last(arr, low, (mid -1), x, n); 
        else
            return last(arr, (mid + 1), high, x, n); 
    } 
    return -1; 
} 


int main() 
{ 
    int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8} , f , l; 
    int n = sizeof(arr)/sizeof(int); 
    int x = 8;
    f =  first(arr, 0, n-1, x, n);
    l = last(arr, 0, n-1, x, n);
    if(f == -1){
      cout<<"-1 -1 0"<<"\n";
    }
    else{
      cout<<"First Occurrence = "<< f; 
      cout<<"\t"<<"Last Occurrence = "<<l;
      cout<<"\t"<<"Count = "<<(l - f +1)<<"\n"; 
    }
    return 0; 
} 


  
