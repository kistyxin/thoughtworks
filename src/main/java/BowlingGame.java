package main.java;

public class BowlingGame {

	
	public  int getBowlingScore(String bowlingCode) {
		 String[] code =new String[11];
		 int count=0;
		 int start=0;
		
		 for(int i =0;i<bowlingCode.length();i++){
			 if(count>9) break;
			 if(bowlingCode.charAt(i)=='|'){
				 code[count]=bowlingCode.substring(start,i);
				 count++;
				 start=i+1;
			 }
		 }
		
		 for(int j=bowlingCode.length()-1;j>=0;j--){
			 if(bowlingCode.charAt(j)=='|'){
				 code[10]=bowlingCode.substring(j+1,bowlingCode.length());
				 break;
			 }
		 }
		 int[][] score = new int[11][4];
		
		 for(int i=0;i<10;i++){
			 String str = code[i];
			 int len = str.length();
			 if(len==1){
				 score[i][0]=10;
				 score[i][1]=0;
			 }else{
				if(str.charAt(0)>='0'&&str.charAt(0)<='9'){
					score[i][0]=str.charAt(0)-'0';
					if(str.charAt(1)=='/'){
						score[i][1]=10-score[i][0];
					}else{
						score[i][1]=0;
					}
				 }else{
					 score[i][0]=0;
					 score[i][1]=str.charAt(1)-'0';
				 }
			 }
		 }
		
		 String str=code[10];

		 int strlen=str.length();
		 if(strlen==0){
			 score[10][0]=0;
			 score[10][1]=0;
		 }else if(strlen==1){
			 if(str.charAt(0)=='X'){
				 score[10][0]=10;
				 score[10][1]=0;
			 }else{
				 score[10][0]=str.charAt(0)-'0';
		         score[10][1]=0;	 
			 }
		 }else{
			 for(int i=0;i<=1;i++){
				 if(str.charAt(i)=='X'){
					 score[10][i]=10;
					 
				 }else{
					score[10][i]=str.charAt(i)-'0'; 
				 }
			 }
		 }
		
		 
		 for(int i = 0;i<9;i++){
			 if(score[i][0]==10){
				 if(score[i+1][0]==10){
					 score[i][2]=score[i][0]+score[i+1][0]+score[i+2][0];
				 }else if(score[i+1][0]!=10||i==8){
					 score[i][2]=score[i][0]+score[i+1][0]+score[i+1][1];
				 }
				 
			 }else{
				 
				 if(score[i][0]+score[i][1]==10){
					 score[i][2]=score[i][0]+score[i][1]+score[i+1][0];
				 }else{
					 score[i][2]=score[i][0]+score[i][1];
				 }
			 }
		 }
		 
		 if(score[9][0]==10){
			 score[9][2]=score[9][0]+score[10][0]+score[10][1];
		 }
		 else if(score[9][0]+score[9][1]==10){
			 score[9][2]=score[9][0]+score[9][1]+score[10][0];
		 }else {
			 score[9][2]=score[9][0]+score[9][1];
		 }
		 
	
		 score[0][3]=score[0][2];
		 
		 for(int i=1;i<10;i++){
			 score[i][3]=score[i][2]+score[i-1][3];
		 }
		
	        return score[9][3];
	    }
}
