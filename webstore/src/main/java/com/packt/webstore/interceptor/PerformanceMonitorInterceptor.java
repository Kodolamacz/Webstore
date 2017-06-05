package com.packt.webstore.interceptor;

import javafx.scene.input.DataFormat;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Created by Blazej on 27.04.2017.
 */
public class PerformanceMonitorInterceptor implements HandlerInterceptor{
    ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<StopWatch>();
    Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        StopWatch stopWatch = new StopWatch(o.toString());
        stopWatch.start(o.toString());
        stopWatchThreadLocal.set(stopWatch);
        logger.info("Przetwarzanie żadnia do ścieżki: " + getURLPath(httpServletRequest));
        logger.info("Przetwarzanie żadnia rozpoczęto o: " + getCurrentTime());
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        logger.info("Przetwarzanie żądania zakończono o: " + getCurrentTime());

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        StopWatch stopWatch = stopWatchThreadLocal.get();
        stopWatch.stop();
        logger.info("Łączny czas przetwarzania żądania: " +
        stopWatch.getTotalTimeMillis() + " ms");
        stopWatchThreadLocal.set(null);
        logger.info("===============================================");
    }
    private String getURLPath(HttpServletRequest request){
        String currentPath = request.getRequestURI();
        String queryString = request.getQueryString();
        queryString = queryString == null ? "" : "?" + queryString;
        return currentPath + queryString;
    }
    private  String getCurrentTime(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy 'o' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return format.format(calendar.getTime());
    }
}
