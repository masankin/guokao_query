package test.guokao.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.guokao.dao.JobInfoMapper;
import test.guokao.model.JobInfo;
import test.guokao.service.JobInfoServiceI;

@Service("jobInfoService")
public class JobInfoServiceImpl implements JobInfoServiceI {
	
	private JobInfoMapper jobInfoMapper;
	
	
	public JobInfoMapper getJobInfoMapper() {
		return jobInfoMapper;
	}

	@Autowired
	public void setJobInfoMapper(JobInfoMapper jobInfoMapper) {
		this.jobInfoMapper = jobInfoMapper;
	}


	public List<JobInfo> getJobInfoList(JobInfo record) {
		return jobInfoMapper.getJobInfoList(record);
	}

}
