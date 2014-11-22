package test.guokao.dao;

import java.util.List;

import test.guokao.model.JobInfo;


public interface JobInfoMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(JobInfo record);

    int insertSelective(JobInfo record);

    JobInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobInfo record);

    int updateByPrimaryKey(JobInfo record);
    
    List<JobInfo> getJobInfoList(JobInfo record);

	List<JobInfo> getSpecialityInfo();
}