package com.kaishengit.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Page<T> {

	private int pageNo;
	
	private int totalPages;
	
	private int totalCounts;
	
	private List<T> items;
	
	private int pageSize;
	
	public Page(){}
	
	public Page(int pageSize,int totalCounts,String pageNo) {
		setPageSize(pageSize);
		setTotalCounts(totalCounts);
		setPageNo(pageNo);
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(String pageNo) {
		if(StringUtils.isNumeric(pageNo)) {
			int tempNo = Integer.parseInt(pageNo);
			if(tempNo < 1) {
				tempNo = 1;
			} else if(tempNo > getTotalPages() && getTotalPages() != 0) {
				tempNo = getTotalPages();
			}
			this.pageNo = tempNo;	
		} else {
			this.pageNo = 1;
		}
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalCounts() {
		return totalCounts;
	}
	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
		
		this.totalPages = totalCounts / getPageSize();
		if(totalCounts % getPageSize() != 0) {
			this.totalPages++;
		}
		
		
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getFrom() {
		return (getPageNo() - 1) * getPageSize();
	}
	
	/**
	   * 计算以当前页为中心的页面列表,如"首页,23,24,25,26,27,末页"
		 * @param count 需要计算的列表大小
	   * @parm pageNum 当前页号
		 * @return pageNo列表 
		 */
		public List<Integer> getSlider() {
//			int count = 6; //数字的数量
//			int halfSize = count / 2;
//			int totalPage = getTotalPages();
//	 
//			int startPageNo = Math.max(getPageNo() - halfSize, 1);
//			int endPageNo = Math.min(startPageNo + count - 1, totalPage);
//			
//			if(endPageNo - startPageNo < count - 1) {
//				startPageNo = Math.max(endPageNo - count, 1);
//			}
			
			int startPageNo = getPageNo() - 2;
			int endPageNo = getPageNo() + 2;
			
			if(startPageNo <= 0) {
				endPageNo -= startPageNo -1;
				startPageNo = 1;
			}
			
			if(endPageNo > getTotalPages()) {
				int temp = getTotalPages() - endPageNo;
				endPageNo = getTotalPages();
				startPageNo = startPageNo + temp;
				if(startPageNo < 1) {
					startPageNo = 1;
				}
			}
			
	 
			List<Integer> result = new ArrayList<Integer>();
			for (int i = startPageNo; i <= endPageNo; i++) {
				result.add(i);
			}
			return result;
		}
	
}

