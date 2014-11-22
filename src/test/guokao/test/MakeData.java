package test.guokao.test;

import org.springframework.beans.factory.annotation.Autowired;

import test.guokao.dao.JobInfoMapper;

public class MakeData {
	
	private JobInfoMapper jobInfoMapper;
	
	
	public JobInfoMapper getJobInfoMapper() {
		return jobInfoMapper;
	}

	@Autowired
	public void setJobInfoMapper(JobInfoMapper jobInfoMapper) {
		this.jobInfoMapper = jobInfoMapper;
	}


	
	public static void main(String[] args) {
		
		MakeData makeData = new MakeData();
		
		//makeData.getSpecialityInfo();
	}
	

}
