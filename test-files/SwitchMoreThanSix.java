package edu.byu.yc.tests

public class SwitchMoreThanSix {

    public int eightCases(String cheese) {
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
            case "sharp":
                x = 6;
                break;
            case "blue":
                x = 7;
                break;
            case "green":
                x = 8;
                break;
            default:
                x = 9;
                break;
        }
        return x;
    }

    public int sevenCases(String cheese) {
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
            case "sharp":
                x = 6;
                break;
            case "blue":
                x = 7;
                break;
            default:
                x = 9;
                break;
        }
        return x;
    }

}