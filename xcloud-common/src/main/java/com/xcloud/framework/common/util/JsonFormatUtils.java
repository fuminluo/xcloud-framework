package com.xcloud.framework.common.util;

/**
 * @author administered
 * @data 2018/8/7
 */
public class JsonFormatUtils {
    private static String SPACE = "   ";

    public JsonFormatUtils() {
    }

    public static String formatJson(String json) {
        StringBuffer result = new StringBuffer();
        int length = json.length();
        int number = 0;
        //char key = false;

        for(int i = 0; i < length; ++i) {
            char key = json.charAt(i);
            if (key != '[' && key != '{') {
                if (key != ']' && key != '}') {
                    if (key == ',') {
                        result.append(key);
                        result.append('\n');
                        result.append(indent(number));
                    } else {
                        result.append(key);
                    }
                } else {
                    result.append('\n');
                    --number;
                    result.append(indent(number));
                    result.append(key);
                    if (i + 1 < length && json.charAt(i + 1) != ',') {
                        result.append('\n');
                    }
                }
            } else {
                if (i - 1 > 0 && json.charAt(i - 1) == ':') {
                    result.append('\n');
                    result.append(indent(number));
                }

                result.append(key);
                result.append('\n');
                ++number;
                result.append(indent(number));
            }
        }

        return result.toString();
    }

    private static String indent(int number) {
        StringBuffer result = new StringBuffer();

        for(int i = 0; i < number; ++i) {
            result.append(SPACE);
        }

        return result.toString();
    }
}

