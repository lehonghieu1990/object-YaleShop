package com.yaleshop.repositoryImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaleshop.entity.Sizesanpham;
import com.yaleshop.repository.SizesanphamRepository;
import com.yaleshop.service.SizesanphamService;

@Repository("sizesanphamRepository")
public class SizesanphamRepositoryImpl implements SizesanphamRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Sizesanpham> danhsachSizesanpham() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Sizesanpham> listSizesanpham = (List<Sizesanpham>) session.createQuery("from Sizesanpham").getResultList(); 
		return listSizesanpham;
	}
}
