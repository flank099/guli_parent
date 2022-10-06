package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author flank
 * @since 2022-10-04
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    // 多条件查询讲师，带分页
    @Override
    public void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery) {
        // 构建条件
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();

        //取出值，判断他们是否有值
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        //判断条件值是否为空，如果不为空，拼接条件
        //判断是否有传入教师名
        if(StringUtils.isNotEmpty(name)){
            // 模糊查询
            queryWrapper.like("name", name);
        }
        //判断是否传入教师头衔
        if (StringUtils.isNotEmpty(String.valueOf(level))){
            //构造条件
            queryWrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(begin)){
            //构造条件
            queryWrapper.ge("gmt_create",begin);//ge：大于等于
        }
        if (!StringUtils.isEmpty(begin)){
            //构造条件
            queryWrapper.le("gmt_modified",end);//le:小于等于
        }
        //带上门判断后的条件进行分页查询
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}