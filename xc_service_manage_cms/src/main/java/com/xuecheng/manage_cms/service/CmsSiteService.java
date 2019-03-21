package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiboss
 * @create 2019-03-19 10:11
 */
@Service
public class CmsSiteService {

    @Autowired
    CmsSiteRepository cmsSiteRepository ;

    public QueryResponseResult findList(){
        //查询所有站点
        List<CmsSite> all = cmsSiteRepository.findAll();
        //查询结果
        QueryResult queryResult = new QueryResult() ;
        queryResult.setList(all);          //数据列表
        queryResult.setTotal(all.size());   //数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult) ;
        return queryResponseResult ;
    }
}
