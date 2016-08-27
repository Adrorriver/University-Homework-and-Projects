
/**
 * Fill Hadamard matrix
 * 
 * @author (amir dror) 
 * 
 */
public class Hadamard
{
public static void fillHadamard (int[][] arr){
        int index = arr.length;
        fillHadamard (arr,index,0,0,1);
    }
    
    public static void fillHadamard(int[][] arr,int size,int r,int c,int value){
        if(size == 1){
            arr[r][c] = value;
            return;
        }
        else{
            fillHadamard(arr,size/2,r,c,value);
            fillHadamard(arr,size/2,size/2+r,c,value);
            fillHadamard(arr,size/2,r,size/2+c,value);
            fillHadamard(arr,size/2,size/2+r,size/2+c,-value);
            return;
        }
    }
    
    public static void main(String[] args){
        int[][] arr = new int[4][4];
        fillHadamard(arr);
        for (int i=0;i<4;i++){
            for(int j=0;j<4;j++){
            	if(arr[i][j] == 1) 
            		System.out.print(" "+arr[i][j]+"\t  ");
            	else
            		System.out.print(arr[i][j]+"\t  ");
            }
            System.out.println("");
        }
    }
}
