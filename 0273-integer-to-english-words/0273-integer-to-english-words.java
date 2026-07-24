class Solution {

    private final String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    private final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        if (num >= 1_000_000_000) {
            int rem = num % 1_000_000_000;

            return helper(num / 1_000_000_000) + " Billion" +
                   (rem != 0 ? " " + numberToWords(rem) : "");
        }

        if (num >= 1_000_000) {
            int rem = num % 1_000_000;

            return helper(num / 1_000_000) + " Million" +
                   (rem != 0 ? " " + numberToWords(rem) : "");
        }

        if (num >= 1_000) {
            int rem = num % 1_000;

            return helper(num / 1_000) + " Thousand" +
                   (rem != 0 ? " " + numberToWords(rem) : "");
        }

        return helper(num);
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return below20[num];
        }

        if (num < 100) {
            return tens[num / 10] +
                   (num % 10 != 0
                       ? " " + below20[num % 10]
                       : "");
        }

        return below20[num / 100] + " Hundred" +
               (num % 100 != 0
                   ? " " + helper(num % 100)
                   : "");
    }
}