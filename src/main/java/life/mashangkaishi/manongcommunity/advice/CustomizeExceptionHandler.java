package life.mashangkaishi.manongcommunity.advice;

import com.alibaba.fastjson.JSON;
import life.mashangkaishi.manongcommunity.dto.ResultDTO;
import life.mashangkaishi.manongcommunity.exception.CustomizeErrorCode;
import life.mashangkaishi.manongcommunity.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable ex, Model model,
                  HttpServletRequest request,
                  HttpServletResponse response) {
        //根据传入的参数类型，判断出错问题该跳转页面还是返回数据
        String contentType = request.getContentType();
        if ("application/json".equals(contentType)){
            ResultDTO resultDTO;
            //返回 JSON
            if (ex instanceof CustomizeException){
                resultDTO= ResultDTO.errorOf((CustomizeException)ex);
            }else {
                resultDTO= ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            try {
                //ResponseBody无法与http同时判断传递，此处通过response直接传入json值
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e) {
            }

            return null;
        }else {
            //错误页面跳转
            if (ex instanceof CustomizeException){
                model.addAttribute("message",ex.getMessage());
            }else {
                model.addAttribute("message",CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }
}
