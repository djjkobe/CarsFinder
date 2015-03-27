package project;

public class Median {
	public static void main(String []args){
		int[] A= new int[6];
		int[] B = new int[4];
		for (int i = 0; i < 6; i++){
			A[i] = i+1;
//			System.out.println(A[i]);
		}
		for (int i = 0; i < 4; i++){
			B[i] = i+2;
			
		}
	 Median m = new Median();
	 System.out.println("median is "+m.findMedianSortedArrays(A, B));
		
	}
	    public double findMedianSortedArrays(int[] A, int[] B) {
	        // write your code here
	        if (A == null || A.length == 0 || B == null || B.length == 0){
	            return -1.0;
	        }
	        
	        int m = A.length;
	        int n = B.length;
	        int index = m + n;
	        int[] C = new int[index];
	        int count = 0;
	        int i = 0;
	        int j = 0;
	         while (i + j < m + n - 1){
	            if (i == m - 1){
	                C[i + j] = B[j];
	                j++;
	            }
	            else if (j == n - 1){
	                C[i + j] = A[i];
	                i++;
	            }
	            else {
	                if (A[i] <= B[j]){
	                    C[i + j] = A[i] ;
	                    i++;
	                }
	                else {
	                    C[i + j] = B[j] ;
	                    j++;
	                }
	            }
	            
	        }
	         for (int w = 0; w < 10; w++){
	 			
	 			System.out.println(C[w]);
	 		}
	       System.out.println("C length is "+C.length);
	       System.out.println("C 10 is "+C[9]);
	        if ((m + n) % 2 == 0){
	        	System.out.println("aaa "+ C[index/2] +" bbb "+ C[index/2 - 1]);
	            return (double)(C[index/2] + C[index/2 - 1])/2;
	        }
	        else {
	            return (double)(C[index/2]);
	        }
	    }



}
