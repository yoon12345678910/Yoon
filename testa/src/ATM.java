import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.csvreader.CsvWriter;
import com.opencsv.CSVReader;

public class ATM {

	static Scanner scanner;
	static ArrayList<Account> list = new ArrayList<Account>(); 
	static String bankList = "bankList.csv";
	static 	String bankHistory = "bankHistory.csv"; 
	 
	public static void main(String[] args) throws IOException {
		init();
		reader();
		
	scanner = new Scanner(System.in);
		loop: while (true) { 
			System.out.println("1.계좌 등록");
			System.out.println("2.계좌 목록");
			System.out.println("3.계좌 수정");
			System.out.println("4.계좌 삭제");		
			System.out.println("5.입출금");
			System.out.println("6.입출금 히스토리 목록");
			System.out.print("->"); 
			
			int selectNo = scanner.nextInt();
			scanner.nextLine();
			try{
			switch(selectNo){
			
				case 1:
					
					String accountName;
					String accountNo;
					String bankName;
					String bankPhone;
					
					System.out.print("계좌이름: ");
					accountName = scanner.nextLine();
					
					accountNameWhile: while(isNum(accountName) || accountName.isEmpty() ){
						System.err.print("문자로 입력하세요: ");
						accountName = scanner.nextLine();
						continue accountNameWhile;
					}
					
					System.out.print("계좌번호: ");
					accountNo = scanner.nextLine();
					
					
					accountNoWhile: while(!isNum(accountNo) || Integer.parseInt(accountNo) < 0 || Integer.parseInt(accountNo) >999){
						System.err.print("숫자형식으로 1~3자리 입력하세요: ");
						accountNo = scanner.nextLine();
						continue accountNoWhile;
					}
					
					System.out.print("은행명: ");
					//scanner.nextLine();
					bankName = scanner.nextLine();
					
					bankNameWhile: while(isNum(bankName) || accountName.isEmpty()){
						System.err.print("문자로 입력하세요: ");
						bankName = scanner.nextLine();
						continue bankNameWhile;
					};
					
					System.out.print("은행 전화번호(ex 02-123(4)-5678): ");
					bankPhone = scanner.nextLine();
					
					bankPhoneWhile: while(!isTelePhone(bankPhone)){
						System.err.print("정확하게 입력하세요: ");
						bankPhone = scanner.nextLine();
						continue bankPhoneWhile;
					};
					
					Account account = new Account(
						accountName,
						Integer.parseInt(accountNo),		
						bankName,
						bankPhone);
					
					list.add(account);
					System.out.println("계좌가 등록되었습니다.");

					try {
						CsvWriter  csvOutput = new CsvWriter(new FileWriter(bankList, true), ';');
				
						csvOutput.write(accountName);
						csvOutput.write(accountNo);
						csvOutput.write(bankName);
						csvOutput.write(bankPhone);
						csvOutput.write("0");
						
						csvOutput.endRecord();
						
						csvOutput.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

					
				break;
				
				case 2:
					Collections.sort(list, new Comparator<Account>() {
			        public int compare(Account account1, Account account2)
				        {
				            return  account1.getAccountName().compareTo(account2.getAccountName());
				        }
					});
					if(!list.isEmpty()){
							System.out.println("ㅣ계좌이름ㅣ계좌번호ㅣ    잔액    ㅣ 은행명 ㅣ은행 전화번호ㅣ ");
					 int index = 0;
						 for(Account account1 : list){
							 System.out.printf("%8s %8s %10s %9s %12s\n",  
									 account1.getAccountName(), numberFormat(account1.getAccountNo()),  
									 account1.getMoney()+"원", account1.getBankName(), account1.getBankPhone()); 
							 index++; 
						 }
					}else{
						System.err.println("등록된 계좌가 없습니다");
					}
					 
				break;
					
				case 3:
					doUpdate();
				break;
				
				case 4:
					doDelete();
				break;
				
				case 5:
					doIO();
				break;
				
				case 6:
				break;
				
				default:
					System.out.println("이 명령어를 지원하지 않습니다.");
				break;
			
			}
			}catch(Exception e){
				  e.printStackTrace(); 
				  System.out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요."); 
			 }
			
		}
	}
	
	private static boolean isNum(String strValue){
		try{
			Integer.parseInt(strValue);
		}catch(Exception InputMismatchException){ //NumberFormatException
			return false;
		}
			return true;
	}
	
	
	private static String numberFormat(int accountNo){
		NumberFormat numformat = NumberFormat.getIntegerInstance();
		numformat.setMinimumIntegerDigits(3);
		return numformat.format(accountNo);
	}
	
	private static int searchAccount(int accountNo){
		int i=0;
			if(!list.isEmpty()){
				for(i = 0; i < list.size(); i++){
					if(list.get(i).getAccountNo() == accountNo){
						return i;
					}
				}
				i=-2;	
			}else{
				i=-1;
			}
			return i;
	};
	
	private static boolean isTelePhone(String str) {    
		/*    02  서울특별시    
		  	  031 경기도    
		  	  032 인천광역시    
		  	  033 강원도   
		  	  041 충청남도    
		  	  042 대전광역시    
		  	  043 충청북도    
		  	  051 부산광역시    
		  	  052 울산광역시    
		  	  053 대구광역시    
		  	  054 경상북도    
		  	  055 경상남도    
		  	  061 전라남도    
		  	  062 광주광역시    
		  	  063 전라북도    
		  	  064 제주특별자치도    */    
		return str.matches("(0(2|3(1|2|3)|4(1|2|3)|5(1|2|3|4|5)|6(1|2|3|4)))-(\\d{3,4})-(\\d{4})");
	}
	
	private static void doUpdate()throws CloneNotSupportedException{
		System.out.print("수정할 계좌번호: ");
		int accountNumber = Integer.parseInt(scanner.nextLine());
		
		if(searchAccount(accountNumber) == -1){
			System.out.println("등록된 계좌가 없습니다");
		}else if(searchAccount(accountNumber) == -2){
			System.out.println("등록된 계좌가 아닙니다. 다시 확인하세요.");
		}else{
			Account account = list.get(searchAccount(accountNumber));
			Account tempAccount = account.clone();
		
			 String text = null; 
			 System.out.printf("계좌번호(%s):", numberFormat(account.getAccountNo())); 
		  	 text = scanner.nextLine(); 
		  	 
		  	 accountNoWhile: while(!isNum(text) || Integer.parseInt(text) < 0 || Integer.parseInt(text) >999){
					System.err.print("숫자형식으로 1~3자리 입력하세요: ");
					text = scanner.nextLine();
					continue accountNoWhile;
			}
		    tempAccount.setAccountNo(Integer.parseInt(text)); 
				      
		    System.out.printf("계좌명(%s):", account.getAccountName()); 
		    text = scanner.nextLine(); 
		    
		    bankNameWhile: while(isNum(text) || text.isEmpty()){
					System.err.print("문자로 입력하세요: ");
					text = scanner.nextLine();
					continue bankNameWhile;
					};
	       tempAccount.setAccountName(text); 
		
		    System.out.printf("은행이름(%s):", account.getBankName()); 
		    text = scanner.nextLine(); 
		    
		    bankNameWhile: while(isNum(text) || text.isEmpty()){
					System.err.print("문자로 입력하세요: ");
					text = scanner.nextLine();
					continue bankNameWhile;
					};
		    tempAccount.setBankName(text);  
		
		    System.out.printf("은행번호(%s):", account.getBankPhone()); 
		    text = scanner.nextLine(); 
	    	 bankPhoneWhile: while(!isTelePhone(text)){
					System.err.print("정확하게 입력하세요: ");
					text = scanner.nextLine();
					continue bankPhoneWhile;
			};
		    tempAccount.setBankPhone(text); 
		
		    System.out.print("정말 변경하시겠습니까?(y/n)"); 
		    if (scanner.nextLine().equalsIgnoreCase("y")) { 
		
		      list.set(searchAccount(accountNumber), tempAccount); 
		      System.out.println("변경하였습니다."); 
		    } else { 
		      System.out.println("변경 취소하였습니다."); 
		    } 
		}
		
	
	}
	
	private static void doDelete(){
		System.out.print("삭제할 계좌번호를 입력해주세요");
		int accountNumber = Integer.parseInt(scanner.nextLine());
		
		if(searchAccount(accountNumber) == -1){
			System.out.println("등록된 계좌가 없습니다");
		}else if(searchAccount(accountNumber) == -2){
			System.out.println("등록된 계좌가 아닙니다. 다시 확인하세요.");
		}else{
			Account account = list.get(searchAccount(accountNumber));
			
			System.out.print(account.getAccountName() +"-"+ account.getAccountNo() +" 를 삭제하시겠습니까?(y/n)");
		    if (scanner.nextLine().equalsIgnoreCase("y")) { 
		    	if(account.getMoney() == 0){
		    		list.remove(searchAccount(accountNumber));
		    		System.out.println("삭제하였습니다."); 
		    	}else{
		    		System.err.println("잔액이 0원 이상이면 계좌를 삭제할 수 없습니다.");
		    	}
		    } else { 
		    	System.out.println("삭제 취소하였습니다."); 
		    } 
		}
	};
	
	private static void doIO(){
		
		loop2 : while(true){
			System.out.println("1.입금");
			System.out.println("2.출금");
			System.out.println("3.나가기");
			System.out.print("메뉴를 입력해주세요: ");
			
			int selectNo = scanner.nextInt();
			scanner.nextLine();
			if(selectNo == 1){
				System.out.print("입금계좌를 입력해주세요: ");
			}else if(selectNo == 2){
				System.out.print("출금계좌를 입력해주세요: ");
			}else if(selectNo ==3){
				break;
			}else{
				System.out.println("잘못된 명령입니다. 다시 입력해주세요:");
				scanner.nextLine();
				continue loop2;
			}
				
				int accountNumber = Integer.parseInt(scanner.nextLine());
				if(searchAccount(accountNumber) == -1){
					System.out.println("등록된 계좌가 없습니다");
				}else if(searchAccount(accountNumber) == -2){
					System.out.println("등록된 계좌가 아닙니다. 다시 확인하세요.");
				}else{
				Account account = list.get(searchAccount(accountNumber));
				
				
				if(selectNo == 1){
					System.out.print("얼마를 입금하시겠습니까?");
					int balance = Integer.parseInt(scanner.nextLine());
					
					account.deposit(balance);
					System.out.println(balance + "원을 입금하고, 잔액은 " + account.getMoney() + "원입니다."); 
				
					SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
					Date currentTime = new Date ( );
					String dTime = formatter.format ( currentTime );
					
					try {
						CsvWriter  csvOutput = new CsvWriter(new FileWriter(bankHistory, true), ';');
				
						csvOutput.write(Integer.toString(accountNumber));
						csvOutput.write("+");
						csvOutput.write(Integer.toString(balance));
						csvOutput.write(dTime);
						
						csvOutput.endRecord();
						csvOutput.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				
				
				}else if(selectNo ==2){
					System.out.print("얼마를 출금하시겠습니까?");
					int balance = Integer.parseInt(scanner.nextLine());
					 if (balance > account.getMoney()) { 
			            System.err.println("잔액이 부족합니다."); 
			        } else {
					account.withdraw(balance);
					 System.out.println(balance + "원을 출금하고, 잔액은 " + account.getMoney()
			                + "원입니다."); 
					 
					SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
					Date currentTime = new Date ( );
					String dTime = formatter.format ( currentTime );
					 
					 try {
						CsvWriter csvOutput = new CsvWriter(new FileWriter(bankHistory, true), ';');
				
						csvOutput.write(Integer.toString(accountNumber));
						csvOutput.write("-");
						csvOutput.write(Integer.toString(balance));
						csvOutput.write(dTime);
						
						csvOutput.endRecord();
						csvOutput.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				
					 
					 
			        }
					
				}
			}
		}
	};
	
	static private void init()throws IOException{
		
			boolean alreadyExistsBankList = new File(bankList).exists();
			boolean alreadyExistsBankHistory = new File(bankHistory).exists();	
					try {
						CsvWriter  csvBankList = new CsvWriter(new FileWriter(bankList, true), ';');
						CsvWriter  csvBankHistory = new CsvWriter(new FileWriter(bankHistory, true), ';');
						
						if (!alreadyExistsBankList)
						{
							csvBankList.close();
						}
						
						if (!alreadyExistsBankHistory)
						{
							csvBankHistory.close();
						}
					
					} catch (IOException e) {
						e.printStackTrace();
					}
	};
	
	
	static private void reader()throws IOException{

			try {
				CSVReader reader = new CSVReader(new FileReader(bankList), ';');
				
				String [] nextLine;
				
				Account account = new Account();
				while ((nextLine = reader.readNext()) != null) {
						account.setAccountName(nextLine[0]);
						account.setAccountNo(Integer.parseInt(nextLine[1]));
						account.setBankName(nextLine[2]);
						account.setBankPhone(nextLine[3]);
						account.setMoney(Integer.parseInt(nextLine[4]));
						list.add(account);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 

		
	}

}
