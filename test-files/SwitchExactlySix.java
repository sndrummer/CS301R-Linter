package edu.byu.yc.tests

public class SwitchMoreThanSix {

    public int withDefault(String cheese) {
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
            default:
                x = 7;
                break;
        }
        return x;
    }

    public int withoutDefault(String cheese) {
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
        }
        return x;
    }

}