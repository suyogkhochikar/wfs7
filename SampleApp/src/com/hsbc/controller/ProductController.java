package com.hsbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.dao.IProductRepo;
import com.hsbc.dao.impl.ProductDAO;
import com.hsbc.exceptions.ProductNotFoundException;
import com.hsbc.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	IProductRepo repo=new ProductDAO();
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId=request.getParameter("productId");
		if(pId!=null) {
			int productId=Integer.parseInt(pId);
			Product product=null;
			try {
				product = repo.findProductById(productId);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(product!=null) {
				System.out.println(product);
			}
		}
		else
		{
			try {
				List<Product> products=repo.findProducts();
				if(products!=null) {
					request.setAttribute("products",products);
					request.getRequestDispatcher("./product.jsp").forward(request, response);
				}
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
