package test.guokao.test;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import test.guokao.model.JobInfo;
import test.guokao.model.Speciality;
import test.guokao.util.DBDaoUtils;
import test.guokao.util.DBUtil;
import test.guokao.util.Excel2DB;

public class Test {

	

	
	public static void readExcel(){
		
		List<JobInfo> jobInfoList = Excel2DB.readExcel(new File("D:\\2015年度职位信息.xls"));
		
		DBUtil dbUtil = new DBUtil();
		
		Date begin = new Date();
		for (int i = 0; i < jobInfoList.size(); i++) {
			
			
			//dbUtil.save(jobInfoList.get(i),i);
		}
		Date end = new Date();	
		
		System.out.println((end.getTime()-begin.getTime())/1000);
		
		
	}
	public static void getSpecialityInfo(){
		
		String getSpeciality = "select id , speciality from jobinfo ";
		
		List<JobInfo>  list =  DBDaoUtils.executeQuery(getSpeciality, JobInfo.class);
		
		int countSpeciality = 0;
		
		Map<Integer, String> id2specialitys =new HashMap<Integer,String>();
		
		for (int i = 0; i < list.size(); i++) {
			
			id2specialitys.put(list.get(i).getId(), list.get(i).getSpeciality());
			
		}
		
		/*Iterator iterator = id2specialitys.i*/
		
		Map<Integer,Set<String>> specialitysMap = new HashMap<Integer,Set<String>>();
		
		for(Map.Entry<Integer, String> entry:id2specialitys.entrySet()){
			
			int id = entry.getKey();
			
			String specialitys = entry.getValue();
			
			//System.out.println(entry.getKey()+"--->"+entry.getValue());
			
			Set<String> nameSet =  new HashSet<String>();
			
			for(String names: specialitys.split("、")){
				
				//System.out.println("names-=-=-="+names);
				
				nameSet.add(names);
				
				if(names.contains("；")){
					
					String[] tempNames = names.split("；") ;
					for(String tms :tempNames ){
						nameSet.add(tms);
					}
					
				}
				if(names.contains("/")){
					
					String[] tempNames = names.split("/") ;
					for(String tms :tempNames ){
						nameSet.add(tms);
					}
					
				}
				if(names.contains("、")){
					
					String[] tempNames = names.split("、") ;
					for(String tms :tempNames ){
						nameSet.add(tms);
					}
					
				}
				if(names.contains("，")){
					
					String[] tempNames = names.split("，") ;
					for(String tms :tempNames ){
						nameSet.add(tms);
					}
					
				}
				if(names.contains("；")){
					
					String[] tempNames = names.split("；") ;
					for(String tms :tempNames ){
						nameSet.add(tms);
					}
					
				}
			}
			
			

			/*if(specialitys.contains("；")){
				
				String[] tempNames = specialitys.split("；") ;
				for(String tms :tempNames ){
					nameList.add(tms);
				}
				
			}
			if(specialitys.contains("/")){
				
				String[] tempNames = specialitys.split("/") ;
				for(String tms :tempNames ){
					nameList.add(tms);
				}
				
			}
			if(specialitys.contains("、")){
				
				String[] tempNames = specialitys.split("、") ;
				for(String tms :tempNames ){
					nameList.add(tms);
				}
				
			}
			if(specialitys.contains("，")){
				
				String[] tempNames = specialitys.split("，") ;
				for(String tms :tempNames ){
					nameList.add(tms);
				}
				
			}
			*/
			specialitysMap.put(id, nameSet);
			
		}
		
		for(Map.Entry<Integer, Set<String>> entry:specialitysMap.entrySet()){
			
			int id = entry.getKey();
			
			Set<String> setNames = entry.getValue();
			
			for(String names: setNames){
				
				System.out.println(id+"--->"+names);
				
				Speciality speciality = new Speciality();
				
				speciality.setJobid(id);
				speciality.setSpecialityName(names);
				
				DBUtil dbUtil = new DBUtil();
				
				dbUtil.save(speciality);
				
				//System.out.println(names);
				countSpeciality++;
			}
			
			
		}
		
		
		
		
		System.out.println(countSpeciality);
	}
	public static void createDB(){
		
		//装载配置文件 
		//使用注解是这个会报错（ An AnnotationConfiguration instance is required to use）
		//AnnotationConfiguration cfg = new AnnotationConfiguration().configure(); 
		Configuration cfg = new Configuration().configure();
	
        SchemaExport export = new SchemaExport(cfg); 
        export.create(true, true);  
	}
	
	public static void getEverySpecialityName(){
		
		String name = "经济学、法学、哲学、文学、历史学、教育学、管理学、艺术学类专业";
		
		String [] a  = name.split("、");
		
		for(String aa :a ){
			System.out.println(aa);
		}
		
		
	}
	
	public static void main(String[] args) {

		//readExcel();
		//createDB();
		
		getSpecialityInfo();
		
		//getEverySpecialityName();
	}
}
