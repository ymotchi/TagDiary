package com.motchi.tagdiary.common.interceptor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.motchi.tagdiary.common.util.Constant;
import com.motchi.tagdiary.dto.UserDto;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthenticationChecker extends AbstractInterceptor {

	/**
	 *
	 */
	private static final long serialVersionUID = -1661372366221355228L;

	private static final Log log = LogFactory.getLog(AuthenticationChecker.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();

		// セッションにUserDtoが存在すれば、ログイン済みとみなす。
		Object user = session.get(Constant.SESSION_USER_INFO);

		if (user != null && user instanceof UserDto) {
			log.debug("Logged-in");
			return invocation.invoke();
		} else {
			log.debug("Not Logged-in");
			return "noLogin";
		}
	}

}
