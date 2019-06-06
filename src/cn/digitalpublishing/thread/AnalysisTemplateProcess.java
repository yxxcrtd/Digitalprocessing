package cn.digitalpublishing.thread;

import cn.digitalpublishing.po.Template;
import cn.digitalpublishing.service.factory.ServiceFactory;
import cn.digitalpublishing.service.factory.impl.ServiceFactoryImpl;

public class AnalysisTemplateProcess extends Thread {

		ServiceFactory serviceFactory = null;
		
		private Counter counter;
		
		private Template template;
			
		
		public AnalysisTemplateProcess (Counter counter,Template template){
			serviceFactory=(ServiceFactory)new ServiceFactoryImpl();
			this.template=template;
			this.counter=counter;
		}
			
		@Override
		public void run(){
			this.scan();
			counter.countDown();
		}
			
		private void scan(){
			try {
				System.out.println(serviceFactory.getTemplateNodeService());
				serviceFactory.getTemplateNodeService().analysisTemplateAddNode(template);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}
