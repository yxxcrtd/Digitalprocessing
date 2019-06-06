package cn.digitalpublishing.springmvc.form;

import java.util.HashMap;
import java.util.Map;

public class ThreadConfigForm extends DataTableForm {

	private int threadA;

	private int threadB;


	// 下载源数据
	private int sourceDataLoad;

	// 解析源数据
	private int analysisDataLoad;

	// 下载图书文件
	private int download;

	public int getSourceDataLoad() {
		return sourceDataLoad;
	}

	public void setSourceDataLoad(int sourceDataLoad) {
		this.sourceDataLoad = sourceDataLoad;
	}

	public int getAnalysisDataLoad() {
		return analysisDataLoad;
	}

	public void setAnalysisDataLoad(int analysisDataLoad) {
		this.analysisDataLoad = analysisDataLoad;
	}

	public int getDownload() {
		return download;
	}

	public void setDownload(int download) {
		this.download = download;
	}

	private Map<String, String> loadMap = new HashMap<String, String>();

	public Map<String, String> getLoadMap() {
		return loadMap;
	}

	public void setLoadMap(Map<String, String> loadMap) {
		this.loadMap = loadMap;
	}

	public int getThreadA() {
		return threadA;
	}

	public void setThreadA(int threadA) {
		this.threadA = threadA;
	}

	public int getThreadB() {
		return threadB;
	}

	public void setThreadB(int threadB) {
		this.threadB = threadB;
	}


}
