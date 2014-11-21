package test.guokao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import test.guokao.model.JobInfo;
import test.guokao.service.JobInfoServiceI;

@Controller
@RequestMapping("/jobInfoList")	
public class JobInfoController {
	 
	private JobInfoServiceI jobInfoServiceI;
	
	
	public JobInfoServiceI getJobInfoServiceI() {
		return jobInfoServiceI;
	}

	@Autowired
	public void setJobInfoServiceI(JobInfoServiceI jobInfoServiceI) {
		this.jobInfoServiceI = jobInfoServiceI;
	}

	@RequestMapping("/getList")
	@ResponseBody
	public JSON getJobInfoList(){
		
		System.out.println(12312312);
		JobInfo jobInfo = new JobInfo();
		
		List<JobInfo> jobInfolist= jobInfoServiceI.getJobInfoList(jobInfo);
		
		
		return (JSON) JSON.toJSON(jobInfolist);
	}

}
