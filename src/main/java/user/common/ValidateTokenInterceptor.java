package user.common;


import cn.hutool.core.util.StrUtil;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import user.exception.UserManagementException;
import user.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateTokenInterceptor implements HandlerInterceptor {



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }





    private void checkToken(HttpServletRequest request) {
        String token = request.getHeader("authorizationToken");
        if (StrUtil.isEmpty(token)) {
            throw new UserManagementException(RespCode.USER_NO_LOGIN);
        }
        User user = CacheUtils.getUser(token);
        if (user == null){
            throw new UserManagementException(RespCode.USER_NO_LOGIN);
        }
        CacheUtils.storeCurrentToken(token);
    }
}
