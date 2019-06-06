package cn.digitalpublishing.config;

public class ProcessQueue {
	
	/**
	 * rest:rest服务 ws:webservice服务 ftp:ftp服务
	 */
	public static String interfaceService = "rest";
	
	/**
	 * WEBROOT
	 */
	public static String WEBROOT = "";
	
	
	public static String TEMPLATEHOME = "templatehome";
	
	public static int THREADASTAUTS=0;
	
	public static int THREADBSTAUTS=0;
	
	
	/**
	 * 自动下载源数据 1-加载 0-不加载 
	 * */
	public static int SOURCEDATALOAD=0;
	
	/**
	 * 解析拆分
	 */
	public static int ANALYSISDATALOAD=0;
	/**
	 * 解析拆分
	 */
	public static int DOWNLOAD=0;
	
	/**
	 * 下载文件根目录
	 */
	public static String UPLOADROOT = "uploadRoot";
	
	/**
	 * txt转换成html目录
	 */
	public static String HTMLPATH ="htmlfile";
	/**
	 * pdf目录
	 */
	public static String PDFPATH ="pdffile";
	/**
	 * XML目录
	 */
	public static String XMLPATH ="xmlfile";
	/**
	 * DOC目录
	 */
	public static String DOCPATH ="docfile";
	

	/**
	 * 源数据下载目录
	 */
	public static String SOURCEDATAPATH = "sourcedatapath";
}
