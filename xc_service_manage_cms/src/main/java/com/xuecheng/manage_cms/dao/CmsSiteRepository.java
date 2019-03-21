package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author xiboss
 * @create 2019-03-19 10:01
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {

    //根据站点id查询
    CmsSite findBySiteId(String siteID) ;

    //根据站点名称查询
    CmsSite findBySiteName(String siteName) ;

    //根据站点创建时间查询
    CmsSite findBySiteCreateTime(String createTime) ;

}
