package org.yiming.networkworkbench.framework.servlet;

import com.alibaba.fastjson.JSON;
import org.yiming.networkworkbench.config.Request;
import org.yiming.networkworkbench.framework.beans.Handler;
import org.yiming.networkworkbench.framework.beans.HandlerMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求分发
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取上下文地址（项目名称）
        String contextPath = req.getContextPath();
        // 获取URL地址  先获取URI 然后通过上下文地址截取出URL 再讲多余的/ 去除
        String url = req.getRequestURI().replaceAll(contextPath,"").replaceAll("/+","/");

        // 通过HandlerMapping获取到对应的Handler
        Handler handler =  HandlerMapping.getHandler(url);
        // 当handler不存时返回404
        if(handler == null){
            // TODO 目前为最简单的404实现
            resp.setStatus(404);
            resp.getWriter().write("404 找不到该页面！ ");
        }
        try {
            Request request = new Request();
            request.setRequestParameterMap(req.getParameterMap());
            String jsonString = JSON.toJSONString(handler.performMethod(request));
            resp.setStatus(200);
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
            resp.getWriter().write(e.toString());
        }
//        super.service(req, resp);
    }
}
