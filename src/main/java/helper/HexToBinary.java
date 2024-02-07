package helper;

import java.util.Base64;
import java.util.HexFormat;

public class HexToBinary {

    public static String hexToRow() {
        String s = "0000   00 00 00 b1 00 00 00 04 00 00 00 00 00 8f 0e d7\n" +
                "0010   00 05 00 41 70 70 6c 65 00 01 01 37 39 32 35 33\n" +
                "0020   32 37 33 30 34 32 00 40 00 00 00 30 30 30 30 30\n" +
                "0030   30 30 30 32 35 30 30 30 30 30 52 00 01 00 00 00\n" +
                "0040   00 04 24 00 6c 06 01 02 15 79 00 00 52 45 47 2d\n" +
                "0050   52 45 53 50 3f 76 3d 33 3b 72 3d 31 33 37 36 33\n" +
                "0060   32 35 31 36 32 3b 6e 3d 2b 37 39 32 35 33 32 37\n" +
                "0070   33 30 34 32 3b 73 3d 30 32 36 35 42 38 41 30 46\n" +
                "0080   41 46 46 46 46 46 46 46 46 32 32 39 33 35 43 35\n" +
                "0090   46 36 32 36 32 45 44 45 41 42 36 46 43 42 30 37\n" +
                "00a0   30 43 32 46 36 31 35 30 44 33 30 41 31 45 45 46\n" +
                "00b0   36\n";
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
