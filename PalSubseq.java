import java.util.*;
class PalSubseq {

    static int checkPali(String str,int s,int e){
        int length=0;
        while(s<=e){
            if(str.charAt(s) == str.charAt(e)){
                s++;
                e--;
                if(s!=e)
                length+=2;
                else length++;
            }
            else break;
        }
        if(s>e)
        return length;
        else return 0;
    }

    static ArrayList<Integer> find(String str,char c,int s){
        ArrayList<Integer> pos = new ArrayList<Integer>();
        for(int i=s+1;i<str.length();i++){
            if(str.charAt(i) == c){
                pos.add(i);
            }
        }
        return pos;
    }

    static int subseqlen(String str){
        ArrayList<Integer> len = new ArrayList<Integer>();
        int n=str.length();
        for(int i=0;i<n;i++){
           char c = str.charAt(i);
           ArrayList<Integer> pos = new ArrayList<Integer>();
           pos = find(str,c,i);
           for(int j=0;j<pos.size();j++){
               int x = checkPali(str,i,pos.get(j));
               len.add(x);
           }
        }
        if(len.size()==0)
            return 0;
        else{
        Collections.sort(len);
        return len.get(len.size()-1);
        }
    }

    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the string");
        String str = s.next();
        System.out.println("Longest Palindromic subsequence is "+subseqlen(str));
    }
}
