package com.benjn.numbershapes;

/**
 * Created by bnelson on 7/7/16.
 */
public class Number {
    int number;

    public boolean isSquare(){
        double sqrtResult = Math.sqrt(number);

        if(sqrtResult == Math.floor(sqrtResult)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isTriangular(){
        int x = 1;
        int triangularNumber = 1;

        while(triangularNumber < number){
            x++;

            triangularNumber = triangularNumber + x;
        }

        if(triangularNumber == number){
            return true;
        }else{
            return false;
        }
    }

}
