package org.example;

import org.apache.commons.lang3.StringUtils;

public class AbbreivateText {

    public static String abbreviateText (String text, int maxWidth){
        String cutText = StringUtils.abbreviate(text, maxWidth);
        return cutText;
    }

    public static void main(String[] args) {
        System.out.println(abbreviateText("GGGGGGGGGG1234", 5));
    }
}
