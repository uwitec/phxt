package cn.com.framework.demo;

import cn.com.framework.demo.beans.DemoBean;

import com.opensymphony.xwork2.ActionSupport;

public class DemoAction extends ActionSupport {
	private DemoBean demoBean;

	public String demo() throws Exception {
		System.out.println(demoBean.getName());
		return INPUT;
	}

	public String init() throws Exception {
		return "demoLr";
	}

	public DemoBean getDemoBean() {
		return demoBean;
	}

	public void setDemoBean(DemoBean demoBean) {
		this.demoBean = demoBean;
	}
}
