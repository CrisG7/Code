package com.sise.ssh.gh.action;

import java.util.List;















import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.sise.ssh.gh.dao.CategoryDao;
import com.sise.ssh.gh.dao.impl.CategoryDaoImpl;
import com.sise.ssh.gh.po.Category;
import com.sise.ssh.gh.service.CategoryService;

public class CategoryAction extends ActionSupport{
	@Resource private CategoryService categoryService;
	private Category category;
	private List<Category> categories;
	private CategoryDao categoryDao;
	private int id;
	public CategoryAction(){
		categoryDao=new CategoryDaoImpl();
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public String add(){                     //������������
		categoryService.addCategory(category);
		return SUCCESS;
	}
	public String update(){                 //������������
		category=categoryService.findById(id);
		return "update";
	}
	public String updated(){                 //����ҳ��	
		categoryService.updateCategory(category);
		return SUCCESS;
	}
	
	public String delete(){                  //ɾ������ӵ���������
		category=categoryService.findById(id);
		categoryService.removeCategory(category);
		return SUCCESS;
	}
	
	public String list(){                    //��ʾ��������
	categories=categoryService.findAllCategories();	
		return "list";
	}
}
