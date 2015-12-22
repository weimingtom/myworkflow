package org.zywx.appdo.flow.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zywx.appdo.common.utils.license.Md5Encrypt;
import org.zywx.appdo.flow.service.WorkflowUserService;
import org.zywx.appdo.utils.PropertyTools;

import com.alibaba.dubbo.common.json.JSONObject;

/**
 * 工作流拦截器
 * 
 * 目前只对header记性MD5验证， 如有其他需求，在此添加
 * 
 * @author xingshen.zhao
 *
 */
public class WorkFlowInterceptor implements HandlerInterceptor {

	// @Autowired
	// private WorkflowUserService userServiec;

	/**
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestPath = request.getRequestURI();

		if (requestPath.indexOf("/workFlow") > 0) {
			// // 校验请求接口
//			String key = request.getHeader(PropertyTools.getPropertyByKey("validateKey"));
//			if (StringUtils.isEmpty(key)) {
//				this.setResult(response, "Header is Empty!", "001");
//				return false;
//			}
//			int index = key.lastIndexOf(";");
//			String timestamp = key.substring(index + 1);
//			String value = key.substring(0, index);
//			// 验证
//			if (!Md5Encrypt.md5(PropertyTools.getPropertyByKey("validateValue") + ":" + timestamp).equals(value)) {
//				this.setResult(response, "Header Checked Error!", "001");
//				return false;
//			}
		} else if (requestPath.indexOf("/settingM") > 0) {
			// 校验后台设置
//			String ticket = request.getParameter("ticket");
//			if (StringUtils.isEmpty(ticket)) {
//				this.setResult(response, "not login!", "001");
//				return false;
//			}
//			JSONObject jsonUser = new JSONObject();
//			HttpSession session = request.getSession();
//			if (null != session) {
//				Object userName = session.getAttribute("wfUserId");
//				if (null != userName) {
//					jsonUser.put("user", userName);
//					jsonUser.put("loginName", session.getAttribute("wfUserName"));
//				}
//			}
			// {wfUserId=admin, wfUserName=admin}
			// request.getSession().getAttribute("wfUserId");
			// 解析ticket获取用户名信息
			// String userInfo =
			// userServiec.getTicketInfo(PropertyTools.getPropertyByKey("ssoSite"),
			// ticket, PropertyTools.getPropertyByKey("homeSite")+requestPath);
			// userInfo="<cas:serviceResponse
			// xmlns:cas='http://www.yale.edu/tp/cas'>"
			// + "<cas:authenticationSuccess>"
			// + "<cas:user>admin</cas:user>"
			// + "<cas:attributes>"
			// + "<cas:userPhone>13051009579</cas:userPhone>"
			// + "<cas:isuse>T</cas:isuse>"
			// + "<cas:loginName>admin</cas:loginName>"
			// + "</cas:attributes>"
			// + "</cas:authenticationSuccess>"
			// + "</cas:serviceResponse>";

			// JSONObject jsonUser = (JSONObject)
			// WorkflowUtils.xml2JSON(userInfo);
			// HttpSession session = request.getSession();
//			session.setAttribute("wfUserId", jsonUser.get("user") == null ? "admin" : jsonUser.get("user"));
//			session.setAttribute("wfUserName", jsonUser.get("loginName") == null ? "admin" : jsonUser.get("loginName"));
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView view)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 输出错误信息
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param msg
	 *            输出信息
	 * @param stauts
	 *            状态
	 */
	private void setResult(HttpServletResponse response, String msg, String stauts) {
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("{\"status\":\"" + stauts + "\",\"msg\":{\"message\":\"" + msg + "\"}}");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
