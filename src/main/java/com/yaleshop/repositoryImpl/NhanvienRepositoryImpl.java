package com.yaleshop.repositoryImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaleshop.entity.Nhanvien;
import com.yaleshop.repository.NhanvienRepository;

@Repository("nhanvienRepository")
public class NhanvienRepositoryImpl implements NhanvienRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean getNhanvien(String email, String matkhau) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Nhanvien nhanvien = (Nhanvien) session
					.createQuery("from Nhanvien where email = '" + email + "' and matkhau = '" + matkhau + "'")
					.getSingleResult();
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	public boolean saveNhanvien(Nhanvien nhanvien) {
			Session session = sessionFactory.getCurrentSession();
			int manhanvien = (Integer) session.save(nhanvien);
			if (manhanvien != 0) {
				return true;
			}
		return false;
	}


}
