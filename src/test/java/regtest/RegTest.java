package regtest;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by navia on 2015/5/1.
 */
public class RegTest {
    private String str = "<div style=\"width:80px;\">this is a test</div>" +
            "<div width=\"300\">this is a test</div>";

    @Test
    public void test1(){
        // 正则表达式前面加(?i)表示不区分大小写
        String regix = "(?i)(?:style|width)\\s*=\\s*\"[^\"]+\"";
        System.out.println(str.replaceAll(regix, ""));
    }

    @Test
    public void test2(){
        Pattern p = Pattern.compile("(?:style|width)\\s*=\\s*\"[^\"]+\"", Pattern.CASE_INSENSITIVE);
        StringBuffer sb = new StringBuffer();
        Matcher m = p.matcher(str);
        while(m.find()){
            m.appendReplacement(sb, "");
        }
        m.appendTail(sb);

        System.out.println(sb.toString());
    }
}
