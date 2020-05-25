package weekandmonth;

import java.util.Scanner;

public class week {
  
    public static void PrintDay(int year, int month, int day) {
        char dayOfWeek = DayofDate(year, month, day);
        System.out.println(year + "년 " + month + "월 " + day + "일 " + dayOfWeek + "요일" );
        
    }
   
    
   public static int MonthDays(int year, int month) {
        
    	int dayOfMonth = 0;
        Boolean yoon = ((year % 4 == 0) && (year % 100 !=0)) || year % 400 == 0;
        Boolean num_31 = (month == 1) || (month == 3) || (month == 5) || (month == 7)
 || (month == 8) || (month == 10) || (month == 12);
        
        if (yoon && month == 2) {
            dayOfMonth = 29;
        } else if (!yoon && month == 2) {
            dayOfMonth = 28;
        } else if (num_31) {
            dayOfMonth = 31;
        } else {
            dayOfMonth = 30;
        }
        return dayOfMonth;
    }
    
    
    public static char DayofDate(int year, int month, int day) {
        char dayOfWeek = 0;
        int totalDay = 0;
        for(int i = 1900; i <= year; i++) {
            if (i < year) {
                for(int j = 1; j <= 12; j++) {
                    totalDay += MonthDays(i, j);
                }
            
            } else {
                for(int j = 1; j < month; j++) {
                    totalDay += MonthDays(i, j);
                }
            }
        }
        totalDay += day;
        
        switch (totalDay % 7) {
        case 0:
            dayOfWeek = '일';
            break;
        case 1:
            dayOfWeek = '월';
            break;
        case 2:
            dayOfWeek = '화';
            break;
        case 3:
            dayOfWeek = '수';
            break;    
        case 4:
            dayOfWeek = '목';
            break;
        case 5:
            dayOfWeek = '금';
            break;
        case 6:
            dayOfWeek = '토';
            break;    
        }
        return dayOfWeek;
    }
    
    public static void main(String[] args) {
        int year, day, month;
        Scanner scanner = new Scanner(System.in);//입력
        do {
            System.out.println("연도를 입력: ");
            year = scanner.nextInt();
        } while (year < 1900);
        do {
            System.out.println("월을 입력 : ");
            month = scanner.nextInt();
        } while (month < 1 || month > 12);
        do {
            System.out.println("일을 입력 : ");
            day = scanner.nextInt();
        } while (day < 1 || day > 31);
        
        PrintDay(year, month, day);//출력
    }
    
    
}
