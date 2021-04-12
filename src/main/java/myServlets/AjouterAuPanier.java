package myServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.articles;
import modele.clients;
import modele.Panier;
import DAO.ArticleDAO;

/**
 * Servlet implementation class AjouterAuPanier
 */
@WebServlet("/AjouterAuPanier")
public class AjouterAuPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterAuPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		clients client=(clients)session.getAttribute("utilisateur");
		ArticleDAO articleDao=new ArticleDAO();
		
		articles article=articleDao.find(Integer.valueOf(request.getParameter("param")));
		int quantite=Integer.valueOf((request.getParameter("quantite")));
		System.out.println(request.getParameter("quantite"));
		System.out.println(article.getDesignation());
		client.ajouterAuPanier(new Panier(article,quantite));
		
		
		session.setAttribute("utilisateur", client);
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