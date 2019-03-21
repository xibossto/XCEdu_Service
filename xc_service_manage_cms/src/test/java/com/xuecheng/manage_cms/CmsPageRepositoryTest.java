package com.xuecheng.manage_cms;


import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author xiboss
 * @create 2019-03-12 11:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository ;

    @Test
    public void testFindAll(){
        List<CmsPage> all = cmsPageRepository.findAll();//查询全部
        System.out.println(all);
    }

    //spring MongoDB
    //分页查询
    @Test
    public void testFindPage(){
        int page = 0 ;   //从0开始
        int size  = 10 ;    //每页显示记录数
        Pageable pageable = PageRequest.of(page,size) ;
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }

    //添加
    @Test
    public void testInsert(){
        //定义实体类
        CmsPage cmsPage = new CmsPage() ;
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("c01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());

        //设置参数列表
        List<CmsPageParam> cmsPageParams = new ArrayList<>() ;
        CmsPageParam cmsPageParam = new CmsPageParam() ;
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam) ;

        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage) ;
        System.out.println(cmsPage);
    }

    //删除
    @Test
    public void testDelete(){
        cmsPageRepository.deleteById("5c873f2b0e944049c865d76d");
    }

    //修改
    @Test
    public void testUpdate(){
        //查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("5c8740c20e94404724ae4d6d");
        if(optional.isPresent()){
            CmsPage cmsPage = optional.get();
            //设置要修改的值
            cmsPage.setPageName("测试页面--修改");
            //修改
            cmsPageRepository.save(cmsPage) ;
        }
    }

    //根据页面名称查询
    @Test
    public void testfindByPageName(){
        CmsPage cmsPage = cmsPageRepository.findByPageName("测试页面--修改");
        System.out.println(cmsPage.getPageName());
    }

    //自定义条件查询
    @Test
    public void testFindAllByExample(){
        //分页参数
        int page = 0 ; //从0开始
        int size = 10 ;
        Pageable pageable = PageRequest.of(page,size) ;
        //条件值对象
        CmsPage cmsPage = new CmsPage() ;
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        cmsPage.setPageAliase("轮播");
        //条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        //设置模糊查询
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //定义Example
        Example<CmsPage> example = Example.of(cmsPage,exampleMatcher) ;
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        System.out.println(all);
    }
    
}
