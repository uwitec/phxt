package cn.com.framework.beans.order;

public class FsxxBean {
	private String id;
	private String name;
	private String je;
	private String pmje100="0";
	private String pmje50="0";
	private String pmje20="0";
	private String fileName;
	private String dr_time;

	public String getDr_time() {
		return dr_time;
	}

	public void setDr_time(String dr_time) {
		this.dr_time = dr_time;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJe() {
		return je;
	}

	public void setJe(String je) {
		this.je = je;
	}

	public String getPmje100() {
		return pmje100;
	}

	public void setPmje100(String pmje100) {
		this.pmje100 = pmje100;
	}

	public String getPmje50() {
		return pmje50;
	}

	public void setPmje50(String pmje50) {
		this.pmje50 = pmje50;
	}

	public String getPmje20() {
		return pmje20;
	}

	public void setPmje20(String pmje20) {
		this.pmje20 = pmje20;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
