package com.yaleshop.repositoryImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaleshop.entity.Sanpham;
import com.yaleshop.repository.SanphamRepository;

@Repository("sanphamRepository")
public class SanphamRepositoryImpl implements SanphamRepository{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Sanpham> danhsachsanpham() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Sanpham> listSanpham = (List<Sanpham>) session.createQuery("from Sanpham").getResultList(); 
		return listSanpham;
	}
	
/*	@Transactional
	public List<Sanpham> danhsachsanphamPhantrag(int positon, int spMax) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Sanpham> listSanpham = (List<Sanpham>) session.createQuery("from Sanpham").
				setFirstResult(spFirt).setMaxResults(spMax).getResultList(); 
		Criteria criteria = session.createCriteria(Sanpham.class);
	    criteria.setFirstResult(positon);
	    criteria.setMaxResults(spMax);
		return criteria.list();
	}*/
	
	@Transactional
	public Sanpham getSanpham(int id) {
		Session session = sessionFactory.getCurrentSession();
		Sanpham sanpham = session.get(Sanpham.class, id);
		return sanpham;
	}
	
	@Transactional
	public List<Sanpham> danhsachsanphamPhantrag(int positon, int spMax) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Sanpham> listSanpham = null;;
		if(positon < 0) {
			listSanpham = (List<Sanpham>) session.createQuery("from Sanpham").getResultList();
		}else {
		    listSanpham = (List<Sanpham>) session.createQuery("from Sanpham").setFirstResult(positon).setMaxResults(spMax).getResultList(); 
			
		}
		return listSanpham;
	}
	
	@Transactional
	public int saveSanpham(Sanpham sanpham) {
		Session session = sessionFactory.getCurrentSession();
		int save = (Integer) session.save(sanpham);
		return save;
	}

}
