package com.xuecheng.api.cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author xiboss
 * @create 2019-03-17 11:11
 */
@Api(value="cms站点管理接口",description="cms站点管理接口，提供站点查询")
public interface CmsSiteControllerApi {
    //站点查询
    @ApiOperation("查询站点列表")
    public QueryResponseResult findList() ;
}
