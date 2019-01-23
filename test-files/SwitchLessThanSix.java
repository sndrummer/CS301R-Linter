package edu.byu.yc.tests

public class SwitchLessThanSix {

    public int threeCases(String cheese) {
        int x = 0;
        switch (cheese) {
            case "parmesan":
                x = 1;
                break;
            case "cheddar":
                x = 2;
                break;
            case "jack":
                x = 3;
                break;
            default:
                x = 4;
                break;
        }
        return x;
    }

    public int oneCase(String cheese) {
        int x = 0;
        switch (cheese) {
            case "parmesan":
                x = 1;
                break;
            default:
                x = 2;
                break;
        }
        return x;
    }

    public int fiveCaseWithDefault(String cheese) {
        int x = 0;
        switch (cheese) {
            case "parmesan":
                x = 1;
                break;
            case "cheddar":
                x = 2;
                break;
            case "jack":
                x = 3;
                break;
            case "spicy":
                x = 4;
                break;
            case "swiss":
                x = 5;
                break;
            default:
                x = 6;
                break;
        }
        return x;
    }

}