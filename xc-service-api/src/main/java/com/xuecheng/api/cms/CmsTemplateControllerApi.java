package com.xuecheng.api.cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author xiboss
 * @create 2019-03-19 22:04
 */
@Api(value="cms模板管理接口",description="cms模板管理接口，提供模板查询")
public interface CmsTemplateControllerApi {

    //模板列表查询
    @ApiOperation("查询模板列表")
    public QueryResponseResult findList() ;
}
