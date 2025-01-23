
public class Task120{


    public static void main(String[] args) {
       sumParam(4,7,8);
    }

    public static void sumParam(int... numbers){
        int sumTotal = 0, paramSumTotal = 0;
        
        for(int num : numbers){
            for(int j=0; j<=num; j++){
                paramSumTotal += j;
            }
            System.out.println(num+" Parameter Cumulative  Sum is: "+paramSumTotal);
        }
        
        for(int i=0; i < numbers.length; i++){
            sumTotal += numbers[i];       
        }
        System.out.println("Total sum of all parameters: "+ sumTotal);
    }
   
}