package com.packt.webstore.interceptor;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Created by Blazej on 01.05.2017.
 */
public class AuditingInterceptor extends HandlerInterceptorAdapter {
    private final static Logger logger = Logger.getLogger("auditLogger");
    private String user;
    private String productId;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
                             Object handler) throws Exception{

        if(request.getRequestURI().endsWith("products/add/p") &&
            request.getMethod().equals("POST")){
            user = request.getRemoteUser();
            productId = request.getParameterValues("productId")[0];
        }
        return true;
    }
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception arg3) throws Exception{

        if(request.getRequestURI().endsWith("products/add/p") &&
                response.getStatus() == 302){
            logger.info(String.format("Nowy produkt [%s] dodany przez %s dnia %s",
                    productId,user,getCurrentTime()));
        }
    }
    private  String getCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy 'o' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return format.format(calendar.getTime());
    }
}
