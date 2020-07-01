
package talkingclock;

/**
 *
 * @author Şilan
 */
public class WhatTimeIsIt {
    
            int hour;
            String hourName;
            String minuteName;
            int minute;
           //printing hour
            String[] hours={"twelve","one","two","three","four","five","six","seven","eight","nine","ten","eleven"};
           
            
            //printing minutes
            String[] ones={"","one","two","three","four","five","six","seven","eight","nine"};
            String[] teens={"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen",};
            String[] tens={"","","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
            
            //constructer
            WhatTimeIsIt(int hour,int minute){
                this.hour=hour;
                this.minute=minute;
            }
            
            void printHour(){
                hourName=hours[hour%12];
                
                System.out.print(hourName+" ");
            }
            void printMinute(){
                if(minute==0){
                    
                }
                else if(minute<10){
                    minuteName=ones[minute];
                     System.out.print("oh "+minuteName+" ");
                }
                else if(minute<20){
                    minuteName=teens[minute%10];
                    System.out.print(minuteName+" ");
                }
                else{
                    String ten;
                    String one;
                    
                    ten=tens[minute/10];
                    one=ones[minute%10];
                    
                    minuteName=ten+" "+one;
                     System.out.print(minuteName+" ");
                }
                
            }
            
            void noon(){
                if(hour==12){
                    System.out.println("noon");
                }
                else if(hour<12){
                    System.out.println("am");
                }
                else{
                    System.out.println("pm");
                }
            }
                
            
}
