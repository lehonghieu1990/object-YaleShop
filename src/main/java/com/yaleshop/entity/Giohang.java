package com.yaleshop.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Giohang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int masanpham;
	private String tensanpham;
	private int mamau;
	private String tenmau;
	private int masize;
	private String tensize;
	private int soluong;
	private String giatien;
	public int getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public int getMamau() {
		return mamau;
	}
	public void setMamau(int mamau) {
		this.mamau = mamau;
	}
	public String getTenmau() {
		return tenmau;
	}
	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}
	public int getMasize() {
		return masize;
	}
	public void setMasize(int masize) {
		this.masize = masize;
	}
	public String getTensize() {
		return tensize;
	}
	public void setTensize(String tensize) {
		this.tensize = tensize;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGiatien() {
		return giatien;
	}
	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}
	
	public static void main(String[] args) {
		int [] array =     
			{ 49 ,  38 ,  65 ,  97 ,  76 ,  13 ,  27 };
		System.out.println("length : " + array.length);
		int  temp =  0 ;  
	    for  ( int  i =  0 ; i <array.length -  1 ; i ++) {
	    	System.out.println("i = " + i);
	        for  ( int  j =  0 ; j <array.length -  1  - i; j ++) {  
	        	System.out.println("j = " + j);
	            if  (array [j]> array [j +  1 ]) {  
	                temp = array [j];  
	                array [j] = array [j +  1 ];  
	                array [j +  1 ] = temp;  
	            }  
	        }  
	    }  
	    System.out.println (Arrays.toString (array) +  "bubbleSort" );  
	}
}
