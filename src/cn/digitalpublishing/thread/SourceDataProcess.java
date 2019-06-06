package cn.digitalpublishing.thread;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.digitalpublishing.config.ProcessQueue;
import cn.digitalpublishing.po.FtpConfig;
import cn.digitalpublishing.po.FtpFolder;
import cn.digitalpublishing.po.Resource;
import cn.digitalpublishing.service.factory.ServiceFactory;
import cn.digitalpublishing.service.factory.impl.ServiceFactoryImpl;

public class SourceDataProcess extends Thread {

		ServiceFactory serviceFactory = null;
			
		private Counter counter;
			
		public SourceDataProcess (Counter counter){
			serviceFactory=(ServiceFactory)new ServiceFactoryImpl();
			this.counter=counter;
		}
				
		@Override
		public void run(){
			this.scan();
			counter.countDown();
		}
			
		private void scan(){
			
			System.out.println("----SourceDataProcess线程开启-----");
			//取得fptconfigure 和FtpFolder信息列表
			try{
 				Map<String,Object> map = new HashMap<String,Object>();
				map.put("flag", 0);
				List<FtpFolder> FtpFolderlist = this.serviceFactory.getFtpFolderService().getList(map, "");
				if(FtpFolderlist!=null&&FtpFolderlist.size()>0){
					for (FtpFolder FtpFolder : FtpFolderlist) {
						try{
							FtpConfig FtpConfig = FtpFolder.getFtpConfig();
							//ftp文件目录
							String removePath = FtpFolder.getUrl();
							//连接指定ftp服务器 取得指定文件目录下的文件名称
							List<String> fileNames = serviceFactory.getFtpFolderService().getFileNames(FtpConfig,removePath);
							//得到需要下载的文件的名map集合
							Map<String,String> notExistFileNames = serviceFactory.getFtpFolderService().notExistFileNames(fileNames,FtpConfig.getIdent(),FtpFolder.getUrl());
							System.out.println("=========需要下载的文件========="+notExistFileNames);
							if(notExistFileNames!=null&&notExistFileNames.size()>0){
								//保存到本地路径
								String localPath =ProcessQueue.WEBROOT+File.separator+ProcessQueue.UPLOADROOT+File.separator+ProcessQueue.SOURCEDATAPATH+File.separator+FtpConfig.getIdent()+File.separator+FtpConfig.getIdent()+File.separator+FtpFolder.getUrl()+File.separator;
								//下载文件
								List<Resource> resourceList=serviceFactory.getFtpFolderService().downloadRemoteFile(FtpConfig,localPath,removePath,notExistFileNames);
								//.保存Source源文件信息到Resource表中
								serviceFactory.getFtpFolderService().saveResources(resourceList);
							}
							System.out.println("======文件下载线程结束=======");
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}
