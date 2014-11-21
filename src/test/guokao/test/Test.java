package test.guokao.test;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import test.guokao.model.JobInfo;
import test.guokao.util.DBUtil;
import test.guokao.util.Excel2DB;

public class Test {

	
	public static void main(String[] args) {

		readExcel();
		//createDB();
	}
	
	public static void readExcel(){
		
		List<JobInfo> jobInfoList = Excel2DB.readExcel(new File("D:\\2015年度职位信息.xls"));
		
		DBUtil dbUtil = new DBUtil();
		
//		Iterator<JobInfo> iterator = jobInfoList.iterator();
//		
//		while (iterator.hasNext()) {
//			
//			JobInfo jobInfo = (JobInfo) iterator.next();
//			
//			jobInfoDao.save(jobInfo);
//			
//		}
//		 
		Date begin = new Date();
		for (int i = 0; i < jobInfoList.size(); i++) {
			
			
			dbUtil.save(jobInfoList.get(i),i);
		}
		Date end = new Date();	
		
		System.out.println((end.getTime()-begin.getTime())/1000);
		
		
	}
	
	public static void createDB(){
		
		//装载配置文件 
		//使用注解是这个会报错（ An AnnotationConfiguration instance is required to use）
		//AnnotationConfiguration cfg = new AnnotationConfiguration().configure(); 
		Configuration cfg = new Configuration().configure();
	
        SchemaExport export = new SchemaExport(cfg); 
        export.create(true, true);  
	}
}
