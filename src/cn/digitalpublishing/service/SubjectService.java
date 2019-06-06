package cn.digitalpublishing.service;

import java.util.List;
import java.util.Map;

import cn.digitalpublishing.po.BSubRelation;
import cn.digitalpublishing.po.BSubject;
import cn.digitalpublishing.po.BSubject;
import cn.digitalpublishing.po.PCSRelation;
import cn.digitalpublishing.springmvc.form.SubjectForm;

public interface SubjectService extends BaseService {

	/**
	 * 获取分类
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BSubject getSubject(String id)throws Exception;
	/**
	 * 删除分类
	 * @param id
	 * @param path
	 * @throws Exception
	 */
	public void deleteSubject(String id)throws Exception;
	/**
	 * 新增分类
	 * @param obj
	 * @throws Exception
	 */
	public void addSubject(BSubject obj)throws Exception;
	/**
	 * 更新分类
	 * @param obj
	 * @param id
	 * @param properties
	 * @throws Exception
	 */
	public boolean updateSubject(BSubject obj,String id,String[] properties)throws Exception;
	
	/**
	 * 获取列表
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	public List<BSubject> getSubjectList(Map<String,Object> condition,String sort)throws Exception;
	/**
	 * 获取分页列表
	 * @param condition
	 * @param sort
	 * @param pageCount
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<BSubject> getSubjectPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
	/**
	 * 获取总数
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public Integer getSubjectCount(Map<String,Object> condition)throws Exception;
	/**
	 * 插入
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public String insertSubject(BSubject obj) throws Exception;
	/**
	 * 用sql语句更新
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public boolean updateBySql(BSubject obj)throws Exception;
	/**
	 * 查询分类列表
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	public List<BSubject> getSubList(Map<String,Object> condition,String sort)throws Exception;
	/**
	 * 通过relation来查询分类总数
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	/*batchsubject
	 * public Integer getRelationCount(Map<String,Object> condition)throws Exception;*/
	/**
	 * 通过relation查询分类的分页列表信息
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	/*刘冶注释
	 * public List<BSubRelation> getRelationPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;*/
	/**
	 * 批量保存分类对应关系
	 * @param coopIds
	 * @param clcIds
	 * @throws Exception
	 */
	/*刘冶注释
	 * public void batchSaveRelation(String[] coopIds, String[] clcIds)throws Exception;*/
	/**
	 * 主分类生成xml
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	public String generateXML(Map<String,Object> condition,String sort,String path)throws Exception;
	/**
	 * 分类法移动处理
	 * @param form
	 * @throws Exception
	 */
	public void subjectPosChange(SubjectForm form)throws Exception;
	/**
	 * 获取分类编号
	 * @param code
	 * @param typeCode
	 * @return
	 * @throws Exception
	 */
	public BSubject getSubjectByCode(String code,String typeCode)throws Exception;
	/**
	 * 获取分类类型
	 * @param typeCode
	 * @return
	 * @throws Exception
	 */
	public BSubject getSubjectTypeByCode(String typeCode)throws Exception;
	/**
	 * 根据BIC值返回分类信息
	 * @param bicCode
	 * @return
	 * @throws Exception
	 */
	/*刘冶注释
	 * public BSubRelation getSubRelationByBIC(String bicCode)throws Exception;*/
	/**
	 * 获取分类映射列表
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	/*刘冶注释
	 * public List<BSubRelation> getSubRelationList(Map<String,Object> condition)throws Exception;*/
	/**
	 * 获取分类列表，但是设计到产品关联
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	public List<BSubject> getSubjectListToContent(Map<String, Object> condition, String sort)throws Exception;
	/**
	 * 查询产品分类关系
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	public List<PCSRelation> getPCsRelationList(Map<String, Object> condition,String sort)throws Exception;
	/**
	 * 批量保存分类关系
	 * @param contentId
	 * @param nodes
	 * @throws Exception
	 */
	/*刘冶注释
	 * public void batchSubject(String contentId,List<Map<String, Object>> nodes)throws Exception;*/
	/**
	 * 批量更新分类产品映射关系
	 * @param contentId
	 * @param modifyObj
	 */
	/*刘冶注释
	 * public void batchUpdateSubject(String contentId, Map<String, List<Object>> modifyObj)throws Exception;*/
	/**
	 * 查询分类列表（简单）
	 * @param condition
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	public List<BSubject> getPubSubjectList(Map<String,Object> condition,String sort)throws Exception;

	public List<BSubject> getDistinctCodeList()throws Exception ;
	
	public List<BSubject> getDistinctNameList()throws Exception ;
	/**
	 * 通过relation来查询分类总数
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public Integer getRelationCount(Map<String,Object> condition)throws Exception;
	/**
	 * 通过relation查询分类的分页列表信息
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public List<BSubRelation> getRelationPagingList(Map<String,Object> condition,String sort,Integer pageCount,Integer page)throws Exception;
 
	
	public void saveObj(BSubRelation obj) throws Exception;
}
