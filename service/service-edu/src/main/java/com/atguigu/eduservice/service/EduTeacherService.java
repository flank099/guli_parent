package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author flank
 * @since 2022-10-04
 */
public interface EduTeacherService extends IService<EduTeacher> {

    //多条件查询讲师带分页
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);
}