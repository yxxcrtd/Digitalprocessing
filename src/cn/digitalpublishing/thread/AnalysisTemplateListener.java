package cn.digitalpublishing.thread;

import cn.digitalpublishing.po.Template;


@SuppressWarnings("unused")
public class AnalysisTemplateListener {

	private Counter counter = null;
	
	private int i = 0;
	
	private String msg="";
	
	public AnalysisTemplateListener(){
		counter = new Counter();
	}
	
	/**
	 * 执行数据扫描
	 */
	public void executeScan(Template template){
		if(counter.getCount()==0){
			System.out.println("xml模板解析线程*****开始");
			msg="";
			i++;
			counter.countAdd();
			Thread t = new AnalysisTemplateProcess(counter,template);   
			t.start();
		}else{
			if(msg.trim().length()==0){
				msg="xml模板解析线程，等待......";
				System.out.println(msg);
			}
		}
	}
	
}
