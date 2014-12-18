long numberTested = 2;
        long divisor = 1;
        long counter = 0;
        long allFactors = 0;
        //as long as this is less than 4, continue
        while(counter <= 4){
            //while what we are dividing by is less than the numberTested, continue
            while(divisor < numberTested){
                //if the number tested divided by the divisor goes evenly, add the divisor to allFactors
                if(numberTested % divisor == 0){
                    allFactors = allFactors + divisor;
                    divisor ++;
                }else{
                    divisor ++;
                }
                
            }
            
            if(numberTested == allFactors){
                System.out.println(numberTested + "is perfect");
                counter ++;
                divisor = 1;
                allFactors = 0;
                numberTested ++;
            }else{
                numberTested ++;
                divisor = 1;
                allFactors = 0;
            }
        }
    }
}
