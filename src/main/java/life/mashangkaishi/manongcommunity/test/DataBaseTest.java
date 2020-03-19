package life.mashangkaishi.manongcommunity.test;

import ch.qos.logback.classic.spi.EventArgUtil;
import life.mashangkaishi.manongcommunity.mapper.testTableMapper;
import life.mashangkaishi.manongcommunity.model.testTable;
import life.mashangkaishi.manongcommunity.model.testTableExample;
import org.apache.logging.log4j.util.ProviderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.tools.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class DataBaseTest {
    static JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
    static DiagnosticCollector<JavaFileObject> diagnosticCollector=new DiagnosticCollector();

    public static void main(String[] args) throws FileNotFoundException {

        String s="asdasd";
        char[] chars = s.toCharArray();
        s.length();
        int length = chars.length;

//        System.out.println(getFullClassName("import java.util.*;public class Test2 {public static void main(String[] args)  {Test test=new Test(); test.test(); }}class Test {public void test(){List<Integer> ints = new ArrayList(); ints.add(1);System.out.println(ints.get(0));}}"));
//        PrintStream PrintStream = new PrintStream("C:\\Users\\marboo\\Desktop\\RemoteSensingData\\FY4GEO\\test.txt"); //输出到文件
//        PrintStream.println("asdfasfasdfsadfasfasdfasdfsadfasdfasfsafsdaf");
//        System.setOut(PrintStream);

    }
    public static int GetUglyNumber_Solution(int index) {
        int haveUgly=0;
        for(int i=1;i<Integer.MAX_VALUE;i++){
            if(isUgly(i)){
                haveUgly++;
            }
            if(haveUgly==index)
                return i;
        }
        return 0;
    }

    static boolean isUgly(int num){
        if(num==1)
            return true;
        if(num%2==0)
            return isUgly(num/2);
        if(num%3==0)
            return isUgly(num/3);
        if(num%5==0)
            return isUgly(num/5);
        return false;
    }

    public static String getFullClassName(String sourceCode) {
        String className = "";
        Pattern pattern = Pattern.compile("package\\s+\\S+\\s*;");
        Matcher matcher = pattern.matcher(sourceCode);
        if (matcher.find()) {
            className = matcher.group().replaceFirst("package", "").replace(";", "").trim() + ".";
        }


        pattern = Pattern.compile("class\\s+\\S+\\s+\\{");
        matcher = pattern.matcher(sourceCode);
        if (matcher.find()) {
            className += matcher.group().replaceFirst("class", "").replace("{", "").trim();
        }

        System.out.println(matcher.regionEnd()+"---"+sourceCode.length());
        return className;
    }

    public static void test3(){
//        StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(diagnosticCollector, null, null);
//        JavaFileManager javaFileManager = new JavaFileManage(standardFileManager);
//        JavaFileObject javaFileObject=new JavaFileObject();
    }
}
//class JavaFileObject extends SimpleJavaFileObject{
//
//
//    /**
//     * Construct a SimpleJavaFileObject of the given kind and with the
//     * given URI.
//     *
//     *  uri  the URI for this file object
//     *  kind the kind of this file object
//     */
//    protected JavaFileObject(String className, String source) {
//        super(URI.create("string:///" + className.replaceAll("\\.", "/") + Kind.SOURCE.extension), kind.SOURCE);
//    }
//}

 class JavaFileManage extends ForwardingJavaFileManager {

     /**
      * Creates a new instance of ForwardingJavaFileManager.
      *
      * @param fileManager delegate to this file manager
      */
     protected JavaFileManage(JavaFileManager fileManager) {
         super(fileManager);
     }
 }
