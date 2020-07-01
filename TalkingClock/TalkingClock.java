//This program takes the time as digital and tells that what time is it
package talkingclock;

import java.util.Scanner;

/**
 *
 * @author Şilan
 */
public class TalkingClock {


    public static void main(String[] args) {
            int hour,minute;
          
           
            //taking time
            System.out.println("Saati giriniz");
            Scanner scan=new Scanner(System.in);
            hour=scan.nextInt();
            System.out.println("Dakikayi giriniz");
            minute=scan.nextInt();
            
              WhatTimeIsIt clock=new WhatTimeIsIt(hour, minute);
            System.out.print("It's ");
            clock.printHour();
            clock.printMinute();
            clock.noon();
            System.out.println("");
            
    }
    
}
