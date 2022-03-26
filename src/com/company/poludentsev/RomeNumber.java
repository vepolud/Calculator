package com.company.poludentsev;

public enum RomeNumber {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
    //    XI(11),XII(12), XIII(13), XIV(14), XV(15), XVI(16), XVII(17), XVIII(18), XIX(19), XX(20);
    private final int value;

    RomeNumber(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    public static String convert(int in) throws Exception {

        if (in > 0) {
            StringBuilder a;
            a = new StringBuilder();

            // Выделяем сотни
            int c1 = in / 100;
            a.append(C(c1));
            // остаток из сотен
            int c2 = in % 100;

            // Выделяем полсотни
            int l1 = c2 / 50;
            a.append(L(l1));
            // остаток
            int l2 = c2 % 50;

            // Выделяем десятки
            int x1 = l2 / 10;
            a.append(X(x1));
            // остаток
            int x2 = l2 % 10;

            // Выделяем то что осталось
            a.append(basic(x2));
            return a.toString();
        } else {
            throw new Exception("Rome number can be positive only");
        }
    }

    // преобразовываем целые сотни
    private static String C(int in) {
        if (in == 4) return "CD"; //если 400, то 500-100
        else if ((in != 0) && (in < 4)) {
            StringBuilder a = new StringBuilder();
            int i = 0;
            while (i < in) {
                a.append("C");
                i++;
            }
            return a.toString();
        } else return "";
    }

// целые десятки

    private static String X(int in) {
        if (in == 4) return "XL"; // если 40, то 50-10
        else if ((in != 0) && (in < 4)) {
            StringBuilder a = new StringBuilder();
            int i = 0;
            while (i < in) {
                a.append("X");
                i++;
            }
            return a.toString();
        } else return "";
    }


    private static String L(int in) {
        if (in == 4) return "XC"; // если90 то100 - 10
        else if ((in != 0) && (in < 4)) {
            StringBuilder a = new StringBuilder();
            int i = 0;
            while (i < in) {
                a.append("L");
                i++;
            }
            return a.toString();
        } else return "";

    }

    // От 1 до 9, то что осталось
    private static String basic(int in) {
        String[] a = {
                "",
                "I",
                "II",
                "III",
                "IV",
                "V",
                "VI",
                "VII",
                "VIII",
                "IX"
        };
        return a[in];
    }
}



