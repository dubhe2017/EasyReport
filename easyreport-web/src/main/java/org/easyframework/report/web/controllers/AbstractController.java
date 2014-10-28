package org.easyframework.report.web.controllers;

import org.apache.commons.lang3.StringUtils;
import org.easyframework.report.common.viewmodel.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected void setSuccessResult(JsonResult result, String msg) {
		result.setSuccess(true);
		result.setMsg(StringUtils.isBlank(msg) ? "操作成功！" : msg);
	}

	protected void setFailureResult(JsonResult result, String msg) {
		result.setSuccess(false);
		result.setMsg(StringUtils.isBlank(msg) ? "操作失败！" : msg);
	}

	protected void setExceptionResult(JsonResult result, Exception ex) {
		result.setSuccess(false);
		result.setMsg(String.format("系统异常, 原因:%s", ex.getMessage()));
		this.logException(ex);
	}

	protected void logException(String msg, Exception ex) {
		this.logException(msg, ex);
	}

	protected void logException(Exception ex) {
		logger.error("系统异常", ex);
	}
}
