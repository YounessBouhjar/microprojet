package myServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.articles;
import DAO.ArticleDAO;
import DAO.CategorieDAO;

/**
 * Servlet implementation class GenererTable
 */
@WebServlet("/GenererTable")
public class GenererTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenererTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String cat=(String) request.getParameter("categorie");
		
			CategorieDAO catDao=new CategorieDAO();
			ArticleDAO artDao=new ArticleDAO();
			
			List<articles> maListe=artDao.selectAllByCat(cat);
			HttpSession session=request.getSession();
		
		 
			List<String> taListe=catDao.selectAllCats();
			session.setAttribute("selected", cat);
			session.setAttribute("taListe", taListe);
			request.setAttribute("maListe", maListe);
			
			RequestDispatcher view=request.getRequestDispatcher("afficherCatalogue.jsp");
			view.forward(request, response);
			}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}