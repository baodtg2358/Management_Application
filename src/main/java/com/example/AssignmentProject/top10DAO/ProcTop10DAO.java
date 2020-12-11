package com.example.AssignmentProject.top10DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.AssignmentProject.dto.TopStaffs;
import com.example.AssignmentProject.entity.Staffs;



@Repository
public class ProcTop10DAO {

	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<TopStaffs> getTop10Staffs(){
		List<Object[]> res = em.createNamedStoredProcedureQuery("showTop10").getResultList();
		List<TopStaffs> list = new ArrayList<TopStaffs>();
		Iterator it = res.iterator();
		while(it.hasNext()) {
			Object[] line = (Object[]) it.next();
			TopStaffs topStaffs = new TopStaffs();
			topStaffs.setID(String.valueOf(line[0]));
			topStaffs.setFullname(String.valueOf(line[1]));
			topStaffs.setEmail(String.valueOf(line[2]));
			topStaffs.setDepart(String.valueOf(line[3]));
			topStaffs.setCount(Integer.valueOf(String.valueOf(line[4])));
			list.add(topStaffs);
		}
		return list;
	}
}
