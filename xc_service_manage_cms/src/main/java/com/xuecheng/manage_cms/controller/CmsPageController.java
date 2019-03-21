package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiboss
 * @create 2019-03-12 10:59
 */
@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    PageService pageService ;

    //查询页面列表
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest) {

       /* //静态测试数据
        QueryResult<CmsPage> queryResult = new QueryResult<>() ;
        List<CmsPage> list = new ArrayList<>() ;
        CmsPage cmsPage = new CmsPage() ;
        cmsPage.setPageName("测试页面");
        list.add(cmsPage) ;
        queryResult.setList(list);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult) ;*/
        return pageService.findList(page,size,queryPageRequest) ;
    }

    //添加页面
    @Override
    @PostMapping("/add")        //post提交
    public CmsPageResult addPage(@RequestBody CmsPage cmsPage) throws Exception {
        return pageService.addPage(cmsPage);
    }

    //通过id查询页面
    @Override
    @GetMapping("/get/{id}")
    public CmsPage findById(@PathVariable("id") String id) {
        return pageService.findById(id);
    }

    //修改页面
    @Override
    @PutMapping("/edit/{id}")
    public CmsPageResult edit(@PathVariable("id") String id,@RequestBody CmsPage cmsPage) {
        return pageService.editPage(id,cmsPage);
    }

    //删除页面
    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult delete(@PathVariable("id") String id) {
        return pageService.delete(id);
    }
}
