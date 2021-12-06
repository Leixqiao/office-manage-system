package com.leixiaoqiao.api.constant;

public interface CommonConstant {
	/** {@code 500 Server Error} (HTTP/1.0 - RFC 1945) */
    Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /** {@code 200 OK} (HTTP/1.0 - RFC 1945) */
    Integer SC_OK_200 = 200;

    Integer LOGIN_PASSWORD_ERROR = 4000;

    String LOGIN_ERROR_MESSAGE = "用户名或密码错误";
}
