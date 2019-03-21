package com.xuecheng.framework.domain.cms.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xiboss
 * @create 2019-03-19 10:14
 */
@Data
public class QuerySiteRequest {
    //接收站点查询和查询条件

    //站点ID
    @ApiModelProperty("站点id")
    private String siteId;
    //站点名称
    @ApiModelProperty("站点名称")
    private String siteName;
}
