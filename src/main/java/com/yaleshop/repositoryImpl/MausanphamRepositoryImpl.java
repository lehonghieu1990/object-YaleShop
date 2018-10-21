package com.yaleshop.repositoryImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaleshop.entity.Mausanpham;
import com.yaleshop.repository.MausanphamRepository;

@Repository("mausanphamRepository")
public class MausanphamRepositoryImpl implements MausanphamRepository{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Mausanpham> danhsachMausanpham() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Mausanpham> listMausanpham = (List<Mausanpham>) session.createQuery("from Mausanpham").getResultList(); 
		return listMausanpham;
	}
}
