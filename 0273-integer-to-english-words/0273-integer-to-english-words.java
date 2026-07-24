class Solution {

    private static final String[] BELOW_20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen",
        "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy",
        "Eighty", "Ninety"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();

        int billion  = num / 1_000_000_000;
        int million  = (num / 1_000_000) % 1000;
        int thousand = (num / 1_000) % 1000;
        int rest     = num % 1000;

        if (billion > 0) {
            convert(billion, sb);
            sb.append("Billion ");
        }

        if (million > 0) {
            convert(million, sb);
            sb.append("Million ");
        }

        if (thousand > 0) {
            convert(thousand, sb);
            sb.append("Thousand ");
        }

        if (rest > 0) {
            convert(rest, sb);
        }

        // Remove final extra space
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }

    private void convert(int num, StringBuilder sb) {

        if (num >= 100) {
            sb.append(BELOW_20[num / 100])
              .append(" Hundred ");

            num %= 100;
        }

        if (num >= 20) {
            sb.append(TENS[num / 10])
              .append(' ');

            num %= 10;
        }

        if (num > 0) {
            sb.append(BELOW_20[num])
              .append(' ');
        }
    }
}