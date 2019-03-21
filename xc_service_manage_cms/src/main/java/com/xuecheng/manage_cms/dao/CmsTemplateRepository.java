package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author xiboss
 * @create 2019-03-19 22:00
 */
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {
    //根据模板id和模板名称查询
    CmsTemplate findByTemplateFileIdAndTemplateName(String templateId, String templateName) ;
}
