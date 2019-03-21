package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiboss
 * @create 2019-03-19 22:07
 */
@Service
public class CmsTemplateService {

    @Autowired
    CmsTemplateRepository cmsTemplateRepository ;

    public QueryResponseResult findList(){
        //获取模板列表
        List<CmsTemplate> all = cmsTemplateRepository.findAll();
        //查询结果
        QueryResult queryResult = new QueryResult() ;
        queryResult.setList(all);          //数据列表
        queryResult.setTotal(all.size());   //数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult) ;
        return queryResponseResult ;
    }
}
