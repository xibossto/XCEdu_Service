package com.xuecheng.framework.utils;

/**
 * @author xiboss
 * @create 2019-03-20 21:30
 */
public class CodeStringUtils {
    /**
     * 去除字符串中所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
     * @param s
     * @return
     */
    public static String removeAllBlank(String s) {
        String result = "";
        if (null != s && !"".equals(s)) {
            result = s.replaceAll("[　*| *| *|//s*]*", "");
        }
        return result;
    }

    /**
     * 去除字符串中头部和尾部所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
     * @param s
     * @return
     */
    public static String trim(String s) {
        String result = "";
        if (null != s && !"".equals(s)) {
            result = s.replaceAll("^[　*| *| *|//s*]*", "").replaceAll("[　*| *| *|//s*]*$", "");
        }
        return result;
    }

    /**
     * 全角转半角
     * @param s
     * @return 半角字符串
     */
    public static String ToBJ(String s){
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length ; i++) {
            if(c[i] == '\u3000'){
                c[i] = ' ' ;
            }else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);
            }
        }
        return new String(c) ;
    }

    public static void main(String[] args) {
        String input = "CMS_ADDPAGE_EXISTS(false,24001,\"页面已存在！\");\n" +
                "    //操作结果\n" +
                "package com.xuecheng.framework.exception;\n" +
                "import com.xuecheng.framework.model.response.ResponseResult;\n" +
                "import com.xuecheng.framework.model.response.ResultCode;\n" +
                "import org.slf4j.Logger;\n" +
                "import org.slf4j.LoggerFactory;\n" +
                "import org.springframework.web.bind.annotation.ControllerAdvice;\n" +
                "import org.springframework.web.bind.annotation.ExceptionHandler;\n" +
                "import org.springframework.web.bind.annotation.ResponseBody;\n" +
                "@ControllerAdvice\n" +
                "public class ExceptionCatch {\n" +
                "    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);\n" +
                "    //捕获 CustomException异常\n" +
                "    @ExceptionHandler(CustomException.class)\n" +
                "    @ResponseBody\n" +
                "    public ResponseResult customException(CustomException e) {\n" +
                "        LOGGER.error(\"catch exception : {}\\r\\nexception: \",e.getMessage(), e);\n" +
                "        ResultCode resultCode = e.getResultCode();\n" +
                "        ResponseResult responseResult = new ResponseResult(resultCode);\n" +
                "        return responseResult;\n" +
                "    }\n" +
                "}\n" +
                "    boolean success; \n" +
                "    //操作代码\n" +
                "    int code;\n" +
                "    //提示信息\n" +
                "    String message;\n" +
                "    private CmsCode(boolean success, int code, String message){\n" +
                "        this.success = success;\n" +
                "        this.code = code;\n" +
                "        this.message = message;\n" +
                "    }" ;
        String str = ToBJ(input).replaceAll("\\u00A0"," ") ;
        System.out.println(str);
    }
}
