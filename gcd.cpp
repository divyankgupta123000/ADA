#include<iostream>
using namespace std;
int gcd(int m , int n){
  if(m == n)
    return m;
  if(m > n)
    return gcd(m-n ,n);
  else
    return gcd(m , n-m);
}

int main(){
  int m , n;
  cout<<"Enter the two numbers:"<<"\n";
  cin>>m>>n;
  int g = gcd(m,n);
  cout<<"The gcd of "<<m<<" and "<<n<<" is "<< g<<"\n";
}

