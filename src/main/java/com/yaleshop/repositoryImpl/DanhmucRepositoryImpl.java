package com.yaleshop.repositoryImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaleshop.entity.Danhmucsanpham;
import com.yaleshop.repository.DanhmucRepository;

@Repository("danhmucRepository")
public class DanhmucRepositoryImpl implements DanhmucRepository{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Danhmucsanpham> danhsachdanhmuc() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Danhmucsanpham> listDanhmucsanpham = (List<Danhmucsanpham>) session.createQuery("from Danhmucsanpham").getResultList(); 
		return listDanhmucsanpham;
		
	}



}
