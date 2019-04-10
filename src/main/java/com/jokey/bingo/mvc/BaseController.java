package com.jokey.bingo.mvc;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :JokeyFeng
 * Date: 21:51 2018/6/9.
 * Contact :976024396@qq.com
 * Description: 视图层抽象类
 */

public abstract class BaseController<T> {
    /**
     * <p>
     * 获取项目在操作系统的绝对路径
     * </p>
     * 返回形如D:\工具\Tomcat-6.0\webapps\projectname\字符串 其中projectname为项目名称
     *
     * @return
     */
    protected String getRootAbsolutePath() {
        HttpServletRequest request = getRequest();
        return request.getSession().getServletContext().getRealPath("/");
    }

    /**
     * 得到应用的访问头地址 http://ip(域名):端口/应用名
     *
     * @return
     */
    protected String getBasePath() {
        HttpServletRequest request = getRequest();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return basePath.concat(request.getContextPath());
    }

    /**
     * 获取web上下文
     *
     * @return
     */
    protected ServletContext getServletContext() {
        HttpServletRequest request = getRequest();
        if (request != null) {
            return request.getSession().getServletContext();
        }
        return null;
    }


    /**
     * 获取HttpServletRequest
     *
     * @return
     */
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取HttpServletResponse
     *
     * @return
     */
    protected HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
