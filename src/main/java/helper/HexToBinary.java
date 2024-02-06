package helper;

import java.util.Base64;
import java.util.HexFormat;

public class HexToBinary {

    public static String hexToRow() {
        String s = "0000   00 00 00 cc 00 00 00 04 00 00 00 00 00 00 02 41\n" +
                "0010   00 05 00 74 65 73 74 00 01 01 37 39 30 35 37 30\n" +
                "0020   39 38 32 38 34 00 40 00 00 00 30 30 30 30 30 30\n" +
                "0030   30 30 31 30 30 30 30 30 30 52 00 01 00 08 00 8c\n" +
                "0040   05 05 03 51 0a 01 04 1f 04 40 04 3e 04 32 04 35\n" +
                "0050   04 40 04 3a 04 30 00 20 00 66 00 69 00 6c 00 74\n" +
                "0060   00 65 00 72 00 2d 00 6c 00 69 00 6d 00 69 00 74\n" +
                "0070   00 31 00 20 04 1f 04 40 04 3e 04 32 04 35 04 40\n" +
                "0080   04 3a 04 30 00 20 00 66 00 69 00 6c 00 74 00 65\n" +
                "0090   00 72 00 2d 00 6c 00 69 00 6d 00 69 00 74 00 32\n" +
                "00a0   00 20 04 1f 04 40 04 3e 04 32 04 35 04 40 04 3a\n" +
                "00b0   04 30 00 20 00 66 00 69 00 6c 00 74 00 65 00 72\n" +
                "00c0   00 2d 00 6c 00 69 00 6d 00 69 00 74\n";
        s = s.replaceAll("\\w{4}\\s{3}", "");
        s = s.replaceAll("\\n", " ");
        s = s.replaceAll("\\s", "");
//        s = s.substring(0, s.length() - 1);
        return s;
    }


    public static void main(String[] args) {
        System.out.println("hexadecimal from submit_sm:");
        System.out.println(hexToRow());

        System.out.println("---------------------------");
        System.out.println("convert hexadecimal to base64:");
        byte[] hexBytes = HexFormat.of().parseHex(hexToRow());
        String base64String = Base64.getEncoder().encodeToString(hexBytes);
        System.out.println(base64String);
    }

}
