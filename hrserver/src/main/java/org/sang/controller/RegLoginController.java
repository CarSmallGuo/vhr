package org.sang.controller;

import org.sang.bean.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sang on 2017/12/29.
 */
@RestController
public class RegLoginController {
    @RequestMapping("/login_p")
    public RespBean login(HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        resp.setContentType("application/json;charset=UTF-8");
        //PrintWriter out = resp.getWriter();
        //out.write("{\"status\":\"error\",\"msg\":\"尚未登录，请登录!\"}");
        //out.flush();
        //out.close();
        return new RespBean("error", "尚未登录，请登录!");
    }
}
