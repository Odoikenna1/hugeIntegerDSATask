package tddProject;

import tddProject.exception.InvalidNumberInput;
import tddProject.exception.NumberTooLargeException;

import java.util.ArrayList;

public class HugeInteger {
    Integer[] value;


    public void parse(String number) {
        ArrayList<Integer> surrogateArrLst = new ArrayList<>();
        String validatedNumber = validateNumber(number);
        ArrayList<Integer> surrogateArrLstPopulated = numberToArrLst(validatedNumber, surrogateArrLst);
        setValue(surrogateArrLstPopulated);
    }

    public HugeInteger add(HugeInteger hugeInt2) {
        ArrayList<Integer> surrogateArr = new ArrayList<>();
        if(hugeInt2.getValue().length < value.length){
            for (int i = 0; i < hugeInt2.getValue().length; i++){
                surrogateArr.add(hugeInt2.getValue()[i] + value[i]);
            }
        }else {
            for (int i = 0; i < value.length; i++) {
                surrogateArr.add(value[i] + hugeInt2.getValue()[i]);
            }
        }
        HugeInteger hugeInteger = new HugeInteger();
        hugeInteger.setValue(surrogateArr);
        return hugeInteger;
    }

    public Integer[] getValue() {
        return value;
    }
    public String toString(){
        String objectElements = "";
        for(int i = 0; i < value.length; i++){
            objectElements += value[i];
        }
        return objectElements;
    }
    public String toString(Integer[] arr){
        String objectElements = "";
        for(int i = 0; i < arr.length; i++){
            objectElements += arr[i];
        }
        return objectElements;
    }

    private String validateNumber(String number){
        if(number.matches("\\d+")){
            if(number.length() > 40){ throw new NumberTooLargeException("The number input is larger than 40 digits.");}
            else{
                return number;
            }
        }
        throw new InvalidNumberInput("You have entered an invalid number.");
    }

    private ArrayList<Integer> numberToArrLst(String number, ArrayList<Integer> surrogateArrLst) {
        String numberValidated = validateNumber(number);
        int strDigitToNum = 0;
        for(int j = 0; j < numberValidated.length(); j++){
            String digitToStr = String.valueOf(numberValidated.charAt(j));
            strDigitToNum = Integer.parseInt(digitToStr);
            surrogateArrLst.add(strDigitToNum);
        }
        return surrogateArrLst;
    }

    private void setValue(ArrayList<Integer> surrogateArrLst) {
        value = new Integer[surrogateArrLst.size()];
        for(int i = 0; i < value.length; i++){
            value[i] = surrogateArrLst.get(i);
        }

    }



}
