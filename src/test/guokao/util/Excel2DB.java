package test.guokao.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import test.guokao.model.JobInfo;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


@Entity
public class Excel2DB {
	
	public static List<JobInfo> readExcel(File file){
		List<JobInfo> list = new ArrayList<JobInfo>();

		Workbook wb = null;
		
		int count = 0;
		try {
			// 获得工作簿对象
			wb = Workbook.getWorkbook(file);

			if (null != file) {
				// 获取工作表对象
				Sheet[] sheets = wb.getSheets();
				
				if (null != sheets && sheets.length != 0) {
					// 遍历所有的工作表
					for (int i = 0; i < sheets.length; i++) {
						// 获得工作表行数
						int rows = sheets[i].getRows();
						//获得列数
						//int cols = sheets[i].getColumns();
						// 遍历行
						for (int j = 0; j < rows; j++) {
							
							JobInfo jobInfo = new JobInfo();
							
							//for (int k = 0; k < cols; k++) {
								// 获取当前行的所有单元格
								//Cell cells = sheets[i].getCell(k,j);
								Cell[] cells = sheets[i].getRow(j);
								
								jobInfo.setDeptcode(cells[0].getContents());
								jobInfo.setDeptname(cells[1].getContents());
								jobInfo.setEmployplace(cells[2].getContents());
								jobInfo.setInstitutional_properties(cells[3].getContents());
								jobInfo.setInstitutional_level(cells[4].getContents());
								jobInfo.setPosition_property(cells[5].getContents());
								jobInfo.setPosition_name(cells[6].getContents());
								jobInfo.setPosition_summary(cells[7].getContents());
								jobInfo.setPosition_number(cells[8].getContents());
								jobInfo.setTest_category(cells[9].getContents());
								jobInfo.setRecruit_number(cells[10].getContents());
								jobInfo.setSpeciality(cells[11].getContents());
								jobInfo.setDegree(cells[12].getContents());
								jobInfo.setEducation(cells[13].getContents());
								jobInfo.setPolitical_status(cells[14].getContents());
								jobInfo.setBasic_level(cells[15].getContents());
								jobInfo.setThree_hand_students(cells[16].getContents());
								jobInfo.setVolunteers_west(cells[17].getContents());
								jobInfo.setVillage_officials(cells[18].getContents());
								jobInfo.setSpecial_teacther(cells[19].getContents());
								jobInfo.setUnlimit(cells[20].getContents());
								jobInfo.setProfessional_exam(cells[21].getContents());
								jobInfo.setPercentage(cells[22].getContents());
								jobInfo.setOther(cells[23].getContents());
								jobInfo.setNotes(cells[24].getContents());
								jobInfo.setPosition(cells[25].getContents());
								jobInfo.setWebsite(cells[26].getContents());
								jobInfo.setTelephone1(cells[27].getContents());
								jobInfo.setTelephone2(cells[28].getContents());
								jobInfo.setTelephone3(cells[29].getContents());
								
								//System.out.println(jobInfo.toString());
								
								count++;
								list.add(jobInfo);
							//}
						}
					}
				}
			}
			
			System.out.println(count);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			wb.close();
		}
		return list;
		
	}

}
