package com.sbi.banking;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bank_Operations extends Banking {
	static int newBalance;
	static String stringDipositewithrwalLine;
	
	Bank_Operations(int withrwalAmmount,int newBalance){
		String stringWithrwalBalance=Integer.toString(withrwalAmmount);
		String stringNewBalance=Integer.toString(newBalance);
		stringDipositewithrwalLine= " Withrwal          "+stringWithrwalBalance+"         "+stringNewBalance;
	}
	Bank_Operations(int wi,int dipositAmmount,int newBalance){
		String stringDipositAmmount=Integer.toString(dipositAmmount);
		String stringNewBalance=Integer.toString(newBalance);
		stringDipositewithrwalLine=" Diposit        "+stringDipositAmmount+"        "+stringNewBalance;
	}
	
	static Bank_Operations bank_Operations=new Bank_Operations();
	
	static void banking(String myBal,String name,String accNum,String 
			ifsc,String cifs,String userName,String password,String stm1,String stm2,String stm3,String stm4) throws IOException
	{
		System.out.println(" ======================================================================");
		System.out.println("*Welcome SBI Banking*"+" User Name:"+userName+"           Bal.:"+myBal+"  #Log out");
		System.out.println(" ======================================================================");
			name =name.toUpperCase();
		System.out.println("				holder Name:-"+name);
		System.out.println("				Account no.:-" +accNum);
		System.out.println("				IFSC Code.:-"+ifsc);
		System.out.println("				CIFS Code.:-"+cifs);
		//System.out.println("	Saving Balance is : "+myBal)	;
		
		
		int intBalance=new Integer(myBal);
//		System.out.println(b);
//		int w=b; 
//		b=b*2;
		int finalBalance=operations(intBalance,accNum,stm1,stm2,stm3,stm4);
		//Properties_file file =new Properties_file();
		//b=file.operations(b1);
		System.out.println("    		          Updated Balance in Account  "+finalBalance);
		String stringFinalBal=Integer.toString(finalBalance);
		storeData(name,accNum,ifsc,cifs,stringFinalBal,userName,password,stringDipositewithrwalLine,stm1,stm2,stm3);
	}

	public Bank_Operations() {
	}
	@Override
	int withdrawMoney(int myBal) {
		System.out.println("Enter Withrwal ammount ");
		Scanner sc=new Scanner(System.in);
		int withrwalAmmount =sc.nextInt();
		
		if(myBal>=withrwalAmmount) {
			newBalance=myBal-withrwalAmmount;
			new Bank_Operations(withrwalAmmount,newBalance);
		System.out.println("					Ammount "+withrwalAmmount+" Withrwal Successfull..");
		}else {int needBalance=withrwalAmmount-myBal;
			System.out.println("Insufficient fund...Need more "+needBalance+" rupees");}
		return newBalance;
	}

	@Override
	int dipositMoney(int myBal) {
		System.out.println("Enter Diposit ammount ");
		Scanner sc=new Scanner(System.in);
		int dipositAmmount=sc.nextInt();
		newBalance=myBal+dipositAmmount;
	new	Bank_Operations(dipositAmmount, dipositAmmount, newBalance);
		System.out.println("ammount "+dipositAmmount+" Diposited successfull...");
		return newBalance;
	}

	@Override
	void statement(String accNum,String stm1,String stm2,String stm3,String stm4) {
		System.out.println(" ** Mini Statement of Account   "+accNum +"**");
		System.out.println("                Withrwal/Diposit       available balance");
		System.out.println("1 "+stm1);
		System.out.println("2 "+stm2);
		System.out.println("3 "+stm3);
		System.out.println("4 "+stm4);

	}
	
	//storeData(name,accNum,ifsc,cifs,stringBal,userName,password,stm1,stm2,stm3,stm4);
	static void storeData(String name,String accNum,String ifs,String cif,String balance,
			String uid,String password,String stringDipositeWithrwalLine,String stm1,String stm2,String stm3){
		
		
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\HP\\Desktop\\demo.properties");

			String sUserName="\n userName=";
			String sPassword="\n password=";
			String sName="\n name=";
			String sAccNum="\n accNum=";
			String sIFSC="\n IFSC=";
			String sCIFS="\n CIFS=";
			String sBal="\n bal=";
			String StatementLine1="\nStatementLine1=";
			String StatementLine2="\nStatementLine2=";
			String StatementLine3="\nStatementLine3=";
			String StatementLine4="\nStatementLine4=";
					

	
			try {
				
				fos.write(sUserName.concat(uid).getBytes());
				fos.write(sPassword.concat(password).getBytes());
				fos.write(sName.concat(name).getBytes());
				fos.write(sAccNum.concat(accNum).getBytes());
				fos.write(sIFSC.concat(ifs).getBytes());
				fos.write(sCIFS.concat(cif).getBytes());
				fos.write(sBal.concat(balance).getBytes());
				fos.write(StatementLine1.concat(stringDipositeWithrwalLine).getBytes());
				fos.write(StatementLine2.concat(stm1).getBytes());
				fos.write(StatementLine3.concat(stm2).getBytes());
				fos.write(StatementLine4.concat(stm3).getBytes());
				PrintWriter pw=new PrintWriter(fos);
				pw.close();
				System.out.println("\n----------------------* Thanks for banking in SBI *-----------------");
			}		
			 catch (IOException e) {
				System.out.println(e);		}
			
		} catch (FileNotFoundException e) {
			System.out.println(e);		}
		
	}
	static int operations(int balance,String accNum,String stm1,String stm2,String stm3,String stm4) {

		System.out.println("\n          ****SELECT CHOICE****");
		System.out.println("1. withdraw money");
		System.out.println("2. Diposit Money");
		System.out.println("3. mini Statement");
		Scanner scan= new Scanner(System.in);
		int choice=scan.nextInt();
		switch(choice) {
		case 1: bank_Operations.withdrawMoney(balance);break;
		case 2: bank_Operations.dipositMoney(balance);break;
		case 3:{newBalance=balance;stringDipositewithrwalLine="Statement checked...";
				bank_Operations.statement(accNum,stm1,stm2,stm3,stm4);break;}
		default:{ newBalance=balance; System.out.println("Enter valid choice");}
	}
		return newBalance;
}

}
