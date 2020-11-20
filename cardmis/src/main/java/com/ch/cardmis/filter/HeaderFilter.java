package com.ch.cardmis.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "/*",filterName = "headerFilter")
public class HeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        /**
         * 解决跨域访问start
         */
        response.setContentType("text/html;charset=UTF-8");
        //允许跨域请求的域名
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        //response.setHeader("Access-Control-Allow-Origin", "*");
        //Access-Control-Allow-Methods：跨域请求允许的请求方式
        response.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
        // response.setHeader("Access-Control-Allow-Methods","*");
        /*
         * 浏览器的同源策略，就是出于安全考虑，浏览器会限制从脚本发起的跨域HTTP请求（比如异步请求GET, POST, PUT, DELETE, OPTIONS等等），所以浏览器会向所请求的服务器发起两次请求，第一次是浏览器使用OPTIONS方法发起一个预检请求，第二次才是真正的异步请求，第一次的预检请求获知服务器是否允许该跨域请求：如果允许，才发起第二次真实的请求；如果不允许，则拦截第二次请求。
         * Access-Control-Max-Age用来指定本次预检请求的有效期，单位为秒，，在此期间不用发出另一条预检请求。
         * 例如：
         * response.addHeader("Access-Control-Max-Age", "0")，表示每次异步请求都发起预检请求，也就是说，发送两次请求。
         * response.addHeader("Access-Control-Max-Age", "1800")，表示隔30分钟才发起预检请求。也就是说，发送两次请求
         */
        response.setHeader("Access-Control-Max-Age","0");
        //Access-Control-Allow-Headers：允许发送的内容类型
        response.setHeader("Access-Control-Allow-Headers","Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,token");
        // response.setHeader("Access-Control-Allow-Headers","*");
        //服务器端通过在响应 header 中设置 Access-Control-Allow-Credentials = true 来运行客户端携带证书式访问。
        //通过对 Credentials 参数的设置，就可以保持跨域 Ajax 时的 Cookie。这里需要注意的是：
        //服务器端 Access-Control-Allow-Credentials = true时，参数Access-Control-Allow-Origin 的值不能为 '*' 。
        response.setHeader("Access-Control-Allow-Credentials","true");
        filterChain.doFilter(request, response);
        /**
         * 解决跨域访问end
         */
    }
}
